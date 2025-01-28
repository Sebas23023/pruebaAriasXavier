package com.espe.micro_libros.services;

import com.espe.micro_libros.model.entity.Libro;
import com.espe.micro_libros.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro obtenerPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado con ID: " + id);
        }
        libroRepository.deleteById(id);
    }

    @Override
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    @Override
    public List<Libro> buscarPorAutorNombre(String nombre) {
        return libroRepository.findByAutor_Nombre(nombre);
    }

    @Override
    public List<Libro> buscarPorGenero(String genero) {
        return libroRepository.findByGenero(genero);
    }

    @Override
    public List<Libro> buscarPorFechaPublicacionPosterior(Date fecha) {
        return libroRepository.findByFechaPublicacionAfter(fecha);
    }

    @Override
    public List<Libro> buscarPorTituloContiene(String texto) {
        return libroRepository.findByTituloContaining(texto);
    }

    @Override
    public List<Libro> buscarPorAutorNombreYGenero(String nombre, String genero) {
        return libroRepository.findByAutor_NombreAndGenero(nombre, genero);
    }

    @Override
    public List<Libro> buscarPorAutorId(Long autorId) {
        return libroRepository.findByAutor_Id(autorId);
    }
}
