// CategoriaController.java
package com.reto9.controller;

import com.reto9.dto.CategoriaDTO;
import com.reto9.dto.CategoriaRequestDTO;
import com.reto9.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaDTO getById(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public CategoriaDTO create(@Valid @RequestBody CategoriaRequestDTO dto) {
        return categoriaService.save(dto);
    }

    @PutMapping("/{id}")
    public CategoriaDTO update(@PathVariable Integer id, @Valid @RequestBody CategoriaRequestDTO dto) {
        return categoriaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaService.delete(id);
    }
}
