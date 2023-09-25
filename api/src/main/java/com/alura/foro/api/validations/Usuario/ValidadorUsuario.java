package com.alura.foro.api.validations.Usuario;

import com.alura.foro.api.dto.usuario.DatosActualizarUsuario;
import com.alura.foro.api.dto.usuario.DatosAutenticacionUsuario;

public interface ValidadorUsuario {

    public void updateUsuario(DatosActualizarUsuario datosActualizar);
}
