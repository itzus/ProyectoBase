package com.asw.test.app.base.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIMIENTO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoEntity implements Serializable {

	private static final long serialVersionUID = -4114994196292019840L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mov_seq")
	@SequenceGenerator(name = "mov_seq", sequenceName = "MOV_SEQ", allocationSize = 1)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUENTA_ID")
	private CuentaEntity cuenta;

	@Column(name = "FECHA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Column(name = "SALDO_ANTERIOR")
	private BigDecimal saldoAnterior;

	@Column(name = "SALDO_NUEVO")
	private BigDecimal saldoNuevo;

	@Column(name = "MONTO")
	private BigDecimal monto;

	@Column(name = "TIPO_MOVIMIENTO")
	private String tipoMovimiento;

}