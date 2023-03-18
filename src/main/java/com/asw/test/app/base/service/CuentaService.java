package com.asw.test.app.base.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.asw.test.app.base.dto.CuentaDto;
import com.asw.test.app.base.entities.CuentaEntity;
import com.asw.test.app.base.exceptions.BancoException;

public interface CuentaService {

	BigDecimal consultarSaldo(Integer cuenta);

	void retirar(Integer cuenta, BigDecimal monto) throws BancoException;

	void transferir(Integer cuentaOrigen, int cuentaDestino, BigDecimal monto) throws BancoException;

	List<CuentaDto> cuentasPorUsuario(Integer usuarioId);

	Page<CuentaEntity> cuentasfindAll(Pageable pagina);

	void retirarCuentaBanco(BigDecimal monto) throws BancoException;
}