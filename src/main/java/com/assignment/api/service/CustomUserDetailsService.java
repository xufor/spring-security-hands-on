package com.assignment.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment.api.entity.User;
import com.assignment.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username + " is trying to authenticate!");
		User user = userRepository.findById(Integer.parseInt(username)).get();
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getId()),
				user.getPassword(), new ArrayList<>());
	}

}
