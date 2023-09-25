package com.alura.foro.api.controller;

import com.alura.foro.api.dto.usuario.*;
import com.alura.foro.api.modelo.Tipo;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.UsuarioRepository;
import com.alura.foro.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/admin")
@SecurityRequirement(name = "bearer-key")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/register")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Registra un usuario en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN",
            tags = { "Registrar un Usuario" })
    public ResponseEntity<DatosRespuestaUsuario> registrar(
            @RequestBody
            @Valid
            DatosRegistroUsuario datosRegistro,
            UriComponentsBuilder uri) {

        DatosRespuestaUsuario datosRespuesta = usuarioService.crearUsuario(datosRegistro);
        URI url = uri.path("/admin/{id}").buildAndExpand(datosRespuesta.id()).toUri();

        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping("/usuarios")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Obtener todos los usuarios en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<Page<DatosListadoUsuario>> listar(
            @PageableDefault(size = 10)
            Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(paginacion).map(DatosListadoUsuario::new));

    }

    @GetMapping("/usuarios/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Consulta un usuario por ID en la base de datos",
            description = "")
    public ResponseEntity<DatosRespuestaUsuarioId> retornaDatos(
            @PathVariable
            Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaUsuarioId(usuario));
    }

//    @PutMapping("/usuarios")
//    @Transactional
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @Operation(
//            summary = "Actualiza el usuario en la base de datos",
//            description = "Solo el ROLE_ADMIN puede actualizar el tipo ")
//    public ResponseEntity<DatosRespuestaUsuario> actualizar(
//            @RequestBody
//            @Valid
//            DatosActualizarUsuario datosActualizar) {
//        DatosRespuestaUsuario datosRespuesta = usuarioService.actualizarUsuarioAdmin(datosActualizar);
//        return ResponseEntity.ok(datosRespuesta);
//    }

    @PatchMapping("/usuarios")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Actualiza el usuario en la base de datos",
            description = "Solo el ROLE_ADMIN puede actualizar el tipo ")
    public ResponseEntity<DatosRespuestaUsuario> actualizar(
            @RequestBody
            @Valid
            DatosActualizarUsuario datosActualizar) {
        DatosRespuestaUsuario datosRespuesta = usuarioService.actualizarUsuarioAdmin(datosActualizar);
        return ResponseEntity.ok(datosRespuesta);
    }

    @DeleteMapping("/usuarios/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Eliminar los usuarios por ID en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN")
    public ResponseEntity<Void> eliminar(
            @PathVariable
            Long id) {
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();
        return ResponseEntity.noContent().build();
    }
}
