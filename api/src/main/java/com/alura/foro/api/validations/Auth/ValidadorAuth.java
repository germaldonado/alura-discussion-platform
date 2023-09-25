package com.alura.foro.api.validations.Auth;

import com.alura.foro.api.dto.usuario.DatosAutenticacionUsuario;

public interface ValidadorAuth {

    public void validar(DatosAutenticacionUsuario datosAutenticacion);
}
