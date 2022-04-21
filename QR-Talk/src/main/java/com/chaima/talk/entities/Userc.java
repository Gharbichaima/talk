package com.chaima.talk.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Document(collection =  "user")
	public class Userc {

		@Id
	    private String id_user;
		@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	    private String email;
	    private String password;
	    private String pseudo;
	    private String image;
	    @DBRef
	    private Set<Role> roles = new HashSet<>();

		//private List<Publication> pub;
		public Userc( String email, String password,String pseudo ) {
			super();
			this.email = email;
			this.password = password;
			this.pseudo = pseudo;
		
		}
		public Userc( String email, String password ) {
			super();
			this.email = email;
			this.password = password;
		
		}
}
