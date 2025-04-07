package com.reto9.backend.service.impl;

import com.reto9.backend.dto.UsuarioDTO;
import com.reto9.backend.model.Usuario;
import com.reto9.backend.repository.UsuarioRepository;
import com.reto9.backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de usuarios.
 * Contiene la lógica para gestionar operaciones CRUD y la desactivación de usuarios.
 */
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Recupera todos los usuarios del sistema.
     * @return Lista de objetos UsuarioDTO
     */
    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca un usuario por su nombre de usuario (username).
     * @param username Identificador del usuario
     * @return UsuarioDTO si existe, o null en caso contrario
     */
    @Override
    public UsuarioDTO findByUsername(String username) {
        return usuarioRepository.findById(username)
                .map(this::toDTO)
                .orElse(null);
    }

    /**
     * Crea un nuevo usuario en el sistema.
     * @param dto Objeto DTO con la información del usuario
     * @return UsuarioDTO guardado
     */
    @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario usuario = toEntity(dto);
        return toDTO(usuarioRepository.save(usuario));
    }

    /**
     * Actualiza la información de un usuario existente.
     * @param username Identificador del usuario
     * @param dto Datos a actualizar
     * @return UsuarioDTO actualizado
     */
    @Override
    public UsuarioDTO update(String username, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(username).orElseThrow();
        usuario.setNombre(dto.getNombre());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEmail(dto.getEmail());
        usuario.setEnabled(dto.getEnabled());
        usuario.setFechaRegistro(dto.getFechaRegistro());
        return toDTO(usuarioRepository.save(usuario));
    }

    /**
     * Desactiva un usuario (no lo elimina físicamente).
     * Cambia su estado "enabled" a 0.
     * @param username Usuario a desactivar
     */
    @Override
    public void disable(String username) {
        Usuario usuario = usuarioRepository.findById(username).orElseThrow();
        usuario.setEnabled(0);
        usuarioRepository.save(usuario);
    }

    /**
     * Convierte un objeto Usuario a UsuarioDTO.
     * @param u Entidad Usuario
     * @return DTO correspondiente
     */
    private UsuarioDTO toDTO(Usuario u) {
        return UsuarioDTO.builder()
                .username(u.getUsername())
                .nombre(u.getNombre())
                .apellidos(u.getApellidos())
                .email(u.getEmail())
                .enabled(u.getEnabled())
                .fechaRegistro(u.getFechaRegistro())
                .build();
    }

    /**
     * Convierte un objeto UsuarioDTO a entidad Usuario.
     * @param dto DTO recibido
     * @return Entidad Usuario
     */
    private Usuario toEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .username(dto.getUsername())
                .nombre(dto.getNombre())
                .apellidos(dto.getApellidos())
                .email(dto.getEmail())
                .enabled(dto.getEnabled())
                .fechaRegistro(dto.getFechaRegistro())
                .build();
    }
}
