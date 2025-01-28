package com.espe.micro_libros.controllers;

import com.espe.micro_libros.model.entity.Libro;
import com.espe.micro_libros.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "http://localhost:3000") // Habilitar CORS solo para este origen
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarLibros() {
        List<Libro> libros = libroService.listarTodos();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros obtenidos exitosamente.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerLibro(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Libro libro = libroService.obtenerPorId(id);
            response.put("message", "Libro encontrado exitosamente.");
            response.put("data", libro);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Libro no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crearLibro(@RequestBody Libro libro) {
        Libro libroCreado = libroService.guardarLibro(libro);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libro creado exitosamente.");
        response.put("data", libroCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Map<String, Object> response = new HashMap<>();
        try {
            Libro libroExistente = libroService.obtenerPorId(id);
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setGenero(libro.getGenero());
            libroExistente.setFechaPublicacion(libro.getFechaPublicacion());
            Libro libroActualizado = libroService.guardarLibro(libroExistente);
            response.put("message", "Libro actualizado exitosamente.");
            response.put("data", libroActualizado);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Libro no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarLibro(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            libroService.eliminarPorId(id);
            response.put("message", "Libro eliminado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Libro no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/buscar/titulo/{titulo}")
    public ResponseEntity<Map<String, Object>> buscarPorTitulo(@PathVariable String titulo) {
        List<Libro> libros = libroService.buscarPorTitulo(titulo);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros encontrados por título.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/autor/nombre/{nombre}")
    public ResponseEntity<Map<String, Object>> buscarPorAutorNombre(@PathVariable String nombre) {
        List<Libro> libros = libroService.buscarPorAutorNombre(nombre);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros encontrados por nombre del autor.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/genero/{genero}")
    public ResponseEntity<Map<String, Object>> buscarPorGenero(@PathVariable String genero) {
        List<Libro> libros = libroService.buscarPorGenero(genero);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros encontrados por género.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/fecha/{fecha}")
    public ResponseEntity<Map<String, Object>> buscarPorFechaPublicacionPosterior(@PathVariable Date fecha) {
        List<Libro> libros = libroService.buscarPorFechaPublicacionPosterior(fecha);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros encontrados después de la fecha proporcionada.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/titulo/contiene/{texto}")
    public ResponseEntity<Map<String, Object>> buscarPorTituloContiene(@PathVariable String texto) {
        List<Libro> libros = libroService.buscarPorTituloContiene(texto);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros encontrados por título parcial.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/autor/nombre/genero")
    public ResponseEntity<Map<String, Object>> buscarPorAutorNombreYGenero(@RequestParam String nombre, @RequestParam String genero) {
        List<Libro> libros = libroService.buscarPorAutorNombreYGenero(nombre, genero);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros encontrados por autor y género.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar/autor/id/{autorId}")
    public ResponseEntity<Map<String, Object>> buscarPorAutorId(@PathVariable Long autorId) {
        List<Libro> libros = libroService.buscarPorAutorId(autorId);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libros encontrados por ID del autor.");
        response.put("data", libros);
        return ResponseEntity.ok(response);
    }
}
