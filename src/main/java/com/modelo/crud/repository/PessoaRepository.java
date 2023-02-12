package com.modelo.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.crud.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	List<Pessoa>findByNomeContainingIgnoreCase(String nome);
	
	boolean existsByEmail(String email);
}
