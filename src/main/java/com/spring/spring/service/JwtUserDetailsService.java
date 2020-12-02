package com.spring.spring.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.spring.model.Users;
import com.spring.spring.repostirory.UsersRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepositorie;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Users> findUser = userRepositorie.findByEmail(email);

		if (findUser.get().getEmail() != null & findUser.get().getEmail().equals(email)) {
		
			return new User(findUser.get().getEmail(), findUser.get().getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
	}
	

}
