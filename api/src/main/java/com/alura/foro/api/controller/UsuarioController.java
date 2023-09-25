package com.alura.foro.api.controller;

import com.alura.foro.api.dto.usuario.*;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.UsuarioRepository;
import com.alura.foro.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class  UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(
            summary = "Obtener todos los usuarios en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<Page<DatosListadoUsuario>> listar(
            @PageableDefault(size = 10)
            Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(paginacion).map(DatosListadoUsuario::new));

    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consulta un usuario por ID en la base de datos",
            description = "")
    public ResponseEntity<DatosRespuestaUsuarioId> retornaDatos(
            @PathVariable
            Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaUsuarioId(usuario));
    }

    @PutMapping
    @Transactional
    @Operation(
            summary = "Actualiza el usuario en la base de datos",
            description = "Solo el ROLE_ADMIN puede actualizar el tipo ")
    public ResponseEntity<DatosRespuestaUsuario> actualizar(
            @RequestBody
            @Valid
            DatosActualizarUsuario datosActualizar) {
        DatosRespuestaUsuario datosRespuesta = usuarioService.actualizarUsuario(datosActualizar);
        return ResponseEntity.ok(datosRespuesta);
    }

}
