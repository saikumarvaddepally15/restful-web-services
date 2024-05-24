package com.springboot.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import org.hibernate.annotations.BatchSize;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private int id;
	@Size(min=2,message = "Minimum username length should be 2")
	private String username;
	@Past
	private LocalDate birthDate;
	
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
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthDate=" + birthDate + "]";
	}
	
	
}
