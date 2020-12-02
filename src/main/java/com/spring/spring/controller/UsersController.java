package com.spring.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring.model.Users;
import com.spring.spring.repostirory.UsersRepository;
import com.spring.spring.service.UserService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Users> create(@RequestBody Users user){
		

		return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Users>findtAll(){
		return this.userRepository.findAll();
	}

}
