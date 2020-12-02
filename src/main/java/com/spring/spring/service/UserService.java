package com.spring.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.spring.model.Users;
import com.spring.spring.repostirory.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository userPrepository;
	
	@Autowired
	PasswordEncoder passwroEncoder;
	
	public Users createUser(Users user) {
		
		Users newUser = new Users();
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(this.passwroEncoder.encode(user.getPassword()));
		
		return this.userPrepository.save(newUser);
	}
	
}
