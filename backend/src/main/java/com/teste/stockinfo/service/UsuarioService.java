package com.teste.stockinfo.service;

import com.teste.stockinfo.model.Usuario;
import com.teste.stockinfo.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    /*public ResponseEntity<Usuario> editarUsuario(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(resp -> {
            resp.setEmail(usuario.getEmail());
            resp.setTelefone(usuario.getEmail());
            resp.setEndereco(usuario.getEndereco());
            Usuario usuarioAtualizado = usuarioRepository.save(resp);
            return ResponseEntity.ok().body(usuarioAtualizado);

        });
    }*/
}
