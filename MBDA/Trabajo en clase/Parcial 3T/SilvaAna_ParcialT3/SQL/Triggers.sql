CREATE OR REPLACE TRIGGER T1_Asignaciones
BEFORE INSERT ON Asignaciones
FOR EACH ROW
DECLARE
valorNumero INTEGER;
BEGIN 
    SELECT COUNT(*)+1 INTO valorNumero FROM Asignaciones;
    :new.numero := valorNumero;
END;



CREATE OR REPLACE TRIGGER T1_Familias
BEFORE INSERT ON Familias
FOR EACH ROW
DECLARE
valorNumero INTEGER;
BEGIN 
    SELECT COUNT(*)+1 INTO valorNumero FROM Familias;
    :new.numero := valorNumero;
END;

CREATE OR REPLACE TRIGGER T1_Personas
BEFORE INSERT ON Personas
FOR EACH ROW
DECLARE
valorNumero INTEGER;
BEGIN 
    SELECT COUNT(*)+1 INTO valorNumero FROM Personas;
    :new.codigo := valorNumero;
END;

CREATE OR REPLACE TRIGGER T1_Opiniones
BEFORE INSERT ON Opiniones
FOR EACH ROW
DECLARE
valorNumero INTEGER;
BEGIN 
    SELECT COUNT(*)+1 INTO valorNumero FROM Opiniones;
    :new.numero := valorNumero;
END;









