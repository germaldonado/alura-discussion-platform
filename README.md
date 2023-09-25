# Nombre del Proyecto 📋

"**Alura Discussion Platform:** es permitir a los usuarios registrados realizar preguntas, responder a preguntas y participar en discusiones sobre diversos temas. 😀

<div>
  <div style="text-align: center">
    <h1 style="font-size: 25px; text-decoration-line: underline">
      Version OPENAPI 💻
    </h1>
    <div
      style="
        text-align: center;
        padding: 10px;
        display: flex;
        flex-direction: column;
        /* margin: 0 20px 20px 20px; */
      "
    >
    <!-- Autenticacion -->
      <div
        style="
          display: flex;
          flex-direction: column;
          background: #fafafa;
        "
      >
        <div
        style="
          display: flex;
          flex-direction: column;
          background: #fafafa;
        "
      >
        <div style="display: flex; align-items: center">
          <h3
            style="
              color: #3b4151;
              font-family: sans-serif;
              font-size: 24px;
              margin: 10px 5px;
              flex:2;
              text-align: left;
            "
          >
            Autenticacion
          </h3>
          <p
            style="
              flex: 6;
              color: #3b4151;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 400;
              padding: 0 10px;
              margin: 1em auto;
              text-align: left;
            "
          >
            obtiene el token para el usuario asignado que da acceso al resto de endpoint
          </p>
        </div>
        <div
          aria-label="post/login"
          aria-expanded="false"
          style="cursor: pointer; display: flex"
        >
          <span
            style="
              background: #49cc90;
              border-radius: 3px;
              color: #fff;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 700;
              padding: 6px 60px;
              text-align: center;
            "
            >POST</span
          >
          <span
            data-path="/login"
            style="
              width: 100%;
              background: #e8f6f0;
              border-radius: 3px;
              padding: 6px 16px;
              text-align: center;
              align-items: center;
              color: #3b4151;
              font-family: monospace;
              font-size: 16px;
              font-weight: 600;
            "
          >
            <a>
              <span style="color: #3b4151">/login</span>
            </a>
          </span>
        </div>
      </div>
      <!-- Registrar un Usuario -->
      <div
        style="
          display: flex;
          flex-direction: column;
          background: #fafafa;
        "
      >
        <div style="display: flex; align-items: center">
          <h3
            style="
              color: #3b4151;
              font-family: sans-serif;
              font-size: 24px;
              margin: 10px 55px 10px 10px;
              flex:2;
              text-align: left;
            "
          >
            Registrar un Usuario
          </h3>
          <p
            style="
              flex: 8;
              color: #3b4151;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 400;
              padding: 0 10px;
              margin: 1em auto;
              text-align: left;
            "
          >
            Registra un usuario en la base de datos
          </p>
        </div>
        <div
          aria-label="post/admin/register"
          aria-expanded="false"
          style="cursor: pointer; display: flex"
        >
          <span
            style="
              background: #49cc90;
              border-radius: 3px;
              color: #fff;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 700;
              padding: 6px 60px;
              text-align: center;
            "
            >POST</span
          >
          <span
            data-path="/admin/register"
            style="
              width: 100%;
              background: #e8f6f0;
              border-radius: 3px;
              padding: 6px 16px;
              text-align: center;
              align-items: center;
              color: #3b4151;
              font-family: monospace;
              font-size: 16px;
              font-weight: 600;
            "
          >
            <a>
              <span style="color: #3b4151">/admin/register</span>
            </a>
          </span>
        </div>
      </div>
      <!-- admin-controller -->
      <div
        style="
          display: flex;
          flex-direction: column;
          background: #fafafa;
        "
      >
        <div style="display: flex; align-items: center">
          <h3
            style="
              color: #3b4151;
              font-family: sans-serif;
              font-size: 24px;
              margin: 10px 55px 10px 10px;
              flex:2;
              text-align: left;
            "
          >
            admin-controller
          </h3>
        </div>
        <!-- GET -->
        <div style="display: flex; align-items: center">
          <p
            style="
              flex: 8;
              color: #3b4151;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 400;
              padding: 0 10px;
              margin: 1em auto;
              text-align: left;
            "
          >
            Obtener todos los usuarios en la base de datos
          </p>
        </div>
        <div
          aria-label="get/admin/usuarios"
          aria-expanded="false"
          style="cursor: pointer; display: flex"
        >
          <span
            style="
              background: #61affe;
              border-radius: 3px;
              color: #fff;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 700;
              padding: 6px 66px;
              text-align: center;
            "
            >GET</span
          >
          <span
            data-path="/admin/usuarios"
            style="
              width: 100%;
              background: #ebf3fb;
              border-radius: 3px;
              padding: 6px 16px;
              text-align: center;
              align-items: center;
              color: #3b4151;
              font-family: monospace;
              font-size: 16px;
              font-weight: 600;
            "
          >
            <a>
              <span style="color: #3b4151">/admin/usuarios</span>
            </a>
          </span>
        </div>
      </div>
      <!-- PATCH -->
      <div
        style="
          display: flex;
          flex-direction: column;
          background: #fafafa;
        "
      >
        <div style="display: flex; align-items: center">
          <p
            style="
              flex: 8;
              color: #3b4151;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 400;
              padding: 0 10px;
              margin: 1em auto;
              text-align: left;
            "
          >
            Actualiza el usuario en la base de datos
          </p>
        </div>
        <div
          aria-label="patch/admin/usuarios"
          aria-expanded="false"
          style="cursor: pointer; display: flex"
        >
          <span
            style="
              background: #50e3c2;
              border-radius: 3px;
              color: #fff;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 700;
              padding: 6px 56px;
              text-align: center;
            "
            >PATCH</span
          >
          <span
            data-path="/admin/usuarios"
            style="
              width: 100%;
              background: #e9f8f5;
              border-radius: 3px;
              padding: 6px 16px;
              text-align: center;
              align-items: center;
              color: #3b4151;
              font-family: monospace;
              font-size: 16px;
              font-weight: 600;
            "
          >
            <a>
              <span style="color: #3b4151">/admin/usuarios</span>
            </a>
          </span>
        </div>
      </div>
      <!-- GET{ID} -->
      <div
        style="
          display: flex;
          flex-direction: column;
          background: #fafafa;
        "
      >
        <div style="display: flex; align-items: center">
          <p
            style="
              flex: 8;
              color: #3b4151;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 400;
              padding: 0 10px;
              margin: 1em auto;
              text-align: left;
            "
          >
            Consulta un usuario por ID en la base de datos
          </p>
        </div>
        <div
          aria-label="get/admin/usuarios/{id}"
          aria-expanded="false"
          style="cursor: pointer; display: flex"
        >
          <span
            style="
              background: #61affe;
              border-radius: 3px;
              color: #fff;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 700;
              padding: 6px 66px;
              text-align: center;
            "
            >GET</span
          >
          <span
            data-path="/admin/usuarios/{id}"
            style="
              width: 100%;
              background: #ebf3fb;
              border-radius: 3px;
              padding: 6px 16px;
              text-align: center;
              align-items: center;
              color: #3b4151;
              font-family: monospace;
              font-size: 16px;
              font-weight: 600;
            "
          >
            <a>
              <span style="color: #3b4151">/admin/usuarios/{id}</span>
            </a>
          </span>
        </div>
      </div>
      <!-- DELETE -->
      <div
        style="
          display: flex;
          flex-direction: column;
          background: #fafafa;
        "
      >
        <div style="display: flex; align-items: center">
          <p
            style="
              flex: 8;
              color: #3b4151;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 400;
              padding: 0 10px;
              margin: 1em auto;
              text-align: left;
            "
          >
            Eliminar los usuarios por ID en la base de datos
          </p>
        </div>
        <div
          aria-label="delete/admin/usuarios/{id}"
          aria-expanded="false"
          style="cursor: pointer; display: flex"
        >
          <span
            style="
              background: #f93e3e;
              border-radius: 3px;
              color: #fff;
              font-family: sans-serif;
              font-size: 14px;
              font-weight: 700;
              padding: 6px 53px;
              text-align: center;
            "
            >DELETE</span
          >
          <span
            data-path="/admin/usuarios/{id}"
            style="
              width: 100%;
              background: #fae7e7;
              border-radius: 3px;
              padding: 6px 16px;
              text-align: center;
              align-items: center;
              color: #3b4151;
              font-family: monospace;
              font-size: 16px;
              font-weight: 600;
            "
          >
            <a>
              <span style="color: #3b4151">/admin/usuarios/{id}</span>
            </a>
          </span>
        </div>
      </div>
    </div>
  </div>
