package modelo;

import java.sql.*;

/**
 * Clase que implementa los metodos de acceso al nivel 2 que permite el registro al nivel 1 de la tabla solicitud
 * @author hp
 *
 */
public class Solicitud {
		
	/**
	 * Permite eliminar la tabla solicitud
	 * @param con
	 */
	public void dropTable(Connection con) 
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("DROP TABLE SOLICITUD CASCADE constraints");
			System.out.println("Se borro la tabla solicitud");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Permite insertar registros a la tabla solicitud
	 * @param con conexion a la base de datos
	 * @param observaciones observaciones sobre la solicitud
	 * @param estado estado de la solicitud
	 * @param cedulaCliente cedula del cliente que realiza la solicitud
	 * @param tipoSolicitud tipo de solicitud registrada
	 * @param codigoProducto codigo del producto asociado a la solicitud si es el caso
	 * @param idSolicitud identificador de la solicitud
	 */
	public void insertar(Connection con, String observaciones, String estado, String cedulaCliente, String tipoSolicitud, String codigoProducto, String idSolicitud)
	{
		try 
		{
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pregistrarsolicitud('"+observaciones+"','"+estado+"','"+cedulaCliente+"','"+tipoSolicitud+"','"+codigoProducto+"','"+idSolicitud+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite la actualizacion de los registros de la tabla solicitud
	 * @param con conexion a la base de datos
	 * @param observaciones observaciones sobre la solicitud
	 * @param estado estado de la solicitud
	 * @param cedulaCliente cedula del cliente que realiza la solicitud
	 * @param tipoSolicitud tipo de solicitud registrada
	 * @param codigoProducto codigo del producto asociado a la solicitud si es el caso
	 * @param idSolicitud identificador de la solicitud
	 */
	public void actualizar(Connection con, String observaciones, String estado, String cedulaCliente, String cedulaFuncionario, String tipoSolicitud, String codigoProducto, String idSolicitud)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pactualizarsolicitud('"+observaciones+"','"+estado+"','"+cedulaCliente+"','"+cedulaFuncionario+"','"+tipoSolicitud+"','"+codigoProducto+"','"+idSolicitud+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite eliminar registros de la tabla solicitud
	 * @param con conexion a la base de datos
	 * @param idSolicitud identificador de la solicitud
	 */
	public void borrar(Connection con, String idSolicitud)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pborrarsolicitud('"+idSolicitud+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
