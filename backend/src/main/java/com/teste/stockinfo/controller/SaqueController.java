package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.Saque;
import com.teste.stockinfo.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saque")
public class SaqueController {


    @Autowired
    private SaqueRepository saqueRepository;

    @GetMapping
    public List<Saque> todosSaques() {
        return saqueRepository.findAll();
    }


}
