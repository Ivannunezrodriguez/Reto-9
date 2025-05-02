package com.example.reto.service;

import com.example.reto.apiservice.ApiService;
import com.example.reto.model.Administrador;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class AdministradorService {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Administrador> getAllAdministradores() throws Exception {
        String response = ApiService.get("/administradores");
        return mapper.readValue(response, new TypeReference<List<Administrador>>() {});
    }

    public static void addAdministrador(Administrador administrador) throws Exception {
        String json = mapper.writeValueAsString(administrador);
        ApiService.post("/administradores", json);
    }

    public static void updateAdministrador(Administrador administrador) throws Exception {
        String json = mapper.writeValueAsString(administrador);
        ApiService.put("/administradores/" + administrador.getId(), json);
    }

    public static void deleteAdministrador(Long id) throws Exception {
        ApiService.delete("/administradores/" + id);
    }
}
