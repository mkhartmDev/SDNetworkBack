package com.sdnetwork.repo;

import com.sdnetwork.model.User;

public class Driver {

	public static void main(String[] args) {
		
		UserDao ud = new UserDao();
		User u = new User("cats", "q", "f", "d", "p", "q");
		
		System.out.println(ud.save(u));
//		System.out.println(ud.findAll());
//		System.out.println(ud.findById(1));
//		u.setLastName("iaf");
//		System.out.println(ud.update(u));
//		System.out.println(ud.delete(u.getUserId()));

	}

}
