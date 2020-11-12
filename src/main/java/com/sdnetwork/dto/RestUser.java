package com.sdnetwork.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RestUser {

	private int userId;

	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String pfpLink;
	public RestUser(int userId, String username, String email, String firstName, String lastName, String pfpLink) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pfpLink = pfpLink;
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
	@Override
	public String toString() {
		return "RestUser [userId=" + userId + ", username=" + username + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", pfpLink=" + pfpLink + "]";
	}
	
	
}
