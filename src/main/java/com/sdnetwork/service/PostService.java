package com.sdnetwork.service;

import com.sdnetwork.repo.PostDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<Post> getAll() {
		return pd.findAll();
		
	}
	
	public List<Post> getById(int i){
		return pd.findByUserId(i);
	}

	public void createNew(Post p) {
		pd.save(p);
	}

	

}
