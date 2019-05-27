package modelo;

import java.sql.*;

public class Funcionario {
	
	
	public void dropTable(Connection con) 
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("DROP TABLE FUNCIONARIO CASCADE constraints");
			System.out.println("Se borro la tabla funcionario");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertar(Connection con,String cedulaFuncionario,String nombre,String fechaNacimiento,String direccion, String telefono	)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("EXECUTE pkRegistroNivel2.pregistrarfuncionario('"+cedulaFuncionario+"','"+nombre+"','"+"TO_DATE('"+fechaNacimiento+"', 'DD/MM/YYYY'))"+",'"+direccion+"','"+telefono+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void actualizar(Connection con,String cedulaFuncionario,String nombre,String fechaNacimiento,String direccion, String telefono	)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("EXECUTE pkRegistroNivel2.pactualizarfuncionario('"+cedulaFuncionario+"','"+nombre+"',"+"TO_DATE('"+fechaNacimiento+"', 'DD/MM/YYYY'))"+",'"+direccion+"','"+telefono+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void borrar(Connection con,String cedulaFuncionario)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("EXECUTE pkRegistroNivel2.pborrarfuncionario('"+cedulaFuncionario+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
