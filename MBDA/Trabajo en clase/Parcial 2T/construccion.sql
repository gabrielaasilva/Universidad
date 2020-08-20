--CONSTRUCCION ORACLE
--1. ESTRUCTURA DE TABLAS

CREATE TABLE persona(
	tipoDocumento varchar(3) NOT NULL,
	numeroDocumento varchar(10) NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido varchar(50) NOT NULL
);

CREATE TABLE email(
	tidPersona varchar(3) NOT NULL,
	nidPersona varchar(10) NOT NULL,
	email varchar (50) NOT NULL,
);

CREATE TABLE consultor(
	tipoDocumento varchar(3) NOT NULL,
	numeroDocumento varchar(10) NOT NULL
);

CREATE TABLE estudiante(
	tipoDocumento varchar(3) NOT NULL,
	numeroDocumento varchar(10) NOT NULL,
	nivelEducativo varchar(50) NOT NULL
);

CREATE TABLE profesor(
	tipoDocumento varchar(3) NOT NULL,
	numeroDocumento varchar(10) NOT NULL,
	especialidad varchar(50) NOT NULL,
	tarjetaProfesional varchar (15) NOT NULL
);

CREATE TABLE tematica(
	nombre varchar(50) NOT NULL,
	descripcion varchar (500),
	tdConsultor varchar(3) NOT NULL,
	ndCosultor varchar(10) NOT NULL	
);

CREATE TABLE pregunta(
	codigo varchar(2) NOT NULL,
	estado varchar(20) NOT NULL,
	formulacion varchar(500) NOT NULL,
	fechaCreacion date,	
	tdEstudinate varchar(3) NOT NULL,
	ndEstudiante varchar(10) NOT NULL,
);

CREATE TABLE respuesta(
	codigo varchar(2) NOT NULL,
	respuesta varchar(1000) NOT NULL,
	fechaCreacion date,
	tdProfesor varchar(3) NOT NULL,
	ndProfesor varchar(10) NOT NULL
);

CREATE TABLE respuestatienefuentesinformativas(
	codigoRespuesta varchar(2) NOT NULL,
	codigoFuenteInformativavarchar(2) NOT NULL
);

CREATE TABLE fuenteInformativa(
	codigo varchar(2) NOT NULL,
	referencia varchar(1000) NOT NULL,
);

CREATE TABLE Experiencia(
	codigo  varchar(2) NOT NULL,
	fechaInicial DATE not null,
	fechaFinal date, 
	cargo varchar (50) NOT NULL, 
	tdProfesor varchar(3) NOT NULL,
	ndProfesor varchar(10) NOT NULL
);

CREATE TABLE certificado(
	codigo  varchar(2) NOT NULL,
	fecha DATE not null,
	fechaFinal date, 
	titulo varchar (50) NOT NULL, 
	tdProfesor varchar(3) NOT NULL,
	ndProfesor varchar(10) NOT NULL
);

CREATE TABLE proyecto(
	codigo  varchar(2) NOT NULL,
	tema varchar(20) not null,
	rol varchar(20) not null, 
	duracion varchar (50) NOT NULL, 
	tdProfesor varchar(3) NOT NULL,
	ndProfesor varchar(10) NOT NULL
);











