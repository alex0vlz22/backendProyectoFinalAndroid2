package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Solicitud;

public interface RepoSolicitud extends JpaRepository<Solicitud, Integer>{

	Solicitud findByIdEstudiante(int idEstudiante);
	
	Solicitud findByIdClase(int idClase);
	
}
