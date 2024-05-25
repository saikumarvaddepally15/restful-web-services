package com.springboot.rest.webservices.restfulwebservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.webservices.restfulwebservices.post.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{

}
