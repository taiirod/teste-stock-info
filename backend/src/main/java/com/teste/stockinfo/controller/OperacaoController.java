package com.teste.stockinfo.controller;

import com.teste.stockinfo.dto.OperacaoDTO;
import com.teste.stockinfo.dto.OperacaoDTO;
import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Operacao;
import com.teste.stockinfo.repository.OperacaoRepository;
import com.teste.stockinfo.service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    private OperacaoRepository operacaoRepository;

    @Autowired
    private OperacaoService operacaoService;

    @GetMapping("/todas")
    public List<?> todasOperacoes() {
        List<Operacao> operacaoList = operacaoRepository.findAll();
        List<OperacaoDTO> listTreated = new ArrayList<>();


        for (Operacao d : operacaoList) {

            OperacaoDTO operacaoDTO = new OperacaoDTO();

            operacaoDTO.setConta(d.getConta().getId());
            operacaoDTO.setTipoDeConta(d.getTipoDeConta().name());
            operacaoDTO.setValor(d.getValor());
            operacaoDTO.setData(d.getData());
            operacaoDTO.setOperacao(d.getOperacao());

            listTreated.add(operacaoDTO);
        }

        return listTreated;

    }

    @GetMapping("/{id}")
    public List<OperacaoDTO> todasOperacoesPorIdConta(@PathVariable Long id){
        List<Operacao> saqueList = operacaoRepository.findAllByContaId(id);
        List<OperacaoDTO> listTreated = new ArrayList<>();


        for (Operacao d : saqueList) {

            OperacaoDTO operacaoDTO = new OperacaoDTO();

            operacaoDTO.setConta(d.getConta().getId());
            operacaoDTO.setTipoDeConta(d.getTipoDeConta().name());
            operacaoDTO.setValor(d.getValor());
            operacaoDTO.setData(d.getData());
            operacaoDTO.setOperacao(d.getOperacao());


            listTreated.add(operacaoDTO);
        }

        return listTreated;
    }

    @PutMapping("/{idConta}")
    public ResponseEntity<?> efetuarOperacao(@PathVariable Long idConta, @RequestBody Operacao deposito) {
        return operacaoService.efetuarOperacao(idConta, deposito);
    }
}
