package modelo;

import java.sql.*;

public class Cliente {
	
	
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
