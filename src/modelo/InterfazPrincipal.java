package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InterfazPrincipal {
	
	public static void main(String[] args) {
		try
		{
			//CREACIÓN DE LA CONEXIÓN CON LA BASE DE DATOS
			ConexionOracle conexion=new ConexionOracle();
			Connection con = conexion.getConexion();
			Statement stmt = con.createStatement();
			//ELIMINACION DE TABLAS
			ResultSet rs = stmt.executeQuery("DROP TABLE CLIENTE CASCADE CONSTRAINTS");
			rs = stmt.executeQuery("DROP TABLE CONSSOLI CASCADE CONSTRAINTS");
			rs = stmt.executeQuery("DROP TABLE CONSTANTES CASCADE CONSTRAINTS");
			rs = stmt.executeQuery("DROP TABLE FUNCIONARIO CASCADE CONSTRAINTS");
			rs = stmt.executeQuery("DROP TABLE PRODCLI CASCADE CONSTRAINTS");
			rs = stmt.executeQuery("DROP TABLE SOLICITUD CASCADE CONSTRAINTS");
			//CREACION TABLA CLIENTE
			stmt = con.createStatement();
			rs = stmt.executeQuery("CREATE TABLE cliente (\r\n" + 
					"    cedulacliente     VARCHAR2(20) NOT NULL,\r\n" + 
					"    nombre            VARCHAR2(30) NOT NULL,\r\n" + 
					"    fechanacimiento   DATE NOT NULL,\r\n" + 
					"    direccion         VARCHAR2(30) NOT NULL,\r\n" + 
					"    telefono          VARCHAR2(12) NOT NULL\r\n" + 
					")");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( cedulacliente )");
			System.out.println("Se creo la tabla cliente");
			
			//CREACION TABLA CONSTANTES SOLICITUD
			stmt = con.createStatement();
			rs = stmt.executeQuery("CREATE TABLE conssoli (\r\n" + 
					"    solicitud_idsolicitud        VARCHAR2(8) NOT NULL,\r\n" + 
					"    constantes_codigoconstante   VARCHAR2(2) NOT NULL\r\n" + 
					")");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE conssoli ADD CONSTRAINT conssoli_pk PRIMARY KEY ( solicitud_idsolicitud,\r\n" + 
					"                                                              constantes_codigoconstante )");
			System.out.println("Se creo la tabla constantes solicitud");
			
			//CREACION TABLA CONSTANTES
			stmt = con.createStatement();
			rs = stmt.executeQuery("CREATE TABLE constantes (\r\n" + 
					"    codigoconstante   VARCHAR2(20) NOT NULL,\r\n" + 
					"    nombreconstante   VARCHAR2(20) NOT NULL,\r\n" + 
					"    valor             VARCHAR2(20) NOT NULL\r\n" + 
					")");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN constantes.codigoconstante IS\r\n" + 
					"    'codigo que identifica a la constante'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN constantes.nombreconstante IS\r\n" + 
					"    'Nombre de la constante'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN constantes.valor IS\r\n" + 
					"    'valor de la constante'");
			System.out.println("Se creo la tabla constantes");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE constantes ADD CONSTRAINT constantes_pk PRIMARY KEY ( codigoconstante )");
			
			//CREACION TABLA FUNCIONARIO
			stmt = con.createStatement();
			rs = stmt.executeQuery("CREATE TABLE funcionario (\r\n" + 
					"    cedulafuncionario   VARCHAR2(20) NOT NULL,\r\n" + 
					"    nombre              VARCHAR2(30) NOT NULL,\r\n" + 
					"    fechanacimiento     DATE NOT NULL,\r\n" + 
					"    direccion           VARCHAR2(30) NOT NULL,\r\n" + 
					"    telefono            VARCHAR2(12) NOT NULL\r\n" + 
					")");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE funcionario ADD CONSTRAINT funcionario_pk PRIMARY KEY ( cedulafuncionario )");
			System.out.println("Se creo la tabla funcionario");
			
			//CREACION TABLA PRODUCTO CLIENTE
			stmt = con.createStatement();
			rs = stmt.executeQuery("CREATE TABLE prodcli (\r\n" + 
					"    codigoproducto               NUMBER(8) NOT NULL,\r\n" + 
					"    cliente_cedulacliente        VARCHAR2(20) NOT NULL,\r\n" + 
					"    constantes_codigoconstante   VARCHAR2(20) NOT NULL,\r\n" + 
					"    fechainicio                  DATE NOT NULL,\r\n" + 
					"    fecharetiro                  DATE\r\n" + 
					")");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN prodcli.codigoproducto IS\r\n" + 
					"    'Codigo del producto'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE prodcli ADD CONSTRAINT prodcli_pk PRIMARY KEY ( codigoproducto )");
			System.out.println("Se creo la tabla producto cliente");
			
			//CREACION TABLA SOLICITUD
			stmt = con.createStatement();
			rs = stmt.executeQuery("CREATE TABLE solicitud (\r\n" + 
					"    fechacreacion                   DATE NOT NULL,\r\n" + 
					"    fechaasignacion                 DATE,\r\n" + 
					"    observaciones                   VARCHAR2(140),\r\n" + 
					"    estado                          VARCHAR2(15) NOT NULL,\r\n" + 
					"    cliente_cedulacliente           VARCHAR2(20) NOT NULL,\r\n" + 
					"    funcionario_cedulafuncionario   VARCHAR2(20),\r\n" + 
					"    tiposolicitud                   VARCHAR2(20) NOT NULL,\r\n" + 
					"    prodcli_codigoproducto          NUMBER(8),\r\n" + 
					"    idsolicitud                     VARCHAR2(8) NOT NULL\r\n" + 
					")");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN solicitud.fechacreacion IS\r\n" + 
					"    'Fecha de creacion de la solicitud'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN solicitud.fechaasignacion IS\r\n" + 
					"    'Fecha asignacion de la solicitud'");
					
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN solicitud.observaciones IS\r\n" + 
					"    'Observaciones sobre la solicitud'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN solicitud.estado IS\r\n" + 
					"    'Estado de la solicitud, pueden ser: ASIGNADO, PENDIENTE, ATENDIDO.'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN solicitud.cliente_cedulacliente IS\r\n" + 
					"    'Cedula del cliente que realizó la solicitud'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN solicitud.funcionario_cedulafuncionario IS\r\n" + 
					"    'Cedula del funcionario al que se asigno la solicitud'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("COMMENT ON COLUMN solicitud.tiposolicitud IS\r\n" + 
					"    'Tipo de solicitud'");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE solicitud ADD CONSTRAINT solicitud_pk PRIMARY KEY ( idsolicitud )");
			System.out.println("Se creo la tabla solicitud");
			
			//CLAVES FORANEAS
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE conssoli\r\n" + 
					"    ADD CONSTRAINT conssoli_constantes_fk FOREIGN KEY ( constantes_codigoconstante )\r\n" + 
					"        REFERENCES constantes ( codigoconstante )");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE conssoli\r\n" + 
					"    ADD CONSTRAINT conssoli_solicitud_fk FOREIGN KEY ( solicitud_idsolicitud )\r\n" + 
					"        REFERENCES solicitud ( idsolicitud )" + 
					"");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE prodcli\r\n" + 
					"    ADD CONSTRAINT prodcli_cliente_fk FOREIGN KEY ( cliente_cedulacliente )\r\n" + 
					"        REFERENCES cliente ( cedulacliente )");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE prodcli\r\n" + 
					"    ADD CONSTRAINT prodcli_constantes_fk FOREIGN KEY ( constantes_codigoconstante )\r\n" + 
					"        REFERENCES constantes ( codigoconstante )" + 
					"");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE solicitud\r\n" + 
					"    ADD CONSTRAINT solicitud_cliente_fk FOREIGN KEY ( cliente_cedulacliente )\r\n" + 
					"        REFERENCES cliente ( cedulacliente )" + 
					"");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE solicitud\r\n" + 
					"    ADD CONSTRAINT solicitud_funcionario_fk FOREIGN KEY ( funcionario_cedulafuncionario )\r\n" + 
					"        REFERENCES funcionario ( cedulafuncionario )" + 
					"");
			stmt = con.createStatement();
			rs = stmt.executeQuery("ALTER TABLE solicitud\r\n" + 
					"    ADD CONSTRAINT solicitud_prodcli_fk FOREIGN KEY ( prodcli_codigoproducto )\r\n" + 
					"        REFERENCES prodcli ( codigoproducto )");
			
			//REGISTRO DE CONSTANTES INICIALES
			Constantes constantes = new Constantes();
			constantes.insertar(con, "01", "PENDIENTE", "PENDIENTE");
			constantes.insertar(con, "02", "ASIGNADA", "ASIGNADA");
			constantes.insertar(con, "03", "ATENDIDA", "ATENDIDA");
			
			constantes.insertar(con, "11", "VOZ", "VOZ");
			constantes.insertar(con, "12", "DATOS", "DATOS");
			constantes.insertar(con, "13", "INTEGRADO", "INTEGRADO");

			constantes.insertar(con, "21", "CREACION", "PENDIENTE");
			constantes.insertar(con, "22", "MODIFICACION", "MODIFICACION");
			constantes.insertar(con, "23", "CANCELACION", "CANCELACION");
			constantes.insertar(con, "24", "RECLAMO", "RECLAMO");
			constantes.insertar(con, "25", "DAÑO", "DAÑO");

			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
