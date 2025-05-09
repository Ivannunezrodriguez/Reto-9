package com.example.retobackend.service;

import com.example.retobackend.model.Administrador;
import com.example.retobackend.repository.AdministradorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository repository;

    public AdministradorServiceImpl(AdministradorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Administrador> findAll() {
        return repository.findAll();
    }

    @Override
    public Administrador findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Administrador save(Administrador administrador) {
        return repository.save(administrador);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
