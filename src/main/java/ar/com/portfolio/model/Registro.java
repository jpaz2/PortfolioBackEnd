package ar.com.portfolio.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Registro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String email;
	public String password;
	public long idPersona;
	
	public Registro(long id, String email, String password, long idPersona) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.idPersona = idPersona;
	}
	
	public Registro() {
		super();
		
	}
	


	
	

	
	

}
