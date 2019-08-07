package com.teste.stockinfo.repository;

import com.teste.stockinfo.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
