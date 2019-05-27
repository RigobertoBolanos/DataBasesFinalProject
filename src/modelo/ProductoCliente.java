package modelo;

import java.sql.*;

public class ProductoCliente {
	
	
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
