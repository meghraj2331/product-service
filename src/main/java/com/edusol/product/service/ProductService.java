package com.edusol.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusol.product.model.Product;
import com.edusol.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepository;

	public String addProduct(Product product) {

		productrepository.save(product);
		return "Product Added Successfully" + (product.toString());
	}

	public List<Product> getProduct() {

		List<Product> product = productrepository.findAll();

		return product;
	}

	public String updateProduct(Product product) {

		product = productrepository.save(product);
		return "Record updated Successfully" + (product.toString());

	}

	public List<Product> findByName(String name) {
		
		return productrepository.findByName(name);
	}

	public List<Product> findByType(String type) {
		// TODO Auto-generated method stub
		return productrepository.findAllByType(type);
	}

	
}
