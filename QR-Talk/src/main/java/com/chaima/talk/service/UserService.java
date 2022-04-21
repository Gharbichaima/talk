package com.chaima.talk.service;

import java.util.List;

import com.chaima.talk.entities.Publication;
import com.chaima.talk.entities.Userc;

public interface UserService {

	Userc saveUser(Userc u);
	Userc getUser(String email);
	boolean existsEmail(String email);
	Publication savePub(Publication p);
	Publication updatePub(Publication p);
	void deletePub(Publication p);
	void deletePubById(Long id);
	Publication getPublication(Long id);
	List<Publication> getAllPublications();
	//List<Publication> trierPubDate();

}
