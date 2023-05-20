package ar.com.portfolio.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Habilidad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre;
	private String descripcion;
	private String img;
	private long porcentaje;
	@ManyToOne
	private Persona persona;
	
	public Habilidad(long id, String nombre, String descripcion, String img, long porcentaje, Persona persona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.img = img;
		this.porcentaje = porcentaje;
		this.persona = persona;
	}
	

	
		
}
