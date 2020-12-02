package com.spring.spring.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/git")
public class GitController {

	@GetMapping
	public ResponseEntity<?> listRepositories (@RequestParam("linguagem") String linguagem,
											   @RequestParam("repositorios") String repositorios,
											   @RequestParam("seguidores") String seguidores){
		System.out.println(linguagem);
		System.out.println(repositorios);
		System.out.println(seguidores);
	
		RestTemplate restTemplate = new RestTemplate();
		return new ResponseEntity<>(restTemplate.getForEntity("https://api.github.com/search/users?q="+linguagem+"+repos:>"+repositorios+"+followers:>"+seguidores, Object.class),HttpStatus.OK);

	}
}
