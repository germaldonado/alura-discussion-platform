package com.alura.foro.api.validations.Usuario;

import com.alura.foro.api.dto.usuario.DatosActualizarUsuario;
import com.alura.foro.api.infra.exception.UnauthorizedAccessException;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioID implements ValidadorUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void updateUsuario(DatosActualizarUsuario datosActualizar) {

        // Validar que el ID no sea nulo
        if (datosActualizar.id() == null) {
            throw new UnauthorizedAccessException("El ID no puede ser nulo");
        }

    }

}
