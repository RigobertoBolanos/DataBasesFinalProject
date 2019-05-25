CREATE OR REPLACE PACKAGE pkFuncionario as
PROCEDURE pInsertar(ivCedulaFuncionario VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);
PROCEDURE pBorrar(ivCedulaFuncionario VARCHAR2);
PROCEDURE pModificar(ivCedulaFuncionarioDada VARCHAR2, ivNuevoNombre VARCHAR2, ivNuevaFechaNacimiento DATE, ivNuevaDireccion VARCHAR2, ivNuevoTelefono VARCHAR2);
FUNCTION fConsultar(ivCedulaFuncionario VARCHAR2) RETURN VARCHAR2;
END pkFuncionario;
/

CREATE OR REPLACE PACKAGE BODY pkFuncionario AS

PROCEDURE pInsertar(ivCedulaFuncionario VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2)
IS 
BEGIN
    INSERT INTO FUNCIONARIO VALUES (ivCedulaFuncionario, ivNombre, ivFechaNacimiento, ivDireccion, ivTelefono);
END pInsertar;

PROCEDURE pBorrar(ivCedulaFuncionario VARCHAR2)
IS
BEGIN
    DELETE FROM FUNCIONARIO WHERE FUNCIONARIO.cedulaFuncionario = ivCedulaFuncionario;
END pBorrar;

PROCEDURE pModificar(ivCedulaFuncionarioDada VARCHAR2, ivNuevoNombre VARCHAR2, ivNuevaFechaNacimiento DATE, ivNuevaDireccion VARCHAR2, ivNuevoTelefono VARCHAR2)
IS
BEGIN 
    UPDATE FUNCIONARIO SET FUNCIONARIO.nombre = ivNuevoNombre WHERE FUNCIONARIO.cedulaFuncionario = ivCedulaFuncionarioDada; 
    UPDATE FUNCIONARIO SET FUNCIONARIO.fechaNacimiento = ivNuevaFechaNacimiento WHERE FUNCIONARIO.cedulaFuncionario = ivCedulaFuncionarioDada; 
    UPDATE FUNCIONARIO SET FUNCIONARIO.direccion = ivNuevaDireccion WHERE FUNCIONARIO.cedulaFuncionario = ivCedulaFuncionarioDada; 
    UPDATE FUNCIONARIO SET FUNCIONARIO.telefono = ivNuevoTelefono WHERE FUNCIONARIO.cedulaFuncionario = ivCedulaFuncionarioDada;
END pModificar;

FUNCTION fConsultar( ivCedulaFuncionario VARCHAR2) RETURN VARCHAR2
IS
CURSOR cuFuncionarioBuscado IS 
    SELECT *
    FROM FUNCIONARIO 
    WHERE FUNCIONARIO.cedulaFuncionario = ivCedulaFuncionario;
vCedula VARCHAR2(20);
vNombre VARCHAR2(30);
vFechaNacimiento DATE;
vDireccion VARCHAR2(30);
vTelefono VARCHAR2(12);
BEGIN
    OPEN cuFuncionarioBuscado;
    FETCH cuFuncionarioBuscado INTO vCedula, vNombre, vFechaNacimiento, vDireccion, vTelefono;
    CLOSE cuFuncionarioBuscado;
    
    RETURN vCedula || ' ' || vNombre || ' ' || TO_CHAR(vFechaNacimiento) || ' ' || vDireccion || ' ' || vTelefono;
END fConsultar;

END pkFuncionario;
