CREATE OR REPLACE PACKAGE pkRegistroNivel2 as
PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);
PROCEDURE pRegistrarSolicitud(ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2);
PROCEDURE pRegistrarProductoCliente(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2);
PROCEDURE pRegistrarConstante(ivCodigoConstante VARCHAR2, ivNombreConstante VARCHAR2, ivValor VARCHAR2);
PROCEDURE pRegistrarConstantesSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2);
PROCEDURE pRegistrarFuncionario(ivCedulaFuncionario VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);

PROCEDURE pBorrarCliente (ivCedula VARCHAR2);
PROCEDURE pBorrarSolicitud(ivIdSolicitud VARCHAR2);
PROCEDURE pBorrarProductoCliente(ivCodigoProducto NUMBER);
PROCEDURE pBorrarConstante(ivCodigoConstante VARCHAR2);
PROCEDURE pBorrarConstanteSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2);
PROCEDURE pBorrarFuncionario(ivCedulaFuncionario VARCHAR2);

PROCEDURE pActualizarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);
PROCEDURE pActualizarSolicitud(ivFechaCreacion DATE, ivFechaAsignacion DATE, ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivFuncionario_cedulaFuncionario VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2);
PROCEDURE pActualizarProductoCliente(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2);
PROCEDURE pActualizarConstante(ivCodigoConstante VARCHAR2,ivNombreConstante VARCHAR2, ivValor VARCHAR2);
PROCEDURE pActualizarConstantesSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2);
PROCEDURE pActualizarFuncionario(ivCedulaFuncionarioDada VARCHAR2, ivNuevoNombre VARCHAR2, ivNuevaFechaNacimiento DATE, ivNuevaDireccion VARCHAR2, ivNuevoTelefono VARCHAR2);

FUNCTION fListarConstantes RETURN VARCHAR2;

FUNCTION fSolicitudXFuncionario RETURN VARCHAR2;
FUNCTION fSolicitudXEstado RETURN VARCHAR2;
FUNCTION fSolicitudXTipo RETURN VARCHAR2;
FUNCTION fProductosXCliente RETURN VARCHAR2;


END pkRegistroNivel2;
/
CREATE OR REPLACE PACKAGE BODY pkRegistroNivel2 as
--Actualizar Cliente
PROCEDURE pActualizarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2)
IS
BEGIN
    pkcliente.pmodificar(ivCedula , ivNombre , ivFechaNacimiento , ivDireccion , ivTelefono );
END pActualizarCliente;
--Actualiza Solicitud
PROCEDURE pActualizarSolicitud(ivFechaCreacion DATE, ivFechaAsignacion DATE, ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivFuncionario_cedulaFuncionario VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2)
IS
BEGIN
    pksolicitud.pmodificar(ivFechaCreacion , ivFechaAsignacion , ivObservaciones , ivEstado , ivCliente_cedulaCliente , ivFuncionario_cedulaFuncionario , ivTipoSolicitud , ivProdCli_codigoProducto , ivIdSolicitud );
END pActualizarSolicitud;
--Actualizar Producto Cliente
PROCEDURE pActualizarProductoCliente(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2)IS
BEGIN
    pkproductocliente.pmodificar(ivCodigoProducto , ivCliente_cedulacliente , ivConstantes_codigoconstante);
END pActualizarProductoCliente;
--Actualizar Constante
PROCEDURE pActualizarConstante(ivCodigoConstante VARCHAR2,ivNombreConstante VARCHAR2, ivValor VARCHAR2)IS
BEGIN
    pkconstantes.pmodificar(ivCodigoConstante ,ivNombreConstante , ivValor );
END pActualizarConstante;
--Actualizar Constantes Solicitud
PROCEDURE pActualizarConstantesSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2)IS
BEGIN
    pkconstantessolicitud.pmodificar(ivSolicitud_idsolicitud , ivConstantes_codigoConstante);
