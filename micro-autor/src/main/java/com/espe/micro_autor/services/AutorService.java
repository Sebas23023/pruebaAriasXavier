package com.espe.micro_autor.services;

import com.espe.micro_autor.model.entity.Autor;

import java.util.Date;
import java.util.List;

public interface AutorService {
    // Método para listar todos los autores
    List<Autor> listarTodos();

    // Método para guardar un autor
    Autor guardarAutor(Autor autor);

    // Método para obtener un autor por su ID
    Autor obtenerPorId(Long id);

    // Método para eliminar un autor por su ID
    void eliminarPorId(Long id);

    // Métodos adicionales para búsquedas personalizadas
    List<Autor> buscarPorNombre(String nombre);

    List<Autor> buscarPorApellido(String apellido);

    List<Autor> buscarPorNacionalidad(String nacionalidad);

    List<Autor> buscarPorFechaNacimientoPosterior(Date fecha);

    List<Autor> buscarPorBiografiaContiene(String texto);
}
