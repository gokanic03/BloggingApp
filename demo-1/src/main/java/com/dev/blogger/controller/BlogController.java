package com.dev.blogger.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.blogger.entities.Blog;
import com.dev.blogger.entities.User;
import com.dev.blogger.services.BlogServices;
import com.dev.blogger.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/v1")
public class BlogController {
    
    @Autowired
    private BlogServices blogservices;    

    @PostMapping(path = "/blogpost/{userid}", consumes = "application/json", produces = "application/json")
    @JsonView(Views.Public.class)
    public Optional<Blog> Create (@PathVariable Long userid,  @RequestBody Blog blog){
    	return blogservices.CreateBlog(userid, blog);
    }

    @GetMapping(path = "/blog/{userid}", produces = "application/json")
    @JsonView(Views.Public.class)
    public ResponseEntity<?> findBlog(@PathVariable Long userid) {
	   return ResponseEntity.ok(blogservices.FindBlogByUser(userid));
    }
   
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public User Create (@RequestBody User user){
    	return blogservices.AddUser(user);
    }
   
    @GetMapping(path = "/user/{userid}", produces = "application/json")
    @JsonView(Views.Internal.class)
    public ResponseEntity<?> findUser(@PathVariable Long userid) {
    	return ResponseEntity.ok(blogservices.FindUserDetails(userid));
    }
}