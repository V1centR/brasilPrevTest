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

import br.com.bpcommerce.entity.Brand;
import br.com.bpcommerce.repo.BrandRepo;
import br.com.bpcommerce.utils.RegexValidation;

@RestController
@RequestMapping("/ecommerce")
public class BrandController {

	static final String PATH = "brand";

	@Autowired
	private BrandRepo brandRepo;

	/*
	 * List all Products
	 */
	@GetMapping(value = "/" + PATH + "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Brand> allBrand() {
		return brandRepo.findAll();
	}

	/*
	 * Get Products by id
	 */
	@GetMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Brand getBrand(@PathVariable(name = "id") Integer id) {
		return brandRepo.findById(id);
	}

	/*
	 * Update Products
	 */
	// TODO apply regex validation here
	@PutMapping(value = "/" + PATH + "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Brand updatetBrand(@PathVariable(name = "id") Integer id, @RequestBody Brand prodData) {

		prodData.setId(id);
		return brandRepo.save(prodData);
	}

	/*
	 * Register Products
	 */
	@PostMapping(value = "/" + PATH + "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> registerBrand(@RequestBody Brand brandData) {

		JSONObject jsonObj = new JSONObject(brandData);

		RegexValidation testString = new RegexValidation();

		// prevent empty or invalid pattern string
		if (testString.nameFilter(jsonObj)) {

			try {

				brandRepo.save(brandData);

				return new ResponseEntity<>(null, HttpStatus.CREATED);

			} catch (Exception e) {

				JSONObject jsonObjErr = new JSONObject();
				jsonObjErr.put("ERROR", "Your request cannot be completed at this time");
				return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {

			JSONObject jsonObjErr = new JSONObject();
			jsonObjErr.put("REGISTER",
					"ERROR :: Check if the information is typed correctly or is empty | ONLY LETTERS CHARACTERS ALLOWED | MAX 25");

			return new ResponseEntity<>(jsonObjErr.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	/*
	 * Delete Products
	 */
	@DeleteMapping(value = "/" + PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	private void deleteBrand(@PathVariable(name = "id") Integer id) {
		brandRepo.delete(brandRepo.findById(id));
	}

}
