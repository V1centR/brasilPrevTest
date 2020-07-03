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

import br.com.bpcommerce.entity.Product;
import br.com.bpcommerce.repo.ProductRepo;
import br.com.bpcommerce.utils.RegexValidation;

@RestController
@RequestMapping("/ecommerce")
public class ProductController {

	static final String PATH = "product";

	@Autowired
	private ProductRepo prodRepo;

	/*
	 * List all Products
	 */
	@GetMapping(value = "/" + PATH + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Product> allProd() {
		return prodRepo.findAll();
	}

	/*
	 * Get Products by id
	 */
	@GetMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Product getProd(@PathVariable(name = "id") Integer id) {
		return prodRepo.findById(id);
	}

	/*
	 * Update Products
	 */
	// TODO apply regex validation here
	@PutMapping(value = "/" + PATH + "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Product updatetProd(@PathVariable(name = "id") Integer id, @RequestBody Product prodData) {

		prodData.setId(id);
		return prodRepo.save(prodData);
	}

	/*
	 * Register Products
	 */
	@PostMapping(value = "/" + PATH + "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> registerProd(@RequestBody Product prodData) {

		JSONObject jsonObj = new JSONObject(prodData);

		RegexValidation testString = new RegexValidation();

		// prevent empty or invalid pattern string
		if (testString.productNameFilter(jsonObj)) {

			try {

				prodRepo.save(prodData);

				return new ResponseEntity<>(null, HttpStatus.CREATED);

			} catch (Exception e) {

				JSONObject jsonObjErr = new JSONObject();
				jsonObjErr.put("ERROR", "Your request cannot be completed at this time");
				return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {

			JSONObject jsonObjErr = new JSONObject();
			jsonObjErr.put("REGISTER",
					"ERROR :: Check if the information is typed correctly or is empty | ONLY ALPHANUMERIC CHARACTERS ALLOWED");

			return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * Delete Products
	 */
	@DeleteMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private void deleteProd(@PathVariable(name = "id") Integer id) {
		prodRepo.delete(prodRepo.findById(id));
	}

}
