package modelo;

import java.sql.*;
/**
 * Representa los metodos de acceso a nivel 2 que permiten el acceso al nivel 1 de la tabla producto cliente
 * @author hp
 *
 */
public class ProductoCliente {
	
	/**
	 * Permite eliminar la tabla productocliente
	 * @param con
	 */
	public void dropTable(Connection con) 
	{
		try
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("DROP TABLE PRODCLI CASCADE constraints");
			System.out.println("Se borro la tabla producto cliente");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Permite insertar registros en la tabla productocliente
	 * @param con conexion a la base de datos
	 * @param codigoProducto codigo del producto
	 * @param cedulaCliente cedula del cliente
	 * @param codigoConstante tipo de servicio del producto
	 * @param fechainicio fecha de creacion del producto
	 * @param fecharetiro fecha de retiro del producto si es el caso
	 */
	public void insertar(Connection con, int codigoProducto, String cedulaCliente, String codigoConstante, String fechainicio, String fecharetiro) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pregistrarproductocliente("+codigoProducto+",'"+cedulaCliente+"','"+codigoConstante+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite la actualizacion de los registros de la tabla prodctocliente
	 * @param con conexion a la base de datos
	 * @param codigoProducto codigo del producto
	 * @param cedulaCliente cedula del cliente
	 * @param codigoConstante tipo de servicio del producto
	 * @param fechainicio fecha de creacion del producto
	 * @param fecharetiro fecha de retiro del producto si es el caso
	 */
	public void actualizar(Connection con, int codigoProducto, String cedulaCliente, String codigoConstante, String fechainicio, String fecharetiro) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pactualizarproductocliente('"+codigoProducto+"','"+cedulaCliente+"','"+codigoConstante+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite eliminar los registros de la tabla producto cliente
	 * @param con conexion a la base de datos
	 * @param codigoProducto codigo del producto
	 */
	public void borrar(Connection con, int codigoProducto) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pborrarproductocliente('"+codigoProducto+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
