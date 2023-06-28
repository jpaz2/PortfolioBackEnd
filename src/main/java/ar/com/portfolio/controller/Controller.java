package ar.com.portfolio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.portfolio.model.Persona;
import ar.com.portfolio.model.Registro;
import ar.com.portfolio.service.ILoginService;
import ar.com.portfolio.service.IPersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private IPersonaService persoServ;
	
	@Autowired
	private ILoginService loginServ;
	
	@GetMapping ("/error")
	public String error() {
		return "Se produjo un error";
	}

	@GetMapping("/ver/personas")
	@ResponseBody
	public Persona verPersonas(){
		return persoServ.verPersonas().get(0);
	}
	
	@GetMapping("/personas")
	public List<Persona> verLasPersonas(){
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
	
	@GetMapping("/buscar/persona/{id}")
	@ResponseBody
	public Persona buscarpersona(@PathVariable long id) {
		return persoServ.buscarPersona(id);
	}
	
	@PostMapping("/authenticate")
	@ResponseBody
	public Persona login(@RequestBody String email, String password) {
	   return loginServ.buscarRegistro(email, password);
	}
	
	@PostMapping("/nuevo/registro")
	@ResponseBody
	public void agregarRegistro(@RequestBody Registro registro) {
	    loginServ.agregarRegistro(registro);
	}
	
}
