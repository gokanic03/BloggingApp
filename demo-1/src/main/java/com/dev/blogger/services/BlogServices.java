package com.dev.blogger.services;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.blogger.entities.Blog;
import com.dev.blogger.entities.User;
import com.dev.blogger.repository.BloggerRepository;
import com.dev.blogger.repository.UserRepository;

@Service
public class BlogServices {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogServices.class);
    
    @Autowired
    private BloggerRepository blogRepository;
    
    @Autowired 
    private UserRepository userRepository;  

    public BlogServices(){}
    
    //Add blog post
    public Optional<Blog> CreateBlog(Long userid , Blog blog){
    	return userRepository.findById(userid).map( user -> {
      	   	blog.setUser(user);
        	//LOGGER.info("userId = {}", blog.getBlogid());
            return blogRepository.save(blog); 
        });
    } 
    
    //Find blog post by Userid
    public List<Blog> FindBlogByUser(Long userid){
    	LOGGER.info("Blogger ID = {} ",userid);
 	   	Optional<User> user = userRepository.findById(userid);
 	   	user.get();
        return blogRepository.findByuserOrderByBlogidDesc(user);
    }
    
    //Add user
    public User AddUser(User user) {
    	LOGGER.info("userId = {}", user.getUid());
        return userRepository.save(user);
    }
    
    //Find User details by user id
    public Optional<User> FindUserDetails(Long userid) {
    	return userRepository.findById(userid);
    }
}
