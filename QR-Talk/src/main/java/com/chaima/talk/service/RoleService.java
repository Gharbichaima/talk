package com.chaima.talk.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaima.talk.entities.Role;
import com.chaima.talk.enums.RolNombre;
import com.chaima.talk.repos.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getRoles(){
        return roleRepository.findAll();
    }
    public Optional<Role> getByRolNombre(RolNombre rolNombre){
        return roleRepository.findByRolNombre(rolNombre);
    }

    public boolean existsRolNombre(RolNombre rolNombre){
        return roleRepository.existsByRolNombre(rolNombre);
    }

    public void save(Role rol){
        roleRepository.save(rol);
    }
    
   
}