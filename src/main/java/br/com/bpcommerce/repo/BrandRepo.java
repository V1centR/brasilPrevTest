package br.com.bpcommerce.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.bpcommerce.entity.Brand;

public interface BrandRepo extends CrudRepository<Brand, String> {

	List<Brand> findAll();

	Brand findById(Integer id);

	Brand save(Brand prodData);

	void delete(Brand prodData);

}
