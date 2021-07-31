package com.example.TestSpringBootApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestSpringBootApplication.model.User;
import com.example.TestSpringBootApplication.repository.UserRepository;

@ComponentScan({"com.example.TestSpringBootApplication.repository"})
@RestController
public class Controller {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path="/getUser/{name}")
	public List<User> getUser(@PathVariable String name) {
		return userRepository.findByName(name);
	}
	
	@GetMapping(path="/setUser/{name}/{emailId}")
	public String setUser(@PathVariable String name,@PathVariable String emailId) {
		User user=new User() ;
		user.setName(name);
		user.setEmailId(emailId);
		userRepository.save(user);
		return "Success";
	}
}
