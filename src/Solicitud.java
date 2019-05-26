import java.sql.*;

public class Solicitud {
	
	public void dropTable(Connection con) 
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("DROP TABLE SOLICITUD CASCADE constraints");
			System.out.println("Se borro la tabla solicitud");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertar(Connection con, String observaciones, String estado, String cedulaCliente, String tipoSolicitud, String codigoProducto, String idSolicitud)
	{
		try 
		{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("pkRegistroNivel2.pregistrarsolicitud("+observaciones+","+estado+","+cedulaCliente+","+tipoSolicitud+","+codigoProducto+","+idSolicitud+")");
			
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
			ResultSet rs = stmt.executeQuery("pkRegistroNivel2.pactualizarsolicitud("+observaciones+","+estado+","+cedulaCliente+","+cedulaFuncionario+","+tipoSolicitud+","+codigoProducto+","+idSolicitud+")");
			
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
			ResultSet rs = stmt.executeQuery("pkRegistroNivel2.pborrarsolicitud("+idSolicitud+")");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
