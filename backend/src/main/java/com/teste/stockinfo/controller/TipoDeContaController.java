package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.TipoDeConta;
import com.teste.stockinfo.repository.TipoDeContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoDeConta")
public class TipoDeContaController {

    @Autowired
    private TipoDeContaRepository tipoDeContaRepository;


    @GetMapping
    public List<TipoDeConta> buscarTodos(){
        return tipoDeContaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<TipoDeConta> novoTipoDeConta(@RequestBody TipoDeConta tipoDeConta){
        TipoDeConta novoTipoDeConta = tipoDeContaRepository.save(tipoDeConta);
        return ResponseEntity.ok(novoTipoDeConta);
    }

}
