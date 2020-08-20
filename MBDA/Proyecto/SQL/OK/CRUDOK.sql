/*PRUEBAS PARA COMPROBAR LOS PAQUETES*/
BEGIN
PC_ZonasComunes.Ad_ZonaComunes(700,1830,'Canchas');
end; 

BEGIN
PC_Usuarios.Ad_Usuario('cra 70 N° 2 - 20','Ana Gabriela Silva','1192793547','CC');
end;

BEGIN 
PC_Usuarios.Ad_UsuariosTelefonos('3105743316');
end;

BEGIN
PC_Usuarios.Ad_UsuariosEmail('anagabriela1227@gmail.com');
end;

SELECT.PC_Usuarios.Co_UsuariosTelefonos('3105743316') FROM DUAL;
SELECT.PC_Usuarios. Co_UsuariosEmai('anagabriela1227@gmail.com') FROM DUAL;


BEGIN
PC_Usuarios.Ad_Usuario('KR 65 57B 35','YANETH MARTINEZ HERRERA','51820312','CC');
end;

BEGIN 
PC_Usuarios.Ad_UsuariosTelefonos(1,'3103408490');
PC_Usuarios.Ad_UsuariosTelefonos(2,'3024184991');
end;

BEGIN
PC_Usuarios.Ad_UsuariosEmail(1,'RODRIGO.GUALTERO-M@ESCUELAING.EDU.CO');
end;

