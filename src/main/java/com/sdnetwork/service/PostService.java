package com.sdnetwork.service;

import com.sdnetwork.repo.PostDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdnetwork.dto.RestPost;
import com.sdnetwork.model.Post;

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

	public List<RestPost> getAll() {
		List<RestPost> allPosts = pd.findAll();
		return allPosts;
		
	}
	
	public List<RestPost> getById(int i){
		return pd.findByUserId(i);
	}

	public Post createNew(Post p) {
		return pd.save(p);
	}




	

}
