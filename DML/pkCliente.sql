CREATE OR REPLACE PACKAGE pkCliente AS -- spec
PROCEDURE pInsertar(cedula VARCHAR2, nombre VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2);
PROCEDURE pBorrar (cedula VARCHAR2);
PROCEDURE pModificar(nombre VARCHAR2, cedula VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2);
FUNCTION fConsultar(cedula VARCHAR2) RETURN VARCHAR2;
END pkCliente;
/

CREATE OR REPLACE PACKAGE BODY pkCliente AS -- body

-- Implementación Procedimiento 1
PROCEDURE pInsertar
(cedula VARCHAR2, nombre VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2)
IS
BEGIN
    INSERT INTO Cliente
    VALUES (cedula, nombre, fechaNacimiento, direccion,
    telefono);
END pInsertar;

-- Implementación Procedimiento 2
PROCEDURE pBorrar(cedula VARCHAR2) IS
BEGIN
    DELETE FROM Cliente WHERE Cliente.cedulaCliente = cedula;
END pBorrar;

-- Implementación Procedimiento 3
PROCEDURE pModificar(nombre VARCHAR2, cedula VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2) IS
BEGIN
    UPDATE Cliente SET Cliente.nombre=nombre,Cliente.fechaNacimiento=fechaNacimiento,Cliente.direccion=direccion, Cliente.telefono=telefono
    WHERE Cliente.cedulaCliente=cedula;
END pModificar;

-- Implementación Procedimiento 4
FUNCTION fConsultar(cedula VARCHAR2) RETURN VARCHAR2
IS
CURSOR cClienteSolicitado IS
    SELECT *
    FROM Cliente 
    WHERE Cliente.cedulaCliente=cedula;
    
cedulaCliente VARCHAR2(20);
nombre VARCHAR2(30);
fechaNacimiento DATE;
direccion VARCHAR2(30);
telefono VARCHAR2(12);

BEGIN
  
    OPEN cClienteSolicitado;
    FETCH cClienteSolicitado INTO cedulaCliente, nombre, fechaNacimiento, direccion, telefono;
    CLOSE cClienteSolicitado;
    
    RETURN cedulaCliente || ' ' || nombre || ' ' || TO_CHAR(fechaNacimiento) || ' ' || direccion || ' ' || telefono;
    
END fConsultar;

END pkCliente;
