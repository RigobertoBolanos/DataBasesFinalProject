package modelo;

import java.sql.*;
/**
 * Representa el acceso al nivel2 que permite el acceso al nivel1 de la tabla constantes solicitud que representa las constantes asignadas a las solicitudes
 * @author hp
 *
 */
public class ConstantesSolicitud {
	
	/**
	 * Permite eliminar la tabla conssoli
	 * @param con
	 */
	public void dropTable(Connection con) 
	{
		try
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("DROP TABLE CONSSOLI CASCADE constraints");
			System.out.println("Se borro la tabla Constantes solicitud");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Permite insertar registros en la tabla conssoli
	 * @param con conexion con la base de datos
	 * @param idSolicitud identificador de la solicitud
	 * @param codigoConstante identificador de la constante
	 */
	public void insertar(Connection con, String idSolicitud, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pregistrarconstantessolicitud('"+idSolicitud+"','"+codigoConstante+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite la actualizacion de los registros de la tabla conssoli
	 * @param con conexion con la base de datos
	 * @param idSolicitud identificador de la solicitud
	 * @param codigoConstante identificador de la constante
	 */
	public void actualizar(Connection con, String idSolicitud, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pactualizarconstantessolicitud('"+idSolicitud+"','"+codigoConstante+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite eliminar registros de la tabla conssoli
	 * @param con conexion con la base de datos
	 * @param idSolicitud identificador de la solicitud
	 * @param codigoConstante identificador de la constante
	 */
	public void borrar(Connection con, String idSolicitud, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pborrarconstantessolicitud('"+idSolicitud+"','"+codigoConstante+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
