package com.chaima.talk.entities;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
//We use the annotation @Document to set the collection name that will be used by the model.
//If the collection doesn’t exist, MongoDB will create it.
@Data
@Document(collection="publication")
public class Publication {
	
	 @Id
	// @MongoId
	 private Long idPub;
	private String contenu;
	private Date date_pub;
	private String visibilter;
	//private User user;
	public Publication() {
		super();
	}
	
	public Publication(Long idPub, String contenu, String visibilter) {
		super();
		this.idPub = idPub;
		this.contenu = contenu;
		this.visibilter = visibilter;
	}

	public Publication(Long idPub, String contenu, Date date_pub, String visibilter) {
		super();
		this.idPub = idPub;
		this.contenu = contenu;
		this.date_pub = date_pub;
		this.visibilter = visibilter;
	}
	public Publication( String contenu, Date date_pub, String visibilter) {
		super();
		this.contenu = contenu;
		this.date_pub = date_pub;
		this.visibilter = visibilter;
	}
/*	public Long getIdPub() {
		return idPub;
	}
	public void setIdPub(Long idPub) {
		this.idPub = idPub;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate_pub() {
		return date_pub;
	}
	public void setDate_pub(Date date_pub) {
		this.date_pub = date_pub;
	}
	public String getVisibilter() {
		return visibilter;
	}
	public void setVisibilter(String visibilter) {
		this.visibilter = visibilter;
	}
*/
	@Override
	public String toString() {
		return "Publication [idPub=" + idPub + ", contenu=" + contenu + ", date_pub=" + date_pub + ", visibilter="
				+ visibilter +/* ", +id_user"+user+*/"]";
	}
	
	
}
