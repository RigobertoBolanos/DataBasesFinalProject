package modelo;

import java.sql.*;

public class ConstantesSolicitud {
	
	
	public void dropTable(Connection con) 
	{
		try
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("DROP TABLE CONSSOLI CASCADE constraints");
			System.out.println("Se borro la tabla Constantes solicitud");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertar(Connection con, String idSolicitud, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("EXECUTE pkregistronivel2.pregistrarconstantessolicitud('"+idSolicitud+"','"+codigoConstante+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void actualizar(Connection con, String idSolicitud, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("EXECUTE pkregistronivel2.pactualizarconstantessolicitud('"+idSolicitud+"','"+codigoConstante+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void borrar(Connection con, String idSolicitud, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("EXECUTE pkregistronivel2.pborrarconstantessolicitud('"+idSolicitud+"','"+codigoConstante+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
