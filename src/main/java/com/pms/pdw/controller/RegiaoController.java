package com.pms.pdw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.pdw.model.Regiao;
import com.pms.pdw.service.RegiaoService;

@RestController
@RequestMapping("/api")
public class RegiaoController {
	
	@Autowired
	private RegiaoService regiaoService;
	
	@GetMapping("/regioes")
	public List<Regiao> listarTodasRegioes(){
		return regiaoService.getRegiao();
	}
	
	@GetMapping("/regioes/{id}")
	public ResponseEntity<?> listarRegiaoPorId(@PathVariable Long id){
		return regiaoService.getRegiaoById(id);
	}
	
	@PostMapping("/regioes/novo")
	public Regiao salvarRegiao(@RequestBody Regiao newRegiao) {
		return regiaoService.saveRegiao(newRegiao);
	}
	
	@DeleteMapping("regioes/remover/{id}")
	public void deletarRegiao(@PathVariable Long id) {
		regiaoService.deletaRegiao(id);
	}
}
