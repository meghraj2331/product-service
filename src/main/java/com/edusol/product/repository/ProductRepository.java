package com.edusol.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{

 //String removeByName(String name);
	
	public List<Product>findByName(String name);

	public String deleteProductByName(String Name);

	public List<Product> findAllByType(String type);
	
}
