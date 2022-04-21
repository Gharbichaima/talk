package com.chaima.talk.repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.chaima.talk.entities.Role;
import com.chaima.talk.enums.RolNombre;
public interface RoleRepository extends MongoRepository<Role,String>{

	  Optional<Role> findByRolNombre(RolNombre rolNombre);
	    boolean existsByRolNombre(RolNombre rolNombre);
}
