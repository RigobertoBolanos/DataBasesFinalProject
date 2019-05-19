CREATE OR REPLACE PACKAGE pkCliente AS -- spec
PROCEDURE pInsertarCliente(cedula VARCHAR2, nombre VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2);
PROCEDURE pEliminarCliente (cedula VARCHAR2);
PROCEDURE pModificarCliente(nombre VARCHAR2, cedula VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2);
FUNCTION fConsultarCliente(cedula VARCHAR2) RETURN VARCHAR2;
END pkEmpleados;
/

CREATE OR REPLACE PACKAGE BODY pkCliente AS -- body

-- Implementación Procedimiento 1
PROCEDURE pInsertarCliente
(cedula VARCHAR2, nombre VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2)
IS
BEGIN
    INSERT INTO Cliente
    VALUES (cedula, nombre, fechaNacimiento, direccion,
    telefono);
END pInsertarCliente;

-- Implementación Procedimiento 2
PROCEDURE pEliminarCliente(cedulaCli VARCHAR2) IS
BEGIN
    DELETE FROM Cliente WHERE Cliente.cedula = cedulaCli;
END pEliminarCliente;

-- Implementación Procedimiento 3
PROCEDURE pModificarCliente(cedulaCli VARCHAR2, nombreCli VARCHAR2, fechaNacimientoCli DATE, direccionCli VARCHAR2, telefonoCli VARCHAR2) IS
BEGIN
    UPDATE Cliente SET Cliente.nombre=nombreCli,Cliente.fechaNacimiento=fechaNacimientoCli,Cliente.direccion=direccionCli, Cliente.telefono=telefonoCli
    WHERE cliente.cedula=cedulaCli;
END pModificarCliente;

-- Implementación Procedimiento 4
FUNCTION fConsultarCliente(cedulaCli VARCHAR2) return VARCHAR2 IS
vLista varchar2(100);
CURSOR cClienteSolicitado IS
    SELECT *
    FROM Cliente 
    WHERE Cliente.cedula=cedulaCli;
    
cedula VARCHAR2(20);
nombre VARCHAR2(30);
fechaNacimiento DATE;
direccion VARCHAR2(30);
telefono VARCHAR2(12);

BEGIN
  
    OPEN cClienteSolicitado;
    FETCH cClienteSolicitado INTO cedula, nombre, fechaNacimiento, direccion, telefono;
    CLOSE cClienteSolicitado;
    
    RETURN cedula || ' ' || nombre || ' ' || TO_CHAR(fechaNacimiento) || ' ' || direccion || ' ' || telefono;
    
END fConsultarCliente;

END pkCliente;
