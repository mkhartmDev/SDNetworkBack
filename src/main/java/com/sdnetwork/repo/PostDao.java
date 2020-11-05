package com.sdnetwork.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdnetwork.model.Post;

@Repository
@Transactional
public class PostDao{
	
	SessionFactory sessF;

	public PostDao() {
		super();
	}
	
	@Autowired
	public PostDao(SessionFactory sess) {
		super();
		this.sessF = sess;
	}


	public List<Post> findAll() {
		List<Post> list = sessF.openSession()
				.createNativeQuery("select * from post", Post.class).list();
		return list;
	}


	public Post findById(Integer i) {
		Session sess = sessF.openSession();
		Post p = sess.get(Post.class, i);
		return p;
	}


	public Post update(Post p) {
		Session sess = sessF.openSession();
		sess.update(p);
		return p;
	}


	public Post save(Post p) {
		Session sess = sessF.openSession();
		sess.persist(p);
		return p;
	}


	public Post delete(Integer i) {
		Session sess = sessF.openSession();
		Post p = sess.get(Post.class, i);
		sess.delete(p);
		return p;
	}


}
