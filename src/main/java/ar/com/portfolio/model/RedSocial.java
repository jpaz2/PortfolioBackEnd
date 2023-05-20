package ar.com.portfolio.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter	
//@Entity
public class RedSocial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombreRed;
	private String alias;
	private String direccion;
	@ManyToOne
	private Persona persona;
	
	public RedSocial(long id, String nombreRed, String alias, String direccion, Persona persona) {
		super();
		this.id = id;
		this.nombreRed = nombreRed;
		this.alias = alias;
		this.direccion = direccion;
		this.persona = persona;
	}
	
	


	
}
