package com.projetoEmpresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoEmpresa.entities.Empresa;
import com.projetoEmpresa.service.EmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "Empresa", description = "API REST DE GERENCIAMENTO  DA EMPRESA")
@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	private final EmpresaService empresaService;

	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}
	@GetMapping("/{id}")
	@Operation(summary = "Localiza pedido por ID")
	public ResponseEntity<Empresa> buscaEmpresaControlId(@PathVariable Long id){
		Empresa empresa = empresaService.buscaEmpresaId(id);
		if(empresa !=null) {
			return ResponseEntity.ok(empresa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/")
	@Operation(summary = "Apresenta todos as Empresas")
	public ResponseEntity<List<Empresa>> buscaTodosEmpresasControl(){
		List<Empresa> Empresa = empresaService.buscaTodosEmpresa();
		return ResponseEntity.ok(Empresa);
	}
	@PostMapping("/")
	@Operation(summary = "Cadastra uma Empresa")
	public ResponseEntity<Empresa> salvaEmpresasControl(@RequestBody @Valid Empresa empresa){
		Empresa salvaEmpresa = empresaService.salvaEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaEmpresa);
}
	@PutMapping("/{id}")
	@Operation(summary= "Altera Empresa")
	public ResponseEntity<Empresa> alteraEmpresaControl(@PathVariable Long id, @RequestBody @Valid Empresa empresa){
		Empresa alteraEmpresa = empresaService.alterarEmpresa(id, empresa);
		if(alteraEmpresa !=null) {
			return ResponseEntity.ok(empresa);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	@DeleteMapping("/{id}")
	@Operation (summary = "Deleta Empresa")
	public ResponseEntity<Empresa> apagaEmpresaControl(@PathVariable Long id){
		boolean apagar = empresaService.apagarEmpresa(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
