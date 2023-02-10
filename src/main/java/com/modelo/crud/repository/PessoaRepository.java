package com.modelo.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.crud.entitie.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
