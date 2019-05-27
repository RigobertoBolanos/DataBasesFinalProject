import java.sql.*;

public class Constantes {
	
	
	public void dropTable(Connection con) 
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("DROP TABLE CONSTANTES CASCADE constraints");
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
			ResultSet rs = stmt.executeQuery("pkregistronivel2.pregistrarconstante("+codigoConstante+","+nombreConstante+","+valor+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void actualizar(Connection con, String codigoConstante, String nombreConstante, String valor) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("pkregistronivel2.pactualizarconstante("+codigoConstante+","+nombreConstante+","+valor+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void borrar(Connection con, String codigoConstante) {
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("pkregistronivel2.pborrarconstante("+codigoConstante+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
