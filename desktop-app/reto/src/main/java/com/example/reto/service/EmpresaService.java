package com.example.reto.service;

import com.example.reto.apiservice.ApiService;
import com.example.reto.model.Empresa;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaService {

    private static final String ENDPOINT = "/empresas";

    public static List<Empresa> obtenerTodas() throws IOException {
        String response = ApiService.get(ENDPOINT);
        JSONArray jsonArray = new JSONArray(response);
        List<Empresa> empresas = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            Empresa empresa = new Empresa(
                    obj.getString("nombre"),
                    obj.getString("cif"),
                    obj.getString("telefono")
            );
            empresa.setId(obj.getLong("id"));
            empresas.add(empresa);
        }

        return empresas;
    }

    public static Empresa guardar(Empresa empresa) throws IOException {
        JSONObject json = new JSONObject();
        json.put("nombre", empresa.getNombre());
        json.put("cif", empresa.getCif());
        json.put("telefono", empresa.getTelefono());

        String response = ApiService.post(ENDPOINT, json.toString());
        JSONObject obj = new JSONObject(response);
        empresa.setId(obj.getLong("id"));
        return empresa;
    }

    public static Empresa actualizar(Empresa empresa) throws IOException {
        JSONObject json = new JSONObject();
        json.put("nombre", empresa.getNombre());
        json.put("cif", empresa.getCif());
        json.put("telefono", empresa.getTelefono());

        String response = ApiService.put(ENDPOINT + "/" + empresa.getId(), json.toString());
        return empresa;
    }

    public static void eliminar(Long id) throws IOException {
        ApiService.delete(ENDPOINT + "/" + id);
    }
}



