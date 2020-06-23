package com.dev.blogger.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.blogger.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findById(Long userid);
}
