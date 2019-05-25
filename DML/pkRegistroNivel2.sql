CREATE OR REPLACE PACKAGE pkRegistroNivel2 as
PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);
PROCEDURE pRegistrarSolicitud(ivFechaCreacion DATE,ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2);

END pkRegistroNivel2;
/
CREATE OR REPLACE PACKAGE BODY pkRegistroNivel2 as
-- Registrar Cliente
PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2)
IS
BEGIN  
    pkCliente.pInsertar(ivCedula,ivNombre,ivFechaNacimiento,ivDireccion,ivTelefono);
END pRegistrarCliente;

-- Registrar Solicitud

PROCEDURE pRegistrarSolicitudCreacion(ivFechaCreacion DATE,ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2)
IS
vCliente VARCHAR2(100);
BEGIN
    vCliente := pkcliente.fconsultar(ivCliente_cedulaCliente);
    if vCliente is not null
    then
    pksolicitud.pinsertar(SYSDATE ,null, ivObservaciones, ivEstado , ivCliente_cedulaCliente, null, ivTipoSolicitud, prodCli_codigoProducto, ivIdSolicitud);
    else
    return 'El registro con cédula ' || ivCliente_cedulaCliente || 'no existe en la tabla CLIENTE';
    END IF;
END pRegistrarSolicitudCreacion;

END pkRegistroNivel2;