END pActualizarConstantesSolicitud;
--Actualizar Funcionario
PROCEDURE pActualizarFuncionario(ivCedulaFuncionarioDada VARCHAR2, ivNuevoNombre VARCHAR2, ivNuevaFechaNacimiento DATE, ivNuevaDireccion VARCHAR2, ivNuevoTelefono VARCHAR2)IS
BEGIN
    pkfuncionario.pmodificar(ivCedulaFuncionarioDada , ivNuevoNombre , ivNuevaFechaNacimiento , ivNuevaDireccion , ivNuevoTelefono);
END pActualizarFuncionario;

--Borrar Cliente
PROCEDURE pBorrarCliente (ivCedula VARCHAR2)Is
BEGIN
   pkcliente.pborrar(ivCedula);
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
   pkconstantes.pborrar(ivCodigoConstante);
END pBorrarConstante;
--Borrar Constante Solicitud
PROCEDURE pBorrarConstanteSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2)Is
BEGIN
   pkConstantesSolicitud.pborrar(ivSolicitud_idsolicitud,ivConstantes_codigoConstante);
END;
--Borrar Funcionario
PROCEDURE pBorrarFuncionario(ivCedulaFuncionario VARCHAR2)Is
BEGIN
   pkfuncionario.pborrar(ivCedulaFuncionario);
END;
--Registrar Constante Solicitud
PROCEDURE pRegistrarConstantesSolicitud(ivSolicitud_idsolicitud VARCHAR2, ivConstantes_codigoConstante VARCHAR2)Is
BEGIN
    pkconstantessolicitud.pInsertar(ivSolicitud_idsolicitud, ivConstantes_codigoConstante);
END pRegistrarConstantesSolicitud;
--Registrar Funcionario
PROCEDURE pRegistrarFuncionario(ivCedulaFuncionario VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2)Is
BEGIN
    pkfuncionario.pinsertar(ivCedulaFuncionario , ivNombre , ivFechaNacimiento , ivDireccion , ivTelefono);
END pRegistrarFuncionario;

--Registrar Constante
PROCEDURE pRegistrarConstante(ivCodigoConstante VARCHAR2, ivNombreConstante VARCHAR2, ivValor VARCHAR2)
Is
BEGIN
    pkconstantes.pinsertar(ivCodigoConstante, ivCodigoConstante , ivValor);
END pRegistrarConstante;

--Registrar Producto Cliente
PROCEDURE pRegistrarProductoCliente(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2)
IS
BEGIN
    pkproductocliente.pinsertar(ivCodigoProducto , ivCliente_cedulacliente , ivConstantes_codigoconstante);
END pRegistrarProductoCliente;



-- Registrar Cliente
PROCEDURE pRegistrarCliente(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2)
IS
BEGIN  
    pkCliente.pInsertar(ivCedula,ivNombre,ivFechaNacimiento,ivDireccion,ivTelefono);
END pRegistrarCliente;

-- Registrar Solicitud

PROCEDURE pRegistrarSolicitud(ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2)
IS
vCliente VARCHAR2(100);
BEGIN
    
    vCliente := pkcliente.fconsultar(ivCliente_cedulaCliente);
    if vCliente is not null
    then
    pksolicitud.pinsertar(SYSDATE ,null, ivObservaciones, ivEstado, ivCliente_cedulaCliente, null, ivTipoSolicitud, ivProdCli_codigoProducto, ivIdSolicitud);
    END IF;
END pRegistrarSolicitud;

FUNCTION fListarConstantes RETURN VARCHAR2
IS
BEGIN
        RETURN pkconstantes.flistarconstantes;
END fListarConstantes;

--Solicitud x Funcionario
FUNCTION fSolicitudXFuncionario RETURN VARCHAR2
IS
    CURSOR cuSolicitudXFuncionario IS
        SELECT solicitud.idsolicitud as "ID SOLICITUD", funcionario.nombre as " Nombre Funcionario"
        FROM solicitud  INNER JOIN funcionario  on solicitud.funcionario_cedulafuncionario = funcionario.cedulafuncionario
        WHERE solicitud.estado = '02'
        ORDER BY solicitud.funcionario_cedulafuncionario;
        
