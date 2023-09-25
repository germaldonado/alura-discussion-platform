package com.alura.foro.api.service;

import com.alura.foro.api.dto.usuario.DatosActualizarUsuario;
import com.alura.foro.api.dto.usuario.DatosRegistroUsuario;
import com.alura.foro.api.dto.usuario.DatosRespuestaUsuario;
import com.alura.foro.api.modelo.Tipo;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.UsuarioRepository;
import com.alura.foro.api.validations.Usuario.UsuarioID;
import com.alura.foro.api.validations.Usuario.UsuarioNoActivo;
import com.alura.foro.api.validations.Usuario.UsuarioRepetido;
import com.alura.foro.api.validations.Usuario.ValidadorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepetido usuarioRepetido;
    @Autowired
    private UsuarioID usuarioID;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    List<ValidadorUsuario> validadores;

    public DatosRespuestaUsuario crearUsuario(DatosRegistroUsuario datosRegistro) {

        usuarioRepetido.repetido(datosRegistro);

        Usuario usuario = new Usuario(datosRegistro);
        usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);
        return new DatosRespuestaUsuario(usuario);
    }

    public DatosRespuestaUsuario actualizarUsuario(DatosActualizarUsuario datosActualizar) {

        validadores.forEach(v-> v.updateUsuario(datosActualizar));

        Usuario usuario = usuarioRepository.findById(datosActualizar.id()).get();
        usuario.actualizarDatos(datosActualizar);
        usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));
        usuarioRepository.save(usuario);
        return new DatosRespuestaUsuario(usuario);
    }

    public DatosRespuestaUsuario actualizarUsuarioAdmin(DatosActualizarUsuario datosActualizar) {

        usuarioID.updateUsuario(datosActualizar);

        //fetch actualizado
        Usuario usuario= usuarioRepository.findById(datosActualizar.id()).get();

        usuarioRepository.updateUsuarioAdmin(
                datosActualizar.id(),
                datosActualizar.nombre(),
                datosActualizar.email(),
                datosActualizar.contrasena(),
                datosActualizar.activo(),
                datosActualizar.tipo()
        );

        usuario.setContrasena(bCryptPasswordEncoder.encode(usuario.getContrasena()));

        return new DatosRespuestaUsuario(usuario);

    }
}
