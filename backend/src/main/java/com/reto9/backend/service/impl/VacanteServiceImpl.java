package com.reto9.backend.service.impl;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.repository.VacanteRepository;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacanteServiceImpl implements VacanteService {

    private final VacanteRepository vacanteRepository;

    @Override
    public VacanteDTO create(VacanteDTO dto) {
        Vacante vacante = toEntity(dto);
        vacante.setIdVacante(null);
        vacante.setEstatus(Vacante.EstatusVacante.CREADA);
        return toDTO(vacanteRepository.save(vacante));
    }

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

    @Override
    public void cancel(Integer id) {
        Vacante v = vacanteRepository.findById(id).orElseThrow();
        v.setEstatus(Vacante.EstatusVacante.CANCELADA);
        vacanteRepository.save(v);
    }

    @Override
    public List<VacanteDTO> findAll() {
        return vacanteRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VacanteDTO> findByEmpresa(Integer idEmpresa) {
        return vacanteRepository.findByIdEmpresa(idEmpresa).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VacanteDTO> findCreadas() {
        return vacanteRepository.findByEstatus(Vacante.EstatusVacante.CREADA).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VacanteDTO findById(Integer id) {
        return vacanteRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

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
