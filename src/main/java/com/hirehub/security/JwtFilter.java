package com.hirehub.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("===== JWT FILTER EXECUTED =====");
		
		String authHeader = request.getHeader("Authorization");

		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
		    filterChain.doFilter(request, response);
		    return;
		}

		
		String token = authHeader.substring(7);

		
		String email = jwtUtil.extractEmail(token);
		
		System.out.println("Email from JWT: " + email);
		
		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails =
			        userDetailsService.loadUserByUsername(email);
			
			if (jwtUtil.validateToken(token, userDetails.getUsername())) {
				
				UsernamePasswordAuthenticationToken authentication =
				        new UsernamePasswordAuthenticationToken(
				                userDetails,
				                null,
				                userDetails.getAuthorities()
				        );
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
				System.out.println("JWT Token is VALID");

			}

		}
		
		filterChain.doFilter(request, response);
		
	}

}