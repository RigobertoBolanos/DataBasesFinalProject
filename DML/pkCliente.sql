CREATE OR REPLACE PACKAGE pkCliente AS -- spec
PROCEDURE pInsertar(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);
PROCEDURE pBorrar (ivCedula VARCHAR2);
PROCEDURE pModificar(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2);
FUNCTION fConsultar(ivCedula VARCHAR2) RETURN VARCHAR2;
END pkCliente;
/

CREATE OR REPLACE PACKAGE BODY pkCliente AS -- body

-- Implementación Procedimiento 1
PROCEDURE pInsertar
(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2)
IS
BEGIN
    INSERT INTO Cliente
    VALUES (ivCedula, ivNombre, ivFechaNacimiento, ivDireccion,
    ivTelefono);
END pInsertar;

-- Implementación Procedimiento 2
PROCEDURE pBorrar( ivCedula VARCHAR2) IS
BEGIN
    DELETE FROM Cliente WHERE Cliente.cedulaCliente = ivCedula;
END pBorrar;

-- Implementación Procedimiento 3
PROCEDURE pModificar(ivCedula VARCHAR2, ivNombre VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2, ivTelefono VARCHAR2) IS
BEGIN
    UPDATE Cliente SET Cliente.nombre= ivNombre,Cliente.fechaNacimiento= ivFechaNacimiento,Cliente.direccion= ivDireccion, Cliente.telefono= ivTelefono
    WHERE Cliente.cedulaCliente= ivCedula;
END pModificar;

-- Implementación Procedimiento 4
FUNCTION fConsultar(ivCedula VARCHAR2) RETURN VARCHAR2
IS
CURSOR cuClienteSolicitado IS
    SELECT *
    FROM Cliente 
    WHERE Cliente.cedulaCliente= ivCedula;
    
ovCedulaCliente VARCHAR2(20);
ovNombre VARCHAR2(30);
ovFechaNacimiento DATE;
ovDireccion VARCHAR2(30);
ovTelefono VARCHAR2(12);

BEGIN
  
    OPEN cuClienteSolicitado;
    FETCH cuClienteSolicitado INTO ovCedulaCliente, ovNombre, ovFechaNacimiento, ovDireccion, ovTelefono;
    CLOSE cuClienteSolicitado;
    
    if ovcedulacliente is not null
    then
    RETURN ovCedulaCliente || ' ' || ovNombre || ' ' || TO_CHAR(ovFechaNacimiento) || ' ' || ovDireccion || ' ' || ovTelefono;
    else
    RETURN 'El registro con cédula ' || ivCedula || 'no existe en la tabla CLIENTE';
    END IF;
END fConsultar;

END pkCliente;
