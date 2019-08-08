package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.*;
import com.teste.stockinfo.model.enums.TipoContaEnum;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.TipoDeContaRepository;
import com.teste.stockinfo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoDeContaRepository tipoDeContaRepository;


    @GetMapping
    public List<Conta> buscarTodos() {
        return contaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Conta> novaConta(@RequestBody Conta conta) {
        Conta contaNova = contaRepository.save(conta);
        return ResponseEntity.ok(contaNova);
    }

    @PutMapping("/sacar/{idConta}")
    public ResponseEntity<Conta> sacar(@PathVariable Conta idConta, @RequestBody Saque saque) {
        Conta c = contaRepository.getOne(idConta.getId());

        if (saque.getTipoDeConta().equals(TipoContaEnum.Eventual)) {
            if (saque.getValor() < c.getSaldoContaEventual()) {
                Double saldoAtual = c.getSaldoContaEventual();
                saldoAtual = saldoAtual - saque.getValor();

                c.setSaldoContaEventual(saldoAtual);

                contaRepository.save(c);
            }
        } else if (saque.getTipoDeConta().equals(TipoContaEnum.Normal)) {
            if (saque.getValor() < c.getSaldoContaNormal()) {
                Double saldoAtual = c.getSaldoContaNormal();
                saldoAtual = saldoAtual - saque.getValor();

                c.setSaldoContaNormal(saldoAtual);

                contaRepository.save(c);
            }
        }


        return ResponseEntity.ok(c);
    }

    @PutMapping("/depositar/{idConta}")
    public ResponseEntity<Conta> depositar(@PathVariable Conta idConta, @RequestBody Deposito deposito) {
        Conta c = contaRepository.getOne(idConta.getId());

        if (deposito.getTipoDeConta().equals(TipoContaEnum.Eventual)) {
            Double saldoAtual = c.getSaldoContaEventual();
            saldoAtual = saldoAtual + deposito.getValor();

            c.setSaldoContaEventual(saldoAtual);

            contaRepository.save(c);
        } else if (deposito.getTipoDeConta().equals(TipoContaEnum.Normal)) {
            Double saldoAtual = c.getSaldoContaNormal();
            saldoAtual = saldoAtual + deposito.getValor();

            c.setSaldoContaNormal(saldoAtual);

            contaRepository.save(c);
        }


        return ResponseEntity.ok(c);
    }

}
