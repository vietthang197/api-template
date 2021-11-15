package vn.neo.api.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author thanglv on 5/24/2021
 * @project webapp
 */
@Component
public class TokenProvider {

    private Logger logger = LogManager.getLogger(TokenProvider.class);

    private static final String AUTHORITIES_KEY = "auth";

    private static final String USERID_KEY = "user_id";

    private static final String EMAIL_KEY = "email";

    private static final String USER_TYPE_KEY = "user_type";

    private static final String MOBILE_KEY = "mobile";

    private static final String FULLNAME_KEY = "full_name";

    private static final String DEPARTMENT_ID_KEY = "dp_id";

    private Key key;

    private long tokenValidityInMilliseconds;

    private String secret = "124f093edb90d9bd3c3bdf846a9069d653uieythnghgsle593d9d8bb39278fa48893745jlkjguoiwrh45cd398d9f351055c22a95448b8d13706ce7";

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.tokenValidityInMilliseconds = 8640000;
    }

    /**
     * function generate token from username
     *
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) throws JsonProcessingException {
        long now = System.currentTimeMillis();
        Users usersInfo = (Users) authentication.getPrincipal();
        String authorities = usersInfo.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        Date validity;
        if (usersInfo.getExpireTime() != null)
            validity = usersInfo.getExpireTime();
        else
            validity = new Date(now + this.tokenValidityInMilliseconds);
        if (logger.isDebugEnabled()) {
            logger.debug("Token expire at: {}", new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(validity));
        }

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .claim(USERID_KEY, usersInfo.getUserId())
                .claim(EMAIL_KEY, usersInfo.getEmail())
                .claim(USER_TYPE_KEY, usersInfo.getUserType())
                .claim(MOBILE_KEY, usersInfo.getMobile())
                .claim(FULLNAME_KEY, usersInfo.getFullName())
                .claim(DEPARTMENT_ID_KEY, usersInfo.getDpId())
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(validity)
                .compact();
    }

    /**
     * function get information from token
     *
     * @param token
     * @param path
     * @param method
     * @return
     */
    public Authentication getAuthentication(String token, String path, String method) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        Set<CustomGrantedAuthority> authorities = Arrays.stream(String.valueOf(claims.get(TokenProvider.AUTHORITIES_KEY)).split(",")).map(CustomGrantedAuthority::new).collect(Collectors.toSet());
        Users principal = new Users(claims, claims.getSubject(), "", authorities);

        if (claims.getSubject() == null) { // thang sua o day
            return new UsernamePasswordAuthenticationToken(null, token, authorities);
        }

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    /**
     * function validate token
     *
     * @param authToken
     * @return
     */
    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            logger.info("Invalid JWT token.");
        }
        return false;
    }
}
