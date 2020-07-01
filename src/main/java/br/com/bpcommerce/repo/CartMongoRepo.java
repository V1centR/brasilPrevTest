package br.com.bpcommerce.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.bpcommerce.entity.Cart;

public interface CartMongoRepo extends MongoRepository<Cart, String> {
	
	public Cart save(String data);
	public Optional<Cart> findById(String id);
	void deleteById(String id);
	public List<Cart> findAll();
	

}
