package com.example.servicioExterno.controller;


import com.example.servicioExterno.modelo.Materia;
import com.example.servicioExterno.service.MaestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/maestros") // Define la ruta de busqueda
public class MaestroController {

    @Autowired // Inyección
    private MaestroService maestroService;

    // Endpoint para obtener las materias de un maestro por su ID
    @GetMapping("/materias/{id}")
    public ResponseEntity<List<Materia>> obtenerMateriasPorMaestroId(@PathVariable("id") Long maestroId) {
        List<Materia> materias = maestroService.obtenerMateriasPorMaestroId(maestroId);
        if (materias.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no tiene materias
        }
        return ResponseEntity.ok(materias); // Retorna 200 OK con las materias
    }
}
