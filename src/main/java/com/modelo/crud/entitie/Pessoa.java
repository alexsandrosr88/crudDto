package com.modelo.crud.entitie;

import java.time.LocalDate;

import com.modelo.crud.dto.PessoaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String nome;
	@Column(length = 50)
	private String email;
	private LocalDate dataNasci;
	
	public Pessoa() {}

	public Pessoa(Long id, String nome, String email, LocalDate dataNasci) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNasci = dataNasci;
	}

	public Pessoa(PessoaDTO dto) {
		nome = dto.getNome();
		email = dto.getEmail();
		dataNasci = dto.getDataNasci();
	}

	public Pessoa(PessoaDTO dto, Long id) {
		this.id = id;
		nome = dto.getNome();
		email = dto.getEmail();
		dataNasci = dto.getDataNasci();
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
