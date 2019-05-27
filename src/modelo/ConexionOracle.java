package modelo;

import java.sql.*;

public class ConexionOracle {
	
	private Connection conexion;
	
	public ConexionOracle()
	{
		try 
		{
			
			Connection con = DriverManager.getConnection(
					"jdbc:Oracle:thin:@//200.3.193.24:1522/ESTUD",
					"P09551_1_18",
					"P09551_1_18_20191");
			conexion=con;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	

}
