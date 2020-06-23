package com.dev.blogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.blogger.repository.Blog;
import com.dev.blogger.repository.BloggerRepository;
import com.dev.blogger.repository.User;
import com.dev.blogger.repository.UserRepository;

@RestController
@RequestMapping("/v1")
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
    
    @Autowired
    private BloggerRepository blogRepository;
    
    @Autowired 
    private UserRepository userRepository;
    
    //User user1 = new User();
    
   // @Bean
	//public User Demo() {    
	//    user1.setUId("1");
	 //   user1.setName("Nirav");
	  //  return userRepository.save(user1);
	//}

    @PostMapping(path = "/blogpost", consumes = "application/json", produces = "application/json")
    public Blog Create (@RequestBody Blog blog){
    	LOGGER.info("userId = {}", blog.getBlogId());
        return blogRepository.save(blog);  
   }

   @GetMapping(path = "/blog/{userid}", produces = "application/json")
   public ResponseEntity<?> findByuserid(@PathVariable Long userid) {
	   LOGGER.info("Blogger ID = {} ",userid);
       return ResponseEntity.ok(blogRepository.findByuseridOrderByBlogidDesc(userid));
   }
   
   @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
   public User Create (@RequestBody User user){
   	LOGGER.info("userId = {}", user.getUId());
       return userRepository.save(user);
  }
   
  @GetMapping(path = "/user/{userId}", produces = "application/json")
  public ResponseEntity<?> findByUID(@PathVariable Long userId) {
	  LOGGER.info("Blogger Name/username/ID = {} ",userId);
      return ResponseEntity.ok(userRepository.findByUID(userId));
  }
}