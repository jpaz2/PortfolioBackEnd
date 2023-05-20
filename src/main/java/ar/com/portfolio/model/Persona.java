package ar.com.portfolio.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String apellido;
	private String nombre;
	private String direccion;
	private Date fechaNacimiento;
	private String email;
	private String telefono;
	/*@OneToMany(mappedBy = "persona")
	private List<Educacion> estudios;
	@OneToMany(mappedBy = "persona")
	private List<Habilidad> habilidades;
	@OneToMany(mappedBy = "persona")
	private List<Proyecto> proyectos;
	@OneToMany(mappedBy = "persona")
	private List<Experiencia> experiencias;
	@OneToMany(mappedBy = "persona")
	private List<RedSocial> redesSociales; 
	
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
	} */
	public Persona(long id, String apellido, String nombre, String direccion, Date fechaNacimiento, String email,
			String telefono) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.telefono = telefono;
	}
	
	


	
	

}
