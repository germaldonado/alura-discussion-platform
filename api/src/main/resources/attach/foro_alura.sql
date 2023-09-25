-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: foro_alura
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `activo` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'Biologia','CIENCIAS',1),(2,'Frontend','PROGRAMACION',1),(3,'Software','SISTEMAS',1),(4,'Backend','PROGRAMACION',1);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','create-table-usuarios','SQL','V1__create-table-usuarios.sql',180921081,'root','2023-09-24 00:34:32',38,1),(2,'2','create-table-cursos','SQL','V2__create-table-cursos.sql',-972347564,'root','2023-09-24 00:34:32',83,1),(3,'3','create-table-topicos','SQL','V3__create-table-topicos.sql',968941329,'root','2023-09-24 00:34:32',37,1),(4,'4','create-table-respuestas','SQL','V4__create-table-respuestas.sql',-375878699,'root','2023-09-24 00:34:32',96,1),(5,'5','add-items-cursos','SQL','V5__add-items-cursos.sql',-176085582,'root','2023-09-24 00:34:32',10,1),(6,'6','alter-table-add-activo','SQL','V6__alter-table-add-activo.sql',845005734,'root','2023-09-24 00:34:32',60,1),(7,'7','insert into-table-usuarios','SQL','V7__insert_into-table-usuarios.sql',755527104,'root','2023-09-24 00:34:32',5,1),(8,'8','insert-into-table-usuarios','SQL','V8__insert-into-table-usuarios.sql',-1331611023,'root','2023-09-24 00:35:29',67,0);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuestas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(350) NOT NULL,
  `topico_id` bigint NOT NULL,
  `fecha_creacion` date NOT NULL,
  `autor_id` bigint NOT NULL,
  `solucion` tinyint(1) NOT NULL,
  `activo` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `topico_id` (`topico_id`),
  KEY `autor_id` (`autor_id`),
  CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`topico_id`) REFERENCES `topicos` (`id`),
  CONSTRAINT `respuestas_ibfk_2` FOREIGN KEY (`autor_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topicos`
--

DROP TABLE IF EXISTS `topicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topicos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `mensaje` varchar(350) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `estado` varchar(30) NOT NULL,
  `autor_id` bigint NOT NULL,
  `curso_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `titulo` (`titulo`),
  UNIQUE KEY `mensaje` (`mensaje`),
  KEY `autor_id` (`autor_id`),
  KEY `curso_id` (`curso_id`),
  CONSTRAINT `topicos_ibfk_1` FOREIGN KEY (`autor_id`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `topicos_ibfk_2` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topicos`
--

LOCK TABLES `topicos` WRITE;
/*!40000 ALTER TABLE `topicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `topicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contrasena` varchar(200) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `activo` tinyint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'ADMIN','admin@admin.com','$2a$10$pIooahpd03fOKWTEbUjKlu6OBxbnHeEb6wphHq.9dvCSABRm/zdqm','ROLE_ADMIN',1),(2,'email','email@email.com','$2a$10$IHvNhjYLrulKcDuUKYhO.Or60/Nw7WM0CPksZlbJZlsN3MICDegUe','ROLE_USER',0),(3,'email1','email1@email.com','$2a$10$8LypPW/3AvJdWVUA90U8A.W2tFmNy0e5bAZ2Ya9XKnEaZalL0N41a','ROLE_USER',1),(4,'email2','email2@email.com','$2a$10$77CYWCYARamGx3SEHEO5jOl8/.hTKdeFh397CUSKG1ZLsxy7dRhIy','ROLE_MOD',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-25 16:54:02
