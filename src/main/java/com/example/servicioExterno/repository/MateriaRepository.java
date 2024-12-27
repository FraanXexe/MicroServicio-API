package com.example.servicioExterno.repository;

import com.example.servicioExterno.modelo.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>  {

    // Consulta personalizada para obtener las materias de un maestro por su ID
    @NativeQuery("select materia.id_materia , materia.nombre , materia.descripcion from maestro, maestro_materia, materia where id_maestro = maestro_id and id_materia = materia_id and id_maestro=:maestroId")
    List<Materia> findMateriasBymaestroId(@Param("maestroId") Long maestroId);

}
