package com.reto9.backend.controller;

import com.reto9.backend.dto.CategoriaDTO;
import com.reto9.backend.model.Categoria;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getAll() {
        return categoriaService.findAllDTO();
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping
    public Categoria actualizar(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int idCategoria) {
        categoriaService.deleteById(idCategoria);
    }
}
