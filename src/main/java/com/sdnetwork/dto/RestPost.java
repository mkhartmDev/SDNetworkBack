package com.sdnetwork.dto;

import com.sdnetwork.model.Post;
import com.sdnetwork.model.User;


public class RestPost {
	
	private Post post;
	
	private User user;
	
	private int numOfLikes;
	
	private boolean thisUserHasLiked;
	
	

	public RestPost() {
		super();
	}



	public RestPost(Post post, User user, int numOfLikes, boolean thisUserHasLiked) {
		super();
		this.post = post;
		this.user = user;
		this.numOfLikes = numOfLikes;
		this.thisUserHasLiked = thisUserHasLiked;
	}



	public Post getPost() {
		return post;
	}



	public void setPost(Post post) {
		this.post = post;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getNumOfLikes() {
		return numOfLikes;
	}



	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}



	public boolean isThisUserHasLiked() {
		return thisUserHasLiked;
	}



	public void setThisUserHasLiked(boolean thisUserHasLiked) {
		this.thisUserHasLiked = thisUserHasLiked;
	}



	@Override
	public String toString() {
		return "RestPost [post=" + post + ", user=" + user + ", numOfLikes=" + numOfLikes + ", thisUserHasLiked="
				+ thisUserHasLiked + "]";
	}
	
	
	
	

}
