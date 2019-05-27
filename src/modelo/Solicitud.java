package modelo;

import java.sql.*;

public class Solicitud {
	
	public void dropTable(Connection con) 
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("DROP TABLE SOLICITUD CASCADE constraints");
			System.out.println("Se borro la tabla solicitud");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertar(Connection con, String observaciones, String estado, String cedulaCliente, String tipoSolicitud, String codigoProducto)
	{
		try 
		{
			String idSolicitud = "";
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pregistrarsolicitud('"+observaciones+"','"+estado+"','"+cedulaCliente+"','"+tipoSolicitud+"','"+codigoProducto+"','"+idSolicitud+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void actualizar(Connection con, String observaciones, String estado, String cedulaCliente, String cedulaFuncionario, String tipoSolicitud, String codigoProducto, String idSolicitud)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pactualizarsolicitud('"+observaciones+"','"+estado+"','"+cedulaCliente+"','"+cedulaFuncionario+"','"+tipoSolicitud+"','"+codigoProducto+"','"+idSolicitud+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void borrar(Connection con, String idSolicitud)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			stmt.execute("BEGIN pkRegistroNivel2.pborrarsolicitud('"+idSolicitud+"'); END;");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
