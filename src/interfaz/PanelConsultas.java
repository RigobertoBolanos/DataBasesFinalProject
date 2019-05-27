package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import modelo.ConexionOracle;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.awt.event.ActionEvent;

public class PanelConsultas extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private ConexionOracle conexion;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PanelConsultas(ConexionOracle con) {
		conexion=con;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsulta = new JLabel("Consulta:");
		lblConsulta.setBounds(77, 13, 66, 31);
		contentPane.add(lblConsulta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Solicitud por funcionario", "Solicitud por estado", "Solicitud por tipo", "Productos por cliente"}));
		comboBox.setBounds(155, 17, 211, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 243, 300, -47);
		contentPane.add(scrollPane);
		
		
		JTextArea textArea = new JTextArea();
		
		scrollPane=new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 110, 408, 233);
		//contentPane.add(textArea);
		contentPane.add(scrollPane);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					CallableStatement cs = null;
					Statement stmt = conexion.getConexion().createStatement();
					String opcion=comboBox.getSelectedItem().toString();
					String retorno="";
					if(opcion.equals("Solicitud por funcionario")){
						cs = conexion.getConexion().prepareCall("{? = call pkRegistroNivel2.fSolicitudXFuncionario ()}");
					    cs.registerOutParameter(1, Types.VARCHAR); //se indica el objeto de salida y la posición, en este caso un String.
					    cs.execute(); //ejecuta la llamada y retorna un boolean, se puede usar también executeUpdate() que retorna un entero.
					    retorno+="Solicitud por funcionario:\n";
					    String consulta = cs.getString(1);
					    if(consulta!=null){
					    	String[] split=consulta.split(",");
					    	for(int i=0;i<split.length;i++){
					    		String linea=split[i];
					    		String[] splitdata=linea.split(" ");
					    		String idSol=splitdata[0];
					    		String idEmp=splitdata[1];
					    		retorno+="Id Solicitud: "+idSol+"\n";
					    		retorno+="Funcionario: "+idEmp+"\n\n";
					    }
					    	
					    }
					    
					}
					else if(opcion.equals("Solicitud por estado")){
						cs = conexion.getConexion().prepareCall("{? = call pkRegistroNivel2.fSolicitudXEstado ()}");
					    cs.registerOutParameter(1, Types.VARCHAR); //se indica el objeto de salida y la posición, en este caso un String.
					    cs.execute(); //ejecuta la llamada y retorna un boolean, se puede usar también executeUpdate() que retorna un entero.
					    retorno+="Solicitud por estado:\n";
					    String consulta = cs.getString(1);
					    if(consulta!=null){
					    	String[] split=consulta.split(",");
					    	for(int i=0;i<split.length;i++){
					    		String linea=split[i];
					    		String[] splitdata=linea.split(" ");
					    		String idSol=splitdata[0];
					    		String idEmp=splitdata[1];
					    		retorno+="Id Solicitud: "+idSol+"\n";
					    		retorno+="Estado: "+idEmp+"\n\n";
					    }
					    	
					    }
					}
					
					else if(opcion.equals("Solicitud por tipo")){
						cs = conexion.getConexion().prepareCall("{? = call pkRegistroNivel2.fSolicitudXTipo ()}");
					    cs.registerOutParameter(1, Types.VARCHAR); //se indica el objeto de salida y la posición, en este caso un String.
					    cs.execute(); //ejecuta la llamada y retorna un boolean, se puede usar también executeUpdate() que retorna un entero.
					    retorno+="Solicitud por tipo:\n";
					    String consulta = cs.getString(1);
					    if(consulta!=null){
					    	String[] split=consulta.split(",");
					    	for(int i=0;i<split.length;i++){
					    		String linea=split[i];
					    		String[] splitdata=linea.split(" ");
					    		String idSol=splitdata[0];
					    		String idEmp=splitdata[1];
					    		retorno+="Id Solicitud: "+idSol+"\n";
					    		retorno+="Tipo: "+idEmp+"\n\n";
					    }
					    	
					    }
					}
					else if(opcion.equals("Productos por cliente")){
						cs = conexion.getConexion().prepareCall("{? = call pkRegistroNivel2.fProductosXCliente ()}");
					    cs.registerOutParameter(1, Types.VARCHAR); //se indica el objeto de salida y la posición, en este caso un String.
					    cs.execute(); //ejecuta la llamada y retorna un boolean, se puede usar también executeUpdate() que retorna un entero.
					    retorno+="Productos por cliente:\n";
					    String consulta = cs.getString(1);
					    if(consulta!=null){
					    	String[] split=consulta.split(",");
					    	for(int i=0;i<split.length;i++){
					    		String linea=split[i];
					    		String[] splitdata=linea.split(" ");
					    		String idSol=splitdata[0];
					    		String idEmp=splitdata[1];
					    		retorno+="Id Producto: "+idSol+"\n";
					    		retorno+="Cliente: "+idEmp+"\n\n";
					    }
					    	
					    }
					}
				    //se recupera el resultado de la funcion pl/sql
				     
				    textArea.setText(retorno);
					//System.out.println(retorno);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConsultar.setBounds(155, 64, 97, 25);
		contentPane.add(btnConsultar);
		
		
	}
}
