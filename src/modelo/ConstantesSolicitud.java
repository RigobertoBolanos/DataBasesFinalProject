package modelo;

import java.sql.*;

public class ConstantesSolicitud {
	
	
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
