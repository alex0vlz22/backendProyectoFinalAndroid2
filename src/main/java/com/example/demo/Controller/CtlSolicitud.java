package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	@GetMapping("/buscarSolicitudPorIdClase/{idClase}")
	public ResponseEntity<Solicitud> buscarPorClase(@PathVariable("idClase") int idClase) {
		Solicitud solicitud = this.repoSolicitud.findByIdClase(idClase);
		if (solicitud == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(solicitud);
	}

}
