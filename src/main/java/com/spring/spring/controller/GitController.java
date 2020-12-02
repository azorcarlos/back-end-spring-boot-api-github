package com.spring.spring.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/git")
public class GitController {

	@GetMapping("/list-reposotories")
	public ResponseEntity<?> listRepositories (){
	
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("https://api.github.com/search/users?q=php+repos:>4+followers:>500", Object.class);

	}
}
