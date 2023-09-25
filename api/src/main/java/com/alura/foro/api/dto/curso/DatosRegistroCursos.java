package com.alura.foro.api.dto.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCursos(
        @NotBlank
        String nombre,
        @NotNull
        String categoria) {
}
