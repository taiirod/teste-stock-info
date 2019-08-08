package com.teste.stockinfo.model;

import javax.persistence.*;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private Double saldoContaNormal;

    private Double saldoContaEventual;

    private Double saldoTotalGeral;

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

    public Double getSaldoTotalGeral() {
        return getSaldoContaNormal() + getSaldoContaEventual();
    }

    public void setSaldoTotalGeral(Double saldoTotalGeral) {
        this.saldoTotalGeral = saldoTotalGeral;
    }
}
