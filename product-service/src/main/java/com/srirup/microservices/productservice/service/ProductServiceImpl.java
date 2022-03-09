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
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getAllProductByCategory(String category) {
		return productRepository.findAllByCatagory(category);
	}

	@Override
	public Product getProductById(Long id) throws ResourceNotFoundException {
		//Optional<Product> product = productRepository.findById(id);
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for product id ::" + id));
	}

	@Override
	public List<Product> getAllProductsByName(String name) {
		return productRepository.findAllByProductName(name);
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Map<String, Boolean> deleteProduct(Long productId) throws ResourceNotFoundException {
		Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found for product id ::" + productId));
		Map<String, Boolean> response = new HashMap<>();
		productRepository.delete(product);
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
