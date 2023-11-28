package com.projetoEmpresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoEmpresa.entities.Projeto;

public interface ProjetoRepository  extends JpaRepository <Projeto, Long>{

}
