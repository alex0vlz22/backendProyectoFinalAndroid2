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

import com.example.demo.Entity.Solicitud;
import com.example.demo.Repository.RepoSolicitud;

@RestController
public class CtlSolicitud {

	@Autowired
	RepoSolicitud repoSolicitud;

	@PostMapping("/guardarSolicitud")
	public Solicitud guardar(@RequestBody Solicitud solicitud) {
		return this.repoSolicitud.save(solicitud);
	}

	@GetMapping("/buscarSolicitudPorIdEstudiante/{idEstudiante}")
	public ResponseEntity<Solicitud> buscarPorEstudiante(@PathVariable("idEstudiante") int idEstudiante) {
		Solicitud solicitud = this.repoSolicitud.findByIdEstudiante(idEstudiante);
		if (solicitud == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(solicitud);
	}

	@GetMapping("/buscarSolicitudPorIdDocente/{idDocente}")
	public List<Solicitud> buscarPorClase(@PathVariable("idDocente") int idDocente) {
		List<Solicitud> listaSolicitud = this.repoSolicitud.findByIdDocente(idDocente);
		return listaSolicitud;
	}
	
	@DeleteMapping("/eliminarSolicitud/{id}")
	public ResponseEntity<Solicitud> eliminar(@PathVariable("id") int id){
		Solicitud s = this.repoSolicitud.findById(id);
		if(s == null)
			return ResponseEntity.notFound().build();
		else
			this.repoSolicitud.delete(s);
			return ResponseEntity.ok(s);
	}

}
