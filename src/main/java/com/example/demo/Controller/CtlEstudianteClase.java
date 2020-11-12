package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.EstudianteClase;
import com.example.demo.Repository.RepoEstudianteClase;

@RestController
public class CtlEstudianteClase {

	@Autowired
	private RepoEstudianteClase repoEstudianteClase;
	
	@PostMapping("/guardarEstudianteClase")
	public EstudianteClase guardar(@RequestBody EstudianteClase EstudianteClase) {
		return this.repoEstudianteClase.save(EstudianteClase);
	}
	
}
