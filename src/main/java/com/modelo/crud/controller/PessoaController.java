package com.modelo.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.crud.dto.PessoaDTO;
import com.modelo.crud.entitie.Pessoa;
import com.modelo.crud.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping
	public List<PessoaDTO> listaDePessoa(){
		return service.listarTudo();
	}
	
	@GetMapping(value = "/{id}")
	public PessoaDTO pessoaPorId(@PathVariable Long id) {
		return service.pessoaPorId(id);
	}
	
	@GetMapping(value = "/buscaPorNome/{nome}")
	public List<PessoaDTO> pessoaPorNome(@PathVariable String nome) {
		return service.pessoaPorNome(nome);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public PessoaDTO novaPessoa(@RequestBody PessoaDTO dto) {
		return service.salvarPessoa(dto);
	}
	
	
}
