package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

    //@OneToMany(mappedBy="docente", cascade = CascadeType.REMOVE)
	//private List<Foro> foros;
    
    //@OneToMany(mappedBy="docente", cascade = CascadeType.REMOVE)
	//private List<Clase> clases;
    
}
