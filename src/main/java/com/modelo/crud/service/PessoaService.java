package com.modelo.crud.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modelo.crud.dto.PessoaDTO;
import com.modelo.crud.entitie.Pessoa;
import com.modelo.crud.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Transactional(readOnly = true)
	public List<PessoaDTO> listarTudo() {
		List<Pessoa> list = repository.findAll();
		return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PessoaDTO pessoaPorId(Long id) {
		Pessoa pessoa = repository.findById(id).get();
		return new PessoaDTO(pessoa);
	}

	@Transactional(readOnly = true)
	public List<PessoaDTO> pessoaPorNome(String nome) {
		List<Pessoa> list = repository.findByNomeContainingIgnoreCase(nome);
		return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}
	
	
	
	
}
