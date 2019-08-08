package com.teste.stockinfo.model;

import com.teste.stockinfo.model.enums.TipoContaEnum;

import javax.persistence.*;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoContaEnum tipoConta;

    private Double saldoContaNormal;

    private Double saldoContaEventual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getSaldoContaNormal() {
        return saldoContaNormal;
    }

    public void setSaldoContaNormal(Double saldoContaNormal) {
        this.saldoContaNormal = saldoContaNormal;
    }

    public Double getSaldoContaEventual() {
        return saldoContaEventual;
    }

    public void setSaldoContaEventual(Double saldoContaEventual) {
        this.saldoContaEventual = saldoContaEventual;
    }
}
