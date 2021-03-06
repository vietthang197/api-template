package vn.neo.api.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author thanglv on 10/9/2020
 * @project NBD
 */
public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final TokenProvider tokenProvider;

	public JWTConfigurer(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	/**
	 * function config handle filter each request
	 * 
	 * @param http
	 */
	@Override
	public void configure(HttpSecurity http) {
		JWTFilter customFilter = new JWTFilter(tokenProvider);
		http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
