package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Docente;
import com.example.demo.Entity.Foro;

public interface RepoForo extends JpaRepository<Foro, Integer> {

	Foro findByTitulo(String titulo);

	Foro findById(int id);

	Foro findByDocente(Docente docente);

	List<Foro> findAll();
	
	List<Foro> findAllByDocente(Docente docente);

}
