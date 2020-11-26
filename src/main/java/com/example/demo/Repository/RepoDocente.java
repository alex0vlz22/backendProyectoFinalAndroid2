package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Docente;

public interface RepoDocente extends JpaRepository<Docente, Integer>{

	Docente findByDocumento(long documento);
	
	Docente findById(int id);
	
	Docente findByCorreoIgnoreCase(String correo);
	
}
