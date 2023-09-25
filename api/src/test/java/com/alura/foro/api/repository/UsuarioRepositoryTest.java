package com.alura.foro.api.repository;

import com.alura.foro.api.dto.usuario.DatosRegistroUsuario;
import com.alura.foro.api.modelo.Tipo;
import com.alura.foro.api.modelo.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class UsuarioRepositoryTest {

    String nombre="email";
    String email="email@email.com";
    String contrasena="123";
    Tipo tipo= Tipo.ROLE_USER;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TestEntityManager em;

    /**
     * findActivoByEmail
     */

    @Test
    @DisplayName("deberia retonar Inactivo el usuario por email")
    void findActivoByEmailEscenario1(){

        actualizarUsuario(nombre, email, contrasena, tipo);

        var usuarioActivo = usuarioRepository.findActivoByEmail(email);

        assertThat(usuarioActivo).isNull();

    }

    @Test
    @DisplayName("deberia retonar un usuario activo por email")
    void findActivoByEmailEscenario2(){

        var usuario = registrarUsuario(nombre, email, contrasena, tipo);

        var usuarioActivo = usuarioRepository.findActivoByEmail(email);

        assertThat(usuarioActivo).isEqualTo(usuario.getActivo());

    }

    /**
     * findByPassword
     */

    @Test
    @DisplayName("deberia retonar un usuario con constrasena INCORRECTA")
    void findByPasswordEscenario1() {
        autenticarUsuario(nombre,email, contrasena, tipo);

        var usuarioOk = usuarioRepository.findByPassword(email);

        assertThat(usuarioOk).isNull();
    }

    @Test
    @DisplayName("deberia retonar un usuario con constrasena CORRECTA")
    void findByPasswordEscenario2() {

        var usuario = registrarUsuario(nombre, email, contrasena, tipo);

        var usuarioOk = usuarioRepository.findByPassword(email);

        assertThat(usuarioOk.getPassword()).isEqualTo(usuario.getPassword());
    }

    /**
     * updateUsuarioAdmin
     */

    @Test
    @DisplayName("deberia retonar un ID no puede ser nulo")
    void updateUsuarioAdminEscenario1() {
        actualizarUsuario(nombre, email, contrasena, tipo);

        var usuarioID = usuarioRepository.updateUsuarioAdmin(null, nombre, email, contrasena, true, tipo);

        assertThat(usuarioID).isEqualTo(0);
    }

    @Test
    @DisplayName("deberia retonar un ID valido")
    void updateUsuarioAdminEscenario2() {
        var usuario = registrarUsuario(nombre, email, contrasena, tipo);

        var usuarioID = usuarioRepository.updateUsuarioAdmin(2L, nombre, email, contrasena, true, tipo);

        assertThat(usuarioID).isEqualTo(1);
    }

    /**
     *
     * @param nombre El nombre completo del usuario
     * @param email El email único del usuario
     * @param contrasena La contraseña del usuario
     * @param tipo El rol del usuario "ROLE_ADMIN, ROLE_USER, ROLE_MOD"
     */

    private void actualizarUsuario(String nombre, String email,String contrasena, Tipo tipo) {
        em.persist(new Usuario(null,nombre, email, contrasena, tipo, null));
    }

    private void autenticarUsuario(String nombre,String email, String contrasena, Tipo tipo) {
        em.persist(new Usuario(null, nombre, email, contrasena, tipo, null));
    }

    private Usuario registrarUsuario(String nombre, String email, String contrasena, Tipo tipo) {
        var usuario = new Usuario(datosRegistroUsuario(nombre, email, contrasena, tipo));
        em.persist(usuario);
        return usuario;
    }

    private DatosRegistroUsuario datosRegistroUsuario(String nombre, String email, String contrasena, Tipo tipo) {
        return new DatosRegistroUsuario(nombre, email, contrasena, tipo);
    }
}