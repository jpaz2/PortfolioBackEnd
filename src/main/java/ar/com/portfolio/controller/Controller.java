package ar.com.portfolio.controller;

import java.util.Date;
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
import ar.com.portfolio.model.PersonaResponse;
import ar.com.portfolio.model.PersonaResponse.Roles;
import ar.com.portfolio.model.Registro;
import ar.com.portfolio.model.User;
import ar.com.portfolio.service.ILoginService;
import ar.com.portfolio.service.IPersonaService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/auth/login")
		public PersonaResponse auth(@RequestBody User persona) {
		PersonaResponse perResp = new PersonaResponse();
		Persona personaLogin = loginServ.buscarRegistro(persona.username, persona.password);
		if (personaLogin != null) {
			String token = this.generarToken(personaLogin);
			perResp.idPersona = personaLogin.id;
			perResp.message = "una mentira";
			perResp.token = token;
			perResp.rol = Roles.ADMIN;
			
		}
		  
		return perResp;
		}
	

	
	private String generarToken(Persona personaLogin) {

		String KEY = "mi_clave";
		long tiempo = System.currentTimeMillis();
		String jwt = Jwts.builder()
						.setSubject(personaLogin.nombre+" "+personaLogin.apellido)
						.claim("email", personaLogin.email)
						.setIssuedAt(new Date(tiempo))
						.setExpiration(new Date(tiempo+900000))
						.signWith(SignatureAlgorithm.HS256, KEY)
						.compact();		
		
		return jwt;
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
