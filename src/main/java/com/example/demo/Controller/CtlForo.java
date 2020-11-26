package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Estudiante;
import com.example.demo.Entity.EstudianteClase;
import com.example.demo.Entity.Foro;
import com.example.demo.Entity.Participacion;
import com.example.demo.Repository.RepoEstudiante;
import com.example.demo.Repository.RepoEstudianteClase;
import com.example.demo.Repository.RepoForo;
import com.example.demo.Repository.RepoParticipacion;

@RestController
public class CtlForo {

	@Autowired
	private RepoEstudianteClase repoEstuClase;
	
	@Autowired
	private RepoForo repoForo;
	
	@Autowired
	RepoEstudiante repoEstu;
	
	@Autowired 
	RepoParticipacion repoParticipacion;

	@PostMapping("/guardarForo")
	public Foro guardar(@RequestBody Foro foro) {
		return this.repoForo.save(foro);
	}

	@GetMapping("/buscarForo/{id}")
	public ResponseEntity<Foro> buscar(@PathVariable("id") int id) {
		Foro foro = this.repoForo.findById(id);
		if (foro == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(foro);
	}

	@GetMapping("/listarForos")
	public List<Foro> listarForos() {
		return this.repoForo.findAll();
	}

	@GetMapping("/listarForosDocente/{docenteId}")
	public List<Foro> listarForosPorDocente(@PathVariable("docenteId") int docenteId) {
		return this.repoForo.findByIdDocente(docenteId);
	}
	
	@DeleteMapping("/eliminarForo/{id}")
	public ResponseEntity<Foro> eliminar(@PathVariable("id") int id) {
		Foro foro = this.repoForo.findById(id);
		if (foro == null)
			return ResponseEntity.notFound().build();
		else
			this.repoForo.delete(foro);
		return ResponseEntity.ok(foro);
	}
	
	@GetMapping("/listarForosPorClase/{idClase}")
	public List<Foro> listarForosPorClase(@PathVariable("idClase") int idClase){
		return this.repoForo.findAllByIdClase(idClase);
	}


	@GetMapping("/listarEstudiantesQueParticiparon/{idForo}")
	public List<Estudiante> listarEstudiantesParticiparon(@PathVariable("idForo") int idForo){
		List<Participacion> listaParticipaciones=repoParticipacion.findAllByIdForo(idForo);
		List<Estudiante> listaEstudiantes= new ArrayList<>();
		for (int i = 0; i < listaParticipaciones.size(); i++) {
			if(noEstáRepetido(listaParticipaciones.get(i).getIdParticipante(), listaEstudiantes)) {
				listaEstudiantes.add(repoEstu.findById(listaParticipaciones.get(i).getIdParticipante()));
			}
		}
		return listaEstudiantes;
		
	}
	public List<Estudiante> listarEstudiantesPart(int idForo){
		List<Participacion> listaParticipaciones=repoParticipacion.findAllByIdForo(idForo);
		List<Estudiante> listaEstudiantes= new ArrayList<>();
		for (int i = 0; i < listaParticipaciones.size(); i++) {
			if(noEstáRepetido(listaParticipaciones.get(i).getIdParticipante(), listaEstudiantes)) {
				listaEstudiantes.add(repoEstu.findById(listaParticipaciones.get(i).getIdParticipante()));
			}
		}
		return listaEstudiantes;
		
	}
	
	private boolean noEstáRepetido(int idParticipante, List<Estudiante> listaEstudiantes) {
		for (int i = 0; i < listaEstudiantes.size(); i++) {
			if (listaEstudiantes.get(i).getId()==idParticipante) {
				return false;
			}
		}
		return true;
	}
	
	@GetMapping("/listarEstudiantesNoParticiparon/{idForo}")
	public List<Estudiante> listarNoParticiparon(@PathVariable("idForo") int idForo){
		Foro foro= repoForo.findById(idForo);
		List<Estudiante> listaEstudiantesClase=listarEstudiantesClase(foro.getIdClase());
		List<Estudiante> listaParticiparon= listarEstudiantesPart(foro.getId());
		List<Estudiante> listaNoParticiparon=new ArrayList<>();
		for (int i = 0; i < listaEstudiantesClase.size(); i++) {
			if(!participo(listaEstudiantesClase.get(i).getId(),listaParticiparon)) {
				listaNoParticiparon.add(listaEstudiantesClase.get(i));
			}
		}
		return listaNoParticiparon;
		
	}
	
	@GetMapping("/listarEstudiantesClase/{idClase}")
	public List<Estudiante> listarEstudiantesClase(@PathVariable("idClase") int idClase){
	List<EstudianteClase> listaEstClase= repoEstuClase.findAllByIdClase(idClase);
	List<Estudiante> listaEstudiantes=new ArrayList<>();
	for (int i = 0; i < listaEstClase.size(); i++) {
		listaEstudiantes.add(repoEstu.findById(listaEstClase.get(i).getIdEstudiante()));
	}
	return listaEstudiantes;
	
	}

	private boolean participo(int id, List<Estudiante> listaParticiparon) {
		for (int i = 0; i < listaParticiparon.size(); i++) {
			if (listaParticiparon.get(i).getId()==id) {
				return true;
			}
		}
		return false;
	}
	
}
