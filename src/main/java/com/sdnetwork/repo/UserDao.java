package com.sdnetwork.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sdnetwork.model.User;
import com.sdnetwork.util.HibernateUtil;

@Repository
@Transactional
public class UserDao implements DaoContract<User, Integer> {

	@Override
	public List<User> findAll() {

		return HibernateUtil.getSessionFactory().openSession()
				.createQuery("from ", User.class).list();
	}

	@Override
	public User findById(Integer i) {
		return HibernateUtil.getSessionFactory().openSession()
				.createQuery("from User where user_id = "+ i +"", User.class).list().get(0);
	}

	@Override
	public User update(User t) {
		HibernateUtil.getSessionFactory().openSession().
			update(t);
		return t;
	}

	@Override
	public User save(User t) {
		Session sess= HibernateUtil.getSessionFactory().openSession();
		sess.save(t);
		return t;
	}

	@Override
	public User delete(Integer i) {

		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		User u = sess.get(User.class, i);
		sess.delete(u);
		
		return u;
	}
	
	public User findByUsername(String username) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("from user where name = '"+username+"'", User.class).list().get(0);
	}

}
