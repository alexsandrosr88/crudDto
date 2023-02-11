package com.modelo.crud.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoExcecao extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ValidacaoExcecao(String msg) {
		super(msg);
	}
	
}
