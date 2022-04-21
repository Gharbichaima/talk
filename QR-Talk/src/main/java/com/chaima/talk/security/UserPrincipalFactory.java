package com.chaima.talk.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chaima.talk.entities.Userc;

import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipalFactory {

    public static UserPrincipale build (Userc user){
        List<GrantedAuthority> authorities =
                user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new UserPrincipale(user.getEmail(), user.getPassword(), authorities);
    }

	
}
