package com.edusol.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> addProduct(@RequestBody Product product) {

		return new ResponseEntity<String> (productservice.addProduct(product),HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Product>>  getProduct() {
		return new ResponseEntity<List<Product>> (productservice.getProduct(),HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<String> (productservice.updateProduct(product),HttpStatus.ACCEPTED);
	}

	@GetMapping("findN/{name}")
	public ResponseEntity<List<Product>> findProductByName(@PathVariable String name) {
		return new ResponseEntity<List<Product>> (productservice.findProductByName(name),HttpStatus.FOUND);
	}
     
	@GetMapping("/findT/{type}")
	public ResponseEntity<List<Product>> findProductByType(@PathVariable String type){
		return new ResponseEntity<List<Product>> (productservice.findProductByType(type),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteN/{name}")
	public ResponseEntity<String> deleteProductByName(@PathVariable String name)
	{
		return  productservice.deleteProductByName(name);
	}
	
	@DeleteMapping("/deleteT/{type}")
	 public ResponseEntity<String>  deleteProductByType(@PathVariable String type)
     {
    	 return productservice.deleteProductByType(type);
    	 
     }
	
	
}
