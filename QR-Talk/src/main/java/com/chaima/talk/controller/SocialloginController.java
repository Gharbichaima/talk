package com.chaima.talk.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaima.talk.dto.TokenDto;
import com.chaima.talk.entities.Role;
import com.chaima.talk.entities.Userc;
import com.chaima.talk.enums.RolNombre;
import com.chaima.talk.security.jwt.JwtProvider;
import com.chaima.talk.service.RoleService;
import com.chaima.talk.service.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Value;

@RestController
@RequestMapping("/oauth")
//http://localhost:8080/oauth
@CrossOrigin("http://localhost:4200")
public class SocialloginController {
	
	
	

    @Value("${google.id}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;



   /* @PostMapping("/google")
    public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getToken());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();
        Userc user = new Userc();
        if(userService.existsEmail(payload.getEmail()))
            user = userService.getUser(payload.getEmail());
        else
            user = saveUser(payload.getEmail());
        TokenDto tokenRes = login(user);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }*/

    //http://localhost:8080/api/google
 		@PostMapping("/google")
 		public ResponseEntity<?> LoginWithGoogle(@RequestBody TokenDto tokenDto) throws IOException{
 			NetHttpTransport transport =new NetHttpTransport();
 			JacksonFactory factory = JacksonFactory.getDefaultInstance();
 			GoogleIdTokenVerifier.Builder ver= 
 					new GoogleIdTokenVerifier.Builder(transport,factory)
 					.setAudience(Collections.singleton(googleClientId));
 			 GoogleIdToken googleIdToken = GoogleIdToken.parse(ver.getJsonFactory(),tokenDto.getToken());
 		    
 			    GoogleIdToken.Payload payload = googleIdToken.getPayload();
 			   Userc user = new Userc();
 		        if(userService.existsEmail(payload.getEmail()))
 		            user = userService.getUser(payload.getEmail());
 		        else
 		            user = saveUser(payload.getEmail());
 		        TokenDto tokenRes = login(user);
 			    return new ResponseEntity<>(tokenRes,HttpStatus.OK);
 		      
 		}
  /*  @PostMapping("/facebook")
    public ResponseEntity<TokenDto> facebook(@RequestBody TokenDto tokenDto) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenDto.getToken());
        final String [] fields = {"email","name", "picture"};
        User userf = facebook.fetchObject("me", User.class, fields);
        Userc user = new Userc();
        if(userService.existsEmail(user.getEmail()))
            user = userService.getUser(user.getEmail());
        else
            user = saveUser(user.getEmail());
        TokenDto tokenRes = login(user);
        return new ResponseEntity(tokenRes, HttpStatus.OK);
    }*/
    //http://localhost:8080/api/facebook
	@PostMapping("/facebook")
	public ResponseEntity<?> LoginWithFacebook(@RequestBody TokenDto tokenDto) throws IOException{
		Facebook facebook=new FacebookTemplate(tokenDto.getToken());
		 String [] data = {"email","name","picture"};
		//user c est une classe existe dans le spring
		User userf = facebook.fetchObject("me", User.class,data);
		 Userc user = new Userc();
	        if(userService.existsEmail(user.getEmail()))
	            user = userService.getUser(user.getEmail());
	        else
	            user = saveUser(user.getEmail());
	        TokenDto tokenRes = login(user);
	    return new ResponseEntity<>(tokenRes,HttpStatus.OK);

	}
    private TokenDto login(Userc user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), secretPsw)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(jwt);
        return tokenDto;
    }

    private Userc saveUser(String email){
        Userc user = new Userc(email, passwordEncoder.encode(secretPsw));
        Role roleUser = roleService.getByRolNombre(RolNombre.ROLE_USER).get();
        Set<Role> roles = new HashSet<>();
        roles.add(roleUser);
        user.setRoles(roles);
        return userService.saveUser(user);
    }
	
	 
	
}
