package com.teste.stockinfo.controller;

import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Usuario;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.getOne(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public List<Usuario> buscarTodos() {
        List<Usuario> list = usuarioRepository.findAll();
        return list;
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

        Conta conta = new Conta();

        conta.setUsuario(novoUsuario);

        Conta c = contaRepository.save(conta);



        return ResponseEntity.ok(novoUsuario);
    }
}
