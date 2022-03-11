package com.pms.pdw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	
	private String regiao;
	
	private Long total_exames;

	public Regiao(String regiao, Long total_exames) {
		this.regiao = regiao;
		this.total_exames = total_exames;
	}
	
	public Regiao() {
		
	}

	public Long getId() {
		return id;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Long getTotal_exames() {
		return total_exames;
	}

	public void setTotal_exames(Long total_exames) {
		this.total_exames = total_exames;
	}

		
}
