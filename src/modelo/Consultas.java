package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {

	public static void solicitudesXFuncionario(Connection con) 
	{
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
			"SELECT solicitud.idsolicitud as \"ID_SOLICITUD\", funcionario.nombre as \" Nombre_Funcionario\""
			+"FROM solicitud  INNER JOIN funcionario  on solicitud.funcionario_cedulafuncionario = funcionario.cedulafuncionario"
			+"WHERE solicitud.estado = 'ASIGNADA'"
			+"ORDER BY solicitud.funcionario_cedulafuncionario"
					);

			System.out.println("ID SOLICITUD \t NOMBRE FUNCIONARIO");
			while(rs.next()) {
				String idSolicitud = rs.getString("ID_SOLICITUD");
				String nombreFuncionario = rs.getString("Nombre_Funcionario");
				
				System.out.println(idSolicitud + "\t"+ nombreFuncionario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public static void solicitudesXEstado(Connection con) 
	{
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
			"SELECT solicitud.idsolicitud as \"ID_SOLICITUD\", solicitud.estado as \"Estado_Solicitud\""
			+"FROM solicitud "
			+"ORDER BY solicitud.estado"
					);

			
			System.out.println("ID SOLICITUD \t ESTADO SOLICITUD");
			while(rs.next()) {
				String idSolicitud = rs.getString("ID_SOLICITUD");
				String estadoSolicitud = rs.getString("Estado_Solicitud");
				
				System.out.println(idSolicitud + "\t"+ estadoSolicitud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public static void solicitudesXTipo(Connection con) 
	{
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
			"SELECT solicitud.idsolicitud as \"ID_SOLICITUD\", solicitud.tiposolicitud as \" Tipo_Solicitud\""
			+"FROM solicitud  "
			+"ORDER BY solicitud.tiposolicitud;"
					);

			System.out.println("ID SOLICITUD \t TIPO SOLICITUD");
			while(rs.next()) {
				String idSolicitud = rs.getString("ID_SOLICITUD");
				String tipoSolicitud = rs.getString("Tipo_Solicitud");
				
				System.out.println(idSolicitud + "\t"+ tipoSolicitud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public static void productosXCliente(Connection con) 
	{
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
			"SELECT prodcli.codigoproducto as \"CODIGO_PRODUCTO\", prodcli.cliente_cedulacliente as \" Cedula_Cliente\""
			+"FROM prodcli"
			+"ORDER BY prodcli.cliente_cedulacliente"
					);

			
			System.out.println("CODIGO PRODUCTO \t CÉDULA CLIENTE");
			while(rs.next()) {
				String codigoProducto = rs.getString("CODIGO_PRODUCTO");
				String cedulaCliente= rs.getString("Cedula_Cliente");
				
				System.out.println(codigoProducto + "\t"+ cedulaCliente);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	public static void main(String[] args) {
		ConexionOracle conexion = new ConexionOracle();
		Connection con = conexion.getConexion();
		solicitudesXEstado(con);
		solicitudesXFuncionario(con);
		solicitudesXTipo(con);
		productosXCliente(con);
		
	}
	

	
	
}
