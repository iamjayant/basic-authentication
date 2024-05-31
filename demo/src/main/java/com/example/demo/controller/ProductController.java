package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@RequestMapping("/welcome")
	public String welcomeProduct() {
		return "welcome to the product";
	}
}
