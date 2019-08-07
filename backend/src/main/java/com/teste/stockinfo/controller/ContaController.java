package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;


    @GetMapping
    public List<Conta> buscarTodos(){
        return contaRepository.findAll();
    }

}
