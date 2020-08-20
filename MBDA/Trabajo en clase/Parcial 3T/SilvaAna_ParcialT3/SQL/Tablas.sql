--Tablas
create table Asignaciones(
    numero NUMBER(9) NOT NULL,
    fecha DATE NOT NULL,
    aceptado BOOLEAN,
    numeroFamilia NUMBER(5) NOT NULL
);

create table AsigancionesPorBienes(
    numero NUMBER(9) NOT NULL,
    codigo CHAR(7) NOT NULL
);

create table BIENES (
	codigo CHAR(7) NOT NULL,
	nombre VARCHAR(30) NOT NULL,
	medida CHAR(2) NOT NULL,
	unitario NUMBER(5) NOT NULL,
	retirado CHAR(1) NOT NULL,
);

create table BienesParaFamilia(
    codigoBien CHAR(7) NOT NULL,
    numeroFamilia NUMBER(5) NOT NULL
);

create table Familias (
	numero NUMBER(5) NOT NULL
);

create table Personas(
    codigo NUMBER(7) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    numeroFamilia NUMBER(5) NOT NULL
);

create table Opiniones(
    numero NUMBER(5) NOT NULL,
    fecha DATE NOT NULL,
    opinion VARCHAR(1) NOT NULL,
    justificacion VARCHAR(20) NOT NULL,
    codigoBien CHAR(7) NOT NULL,
    codigoPersonas NUMBER(7) NOT NULL
);

create table OpinionesGrupales(
    numero NUMBER(5) NOT NULL,
    detalle XMLTYPE NOT NULL,
    estrellas NUMBER (1) NOT NULL

);


