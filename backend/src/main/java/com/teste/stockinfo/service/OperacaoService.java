package com.teste.stockinfo.service;

import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Operacao;
import com.teste.stockinfo.model.enums.OperacaoEnum;
import com.teste.stockinfo.model.enums.TipoContaEnum;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class OperacaoService {


    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;

    public ResponseEntity<?> efetuarOperacao(@PathVariable Long idConta, @RequestBody Operacao operacao) {
        Conta c = contaRepository.getOne(idConta);

        Date date = new Date();
        operacao.setData(date);

        operacao.setConta(c);

        // OPERAÇÃO DE DEPOSITO
        if (operacao.getOperacao().equals(OperacaoEnum.Depositar)) {
            if (operacao.getTipoDeConta().equals(TipoContaEnum.Eventual)) {
                Double saldoAtual = c.getSaldoContaEventual();
                saldoAtual = saldoAtual + operacao.getValor();

                c.setSaldoContaEventual(saldoAtual);

                contaRepository.save(c);
            } else if (operacao.getTipoDeConta().equals(TipoContaEnum.Normal)) {
                Double saldoAtual = c.getSaldoContaNormal();
                saldoAtual = saldoAtual + operacao.getValor();

                c.setSaldoContaNormal(saldoAtual);

                contaRepository.save(c);
            }
        }
        // OPERAÇÃO DE SAQUE
        else if (operacao.getOperacao().equals(OperacaoEnum.Sacar)) {
            if (operacao.getTipoDeConta().equals(TipoContaEnum.Eventual)) {
                if (operacao.getValor() <= c.getSaldoContaEventual()) {
                    Double saldoAtual = c.getSaldoContaEventual();
                    saldoAtual = saldoAtual - operacao.getValor();

                    c.setSaldoContaEventual(saldoAtual);

                    contaRepository.save(c);
                } else {
                    return ResponseEntity
                            .status(HttpStatus.BAD_REQUEST)
                            .body("Saldo insuficiente.");
                }
            } else if (operacao.getTipoDeConta().equals(TipoContaEnum.Normal)) {
                if (operacao.getValor() <= c.getSaldoContaNormal()) {
                    Double saldoAtual = c.getSaldoContaNormal();
                    saldoAtual = saldoAtual - operacao.getValor();

                    c.setSaldoContaNormal(saldoAtual);

                    contaRepository.save(c);
                } else {
                    return ResponseEntity
                            .status(HttpStatus.BAD_REQUEST)
                            .body("Saldo insuficiente.");
                }
            }
        }

        operacaoRepository.save(operacao);

        return ResponseEntity.ok(operacao);
    }
}
