package com.srirup.microservices.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srirup.microservices.productservice.entity.Product;
import com.srirup.microservices.productservice.service.ProductService;

@RestController()
@RequestMapping("/api/v1/product")
public class ProductController {
	
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProduct();
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(params = "category")
	public ResponseEntity<List<Product>> getAllProductsByCatagory(@RequestParam ("category") String category) {
		List<Product> products = productService.getAllProductByCategory(category);
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(params = "name")
	public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam ("name") String name) {
		List<Product> products = productService.getAllProductByCategory(name);
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable ("id") Long id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.ok().body(product);
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product result = productService.addProduct(product);
		return ResponseEntity.ok().body(result);
	}
}
