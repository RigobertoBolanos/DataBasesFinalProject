CREATE OR REPLACE PACKAGE pkProductoCliente as
PROCEDURE pInsertar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2);
PROCEDURE pBorrar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2);
PROCEDURE pModificar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2);
FUNCTION fConsultar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2) RETURN VARCHAR2;
END pkProductoCliente;
/

CREATE OR REPLACE PACKAGE BODY pkProductoCliente AS

PROCEDURE pInsertar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2)
IS 
BEGIN
    INSERT INTO PRODCLI VALUES (ivCodigoProducto, ivCliente_cedulacliente, ivConstantes_codigoconstante);
END pInsertar;

PROCEDURE pBorrar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2)
IS
BEGIN
    DELETE FROM PRODCLI WHERE PRODCLI.codigoProducto = ivCodigoProducto AND PRODCLI.cliente_cedulacliente = ivCliente_cedulacliente;
END pBorrar;

PROCEDURE pModificar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2, ivConstantes_codigoconstante VARCHAR2)
IS
BEGIN 
    UPDATE PRODCLI SET PRODCLI.constantes_nombreconstante = ivConstantes_codigoconstante WHERE PRODCLI.codigoProducto = ivCodigoProducto AND PRODCLI.cliente_cedulacliente = ivCliente_cedulacliente;  
END pModificar;

FUNCTION fConsultar(ivCodigoProducto NUMBER, ivCliente_cedulacliente VARCHAR2) RETURN VARCHAR2
IS
CURSOR cuProductoClienteBuscado IS 
    SELECT *
    FROM PRODCLI 
    WHERE PRODCLI.codigoProducto = ivCodigoProducto AND PRODCLI.cliente_cedulacliente = ivCliente_cedulacliente;
ovCodigoProductoCliente NUMBER(8);
ovCliente_cedulacliente VARCHAR2(20);
ovConstantes_codigoconstante VARCHAR2(20);
BEGIN
    OPEN cuProductoClienteBuscado;
    FETCH cuProductoClienteBuscado INTO ovCodigoProductoCliente, ovCliente_cedulacliente, ovConstantes_codigoconstante;
    CLOSE cuProductoClienteBuscado;
    
    RETURN ovCodigoProductoCliente || ' ' || ovCliente_cedulacliente || ' ' || ovConstantes_codigoconstante;
END fConsultar;

END pkProductoCliente;
