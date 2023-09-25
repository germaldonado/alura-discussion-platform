package com.alura.foro.api.validations.Usuario;

import com.alura.foro.api.dto.usuario.DatosActualizarUsuario;
import com.alura.foro.api.infra.exception.ExceptionDeAuth;
import com.alura.foro.api.infra.exception.UnauthorizedAccessException;
import com.alura.foro.api.modelo.Tipo;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUpdate implements ValidadorUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void updateUsuario(DatosActualizarUsuario datosActualizar) {

        // Validar que el ID y el tipo no sean diferentes a los de la base de datos
        Usuario usuario = usuarioRepository.findById(datosActualizar.id()).get();
        if (datosActualizar.id() != usuario.getId() ||
                datosActualizar.tipo() != usuario.getTipo() ||
                datosActualizar.activo() != usuario.getActivo()) {
            throw new UnauthorizedAccessException("Solo el ADMIN puede actualizar el tipo de rol, el ID o su estado");
        }

    }

}
