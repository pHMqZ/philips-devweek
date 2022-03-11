package com.pms.pdw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pms.pdw.model.FaixaEtaria;
import com.pms.pdw.repository.FaixaEtariaRepo;

@Service
public class FaixaEtariaService {

	@Autowired
	private FaixaEtariaRepo fERepo;
	
	public ResponseEntity<?> findAllFaixa(){
		try {
			List<FaixaEtaria> lista = fERepo.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<FaixaEtaria> findByIdFaixa(@PathVariable Long id){
		try {
			Optional<FaixaEtaria> undOptional = fERepo.findById(id);
			if (undOptional.isPresent()) {
				FaixaEtaria faixaEtariaUnd = undOptional.get();
				return new ResponseEntity<>(faixaEtariaUnd, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public FaixaEtaria salvarFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria) {
		return fERepo.save(newFaixaEtaria);
	}
	
	public void deleteFaixaEtaria(@PathVariable Long id) {
		fERepo.deleteById(id);
	}
}
