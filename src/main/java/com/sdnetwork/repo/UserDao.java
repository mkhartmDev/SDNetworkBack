package com.sdnetwork.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sdnetwork.model.User;
import com.sdnetwork.util.HibernateUtil;

@Repository
public class UserDao implements DaoContract<User, Integer> {

	@Override
	public List<User> findAll() {
		List<User> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from user", User.class).list();
		return list;
	}

	@Override
	public User findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		User u = sess.get(User.class, i);
		return u;
	}

	@Override
	public User update(User u) {
		Session sess;
		Transaction tx=null;
		try {
		sess = HibernateUtil.getSessionFactory().openSession();
		tx = sess.beginTransaction();
		sess.update(u);
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return u;
	}

	@Override
	public User save(User u) {
		Session sess;
		Transaction tx=null;
		try {
		sess = HibernateUtil.getSessionFactory().openSession();
		tx = sess.beginTransaction();
		sess.persist(u);
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return u;
	}

	@Override
	public User delete(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		User u = sess.get(User.class, i);
		sess.delete(u);
		return u;
	}
	
	public User findByUsername(String username) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("from user where name = '"+username+"'", User.class).list().get(0);
	}
	
	
	

}
