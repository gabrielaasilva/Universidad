
-- CRUDE OPINION

CREATE OR REPLACE PACKAGE PC_Opinion IS
    PROCEDURE AD_Opinion (xfecha IN DATE, xopinion IN VARCHAR, xjustificacion IN VARCHAR, xcodigoBien IN CHAR, xcodigoPersonas IN NUMBER );
    FUNCTION CO_Opinion (xfecha IN DATE, xopinion IN VARCHAR, xjustificacion IN VARCHAR, xcodigoBien IN CHAR, xcodigoPersonas IN NUMBER);
END PC_Opinion; 
