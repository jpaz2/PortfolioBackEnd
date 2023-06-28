package ar.com.portfolio.service;

import ar.com.portfolio.model.Persona;
import ar.com.portfolio.model.Registro;

public interface ILoginService {

	public Persona buscarRegistro(String email, String password);

	public void agregarRegistro(Registro registro);

	

	}
