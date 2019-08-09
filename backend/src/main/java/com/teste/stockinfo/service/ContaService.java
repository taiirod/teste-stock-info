package com.teste.stockinfo.service;

import com.teste.stockinfo.model.Conta;
import com.teste.stockinfo.model.Operacao;
import com.teste.stockinfo.model.Usuario;
import com.teste.stockinfo.model.enums.TipoContaEnum;
import com.teste.stockinfo.repository.ContaRepository;
import com.teste.stockinfo.repository.OperacaoRepository;
import com.teste.stockinfo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Service
public class ContaService {


    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private OperacaoRepository operacaoRepository;


    public ResponseEntity<?> criarConta(@RequestBody Conta conta) {
        Conta novaConta = new Conta();
        Usuario usuario = usuarioRepository.getOne(conta.getUsuario().getId());


        if (contaRepository.findByUsuarioCpf(usuario.getCpf()) == null) {
            novaConta = contaRepository.save(conta);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Usuário já possui uma conta.");
        }

        return ResponseEntity.ok(novaConta);
    }
}
