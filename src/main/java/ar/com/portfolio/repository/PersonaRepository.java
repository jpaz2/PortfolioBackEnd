package ar.com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.portfolio.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
