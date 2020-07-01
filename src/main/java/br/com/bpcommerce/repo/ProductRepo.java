package br.com.bpcommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.bpcommerce.entity.Product;

public interface ProductRepo extends CrudRepository<Product, String> {

	@Query("SELECT u FROM Product u")
    List<Product> findAll();
	
	@Query("select p from Product p WHERE p.id = :id")
    Product findById(Integer id);
	
	//Product save();
}
