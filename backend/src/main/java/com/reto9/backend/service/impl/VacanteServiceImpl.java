package com.reto9.backend.service.impl;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.model.EstatusVacante;
import com.reto9.backend.repository.SolicitudRepository;
import com.reto9.backend.repository.VacanteRepository;
import com.reto9.backend.repository.UsuarioRepository;
import com.reto9.backend.service.VacanteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VacanteServiceImpl implements VacanteService {

    private final VacanteRepository vacanteRepository;
    private final SolicitudRepository solicitudRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<VacanteDTO> findAllDTO() {
        return vacanteRepository.findAll().stream()
                .map(v -> {
                    VacanteDTO dto = new VacanteDTO();
                    dto.setIdVacante(v.getIdVacante());
                    dto.setSalario(v.getSalario());
                    dto.setDescripcion(v.getDescripcion());
                    dto.setImagenVacante(v.getImagenVacante());
                    dto.setNombre(v.getNombre());
                    dto.setEstatus(v.getEstatus());
                    dto.setIdEmpresa(v.getEmpresa().getIdEmpresa());
                    dto.setIdCategoria(v.getCategoria().getIdCategoria());
                    dto.setDestacado(v.getDestacado());
                    dto.setFecha(v.getFecha());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<VacanteDTO> findByEstado(String estado) {
        return vacanteRepository.findByEstado(estado).stream()
                .map(v -> {
                    VacanteDTO dto = new VacanteDTO();
                    dto.setIdVacante(v.getIdVacante());
                    dto.setDescripcion(v.getDescripcion());
                    dto.setSalario(v.getSalario());

                    dto.setImagenVacante(v.getImagenVacante());
                    dto.setNombre(v.getNombre());
                    dto.setEstatus(v.getEstatus());
                    dto.setIdEmpresa(v.getEmpresa().getIdEmpresa());
                    dto.setIdCategoria(v.getCategoria().getIdCategoria());
                    dto.setDestacado(v.getDestacado());
                    dto.setFecha(v.getFecha());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Vacante> findAll() {
        return vacanteRepository.findAll();
    }

    @Override
    public Optional<Vacante> findById(int idVacante) {
        return vacanteRepository.findById(idVacante);
    }

    @Override
    public Vacante save(Vacante vacante) {
        return vacanteRepository.save(vacante);
    }

    @Override
    public void deleteById(int idVacante) {
        vacanteRepository.deleteById(idVacante);
    }

    @Override
    @Transactional
    public void asignarVacanteAUsuario(int idVacante, String username) {
        Vacante vacante = vacanteRepository.findById(idVacante)
                .orElseThrow(() -> new RuntimeException("Vacante no encontrada"));

        vacante.setEstatus(EstatusVacante.ASIGNADA); // ✅ enum, no string
        vacanteRepository.save(vacante);

        solicitudRepository.findByVacanteIdAndUsuarioUsername(idVacante, username)
                .ifPresent(solicitud -> {
                    solicitud.setEstado("1");
                    solicitudRepository.save(solicitud);
                });
    }
}
