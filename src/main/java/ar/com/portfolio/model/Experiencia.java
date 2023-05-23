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
public class Experiencia {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		public long id;
		public String nombre;
		public String descripcion;
		public String cargo;
		public Date fechaInicio;
		public Date fechaFin;
		@ManyToOne
		public Persona persona;
		
		public Experiencia(long id, String nombre, String descripcion, String cargo, Date fechaInicio, Date fechaFin,
				Persona persona) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.cargo = cargo;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
			this.persona = persona;
		}
		public Experiencia() {
			
		}
}
