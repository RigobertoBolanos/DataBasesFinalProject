CREATE OR REPLACE PACKAGE pkAsignacionNivel2 as
PROCEDURE pAsignarIndividual(idSolicitud VARCHAR2,cedulaFuncionario VARCHAR2);
PROCEDURE pInsertar(cedulaFuncionario VARCHAR2, nombre VARCHAR2, fechaNacimiento DATE, direccion VARCHAR2, telefono VARCHAR2);
END pkAsignacionNivel2;
/

CREATE OR REPLACE TRIGGER trigger_name
AFTER INSERT
   ON SOLICITUD

DECLARE
   vIdSolicitud VARCHAR2(10);

BEGIN
   SELECT idSolicitud INTO vIdSolicitud
   FROM dual;
   
  pkAsignacionNivel2.pAsignarAutomaticamente(vIdSolicitud);

END;

CREATE OR REPLACE PACKAGE BODY pkAsignacionNivel2 AS

PROCEDURE pAsignarAutomaticamente(ivIdSolicitud VARCHAR)
IS
BEGIN
    FOR i IN (SELECT FUNCIONARIO.cedulaFuncionario FROM FUNCIONARIO) LOOP
        SELECT COUNT(FUNCIONARIO.cedulaFuncionario)INTO ovNumber FROM FUNCIONARIO INNER JOIN SOLICITUD ON FUNCIONARIO.cedulaFuncionario=SOLICITUD.cliente_cedulaCliente
        WHERE FUNCIONARIO.cedulaFuncionario=i.cedulaFuncionario;
        IF ovNumber <=3 THEN
            UPDATE SOLICITUD SET SOLICITUD.funcionario_cedulaFuncionario = i.cedulaFuncionario WHERE SOLICITUD.idSolicitud=ivIdSolicitud;
            UPDATE SOLICITUD SET SOLICITUD.FechaAsignacion = SYSDATE WHERE SOLICITUD.idSolicitud=ivIdSolicitud;
            UPDATE SOLICITUD SET SOLICITUD.estado = 'asignada' WHERE SOLICITUD.idSolicitud=ivIdSolicitud;
            EXIT;
        END IF;
    END LOOP;
END pAsignarAutomaticamente;

PROCEDURE pAsignarIndividual(ivIdSolicitud VARCHAR2,ivCedulaFuncionario VARCHAR2)
IS
BEGIN
    UPDATE SOLICITUD SET SOLICITUD.funcionario_cedulaFuncionario = ivCedulaFuncionario WHERE SOLICITUD.idSolicitud=ivIdSolicitud;
    UPDATE SOLICITUD SET SOLICITUD.FechaAsignacion = SYSDATE WHERE SOLICITUD.idSolicitud=ivIdSolicitud;
    UPDATE SOLICITUD SET SOLICITUD.estado = 'asignada' WHERE SOLICITUD.idSolicitud=ivIdSolicitud;
END pAsignarIndividual;

PROCEDURE pAsignarMasivamente
IS
BEGIN
    FOR i IN (SELECT SOLICITUD.idSolicitud,SOLICITUD.fechaCreacion FROM SOLICITUD) LOOP
        SELECT SOLICITUD.fechaCreacion INTO ovDate FROM SOLICITUD 
        WHERE SOLICITUD.idSolicitud=i.idSolicitud;
        IF SYSDATE-ovDate>=4 THEN
            pkAsignacionNivel2.pAsignarAutomaticamente(i.idSolicitud);
        END IF;
    END LOOP;
END pAsignarMasivamente;

BEGIN
    DBMS_SCHEDULER.CREATE_JOB
    (
        'job_1',
        'PLSQL_BLOCK',
        'BEGIN pkAsignacionNivel2.pAsignarMasivamente; END;',
        SYSDATE,
        'FREQ=DAILY;BYHOUR=22;INTERVAL=1'
    ); 
END;


END pkAsignacionNivel2;