package com.asw.test.app.base.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = -296175153177566710L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usu_seq")
	@SequenceGenerator(name = "usu_seq", sequenceName = "USU_SEQ", allocationSize = 1)
	private Integer id;

	@Column(name = "NOMBRE")
	private String nombre;

}