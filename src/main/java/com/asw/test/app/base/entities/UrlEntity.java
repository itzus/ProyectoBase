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
@Table(name = "BANCO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlEntity implements Serializable {

	private static final long serialVersionUID = -7281470466797616931L;

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ban_seq")
    @SequenceGenerator(name = "ban_seq", sequenceName = "BAN_SEQ", allocationSize = 1)
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "ESTADO")
    private String estado;

}