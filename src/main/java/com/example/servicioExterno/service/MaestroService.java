package com.example.servicioExterno.service;

import com.example.servicioExterno.modelo.Materia;
import com.example.servicioExterno.repository.MateriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaestroService {

    @Autowired
    private final MateriaRepository materiaRepository;

    public MaestroService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }


    // Metodo para seleccionar materias por ID de maestro
    public List<Materia> obtenerMateriasPorMaestroId(Long maestroId) {
        return materiaRepository.findMateriasBymaestroId(maestroId);
    }

}
