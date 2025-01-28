package com.espe.micro_libros.repositories;

import com.espe.micro_libros.model.entity.AutorLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorLibroRepository extends JpaRepository<AutorLibro, Long> {

    // Buscar por autorId
    List<AutorLibro> findByAutorId(Long autorId);

    // Buscar por libroId
    List<AutorLibro> findByLibroId(Long libroId);

    // Buscar por autorId y libroId
    AutorLibro findByAutorIdAndLibroId(Long autorId, Long libroId);

    // Eliminar todas las relaciones de un autor específico
    void deleteByAutorId(Long autorId);

    // Eliminar todas las relaciones de un libro específico
    void deleteByLibroId(Long libroId);
}
