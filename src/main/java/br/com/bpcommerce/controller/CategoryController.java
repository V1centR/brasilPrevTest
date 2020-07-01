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
public class CategoryController {

	static final String PATH = "category";
	
	@GetMapping(value = "/"+PATH+"/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private String allCategory() {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@GetMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String getCategory(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@PutMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String updatetCategory(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		
		return allUser.toString();		
	}
	
	@PostMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String registerCategory(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		return allUser.toString();		
	}
	
	@DeleteMapping(value = "/"+PATH+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String deleteCategory(@PathVariable(name = "id") String id) {
		
		User allUser = new User();
		
		return allUser.toString();		
	}
	
}
