CREATE OR REPLACE PACKAGE pkProductoCliente as
PROCEDURE pInsertar(codigoProducto NUMBER, cliente_cedulacliente VARCHAR2, constantes_codigoconstante VARCHAR2);
PROCEDURE pBorrar(codigoProducto NUMBER, cedulaCliente VARCHAR2);
PROCEDURE pModificar(codigoProducto NUMBER, cliente_cedulacliente VARCHAR2, constantes_codigoconstante VARCHAR2);
FUNCTION fConsultar(codigoProducto NUMBER, cliente_cedulacliente VARCHAR2) RETURN VARCHAR2;
END pkProductoCliente;
/

CREATE OR REPLACE PACKAGE BODY pkProductoCliente AS

PROCEDURE pInsertar(codigoProducto NUMBER, cliente_cedulacliente VARCHAR2, constantes_codigoconstante VARCHAR2)
IS 
BEGIN
    INSERT INTO PRODCLI VALUES (codigoProducto, cliente_cedulacliente, constantes_codigoconstante);
END pInsertar;

PROCEDURE pBorrar(codigoProducto NUMBER, cedulaCliente VARCHAR2)
IS
BEGIN
    DELETE FROM PRODCLI WHERE PRODCLI.codigoProducto = codigoProducto AND PRODCLI.cliente_cedulacliente = cedulaCliente;
END pBorrar;

PROCEDURE pModificar(codigoProducto NUMBER, cliente_cedulacliente VARCHAR2, constantes_codigoconstante VARCHAR2)
IS
BEGIN 
    UPDATE PRODCLI SET PRODCLI.codigoProducto = codigoProducto WHERE PRODCLI.codigoProducto = codigoProducto AND PRODCLI.cliente_cedulacliente = cliente_cedulacliente;  
END pModificar;

FUNCTION fConsultar(codigoProducto NUMBER, cliente_cedulacliente VARCHAR2) RETURN VARCHAR2
IS
CURSOR productoClienteBuscado IS 
    SELECT *
    FROM PRODCLI 
    WHERE PRODCLI.codigoProducto = codigoProducto AND PRODCLI.cliente_cedulacliente = cliente_cedulacliente;
codigoProductoCliente NUMBER(8);
cliente_cedulaclienteV VARCHAR2(20);
constantes_codigoconstante VARCHAR2(20);
BEGIN
    OPEN productoClienteBuscado;
    FETCH productoClienteBuscado INTO codigoProductoCliente, cliente_cedulaclienteV, constantes_codigoconstante;
    CLOSE productoClienteBuscado;
    
    RETURN codigoProductoCliente || ' ' || cliente_cedulaclienteV || ' ' || constantes_codigoconstante;
END fConsultar;

END pkProductoCliente;
