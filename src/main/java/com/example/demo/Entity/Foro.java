package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Foro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo, descripcion;
	private boolean activo;
	private int limiteParticipaciones;
	private int idDocente;
	//@ManyToOne
	//@JoinColumn(name="idDocente")
	//private Docente docente;
}
