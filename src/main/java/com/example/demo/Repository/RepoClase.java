package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Clase;
import com.example.demo.Entity.Docente;

public interface RepoClase extends JpaRepository<Clase, Integer>{
	
	@Query("select c from Clase c where c.grado = ?1 and c.idDocente = ?1")
	Clase buscarClasePorGradoYDocente(String grado, int idDocente);
	
	List<Clase> findByGrado(String grado);
	
	Clase findByIdDocente(int idDocente);
	
	
	// este método sí sirve equisdé
	@Query("select c from Clase c where c.idDocente = ?1")
	List<Clase> buscarClasesPorDocente(int idDocente);
	
	Clase findByCodigo(String codigo);
	
}
