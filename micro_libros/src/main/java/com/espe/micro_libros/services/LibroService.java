package com.espe.micro_libros.services;

import com.espe.micro_libros.model.entity.Libro;

import java.util.Date;
import java.util.List;

public interface LibroService {

    // Método para listar todos los libros
    List<Libro> listarTodos();

    // Método para guardar un libro
    Libro guardarLibro(Libro libro);

    // Método para obtener un libro por su ID
    Libro obtenerPorId(Long id);

    // Método para eliminar un libro por su ID
    void eliminarPorId(Long id);

    // Métodos adicionales para búsquedas personalizadas
    List<Libro> buscarPorTitulo(String titulo);

    // Buscar libros por el nombre del autor
    List<Libro> buscarPorAutorNombre(String nombre);

    // Buscar libros por género
    List<Libro> buscarPorGenero(String genero);

    // Buscar libros publicados después de una fecha específica
    List<Libro> buscarPorFechaPublicacionPosterior(Date fecha);

    // Buscar libros cuyo título contenga un texto específico
    List<Libro> buscarPorTituloContiene(String texto);

    // Buscar libros por el nombre del autor y género
    List<Libro> buscarPorAutorNombreYGenero(String nombre, String genero);

    // Buscar libros por el ID del autor
    List<Libro> buscarPorAutorId(Long autorId);
}
