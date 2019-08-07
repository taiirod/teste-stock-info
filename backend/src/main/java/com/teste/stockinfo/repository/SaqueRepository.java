package com.teste.stockinfo.repository;

import com.teste.stockinfo.model.Saque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaqueRepository extends JpaRepository<Saque, Long> {
}
