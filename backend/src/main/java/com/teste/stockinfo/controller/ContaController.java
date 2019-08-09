package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Deposito;
import com.teste.stockinfo.model.Saque;
import com.teste.stockinfo.model.Usuario;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.UsuarioRepository;
import com.teste.stockinfo.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> buscarContaPorCpfUsuario(@PathVariable Long id){
        Conta conta = contaRepository.findByUsuarioId(id);
        return ResponseEntity.ok(conta);
    }

    @PostMapping
    public ResponseEntity<?> novaConta(@RequestBody Conta conta) {
        conta.setSaldoTotalGeral(conta.getSaldoContaNormal() + conta.getSaldoContaEventual());
        return contaService.criarConta(conta);
    }

    @PutMapping("/depositar/{idConta}")
    public ResponseEntity<?> depositar(@PathVariable Conta idConta, @RequestBody Deposito deposito) {
        return contaService.depositar(idConta, deposito);
    }

    @PutMapping("/sacar/{idConta}")
    public ResponseEntity<?> sacar(@PathVariable Conta idConta, @RequestBody Saque saque) {
        return contaService.sacar(idConta, saque);
    }


}
