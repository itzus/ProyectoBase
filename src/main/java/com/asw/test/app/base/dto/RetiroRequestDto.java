package com.asw.test.app.base.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RetiroRequestDto {

    private Integer cuenta;
    private BigDecimal monto;

}