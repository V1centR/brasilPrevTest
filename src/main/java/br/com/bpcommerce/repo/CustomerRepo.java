package br.com.bpcommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bpcommerce.entity.Customer;
import br.com.bpcommerce.entity.Product;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, String> {

	@Query("SELECT u FROM Customer u")
    List<Customer> findAll();
	
	@Query("select p from Customer p WHERE p.id = :id")
	Customer findById(Integer id);

	Customer save(Customer userData);
	
//	Customer save(Customer data) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
