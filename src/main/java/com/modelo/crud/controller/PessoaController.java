package com.modelo.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.crud.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
}
