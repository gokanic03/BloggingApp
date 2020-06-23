package com.dev.blogger.repository;

//import java.util.List;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.blogger.entities.Blog;

@Repository
public interface BloggerRepository extends CrudRepository<Blog, Long>{
	 List<Blog> findByuseridOrderByBlogidDesc(Long userid);
}
