package com.teste.stockinfo.model;

import com.teste.stockinfo.model.enums.TipoContaEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Saque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @Enumerated(EnumType.STRING)
    private TipoContaEnum tipoDeConta;

    private Date data;

    @ManyToOne
    private Conta conta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoContaEnum getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(TipoContaEnum tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
