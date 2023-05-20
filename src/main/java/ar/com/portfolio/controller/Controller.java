package ar.com.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.portfolio.model.Persona;
import ar.com.portfolio.service.IPersonaService;

@RestController
public class Controller {
	
	@Autowired
	private IPersonaService persoServ;
	
	@GetMapping ("/error")
	public String error() {
		return "Se produjo un error";
	}

	@GetMapping("/ver/personas")
	public List<Persona> verPersonas(){
		return persoServ.verPersonas();
	}
	
	@PostMapping("/new/persona")
	public void agregarPersona(@RequestBody Persona persona) {
		persoServ.crearPersona(persona);
	}
	
	@DeleteMapping("/delete/{id}")
	public void agregarPersona(@PathVariable long id) {
		persoServ.borrarPersona(id);
	}
	

}
