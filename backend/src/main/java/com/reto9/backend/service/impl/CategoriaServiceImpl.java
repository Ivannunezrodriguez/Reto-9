package com.reto9.backend.service.impl;

import com.reto9.backend.dto.CategoriaDTO;
import com.reto9.backend.model.Categoria;
import com.reto9.backend.repository.CategoriaRepository;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> findAllDTO() {
        return categoriaRepository.findAll().stream()
                .map(c -> new CategoriaDTO(
                        c.getIdCategoria(),
                        c.getNombre(),
                        c.getDescripcion()))
                .collect(Collectors.toList());
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> findById(int idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    @Override
    public void deleteById(int idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}
