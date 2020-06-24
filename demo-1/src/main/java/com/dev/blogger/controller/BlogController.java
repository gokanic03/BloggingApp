package com.dev.blogger.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.dev.blogger.repository.BloggerRepository;
import com.dev.blogger.repository.UserRepository;
import com.dev.blogger.views.Views;
import com.dev.blogger.views.Views.Internal;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/v1")
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
    
    @Autowired
    private BloggerRepository blogRepository;
    
    @Autowired 
    private UserRepository userRepository;    

    @PostMapping(path = "/blogpost/{userid}", consumes = "application/json", produces = "application/json")
    @JsonView(Views.Public.class)
    public Optional<Blog> Create (@PathVariable Long userid,  @RequestBody Blog blog){
    	return userRepository.findById(userid).map( user -> {
  	   	blog.setUser(user);
    	LOGGER.info("userId = {}", blog.getBlogid());
        return blogRepository.save(blog);  
    });
   }

   @GetMapping(path = "/blog/{userid}", produces = "application/json")
   @JsonView(Views.Public.class)
   public ResponseEntity<?> findByuserid(@PathVariable Long userid) {
	   LOGGER.info("Blogger ID = {} ",userid);
	   Optional<User> user = userRepository.findById(userid);
	   user.get();
       return ResponseEntity.ok(blogRepository.findByuserOrderByBlogidDesc(user));
   }
   
   @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
   public User Create (@RequestBody User user){
   	LOGGER.info("userId = {}", user.getUid());
       return userRepository.save(user);
  }
   
  @GetMapping(path = "/user/{userId}", produces = "application/json")
  @JsonView(Views.Internal.class)
  public ResponseEntity<?> findByUID(@PathVariable Long userId) {
	  //LOGGER.info("Blogger Name/username/ID = {} ",userId);
      return ResponseEntity.ok(userRepository.findById(userId));
  }
}