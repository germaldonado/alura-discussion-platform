package com.alura.foro.api.controller;

import com.alura.foro.api.dto.curso.DatosListadoCurso;
import com.alura.foro.api.dto.respuesta.*;
import com.alura.foro.api.modelo.Estado;
import com.alura.foro.api.modelo.Respuesta;
import com.alura.foro.api.modelo.Topico;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.RespuestaRepository;
import com.alura.foro.api.repository.TopicoRepository;
import com.alura.foro.api.repository.UsuarioRepository;
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
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Operation(
            summary = "Registra una respuesta en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<DatosRetornoRespuesta> registrar(
            @RequestBody
            @Valid
            DatosRegistroRespuesta datosRegistro,
            UriComponentsBuilder uri) {
        Topico topico = topicoRepository.getReferenceById(datosRegistro.topicoId());
        if (topico.getEstado() == Estado.CERRADO) {
           return ResponseEntity.unprocessableEntity().build();
        }

        Usuario autor = usuarioRepository.getReferenceById(datosRegistro.autorId());
        Respuesta respuesta = respuestaRepository.save(new Respuesta(datosRegistro, topico, autor));
        topico.agregarRespuesta(respuesta);
        DatosRetornoRespuesta datosRespuesta = new DatosRetornoRespuesta(respuesta);
        URI url = uri.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping
    @Operation(
            summary = "Obtener todas las respuesta en la base de datos",
            description = "")
    public ResponseEntity<Page<DatosListadoRespuesta>> listar(
            @PageableDefault(size = 10)
            Pageable paginacion) {
        return ResponseEntity.ok(respuestaRepository.findByActivoTrue(paginacion).map(
                DatosListadoRespuesta::new));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consulta una respuesta por ID en la base de datos",
            description = "")
    public ResponseEntity<DatosRetornoRespuestaId> retornaDatos(
            @PathVariable
            Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRetornoRespuestaId(respuesta));
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Operation(
            summary = "Actualiza las respuestas en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<DatosRetornoRespuesta> actualizar(
            @RequestBody
            @Valid
            DatosActualizarRespuesta datosActualizar) {
        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizar.id());
        Topico topico = topicoRepository.getReferenceById(datosActualizar.topicoId());
        Usuario autor = usuarioRepository.getReferenceById(datosActualizar.autorId());
        respuesta.actualizarDatos(datosActualizar, topico, autor);
        return ResponseEntity.ok( new DatosRetornoRespuesta(respuesta));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Operation(
            summary = "Elimina las respuesta por ID en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<Void> eliminar(
            @PathVariable
            Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuesta.desactivarRespuesta();
        return ResponseEntity.noContent().build();
    }
}
