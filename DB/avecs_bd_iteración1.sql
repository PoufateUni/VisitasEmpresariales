-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 08-05-2020 a las 21:03:45
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
CREATE DATABASE IF NOT EXISTS `avecs_bd_iteración1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `avecs_bd_iteración1`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--
-- Creación: 08-05-2020 a las 04:21:53
--

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
-- Creación: 08-05-2020 a las 17:16:25
-- Última actualización: 08-05-2020 a las 18:20:11
--

CREATE TABLE `director_administrador` (
  `id_director` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `director_administrador`
--

INSERT INTO `director_administrador` (`id_director`, `fecha_entrada`, `fecha_salida`) VALUES
('002', '2020-05-03', '2020-05-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento_apoyo`
--
-- Creación: 08-05-2020 a las 04:21:56
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
-- Creación: 08-05-2020 a las 17:34:39
--

CREATE TABLE `empresa` (
  `nit` int(11) NOT NULL,
  `representante_legal` int(11) NOT NULL,
  `nombre_razon_social` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `representante_id_tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--
-- Creación: 08-05-2020 a las 18:18:05
-- Última actualización: 08-05-2020 a las 18:18:22
--

CREATE TABLE `estudiante` (
  `persona_id` int(11) NOT NULL,
  `id_tipo_personal` int(11) NOT NULL,
  `codigo` varchar(8) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`persona_id`, `id_tipo_personal`, `codigo`) VALUES
(1, 1, '1'),
(5, 4, '2'),
(1, 2, '3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--
-- Creación: 08-05-2020 a las 04:21:47
-- Última actualización: 08-05-2020 a las 18:05:36
--

CREATE TABLE `genero` (
  `id_genero` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id_genero`, `nombre`) VALUES
