package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Deposito;
import com.teste.stockinfo.model.Saque;
import com.teste.stockinfo.model.enums.TipoContaEnum;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.DepositoRepository;
import com.teste.stockinfo.repository.SaqueRepository;
import com.teste.stockinfo.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<Conta> buscarTodos() {
        return contaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        Conta conta = contaRepository.getOne(id);
        return ResponseEntity.ok(conta);
    }

    @PostMapping
    public ResponseEntity<Conta> novaConta(@RequestBody Conta conta) {
        Conta contaNova = contaRepository.save(conta);
        return ResponseEntity.ok(contaNova);
    }

    @PutMapping("/depositar/{idConta}")
    public ResponseEntity<Conta> depositar(@PathVariable Conta idConta, @RequestBody Deposito deposito) {
        return contaService.depositar(idConta, deposito);
    }

    @PutMapping("/sacar/{idConta}")
    public ResponseEntity<Conta> sacar(@PathVariable Conta idConta, @RequestBody Saque saque) {
        return contaService.sacar(idConta, saque);
    }


}
