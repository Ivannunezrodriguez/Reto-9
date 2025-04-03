package com.reto9.backend.service.impl;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.repository.VacanteRepository;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación del servicio de Vacantes.
 * Proporciona las operaciones CRUD y funciones específicas de negocio como creación, cancelación o filtrado por estado o empresa.
 */
@Service
@RequiredArgsConstructor
public class VacanteServiceImpl implements VacanteService {

    private final VacanteRepository vacanteRepository;

    /**
     * Crea una nueva vacante en estado "CREADA".
     * @param dto Objeto con los datos de la vacante a registrar.
     * @return VacanteDTO registrada.
     */
    @Override
    public VacanteDTO create(VacanteDTO dto) {
        Vacante vacante = toEntity(dto);
        vacante.setIdVacante(null); // Forzamos creación
        vacante.setEstatus(Vacante.EstatusVacante.CREADA); // Estado inicial
        return toDTO(vacanteRepository.save(vacante));
    }

    /**
     * Actualiza los datos de una vacante existente.
     * @param id ID de la vacante.
     * @param dto Objeto con los nuevos datos.
     * @return VacanteDTO actualizada.
     */
    @Override
    public VacanteDTO update(Integer id, VacanteDTO dto) {
        Vacante v = vacanteRepository.findById(id).orElseThrow();
        v.setNombre(dto.getNombre());
        v.setDescripcion(dto.getDescripcion());
        v.setFecha(dto.getFecha());
        v.setSalario(dto.getSalario());
        v.setImagen(dto.getImagen());
        v.setDestacado(dto.isDestacado());
        v.setDetalles(dto.getDetalles());
        v.setIdCategoria(dto.getIdCategoria());
        return toDTO(vacanteRepository.save(v));
    }

    /**
     * Cancela una vacante cambiando su estado a "CANCELADA".
     * @param id ID de la vacante a cancelar.
     */
    @Override
    public void cancel(Integer id) {
        Vacante v = vacanteRepository.findById(id).orElseThrow();
        v.setEstatus(Vacante.EstatusVacante.CANCELADA);
        vacanteRepository.save(v);
    }

    /**
     * Recupera todas las vacantes del sistema.
     * @return Lista de VacanteDTO.
     */
    @Override
    public List<VacanteDTO> findAll() {
        return vacanteRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recupera todas las vacantes asociadas a una empresa.
     * @param idEmpresa ID de la empresa.
     * @return Lista de vacantes de la empresa.
     */
    @Override
    public List<VacanteDTO> findByEmpresa(Integer idEmpresa) {
        return vacanteRepository.findByIdEmpresa(idEmpresa).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recupera todas las vacantes que están en estado "CREADA".
     * @return Lista de vacantes disponibles para usuarios.
     */
    @Override
    public List<VacanteDTO> findCreadas() {
        return vacanteRepository.findByEstatus(Vacante.EstatusVacante.CREADA).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca una vacante por su ID.
     * @param id ID de la vacante.
     * @return VacanteDTO correspondiente o null si no existe.
     */
    @Override
    public VacanteDTO findById(Integer id) {
        return vacanteRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    /**
     * Convierte una entidad Vacante a DTO.
     * @param v Entidad Vacante.
     * @return DTO correspondiente.
     */
    private VacanteDTO toDTO(Vacante v) {
        return VacanteDTO.builder()
                .idVacante(v.getIdVacante())
                .nombre(v.getNombre())
                .descripcion(v.getDescripcion())
                .fecha(v.getFecha())
                .salario(v.getSalario())
                .estatus(v.getEstatus().name())
                .destacado(Boolean.TRUE.equals(v.getDestacado()))
                .imagen(v.getImagen())
                .detalles(v.getDetalles())
                .idCategoria(v.getIdCategoria())
                .idEmpresa(v.getIdEmpresa())
                .build();
    }

    /**
     * Convierte un DTO a entidad Vacante.
     * @param dto Objeto DTO con los datos de entrada.
     * @return Entidad Vacante construida.
     */
    private Vacante toEntity(VacanteDTO dto) {
        return Vacante.builder()
                .idVacante(dto.getIdVacante())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .fecha(dto.getFecha())
                .salario(dto.getSalario())
                .estatus(Vacante.EstatusVacante.valueOf(dto.getEstatus()))
                .destacado(dto.isDestacado())
                .imagen(dto.getImagen())
                .detalles(dto.getDetalles())
                .idCategoria(dto.getIdCategoria())
                .idEmpresa(dto.getIdEmpresa())
                .build();
    }
}
