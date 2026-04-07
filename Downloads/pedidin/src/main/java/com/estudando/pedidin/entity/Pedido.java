package com.estudando.pedidin.entity;

import com.estudando.pedidin.entity.enums.StatusPedido;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private StatusPedido statusPedido;
    private BigDecimal valorTotal;
    private LocalDateTime dateTime;


    public Pedido(){

    }

    public Pedido(Long id, StatusPedido statusPedido, BigDecimal valorTotal, LocalDateTime dateTime) {
        this.id = id;
        this.statusPedido = statusPedido;
        this.valorTotal = valorTotal;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
