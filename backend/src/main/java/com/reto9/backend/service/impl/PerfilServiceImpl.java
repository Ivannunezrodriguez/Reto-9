package com.reto9.backend.service.impl;

import com.reto9.backend.dto.PerfilDTO;
import com.reto9.backend.model.Perfil;
import com.reto9.backend.repository.PerfilRepository;
import com.reto9.backend.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio PerfilService.
 * Encargado de manejar la lógica de negocio relacionada con los perfiles de usuario.
 */
@Service
@RequiredArgsConstructor
public class PerfilServiceImpl implements PerfilService {

    // Repositorio JPA para la entidad Perfil
    private final PerfilRepository perfilRepository;

    /**
     * Obtiene todos los perfiles existentes en el sistema.
     * @return Lista de objetos PerfilDTO
     */
    @Override
    public List<PerfilDTO> findAll() {
        return perfilRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca un perfil por su ID.
     * @param id ID del perfil
     * @return PerfilDTO correspondiente si existe, o null si no se encuentra
     */
    @Override
    public PerfilDTO findById(Integer id) {
        return perfilRepository.findById(id).map(this::toDTO).orElse(null);
    }

    /**
     * Guarda un nuevo perfil en la base de datos.
     * @param dto Datos del perfil a guardar
     * @return PerfilDTO guardado
     */
    @Override
    public PerfilDTO save(PerfilDTO dto) {
        return toDTO(perfilRepository.save(toEntity(dto)));
    }

    /**
     * Actualiza un perfil existente.
     * @param id ID del perfil a actualizar
     * @param dto Datos nuevos del perfil
     * @return PerfilDTO actualizado
     */
    @Override
    public PerfilDTO update(Integer id, PerfilDTO dto) {
        Perfil perfil = perfilRepository.findById(id).orElseThrow();
        perfil.setNombre(dto.getNombre());
        return toDTO(perfilRepository.save(perfil));
    }

    /**
     * Elimina un perfil por su ID.
     * @param id ID del perfil a eliminar
     */
    @Override
    public void delete(Integer id) {
        perfilRepository.deleteById(id);
    }

    /**
     * Convierte una entidad Perfil a un DTO.
     * @param perfil Entidad Perfil
     * @return PerfilDTO resultante
     */
    private PerfilDTO toDTO(Perfil perfil) {
        return PerfilDTO.builder()
                .idPerfil(perfil.getIdPerfil())
                .nombre(perfil.getNombre())
                .build();
    }

    /**
     * Convierte un DTO a una entidad Perfil.
     * @param dto Objeto PerfilDTO
     * @return Entidad Perfil
     */
    private Perfil toEntity(PerfilDTO dto) {
        return Perfil.builder()
                .idPerfil(dto.getIdPerfil())
                .nombre(dto.getNombre())
                .build();
    }
}
