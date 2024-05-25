package com.springboot.rest.webservices.restfulwebservices.user.jpa;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.webservices.restfulwebservices.post.Post;
import com.springboot.rest.webservices.restfulwebservices.user.User;
import com.springboot.rest.webservices.restfulwebservices.user.UserNotFoundException;

import jakarta.validation.Valid;
@RestController
public class UserJpaResource {
	private UserRepository userRepository;
	private PostRepository postRepository;
	public UserJpaResource(UserRepository userRepository,PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository=postRepository;
	}
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		List<User> users= userRepository.findAll();
		return users;
	}
	@GetMapping("/jpa/users/{id}")
	public User retrieveUserById(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(!user.equals(id) || user==null) {
			throw new UserNotFoundException("id"+user.get().getId());
		}
		return user.get();
	}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id){
		 userRepository.deleteById(id);
	}
	@PostMapping("/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User saveUser = userRepository.save(user);
		URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(saveUser.getId())
						.toUri();
		return ResponseEntity.created(locationUri).build();
	}
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getPostofUser(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(!user.equals(id) || user==null) {
			throw new UserNotFoundException("id"+user.get().getId());
		}
		return user.get().getPosts();
	}
	@PostMapping("/jpa/users/{id}/posts")
	public void createPostForUser(@PathVariable int id,@Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(id);
		if(!user.equals(id) || user==null) {
			throw new UserNotFoundException("id"+user.get().getId());
		}
		postRepository.save(post);
			
	}
}
