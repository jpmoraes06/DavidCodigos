package com.projetoEmpresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoEmpresa.entities.Empresa;

public interface EmpresaRepository extends JpaRepository <Empresa, Long>{

}