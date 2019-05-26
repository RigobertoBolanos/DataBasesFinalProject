-- Generado por Oracle SQL Developer Data Modeler 18.4.0.339.1532
--   en:        2019-05-25 23:25:04 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g
DROP TABLE CLIENTE CASCADE CONSTRAINTS;
DROP TABLE CONSSOLI CASCADE CONSTRAINTS;
DROP TABLE CONSTANTES CASCADE CONSTRAINTS;
DROP TABLE FUNCIONARIO CASCADE CONSTRAINTS;
DROP TABLE PRODCLI CASCADE CONSTRAINTS;
DROP TABLE SOLICITUD CASCADE CONSTRAINTS;


CREATE TABLE cliente (
    cedulacliente     VARCHAR2(20) NOT NULL,
    nombre            VARCHAR2(30) NOT NULL,
    fechanacimiento   DATE NOT NULL,
    direccion         VARCHAR2(30) NOT NULL,
    telefono          VARCHAR2(12) NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( cedulacliente );

CREATE TABLE conssoli (
    solicitud_idsolicitud        VARCHAR2(8) NOT NULL,
    constantes_codigoconstante   VARCHAR2(2) NOT NULL
);

ALTER TABLE conssoli ADD CONSTRAINT conssoli_pk PRIMARY KEY ( solicitud_idsolicitud,
                                                              constantes_codigoconstante );

CREATE TABLE constantes (
    codigoconstante   VARCHAR2(20) NOT NULL,
    nombreconstante   VARCHAR2(20) NOT NULL,
    valor             VARCHAR2(20) NOT NULL
);

COMMENT ON COLUMN constantes.codigoconstante IS
    'codigo que identifica a la constante';

COMMENT ON COLUMN constantes.nombreconstante IS
    'Nombre de la constante';

COMMENT ON COLUMN constantes.valor IS
    'valor de la constante';

ALTER TABLE constantes ADD CONSTRAINT constantes_pk PRIMARY KEY ( codigoconstante );

CREATE TABLE funcionario (
    cedulafuncionario   VARCHAR2(20) NOT NULL,
    nombre              VARCHAR2(30) NOT NULL,
    fechanacimiento     DATE NOT NULL,
    direccion           VARCHAR2(30) NOT NULL,
    telefono            VARCHAR2(12) NOT NULL
);

ALTER TABLE funcionario ADD CONSTRAINT funcionario_pk PRIMARY KEY ( cedulafuncionario );

CREATE TABLE prodcli (
    codigoproducto               NUMBER(8) NOT NULL,
    cliente_cedulacliente        VARCHAR2(20) NOT NULL,
    constantes_codigoconstante   VARCHAR2(20) NOT NULL,
    fechainicio                  DATE NOT NULL,
    fecharetiro                  DATE
);

COMMENT ON COLUMN prodcli.codigoproducto IS
    'Codigo del producto';

ALTER TABLE prodcli ADD CONSTRAINT prodcli_pk PRIMARY KEY ( codigoproducto );

CREATE TABLE solicitud (
    fechacreacion                   DATE NOT NULL,
    fechaasignacion                 DATE,
    observaciones                   VARCHAR2(140),
    estado                          VARCHAR2(15) NOT NULL,
    cliente_cedulacliente           VARCHAR2(20) NOT NULL,
    funcionario_cedulafuncionario   VARCHAR2(20),
    tiposolicitud                   VARCHAR2(20) NOT NULL,
    prodcli_codigoproducto          NUMBER(8),
    idsolicitud                     VARCHAR2(8) NOT NULL
);

COMMENT ON COLUMN solicitud.fechacreacion IS
    'Fecha de creacion de la solicitud';

COMMENT ON COLUMN solicitud.fechaasignacion IS
    'Fecha asignacion de la solicitud';

COMMENT ON COLUMN solicitud.observaciones IS
    'Observaciones sobre la solicitud';

COMMENT ON COLUMN solicitud.estado IS
    'Estado de la solicitud, pueden ser: ASIGNADO, PENDIENTE, ATENDIDO.';

COMMENT ON COLUMN solicitud.cliente_cedulacliente IS
    'Cedula del cliente que realizó la solicitud';

COMMENT ON COLUMN solicitud.funcionario_cedulafuncionario IS
    'Cedula del funcionario al que se asigno la solicitud';

COMMENT ON COLUMN solicitud.tiposolicitud IS
    'Tipo de solicitud';

ALTER TABLE solicitud ADD CONSTRAINT solicitud_pk PRIMARY KEY ( idsolicitud );

ALTER TABLE conssoli
    ADD CONSTRAINT conssoli_constantes_fk FOREIGN KEY ( constantes_codigoconstante )
        REFERENCES constantes ( codigoconstante );

ALTER TABLE conssoli
    ADD CONSTRAINT conssoli_solicitud_fk FOREIGN KEY ( solicitud_idsolicitud )
        REFERENCES solicitud ( idsolicitud );

ALTER TABLE prodcli
    ADD CONSTRAINT prodcli_cliente_fk FOREIGN KEY ( cliente_cedulacliente )
        REFERENCES cliente ( cedulacliente );

ALTER TABLE prodcli
    ADD CONSTRAINT prodcli_constantes_fk FOREIGN KEY ( constantes_codigoconstante )
        REFERENCES constantes ( codigoconstante );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_cliente_fk FOREIGN KEY ( cliente_cedulacliente )
        REFERENCES cliente ( cedulacliente );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_funcionario_fk FOREIGN KEY ( funcionario_cedulafuncionario )
        REFERENCES funcionario ( cedulafuncionario );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_prodcli_fk FOREIGN KEY ( prodcli_codigoproducto )
        REFERENCES prodcli ( codigoproducto );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             6
-- CREATE INDEX                             0
-- ALTER TABLE                             13
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
