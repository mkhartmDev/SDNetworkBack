package com.sdnetwork.service;

import com.sdnetwork.repo.PostDao;
import com.sdnetwork.repo.UserDao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdnetwork.dto.RestLike;
import com.sdnetwork.dto.RestPost;
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
	
	
	public void addLike(RestLike like) {
			
		pd.addLike(like);
	}
	public void removeLike(RestLike like) {
//		Post p = pd.findById(postId);
//		User u = ud.findById(userId);
//		Set<User> likedBy=p.getLikedBy();
//		likedBy.remove(u);
//		p.setLikedBy(likedBy);
//		p.setNumberOfLikes(p.getNumberOfLikes()-1);
//		pd.update(p);
//		Set<Post> userLikes = u.getLikes();
//		u.setLikes(userLikes);
//		userLikes.add(p);
//		ud.update(u);
	}

}
