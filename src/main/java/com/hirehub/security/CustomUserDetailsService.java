package com.hirehub.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.hirehub.entity.User;
import com.hirehub.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmail(username)
		        .orElseThrow(() ->
		                new UsernameNotFoundException("User Not Found"));
		return new org.springframework.security.core.userdetails.User(
		        user.getEmail(),
		        user.getPassword(),
		        List.of(new SimpleGrantedAuthority(user.getRole().name()))
		);
	}
	
}