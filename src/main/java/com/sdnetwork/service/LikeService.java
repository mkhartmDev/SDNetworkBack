package com.sdnetwork.service;

import com.sdnetwork.repo.PostDao;
import com.sdnetwork.repo.UserDaoTest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdnetwork.dto.RestLike;
import com.sdnetwork.dto.RestPost;
import com.sdnetwork.model.*;

@Service
public class LikeService {
	private PostDao pd;
	private UserDaoTest ud;
	
	
	
	@Autowired
	public LikeService(PostDao pd, UserDaoTest ud) {
		super();
		this.pd = pd;
		this.ud = ud;
	}
	
	public LikeService() {
		this(new PostDao(),new UserDaoTest());
	}
	
	
	public void addLike(RestLike like) {	
		pd.addLike(like);
	}
	public void removeLike(RestLike like) {
		pd.removeLike(like);
	}

}
