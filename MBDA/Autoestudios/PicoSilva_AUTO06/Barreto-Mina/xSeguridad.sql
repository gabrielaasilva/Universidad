/*Eliminar los paquetes*/
DROP PACKAGE PC_VENTA;
DROP PACKAGE PC_MODELO;
/*Eliminar permisos*/
REVOKE ALL PRIVILEGES FROM VENTA;
REVOKE ALL PRIVILEGES FROM MODELO;