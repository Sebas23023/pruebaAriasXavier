package com.espe.micro_autor.services;

import com.espe.micro_autor.model.entity.Autor;
import com.espe.micro_autor.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor obtenerPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + id));
    }

    @Override
    public void eliminarPorId(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor no encontrado con ID: " + id);
        }
        autorRepository.deleteById(id);
    }

    @Override
    public List<Autor> buscarPorNombre(String nombre) {
        return autorRepository.findByNombre(nombre);
    }

    @Override
    public List<Autor> buscarPorApellido(String apellido) {
        return autorRepository.findByApellido(apellido);
    }

    @Override
    public List<Autor> buscarPorNacionalidad(String nacionalidad) {
        return autorRepository.findByNacionalidad(nacionalidad);
    }

    @Override
    public List<Autor> buscarPorFechaNacimientoPosterior(Date fecha) {
        return autorRepository.findByFechaNacimientoAfter(fecha);
    }

    @Override
    public List<Autor> buscarPorBiografiaContiene(String texto) {
        return autorRepository.findByBiografiaContaining(texto);
    }
}
