package com.asw.test.app.base.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.asw.test.app.base.dto.ErrorNotificacionDto;
import com.asw.test.app.base.exceptions.BancoException;

@RestControllerAdvice
public class BancoAdvice {
	
	
	@ExceptionHandler(BancoException.class)
	public ResponseEntity<ErrorNotificacionDto> handle(BancoException runtime) {
		runtime.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorNotificacionDto.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).error(runtime.getMessage()).build());
	}

}
