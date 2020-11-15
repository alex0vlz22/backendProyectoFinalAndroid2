package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Estudiante;
import com.example.demo.Entity.Participacion;


public interface RepoParticipacion extends JpaRepository<Participacion, Integer>{

	Participacion findByDescripcion(String descripcion);

	Participacion findById(int id);

	List<Participacion> findAllByIdForo(int idForo);
	
	List<Participacion> findByIdParticipante(int idParticipante);

	List<Participacion> findAll();
	
	@Query("Select p from Participacion p where p.idParticipante= ?1 and  p.idForo=?2")
	public List<Participacion> buscarParticipacionesPorParticipanteYForo(int idParticipante, int idForo);
	
	/*
	@Query("select * from (select * from (Select distinct idEstudiante from participacion p where p.idForo= ?1) e join Estudiantes est where e.idEstudiante= est.id) minus select * from estudiantes estud")
	public List<Estudiante> contarFaltantes(int idForo);
	*/

}

