package com.sdnetwork.repo;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdnetwork.model.User;

@Repository
@Transactional
@DynamicUpdate
public class UserDao  {
	
	SessionFactory sessF;

	public UserDao() {
		super();
	}
	
	@Autowired
	public UserDao(SessionFactory sessF) {
		this.sessF = sessF;
	}


	public List<User> findAll() {

		return sessF.openSession()
				.createQuery("from User", User.class).list();
	}


	public User findById(Integer i) {
		return sessF.openSession()
				.createQuery("from User where user_id = "+ i +"", User.class).list().get(0);
	}


	public User update(User t) {
		Session sess = sessF.getCurrentSession();
		sess.merge(t);
		return t;
	}


	public User save(User t) {
		Session sess= sessF.openSession();
		try{sess.save(t);
		return t;
		} catch (Exception e) {
			return null;
		}
	}


	public User delete(Integer i) {

		Session sess = sessF.getCurrentSession();
		User u = sess.get(User.class, i);
		sess.delete(u);
		
		return u;
	}
	
	
	public User findByUsername(String username) {
		try {
		return sessF.getCurrentSession().createQuery("from User where username = '"+username+"'", User.class).list().get(0);
		} catch (Exception e) {
			return null;
		}
	}
	

}
