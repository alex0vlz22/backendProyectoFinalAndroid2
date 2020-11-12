package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Estudiante;

public interface RepoEstudiante extends JpaRepository<Estudiante, Integer>{

	Estudiante findByDocumento(long documento);
	
	Estudiante findByCorreo(String correo);
	
	Estudiante findById(int id);
	
}
