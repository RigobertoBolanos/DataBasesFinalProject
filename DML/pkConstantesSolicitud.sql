CREATE OR REPLACE PACKAGE pkConstantesSolicitud as
PROCEDURE pInsertar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2);
PROCEDURE pBorrar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2);
PROCEDURE pModificar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2);
FUNCTION fConsultar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2) RETURN VARCHAR2;
END pkConstantesSolicitud;
/

CREATE OR REPLACE PACKAGE BODY pkConstantesSolicitud AS

PROCEDURE pInsertar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2)
IS 
BEGIN
    INSERT INTO CONSSOLI VALUES (ivSolicitud_idsolicitud, ivConstantes_codigoConstante);
END pInsertar;

PROCEDURE pBorrar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2)
IS
BEGIN
    DELETE FROM CONSSOLI WHERE CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud AND CONSSOLI.constantes_codigoconstante = ivConstantes_codigoConstante;
END pBorrar;

PROCEDURE pModificar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2)
IS
BEGIN 
    UPDATE CONSSOLI SET CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud WHERE CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud; 
    UPDATE CONSSOLI SET CONSSOLI.constantes_codigoconstante = ivConstantes_codigoConstante WHERE CONSSOLI.constantes_codigoconstante = ivConstantes_codigoConstante; 
END pModificar;

FUNCTION fConsultar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2) RETURN VARCHAR2
IS
CURSOR cuConstSolicitudBuscada IS 
    SELECT *
    FROM CONSSOLI 
    WHERE CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud AND CONSSOLI.constantes_codigoconstante = ivConstantes_codigoConstante;
ovSolicitud_idsolicitud        VARCHAR2(8);
ovConstantes_codigoConstante   VARCHAR2(20);
BEGIN
    OPEN cuConstSolicitudBuscada;
    FETCH cuConstSolicitudBuscada INTO ovSolicitud_idsolicitud, ovConstantes_codigoConstante;
    CLOSE cuConstSolicitudBuscada;
    
    RETURN ovSolicitud_idsolicitud || ' ' || ovConstantes_codigoConstante;
END fConsultar;

END pkConstantesSolicitud;
