package ar.com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.portfolio.model.Registro;


@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

}