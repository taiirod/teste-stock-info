package com.teste.stockinfo.controller;

import com.teste.stockinfo.DepositoDTO;
import com.teste.stockinfo.model.Deposito;
import com.teste.stockinfo.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deposito")
public class DepositoController {

    @Autowired
    private DepositoRepository depositoRepository;

    private DepositoDTO depositoDTO = new DepositoDTO();

    @GetMapping
    public List<DepositoDTO> todosDepositos() {
        List<Deposito> depositosList = depositoRepository.findAll();
        List<DepositoDTO> listTreated = new ArrayList<>();


        for (Deposito d : depositosList) {

            depositoDTO.setValor(d.getValor());
            depositoDTO.setConta(d.getConta().getUsuario().getNomeCompleto());
            depositoDTO.setData(d.getData());
            depositoDTO.setTipoDeConta(d.getTipoDeConta().name());

            listTreated.add(depositoDTO);
        }

        return listTreated;

    }
}
