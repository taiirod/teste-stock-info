package com.teste.stockinfo.controller;

import com.teste.stockinfo.dto.SaqueDTO;
import com.teste.stockinfo.model.Saque;
import com.teste.stockinfo.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/saque")
public class SaqueController {

    @Autowired
    private SaqueRepository saqueRepository;

    private SaqueDTO saqueDTO = new SaqueDTO();

    @GetMapping
    public List<SaqueDTO> todosSaques() {
        List<Saque> saqueList = saqueRepository.findAll();
        List<SaqueDTO> listTreated = new ArrayList<>();


        for (Saque d : saqueList) {

            saqueDTO.setConta(d.getConta().getId());
            saqueDTO.setTipoDeConta(d.getTipoDeConta().name());
            saqueDTO.setValor(d.getValor());
            saqueDTO.setData(d.getData());

            listTreated.add(saqueDTO);
        }

        return listTreated;
    }


}
