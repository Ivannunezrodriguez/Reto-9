package com.example.reto.service;

import com.example.reto.apiservice.ApiService;
import com.example.reto.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class UsuarioService {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Usuario> getAll() throws Exception {
        String response = ApiService.get("/usuarios");
        return mapper.readValue(response, new TypeReference<List<Usuario>>() {});
    }

    public static void create(Usuario usuario) throws Exception {
        String json = mapper.writeValueAsString(usuario);
        ApiService.post("/usuarios", json);
    }

    public static void update(Usuario usuario) throws Exception {
        String json = mapper.writeValueAsString(usuario);
        ApiService.put("/usuarios/" + usuario.getId(), json);
    }

    public static void delete(Long id) throws Exception {
        ApiService.delete("/usuarios/" + id);
    }
}
