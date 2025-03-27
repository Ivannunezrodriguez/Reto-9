package com.reto9.backend.service.impl;


import com.reto9.backend.model.Usuario;
import com.reto9.backend.repository.UsuarioRepository;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(String id, Usuario usuario) {
        usuario.setUsername(id);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(String id) {
        usuarioRepository.deleteById(id);
    }
}
