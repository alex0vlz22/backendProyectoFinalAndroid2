package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Clase;
import com.example.demo.Entity.Solicitud;

public interface RepoSolicitud extends JpaRepository<Solicitud, Integer>{

	Solicitud findByIdEstudiante(int idEstudiante);
	
	List<Solicitud> findByIdDocente(int idDocente);
	
	Solicitud findById(int id);
	
}
