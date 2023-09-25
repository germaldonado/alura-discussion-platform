package com.alura.foro.api.controller;

import com.alura.foro.api.dto.curso.DatosActualizarCurso;
import com.alura.foro.api.dto.curso.DatosListadoCurso;
import com.alura.foro.api.dto.curso.DatosRegistroCursos;
import com.alura.foro.api.dto.curso.DatosRespuestaCurso;
import com.alura.foro.api.modelo.Curso;
import com.alura.foro.api.repository.CursoRepository;
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
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @PostMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Registra un curso en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN")
    public ResponseEntity<DatosRespuestaCurso> registrarCurso(
            @RequestBody
            @Valid
            DatosRegistroCursos datosRegistroCursos,
            UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoRepository.save(new Curso(datosRegistroCursos));
        DatosRespuestaCurso datosRespuestaCurso = new DatosRespuestaCurso(
                curso.getNombre(),curso.getCategoria());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCurso);
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los cursos en la base de datos",
            description = "")
    public ResponseEntity<Page<DatosListadoCurso>> listadoCursos(
            @PageableDefault(sort = "nombre" )
            Pageable paginacion){
        return ResponseEntity.ok(cursoRepository.findByActivoTrue(paginacion).map(
                DatosListadoCurso::new));
    }

    @PutMapping
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Actualizar los cursos en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN")
    public ResponseEntity actualizarCurso(
            @RequestBody
            @Valid
            DatosActualizarCurso datosActualizarCurso){
        Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarCurso(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(
                curso.getNombre(),curso.getCategoria()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(
            summary = "Eliminar los cursos por ID en la base de datos",
            description = "Esta petición solo la puede realizar el ROLE_ADMIN")
    public ResponseEntity elminarCurso(
            @PathVariable
            Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        curso.desactivarCurso();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consulta los cursos por ID en la base de datos",
            description = "")
    public ResponseEntity<DatosRespuestaCurso> retornaDatosCurso(
            @PathVariable
            Long id){
        Curso curso = cursoRepository.getReferenceById(id);
        var datosCurso = new DatosRespuestaCurso(
                curso.getNombre(),curso.getCategoria());
        return ResponseEntity.ok(datosCurso);
    }

}
