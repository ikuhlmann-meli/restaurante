package com.example.restaurante.repository;

import com.example.restaurante.entity.Caixa;
import com.example.restaurante.entity.Mesa;
import com.example.restaurante.entity.Pedido;
import com.example.restaurante.entity.Prato;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteRepository {
    List<Pedido> pedidos = new ArrayList<>();
    List<Prato> pratos = new ArrayList<>();
    Caixa caixa = Caixa.builder().valorTotal(new BigDecimal(0)).build();
    Prato pizza = Prato.builder().id(1l).preco(new BigDecimal(40)).descricao("Portuguesa").quantidade(1).build();
    Prato lasanha = Prato.builder().id(2l).preco(new BigDecimal(30)).descricao("Bolonhesa").quantidade(1).build();
    Prato macarrao = Prato.builder().id(3l).preco(new BigDecimal(25)).descricao("Espaguete").quantidade(1).build();
    Prato torta = Prato.builder().id(4l).preco(new BigDecimal(15)).descricao("Morango").quantidade(1).build();

    Pedido p1 = Pedido.builder().id(1l).listaPrato(List.of(pizza,lasanha)).valorTotal(new BigDecimal(70)).build();
    Pedido p2 = Pedido.builder().id(2l).listaPrato(List.of(lasanha,torta)).valorTotal(new BigDecimal(45)).build();
    Pedido p3 = Pedido.builder().id(3l).listaPrato(List.of(torta,pizza)).valorTotal(new BigDecimal(55)).build();
    Pedido p4 = Pedido.builder().id(4l).listaPrato(List.of(macarrao,torta)).valorTotal(new BigDecimal(40)).build();


    Mesa mesa1 = Mesa.builder().id(1l).listaPedidos(List.of(p1,p2)).build();
    Mesa mesa2 = Mesa.builder().id(2l).listaPedidos(List.of(p3,p4)).build();

    List<Mesa> mesas =List.of(mesa1,mesa2);


    public Mesa consultaMesa(Long id) {
        Mesa mesa = mesas.stream().filter(mesa1 -> mesa1.getId() == id).findFirst().orElse(null);
        return mesa;
    }


    public void atualizaMesa(Mesa mesa) {
        Long id = mesa.getId();
        mesas = mesas.stream().map(mesa1 -> {
            if (mesa1.getId() == id) {
                return mesa;
            } else {
                return mesa1;
            }
        }).collect(Collectors.toList());// itera sobre mesas e atualiza a mesa

    }
    public Caixa consultaCaixa(){
        return caixa;
    }
    public void atualizaCaixa(Caixa cx){
    caixa = cx;
    }

}