</div>

Para una mejor visualización, al momento de llevar el proyecto en desarrollo o test visitar la pagina web:

```
    http://localhost:8080/swagger-ui/index.html#/
```

De la misma manera, en el proyecto adjunto **resources/attach/Insomnia_foro_alura.json** donde se encuentra una interfaz en Insomnia que permite probar y explorar todas las rutas y endpoints disponibles en la API.

# Link Proyecto

<div style="display: flex; flex-direction: column; align-items: center;">
    <img src="/api/src/main/java/com/alura/foro/api/images/foro_icon.png" width="50px">
    <a style="color: blue; font-size: 20px; display: block; text-align: center;" href="https://gitlab.com/Willydmq/alura-discussion-platform" target="_blank">Alura Discussion Platform</a>
</div>

## Instalación ⚙️

1. Enfoque del proyecto: Este proyecto está enfocado al **backend**,la estructura se tomó como referencia clonando el siguiente proyecto:

```
    git clone https://github.com/alura-challenges/challenge-one-foro-alura.git
```

2. Requisitos previos: Un entorno de desarrollo con **Java 8 o superior** instalado, un servidor de base de datos: **MySQL** -> Base de datos para desarrollo, y **H2** -> Base de datos para los Test

La base de datos se compone de las siguientes tablas:

