package br.com.bpcommerce.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bpcommerce.model.User;

@RestController
@RequestMapping("/ecommerce")
public class UserController {

	static final String PATH = "user";
	
	@GetMapping(value = "/"+PATH+"/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private String allUsers() {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@GetMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String getUser(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@PutMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String updatetUser(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@PostMapping(value = "/"+PATH+"/register/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String registerUser(String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@DeleteMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String deleteUser(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		return allUser.toString();		
	}
	
	@PostMapping(value = "/"+PATH+"/login/{jwt}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String loginUser(@PathVariable(name = "jwt") String id) {
		
		User allUser = new User();
		
		return allUser.toString();		
	}
	
}
