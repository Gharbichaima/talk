package com.chaima.talk.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chaima.talk.entities.Userc;


public interface UserRepository extends MongoRepository<Userc,String> {
	
	Userc findByEmail(String email);
	boolean existsByEmail(String email);
}
