package com.pms.pdw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pdw.model.Incidencia;
import com.pms.pdw.service.IncidenciaService;

@RestController
@RequestMapping("api")
public class IncidenciaController {

	@Autowired
	private IncidenciaService incService;
	
	@GetMapping("/incidencias")
	public ResponseEntity<?> listarTodosInc(){
		return incService.findIncidencia();
	}
	
	@GetMapping("/incidencias/{id}")
	public ResponseEntity<?> listarPorIdInc(@PathVariable Long id){
		return incService.findIndicenciaById(id);
	}
	
	@PostMapping("/incidencias/novo")
	public Incidencia salvarInc(@RequestBody Incidencia newIncidencia) {
		return incService.salvarIncidencia(newIncidencia);
	}
	
	@DeleteMapping("incidencias/remover/{id}")
	public void deletarInc(@PathVariable Long id) {
		incService.deletarIncidencia(id);
	}
}

