create database nexos;

use nexos;

CREATE TABLE `libro` (
  `id_libro` int(11) NOT NULL,  
  `titulo` varchar(250) NOT NULL,
  `año` varchar(4) DEFAULT NULL,
  `genero` char(1) NOT NULL,
  `numero_paginas` int(11) NOT NULL,
  `id_editorial` int(11) DEFAULT NULL,
  `id_autor` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `autor` (
  `id_autor` int(11) NOT NULL,  
  `nombre` varchar(250) DEFAULT NULL,
  `fecha_nacimiento` datetime DEFAULT NULL,
  `ciudad_procedencia` varchar(250) DEFAULT NULL,
  `correo` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `editorial` (
  `id_editorial` int(11) NOT NULL,  
  `nombre` varchar(250) NOT NULL,
  `direccion_correspondecia` varchar(250) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `correo` varchar(250) DEFAULT NULL,
  `maximo_libros` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `libro`
  ADD PRIMARY KEY (`id_libro`);
  
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id_autor`);
  
ALTER TABLE `editorial`
  ADD PRIMARY KEY (`id_editorial`);
  
  ALTER TABLE `libro`
  MODIFY `id_libro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  
  ALTER TABLE `autor`
  MODIFY `id_autor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  
  ALTER TABLE `editorial`
  MODIFY `id_editorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
  
ALTER TABLE libro 
ADD CONSTRAINT fk_libro_editorial
FOREIGN KEY (id_editorial) 
REFERENCES editorial (id_editorial);

ALTER TABLE libro 
ADD CONSTRAINT fk_libro_autor
FOREIGN KEY (id_autor) 
REFERENCES autor (id_autor);