package com.example.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Mesa {
    private Long id;
    private List<Pedido> listaPedidos;
    private BigDecimal valorTotal;
}
