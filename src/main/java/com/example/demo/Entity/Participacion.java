package com.example.demo.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Participacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private int idParticipante;
	private int idForo;
}
