package com.chaima.talk.service;

import java.util.List;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaima.talk.entities.Publication;
import com.chaima.talk.entities.Userc;
import com.chaima.talk.repos.PublicationRepository;
import com.chaima.talk.repos.UserRepository;
@Service
public class UserServiceImpl implements UserService{

		@Autowired
		PublicationRepository  publicationRepository;
		@Autowired
		UserRepository userRepository;
		//@Autowired
	  //  private PasswordEncoder bCryptPasswordEncoder;
		@Override
		public Publication savePub(Publication p) {
			return publicationRepository.save(p);
		}

		@Override
		public Publication updatePub(Publication p) {
			return publicationRepository.save(p);
		}

		@Override
		public void deletePub(Publication p) {
			publicationRepository.delete(p);		
		}

	@Override
	public void deletePubById(Long id) {
		publicationRepository.deleteById(id);		
	}

	@Override
	public Publication getPublication(Long id) {
		return publicationRepository.findById(id).get();
		
	}

	@Override
	public List<Publication> getAllPublications() {
		return publicationRepository.findAll();
	}
//les methodes de user 
	@Override
	public Userc saveUser(Userc u) {
		return userRepository.save(u);
	}

	@Override
	public Userc getUser(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public boolean existsEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	/*@Override
	public List<Publication> trierPubDate() {
		return publicationRepository.tri;
	}*/


}
