package com.teste.stockinfo.repository;

import com.teste.stockinfo.model.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositoRepository extends JpaRepository<Deposito, Long> {
}
