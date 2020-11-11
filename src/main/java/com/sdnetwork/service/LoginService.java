package com.sdnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sdnetwork.model.User;
import com.sdnetwork.repo.UserDaoTest;

@Service
public class LoginService {
	
	public UserDaoTest ud;
	
	@Autowired
	public LoginService(UserDaoTest ud) {
		this.ud = ud;
		
	}
	
	public LoginService() {
		this(new UserDaoTest());
	}

	public User getUser(String username, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User u = new User();
		
		u = ud.findByUsername(username);
		if(encoder.matches(password,u.getPassword())) {
			u.setPassword(null);
			return u;
		} else {
			return null;
		}
	}

}
