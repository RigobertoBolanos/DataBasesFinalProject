package modelo;

import java.sql.*;

public class ProductoCliente {
	
	
	public void dropTable(Connection con) 
	{
		try
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("DROP TABLE PRODCLI CASCADE constraints");
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
			ResultSet rs = stmt.executeQuery("pkregistronivel2.pregistrarproductocliente("+codigoProducto+","+cedulaCliente+","+codigoConstante+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void actualizar(Connection con, int codigoProducto, String cedulaCliente, String codigoConstante, String fechainicio, String fecharetiro) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("pkregistronivel2.pactualizarproductocliente("+codigoProducto+","+cedulaCliente+","+codigoConstante+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void borrar(Connection con, int codigoProducto) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("pkregistronivel2.pborrarproductocliente("+codigoProducto+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
