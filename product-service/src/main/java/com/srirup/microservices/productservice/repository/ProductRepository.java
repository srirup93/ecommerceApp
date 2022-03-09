package com.srirup.microservices.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srirup.microservices.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findAllByCatagory(String catagory);
	public List<Product> findAllByProductName(String name);
}
