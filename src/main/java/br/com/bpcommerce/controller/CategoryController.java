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

import br.com.bpcommerce.entity.Category;
import br.com.bpcommerce.repo.CategoryRepo;
import br.com.bpcommerce.utils.RegexValidation;

@RestController
@RequestMapping("/ecommerce")
public class CategoryController {

	static final String PATH = "category";

	@Autowired
	private CategoryRepo categoryRepo;

	/*
	 * List all Categories
	 */
	@GetMapping(value = "/" + PATH + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Category> allCategories() {
		return categoryRepo.findAll();
	}

	/*
	 * Get categories by id
	 */
	@GetMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Category getCategory(@PathVariable(name = "id") Integer id) {
		return categoryRepo.findById(id);
	}

	/*
	 * Update category
	 */
	// TODO apply regex validation here
	@PutMapping(value = "/" + PATH + "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Category updatetCategory(@PathVariable(name = "id") Integer id, @RequestBody Category ctgData) {

		ctgData.setId(id);
		return categoryRepo.save(ctgData);
	}

	/*
	 * Register category
	 */
	@PostMapping(value = "/" + PATH + "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> registerCategory(@RequestBody Category ctgData) {

		JSONObject jsonObj = new JSONObject(ctgData);

		RegexValidation testString = new RegexValidation();

		// prevent empty or invalid pattern string
		if (testString.categoryNameFilter(jsonObj)) {

			try {
				categoryRepo.save(ctgData);
				return new ResponseEntity<>(null, HttpStatus.CREATED);

			} catch (Exception e) {

				JSONObject jsonObjErr = new JSONObject();
				jsonObjErr.put("ERROR", "Your request cannot be completed at this time");
				return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {

			JSONObject jsonObjErr = new JSONObject();
			jsonObjErr.put("REGISTER",
					"ERROR :: Check if the information is typed correctly or is empty | ONLY LETTERS ALLOWED");

			return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * Delete category
	 */
	@DeleteMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private void deleteCategory(@PathVariable(name = "id") Integer id) {
		categoryRepo.delete(categoryRepo.findById(id));
	}

}
