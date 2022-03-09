package com.srirup.microservices.userservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srirup.microservices.userservice.exceptionHandling.ResourceNotFoundException;
import com.srirup.microservices.userservice.model.User;
import com.srirup.microservices.userservice.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers() {
		List<User> users = null;
		try {
			users =  userRepository.findAll();
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		return users;
	}
	
	public User getUserByUserId(Long userId) throws ResourceNotFoundException {
		Optional<User> result = null;
		User user = null;
		try {
			result = userRepository.findById(userId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		if(result.isPresent()) {
			user = result.get();
		} else {
			throw new ResourceNotFoundException("User not found for this user id ::" + userId);
		}
		return user;
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public Map<String, Boolean> deleteUserByUserId(Long userId) throws ResourceNotFoundException {
		Optional<User> result = null;
		try {
			result = userRepository.findById(userId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new ResourceNotFoundException("User not found for this user id ::" + userId);
		}
		if(result.isPresent()) {
			userRepository.deleteById(userId);
			Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
		} else {
			throw new ResourceNotFoundException("User not found for this user id ::" + userId);
		}
	}

	@Override
	public User updateUser(Long userId, User user) throws ResourceNotFoundException {
		
		Optional<User> result = null;
		try {
			result = userRepository.findById(userId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		if(result.isPresent()) {
			User userDetails = result.get();
			userDetails.setUserName(user.getUserName());
			userDetails.setFirstName(user.getFirstName());
			userDetails.setLastName(user.getLastName());
			userDetails.setEmail(user.getEmail());
			User updatedUser = userRepository.save(userDetails);
			return updatedUser;
		} else {
			throw new ResourceNotFoundException("User not found for this user id ::" + userId);
		}
	}
}
