package com.alura.foro.api.validations.Usuario;

import com.alura.foro.api.dto.usuario.DatosActualizarUsuario;
import com.alura.foro.api.infra.exception.UnauthorizedAccessException;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioNoActivo implements ValidadorUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void updateUsuario(DatosActualizarUsuario datosActualizar){

        if (datosActualizar.email() == null){
            return;
        }

        var usuarioNoActivo = usuarioRepository.findActivoByEmail(datosActualizar.email());
        if (!usuarioNoActivo){
            throw new UnauthorizedAccessException("El usuario ya existe pero esta Inactivo, comunicate con el ADMIN");
        }

    }

}
