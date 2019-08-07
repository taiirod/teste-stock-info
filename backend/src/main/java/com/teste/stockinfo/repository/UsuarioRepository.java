package com.teste.stockinfo.repository;

import com.teste.stockinfo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}