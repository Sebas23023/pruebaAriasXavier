package com.espe.micro_libros.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "autores_libros",
        uniqueConstraints = @UniqueConstraint(columnNames = {"autor_id", "libro_id"}))
public class AutorLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "autor_id", nullable = false)
    private Long autorId;

    @Column(name = "libro_id", nullable = false)
    private Long libroId;

    // Constructor vacío (necesario para JPA)
    public AutorLibro() {}

    // Constructor con parámetros
    public AutorLibro(Long autorId, Long libroId) {
        this.autorId = autorId;
        this.libroId = libroId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }
}
