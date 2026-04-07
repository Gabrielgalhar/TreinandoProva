package com.estudando.pedidin.service;

import com.estudando.pedidin.entity.Pedido;
import com.estudando.pedidin.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido criarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll(){
        return  pedidoRepository.findAll();
    }

    public Optional<Pedido> findByIdPedido (Long id){
        return pedidoRepository.findById(id);
    }

    public boolean deletarPedido(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if (pedido.isPresent()) {
            pedidoRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public Optional<Pedido> atualizarPedido(Pedido pedido, Long id){
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido1 = pedidoOptional.get();
            pedido1.setStatusPedido(pedido.getStatusPedido());
            pedido1.setDateTime(pedido.getDateTime());
            pedido1.setValorTotal(pedido.getValorTotal());

            return Optional.of(pedidoRepository.save(pedido1));
        }

        return Optional.empty();
    }


}
