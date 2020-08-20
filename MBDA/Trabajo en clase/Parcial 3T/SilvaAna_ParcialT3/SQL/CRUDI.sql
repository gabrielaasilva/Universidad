CREATE OR REPLACE BODY  PACKAGE PC_Opinion IS
    PROCEDURE AD_Opinion(xfecha IN DATE, xopinion IN VARCHAR, xjustificacion IN VARCHAR, xcodigoBien IN CHAR, xcodigoPersonas IN NUMBER) IS
        BEGIN 
            INSERT INTO Opinion(fecha,opinion, justificacion ,codigoBien,codigoPersonas) VALUES 
                (xfecha, xopinion, xjustificacion, xcodigoBien, xcodigoPersonas);

            COMMIT;
            EXCEPTION
            WHEN OTHERS THEN
                ROLLBACK;
                RAISE_APPLICATION_ERROR(-200001, 'Error al insertar opinion');
        END Ad_ZonaComunes;

    FUNCTION CO_Opinion(xfecha IN DATE, xopinion IN VARCHAR, xjustificacion IN VARCHAR, xcodigoBien IN CHAR, xcodigoPersonas IN NUMBER) RETURN SYS_REFCURSOR IS CO_Opinion SYS_REFCURSOR;
     BEGIN
            OPEN CO_Opinion FOR
                SELECT fecha,opinion, justificacion ,codigoBien,codigoPersonas FROM Opinion;
            RETURN CO_Opinion;
        END CO_Opinion;

END PC_Opinion;
