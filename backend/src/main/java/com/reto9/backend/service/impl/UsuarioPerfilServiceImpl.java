package com.reto9.backend.service.impl;

import com.reto9.backend.dto.UsuarioPerfilDTO;
import com.reto9.backend.model.UsuarioPerfil;
import com.reto9.backend.repository.PerfilRepository;
import com.reto9.backend.repository.UsuarioPerfilRepository;
import com.reto9.backend.service.UsuarioPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio que gestiona las relaciones entre usuarios y perfiles (roles).
 * Este servicio permite asignar perfiles a usuarios, eliminarlos y consultarlos.
 */
@Service
@RequiredArgsConstructor
public class UsuarioPerfilServiceImpl implements UsuarioPerfilService {

    private final UsuarioPerfilRepository usuarioPerfilRepository;
    private final PerfilRepository perfilRepository;

    /**
     * Obtiene todas las asignaciones de perfil-usuario.
     * @return Lista de UsuarioPerfilDTO
     */
    @Override
    public List<UsuarioPerfilDTO> findAll() {
        return usuarioPerfilRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca todos los perfiles asignados a un usuario específico.
     * @param username Nombre del usuario
     * @return Lista de UsuarioPerfilDTO asignados al usuario
     */
    @Override
    public List<UsuarioPerfilDTO> findByUsername(String username) {
        return usuarioPerfilRepository.findByUsername(username).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Asigna un perfil a un usuario.
     * @param dto Objeto DTO con datos de asignación
     * @return UsuarioPerfilDTO persistido
     */
    @Override
    public UsuarioPerfilDTO save(UsuarioPerfilDTO dto) {
        return toDTO(usuarioPerfilRepository.save(toEntity(dto)));
    }

    /**
     * Elimina una asignación de perfil-usuario por su ID.
     * @param id ID de la asignación
     */
    @Override
    public void delete(Integer id) {
        usuarioPerfilRepository.deleteById(id);
    }

    /**
     * Convierte una entidad UsuarioPerfil a su DTO.
     * @param u Entidad UsuarioPerfil
     * @return DTO correspondiente
     */
    private UsuarioPerfilDTO toDTO(UsuarioPerfil u) {
        return UsuarioPerfilDTO.builder()
                .idUsuarioPerfil(u.getIdUsuarioPerfil())
                .username(u.getUsername())
                .idPerfil(u.getPerfil().getIdPerfil()) // se extrae el ID del objeto Perfil
                .build();
    }

    /**
     * Convierte un DTO a una entidad UsuarioPerfil.
     * @param dto DTO a convertir
     * @return Entidad correspondiente
     */
    private UsuarioPerfil toEntity(UsuarioPerfilDTO dto) {
        return UsuarioPerfil.builder()
                .idUsuarioPerfil(dto.getIdUsuarioPerfil())
                .username(dto.getUsername())
                .perfil(perfilRepository.findById(dto.getIdPerfil()).orElse(null)) // se busca el perfil completo desde el repositorio
                .build();
    }

}
