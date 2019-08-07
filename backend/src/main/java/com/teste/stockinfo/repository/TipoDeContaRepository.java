package com.teste.stockinfo.repository;

import com.teste.stockinfo.model.TipoDeConta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDeContaRepository extends JpaRepository<TipoDeConta, Long> {
}
