package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.EstudianteClase;

public interface RepoEstudianteClase extends JpaRepository<EstudianteClase, Integer>{

	@Query("select c from EstudianteClase c where idEstudiante = ?1")
	List<EstudianteClase> findearPorEstudiante(int idEstudiante);
	
	List<EstudianteClase> findAllByIdClase(int idClase);
	
}
