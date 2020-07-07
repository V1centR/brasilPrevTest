package br.com.bpcommerce.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import br.com.bpcommerce.entity.Cart;

@Component
public interface CartMongoRepo extends MongoRepository<Cart, String> {

	
//	public Cart save(String data);
//	//public Optional<Cart> findById(String id);
//	void deleteById(String id);
//	public List<Cart> findAll();
	

}
