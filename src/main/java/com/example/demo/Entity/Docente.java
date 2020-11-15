package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private long documento;
    private String nombre, apellido;
    private long telefono;
    private String correo, contrasena;
    private String fechaNacimiento;
    
}
