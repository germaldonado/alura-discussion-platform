package com.alura.foro.api.infra.errores;

import com.alura.foro.api.infra.exception.ExceptionDeAuth;
import com.alura.foro.api.infra.exception.UnauthorizedAccessException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ExceptionDeAuth.class)
    public ResponseEntity errorHandlerExceptionIntegridad(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> handleAccessDeniedException(Exception e) {
        String mensaje = "No tienes permitido hacer esta accion, comunicate con tu ADMIN";

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(mensaje);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity UnauthorizedAccessException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    private record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
