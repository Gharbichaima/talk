package com.chaima.talk.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="espace")
public class Espace {
	@Id
	private String id_es;
	private String nom;
	private String desc;
	
	
}
