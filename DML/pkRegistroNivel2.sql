CREATE OR REPLACE PACKAGE pkRegistroNivel2 as
PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);
PROCEDURE pRegistrarSolicitud(ivFechaCreacion DATE,ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2);
PROCEDURE pRegistrarProductoCliente(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2);
PROCEDURE pRegistrarConstante(ivNombreConstante VARCHAR2, ivValor VARCHAR2);
PROCEDURE pRegistrarConstantesSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2);
PROCEDURE pRegistrarFuncionario(ivCedulaFuncionario VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);

PROCEDURE pBorrarCliente (ivCedula VARCHAR2);
PROCEDURE pBorrarSolicitud(ivIdSolicitud VARCHAR2);
PROCEDURE pBorrarProductoCliente(ivCodigoProducto NUMBER);
PROCEDURE pBorrarConstante(ivNombreConstante VARCHAR2);
PROCEDURE pBorrarConstanteSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2);
PROCEDURE pBorrarFuncionario(ivCedulaFuncionario VARCHAR2);

END pkRegistroNivel2;
/
CREATE OR REPLACE PACKAGE BODY pkRegistroNivel2 as
--Borrar Cliente
PROCEDURE pBorrarCliente (ivCedula VARCHAR2)Is
BEGIN
   pkcliente.pborrar(ivCed
   ula);
END pBorrarCliente;
--Borrar Solicitud
PROCEDURE pBorrarSolicitud(ivIdSolicitud VARCHAR2)Is
BEGIN
   pksolicitud.pborrar(ivIdSolicitud);
END pBorrarSolicitud;
--Borrar Producto Cliente
PROCEDURE pBorrarProductoCliente(ivCodigoProducto NUMBER)Is
BEGIN
   pkProductoCliente.pborrar(ivCodigoProducto);
END pBorrarProductoCliente;
--Borrar Constante
PROCEDURE pBorrarConstante(ivCodigoConstante VARCHAR2)Is
BEGIN
   pkconstante.pborrar(ivCodigoConstante);
END pBorrarConstante;
--Borrar Constante Solicitud
PROCEDURE pBorrarConstanteSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2)Is
BEGIN
   pkConstantesSolicitud.pborrar(ivSolicitud_idsolicitud,ivConstantes_nombreconstante);
END;
--Borrar Funcionario
PROCEDURE pBorrarFuncionario(ivCedulaFuncionario VARCHAR2)Is
BEGIN
   pkfuncionario.pborrar(ivCedulaFuncionario);
END;
--Registrar Constante Solicitud
PROCEDURE pRegistrarConstantesSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_nombreconstante VARCHAR2)Is
BEGIN
    pkconstantessolicitud.pinsertar(ivSolicitud_idsolicitud , ivConstantes_nombreconstante);
END pRegistrarConstantesSolicitud;
--Registrar Funcionario
PROCEDURE pRegistrarFuncionario(ivCedulaFuncionario VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2)Is
BEGIN
    pkfuncionario.pinsertar(ivCedulaFuncionario , ivNombre , ivFechaNacimiento , ivDireccion , ivTelefono);
END pRegistrarFuncionario;

--Registrar Constante
PROCEDURE pRegistrarConstante(ivNombreConstante VARCHAR2, ivValor VARCHAR2)
Is
BEGIN
    pkconstantes.pinsertar(ivNombreConstante , ivValor);
END pRegistrarConstante;

--Registrar Producto Cliente
PROCEDURE pRegistrarProductoCliente(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2)
IS
BEGIN
    pkproductocliente.pinsertar(ivCodigoProducto , ivCliente_cedulacliente , ivConstantes_codigoconstante );
END pRegistrarProductoCliente;



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
    pksolicitud.pinsertar(SYSDATE ,null, ivObservaciones, ivEstado , ivCliente_cedulaCliente, null, ivTipoSolicitud, ivProdCli_codigoProducto, ivIdSolicitud);
    --else
  -- return 'El registro con cédula ' || ivCliente_cedulaCliente || 'no existe en la tabla CLIENTE';
    END IF;
END pRegistrarSolicitudCreacion;

END pkRegistroNivel2;
