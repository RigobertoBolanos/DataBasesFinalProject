CREATE OR REPLACE PACKAGE pkSolicitud AS -- spec
PROCEDURE pInsertar(ivFechaCreacion DATE, ivFechaAsignacion DATE, ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivFuncionario_cedulaFuncionario VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivProdCli_cedulaCliente VARCHAR2, ivIdSolicitud VARCHAR2);
PROCEDURE pBorrar(ivIdSolicitud VARCHAR2);
PROCEDURE pModificar(ivFechaCreacion DATE, ivFechaAsignacion DATE, ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivFuncionario_cedulaFuncionario VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivProdCli_cedulaCliente VARCHAR2, ivIdSolicitud VARCHAR2);
FUNCTION fConsultar(ivIdSolicitud VARCHAR2) RETURN VARCHAR2;
END pkSolicitud;
/

CREATE OR REPLACE PACKAGE BODY pkSolicitud AS -- body

-- Implementación Procedimiento 1
PROCEDURE pInsertar
(ivFechaCreacion DATE, ivFechaAsignacion DATE, ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivFuncionario_cedulaFuncionario VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivProdCli_cedulaCliente VARCHAR2, ivIdSolicitud VARCHAR2)
IS
BEGIN
    INSERT INTO SOLICITUD
    VALUES (ivFechaCreacion , ivFechaAsignacion , ivObservaciones , ivEstado , ivCliente_cedulaCliente , ivFuncionario_cedulaFuncionario , ivTipoSolicitud , ivProdCli_codigoProducto , ivProdCli_cedulaCliente , ivIdSolicitud );
END pInsertar;

-- Implementación Procedimiento 2
PROCEDURE pBorrar(ivIdSolicitud VARCHAR2) IS
BEGIN
    DELETE FROM SOLICITUD WHERE Solicitud.idSolicitud = ivIdSolicitud;
END pBorrar;

-- Implementación Procedimiento 3
PROCEDURE pModificar(ivFechaCreacion DATE, ivFechaAsignacion DATE, ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivFuncionario_cedulaFuncionario VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivProdCli_cedulaCliente VARCHAR2, ivIdSolicitud VARCHAR2) IS
BEGIN
    UPDATE Solicitud SET Solicitud.fechaCreacion= ivFechaCreacion , Solicitud.fechaAsignacion = ivFechaAsignacion , Solicitud.observaciones = ivObservaciones, Solicitud.estado = ivEstado , Solicitud.cliente_cedulaCliente = ivCliente_cedulaCliente , Solicitud.funcionario_cedulaFuncionario = ivFuncionario_cedulaFuncionario , Solicitud.tipoSolicitud = ivTipoSolicitud , Solicitud.prodCli_codigoProducto = ivProdCli_codigoProducto , Solicitud.prodCli_cedulaCliente = ivProdCli_cedulaCliente 
    WHERE Solicitud.idSolicitud= ivIdSolicitud;
END pModificar;

-- Implementación Procedimiento 4
FUNCTION fConsultar(ivIdSolicitud VARCHAR2) return VARCHAR2 IS
CURSOR cuSolicitudBuscada IS
    SELECT *
    FROM SOLICITUD 
    WHERE Solicitud.idSolicitud= ivIdSolicitud;
    
ovFechaCreacion DATE;
ovFechaAsignacion DATE;
ovObservaciones VARCHAR2(140);
ovEstado VARCHAR2(15);
ovCliente_cedulaCliente VARCHAR2(20);
ovFuncionario_cedulaFuncionario VARCHAR2(20);
ovTipoSolicitud VARCHAR2(20);
ovProdCli_codigoProducto NUMBER(8);
ovProdCli_cedulaCliente VARCHAR2(20);
ovIdSolicitudC VARCHAR2(8);

BEGIN
  
    OPEN cuSolicitudBuscada;
    FETCH cuSolicitudBuscada INTO ovFechaCreacion , ovFechaAsignacion , ovObservaciones , ovEstado , ovCliente_cedulaCliente , ovFuncionario_cedulaFuncionario , ovTipoSolicitud , ovProdCli_codigoProducto , ovProdCli_cedulaCliente , ovIdSolicitudC;
    CLOSE cuSolicitudBuscada;
    
    RETURN ovIdSolicitudC || ' ' || TO_CHAR(ovFechaCreacion) || ' ' || TO_CHAR(ovFechaAsignacion) || ' ' || ovEstado || ' ' || ovCliente_cedulaCliente || ' ' || ovFuncionario_cedulaFuncionario || ' ' || ovTipoSolicitud || ' ' || TO_CHAR(ovProdCli_codigoProducto) || ' ' || ovProdCli_cedulaCliente || ' ' || ovObservaciones;
    
END fConsultar;

END pkSolicitud;
