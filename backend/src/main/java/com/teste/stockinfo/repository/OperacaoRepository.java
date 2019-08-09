package com.teste.stockinfo.repository;

import com.teste.stockinfo.model.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {


    List<Operacao> findAllByContaId(Long id);

}
