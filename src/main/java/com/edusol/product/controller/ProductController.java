package com.edusol.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.product.model.Product;
import com.edusol.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productservice;

	@PostMapping
	public String addProduct(@RequestBody Product product) {

		return productservice.addProduct(product);
	}

	@GetMapping
	public List<Product> getProduct() {
		return productservice.getProduct();
	}

	@PutMapping
	public String updateProduct(@RequestBody Product product) {
		return productservice.updateProduct(product);
	}

	@GetMapping("/{name}")
	public List<Product> findByName(@PathVariable String name) {
		return productservice.findByName(name);
	}
     
	@RequestMapping("/find/{type}")
	public List<Product>findByType(@PathVariable String type){
		return productservice.findByType(type);
	}
	
	
}
