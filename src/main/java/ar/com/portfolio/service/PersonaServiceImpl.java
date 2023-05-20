package ar.com.portfolio.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.portfolio.model.Persona;
import ar.com.portfolio.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	public PersonaRepository persoRep;
	
	@Override
	public List<Persona> verPersonas() {
		return persoRep.findAll();
	}

	@Override
	public void crearPersona(Persona persona) {
		persoRep.save(persona);
	}

	@Override
	public Persona buscarPersona(long id) {
		return persoRep.findById(id).orElse(null);
	}

	@Override
	public void modificarPersona(long id, Persona persona) {
		persoRep.save(persona);
		
	}

	@Override
	public void borrarPersona(long id) {
		persoRep.deleteById(id);;
	}

}
