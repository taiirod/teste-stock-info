package com.teste.stockinfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Usuario usuario;

    private List<TipoDeConta> tiposDeConta;

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

    public List<TipoDeConta> getTiposDeConta() {
        return tiposDeConta;
    }

    public void setTiposDeConta(List<TipoDeConta> tiposDeConta) {
        this.tiposDeConta = tiposDeConta;
    }
}
