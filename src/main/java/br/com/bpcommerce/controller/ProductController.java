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
public class ProductController {

	static final String PATH = "product";
	
	@GetMapping(value = "/"+PATH+"/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private String allProd() {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@GetMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String getProd(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@PostMapping(value = "/"+PATH+"/register", produces = MediaType.APPLICATION_JSON_VALUE)
	private String registerProd(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@PutMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String updatetProd(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@DeleteMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String deleteProd(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		return allUser.toString();		
	}
	
}
