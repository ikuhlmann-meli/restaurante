package com.example.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Pedido {
    private Long id;
    private Mesa mesa;
    private List<Prato> listaPrato;
    private BigDecimal valorTotal;

}
