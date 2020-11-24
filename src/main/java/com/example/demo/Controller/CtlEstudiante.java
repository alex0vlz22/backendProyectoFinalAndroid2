package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Estudiante;
import com.example.demo.Repository.RepoEstudiante;

@RestController
public class CtlEstudiante {

	@Autowired
	private RepoEstudiante repoEstudiante;
	
	@PostMapping("/guardarEstudiante")
	public Estudiante guardar(@RequestBody Estudiante estudiante) {
		System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
		return this.repoEstudiante.save(estudiante);
	}
	
	@GetMapping("/buscarEstudiante/{documento}")
	public ResponseEntity<Estudiante> buscar(@PathVariable("documento") long documento){
		Estudiante e = this.repoEstudiante.findByDocumento(documento);
		if(e == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(e);
	}
	
	@GetMapping("/buscarEstudianteId/{id}")
	public ResponseEntity<Estudiante> buscarPorId(@PathVariable("id") int id){
		Estudiante e = this.repoEstudiante.findById(id);
		if(e==null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(e);
	}
	
	@PutMapping("/modificarEstudiante")
	public ResponseEntity<Estudiante> modificar(@RequestBody Estudiante estudiante){
		Estudiante e = this.repoEstudiante.findByCorreo(estudiante.getCorreo());
		if (e == null)
			return ResponseEntity.notFound().build();
		else
			estudiante.setId(e.getId());
			this.repoEstudiante.save(estudiante);
			return ResponseEntity.ok(estudiante);
	}
	
	@DeleteMapping("eliminarEstudiante/{documento}")
	public ResponseEntity<Estudiante> eliminar(@PathVariable("documento") long documento){
		Estudiante e = this.repoEstudiante.findByDocumento(documento);
		if(e == null)
			return ResponseEntity.notFound().build();
		else
			this.repoEstudiante.delete(e);
			return ResponseEntity.ok(e);
	}
	
	// consultas
	
	@GetMapping("/listarEstudiantes")
	public List<Estudiante> listarEstudiantes(){
		return this.repoEstudiante.findAll();
	}
	
	@GetMapping("/buscarEstudiantePorCorreo/{correo}")
	public ResponseEntity<Estudiante> buscarPorCorreo(@PathVariable("correo") String correo){
		Estudiante e = this.repoEstudiante.findByCorreo(correo);
		if(e == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(e);
	}
	
}
