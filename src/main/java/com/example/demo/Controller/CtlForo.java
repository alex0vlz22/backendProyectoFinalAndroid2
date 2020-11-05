package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Foro;
import com.example.demo.Repository.RepoForo;

@RestController
public class CtlForo {

	@Autowired
	private RepoForo repoForo;

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
}
