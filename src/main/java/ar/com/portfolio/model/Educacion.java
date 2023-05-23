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
@Entity
public class Educacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String descripcion;
	public String nombre;
	public String direccion;
	public Date fechaInicio;
	public Date fechaFin;
	@ManyToOne
	public Persona persona;

	public Educacion(long id, String descripcion, String nombre, String direccion, Date fechaInicio, Date fechaFin,
			Persona persona) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.persona = persona;
	}
	
	public Educacion() {
	}


	
}
