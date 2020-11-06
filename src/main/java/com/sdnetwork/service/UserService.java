package com.sdnetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sdnetwork.model.User;
import com.sdnetwork.repo.UserDao;

@Service
public class UserService {
	
	UserDao ud;

	@Autowired
	public UserService(UserDao ud) {
		super();
		this.ud = ud;
	}

	public UserService() {
		super();
	}

	public User createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		return ud.save(user);
	}
	
	
	

}
