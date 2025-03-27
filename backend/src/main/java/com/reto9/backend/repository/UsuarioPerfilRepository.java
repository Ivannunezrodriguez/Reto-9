package com.reto9.backend.repository;


import com.reto9.backend.model.UsuarioPerfil;
import com.reto9.backend.model.UsuarioPerfilId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilId> {
}
