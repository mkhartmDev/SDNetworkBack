package com.sdnetwork.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="username",nullable=false,unique=true)
	private String username;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	@Column(name="pfp_link")
	private String pfpLink;
	
	@OneToMany(mappedBy = "User", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Post> posts;
	
	@OneToMany(mappedBy = "User", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Like> likes;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String email, String firstName, String lastName, String pfpLink) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pfpLink = pfpLink;
	}
	
	public User(int userId, String username, String password, String email, String firstName, String lastName,
			String pfpLink) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pfpLink = pfpLink;
	}

	
	public User(int userId, String username, String password, String email, String firstName, String lastName,
			String pfpLink, Set<Post> posts, Set<Like> likes) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pfpLink = pfpLink;
		this.posts = posts;
		this.likes = likes;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPfpLink() {
		return pfpLink;
	}

	public void setPfpLink(String pfpLink) {
		this.pfpLink = pfpLink;
	}

}
