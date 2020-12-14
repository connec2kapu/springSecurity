package com.kp.security.authentication;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication extends UsernamePasswordAuthenticationToken {

	public CustomAuthentication(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		// TODO Auto-generated constructor stub
	}

	public CustomAuthentication(Object principal, Object credentials) {
		super(principal, credentials);
		// TODO Auto-generated constructor stub
	}

	

}
