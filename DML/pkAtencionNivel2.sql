CREATE OR REPLACE PACKAGE pkAtencion AS -- spec
FUNCTION pAtenderNuevo(ivCodigoSolicitud VARCHAR2, ivCedulaFuncionario VARCHAR2, ivCodigoNuevoProducto NUMBER) return VARCHAR2;
PROCEDURE pAtenderRetiro (ivCodigoSolicitud VARCHAR2, ivCedulaFuncionario VARCHAR2, ivCodigoNuevoProducto NUMBER);
PROCEDURE pAtenderDanoReclamo(ivCodigoSolicitud VARCHAR2, ivCedulaFuncionario VARCHAR2, ivTipo VARCHAR2, ivRespuestaFuncionario VARCHAR2, ivObservaciones VARCHAR2);

END pkAtencion;
/

CREATE OR REPLACE PACKAGE BODY pkAtencion AS -- body

-- Implementación Procedimiento 1
FUNCTION pAtenderNuevo
(ivCodigoSolicitud VARCHAR2, ivCedulaFuncionario VARCHAR2, ivCodigoNuevoProducto NUMBER) return VARCHAR2
IS
Vproducto VARCHAR2(20);
VcedulaCliente VARCHAR2(20);
VfechaInicio DATE;
Vmes NUMBER(2);
Vano NUMBER(4);
VfechaInicioOk VARCHAR(20);
Vestado VARCHAR(15);
BEGIN
/*codigo sql*/

    select solicitud.estado into Vestado
    from solicitud
    where solicitud.idsolicitud = ivCodigoSolicitud and solicitud.funcionario_cedulafuncionario = ivCedulaFuncionario;
    
    select conssoli.constantes_nombreconstante into Vproducto
    from conssoli
    where conssoli.solicitud_cedulafuncionario = ivCedulaFuncionario and conssoli.solicitud_idsolicitud = ivCodigoSolicitud;
    
    select solicitud.cliente_cedulacliente into VcedulaCliente
    from solicitud
    where solicitud.idsolicitud = ivCodigoSolicitud;

    VfechaInicio := add_months(SYSDATE, 1);
    
    Vmes := extract(month from VfechaInicio);
    Vano := extract(year from VfechaInicio);
 
    VfechaInicioOk := '1/' || Vmes || '/' || Vano;

    insert into prodcli (codigoproducto, cliente_cedulacliente, constantes_nombreconstante, fecha_inicio, fecha_retiro)
    values (ivCodigoNuevoProducto, VcedulaCliente, Vproducto, VfechaInicioOk , null);
    
    update solicitud
    set solicitud.estado = 'atendida'
    where solicitud.idsolicitud = ivCodigoSolicitud;
    
    RETURN 'Nuevo registro creado';
    
    /*Maneja las excepciones*/
    EXCEPTION
    WHEN no_data_found THEN
    
    RETURN 'error, solicitud no encontrada';
    
END pAtenderNuevo;

PROCEDURE pAtenderRetiro
(ivCodigoSolicitud VARCHAR2, ivCedulaFuncionario VARCHAR2, ivCodigoNuevoProducto NUMBER)
IS
VcedulaCliente VARCHAR2(20);
Vproducto NUMBER(8);
BEGIN

    select solicitud.cliente_cedulacliente into VcedulaCliente
    from solicitud
    where solicitud.idsolicitud = ivCodigoSolicitud;
    
    select solicitud.prodcli_codigoproducto into Vproducto
    from solicitud
    where solicitud.idsolicitud = ivCodigoSolicitud;
    
    update prodcli
    set fecha_retiro = SYSDATE
    where prodcli.codigoproducto =  Vproducto and prodcli.cliente_cedulacliente = VcedulaCliente;

    update solicitud
    set solicitud.estado = 'atendida'
    where solicitud.idsolicitud = ivCodigoSolicitud;
    
END pAtenderRetiro;

PROCEDURE pAtenderDanoReclamo
(ivCodigoSolicitud VARCHAR2, ivCedulaFuncionario VARCHAR2, ivTipo VARCHAR2, ivRespuestaFuncionario VARCHAR2, ivObservaciones VARCHAR2)

IS
BEGIN

    IF ivTipo = 'dano' THEN
        update solicitud
        set solicitud.estado = ivRespuestaFuncionario, solicitud.observaciones = ivObservaciones
        where solicitud.idsolicitud = ivCodigoSolicitud;
    ELSE
        update solicitud
        set solicitud.estado = ivRespuestaFuncionario, solicitud.observaciones = ivObservaciones
        where solicitud.idsolicitud = ivCodigoSolicitud;
    END IF;

END pAtenderDanoReclamo;

END pkAtencion;