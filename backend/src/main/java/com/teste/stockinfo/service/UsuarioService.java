package com.teste.stockinfo.service;

import com.teste.stockinfo.model.Usuario;
import com.teste.stockinfo.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    public Usuario editarUsuario(Long id, Usuario usuario) {
        Usuario usuarioAtualizado = usuarioRepository.getOne(id);


        if (usuarioAtualizado == null) {
            throw new EmptyResultDataAccessException(1);
        } else {
            BeanUtils.copyProperties(usuario,usuarioAtualizado, "id, nomeCompleto, cpf, sexo, idade, dataDeNascimento");
        }
        return usuarioRepository.save(usuarioAtualizado);

    }
}
