package com.springboot.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.rest.webservices.restfulwebservices.post.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Entity (name="user_details")
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Size(min=2,message = "Minimum username length should be 2")
	private String username;
	@Past
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;
	protected User() {
		
	}
	public User(int id, String username, LocalDate birthDate) {
		super();
		this.id = id;
		this.username = username;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthDate=" + birthDate + ", posts=" + posts + "]";
	}
	
	
	
}
