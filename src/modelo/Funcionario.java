package modelo;

import java.sql.*;
/**
 * Representa el acceso al nivel2 que permite el acceso al nivel 1 de la tabla funcionario
 * @author hp
 *
 */
public class Funcionario {
	
	/**
	 * Permite la eliminacion de la tabla funcionario
	 * @param con
	 */
	public void dropTable(Connection con) 
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("DROP TABLE FUNCIONARIO CASCADE constraints");
			System.out.println("Se borro la tabla funcionario");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Permite insertar registros a la tabla funcionario
	 * @param con conexion con la base de datos
	 * @param cedulaFuncionario cedula del funcionario
	 * @param nombre nombre del funcionario
	 * @param fechaNacimiento fecha de nacimiento del funcionario
	 * @param direccion direccion del funcionario
	 * @param telefono telefono del funcionario
	 */
	public void insertar(Connection con,String cedulaFuncionario,String nombre,String fechaNacimiento,String direccion, String telefono	)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pregistrarfuncionario('"+cedulaFuncionario+"','"+nombre+"','"+"TO_DATE('"+fechaNacimiento+"', 'DD/MM/YYYY'))"+",'"+direccion+"','"+telefono+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite actualizar los registros de la tabla funcionarios
	 * @param con conexion con la base de datos
	 * @param cedulaFuncionario cedula del funcionario
	 * @param nombre nombre del funcionario
	 * @param fechaNacimiento fecha de nacimiento del funcionario
	 * @param direccion direccion del funcionario
	 * @param telefono telefono del funcionario
	 */
	public void actualizar(Connection con,String cedulaFuncionario,String nombre,String fechaNacimiento,String direccion, String telefono	)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pactualizarfuncionario('"+cedulaFuncionario+"','"+nombre+"',"+"TO_DATE('"+fechaNacimiento+"', 'DD/MM/YYYY'))"+",'"+direccion+"','"+telefono+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Permite eliminar los registros de la tabla funcionario
	 * @param con conexion con la base de datos
	 * @param cedulaFuncionario cedula del funcionario
	 */
	public void borrar(Connection con,String cedulaFuncionario)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pborrarfuncionario('"+cedulaFuncionario+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
