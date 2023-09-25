package com.alura.foro.api.validations.Auth;

import com.alura.foro.api.dto.usuario.DatosAutenticacionUsuario;
import com.alura.foro.api.infra.exception.ExceptionDeAuth;
import com.alura.foro.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

;

@Component
public class AuthPassword implements ValidadorAuth {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void validar(DatosAutenticacionUsuario datosAutenticacion) {
        if (datosAutenticacion.contrasena() == null) {
            return;
        }

        var usuarioActivo = usuarioRepository.findByPassword(datosAutenticacion.email());
        if (usuarioActivo == null || !bCryptPasswordEncoder.matches(datosAutenticacion.contrasena(), usuarioActivo.getPassword())) {
            throw new ExceptionDeAuth("La Contraseña es incorrecta");
        }
    }
}
