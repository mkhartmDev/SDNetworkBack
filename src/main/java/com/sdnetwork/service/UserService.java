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
		user = ud.save(user);
		if (user != null) {
			user.setPassword(null);
		}
		return user;
	}

	public User updateUser(User user) {
		User u = ud.findById(user.getUserId());
		user.setPassword(u.getPassword());
		ud.update(user);
		return user;
	}

	public User getUserByUsername(String username) {
		User user= ud.findByUsername(username);
		user.setPassword(null);
		return user;

	}
	
}
