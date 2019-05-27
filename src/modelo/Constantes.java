package modelo;

import java.sql.*;

public class Constantes {
	
	
	public void dropTable(Connection con) 
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("DROP TABLE CONSTANTES CASCADE constraints");
			System.out.println("Se borro la tabla constantes");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertar(Connection con, String codigoConstante, String nombreConstante, String valor) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pRegistrarConstante('"+codigoConstante+"','"+nombreConstante+"','"+valor+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void actualizar(Connection con, String codigoConstante, String nombreConstante, String valor) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pactualizarconstante('"+codigoConstante+"','"+nombreConstante+"','"+valor+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void borrar(Connection con, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkregistronivel2.pborrarconstante('"+codigoConstante+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String listar(Connection con) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("BEGIN pkregistronivel2.flistarconstantes; END;");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
