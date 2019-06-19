package com.tts.Radiate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.Radiate.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	public User findByFirstName(String firstName);
	public User findByLastName(String lastName);
	
}
