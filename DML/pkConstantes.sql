CREATE OR REPLACE PACKAGE pkConstantes as
PROCEDURE pInsertar(ivCodigoConstante VARCHAR2, ivNombreConstante VARCHAR2, ivValor VARCHAR2);
PROCEDURE pBorrar(ivCodigoConstante VARCHAR2);
PROCEDURE pModificar(ivCodigoConstante VARCHAR2,ivNombreConstante VARCHAR2, ivValor VARCHAR2);
FUNCTION fConsultar(ivCodigoConstante VARCHAR2) RETURN VARCHAR2;
FUNCTION fListarConstantes RETURN VARCHAR2;
END pkConstantes;
/

CREATE OR REPLACE PACKAGE BODY pkConstantes AS

PROCEDURE pInsertar(ivCodigoConstante VARCHAR2, ivNombreConstante VARCHAR2, ivValor VARCHAR2)
IS 
BEGIN
    INSERT INTO CONSTANTES VALUES (ivCodigoConstante, ivNombreConstante, ivValor);
END pInsertar;

PROCEDURE pBorrar(ivCodigoConstante VARCHAR2)
IS
BEGIN
    DELETE FROM CONSTANTES WHERE CONSTANTES.codigoConstante = ivCodigoConstante;
END pBorrar;

PROCEDURE pModificar(ivCodigoConstante VARCHAR2,ivNombreConstante VARCHAR2, ivValor VARCHAR2)
IS
BEGIN 
    UPDATE CONSTANTES SET CONSTANTES.valor = ivValor WHERE CONSTANTES.codigoConstante = ivCodigoConstante;  
    UPDATE CONSTANTES SET CONSTANTES.nombreConstante = ivNombreConstante WHERE CONSTANTES.codigoConstante = ivCodigoConstante; 
END pModificar;

FUNCTION fConsultar(ivCodigoConstante VARCHAR2) RETURN VARCHAR2
IS
CURSOR cuConstanteBuscada IS 
    SELECT *
    FROM CONSTANTES 
    WHERE CONSTANTES.codigoConstante = ivCodigoConstante;
ovCodigoConstante VARCHAR(2);
ovNombreConstante VARCHAR2(20);
ovValor VARCHAR2(20);
BEGIN
    OPEN cuConstanteBuscada;
    FETCH cuConstanteBuscada INTO ovCodigoConstante,ovNombreConstante, ovValor;
    CLOSE cuConstanteBuscada;
    
    RETURN ovCodigoConstante || ' ' || ovNombreConstante || ' ' || ovValor;
END fConsultar;

FUNCTION fListarConstantes RETURN VARCHAR2
IS  
CURSOR cuListaConstantes is 
    SELECT CONSTANTES.codigoConstante, CONSTANTES.nombreConstante
    FROM CONSTANTES;
vResultado VARCHAR2(500);
BEGIN
    FOR rc in cuListaConstantes
        LOOP
            Vresultado := Vresultado || rc.codigoConstante || ',' || rc.nombreConstante || '/';
        END LOOP;
    RETURN Vresultado;
END fListarConstantes;

END pkConstantes;
