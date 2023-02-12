package com.modelo.crud.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.modelo.crud.entity.Pessoa;

public class PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNasci;
	
	public PessoaDTO(){}

	public PessoaDTO(Long id, String nome, String email, LocalDate dataNasci) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNasci = dataNasci;
	}
	
	public PessoaDTO(Pessoa entity) {
		id = entity.getId();
		nome = entity.getNome();
		email = entity.getEmail();
		dataNasci = entity.getDataNasci();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNasci() {
		return dataNasci;
	}

	public void setDataNasci(LocalDate dataNasci) {
		this.dataNasci = dataNasci;
	}
}
