CREATE OR REPLACE PACKAGE pkConstantes as
PROCEDURE pInsertar(ivNombreConstante VARCHAR2, ivValor VARCHAR2);
PROCEDURE pBorrar(ivNombreConstante VARCHAR2);
PROCEDURE pModificar(ivNombreConstante VARCHAR2, ivValor VARCHAR2);
FUNCTION fConsultar(ivNombreConstante VARCHAR2) RETURN VARCHAR2;
END pkConstantes;
/

CREATE OR REPLACE PACKAGE BODY pkConstantes AS

PROCEDURE pInsertar(ivNombreConstante VARCHAR2, ivValor VARCHAR2)
IS 
BEGIN
    INSERT INTO CONSTANTES VALUES (ivNombreConstante, ivValor);
END pInsertar;

PROCEDURE pBorrar(ivNombreConstante VARCHAR2)
IS
BEGIN
    DELETE FROM CONSTANTES WHERE CONSTANTES.nombreConstante = ivNombreConstante;
END pBorrar;

PROCEDURE pModificar(ivNombreConstante VARCHAR2, ivValor VARCHAR2)
IS
BEGIN 
    UPDATE CONSTANTES SET CONSTANTES.valor = ivValor WHERE CONSTANTES.nombreConstante = ivNombreConstante;  
END pModificar;

FUNCTION fConsultar(ivNombreConstante VARCHAR2) RETURN VARCHAR2
IS
CURSOR cuConstanteBuscada IS 
    SELECT *
    FROM CONSTANTES 
    WHERE CONSTANTES.nombreConstante = ivNombreConstante;
ovNombreConstante VARCHAR2(20);
ovValor VARCHAR2(20);
BEGIN
    OPEN cuConstanteBuscada;
    FETCH cuConstanteBuscada INTO ovNombreConstante, ovValor;
    CLOSE cuConstanteBuscada;
    
    RETURN ovNombreConstante || ' ' || ovValor;
END fConsultar;

END pkConstantes;
