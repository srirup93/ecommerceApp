package com.srirup.microservices.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srirup.microservices.userservice.exceptionHandling.ResourceNotFoundException;
import com.srirup.microservices.userservice.model.User;
import com.srirup.microservices.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUserByUserId(Long userId) throws ResourceNotFoundException{
		return userRepository.findById(userId);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
}
