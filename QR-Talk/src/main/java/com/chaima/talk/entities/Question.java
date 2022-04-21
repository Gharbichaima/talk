package com.chaima.talk.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="question")
public class Question /*extends Publication */{
	//@Id
	private String idQues;
	private String contenu_q;
	
	//pour test
	/*@Override
    public String toString() {
        return "{fieldA: " + getIdPub() + ", fieldB: " + idQues + "}";
    }*/
}
