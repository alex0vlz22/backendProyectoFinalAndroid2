package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Estudiante;
import com.example.demo.Entity.Foro;

public interface RepoForo extends JpaRepository<Foro, Integer> {

	Foro findByTitulo(String titulo);

	Foro findById(int id);

	List<Foro> findByIdDocente(int idDocente);

	List<Foro> findAll();
	
	List<Foro> findAllByIdClase(int idClase);
	
	//List<Foro> findAllByIdDocente(int idDocente);

	
}
