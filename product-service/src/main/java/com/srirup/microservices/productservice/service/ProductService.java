package com.srirup.microservices.productservice.service;
import java.util.List;
import java.util.Map;

import com.srirup.microservices.productservice.entity.Product;
import com.srirup.microservices.productservice.exceptionHandling.ResourceNotFoundException;
public interface ProductService {
	public List<Product> getAllProduct();
    public List<Product> getAllProductByCategory(String category);
    public Product getProductById(Long id) throws ResourceNotFoundException;
    public List<Product> getAllProductsByName(String name);
    public Product addProduct(Product product);
    public Map<String, Boolean> deleteProduct(Long productId) throws ResourceNotFoundException;
}
