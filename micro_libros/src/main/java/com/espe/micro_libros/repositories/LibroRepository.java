package com.espe.micro_libros.repositories;

import com.espe.micro_libros.model.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Buscar libros por título
    List<Libro> findByTitulo(String titulo);

    // Buscar libros cuyo título contenga un texto específico
    List<Libro> findByTituloContaining(String texto);

    // Buscar libros publicados después de una fecha específica
    List<Libro> findByFechaPublicacionAfter(Date fecha);

    // Buscar libros por género
    List<Libro> findByGenero(String genero);

    // Buscar libros por nombre del autor
    List<Libro> findByAutor_Nombre(String nombre);

    // Buscar libros por nombre del autor y género
    List<Libro> findByAutor_NombreAndGenero(String nombre, String genero);

    // Buscar libros por ID del autor
    List<Libro> findByAutor_Id(Long autorId);
}
