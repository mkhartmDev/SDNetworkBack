package com.sdnetwork.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Like {
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="poster_id",referencedColumnName="user_id")
	private int posterId;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="post_id",referencedColumnName="post_id")
	private int postId;
	
	public Like() {
		super();
	}

	public Like(int posterId, int postId) {
		super();
		this.posterId = posterId;
		this.postId = postId;
	}

	public int getPosterId() {
		return posterId;
	}

	public void setPosterId(int posterId) {
		this.posterId = posterId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

}
