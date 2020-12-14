package com.kp.security.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.kp.security.authentication.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Value("${key}")
	private String key;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		if (authentication.getName().equals(key)) {
			return new CustomAuthentication(key, null, null);
		} else {
			throw new BadCredentialsException("Error: Bad Creadentials");
		}

		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthentication.class.equals(authentication);
	}
	
	public CustomAuthenticationProvider(){
		
	}
	 

}
