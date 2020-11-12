package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repository.RepoEstudianteClase;

import lombok.Data;

@Entity
@Data
public class EstudianteClase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int idClase, idEstudiante;
	private String nombreClase;
	
}
