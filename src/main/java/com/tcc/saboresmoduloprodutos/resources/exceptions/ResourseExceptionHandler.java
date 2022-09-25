package com.tcc.saboresmoduloprodutos.resources.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tcc.saboresmoduloprodutos.service.exceptions.DataIntegrityException;
import com.tcc.saboresmoduloprodutos.service.exceptions.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ResourseExceptionHandler {
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException e, HttpServletRequest http) {
		Integer status = HttpStatus.NOT_FOUND.value();
		StandardError error = new StandardError(status, e.getMessage(), new Date());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest http) {
		Integer status = HttpStatus.BAD_REQUEST.value();
		StandardError error = new StandardError(status, e.getMessage(), new Date());
		return ResponseEntity.status(status).body(error);
	}
}
