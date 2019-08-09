package com.teste.stockinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teste.stockinfo.model.enums.OperacaoEnum;
import com.teste.stockinfo.model.enums.TipoContaEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    @Enumerated(EnumType.STRING)
    private TipoContaEnum tipoDeConta;

    private Date data;

    @ManyToOne
    private Conta conta;

    @Enumerated(EnumType.STRING)
    private OperacaoEnum operacao;

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

    public OperacaoEnum getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoEnum operacao) {
        this.operacao = operacao;
    }
}
