package com.teste.stockinfo.controller;

import com.teste.stockinfo.model.Deposito;
import com.teste.stockinfo.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deposito")
public class DepositoController {

    @Autowired
    private DepositoRepository depositoRepository;

    @GetMapping
    public List<Deposito> todosDepositos() {
        return depositoRepository.findAll();
    }
}
