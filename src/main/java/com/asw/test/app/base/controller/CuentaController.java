package com.asw.test.app.base.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asw.test.app.base.dto.RetiroRequestDto;
import com.asw.test.app.base.exceptions.BancoException;
import com.asw.test.app.base.service.CuentaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "CUENTA", description = "Cuenta management APIs")
@RequestMapping("cuenta")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@Operation(summary = "CONSULTAR SALDO POR CUENTA", description = "Permite consultar el saldo para una cuenta especifica", tags = {
			"get" })
	@ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = BigDecimal.class), mediaType = "application/json") })
	@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
	@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
	@GetMapping(path = "{cuentaId}")
	public BigDecimal getSaldo(@PathVariable Integer cuentaId) {
		return cuentaService.consultarSaldo(cuentaId);
	}

	@Operation(summary = "RETIRAR CUENTA", description = "Permite retirar un monto de una cuenta especifica", tags = {
			"post" })
	@ApiResponse(responseCode = "200")
	@PostMapping(path = "/retiro", produces = MediaType.APPLICATION_JSON_VALUE)
	public void retiro(@RequestBody RetiroRequestDto dataRetiro) throws BancoException {
		cuentaService.retirar(dataRetiro.getCuenta(), dataRetiro.getMonto());
	}

}