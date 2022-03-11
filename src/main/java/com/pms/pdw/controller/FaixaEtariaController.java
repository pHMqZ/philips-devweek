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

import com.pms.pdw.model.FaixaEtaria;
import com.pms.pdw.service.FaixaEtariaService;

@RestController
@RequestMapping("/api")
public class FaixaEtariaController {
	
	@Autowired
	private FaixaEtariaService fEService;
	
	@GetMapping("/faixaetaria")
	public ResponseEntity<?> listarTodosFaixa(){
		return fEService.findAllFaixa();
	}
	
	@GetMapping("/faixaetaria/{id}")
	public ResponseEntity<?> listarFaixaPorId(@PathVariable Long id){
		return fEService.findByIdFaixa(id);
	}

	@PostMapping("/faixaetaria/novo")
	public FaixaEtaria salvarFaixa(@RequestBody FaixaEtaria newFaixaEtaria) {
		return fEService.salvarFaixaEtaria(newFaixaEtaria);
	}
	
	@DeleteMapping("faixaetaria/remover/{id}")
	public void deletarFaixa(@PathVariable Long id) {
		fEService.deleteFaixaEtaria(id);
	}
}