vIdSolicitud VARCHAR2(8);
vNombreFuncionario  VARCHAR2(30);
ovConsulta VARCHAR2(100);
BEGIN
ovConsulta :='';
    
    OPEN cuSolicitudXFuncionario;
     LOOP
        FETCH cuSolicitudXFuncionario INTO vIdSolicitud, vNombreFuncionario ;
        EXIT WHEN cuSolicitudXFuncionario%NOTFOUND;
        ovConsulta:= ovConsulta|| vIdSolicitud|| ' '||vNombreFuncionario||',';
     END LOOP;    
    CLOSE cuSolicitudXFuncionario;
    
RETURN ovConsulta;
END fSolicitudXFuncionario;

--Solicitud x Estado
FUNCTION fSolicitudXEstado RETURN VARCHAR2
IS
    CURSOR cuConsulta IS
        SELECT solicitud.idsolicitud as "ID SOLICITUD", constantes.valor as " Estado Solicitud"
        FROM solicitud INNER JOIN constantes on solicitud.estado = constantes.codigoconstante
        ORDER BY solicitud.estado;
        
vIdSolicitud VARCHAR2(8);
vEstado  VARCHAR2(30);
ovConsulta VARCHAR2(100);
BEGIN
ovConsulta :='';
    
    OPEN cuConsulta;
     LOOP
        FETCH cuConsulta INTO vIdSolicitud, vEstado ;
        EXIT WHEN cuConsulta%NOTFOUND;

        ovConsulta:= ovConsulta|| vIdSolicitud|| ' '||vEstado||',';
     END LOOP;    
    CLOSE cuConsulta;
    DBMS_OUTPUT.PUT_LINE(ovConsulta);
    
RETURN ovConsulta;
END fSolicitudXEstado;

--Solicitud x Tipo
FUNCTION fSolicitudXTipo RETURN VARCHAR2
IS
    CURSOR cuConsulta IS
        SELECT solicitud.idsolicitud as "ID SOLICITUD", solicitud.tiposolicitud as " Tipo Solicitud"
        FROM solicitud  
        ORDER BY solicitud.tiposolicitud;
        
vIdSolicitud VARCHAR2(8);
vTipo  VARCHAR2(30);
ovConsulta VARCHAR2(100);
BEGIN
ovConsulta :='';
    
    OPEN cuConsulta;
     LOOP
        FETCH cuConsulta INTO vIdSolicitud, vTipo ;
        EXIT WHEN cuConsulta%NOTFOUND;
        ovConsulta:= ovConsulta|| vIdSolicitud|| ' '||vTipo||',';
     END LOOP;    
    CLOSE cuConsulta;
    
RETURN ovConsulta;
END fSolicitudXTipo;

--Productos x Cliente
FUNCTION fProductosXCliente RETURN VARCHAR2
IS
    CURSOR cuConsulta IS
        SELECT prodcli.codigoproducto as "CODIGO PRODUCTO", prodcli.cliente_cedulacliente as " Cedula Cliente"
        FROM prodcli  
        ORDER BY prodcli.cliente_cedulacliente;
        
vCodigoProducto NUMBER(8);
vCedulaCliente  VARCHAR2(20);
ovConsulta VARCHAR2(100);
BEGIN
ovConsulta :='';
    
    OPEN cuConsulta;
     LOOP
        FETCH cuConsulta INTO vCodigoProducto, vCedulaCliente ;
        EXIT WHEN cuConsulta%NOTFOUND;
        ovConsulta:= ovConsulta|| TO_CHAR(vCodigoProducto)|| ' '||vCedulaCliente||',';
     END LOOP;    
    CLOSE cuConsulta;
    
RETURN ovConsulta;
END fProductosXCliente;
END pkRegistroNivel2;
