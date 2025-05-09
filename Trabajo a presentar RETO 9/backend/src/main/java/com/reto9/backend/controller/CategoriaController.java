package com.reto9.backend.controller;

import com.reto9.backend.dto.CategoriaDTO;
import com.reto9.backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de categorías.
 * Permite realizar operaciones CRUD sobre categorías, exclusivamente por usuarios con rol ADMIN.
 */
@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite acceso desde cualquier origen (útil para frontend en desarrollo)
public class CategoriaController {

    private final CategoriaService categoriaService;

    /**
     * Obtiene una lista de todas las categorías.
     * Accesible solo por usuarios con rol ADMIN.
     * @return Lista de objetos CategoriaDTO.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    /**
     * Obtiene los detalles de una categoría específica por su ID.
     * Accesible solo por ADMIN.
     * @param id ID de la categoría.
     * @return Objeto CategoriaDTO correspondiente.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    /**
     * Crea una nueva categoría.
     * Accesible solo por usuarios con rol ADMIN.
     * @param dto Objeto CategoriaDTO con los datos a registrar.
     * @return La categoría creada.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO dto) {
        return ResponseEntity.ok(categoriaService.save(dto));
    }

    /**
     * Actualiza una categoría existente según su ID.
     * Accesible solo por usuarios con rol ADMIN.
     * @param id ID de la categoría a actualizar.
     * @param dto Datos nuevos para la categoría.
     * @return Categoría actualizada.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @RequestBody CategoriaDTO dto) {
        return ResponseEntity.ok(categoriaService.update(id, dto));
    }

    /**
     * Elimina una categoría por ID.
     * Comentado por integridad referencial (dependencias en vacantes),
     * pero se incluye seguridad por si se habilita en el futuro.
     */
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id) {
//        categoriaService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
