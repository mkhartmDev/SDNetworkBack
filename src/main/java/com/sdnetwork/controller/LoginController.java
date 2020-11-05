package com.sdnetwork.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdnetwork.model.User;
import com.sdnetwork.service.LoginService;

@Controller
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	/**
	 * 
	 */

	public LoginService ss;
	
	public LoginController(LoginService ss) {
		super();
		this.ss = ss;
	}

	public LoginController() {
		this(new LoginService());
	}


	@PostMapping
	public @ResponseBody User login(@RequestParam("username") String username, @RequestParam("password") String password) {
	
		return ss.getUser(username, password);

	}
	

	
	 
	
	
	

}