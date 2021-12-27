package com.example.restaurante.service;

import com.example.restaurante.entity.Caixa;
import com.example.restaurante.entity.Mesa;
import com.example.restaurante.entity.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RestauranteService {

    private RestauranteRepository restauranteRepository;

    public UsuarioService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Mesa consultaPedidos(Long mesaNumero){

        Mesa mesa = restauranteRepository.consultaMesa(mesaNumero);
        BigDecimal total = new BigDecimal(0);
        for (Pedido p: mesa.getListaPedidos()){
            total = total.add(p.getValorTotal());
        }
        mesa.setValorTotal(total);
        return mesa;
    }

    public BigDecimal fecharPedido(Long mesaNumero){
        Mesa mesa = consultaPedidos(mesaNumero);
        mesa.getListaPedidos().clear();
        Caixa caixa = restauranteRepository.consultaCaixa();
        restauranteRepository.atualizaMesa(mesa);
        BigDecimal atual = caixa.getValorTotal();
        BigDecimal novo = atual.add(mesa.getValorTotal());
        caixa.setValorTotal(novo);
        restauranteRepository.atualizaCaixa(caixa);
        return atual;
    }

    public Caixa totalCaixa(){
        Caixa caixa = restauranteRepository.consultaCaixa();
        return caixa;
    }
}
