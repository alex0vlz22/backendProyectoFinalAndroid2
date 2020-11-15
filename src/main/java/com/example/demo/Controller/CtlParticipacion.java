package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Participacion;
import com.example.demo.Repository.RepoParticipacion;

@RestController
public class CtlParticipacion {




	@Autowired
	private RepoParticipacion repoParticipacion;

	@PostMapping("/guardarParticipacion")
	public Participacion guardar(@RequestBody Participacion participacion) {
		return this.repoParticipacion.save(participacion);
	}

	@GetMapping("/buscarParticipacion/{id}")
	public ResponseEntity<Participacion> buscar(@PathVariable("id") int id) {
		Participacion participacion= this.repoParticipacion.findById(id);
		if (participacion == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(participacion);
	}

	@GetMapping("/listarParticipaciones")
	public List<Participacion> listarParticipaciones() {
		return this.repoParticipacion.findAll();
	}

	@GetMapping("/listarParticipacionesPorParticipante/{idParticipante}")
	public List<Participacion> listarParticipacionesPorParticipante(@PathVariable("idParticipante") int idParticipante) {
		return this.repoParticipacion.findByIdParticipante(idParticipante);
	}
	
	@GetMapping("/listarParticipacionPorParticipanteEnForo/{idParticipante}/{idForo}")
	public List<Participacion> listarParticipacionesPorParticipanteEnForo(@PathVariable("idParticipante") int idParticipante, @PathVariable("idForo") int idForo){
		return this.repoParticipacion.buscarParticipacionesPorParticipanteYForo(idParticipante, idForo);
	}
	
	
	@DeleteMapping("eliminarParticipacion/{id}")
	public ResponseEntity<Participacion> eliminar(@PathVariable("id") int id) {
		Participacion participacion= this.repoParticipacion.findById(id);
		if (participacion== null)
			return ResponseEntity.notFound().build();
		else
			this.repoParticipacion.delete(participacion);
		return ResponseEntity.ok(participacion);
	}
}

	

