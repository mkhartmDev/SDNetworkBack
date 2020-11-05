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
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.update(p);
		return p;
	}

	@Override
	public Post save(Post p) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		sess.persist(p);
		return p;
	}

	@Override
	public Post delete(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Post p = sess.get(Post.class, i);
		sess.delete(p);
		return p;
	}


}
