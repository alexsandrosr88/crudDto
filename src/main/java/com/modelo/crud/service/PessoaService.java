package com.modelo.crud.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modelo.crud.dto.PessoaDTO;
import com.modelo.crud.entity.Pessoa;
import com.modelo.crud.repository.PessoaRepository;
import com.modelo.crud.service.exception.RecursoNaoEncontrado;
import com.modelo.crud.service.exception.ValidacaoExcecao;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Transactional(readOnly = true)
	public List<PessoaDTO> listarTudo() {
		List<Pessoa> list = repository.findAll();
		if (list.isEmpty())
			throw new RecursoNaoEncontrado("O banco não possui registros!");
		else
			return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PessoaDTO pessoaPorId(Long id) {
		try {
			Pessoa pessoa = repository.findById(id).get();
			return new PessoaDTO(pessoa);
		} catch (NoSuchElementException e) {
			throw new RecursoNaoEncontrado("O id: " + id + " não existe!");
		}

	}

	@Transactional(readOnly = true)
	public List<PessoaDTO> pessoaPorNome(String nome) {
		List<Pessoa> list = repository.findByNomeContainingIgnoreCase(nome);
		if (list.isEmpty())
			throw new RecursoNaoEncontrado("O nome: " + nome + " não existe!");
		return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = false)
	public PessoaDTO salvarPessoa(PessoaDTO dto) {
		validaEmail(dto.getEmail());
		Pessoa pessoa = new Pessoa(dto);
		return new PessoaDTO(repository.save(pessoa));
	}

	@Transactional(readOnly = false)
	public PessoaDTO editarPessoa(PessoaDTO dto, Long id) {
		try {
			Pessoa pessoa = repository.getReferenceById(id);
			pessoa = new Pessoa(dto, id);
			return new PessoaDTO(repository.save(pessoa));
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontrado("O id: " + id + " não existe!");
		}
	}

	@Transactional(readOnly = false)
	public void deletarPessoa(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new RecursoNaoEncontrado("O id: " + id + " não existe!");
		}
	}

	private void validaEmail(String email) {

		if (repository.existsByEmail(email)) {
			throw new ValidacaoExcecao("Este e-mail já existe no banco!");
		}
	}
}
