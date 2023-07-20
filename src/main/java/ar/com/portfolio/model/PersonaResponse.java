package ar.com.portfolio.model;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PersonaResponse {

	/*
	export interface UserResponse {
	    message: string;
	    token: string;
	    userId: number;
	    role: Roles;
	}*/
	
	public enum Roles {
	    SUSCRIPTOR,
	    ADMIN;
	}
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public long idPersona;
	public String message;
	public String token;
	public Roles rol;
	public PersonaResponse(long id, long idPersona, String message, String token, Roles rol) {
		super();
		this.id = id;
		this.idPersona = idPersona;
		this.message = message;
		this.token = token;
		this.rol = rol;
	}
	public PersonaResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	

}
