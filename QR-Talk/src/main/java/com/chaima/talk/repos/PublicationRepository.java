package com.chaima.talk.repos;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chaima.talk.entities.Publication;

public interface PublicationRepository extends MongoRepository<Publication,Long>{


	//List<Publication> findByContenu (String contenu);
	//List<Publication> findByContenuContains(String contenu); 
}
