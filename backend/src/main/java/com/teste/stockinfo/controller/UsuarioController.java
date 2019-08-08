package com.teste.stockinfo.controller;

import com.teste.stockinfo.model.Usuario;
import com.teste.stockinfo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> novo(@Valid @RequestBody Usuario usuario) {

        Usuario novoUsuario = new Usuario();

        if (usuarioRepository.findByCpf(usuario.getCpf()) == null) {
            novoUsuario = usuarioRepository.save(usuario);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("CPF já cadastrado.");
        }

        return ResponseEntity.ok(novoUsuario);
    }
}