- **Curso:** Representa un curso en el sistema, con información como título, descripción y fecha de inicio.
- **Estado:** Representa el estado de una publicación en el foro, como "SOLUCIONADO" o "CERRADO".
- **Respuesta:** Representa una respuesta a una publicación en el foro, con detalles como el contenido y la fecha de respuesta.
- **Tipo:** Representa el rol de una usuario como "ROLE_USER" o "ROLE_MOD".
- **Topico:** Representa un tema en el foro, con detalles como título y descripción.
- **Usuario:** Representa un usuario registrado en el sistema, con información como nombre, email y contraseña.

La base de datos **se crea automáticamente al ejecutar el proyecto**, no es necesario crear la base de datos manualmente. Para ello, el proyecto incluye una carpeta llamada **resources/db/migration** que contiene los archivos de consulta SQL necesarios para crear la base de datos. Cuando se ejecuta el proyecto, estas consultas se ejecutan automáticamente y crean la base de datos.

El esquema de la base de datos se muestra en la siguiente imagen:

<div style="display: flex; flex-direction: column; align-items: center;">
    <img src="/api/src/main/java/com/alura/foro/api/images/foro_alura.png" width="400px">
</div>

La imagen muestra las tablas y columnas de la base de datos. Las filas en amarillo son llaves primarias y las filas en rojo son llaves foraneas.

**tener en cuenta:** que debe ser veridicta la información de su servidor de base de datos para que no genere errores, igualmente,en caso de que la creación de la base de datos presente algún problema, se adjunta un archivo **resources/attach/foro_alura.sql** con la estructura y datos de la base de datos. Esto permitirá importar directamente la base de datos y asegurar su correcta configuración.

1. Clona el proyecto: Para descargar el proyecto, puede utilizar el siguiente comando:

```
    https://gitlab.com/Willydmq/alura-discussion-platform.git

```

4. Importar el proyecto en el IDE de **IntelliJ IDEA**: para importar el proyecto en IntelliJ IDEA, seleccione la opción
   File > New > Project from Existing Sources.

5. Configura las dependencias: en el archivo **api/pom.xml**, abra el archivo y incluya las siguientes dependencias:

