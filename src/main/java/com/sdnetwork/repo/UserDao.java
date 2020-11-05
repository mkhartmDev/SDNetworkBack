package com.sdnetwork.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdnetwork.model.User;

@Repository
@Transactional
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
		sessF.getCurrentSession().
			update(t);
		return t;
	}


	public User save(User t) {
		Session sess= sessF.openSession();
		sess.save(t);
		return t;
	}


	public User delete(Integer i) {

		Session sess = sessF.getCurrentSession();
//		Transaction tx = sess.beginTransaction();
		User u = sess.get(User.class, i);
		sess.delete(u);
		
		return u;
	}
	
	public User findByUsername(String username) {
		Session sess = sessF.openSession();
		return sess.createQuery("from user where name = '"+username+"'", User.class).list().get(0);
	}

}
