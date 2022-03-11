package com.pms.pdw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pms.pdw.model.Incidencia;
import com.pms.pdw.repository.IncidenciaRepo;

@Service
public class IncidenciaService {
	
	@Autowired
	private IncidenciaRepo incRepo;
	
	public ResponseEntity<List<Incidencia>> findIncidencia(){
		List<Incidencia> listaInc = incRepo.findAll();
		if(listaInc.isEmpty())
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		return new ResponseEntity<>(listaInc, HttpStatus.OK);
	}
	
	public ResponseEntity<Incidencia> findIndicenciaById(@PathVariable Long id){
		Optional<Incidencia> incOptional = incRepo.findById(id);
		if(incOptional.isPresent()) {
			Incidencia indUnd = incOptional.get();
			return new ResponseEntity<Incidencia>(indUnd, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public Incidencia salvarIncidencia(@RequestBody Incidencia newIncidencia) {
		return incRepo.save(newIncidencia);
	}
	
	public void deletarIncidencia(@PathVariable Long id) {
		incRepo.deleteById(id);
	}
}
