CREATE OR REPLACE PACKAGE pkSolicitud AS -- spec
PROCEDURE pInsertarSolicitud(fechaCreacion DATE, fechaAsignacion DATE, observaciones VARCHAR2, estado VARCHAR2, cliente_cedulaCliente VARCHAR2, funcionario_cedulaFuncionario VARCHAR2, tipoSolicitud VARCHAR2, prodCli_codigoProducto NUMBER, prodCli_cedulaCliente VARCHAR2, idSolicitud VARCHAR2);
PROCEDURE pEliminarSolicitud (idSolicitud VARCHAR2);
PROCEDURE pModificarSolicitud(fechaCreacion DATE, fechaAsignacion DATE, observaciones VARCHAR2, estado VARCHAR2, cliente_cedulaCliente VARCHAR2, funcionario_cedulaFuncionario VARCHAR2, tipoSolicitud VARCHAR2, prodCli_codigoProducto NUMBER, prodCli_cedulaCliente VARCHAR2, idSolicitud VARCHAR2);
FUNCTION fConsultarSolicitud(idSolicitud VARCHAR2) RETURN VARCHAR2;
END pkSolicitud;
/

CREATE OR REPLACE PACKAGE BODY pkSolicitud AS -- body

-- Implementación Procedimiento 1
PROCEDURE pInsertarSolicitud
(fechaCreacion DATE, fechaAsignacion DATE, observaciones VARCHAR2, estado VARCHAR2, cliente_cedulaCliente VARCHAR2, funcionario_cedulaFuncionario VARCHAR2, tipoSolicitud VARCHAR2, prodCli_codigoProducto NUMBER, prodCli_cedulaCliente VARCHAR2, idSolicitud VARCHAR2)
IS
BEGIN
    INSERT INTO SOLICITUD
    VALUES (fechaCreacion , fechaAsignacion , observaciones , estado , cliente_cedulaCliente , funcionario_cedulaFuncionario , tipoSolicitud , prodCli_codigoProducto , prodCli_cedulaCliente , idSolicitud );
END pInsertarSolicitud;

-- Implementación Procedimiento 2
PROCEDURE pEliminarSolicitud(idSolicitud VARCHAR2) IS
BEGIN
    DELETE FROM SOLICITUD WHERE Solicitud.idSolicitud = idSolicitud;
END pEliminarSolicitud;

-- Implementación Procedimiento 3
PROCEDURE pModificarSolicitud(fechaCreacion DATE, fechaAsignacion DATE, observaciones VARCHAR2, estado VARCHAR2, cliente_cedulaCliente VARCHAR2, funcionario_cedulaFuncionario VARCHAR2, tipoSolicitud VARCHAR2, prodCli_codigoProducto NUMBER, prodCli_cedulaCliente VARCHAR2, idSolicitud VARCHAR2) IS
BEGIN
    UPDATE Solicitud SET Solicitud.fechaCreacion= fechaCreacion , Solicitud.fechaAsignacion = fechaAsignacion , Solicitud.observaciones = observaciones, Solicitud.estado = estado , Solicitud.cliente_cedulaCliente = cliente_cedulaCliente , Solicitud.funcionario_cedulaFuncionario = funcionario_cedulaFuncionario , Solicitud.tipoSolicitud = tipoSolicitud , Solicitud.prodCli_codigoProducto = prodCli_codigoProducto , Solicitud.prodCli_cedulaCliente = prodCli_cedulaCliente 
    WHERE Solicitud.idSolicitud=idSolicitud;
END pModificarSolicitud;

-- Implementación Procedimiento 4
FUNCTION fConsultarSolicitud(idSolicitud VARCHAR2) return VARCHAR2 IS
vLista varchar2(100);
CURSOR cSolicitudBuscada IS
    SELECT *
    FROM SOLICITUD 
    WHERE Solicitud.idSolicitud=idSolicitud;
    
fechaCreacion DATE;
fechaAsignacion DATE;
observaciones VARCHAR2(140);
estado VARCHAR2(15);
cliente_cedulaCliente VARCHAR2(20);
funcionario_cedulaFuncionario VARCHAR2(20);
tipoSolicitud VARCHAR2(20);
prodCli_codigoProducto NUMBER(8);
prodCli_cedulaCliente VARCHAR2(20);
idSolicitudC VARCHAR2(8);

BEGIN
  
    OPEN cSolicitudBuscada;
    FETCH cSolicitudBuscada INTO fechaCreacion , fechaAsignacion , observaciones , estado , cliente_cedulaCliente , funcionario_cedulaFuncionario , tipoSolicitud , prodCli_codigoProducto , prodCli_cedulaCliente , idSolicitudC;
    CLOSE cSolicitudBuscada;
    
    RETURN idSolicitudC || ' ' || TO_CHAR(fechaCreacion) || ' ' || TO_CHAR(fechaAsignacion) || ' ' || estado || ' ' || cliente_cedulaCliente || ' ' || funcionario_cedulaFuncionario || ' ' || tipoSolicitud || ' ' || TO_CHAR(prodCli_codigoProducto) || ' ' || prodCli_cedulaCliente || ' ' || observaciones;
    
END fConsultarSolicitud;

END pkSolicitud;
