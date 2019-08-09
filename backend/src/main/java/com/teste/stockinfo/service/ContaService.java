package com.teste.stockinfo.service;

import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Deposito;
import com.teste.stockinfo.model.Saque;
import com.teste.stockinfo.model.Usuario;
import com.teste.stockinfo.model.enums.TipoContaEnum;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.DepositoRepository;
import com.teste.stockinfo.repository.SaqueRepository;
import com.teste.stockinfo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class ContaService {


    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private SaqueRepository saqueRepository;

    public ResponseEntity<?> sacar(@PathVariable Conta idConta, @RequestBody Saque saque) {
        Conta c = contaRepository.getOne(idConta.getId());

        Date date = new Date();
        saque.setData(date);

        saque.setConta(c);

        if (saque.getTipoDeConta().equals(TipoContaEnum.Eventual)) {
            if (saque.getValor() <= c.getSaldoContaEventual()) {
                Double saldoAtual = c.getSaldoContaEventual();
                saldoAtual = saldoAtual - saque.getValor();

                c.setSaldoContaEventual(saldoAtual);

                contaRepository.save(c);
            } else {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Saldo insuficiente.");
            }
        } else if (saque.getTipoDeConta().equals(TipoContaEnum.Normal)) {
            if (saque.getValor() <= c.getSaldoContaNormal()) {
                Double saldoAtual = c.getSaldoContaNormal();
                saldoAtual = saldoAtual - saque.getValor();

                c.setSaldoContaNormal(saldoAtual);

                contaRepository.save(c);
            } else {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Saldo insuficiente.");
            }
        }

        saqueRepository.save(saque);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Saque efetuado com sucesso.");
    }

    public ResponseEntity<?> depositar(@PathVariable Conta idConta, @RequestBody Deposito deposito) {
        Conta c = contaRepository.getOne(idConta.getId());

        Date date = new Date();
        deposito.setData(date);

        deposito.setConta(c);

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

        depositoRepository.save(deposito);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Deposito efetuado com sucesso.");
    }

    public ResponseEntity<?> criarConta(@RequestBody Conta conta) {
        Conta novaConta = new Conta();
        Usuario usuario = usuarioRepository.getOne(conta.getUsuario().getId());


        if (contaRepository.findByUsuarioCpf(usuario.getCpf()) == null) {
            novaConta = contaRepository.save(conta);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Usuário já possui uma conta.");
        }

        return ResponseEntity.ok(novaConta);
    }
}
