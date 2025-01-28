package com.espe.micro_libros.clients;

import com.espe.micro_libros.model.entity.Autor;  // Importar la clase Autor
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "micro-autor", url = "micro-autor:8003/api/autores")
public interface AutorClient {

    // Listar todos los autores
    @GetMapping
    public ResponseEntity<Map<String, Object>> listarAutores();

    // Obtener autor por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerAutor(@PathVariable Long id);

    // Crear un nuevo autor
    @PostMapping
    public ResponseEntity<Map<String, Object>> crearAutor(@RequestBody Autor autor);

    // Actualizar un autor existente
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizarAutor(@PathVariable Long id, @RequestBody Autor autor);

    // Eliminar autor por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminarAutor(@PathVariable Long id);
}
