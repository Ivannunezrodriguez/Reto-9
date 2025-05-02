package com.example.reto.service;

import com.example.reto.apiservice.ApiService;
import com.example.reto.model.Categoria;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    private static final String ENDPOINT = "/categorias";

    public List<Categoria> obtenerTodas() throws IOException {
        String response = ApiService.get(ENDPOINT);
        JSONArray jsonArray = new JSONArray(response);
        List<Categoria> categorias = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            Categoria categoria = new Categoria();
            categoria.setId(obj.getLong("id"));
            categoria.setNombre(obj.getString("nombre"));
            categoria.setDescripcion(obj.getString("descripcion"));
            categorias.add(categoria);
        }

        return categorias;
    }

    public Categoria guardar(Categoria categoria) throws IOException {
        JSONObject body = new JSONObject();
        body.put("nombre", categoria.getNombre());
        body.put("descripcion", categoria.getDescripcion());

        String response = ApiService.post(ENDPOINT, body.toString());
        JSONObject obj = new JSONObject(response);

        categoria.setId(obj.getLong("id"));
        return categoria;
    }

    public Categoria actualizar(Categoria categoria) throws IOException {
        JSONObject body = new JSONObject();
        body.put("nombre", categoria.getNombre());
        body.put("descripcion", categoria.getDescripcion());

        String response = ApiService.put(ENDPOINT + "/" + categoria.getId(), body.toString());
        JSONObject obj = new JSONObject(response);

        categoria.setNombre(obj.getString("nombre"));
        categoria.setDescripcion(obj.getString("descripcion"));
        return categoria;
    }

    public void eliminar(Long id) throws IOException {
        ApiService.delete(ENDPOINT + "/" + id);
    }
}
