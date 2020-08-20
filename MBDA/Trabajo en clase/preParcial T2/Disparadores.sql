------------MODELO RELACIONAL: INTEGRIDAD PROCEDIMENTAL. SQL(ESTANDAR)
-------REGISTRAR SERVICIO
--Adicionar

/*Datos para automatizar(código y fecha),El codigo de servicio esta definido por el prefijo SRx, donde x es un número de 5 digitos*/
CREATE OR REPLACE TRIGGER T1_Servicio
BEFORE INSERT ON Servicio
FOR EACH ROW
DECLARE
valorNumero INTEGER;
nuevaFecha DATE;
BEGIN 
    SELECT COUNT(*)+1 INTO valorNumero FROM Servicio;
    SELECT CURRENT_DATE INTO nuevaFecha FROM DUAL;
    :new.codigo :=CONCAT('SR',valorNumero);
    :new.fecha := nuevaFecha;
END;

/* No se puede adicionar un servicio relacionado con un programa diferente al que tiene asignado cada familia*/
CREATE OR REPLACE TRIGGER Ad_ProgramaFamilia
BEFORE INSERT ON Servicio
FOR EACH ROW
DECLARE
tmp INTEGER;
BEGIN
    SELECT COUNT(*) INTO tmp FROM Familias x JOIN Programas y
    ON (x.codigoPrograma = y.codigo) JOIN Servicios z 
    ON (y.codigo = z.codigoPrograma) AND :new.codigo = x.codigoPrograma
    AND :new.codigo = z.codigoPrograma;
    IF tmp > 0 THEN
        raise_aplication_error(-2002, 'La familia no está relacionada con el programa');
    END IF;
END;

/*No se puede asignar un servicio a un voluntario que se encuentre retirado*/
CREATE OR REPALCE TRIGGER T3_Servicio
BEFORE INSERT ON Servicio
FOR EACH ROW 
DECLARE
numero INTEGER;
BEGIN   
    SELECT COUNT(*) INTO numero FROM beneficiario JOIN voluntario ON(Beneficiario.tipoDocumento = voluntario.tipoDocumento) 
    AND beneficiario.numeroDocumento = voluntario.numeroDocumento WHERE voluntario.fechaRetiro IS NOT NULL AND :new.numeroDocumento = beneficiario.numeroDocumento;

    IF numero > 0
     THEN 
        raise_application_error(-202003131,'Usted no se escuentra entrenando al atleta solicitado');
    END IF;
END;

--Modificar
/*No se puede cambiar el programa asociado a cada servicio*/
CREATE OR REPLACE TRIGGER T4_SERVICIO
BEFORE UPDATE ON Servicio
FOR EACH ROW
BEGIN
    IF :new.codigoPrograma <> :old.codigoPrograma
        THEN
            raise_application_error(-2000021,'No se pueden actualizar');
    END IF
END;

/*El voluntario asignado a un servicio se puede cambiar siempre y cuando no se haya retirado*/
CREATE OR REPLACE TRIGGER T5_SERVICIO
BEFORE UPDATE ON Servicio 
FOR EACH ROW
DECLARE
valor INTEGER;
BEGIN   
    SELECT COUNT(*) INTO valor FROM beneficiario JOIN voluntario ON (Beneficiario.tipoDocumento = voluntario.tipoDocumento) 
    AND beneficiario.numeroDocumento = voluntario.numeroDocumento WHERE voluntario.fechaRetiro IS NOT NULL;

    IF valor>=1
        THEN
            raise_application_error(-2000021,'No se pueden actualizar');  
    END IF;
END;  

/*Si se modifica el tipo y número de documento de un beneficiario, se actualiza los servicios asociados a él.*/
CREATE OR REPLACE TRIGGER UP_Voluntarios_Servicios
BEFORE UPDATE ON Voluntarios
FOR EACH ROW
DECLARE
BEGIN
    UPDATE Servicios SET TipoDocumento = :new.TipoDocumento, NumeroDocumento = :new.TipoDocumento 
        WHERE TipoDocumento = :old.TipoDocumento AND NumeroDocumento = :old.TipoDocumento;    
END;
/*De cada tipo de servicio se puede modificar*/
--Huerta: área total.
CREATE OR REPLACE TRIGGER T5_SERVICIO
BEFORE UPDATE ON Huerta
FOR EACH ROW
BEGIN
    IF :new.codigo<>:old.codigo OR :new.ubicacion <>:old.ubicacion OR :new.idFamilia <>:old.idFamilia
    THEN
        raise_application_error(-2000021,'No se puede modificar');
    END IF;
END;

--Empleo: cargo.
CREATE OR REPLACE TRIGGER T5_SERVICIO
BEFORE UPDATE ON Empleo
FOR EACH ROW
BEGIN
    IF :new.codigo<>:old.codigo OR :new.NITEmpleador <>:old.NITEmpleador OR :new.tid <>:old.tid OR :new.nid <>:old.nid
    THEN
        raise_application_error(-2000021,'No se puede modificar');
    END IF;
END;

--Capacitación: Hora y auditorio, siempre y cuando la fecha del servicio sea anterior a la fecha actual.

--Valoración médica: Hora siempre y cuando la fecha del servicio sea anterio a la fecha actual.
CREATE OR REPLACE TRIGGER UP_Tratamiento
BEFORE UPDATE ON Valoraciones_Medicas
FOR EACH ROW
BEGIN
    IF UPDATING('tratamientoDesparacitacion')  THEN
        raise_application_error(-20001,'No se puede modificar ');
    END IF;   
END;
--Eliminar
/*Un servicio no se puede eliminar si la fecha es posterior a la fecha actual.*/
CREATE OR REPLACE TRIGGER T8_SERVICIO
BEFORE DELETE ON Servicio
FOR EACH ROW
BEGIN
    IF (SELECT fecha > SYSDATE FROM DUAL);
        raise_application_error(-2007, 'No se pueden eliminar porque la fecha es posterior a la actual');
    END IF;
/*Si se elimina un beneficiario, los servicio asociados a él quedan referenciando a un beneficiario indefinido.*/

















