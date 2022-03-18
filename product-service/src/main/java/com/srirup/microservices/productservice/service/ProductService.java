package com.srirup.microservices.productservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srirup.microservices.productservice.entity.Product;
import com.srirup.microservices.productservice.exceptionHandling.ResourceNotFoundException;
import com.srirup.microservices.productservice.repository.ProductRepository;

@Service
public class ProductService{
	
	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}


	public List<Product> getAllProduct() {
		List<Product> products =  productRepository.findAll();
		if (products.isEmpty()) {
			throw new ResourceNotFoundException("Product Not found");
		}
		return products;
	}

	
	public List<Product> getAllProductByCategory(String category) {
		List<Product> products = productRepository.findAllByCatagory(category);
		if (products.isEmpty()) {
			throw new ResourceNotFoundException("Product Not found");
		}
		return products;
	}


	public Product getProductById(Long id) {
		//Optional<Product> product = productRepository.findById(id);
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for product id ::" + id));
	}

	
	public List<Product> getAllProductsByName(String name) {
		List<Product> products = productRepository.findAllByProductName(name);
		if (products.isEmpty()) {
			throw new ResourceNotFoundException("Product Not found");
		}
		return products;
	}

	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	
	public Map<String, Boolean> deleteProduct(Long productId) {
		Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found for product id ::" + productId));
		Map<String, Boolean> response = new HashMap<>();
		productRepository.delete(product);
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
