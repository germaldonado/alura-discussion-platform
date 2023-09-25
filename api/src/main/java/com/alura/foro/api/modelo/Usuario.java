package com.alura.foro.api.modelo;

import com.alura.foro.api.dto.usuario.DatosActualizarUsuario;
import com.alura.foro.api.dto.usuario.DatosRegistroUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Email
    private String email;

    private String contrasena;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private Boolean activo;

    public Usuario(DatosRegistroUsuario datos) {
        this.activo = true;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.contrasena = datos.contrasena();
        if (datos.tipo() != this.tipo) {
            this.tipo = datos.tipo();
        }
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizar) {
        /**
         * Las que tiene null son obligatorios los campos actualizar
         */
        if (datosActualizar.nombre() != null) {
            this.nombre = datosActualizar.nombre();
        }
        if (datosActualizar.email() != null) {
            this.email = datosActualizar.email();
        }
        if (datosActualizar.contrasena() != null) {
            this.contrasena = datosActualizar.contrasena();
        }
        if (datosActualizar.tipo() != datosActualizar.tipo()) {
            this.tipo = datosActualizar.tipo();
        }
        if(datosActualizar.activo() != datosActualizar.activo()){
            this.activo = datosActualizar.activo();
        }
    }


    public void desactivarUsuario() {
        this.activo = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipo.toString()));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

