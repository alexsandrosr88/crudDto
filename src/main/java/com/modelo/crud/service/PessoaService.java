package com.modelo.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.crud.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
}
