CREATE OR REPLACE PACKAGE pkConstantesSolicitud as
PROCEDURE pInsertar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2);
PROCEDURE pBorrar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2);
PROCEDURE pModificar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2);
FUNCTION fConsultar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2) RETURN VARCHAR2;
END pkConstantesSolicitud;
/

CREATE OR REPLACE PACKAGE BODY pkConstantesSolicitud AS

PROCEDURE pInsertar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2)
IS 
BEGIN
    INSERT INTO CONSSOLI VALUES (ivSolicitud_idsolicitud, ivConstantes_nombreconstante);
END pInsertar;

PROCEDURE pBorrar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2)
IS
BEGIN
    DELETE FROM CONSSOLI WHERE CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud AND CONSSOLI.constantes_nombreconstante = ivConstantes_nombreconstante;
END pBorrar;

PROCEDURE pModificar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2)
IS
BEGIN 
    UPDATE CONSSOLI SET CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud WHERE CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud; 
    UPDATE CONSSOLI SET CONSSOLI.constantes_nombreconstante = ivConstantes_nombreconstante WHERE CONSSOLI.constantes_nombreconstante = ivConstantes_nombreconstante; 
END pModificar;

FUNCTION fConsultar(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2) RETURN VARCHAR2
IS
CURSOR cuConstSolicitudBuscada IS 
    SELECT *
    FROM CONSSOLI 
    WHERE CONSSOLI.solicitud_idsolicitud = ivSolicitud_idsolicitud AND CONSSOLI.constantes_nombreconstante = ivConstantes_nombreconstante;
ovSolicitud_idsolicitud        VARCHAR2(8);
ovConstantes_nombreconstante   VARCHAR2(20);
BEGIN
    OPEN cuConstSolicitudBuscada;
    FETCH cuConstSolicitudBuscada INTO ovSolicitud_idsolicitud, ovConstantes_nombreconstante;
    CLOSE cuConstSolicitudBuscada;
    
    RETURN ovSolicitud_idsolicitud || ' ' || ovConstantes_nombreconstante;
END fConsultar;

END pkConstantesSolicitud;
