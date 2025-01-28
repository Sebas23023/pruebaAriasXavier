package com.espe.micro_autor.repositories;

import com.espe.micro_autor.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Buscar autor por nombre
    List<Autor> findByNombre(String nombre);

    // Buscar autores por apellido
    List<Autor> findByApellido(String apellido);

    // Buscar autores por nacionalidad
    List<Autor> findByNacionalidad(String nacionalidad);

    // Buscar autores nacidos después de una fecha específica
    List<Autor> findByFechaNacimientoAfter(Date fecha);

    // Buscar autores cuya biografía contenga un texto específico
    List<Autor> findByBiografiaContaining(String texto);
}
