ALTER TABLE persona
ADD CONSTRAINT PK_persona PRIMARY KEY (tipoDocumento, numeroDocumento);
ALTER TABLE consultor
ADD CONSTRAINT PK_consultor PRIMARY KEY (tipoDocumento, numeroDocumento);
ALTER TABLE estudiante
ADD CONSTRAINT PK_estudiante PRIMARY KEY (tipoDocumento, numeroDocumento);
ALTER TABLE profesor
ADD CONSTRAINT PK_profesor PRIMARY KEY (tipoDocumento, numeroDocumento);
ALTER TABLE tematica
ADD CONSTRAINT PK_tematica PRIMARY KEY (nombre);
ALTER TABLE pregunta
ADD CONSTRAINT PK_pregunta PRIMARY KEY (codigo);
ALTER TABLE respuesta
ADD CONSTRAINT PK_respuesta PRIMARY KEY (codigo);
ALTER TABLE experiencia
ADD CONSTRAINT PK_experiencia PRIMARY KEY (codigo);
ALTER TABLE certificado
ADD CONSTRAINT PK_certificado PRIMARY KEY (codigo);
ALTER TABLE estudio
ADD CONSTRAINT PK_estudio PRIMARY KEY (codigo);
ALTER TABLE proyecto
ADD CONSTRAINT PK_proyecto PRIMARY KEY (codigo);





ALTER TABLE tematica
ADD CONSTRAINT UK1_tematica UNIQUE (comentarios);
ALTER TABLE certificado
ADD CONSTRAINT UK2_certificado UNIQUE (codigoE);


ALTER TABLE consultor
ADD CONSTRAINT FK_consultoro FOREIGN KEY (tipoDocumento, numeroDocumento) REFERENCES persona(tipoDocumento, numeroDocumento);
ALTER TABLE estudiante
ADD CONSTRAINT FK_estudiante FOREIGN KEY (tipoDocumento, numeroDocumento) REFERENCES persona(tipoDocumento, numeroDocumento);
ALTER TABLE profesor
ADD CONSTRAINT FK_profesor FOREIGN KEY (tipoDocumento, numeroDocumento) REFERENCES persona(tipoDocumento, numeroDocumento);
ALTER TABLE tematica
ADD CONSTRAINT FK_tematica FOREIGN KEY (tdConsultor, ndConsultor) REFERENCES consultor(tipoDocumento, numeroDocumento);

