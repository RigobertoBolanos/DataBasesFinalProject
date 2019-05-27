package modelo;

import java.sql.*;

public class Cliente {
	
	/**
	 * Elimina la tabla de clientes
	 * @param con es la conexion con la base de datos
	 */
	public void dropTable(Connection con)
	{
		try
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("DROP TABLE CLIENTE CASCADE constraints");
			System.out.println("Se borro la tabla cliente");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inserta un cliente en la tabla clientes
	 * @param con la conexion con la base de datos
	 * @param cedulaCliente la cedula del cliente
	 * @param nombre el nombre del cliente
	 * @param fechaNacimiento la fecha de nacimiento del cliente
	 * @param direccion la direccion del cliente
	 * @param telefono el telefono del cliente
	 */
	public void insertar(Connection con,String cedulaCliente,String nombre,String fechaNacimiento,String direccion, String telefono	)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pregistrarcliente('"+cedulaCliente+"','"+nombre+"','"+"TO_DATE('"+fechaNacimiento+"', 'DD/MM/YYYY'))"+",'"+direccion+"','"+telefono+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Actualiza un cliente en la tabla clientes
	 * @param con la conexion con la base de datos
	 * @param cedulaCliente la cedula a actualizar
	 * @param nombre el nombrea a actualizar
	 * @param fechaNacimiento la fecha de nacimiento a actualizar
	 * @param direccion la direccion a actualizar
	 * @param telefono el telefono a actualizar
	 */
	public void actualizar(Connection con,String cedulaCliente,String nombre,String fechaNacimiento,String direccion, String telefono)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pactualizarcliente('"+cedulaCliente+"','"+nombre+"',"+"TO_DATE('"+fechaNacimiento+"', 'DD/MM/YYYY'))"+",'"+direccion+"','"+telefono+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Borra un cliente de la tabla clientes
	 * @param con la conexion con la base de datos
	 * @param cedulaCliente la cedula del cliente a borrar
	 */
	public void borrar(Connection con,String cedulaCliente)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pborrarcliente('"+cedulaCliente+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
