package com.reto9.backend.service.impl;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.model.Empresa;
import com.reto9.backend.repository.EmpresaRepository;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de la interfaz EmpresaService.
 * Se encarga de la lógica de negocio relacionada con las entidades Empresa.
 */
@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    // Repositorio JPA para operaciones con la entidad Empresa
    private final EmpresaRepository empresaRepository;

    /**
     * Obtiene todas las empresas registradas.
     * @return lista de objetos EmpresaDTO
     */
    @Override
    public List<EmpresaDTO> findAll() {
        return empresaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca una empresa por su ID.
     * @param id identificador único de la empresa
     * @return EmpresaDTO si existe, si no null
     */
    @Override
    public EmpresaDTO findById(Integer id) {
        return empresaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    /**
     * Crea una nueva empresa en el sistema.
     * @param dto datos de la empresa
     * @return EmpresaDTO creada
     */
    @Override
    public EmpresaDTO save(EmpresaDTO dto) {
        Empresa empresa = toEntity(dto);
        return toDTO(empresaRepository.save(empresa));
    }

    /**
     * Actualiza una empresa existente.
     * @param id identificador de la empresa
     * @param dto nuevos datos para actualizar
     * @return EmpresaDTO actualizada
     */
    @Override
    public EmpresaDTO update(Integer id, EmpresaDTO dto) {
        Empresa empresa = empresaRepository.findById(id).orElseThrow();
        empresa.setRazonSocial(dto.getRazonSocial());
        empresa.setDireccionFiscal(dto.getDireccionFiscal());
        empresa.setPais(dto.getPais());
        return toDTO(empresaRepository.save(empresa));
    }

    /**
     * Elimina una empresa por su ID.
     * @param id identificador de la empresa
     */
    @Override
    public void delete(Integer id) {
        empresaRepository.deleteById(id);
    }

    /**
     * Convierte una entidad Empresa a un DTO.
     * @param e entidad Empresa
     * @return DTO correspondiente
     */
    private EmpresaDTO toDTO(Empresa e) {
        return EmpresaDTO.builder()
                .idEmpresa(e.getIdEmpresa())
                .razonSocial(e.getRazonSocial())
                .direccionFiscal(e.getDireccionFiscal())
                .pais(e.getPais())
                .build();
    }

    /**
     * Convierte un DTO a una entidad Empresa.
     * @param dto objeto EmpresaDTO
     * @return entidad Empresa
     */
    private Empresa toEntity(EmpresaDTO dto) {
        return Empresa.builder()
                .idEmpresa(dto.getIdEmpresa())
                .razonSocial(dto.getRazonSocial())
                .direccionFiscal(dto.getDireccionFiscal())
                .pais(dto.getPais())
                .build();
    }
}
