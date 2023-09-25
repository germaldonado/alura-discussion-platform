ALTER TABLE usuarios ADD activo TINYINT;
UPDATE usuarios SET activo=1;

ALTER TABLE cursos ADD activo TINYINT;
UPDATE cursos SET activo=1;

ALTER TABLE respuestas ADD activo TINYINT;
UPDATE respuestas SET activo=1;