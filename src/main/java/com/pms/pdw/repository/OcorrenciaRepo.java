package com.pms.pdw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.pdw.model.Incidencia;

public interface OcorrenciaRepo extends JpaRepository<Incidencia, Long>{

}
