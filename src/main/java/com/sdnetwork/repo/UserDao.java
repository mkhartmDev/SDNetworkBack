package com.sdnetwork.repo;

import java.util.List;

import com.sdnetwork.model.User;
import com.sdnetwork.util.HibernateUtil;

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
		HibernateUtil.getSessionFactory().openSession().save(t);
		return t;
	}

	@Override
	public User delete(Integer i) {
		HibernateUtil.getSessionFactory().openSession().delete("from User where user_id = " + i + "");
		return null;
	}

}
