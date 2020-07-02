package br.com.bpcommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bpcommerce.entity.Category;
import br.com.bpcommerce.entity.Customer;
import br.com.bpcommerce.entity.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, String> {

	//@Query("SELECT u FROM Customer u")
    List<Category> findAll();
	
	//@Query("select p from Customer p WHERE p.id = :id")
    Category findById(Integer id);

    Category save(Category catData);
	
	void delete(Category userData);
	
}
