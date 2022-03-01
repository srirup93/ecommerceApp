package com.srirup.microservices.userservice.service;

import java.util.List;
import java.util.Map;

import com.srirup.microservices.userservice.exceptionHandling.ResourceNotFoundException;
import com.srirup.microservices.userservice.model.User;

public interface IUserService {
	public List<User> getAllUsers();
	public User getUserByUserId(Long userId) throws ResourceNotFoundException;
	public User createUser(User user);
	public Map<String, Boolean> deleteUserByUserId(Long userId) throws ResourceNotFoundException;
	public User updateUser(Long userId, User user) throws ResourceNotFoundException;
	
}
