package com.teste.stockinfo.controller;

import com.teste.stockinfo.dto.OperacaoDTO;
import com.teste.stockinfo.dto.OperacaoDTO;
import com.teste.stockinfo.model.Operacao;
import com.teste.stockinfo.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {

    @Autowired
    private OperacaoRepository operacaoRepository;

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
}
