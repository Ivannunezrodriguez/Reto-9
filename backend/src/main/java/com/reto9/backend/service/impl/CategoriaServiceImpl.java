// CategoriaServiceImpl.java
package com.reto9.service;

import com.reto9.dto.CategoriaDTO;
import com.reto9.dto.CategoriaRequestDTO;
import com.reto9.model.Categoria;
import com.reto9.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private CategoriaDTO convertToDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        return dto;
    }

    private Categoria convertToEntity(CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        return categoria;
    }

    @Override
    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO findById(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
        return convertToDTO(categoria);
    }

    @Override
    public CategoriaDTO save(CategoriaRequestDTO dto) {
        Categoria categoria = convertToEntity(dto);
        return convertToDTO(categoriaRepository.save(categoria));
    }

    @Override
    public CategoriaDTO update(Integer id, CategoriaRequestDTO dto) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Categoría no encontrada con id: " + id);
        }

        Categoria categoria = optional.get();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());

        return convertToDTO(categoriaRepository.save(categoria));
    }

    @Override
    public void delete(Integer id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada con id: " + id);
        }
        categoriaRepository.deleteById(id);
    }
}
