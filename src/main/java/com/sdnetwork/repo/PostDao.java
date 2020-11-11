package com.sdnetwork.repo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sdnetwork.dto.RestPost;
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


	public List<RestPost> findAll() {
//		return sessF.openSession().createNativeQuery("select * from post", Post.class).list();
		Session sess = sessF.getCurrentSession();
		TypedQuery<RestPost> q = sess.createQuery(
				"select new com.sdnetwork.dto.RestPost("
				+ "u.username, u.firstName, u.lastName, p.postText, p.imageLink, p.dateTimePosted, p.numLikes, p.postId, p.isImagePost)"
				+ "from Post p join User u on "
				+ "p.posterId = u.userId",
				RestPost.class
				);
		List<RestPost> p = q.getResultList();
		return p;
		
//		TypedQuery<BookWithAuthorNames> q = em.createQuery(
//		        "SELECT new org.thoughts.on.java.model.BookWithAuthorNames(b.id, b.title, b.price, concat(a.firstName, ' ', a.lastName)) FROM Book b JOIN b.author a WHERE b.title LIKE :title",
//		        BookWithAuthorNames.class);
//		q.setParameter("title", "%Hibernate Tips%");
//		List<BookWithAuthorNames> books = q.getResultList();
//		 
//		for (BookWithAuthorNames b : books) {
//		    log.info(b);
//		}
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
		return sessF.getCurrentSession().createQuery("from Post where user_id = "+userId, Post.class).list();
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
