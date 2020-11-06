package com.sdnetwork.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sdnetwork.model.User;
import com.sdnetwork.repo.UserDao;

public class LoginService {
	
	public UserDao ud;
	
	public LoginService(UserDao ud) {
		this.ud = ud;
		
	}
	
	public LoginService() {
		this(new UserDao());
	}

	public User getUser(String username, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User u = new User();
		
		u = ud.findByUsername(username);
		System.out.println(encoder.matches(password,u.getPassword()));
		if(encoder.matches(password,u.getPassword())) {
			u.setPassword(null);
			return u;
		} else {
			return null;
		}
	}

}
