package com.sdnetwork.service;

import com.sdnetwork.repo.PostDao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdnetwork.model.Post;
import com.sdnetwork.model.User;

@Service
public class PostService {
	
	private PostDao pd;
	
	@Autowired
	public PostService(PostDao pd) {
		super();
		this.pd = pd;
	}
	
	public PostService() {
		this(new PostDao());
	}

	public List<Post> getAll() {
		List<Post> allPosts = pd.findAll();
		allPosts.forEach(PostService::sanitize);
		return allPosts;
		
	}
	
	public List<Post> getById(int i){
		List<Post> userPosts = pd.findByUserId(i);
		userPosts.forEach(PostService::sanitize);
		return pd.findByUserId(i);
	}

	public void createNew(Post p) {
		pd.save(p);
	}
	
	public static Post sanitize(Post p) {
		Set<User> likedBy = p.getLikedBy();
		likedBy.forEach(user->{
		user.setPassword(null);
		user.setLikes(null);
		user.setEmail(null);
		user.setPfpLink(null);
		user.setPosts(null);
		});
		p.setLikedBy(likedBy);
		return p;
	}

	

}
