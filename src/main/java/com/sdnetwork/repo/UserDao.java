package com.sdnetwork.repo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
		try{sess.save(t);
		return t;
		} catch (Exception e) {
			return null;
		}
	}


	public User delete(Integer i) {

		Session sess = sessF.getCurrentSession();
//		Transaction tx = sess.beginTransaction();
		User u = sess.get(User.class, i);
		sess.delete(u);
		
		return u;
	}
	
	
	public User findByUsername(String username) {

		return sessF.getCurrentSession().createQuery("from User where username = '"+username+"'", User.class).list().get(0);

	}

}
