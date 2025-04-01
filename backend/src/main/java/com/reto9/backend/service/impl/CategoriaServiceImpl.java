package com.reto9.backend.service.impl;

import com.reto9.backend.dto.CategoriaDTO;
import com.reto9.backend.model.Categoria;
import com.reto9.backend.repository.CategoriaRepository;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> getAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(c -> new CategoriaDTO(
                        c.getId(),
                        c.getNombre(),
                        c.getDescripcion()
                ))
                .toList();
    }
}
