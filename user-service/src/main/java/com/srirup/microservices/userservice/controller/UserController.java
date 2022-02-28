package com.srirup.microservices.userservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srirup.microservices.userservice.exceptionHandling.ResourceNotFoundException;
import com.srirup.microservices.userservice.model.User;
import com.srirup.microservices.userservice.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserByUserId(@PathVariable(value = "userId") Long userId) throws ResourceNotFoundException{
		User user = userService.getUserByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this user id ::" + userId));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userService.createUser(user);
	}
	

}
