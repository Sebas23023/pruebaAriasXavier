package com.espe.micro_libros.controllers;

import com.espe.micro_libros.model.entity.AutorLibro;
import com.espe.micro_libros.repositories.AutorLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores-libros")
@CrossOrigin(origins = "http://localhost:3000")
public class AutoresLibrosController {

    @Autowired
    private AutorLibroRepository autorLibroRepository;

    @PostMapping
    public ResponseEntity<AutorLibro> asignarLibroAAutor(@RequestBody AutorLibro autorLibro) {
        AutorLibro nuevaRelacion = autorLibroRepository.save(autorLibro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRelacion);
    }

    @GetMapping
    public ResponseEntity<List<AutorLibro>> obtenerRelaciones() {
        List<AutorLibro> relaciones = autorLibroRepository.findAll();
        return ResponseEntity.ok(relaciones);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRelacion(@PathVariable Long id) {
        autorLibroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorLibro> actualizarRelacion(
            @PathVariable Long id,
            @RequestBody AutorLibro detallesActualizados) {
        return autorLibroRepository.findById(id)
                .map(relacionExistente -> {
                    relacionExistente.setAutorId(detallesActualizados.getAutorId());
                    relacionExistente.setLibroId(detallesActualizados.getLibroId());
                    AutorLibro relacionActualizada = autorLibroRepository.save(relacionExistente);
                    return ResponseEntity.ok(relacionActualizada);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/autor/{autorId}")
    public ResponseEntity<List<AutorLibro>> listarLibrosPorAutor(@PathVariable Long autorId) {
        List<AutorLibro> librosPorAutor = autorLibroRepository.findByAutorId(autorId);
        if (librosPorAutor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(librosPorAutor);
    }

    @GetMapping("/libro/{libroId}")
    public ResponseEntity<List<AutorLibro>> listarAutoresPorLibro(@PathVariable Long libroId) {
        List<AutorLibro> autoresPorLibro = autorLibroRepository.findByLibroId(libroId);
        if (autoresPorLibro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(autoresPorLibro);
    }
}
