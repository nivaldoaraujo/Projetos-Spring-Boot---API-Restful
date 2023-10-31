package com.nivaldo.aulaspring.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nivaldo.aulaspring.exceptions.NaoEncontradoException;

@ControllerAdvice
public class ExceptionHandlers {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(NaoEncontradoException.class)
	public String usuarioNaoEncontrado(NaoEncontradoException ex) {
		return ex.getMessage();
	}
}
