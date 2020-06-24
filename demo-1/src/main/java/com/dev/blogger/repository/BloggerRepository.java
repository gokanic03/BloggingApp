package com.dev.blogger.repository;

//import java.util.List;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.blogger.entities.Blog;
import com.dev.blogger.entities.User;

@Repository
public interface BloggerRepository extends CrudRepository<Blog, User>{
	 List<Blog> findByuserOrderByBlogidDesc(Optional<User> user);
}
