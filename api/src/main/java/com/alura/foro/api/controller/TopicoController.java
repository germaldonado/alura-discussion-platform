package com.alura.foro.api.controller;

import com.alura.foro.api.dto.topico.*;
import com.alura.foro.api.modelo.Curso;
import com.alura.foro.api.modelo.Topico;
import com.alura.foro.api.modelo.Usuario;
import com.alura.foro.api.repository.CursoRepository;
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
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;


    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Operation(
            summary = "Registra un topico en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<DatosRespuestaTopico> registrar(
            @RequestBody
            @Valid
            DatosRegistroTopico datosRegistro,
            UriComponentsBuilder uri) {
        Usuario autor = usuarioRepository.getReferenceById(datosRegistro.autorId());
        Curso curso = cursoRepository.getReferenceById(datosRegistro.cursoId());
        Topico topico = topicoRepository.save(new Topico(datosRegistro, autor, curso));
        DatosRespuestaTopico datosRespuesta = new DatosRespuestaTopico(topico);
        URI url = uri.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping
    @Operation(
            summary = "Obtener todas los topicos en la base de datos",
            description = "")
    public ResponseEntity<Page<DatosListadoTopico>> listar(
            @PageableDefault(size = 10)
            Pageable paginacion) {
        System.out.println("get");
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consulta un topico por ID en la base de datos",
            description = "")
    public ResponseEntity<DatosRespuestaTopicoId> retornaDatos(
            @PathVariable
            Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DatosRespuestaTopicoId(topico));
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Operation(
            summary = "Actualiza los topicos en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<DatosRespuestaTopico> actualizar(
            @RequestBody
            @Valid
            DatosActualizarTopico datosActualizar) {
        Usuario autor = usuarioRepository.getReferenceById(datosActualizar.autorId());
        Curso curso = cursoRepository.getReferenceById(datosActualizar.cursoId());
        Topico topico = topicoRepository.getReferenceById(datosActualizar.id());
        topico.actualizarDatos(datosActualizar, autor, curso);
        return ResponseEntity.ok( new DatosRespuestaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @Operation(
            summary = "Elimina los topicos por ID en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN y el ROLE_USER")
    public ResponseEntity<Void> eliminar(
            @PathVariable
            Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        //topicoRepository.delete(topico);
        topico.cerrarTopico();
        return ResponseEntity.noContent().build();
    }
}
