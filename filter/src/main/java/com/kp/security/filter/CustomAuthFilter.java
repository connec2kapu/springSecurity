package com.kp.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.kp.security.authentication.CustomAuthentication;

@Component
public class CustomAuthFilter implements Filter {

	
	@Autowired
	AuthenticationManager authManager;
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String userName = req.getHeader("authorization");
		
		CustomAuthentication auth = new CustomAuthentication(userName, null);
		
		try {
			Authentication authentication = authManager.authenticate(auth);
			
			if (null != authentication && authentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
				chain.doFilter(request, response);
			} else {
				resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
		}catch (Exception e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		
		
		

	}

}
