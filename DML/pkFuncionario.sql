CREATE OR REPLACE PACKAGE pkFuncionario as
PROCEDURE pInsertar(cedulaFuncionario VARCHAR2, nombre VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2);
PROCEDURE pBorrar(cedulaFuncionario VARCHAR2);
PROCEDURE pModificar(cedulaFuncionarioDada VARCHAR2, nuevoNombre VARCHAR2, nuevaFechaNacimiento DATE, nuevaDireccion VARCHAR2, nuevoTelefono VARCHAR2);
FUNCTION fConsultar(cedulaFuncionario VARCHAR2) RETURN VARCHAR2;
END pkFuncionario;
/

CREATE OR REPLACE PACKAGE BODY pkFuncionario AS

PROCEDURE pInsertar(cedulaFuncionario VARCHAR2, nombre VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2)
IS 
BEGIN
    INSERT INTO FUNCIONARIO VALUES (cedulaFuncionario, nombre, fechaNacimiento, direccion, telefono);
END pInsertar;

PROCEDURE pBorrar(cedulaFuncionario VARCHAR2)
IS
BEGIN
    DELETE FROM FUNCIONARIO WHERE FUNCIONARIO.cedulaFuncionario = cedulaFuncionario;
END pBorrar;

PROCEDURE pModificar(cedulaFuncionarioDada VARCHAR2, nuevoNombre VARCHAR2, nuevaFechaNacimiento DATE, nuevaDireccion VARCHAR2, nuevoTelefono VARCHAR2)
IS
BEGIN 
    UPDATE FUNCIONARIO SET FUNCIONARIO.nombre = nuevoNombre WHERE FUNCIONARIO.cedulaFuncionario = cedulaFuncionarioDada; 
    UPDATE FUNCIONARIO SET FUNCIONARIO.fechaNacimiento = nuevaFechaNacimiento WHERE FUNCIONARIO.cedulaFuncionario = cedulaFuncionarioDada; 
    UPDATE FUNCIONARIO SET FUNCIONARIO.direccion = nuevaDireccion WHERE FUNCIONARIO.cedulaFuncionario = cedulaFuncionarioDada; 
    UPDATE FUNCIONARIO SET FUNCIONARIO.telefono = nuevoTelefono WHERE FUNCIONARIO.cedulaFuncionario = cedulaFuncionarioDada;
END pModificar;

FUNCTION fConsultar(cedulaFuncionario VARCHAR2) RETURN VARCHAR2
IS
CURSOR funcionarioBuscado IS 
    SELECT *
    FROM FUNCIONARIO 
    WHERE FUNCIONARIO.cedulaFuncionario = cedulaFuncionario;
cedula VARCHAR2(20);
nombre VARCHAR2(30);
fechaNacimiento DATE;
direccion VARCHAR2(30);
telefono VARCHAR2(12);
BEGIN
    OPEN funcionarioBuscado;
    FETCH funcionarioBuscado INTO cedula, nombre, fechaNacimiento, direccion, telefono;
    CLOSE funcionarioBuscado;
    
    RETURN cedula || ' ' || nombre || ' ' || TO_CHAR(fechaNacimiento) || ' ' || direccion || ' ' || telefono;
END fConsultar;

END pkFuncionario;
