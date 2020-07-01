package br.com.bpcommerce.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bpcommerce.entity.Customer;
import br.com.bpcommerce.model.User;
import br.com.bpcommerce.repo.CustomerRepo;
import br.com.bpcommerce.utils.RegexValidation;

@RestController
@RequestMapping("/ecommerce")
public class UserController {

	static final String PATH = "user";

	@Autowired
	private CustomerRepo customRepo;

	@GetMapping(value = "/" + PATH + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Customer> allUsers() {
		return customRepo.findAll();
	}

	@GetMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String getUser(@PathVariable(name = "id") String id) {

		User allUser = new User();

		return allUser.toString();
	}

	@PutMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String updatetUser(@PathVariable(name = "id") String id) {

		User allUser = new User();

		return allUser.toString();
	}

	/*
	 * Register customer
	 * 
	 */
	@PostMapping(value = "/" + PATH + "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> registerUser(@RequestBody Customer userData) {

		JSONObject jsonObj = new JSONObject(userData);
		RegexValidation testString = new RegexValidation();

		if (testString.strValid(jsonObj)) {

			try {
				customRepo.save(userData);
				return new ResponseEntity<>(null, HttpStatus.CREATED);

			} catch (Exception e) {

				JSONObject jsonObjErr = new JSONObject();
				jsonObjErr.put("ERROR", "Your request cannot be completed at this time");
				return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.INTERNAL_SERVER_ERROR);

			}

		} else {

			JSONObject jsonObjErr = new JSONObject();
			jsonObjErr.put("REGISTER", "ERROR :: Check if the information is typed correctly or is empty");

			return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String deleteUser(@PathVariable(name = "id") String id) {

		User allUser = new User();

		return allUser.toString();
	}

	@PostMapping(value = "/" + PATH + "/login/{jwt}", produces = MediaType.APPLICATION_JSON_VALUE)
	private String loginUser(@PathVariable(name = "jwt") String id) {

		User allUser = new User();

		return allUser.toString();
	}

}
