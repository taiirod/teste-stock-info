package com.teste.stockinfo.service;

import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Deposito;
import com.teste.stockinfo.model.Saque;
import com.teste.stockinfo.model.enums.TipoContaEnum;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.DepositoRepository;
import com.teste.stockinfo.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DepositoRepository depositoRepository;

    @Autowired
    private SaqueRepository saqueRepository;

    public ResponseEntity<Conta> sacar(@PathVariable Conta idConta, @RequestBody Saque saque) {
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
            }
        } else if (saque.getTipoDeConta().equals(TipoContaEnum.Normal)) {
            if (saque.getValor() <= c.getSaldoContaNormal()) {
                Double saldoAtual = c.getSaldoContaNormal();
                saldoAtual = saldoAtual - saque.getValor();

                c.setSaldoContaNormal(saldoAtual);

                contaRepository.save(c);
            }
        }

        saqueRepository.save(saque);

        return ResponseEntity.ok(c);
    }

    public ResponseEntity<Conta> depositar(@PathVariable Conta idConta, @RequestBody Deposito deposito) {
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

        return ResponseEntity.ok(c);
    }
}
