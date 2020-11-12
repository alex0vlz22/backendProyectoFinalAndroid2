package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Solicitud;

public interface RepoSolicitud extends JpaRepository<Solicitud, Integer>{

	Solicitud findByIdEstudiante(int idEstudiante);
	
	List<Solicitud> findByIdDocente(int idDocente);
	
}
