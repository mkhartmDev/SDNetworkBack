package com.sdnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdnetwork.model.User;
import com.sdnetwork.service.UserService;

@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	UserService us;

	@Autowired
	public UserController(UserService us) {
		super();
		this.us = us;
	}

	public UserController() {
		super();
	}
	
	@PostMapping("/new-user")
	public @ResponseBody User createUser(@RequestBody User user) {
		return us.createUser(user);
	}
	
	

}
