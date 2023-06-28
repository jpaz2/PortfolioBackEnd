package ar.com.portfolio.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.portfolio.model.Persona;
import ar.com.portfolio.model.Registro;
import ar.com.portfolio.repository.PersonaRepository;
import ar.com.portfolio.repository.RegistroRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	public RegistroRepository regRep;
	
	@Autowired
	private IPersonaService servPer;
	
	@Override
	public Persona buscarRegistro(String email, String password) {
		Persona persona = new Persona();   
		Registro registro = buscarReg(email, password);
		
		if (registro!=null) {
			persona = servPer.buscarPersona(registro.idPersona);
		} else {
			persona = null;
		} 
		  return persona;
	}

	@Override
	public void agregarRegistro(Registro registro) {
		
		Persona persona = servPer.buscarPersona(registro.idPersona);
		
		boolean personaVerificada = (persona != null && persona.email.equals(registro.email));
				
		if (personaVerificada && buscarRegPorEmail(registro.email)==null) {
			Registro reg = new Registro();
			reg.email = registro.email;
			reg.password = registro.password;
			reg.idPersona = registro.idPersona;
			
			regRep.save(reg);
			}
	}
		
	
	public Registro buscarReg(String email, String password) {
		List<Registro> listaReg = regRep.findAll().stream()
		 	.filter( reg -> reg.email.equals(email))
		 	.filter( reg -> reg.password.equals(password)).collect(Collectors.toList());
		
		Registro registro = listaReg.size()==1 ? listaReg.get(0) : null;
		  
		  return registro;
	}
	
	public Registro buscarRegPorEmail(String email) {
		List<Registro> listaReg = regRep.findAll().stream()
		 	.filter( reg -> reg.email.equals(email))
		 	.collect(Collectors.toList());
		
		Registro registro = listaReg.size()==1 ? listaReg.get(0) : null;
		  
		  return registro;
	}


}
