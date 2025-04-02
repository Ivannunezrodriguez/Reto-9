package com.reto9.backend.controller;

import com.reto9.backend.dto.VacanteDTO;
import com.reto9.backend.model.Vacante;
import com.reto9.backend.service.VacanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacantes")
@RequiredArgsConstructor
public class VacanteController {

    private final VacanteService vacanteService;

    @GetMapping
    public List<VacanteDTO> getAll() {
        return vacanteService.findAllDTO();
    }

    @GetMapping("/estado/{estado}")
    public List<VacanteDTO> getByEstado(@PathVariable String estatus) {
        return vacanteService.findByEstado(estatus);
    }

    @PostMapping
    public Vacante crear(@RequestBody Vacante vacante) {
        return vacanteService.save(vacante);
    }

    @PutMapping
    public Vacante actualizar(@RequestBody Vacante vacante) {
        return vacanteService.save(vacante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int idVacante) {
        vacanteService.deleteById(idVacante);
    }

    @PutMapping("/asignar/{idVacante}/{username}")
    public void asignarVacante(@PathVariable int idVacante, @PathVariable String username) {
        vacanteService.asignarVacanteAUsuario(idVacante, username);
    }
}
