package com.edusol.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.edusol.product.model.Product;

@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> 
{

 
	
	public List<Product>findProductByName(String name);

	public String deleteProductByName(String Name);

	public List<Product> findAllProductBytype(String type);

	public boolean existsByName(String name);

	public String deleteProductByType(String type);

	public boolean existsByType(String type);

}
