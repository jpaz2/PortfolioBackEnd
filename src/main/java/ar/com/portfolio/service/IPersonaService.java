package ar.com.portfolio.service;

import java.util.List;

import ar.com.portfolio.model.Persona;

public interface IPersonaService {
	public List<Persona> verPersonas();

	public void crearPersona(Persona persona);

	public Persona buscarPersona(long id);

	public void modificarPersona(long id, Persona persona);

	public void borrarPersona(long id);
}
