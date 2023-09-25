package com.alura.foro.api.dto.usuario;

import com.alura.foro.api.modelo.Usuario;

public record DatosRespuestaUsuario(
        Long id,
        String nombre,
        String email,
        String tipo) {

    public DatosRespuestaUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getTipo().toString());
    }
}
