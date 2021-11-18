package vn.neo.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import vn.neo.api.dto.ApiResponseDto;
import vn.neo.api.jwt.TokenProvider;
import vn.neo.api.services.vm.LoginVM;

@RestController
@RequestMapping("/")
public class UserJwtController {
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final TokenProvider tokenProvider;
	
	public UserJwtController(AuthenticationManagerBuilder authenticationManagerBuilder, TokenProvider tokenProvider) {
		this.authenticationManagerBuilder = authenticationManagerBuilder;
		this.tokenProvider = tokenProvider;
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<ApiResponseDto> login(@RequestBody @Valid LoginVM loginVM) throws JsonProcessingException {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginVM.getUsername(), loginVM.getPassword());
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.createToken(authentication);
		String bearerToken = "Bearer " + jwt;

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", bearerToken);	
		ApiResponseDto res = new ApiResponseDto(jwt);
		return new ResponseEntity<>(res, httpHeaders, HttpStatus.OK);
	}

}
