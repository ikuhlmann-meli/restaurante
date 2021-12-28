package com.example.restaurante.controller;

import com.example.restaurante.entity.Mesa;
import com.example.restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;


@RestController
@RequestMapping("/pedidos")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/pedidosMesa/{numeroMesa}")
    public ResponseEntity pedidosMesa(@PathVariable String numeroMesa) {
        try {
            Long idMesa = Long.parseLong(numeroMesa);
            Mesa mesa = restauranteService.consultaPedidos(idMesa);

            return ResponseEntity.ok(mesa);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/fecharPedido/{id}")
    public ResponseEntity fecharPedido(@PathVariable String id) {

        try {
            Long idMesa = Long.parseLong(id);
            BigDecimal valorTotal = restauranteService.fecharPedido(idMesa);

            return ResponseEntity.ok(valorTotal);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);

        }

    }

    @GetMapping("/totalCaixa")
    public ResponseEntity totalCaixa(){
        return ResponseEntity.ok(restauranteService.totalCaixa());
    }

}
