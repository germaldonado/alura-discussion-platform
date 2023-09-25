package com.alura.foro.api.repository;

import com.alura.foro.api.modelo.Respuesta;
import com.alura.foro.api.modelo.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    Page<Respuesta> findByActivoTrue(Pageable paginacion);
}
