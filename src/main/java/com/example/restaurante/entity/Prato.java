package com.example.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Prato {
    private long id;
    private BigDecimal preco;
    private String descricao;
    private Integer quantidade;

}
