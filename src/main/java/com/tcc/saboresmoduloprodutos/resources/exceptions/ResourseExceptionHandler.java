package com.tcc.saboresmoduloprodutos.resources.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tcc.saboresmoduloprodutos.service.exceptions.DataIntegrityException;
import com.tcc.saboresmoduloprodutos.service.exceptions.ObjetoNaoEncontradoException;
import com.tcc.saboresmoduloprodutos.utils.Util;

@ControllerAdvice
public class ResourseExceptionHandler {
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException e, HttpServletRequest http) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(status.value(), e.getMessage(), new Date());
		return Util.buildResponse(status).body(error);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest http) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(status.value(), e.getMessage(), new Date());
		return Util.buildResponse(status).body(error);
	}
}
