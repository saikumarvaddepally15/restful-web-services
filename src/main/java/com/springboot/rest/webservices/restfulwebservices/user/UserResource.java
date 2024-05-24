package com.springboot.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	private UserDAOService service;

	public UserResource(UserDAOService service) {
		this.service = service;
	}
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		List<User> users= service.findAll();
		return users;
	}
	@GetMapping("/users/{id}")
	public User retrieveUserById(@PathVariable int id){
		User user = service.findOne(id);
		if(!user.equals(id) || user==null) {
			throw new UserNotFoundException("id"+id);
		}
		return user;
	}
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id){
		 service.deleteById(id);
	}
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User saveUser = service.saveUser(user);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saveUser.getId())
						.toUri();
		return ResponseEntity.created(locationUri).build();
	}
}
