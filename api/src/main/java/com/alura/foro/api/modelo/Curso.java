package com.alura.foro.api.modelo;

import com.alura.foro.api.dto.curso.DatosActualizarCurso;
import com.alura.foro.api.dto.curso.DatosRegistroCursos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;

    private Boolean activo;

    public Curso(DatosRegistroCursos datosRegistroCursos) {
        this.activo = true;
        this.nombre = datosRegistroCursos.nombre();
        this.categoria = datosRegistroCursos.categoria();
    }

    public void actualizarCurso(DatosActualizarCurso datosActualizarCurso) {
        if (datosActualizarCurso.nombre() != null){
            this.nombre = datosActualizarCurso.nombre();
        }
    }

    public void desactivarCurso() {
        this.activo = false;
    }

}
