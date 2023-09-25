package com.alura.foro.api.repository;

import com.alura.foro.api.modelo.Tipo;
import com.alura.foro.api.modelo.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail(String username);

    Page<Usuario> findByActivoTrue(Pageable paginacion);

    @Query("""
            select u.activo 
            from Usuario u
            where u.email=:username
            """)
    Boolean findActivoByEmail(String username);

    @Query("""
            select u.activo 
            from Usuario u
            where u.email=:username
            """)
    Usuario findNoActivo(String username);

    @Query("""
            select u
            from Usuario u
            where u.email = :username and cast(u.activo as boolean) = true
            """)
    Usuario findByPassword(String username);

    @Modifying
    @Query("""
            UPDATE Usuario u
                  SET
                    u.nombre = COALESCE(:nombre, u.nombre),
                    u.email = COALESCE(:email, u.email),
                    u.contrasena = COALESCE(:contrasena, u.contrasena),
                    u.tipo = COALESCE(:tipo, u.tipo),
                    u.activo = COALESCE(:activo, u.activo)
                  WHERE u.id = :id
            """)
    Integer updateUsuarioAdmin(@Param("id") Long id,
                            @Param("nombre") String nombre,
                            @Param("email") String email,
                            @Param("contrasena") String contrasena,
                            @Param("activo") Boolean activo,
                            @Param("tipo") Tipo tipo);
}


//    @Query("""
//            select u
//            from Usuario u
//            where u.email = :username and u.activo = true
//            """)
//    Usuario findByPassword(String username);
