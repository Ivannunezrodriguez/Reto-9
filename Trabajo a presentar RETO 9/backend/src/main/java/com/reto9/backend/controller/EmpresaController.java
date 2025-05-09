package com.reto9.backend.controller;

import com.reto9.backend.dto.EmpresaDTO;
import com.reto9.backend.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de empresas.
 * Todas las operaciones están restringidas al rol ADMIN.
 */
@RestController
@RequestMapping("/api/empresas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Permite acceso desde cualquier frontend (útil durante desarrollo)
public class EmpresaController {

    private final EmpresaService empresaService;

    /**
     * Obtiene una lista de todas las empresas registradas en el sistema.
     * Solo accesible por el rol ADMIN.
     * @return Lista de objetos EmpresaDTO.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> getAll() {
        return ResponseEntity.ok(empresaService.findAll());
    }

    /**
     * Obtiene los detalles de una empresa específica por su ID.
     * Solo accesible por el rol ADMIN.
     * @param id ID de la empresa.
     * @return Objeto EmpresaDTO correspondiente.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(empresaService.findById(id));
    }

    /**
     * Crea una nueva empresa en el sistema.
     * Solo accesible por el rol ADMIN.
     * @param dto Datos de la nueva empresa.
     * @return Objeto EmpresaDTO creado.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<EmpresaDTO> create(@RequestBody EmpresaDTO dto) {
        return ResponseEntity.ok(empresaService.save(dto));
    }

    /**
     * Actualiza los datos de una empresa existente.
     * Solo accesible por el rol ADMIN.
     * @param id ID de la empresa a actualizar.
     * @param dto Nuevos datos de la empresa.
     * @return Objeto EmpresaDTO actualizado.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDTO> update(@PathVariable Integer id, @RequestBody EmpresaDTO dto) {
        return ResponseEntity.ok(empresaService.update(id, dto));
    }

    /**
     * Elimina una empresa por su ID.
     * Solo accesible por el rol ADMIN.
     * @param id ID de la empresa a eliminar.
     * @return Respuesta sin contenido.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
