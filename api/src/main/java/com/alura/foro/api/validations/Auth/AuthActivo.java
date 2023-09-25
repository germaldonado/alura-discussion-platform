package com.alura.foro.api.validations.Auth;

import com.alura.foro.api.dto.usuario.DatosAutenticacionUsuario;
import com.alura.foro.api.infra.exception.ExceptionDeAuth;
import com.alura.foro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;;

@Component
public class AuthActivo implements ValidadorAuth {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DatosAutenticacionUsuario datosAutenticacion){

        if (datosAutenticacion.email() == null){
            return;
        }

        var usuarioActivo = usuarioRepository.findActivoByEmail(datosAutenticacion.email());
        if (usuarioActivo == null){
            throw new ExceptionDeAuth("El Usuario no existe");
        }

        if (!usuarioActivo){
            throw new ExceptionDeAuth("El Usuario no esta Activo");
        }

    }
}
