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
PROCEDURE pEliminarSolicitud(idSoli VARCHAR2) IS
BEGIN
    DELETE FROM SOLICITUD WHERE Solicitud.idSolicitud = isSoli;
END pEliminarSolicitud;

-- Implementación Procedimiento 3
PROCEDURE pModificarSolicitud(fechaCreacionN DATE, fechaAsignacionN DATE, observacionesN VARCHAR2, estadoN VARCHAR2, cliente_cedulaClienteN VARCHAR2, funcionario_cedulaFuncionarioN VARCHAR2, tipoSolicitudN VARCHAR2, prodCli_codigoProductoN NUMBER, prodCli_cedulaClienteN VARCHAR2, idSoli VARCHAR2) IS
BEGIN
    UPDATE Solicitud SET Solicitud.fechaCreacion= fechaCreacionN , Solicitud.fechaAsignacion = fechaAsignacionN , Solicitud.observaciones = observacionesN, Solicitud.estado = estadoN , Solicitud.cliente_cedulaCliente = cliente_cedulaClienteN , Solicitud.funcionario_cedulaFuncionario = funcionario_cedulaFuncionarioN , Solicitud.tipoSolicitud = tipoSolicitudN , Solicitud.prodCli_codigoProducto = prodCli_codigoProductoN , Solicitud.prodCli_cedulaCliente = prodCli_cedulaClienteN 
    WHERE Solicitud.idSolicitud=idSoli;
END pModificarSolicitud;

-- Implementación Procedimiento 4
FUNCTION fConsultarSolicitud(idSoli VARCHAR2) return VARCHAR2 IS
vLista varchar2(100);
CURSOR cSolicitudBuscada IS
    SELECT *
    FROM SOLICITUD 
    WHERE Solicitud.idSolocitud=idSoli;
    
fechaCreacion DATE;
fechaAsignacion DATE;
observaciones VARCHAR2(140);
estado VARCHAR2(15);
cliente_cedulaCliente VARCHAR2(20);
funcionario_cedulaFuncionario VARCHAR2(20);
tipoSolicitud VARCHAR2(20);
prodCli_codigoProducto NUMBER(8);
prodCli_cedulaCliente VARCHAR2(20);
idSolicitud VARCHAR2(8);

BEGIN
  
    OPEN cSolicitudBuscada;
    FETCH cSolicitudBuscada INTO fechaCreacion , fechaAsignacion , observaciones , estado , cliente_cedulaCliente , funcionario_cedulaFuncionario , tipoSolicitud , prodCli_codigoProducto , prodCli_cedulaCliente , idSolicitud;
    CLOSE cSolicitudBuscada;
    
    RETURN idSolicitud || ' ' || TO_CHAR(fechaCreacion) || ' ' || TO_CHAR(fechaAsignacion) || ' ' || estado || ' ' || cliente_cedulaCliente || ' ' || funcionario_cedulaFuncionario || ' ' || tipoSolicitud || ' ' || TO_CHAR(prodCli_codigoProducto) || ' ' || prodCli_cedulaCliente || ' ' || observaciones;
    
END fConsultarSolicitud;

END pkSolicitud;
