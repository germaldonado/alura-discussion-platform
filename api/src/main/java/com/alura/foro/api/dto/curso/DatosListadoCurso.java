package com.alura.foro.api.dto.curso;

import com.alura.foro.api.modelo.Curso;

public record DatosListadoCurso(
        Long id,
        String nombre,
        String categoria) {

    public DatosListadoCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
