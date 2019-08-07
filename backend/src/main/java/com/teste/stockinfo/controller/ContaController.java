package com.teste.stockinfo.controller;


import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Saque;
import com.teste.stockinfo.model.TipoDeConta;
import com.teste.stockinfo.model.Usuario;
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

        List<TipoDeConta> tc = c.getTiposDeConta();

        for (TipoDeConta tdc : tc) {
            if (tdc.getId().equals(saque.getTipoDeConta().getId())) {

                Double saldoAtual = tdc.getSaldo();

                saldoAtual = saldoAtual - saque.getValor();

                tdc.setSaldo(saldoAtual);

                c.setTiposDeConta(tc);
                System.out.println(tdc);

                contaRepository.save(c);
            }
        }


        return ResponseEntity.ok().build();
    }

}
