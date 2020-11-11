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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Clase;
import com.example.demo.Entity.Docente;
import com.example.demo.Repository.RepoClase;
import com.example.demo.Repository.RepoDocente;

@RestController
public class CtlClase {

	@Autowired
	RepoClase repoClase;

	@Autowired
	RepoDocente repoDocente;

	@PostMapping("/guardarClase")
	public Clase guardar(@RequestBody Clase clase) {
		return repoClase.save(clase);
	}

	@GetMapping("/buscarClase/{grado}/{idDocente}")
	public ResponseEntity<Clase> buscar(@PathVariable("grado") String grado, @PathVariable("idDocente") int idDocente) {
		Clase clase= repoClase.buscarClasePorGradoYDocente(grado, idDocente);
		if(clase == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(clase);
		}
	}

	

	/*
	 * @PutMapping("/modificarClase") public ResponseEntity<Clase>
	 * modificar(@RequestBody Clase clase){ Docente docente =
	 * this.repoDocente.findByDocumento(clase.getDocente().getDocumento());
	 * List<Clase> lista = this.repoClase.findAllByDocente(docente); for(Clase c :
	 * lista) { if(c.getGrado().equals(clase.getGrado())) { clase.setId(c.getId());
	 * this.repoClase.save(clase); return ResponseEntity.ok(clase); } } return
	 * ResponseEntity.notFound().build(); }
	 */

	/*@DeleteMapping("/eliminarClase")
	public ResponseEntity<Clase> eliminar(@RequestBody Clase clase) {
		Clase cls = this.repoClase.findByIdDocente(clase.getId());
		if (cls == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(clase);
		}
	}*/

	@GetMapping("/listarPorDocente/{idDocente}")
	public List<Clase> listarPorDocente(@PathVariable("idDocente") int id) {
		List<Clase> lista = this.repoClase.findByIdDocente(id);
		return lista;
	}
	
	@GetMapping("/buscarPorCodigo/{codigo}")
	public ResponseEntity<Clase> buscarPorCodigo(@PathVariable("codigo") String codigo){
		Clase clase = this.repoClase.findByCodigo(codigo);
		if(clase == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(clase);
	}

}
