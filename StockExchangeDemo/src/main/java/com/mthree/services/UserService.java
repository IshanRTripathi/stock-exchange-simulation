package com.mthree.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.models.User;
import com.mthree.repositories.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User u) {
		
		return userRepository.save(u);
	}

	public List<User> loadUser() {
	
	
	return userRepository.findAll();
}
	
	
public Optional<User> getUserById(int userId) {
		
		return userRepository.findById(userId);
}



public void deleteUserById(int userId ) {
userRepository.deleteById(userId);
}
}
