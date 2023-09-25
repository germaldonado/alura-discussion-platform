package com.alura.foro.api.service;

import com.alura.foro.api.dto.usuario.DatosAutenticacionUsuario;
import com.alura.foro.api.dto.usuario.DatosRespuestaUsuario;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.UsuarioRepository;
import com.alura.foro.api.validations.Auth.ValidadorAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    List<ValidadorAuth> validadores;

    private final UsuarioRepository usuarioRepository;

    AutenticacionService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username);
    }

    public DatosRespuestaUsuario autenticarUsuario(DatosAutenticacionUsuario datosAutenticacion) {
        validadores.forEach(v-> v.validar(datosAutenticacion));
        return new DatosRespuestaUsuario((Usuario) usuarioRepository.findByEmail(datosAutenticacion.email()));
    }
}
