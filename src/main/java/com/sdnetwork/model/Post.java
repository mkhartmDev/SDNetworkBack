package com.sdnetwork.model;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postId;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="poster_id",referencedColumnName="UserId")
	private int posterId;
	
	@Column(name="post_text")
	private String postText;
	
	@Column(name="number_of_likes")
	private int numberOfLikes;
	
	@Column(name="date_time_posted", nullable=false)
	private Timestamp dateTimePosted;
	
	@Column(name="is_image_post", nullable=false)
	private boolean isImagePost;
	
	@Column(name="image_link")
	private String imageLink;
	
	@OneToMany(mappedBy = "Post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<User> likedBy;
	
	public Post() {
		super();
	}

	public Post(int posterId, String postText, boolean isImagePost,
			String imageLink) {
		super();
		this.posterId = posterId;
		this.postText = postText;
		this.isImagePost = isImagePost;
		this.imageLink = imageLink;
	}

	public Post(int postId, int posterId, String postText, int numberOfLikes, Timestamp dateTimePosted,
			boolean isImagePost, String imageLink, Set<User> likedBy) {
		super();
		this.postId = postId;
		this.posterId = posterId;
		this.postText = postText;
		this.numberOfLikes = numberOfLikes;
		this.dateTimePosted = dateTimePosted;
		this.isImagePost = isImagePost;
		this.imageLink = imageLink;
		this.likedBy = likedBy;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getPosterId() {
		return posterId;
	}

	public void setPosterId(int posterId) {
		this.posterId = posterId;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public Timestamp getDateTimePosted() {
		return dateTimePosted;
	}

	public void setDateTimePosted(Timestamp dateTimePosted) {
		this.dateTimePosted = dateTimePosted;
	}

	public boolean isImagePost() {
		return isImagePost;
	}

	public void setImagePost(boolean isImagePost) {
		this.isImagePost = isImagePost;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Set<User> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(Set<User> likedBy) {
		this.likedBy = likedBy;
	}


}
