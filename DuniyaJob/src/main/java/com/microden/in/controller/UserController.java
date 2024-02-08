package com.microden.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microden.in.dto.Registration;
import com.microden.in.entity.UserEntity;
import com.microden.in.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
	
@Autowired
private UserService userservice;

@PostMapping("/register")

public UserEntity registeruser(@RequestBody Registration user){
	
	return userservice.registeruser(user);
}
}
