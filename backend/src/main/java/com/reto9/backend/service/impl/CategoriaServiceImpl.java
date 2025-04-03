package com.reto9.backend.service.impl;

import com.reto9.backend.dto.CategoriaDTO;
import com.reto9.backend.model.Categoria;
import com.reto9.backend.repository.CategoriaRepository;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO findById(Integer id) {
        return categoriaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public CategoriaDTO save(CategoriaDTO dto) {
        Categoria categoria = toEntity(dto);
        return toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO update(Integer id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        return toDTO(categoriaRepository.save(categoria));
    }

    @Override
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaDTO toDTO(Categoria c) {
        return CategoriaDTO.builder()
                .idCategoria(c.getIdCategoria())
                .nombre(c.getNombre())
                .descripcion(c.getDescripcion())
                .build();
    }

    private Categoria toEntity(CategoriaDTO dto) {
        return Categoria.builder()
                .idCategoria(dto.getIdCategoria())
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .build();
    }
}
