package com.espe.micro_autor.controllers;

import com.espe.micro_autor.model.entity.Autor;
import com.espe.micro_autor.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/autores")
@CrossOrigin(origins = "http://localhost:3000")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarAutores() {
        List<Autor> autores = autorService.listarTodos();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Autores obtenidos exitosamente.");
        response.put("data", autores);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerAutor(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Autor autor = autorService.obtenerPorId(id);
            response.put("message", "Autor encontrado exitosamente.");
            response.put("data", autor);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Autor no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crearAutor(@RequestBody Autor autor) {
        Autor autorCreado = autorService.guardarAutor(autor);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Autor creado exitosamente.");
        response.put("data", autorCreado);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Map<String, Object> response = new HashMap<>();
        try {
            Autor autorExistente = autorService.obtenerPorId(id);
            autorExistente.setNombre(autor.getNombre());
            autorExistente.setApellido(autor.getApellido());
            autorExistente.setNacionalidad(autor.getNacionalidad());
            autorExistente.setFechaNacimiento(autor.getFechaNacimiento());
            autorExistente.setBiografia(autor.getBiografia());
            Autor autorActualizado = autorService.guardarAutor(autorExistente);
            response.put("message", "Autor actualizado exitosamente.");
            response.put("data", autorActualizado);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Autor no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarAutor(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            autorService.eliminarPorId(id);
            response.put("message", "Autor eliminado exitosamente.");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("message", "Autor no encontrado con ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
