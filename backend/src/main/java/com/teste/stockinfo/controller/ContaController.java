package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Conta> novaConta(@RequestBody Conta conta){
        Conta contaNova = contaRepository.save(conta);
        return ResponseEntity.ok(contaNova);
    }

    @PutMapping
    public ResponseEntity<Conta> sacar()

}
