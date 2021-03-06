package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int idEstudiante, idDocente, idClase;
	
	private String nombreClase, codigo, nombreEstudiante, gradoEstudiante, gradoClase;
	
}
