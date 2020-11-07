package com.sdnetwork.service;

import com.sdnetwork.repo.PostDao;
import com.sdnetwork.repo.UserDao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdnetwork.model.*;

@Service
public class LikeService {
	private PostDao pd;
	private UserDao ud;
	
	
	
	@Autowired
	public LikeService(PostDao pd, UserDao ud) {
		super();
		this.pd = pd;
		this.ud = ud;
	}
	
	public LikeService() {
		this(new PostDao(),new UserDao());
	}
	
	
	public void addLike(int userId,int postId) {
		Post p = pd.findById(postId);
		User u = ud.findById(userId);
		Set<User> likedBy=p.getLikedBy();
		likedBy.add(u);
		p.setLikedBy(likedBy);
		pd.update(p);
//		Set<Post> userLikes = u.getLikes();
//		u.setLikes(userLikes);
//		userLikes.add(p);
//		ud.update(u);
		
	}
	public void removeLike(int userId,int postId) {
		Post p = pd.findById(postId);
		User u = ud.findById(userId);
		Set<User> likedBy=p.getLikedBy();
		likedBy.remove(u);
		p.setLikedBy(likedBy);
		pd.update(p);
//		Set<Post> userLikes = u.getLikes();
//		u.setLikes(userLikes);
//		userLikes.add(p);
//		ud.update(u);
	}

}
