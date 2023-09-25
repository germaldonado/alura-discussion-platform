package com.alura.foro.api.validations.Usuario;

import com.alura.foro.api.dto.usuario.DatosRegistroUsuario;
import com.alura.foro.api.infra.exception.ExceptionDeAuth;
import com.alura.foro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

;

@Component
public class UsuarioRepetido{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void repetido(DatosRegistroUsuario datosRegistro){

        if (datosRegistro.email() == null){
            return;
        }

        var usuarioRepetido = usuarioRepository.findByPassword(datosRegistro.email());
        if (usuarioRepetido != null) {
            throw new ExceptionDeAuth("El Usuario ya esta registrado");
        }

    }
}
