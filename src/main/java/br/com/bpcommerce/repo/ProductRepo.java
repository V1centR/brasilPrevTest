package br.com.bpcommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.bpcommerce.entity.Category;
import br.com.bpcommerce.entity.Product;

public interface ProductRepo extends CrudRepository<Product, String> {

    List<Product> findAll();
	
    Product findById(Integer id);

    Product save(Product prodData);
	
	void delete(Product prodData);

}
