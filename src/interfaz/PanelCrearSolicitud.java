package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdk.jfr.events.FileWriteEvent;
import modelo.ConexionOracle;
import modelo.Constantes;
import modelo.ConstantesSolicitud;
import modelo.Solicitud;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.Buffer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class PanelCrearSolicitud extends JFrame {
//PROCEDURE pRegistrarSolicitud(ivObservaciones VARCHAR2, ivEstado VARCHAR2, ivCliente_cedulaCliente VARCHAR2, ivTipoSolicitud VARCHAR2, ivProdCli_codigoProducto NUMBER, ivIdSolicitud VARCHAR2);
	private JPanel contentPane;
	private JTextField txtCedulaCliente;
	private JTextField txtCodigoProducto;
	private JComboBox cmbTipoProducto;
	private JTextArea txtaObservaciones;
	private JRadioButton rdbtnModificacin;
	private JRadioButton rdbtnCancelacin;
	private JRadioButton rdbtnDao;
	private JRadioButton rdbtnReclamo;
	private JButton btnRegistrarSolicitud;
	private JRadioButton rdbtnCreacin;
	/**
	 * Create the frame.
	 */
	public PanelCrearSolicitud() {
		setTitle("Registro de Solicitudes");
		setBounds(100, 100, 464, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnCreacin = new JRadioButton("Creación");
		rdbtnCreacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				rdbtnCancelacin.setSelected(false);
				rdbtnDao.setSelected(false);
				rdbtnModificacin.setSelected(false);
				rdbtnReclamo.setSelected(false);
				rdbtnCreacin.setSelected(true);
				
				txtCedulaCliente.setEnabled(true);
				txtCodigoProducto.setEnabled(false);
				cmbTipoProducto.setEnabled(true);
				txtaObservaciones.setEnabled(true);
			}
		});
		rdbtnCreacin.setBounds(12, 32, 79, 25);
		contentPane.add(rdbtnCreacin);
		
		rdbtnModificacin = new JRadioButton("Modificación");
		rdbtnModificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				rdbtnCancelacin.setSelected(false);
				rdbtnDao.setSelected(false);
				rdbtnModificacin.setSelected(true);
				rdbtnReclamo.setSelected(false);
				rdbtnCreacin.setSelected(false);
				
				txtCedulaCliente.setEnabled(true);
				txtCodigoProducto.setEnabled(true);
				cmbTipoProducto.setEnabled(true);
				txtaObservaciones.setEnabled(true);
			}
		});
		rdbtnModificacin.setBounds(95, 32, 99, 25);
		contentPane.add(rdbtnModificacin);
		
		rdbtnCancelacin = new JRadioButton("Cancelación");
		rdbtnCancelacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				rdbtnCancelacin.setSelected(true);
				rdbtnDao.setSelected(false);
				rdbtnModificacin.setSelected(false);
				rdbtnReclamo.setSelected(false);
				rdbtnCreacin.setSelected(false);
				
				txtCedulaCliente.setEnabled(true);
				txtCodigoProducto.setEnabled(true);
				cmbTipoProducto.setEnabled(false);
				txtaObservaciones.setEnabled(true);
			}
		});
		rdbtnCancelacin.setBounds(198, 32, 99, 25);
		contentPane.add(rdbtnCancelacin);
		
		rdbtnDao = new JRadioButton("Daño");
		rdbtnDao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				rdbtnCancelacin.setSelected(false);
				rdbtnDao.setSelected(true);
				rdbtnModificacin.setSelected(false);
				rdbtnReclamo.setSelected(false);
				rdbtnCreacin.setSelected(false);
				
				txtCedulaCliente.setEnabled(true);
				txtCodigoProducto.setEnabled(true);
				cmbTipoProducto.setEnabled(false);
				txtaObservaciones.setEnabled(true);
			}
		});
		rdbtnDao.setBounds(301, 32, 57, 25);
		contentPane.add(rdbtnDao);
		
		rdbtnReclamo = new JRadioButton("Reclamo");
		rdbtnReclamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				rdbtnCancelacin.setSelected(false);
				rdbtnDao.setSelected(false);
				rdbtnModificacin.setSelected(false);
				rdbtnReclamo.setSelected(true);
				rdbtnCreacin.setSelected(false);
				
				txtCedulaCliente.setEnabled(true);
				txtCodigoProducto.setEnabled(true);
				cmbTipoProducto.setEnabled(false);
				txtaObservaciones.setEnabled(true);
			}
		});
		rdbtnReclamo.setBounds(362, 32, 79, 25);
		contentPane.add(rdbtnReclamo);
		
		JLabel lblElijaElTipo = new JLabel("Elija el tipo de solicitud:");
		lblElijaElTipo.setBounds(12, 7, 141, 16);
		contentPane.add(lblElijaElTipo);
		
		JLabel lblCedulaCliente = new JLabel("Cedula cliente:");
		lblCedulaCliente.setBounds(12, 81, 90, 16);
		contentPane.add(lblCedulaCliente);
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setEnabled(false);
		txtCedulaCliente.setBounds(143, 78, 116, 22);
		contentPane.add(txtCedulaCliente);
		txtCedulaCliente.setColumns(10);
		
		JLabel lblCdigoProducto = new JLabel("C\u00F3digo producto:");
		lblCdigoProducto.setBounds(12, 125, 110, 16);
		contentPane.add(lblCdigoProducto);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setEnabled(false);
		txtCodigoProducto.setBounds(143, 122, 116, 22);
		contentPane.add(txtCodigoProducto);
		txtCodigoProducto.setColumns(10);
		
		JLabel lblTipoProducto = new JLabel("Tipo producto:");
		lblTipoProducto.setBounds(12, 167, 90, 16);
		contentPane.add(lblTipoProducto);
		
		JLabel lblNewLabel = new JLabel("Observaciones:");
		lblNewLabel.setBounds(12, 211, 90, 16);
		contentPane.add(lblNewLabel);
		
		txtaObservaciones = new JTextArea();
		txtaObservaciones.setEnabled(false);
		txtaObservaciones.setBounds(12, 240, 247, 72);
		contentPane.add(txtaObservaciones);
		
		btnRegistrarSolicitud = new JButton("Registrar Solicitud");
		btnRegistrarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ConexionOracle conexion = new ConexionOracle();
				Solicitud solicitud = new Solicitud();
				ConstantesSolicitud conssoli = new ConstantesSolicitud();
				//INFORMACION NECESARIO PARA LA SOLICUTD
				String tipoSolicitud = "";
				String observaciones = txtaObservaciones.getText();
				String cedulaCliente = txtCedulaCliente.getText().trim();
				String codigoProducto = txtCodigoProducto.getText().trim();
				String tipoServicio = "";
				if(rdbtnCancelacin.isSelected())
				{
					tipoSolicitud = Constantes.CANCELACION;
				}
				else if(rdbtnCreacin.isSelected())
				{
					tipoSolicitud = Constantes.CREACION;
				}
				else if(rdbtnDao.isSelected())
				{
					tipoSolicitud = Constantes.DANIO;
				}
				else if(rdbtnModificacin.isSelected())
				{
					tipoSolicitud = Constantes.MODIFICACION;
				}
				else if(rdbtnReclamo.isSelected())
				{
					tipoSolicitud = Constantes.RECLAMO;
				}
				if(cmbTipoProducto.getSelectedItem().toString().equals("VOZ"))
				{
					tipoServicio = Constantes.VOZ;
				}
				else if(cmbTipoProducto.getSelectedItem().toString().equals("DATOS"))
				{
					tipoServicio = Constantes.DATOS;
				}
				else if(cmbTipoProducto.getSelectedItem().toString().equals("INTEGRADO"))
				{
					tipoServicio = Constantes.INTEGRADO;
				}
				CallableStatement cs = null;
				String idSolicitud = "";
				try
				{
					Statement stmt = conexion.getConexion().createStatement();
					cs = conexion.getConexion().prepareCall("{? = call pkRegistroNivel2.fnumerosolicitud()}");
					cs.registerOutParameter(1, Types.VARCHAR);
					cs.execute();
					idSolicitud = cs.getString(1);
					System.out.println(idSolicitud);
					solicitud.insertar(conexion.getConexion(), observaciones, "01", cedulaCliente, tipoSolicitud, codigoProducto, idSolicitud);
					conssoli.insertar(conexion.getConexion(), idSolicitud, "01");
					conssoli.insertar(conexion.getConexion(), idSolicitud, tipoSolicitud);
				}catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnRegistrarSolicitud.setBounds(12, 326, 141, 25);
		contentPane.add(btnRegistrarSolicitud);
		
		
		try 
		{
			ConexionOracle conexion = new ConexionOracle();
			Connection con = conexion.getConexion();
			Constantes constantes = new Constantes();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		cmbTipoProducto = new JComboBox();
		cmbTipoProducto.setEnabled(false);
		cmbTipoProducto.setModel(new DefaultComboBoxModel(new String[] {"VOZ", "DATOS", "INTEGRADO"}));
		cmbTipoProducto.setBounds(143, 164, 116, 22);
		contentPane.add(cmbTipoProducto);
		
		
	}
}
