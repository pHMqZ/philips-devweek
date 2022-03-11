package com.pms.pdw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.pms.pdw.model.Regiao;
import com.pms.pdw.repository.RegiaoRepo;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepo regiaoRepo;
	
	public List<Regiao> getRegiao(){
		return regiaoRepo.findAll();
	}
	
	public ResponseEntity<?> getRegiaoById(@PathVariable Long id){
		Optional<Regiao> regiaoOptional = regiaoRepo.findById(id);
		if(regiaoOptional.isPresent()) {
			Regiao regiaoUnd = regiaoOptional.get();
			return new ResponseEntity<>(regiaoUnd, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public Regiao saveRegiao(Regiao newRegiao) {
		return regiaoRepo.save(newRegiao);
	}

	public void deletaRegiao(@PathVariable Long id) {
		regiaoRepo.deleteById(id);
	}
}
