package com.alura.foro.api.controller;

import com.alura.foro.api.dto.security.DatosJWTtoken;
import com.alura.foro.api.dto.usuario.DatosAutenticacionUsuario;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.service.AutenticacionService;
import com.alura.foro.api.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Autenticacion", description = "obtiene el token para el usuario asignado que da acceso al resto de endpoint")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AutenticacionService validaciones;


    @PostMapping
    public ResponseEntity autenticarUsuario(
            @RequestBody
            @Valid
            DatosAutenticacionUsuario datosAutenticacion) {
        validaciones.autenticarUsuario(datosAutenticacion);
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacion.email(), datosAutenticacion.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
    }
}