(1, 'masculino'),
(2, 'femenino'),
(3, 'otro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupo`
--
-- Creación: 08-05-2020 a las 04:21:59
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
-- Creación: 08-05-2020 a las 04:21:40
--

CREATE TABLE `materia` (
  `id_materia` int(11) NOT NULL,
  `nombre` varchar(70) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--
-- Creación: 08-05-2020 a las 18:08:23
-- Última actualización: 08-05-2020 a las 18:16:15
--

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_id` int(11) NOT NULL,
  `apellido1` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido2` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `genero` int(11) DEFAULT NULL,
  `correo_contacto` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `nombre`, `tipo_id`, `apellido1`, `apellido2`, `genero`, `correo_contacto`, `fecha_nacimiento`) VALUES
(1, 'Pedro', 1, 'Infante', 'Pabón', 1, 'pedro@gmail.com', '1989-12-10'),
(1, 'Pedrosca', 2, 'perez', 'sloth', 1, '', '1998-05-27'),
(2, 'Maria', 1, 'Antoñanzas', 'traiter', 2, '', '1997-05-13'),
(3, 'Fabian', 4, 'Jurimengoro', 'gosipelo', 1, '', '1993-03-16'),
(4, 'Jan', 1, 'tempo', 'crono', 1, '', '2000-07-22'),
(5, 'Arkantos', 4, 'Atlan', 'tuspide', 1, '', '1998-05-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--
-- Creación: 08-05-2020 a las 18:19:53
-- Última actualización: 08-05-2020 a las 18:19:42
--

CREATE TABLE `profesor` (
  `id_persona` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `codigo` varchar(8) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id_persona`, `id_tipo`, `codigo`) VALUES
(3, 4, '002'),
(4, 1, '01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `semestre`
--
-- Creación: 08-05-2020 a las 04:21:50
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
-- Creación: 08-05-2020 a las 04:21:51
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
-- Creación: 08-05-2020 a las 04:21:51
-- Última actualización: 08-05-2020 a las 18:06:32
--

CREATE TABLE `tipo_identificacion` (
  `id_tipo_identificacion` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_identificacion`
--

INSERT INTO `tipo_identificacion` (`id_tipo_identificacion`, `nombre`) VALUES
(1, 'cc'),
(2, 'ti'),
(3, 'pasaporte'),
(4, 'extranjeria');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--
-- Creación: 08-05-2020 a las 18:04:11
-- Última actualización: 08-05-2020 a las 19:00:43
--

CREATE TABLE `tipo_usuario` (
  `identificador` varchar(1) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_usuario`
--

INSERT INTO `tipo_usuario` (`identificador`, `nombre`) VALUES
('A', 'Admin'),
('D', 'Docente'),
('E', 'estudiante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--
-- Creación: 08-05-2020 a las 18:57:41
-- Última actualización: 08-05-2020 a las 19:00:58
--

CREATE TABLE `usuario` (
  `id_persona` int(11) NOT NULL,
  `email` varchar(120) COLLATE utf8_spanish_ci NOT NULL,
  `contrasena` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `fecha_creacion` datetime DEFAULT current_timestamp(),
  `id_persona_tipo` int(11) NOT NULL,
  `codigo` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `tipo_usuario` varchar(1) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_persona`, `email`, `contrasena`, `fecha_creacion`, `id_persona_tipo`, `codigo`, `tipo_usuario`) VALUES
(1, 'pedro', '123', '2020-05-08 14:00:58', 1, '1', 'E');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visita`
--
-- Creación: 08-05-2020 a las 17:21:54
--

CREATE TABLE `visita` (
  `id_visita` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `grupo_id` int(11) NOT NULL,
  `empresa_nit` int(11) NOT NULL,
  `director_realizado` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
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
  ADD PRIMARY KEY (`id_director`);

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
  ADD KEY `representante_legal` (`representante_legal`),
  ADD KEY `representante_id_tipo` (`representante_id_tipo`),
  ADD KEY `persona_repres_fk` (`representante_legal`,`representante_id_tipo`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`persona_id`,`id_tipo_personal`),
  ADD UNIQUE KEY `codigo_2` (`codigo`),
  ADD KEY `codigo` (`codigo`);

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
  ADD PRIMARY KEY (`id_persona`,`tipo_id`),
  ADD KEY `tipo_id_persona` (`tipo_id`),
  ADD KEY `genero_fk` (`genero`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`id_persona`,`id_tipo`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD UNIQUE KEY `codigo_2` (`codigo`);

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
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`identificador`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_persona`,`id_persona_tipo`),
  ADD KEY `tipo_usuario_fk` (`tipo_usuario`),
  ADD KEY `codigo` (`codigo`,`tipo_usuario`);

--
-- Indices de la tabla `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id_visita`),
  ADD KEY `grupo_id` (`grupo_id`),
  ADD KEY `empresa_nit` (`empresa_nit`),
  ADD KEY `visita_director_fk` (`director_realizado`);

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
  MODIFY `id_genero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
  MODIFY `id_tipo_identificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  ADD CONSTRAINT `codigo_profesor` FOREIGN KEY (`id_director`) REFERENCES `profesor` (`codigo`) ON UPDATE CASCADE;

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
  ADD CONSTRAINT `persona_repres_fk` FOREIGN KEY (`representante_legal`,`representante_id_tipo`) REFERENCES `persona` (`id_persona`, `tipo_id`);

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `estudiante_persona_fk` FOREIGN KEY (`persona_id`,`id_tipo_personal`) REFERENCES `persona` (`id_persona`, `tipo_id`);

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
  ADD CONSTRAINT `id_personal_fk` FOREIGN KEY (`id_persona`,`id_tipo`) REFERENCES `persona` (`id_persona`, `tipo_id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `id_persona_fk` FOREIGN KEY (`id_persona`,`id_persona_tipo`) REFERENCES `persona` (`id_persona`, `tipo_id`),
  ADD CONSTRAINT `tipo_usuario_fk` FOREIGN KEY (`tipo_usuario`) REFERENCES `tipo_usuario` (`identificador`);

--
-- Filtros para la tabla `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `visita_director_fk` FOREIGN KEY (`director_realizado`) REFERENCES `director_administrador` (`id_director`),
  ADD CONSTRAINT `visita_empresa_fk` FOREIGN KEY (`empresa_nit`) REFERENCES `empresa` (`nit`),
  ADD CONSTRAINT `visita_grupo_fk` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
