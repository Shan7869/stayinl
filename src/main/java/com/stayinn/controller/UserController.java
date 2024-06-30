package com.stayinn.controller;

import org.springframework.web.bind.annotation.RestController;

import com.stayinn.entity.User;
import com.stayinn.repository.UserRepository;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("user")
	public User getUser(@RequestParam String userName){
		Optional<User> userOptional = userRepository.findByUsername(userName);
		if(userOptional.isPresent())
			return userOptional.get();
		return null;
	}
	
}
