package com.asw.test.app.base.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUENTA")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuentaEntity implements Serializable {

	private static final long serialVersionUID = -7109536487212965294L;

	@Id
	@Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cue_seq")
//    @SequenceGenerator(name = "cue_seq", sequenceName = "CUE_SEQ", allocationSize = 1)
	private Integer id;

	@Column(name = "TIPO")
	private String tipo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BANCO_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private BancoEntity banco;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO_ID")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private UsuarioEntity usuario;

	@Column(name = "SALDO")
	private BigDecimal saldo;

}