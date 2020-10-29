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

import com.example.demo.Entity.Docente;
import com.example.demo.Repository.RepoDocente;

@RestController
public class CtlDocente {

	@Autowired
	private RepoDocente repoDocente;
	
	@PostMapping("/guardarDocente")
	public Docente guardar(@RequestBody Docente docente) {
		return repoDocente.save(docente);
	}
	
	@GetMapping("/buscarDocente/{documento}")
	public ResponseEntity<Docente> buscar(@PathVariable("documento") long documento) {
		Docente docente = this.repoDocente.findByDocumento(documento);
		if(docente == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(docente);
	}	
	
	@PutMapping("/modificarDocente")
	public ResponseEntity<Docente> modificar(@RequestBody Docente docente){
		Docente d = this.repoDocente.findByCorreo(docente.getCorreo());
		if(d == null)
			return ResponseEntity.notFound().build();
		else
			docente.setId(d.getId());
			this.repoDocente.save(d);
			return ResponseEntity.ok(docente);
	}
	
	@DeleteMapping("/eliminarDocente/{documento}")
	public ResponseEntity<Docente> eliminar(@PathVariable("documento") long documento){
		Docente d = this.repoDocente.findByDocumento(documento);
		if(d == null) 
			return ResponseEntity.notFound().build();
		else
			this.repoDocente.delete(d);
			return ResponseEntity.ok(d);
	}	
	
	// consultas
	
	@GetMapping("/docentes")
	public List<Docente> listarDocentes() {
		return repoDocente.findAll();
	}
	
	@GetMapping("/buscarDocentePorCorreo/{correoDocente}")
	public ResponseEntity<Docente> buscarPorCorreo(@PathVariable("correoDocente") String correo) {
		Docente docente = this.repoDocente.findByCorreo(correo);
		System.out.println("ENTROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		if(docente == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(docente);
	}	
	
}
