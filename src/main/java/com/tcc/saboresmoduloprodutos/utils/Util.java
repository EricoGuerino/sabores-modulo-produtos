package com.tcc.saboresmoduloprodutos.utils;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

public class Util {
	
	public static BodyBuilder buildResponse(HttpStatus status) {
		BodyBuilder body = ResponseEntity.status(status);
		//body.header("Access-Control-Allow-Origin", "*");
		body.contentType(MediaType.APPLICATION_JSON);
		//body.header("content-type", "application/json;charset=UTF-8");
		return body;
	}
	
	public static BodyBuilder buildResponse(URI uri) {
		BodyBuilder body = ResponseEntity.created(uri);
		//body.header("Access-Control-Allow-Origin", "*");
		body.contentType(MediaType.APPLICATION_JSON);
		return body;
	}
}
