package br.com.bpcommerce.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bpcommerce.model.User;

@RestController
@RequestMapping("/ecommerce")
public class UserController {

	
	@GetMapping(value = "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private String allUsers() {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String getUser(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@PutMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String updatetUser(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
}
