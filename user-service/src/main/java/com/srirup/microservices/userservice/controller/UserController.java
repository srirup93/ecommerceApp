package com.srirup.microservices.userservice.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srirup.microservices.userservice.exceptionHandling.ResourceNotFoundException;
import com.srirup.microservices.userservice.model.User;
import com.srirup.microservices.userservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/testing")
	public String testApi() {
		return "Hello testing";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable(value = "userId") Long userId) throws ResourceNotFoundException{
		User user = userService.getUserByUserId(userId);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}
	
	@DeleteMapping("/users/{userId}")
	public Map<String, Boolean> deleteUserByUserId(@PathVariable(value = "userId") Long userId) throws ResourceNotFoundException {
		return userService.deleteUserByUserId(userId);
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "userId") Long userId, 
			@Valid @RequestBody User user) throws ResourceNotFoundException {
		User updatedUser = userService.updateUser(userId, user);
		return ResponseEntity.ok(updatedUser);
	}
}
