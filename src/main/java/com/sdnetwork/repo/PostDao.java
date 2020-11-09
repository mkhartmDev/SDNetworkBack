package com.sdnetwork.repo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdnetwork.model.*;


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
		return sessF.openSession().createNativeQuery("select * from post", Post.class).list();
	}


	public Post findById(Integer i) {
		Session sess = sessF.getCurrentSession();
		Post p = sess.get(Post.class, i);
		return p;
	}


	public Post update(Post p) {
		Session sess = sessF.getCurrentSession();
		sess.update(p);
		return p;
	}


	public Post save(Post p) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		p.setDateTimePosted(now);
		Session sess = sessF.getCurrentSession();
		sess.persist(p);
		return p;
	}


	public Post delete(Integer i) {
		Session sess = sessF.getCurrentSession();
		Post p = sess.get(Post.class, i);
		sess.delete(p);
		return p;
	}
	
	public List<Post> findByUserId(int userId) {
		try {
		return sessF.getCurrentSession().createQuery("from Post where user_id = '"+userId+"'", Post.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addLike(int id) {
		Session sess = sessF.getCurrentSession();
		sess.createNativeQuery("update post set likes=likes+1 where post_id="+Integer.toString(id));
	}


}
