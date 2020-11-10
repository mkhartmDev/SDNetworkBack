package com.sdnetwork.model;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="post_id")
	private int postId;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = User.class, cascade = CascadeType.REMOVE)
	@JoinColumn(name="poster_id",referencedColumnName="user_id")
	private User poster;
	
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
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "likes")
	private Set<User> likedBy;
	
	public Post() {
		super();
	}

	public Post(User poster, String postText, boolean isImagePost,
			String imageLink) {
		super();
		this.poster = poster;
		this.postText = postText;
		this.isImagePost = isImagePost;
		this.imageLink = imageLink;
	}

	public Post(User poster, String postText, int numberOfLikes, Timestamp dateTimePosted,
			boolean isImagePost, String imageLink, Set<User> likedBy) {
		super();
		this.poster = poster;
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

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
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
