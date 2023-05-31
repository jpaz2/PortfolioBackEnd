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
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String apellido;
	public String nombre;
	public String direccion;
	public Date fechaNacimiento;
	public String email;
	public String telefono;

	@OneToMany(mappedBy = "persona")
	@JsonIgnoreProperties(value="persona")
	public List<Educacion> estudios;
	@OneToMany(mappedBy = "persona")
	@JsonIgnoreProperties(value="persona")
	public List<Habilidad> habilidades;
	@OneToMany(mappedBy = "persona")
	@JsonIgnoreProperties(value="persona")
	public List<Proyecto> proyectos;
	@OneToMany(mappedBy = "persona")
	@JsonIgnoreProperties(value="persona")
	public List<Experiencia> experiencias;
	@OneToMany(mappedBy = "persona")
	@JsonIgnoreProperties(value="persona")
	public List<RedSocial> redesSociales;
	public Persona(long id, String apellido, String nombre, String direccion, Date fechaNacimiento, String email,
			String telefono, List<Educacion> estudios, List<Habilidad> habilidades, List<Proyecto> proyectos,
			List<Experiencia> experiencias, List<RedSocial> redesSociales) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
		this.estudios = estudios;
		this.habilidades = habilidades;
		this.proyectos = proyectos;
		this.experiencias = experiencias;
		this.redesSociales = redesSociales;
	}
	public Persona() {
		
	} 
	
	

	
	

}
