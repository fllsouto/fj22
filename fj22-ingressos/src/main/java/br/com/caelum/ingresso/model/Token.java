package br.com.caelum.ingresso.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.validator.constraints.Email;

@Entity
public class Token {

	@Id
	private String uuid;
	
	@Email
	private String email;
	
	/**
	* @deprecated hibernate only
	*/
	public Token() {
	}
	
	public Token(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@PrePersist
	public void prePersist() {
		this.uuid = UUID.randomUUID().toString();
	}
}
