package com.sdnetwork.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sdnetwork.model.Post;
import com.sdnetwork.util.HibernateUtil;

@Repository
public class PostDao implements DaoContract<Post,Integer>{
	
	@Override
	public List<Post> findAll() {
		List<Post> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from post", Post.class).list();
		return list;
	}

	@Override
	public Post findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Post p = sess.get(Post.class, i);
		return p;
	}

	@Override
	public Post update(Post p) {
		Session sess;
		Transaction tx=null;
		try {
		sess = HibernateUtil.getSessionFactory().openSession();
		tx = sess.beginTransaction();
		sess.update(p);
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return p;
	}

	@Override
	public Post save(Post p) {
		Session sess;
		Transaction tx=null;
		try {
		sess = HibernateUtil.getSessionFactory().openSession();
		tx = sess.beginTransaction();
		sess.persist(p);
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return p;
	}

	@Override
	public Post delete(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Post p = sess.get(Post.class, i);
		sess.delete(p);
		return p;
	}
	
	public List<Post> findByUsername(String username) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		return sess.createQuery("from user where name = '"+username+"'", Post.class).list();
	}

}
