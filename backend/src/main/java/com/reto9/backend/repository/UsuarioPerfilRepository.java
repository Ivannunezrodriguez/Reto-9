package com.reto9.backend.repository;

import com.reto9.backend.model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Integer> {
    List<UsuarioPerfil> findByUsuarioUsername(String username);
}
