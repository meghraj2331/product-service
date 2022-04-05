package com.edusol.product.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.edusol.product.model.Product;
import com.edusol.product.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	private ProductRepository productrepository;

	public String addProduct(Product product) {

		productrepository.save(product);
		logger.info("Product Added Successfully\n"+product.toString());
		return "Product Added Successfully\n" + (product.toString());
	}

	public List<Product> getProduct() {

		List<Product> product = productrepository.findAll();
        logger.info(product.toString());
		return product;
	}

	public String updateProduct(Product product) {

		product = productrepository.save(product);
		logger.info("Product updated Successfully\n" + (product.toString()));
		return "Product updated Successfully\n" + (product.toString());

	}

	public List<Product> findProductByName(String name) {

		List<Product> product= productrepository.findProductByName(name);
		logger.info(product.toString());
		return product;
	}

	public List<Product> findProductByType(String type) {
		// TODO Auto-generated method stub
		List<Product> product= productrepository.findAllProductBytype(type);
		logger.info(product.toString());
		return product;
	}

	public ResponseEntity<String> deleteProductByName(String name) {
		// TODO Auto-generated method stub
		try 
		{
			productrepository.existsByName(name);
		   String product= productrepository.deleteProductByName(name);
			logger.info("Product Deleted Succcessfully\n"+product.toString());
			return new ResponseEntity<String> ("Product Deleted Succcessfully",HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			logger.error("Product Not Found");
			return new ResponseEntity<String> ("Product Not Found",HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<String> deleteProductByType(String type) {
		// TODO Auto-generated method stub
		String messege = "";
		try {
			productrepository.existsByType(type);
			String product = productrepository.deleteProductByType(type);

			logger.info("Product Deleted Succcessfully\n" + type.toString());
			messege = "Product deleted successfully";

			return new ResponseEntity<String>(messege, HttpStatus.OK);
		}

		catch (Exception e) {
			messege = "Product Not Found";
			logger.error("Product Not Found");
			return new ResponseEntity<String>(messege, HttpStatus.NOT_FOUND);
		}

	}

}
