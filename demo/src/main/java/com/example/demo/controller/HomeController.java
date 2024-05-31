package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String home() {
		return "Hello Friends";
	}
	
	@PutMapping("/user")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String createUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "user created successfully";
	}
	
	@GetMapping("/user/all")
	@PreAuthorize("hasAuthority('USER')")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/user")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String updateUser(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "user updated successfully";
	}
	
	@DeleteMapping("/user/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteUser(@PathVariable(name = "id") Integer userId) {
		userRepository.deleteById(userId);
		return "user deleted successfully";
	}
	
}
