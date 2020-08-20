--Llaves

--Primarias
ALTER TABLE Asignaciones
ADD CONSTRAINT PK_idAsignaciones PRIMARY KEY (numero);
ALTER TABLE AsigancionesPorBienes
ADD CONSTRAINT PK_numeroCodigo PRIMARY KEY(numero,codigo);
ALTER TABLE BIENES
ADD CONSTRAINT PK_idBienes PRIMARY KEY(codigo);
ALTER TABLE BienesParaFamilia
ADD CONSTRAINT PK_codigoBienFamilia PRIMARY KEY(codigoBien,numeroFamilia);
ALTER TABLE Familias
ADD CONSTRAINT PK_Familias PRIMARY KEY (numero);
ALTER TABLE Personas
ADD CONSTRAINT PK_Personas PRIMARY KEY(codigo);
ALTER TABLE Opiniones
ADD CONSTRAINT PK_Opiniones PRIMARY KEY(numero);
ALTER TABLE OpinionesGrupales
ADD CONSTRAINT PK_OpinionesGrupales PRIMARY KEY(numero);

--Foráneas

ALTER TABLE Asignaciones
ADD CONSTRAINT FK_Asignaciones FOREIGN KEY(numeroFamilia) REFERENCES Familias(numero);
ALTER TABLE AsigancionesPorBienes
ADD CONSTRAINT FK_numeroF  FOREIGN KEY(numero) REFERENCES Asignaciones(numero);
ALTER TABLE AsigancionesPorBienes
ADD CONSTRAINT FK_codigo FOREIGN KEY(codigo) REFERENCES BIENES(codigo);
ALTER TABLE BienesParaFamilia
ADD CONSTRAINT FK_codigoBien FOREIGN KEY(codigoBien) REFERENCES BIENES(codigo);
ALTER TABLE BienesParaFamilia
ADD CONSTRAINT FK1_numeroF FOREIGN KEY(numeroFamilia) REFERENCES  Familias(numero);
ALTER TABLE Personas
ADD CONSTRAINT FK2_numeroF FOREIGN KEY(numeroFamilia) REFERENCES Familias(numero);
ALTER TABLE Opiniones
ADD CONSTRAINT FK1_opiniones FOREIGN KEY(codigoBien) REFERENCES BIENES(codigo);
ALTER TABLE Opiniones
ADD CONSTRAINT FK2_opiniones FOREIGN KEY(codigoPersonas) REFERENCES personas(codigo);
ALTER TABLE OpinionesGrupales
ADD CONSTRAINT FK_OpinionesGrupales FOREIGN KEY(numero) REFERENCES Opiniones(numero);


--Unicas
ALTER TABLE Personas
ADD CONSTRAINT UK_Personas UNIQUE (numeroFamilia);
ALTER TABLE Opiniones
ADD CONSTRAINT UK_Opiniones UNIQUE (justificacion);