- ![groupId](https://img.shields.io/badge/SpringBootDevtools-groupId-red) <a href="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools">
  spring-boot-devtools</a>
- ![groupId](https://img.shields.io/badge/SpringBootStarterWeb-groupId-blue) <a href="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web">
  spring-boot-starter-web</a>
- ![groupId](https://img.shields.io/badge/SpringBootStarterTest-groupId-orange) <a href="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test">
  spring-boot-starter-test</a>
- ![groupId](https://img.shields.io/badge/SpringBootStarterDataJpa-groupId-green) <a href="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa">
  spring-boot-starter-data-jpa</a>
- ![groupId](https://img.shields.io/badge/SpringBootStarterValidation-groupId-white) <a href="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation">
  spring-boot-starter-validation</a>
- ![groupId](https://img.shields.io/badge/SpringBootStarterSecurity-groupId-violet) <a href="https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security">
  spring-boot-starter-security</a>
- ![groupId](https://img.shields.io/badge/SpringSecurityTest-groupId-yellow) <a href="https://mvnrepository.com/artifact/org.springframework.security/spring-security-test">
  spring-security-test</a>
- ![groupId](https://img.shields.io/badge/FlywayCore-groupId-purple) <a href="https://mvnrepository.com/artifact/org.flywaydb/flyway-core">
  flyway-core</a>
- ![groupId](https://img.shields.io/badge/FlywayMysql-groupId-brown) <a href="https://mvnrepository.com/artifact/org.flywaydb/flyway-mysql">
  flyway-mysql</a>
- ![groupId](https://img.shields.io/badge/MysqlConnectorJ-groupId-pink) <a href="https://mvnrepository.com/artifact/com.mysql/mysql-connector-j">
  mysql-connector-j</a>
- ![groupId](https://img.shields.io/badge/Lombok-groupId-teal) <a href="https://mvnrepository.com/artifact/org.projectlombok/lombok">
  lombok</a>
- ![groupId](https://img.shields.io/badge/JavaJwt-groupId-lightgreen) <a href="https://mvnrepository.com/artifact/com.auth0/java-jwt">
  java-jwt</a>
- ![groupId](https://img.shields.io/badge/SpringdocOpenapiStarterWebmvcUi-groupId-magenta) <a href="https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui">
  springdoc-openapi-starter-webmvc-ui</a>
- ![groupId](https://img.shields.io/badge/H2-groupId-gold) <a href="https://mvnrepository.com/artifact/com.h2database/h2">
  h2</a>

6. Debes sobrescribir los valores de las variables de entorno en el archivo **application.properties y application.yml**, abra el archivo y edite los valores de las variables de entorno de acuerdo a su información:

```
    JDBC_URL=jdbc:mysql://localhost:3306/foro_alura?createDatabaseIfNotExist=true&serverTimezone=UTC
    ROOT=xxx
    PASSWORD=xxx
```

Reemplace los valores de **localhost, 3306, foro_alura, root y password** con la información de su servidor de base de datos.

7. Ejecutar el proyecto: en el menú **Run**, seleccione la opción Run.

### Requisitos 📄

1. Conocimientos básicos de programación: es probable que necesiten tener un conocimiento básico de programación, incluyendo conceptos como **variables, tipos de datos, condicionales y bucles**.

2. Conocimientos de Java: tenga conocimientos de **Java**, incluyendo la sintaxis básica, las estructuras de datos y el paradigma de **programación orientada a objetos**.

3. Conocimientos de Git: Si alguna persona quiere colaborar con el proyecto, necesitará tener conocimientos de **Git, GitLab ó GitHub** para poder clonar y contribuir al repositorio.

4. Familiaridad con Spring Boot: Se recomienda tener conocimientos básicos de **Spring Boot**, ya que el proyecto utiliza este framework para el desarrollo de la aplicación web.
5. Conocimientos de bases de datos: Se espera que la persona tenga conocimientos básicos de bases de datos y lenguajes de consulta (SQL), ya que el proyecto utiliza **MySQL como motor de base de datos y H2 para hacer test**.

6. Experiencia en desarrollo web: Poseer experiencia previa en el desarrollo de aplicaciones web utilizando HTML, CSS y JavaScript será beneficioso, ya que el proyecto involucra el desarrollo de **interfaces de usuario**.

7. Familiaridad con el uso de APIs: Ser capaz de consumir y trabajar con APIs será útil, ya que el proyecto puede requerir la **integración con servicios externos**.

8. Habilidades de resolución de problemas: Ser capaz de identificar y resolver **problemas de programación** de manera efectiva y eficiente es fundamental para trabajar en el proyecto.

## Uso 💪

La aplicación Alura Discussion Platform permite a los usuarios participar en discusiones y obtener respuestas a sus preguntas sobre diversos temas, los usuarios pueden registrar una cuenta y acceder a diferentes categorías de discusión para buscar temas de su interés, igualmente, pueden crear publicaciones, realizar preguntas y responder a otras publicaciones para contribuir a la comunidad y compartir conocimientos.

## Construido con 🛠️

<div style="display:flex;text-align: center; padding: 30px; gap:20px">
    <img src="/api/src/main/java/com/alura/foro/api/images/java.png" width="100px">
    <img src="/api/src/main/java/com/alura/foro/api/images/springboot.jpg" width="100px">
    <img src="/api/src/main/java/com/alura/foro/api/images/mysql.png" width="100px">
    <img src="/api/src/main/java/com/alura/foro/api/images/h2.png" width="100px">
</div>

## Deployment 🚀

El proyecto se enfoca en el **desarrollo del backend** del sistema Alura Discussion Platform donde se desarrolla siguiendo una arquitectura de capas, donde cada una tiene un propósito específico:

- **Controller**: Esta capa se encarga de recibir las solicitudes HTTP y dirigirlas al servicio correspondiente. Aquí se definen los endpoints y se realiza la validación de los datos de entrada.
- **DTO (Data Transfer Object)**: Los DTOs se utilizan para transferir datos entre las capas de la aplicación y los clientes. Sirven como objetos de transporte que encapsulan los datos necesarios para cada operación.
- **Errores**: En esta capa se manejan los errores y excepciones que puedan ocurrir durante la ejecución de la aplicación. Se definen clases de excepción personalizadas y se implementan manejadores de excepción para proporcionar respuestas claras y adecuadas al cliente.
- **Security**: Esta capa se encarga de la seguridad de la aplicación, incluyendo la autenticación y autorización de los usuarios. Se implementan mecanismos como JWT (JSON Web Tokens) para proteger los endpoints y controlar el acceso.
- **Modelo**: En esta capa se definen las entidades del dominio, que representan los objetos principales de la aplicación, como usuarios, publicaciones y respuestas. Estas entidades se mapean a tablas en la base de datos.
- **Repository**: Los repositorios son interfaces que definen métodos para interactuar con la base de datos. Se utilizan para realizar consultas y operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en las entidades.
- Service: La capa de servicio contiene la lógica de negocio de la aplicación. Aquí se implementan las operaciones y reglas de negocio, utilizando los repositorios para acceder a los datos.
- **Validations**: Esta capa se encarga de validar los datos de entrada antes de realizar cualquier operación. Se utilizan anotaciones de validación y validadores personalizados para asegurar que los datos sean correctos y consistentes.
- **DB Migration**: En esta capa se gestionan las migraciones de la base de datos. Se utilizan herramientas como Flyway para mantener y versionar la estructura de la base de datos de manera controlada.
- **Test**: Se realizan pruebas unitarias y de integración para asegurar el correcto funcionamiento de la aplicación. Se utilizan frameworks y bibliotecas de pruebas como JUnit y Mockito para escribir y ejecutar las pruebas.

## Autores ✒️

- **William Maldonado** - _Edición #4: Challenge ONE Back End Java + Spring - Implementando una API Rest_ - [Willydmq](https://gitlab.com/Willydmq)

## Expresiones de Gratitud

- Quiero expresar mi más profundo agradecimiento a **Alura Latam y Oracle ONE** por brindarme la oportunidad de participar en este desafío. A través de las enseñanzas de los tutores, he podido adquirir y aplicar nuevos conocimientos en el desarrollo de este proyecto. Su dedicación y esfuerzo en la creación de esta experiencia de aprendizaje han sido invaluables para mi desarrollo profesional.

- Estoy enormemente agradecido a **Alura Latam y Oracle ONE** por el desafío que me han presentado. Gracias a las enseñanzas de los tutores, he logrado superar obstáculos y alcanzar metas que parecían inalcanzables. Su apoyo constante y dedicación han sido fundamentales para mi crecimiento como profesional en el campo de la programación.

- No puedo expresar lo agradecido que estoy con Alura Latam y Oracle ONE por este desafío. **Gracias a las enseñanzas de los tutores**, he podido expandir mis conocimientos y habilidades en programación y desarrollo de software.

Estoy verdaderamente impresionado por el nivel de dedicación y esfuerzo que han puesto en esta experiencia de aprendizaje. Gracias por brindarme la oportunidad de crecer y superar mis límites 🌟.

---

⌨️ con ❤️ por [William Maldonado](https://gitlab.com/Willydmq) 😊

---
