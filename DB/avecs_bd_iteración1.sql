-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-05-2020 a las 00:34:11
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `avecs_bd_iteración1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--
CREATE database avecs_bd_iteración1;
use avecs_bd_iteración1;

CREATE TABLE `asistencia` (
  `estudiante_id` int(11) NOT NULL,
  `visita_id` int(11) NOT NULL,
  `aprobado` tinyint(1) NOT NULL,
  `fecha_registro` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `director_administrador`
--

CREATE TABLE `director_administrador` (
  `id_persona` int(11) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `user_id` int(11) NOT NULL,
  `fecha_salida` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento_apoyo`
--

CREATE TABLE `documento_apoyo` (
  `id_doc` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `direccion_url` mediumtext COLLATE utf8_spanish_ci NOT NULL,
  `visita_id` int(11) NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT current_timestamp(),
  `tipo_doc_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `nit` int(11) NOT NULL,
  `representante_legal` int(11) NOT NULL,
  `nombre_razon_social` varchar(200) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `persona_id` int(11) NOT NULL,
  `codigo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id_genero` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--

CREATE TABLE `grupo` (
  `id` int(11) NOT NULL,
  `materia` int(11) NOT NULL,
  `semestre` int(11) NOT NULL,
  `codigo_profesor` varchar(8) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id_materia` int(11) NOT NULL,
  `nombre` varchar(70) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `nombre_razon_social` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_id` int(11) NOT NULL,
  `apellido1` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido2` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `genero` int(11) DEFAULT NULL,
  `correo_contacto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `id_persona` int(11) NOT NULL,
  `codigo` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semestre`
--

CREATE TABLE `semestre` (
  `id_semestre` int(11) NOT NULL,
  `periodo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `anio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_doc_apoyo`
--

CREATE TABLE `tipo_doc_apoyo` (
  `id_tipo_doc` int(11) NOT NULL,
  `nombre` tinytext NOT NULL,
  `descripcion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_identificacion`
--

CREATE TABLE `tipo_identificacion` (
  `id_tipo_identificacion` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_creacion` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visita`
--

CREATE TABLE `visita` (
  `id_visita` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `grupo_id` int(11) NOT NULL,
  `empresa_nit` int(11) NOT NULL,
  `director_realizado` int(11) NOT NULL,
  `fecha_creada` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`estudiante_id`,`visita_id`),
  ADD KEY `estudiante_id` (`estudiante_id`),
  ADD KEY `visita_id` (`visita_id`);

--
-- Indices de la tabla `director_administrador`
--
ALTER TABLE `director_administrador`
  ADD PRIMARY KEY (`id_persona`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `id_persona` (`id_persona`);

--
-- Indices de la tabla `documento_apoyo`
--
ALTER TABLE `documento_apoyo`
  ADD PRIMARY KEY (`id_doc`,`visita_id`),
  ADD KEY `visita_id` (`visita_id`),
  ADD KEY `tipo_doc_id` (`tipo_doc_id`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`nit`),
  ADD KEY `representante_legal` (`representante_legal`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`persona_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `user_id_2` (`user_id`),
  ADD KEY `estudiante_user_fk` (`user_id`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_genero`);

--
-- Indices de la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `materia` (`materia`),
  ADD KEY `semestre` (`semestre`),
  ADD KEY `codigo_profesor` (`codigo_profesor`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id_materia`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`),
  ADD KEY `tipo_id_persona` (`tipo_id`),
  ADD KEY `genero_fk` (`genero`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id_persona`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD UNIQUE KEY `codigo_2` (`codigo`),
  ADD UNIQUE KEY `user_2` (`user`),
  ADD KEY `user` (`user`);

--
-- Indices de la tabla `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`id_semestre`);

--
-- Indices de la tabla `tipo_doc_apoyo`
--
ALTER TABLE `tipo_doc_apoyo`
  ADD PRIMARY KEY (`id_tipo_doc`);

--
-- Indices de la tabla `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  ADD PRIMARY KEY (`id_tipo_identificacion`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id_visita`),
  ADD KEY `grupo_id` (`grupo_id`),
  ADD KEY `empresa_nit` (`empresa_nit`),
  ADD KEY `director_realizado` (`director_realizado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `documento_apoyo`
--
ALTER TABLE `documento_apoyo`
  MODIFY `id_doc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id_genero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `semestre`
--
ALTER TABLE `semestre`
  MODIFY `id_semestre` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_doc_apoyo`
--
ALTER TABLE `tipo_doc_apoyo`
  MODIFY `id_tipo_doc` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_identificacion`
--
ALTER TABLE `tipo_identificacion`
  MODIFY `id_tipo_identificacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `estudiante_id_fk` FOREIGN KEY (`estudiante_id`) REFERENCES `estudiante` (`persona_id`),
  ADD CONSTRAINT `vsisita_id_asistencia_fk` FOREIGN KEY (`visita_id`) REFERENCES `visita` (`id_visita`);

--
-- Filtros para la tabla `director_administrador`
--
ALTER TABLE `director_administrador`
  ADD CONSTRAINT `admin_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `profesor_admin_fk` FOREIGN KEY (`id_persona`) REFERENCES `profesor` (`id_persona`);

--
-- Filtros para la tabla `documento_apoyo`
--
ALTER TABLE `documento_apoyo`
  ADD CONSTRAINT `tipo_doc_fk` FOREIGN KEY (`tipo_doc_id`) REFERENCES `tipo_doc_apoyo` (`id_tipo_doc`),
  ADD CONSTRAINT `visita_id_fk` FOREIGN KEY (`visita_id`) REFERENCES `visita` (`id_visita`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD CONSTRAINT `representante_fk` FOREIGN KEY (`representante_legal`) REFERENCES `persona` (`id_persona`);

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `estudiante_id_persona_fk` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id_persona`),
  ADD CONSTRAINT `estudiante_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `grupo`
--
ALTER TABLE `grupo`
  ADD CONSTRAINT `materia_grupo_fk` FOREIGN KEY (`materia`) REFERENCES `materia` (`id_materia`),
  ADD CONSTRAINT `profesor_grupo_fk` FOREIGN KEY (`codigo_profesor`) REFERENCES `profesor` (`codigo`),
  ADD CONSTRAINT `semestre_grupo_fk` FOREIGN KEY (`semestre`) REFERENCES `semestre` (`id_semestre`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `genero_fk` FOREIGN KEY (`genero`) REFERENCES `genero` (`id_genero`),
  ADD CONSTRAINT `tipo_id_fk` FOREIGN KEY (`tipo_id`) REFERENCES `tipo_identificacion` (`id_tipo_identificacion`);

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `profesor_persona_id` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `profesor_user` FOREIGN KEY (`user`) REFERENCES `user` (`id`);

--
-- Filtros para la tabla `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `director_id_fk` FOREIGN KEY (`director_realizado`) REFERENCES `director_administrador` (`id_persona`),
  ADD CONSTRAINT `visita_empresa_fk` FOREIGN KEY (`empresa_nit`) REFERENCES `empresa` (`nit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
