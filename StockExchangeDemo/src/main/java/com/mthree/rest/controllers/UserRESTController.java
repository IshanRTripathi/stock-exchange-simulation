package com.mthree.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.models.User;
import com.mthree.services.UserService;

@RestController
@CrossOrigin("*")
public class UserRESTController {

	
	@Autowired
	private UserService userService;
	
	//Register User
		@PostMapping("/addCustomer")
		public String  register(@RequestBody User u) {
			
			userService.registerUser(u);
			
			return "Registration Success";
			
			
		}
		
//		//All user details
//		@GetMapping("/getUsers")
//		public List<User> getUser(){
//			return userService.loadUser();
//		}
//		
//		
//		//Deleting a user
//		@DeleteMapping("/deleteUser/{userId}")
//		public List<User> deleteUserById(@PathVariable("userId") int userId){
//			
//			userService.deleteUserById(userId);
//			return userService.loadUser();
//			
//			
//		}
//		
//		
//		//Details of particular User
//		@GetMapping("/getUser/{userId}")
//		public User getUserById(@PathVariable("userId") int userId){
//			
//			User u = null;
//			
//			
//			Optional<User> userFound = userService.getUserById(userId);
//			
//			if(userFound.isPresent())
//				u = userFound.get();
//			
//			return u;
//		}
//		
//		
//		
		
		
}
