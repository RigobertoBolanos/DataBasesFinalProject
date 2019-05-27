package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import modelo.ConexionOracle;

import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal {

	private JFrame frmProyectoBasesDe;
	private PanelCliente panelcliente;
	private PanelFuncionario panelfuncionario;
	private PanelProducto panelproducto;
	private ConexionOracle conexion;
	
	private PanelAtencionPrincipal atencion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal window = new PanelPrincipal();
					window.frmProyectoBasesDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PanelPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		conexion=new ConexionOracle();
		frmProyectoBasesDe = new JFrame();
		frmProyectoBasesDe.setTitle("Proyecto Bases de Datos");
		frmProyectoBasesDe.setBounds(100, 100, 412, 251);
		frmProyectoBasesDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectoBasesDe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione la opci\u00F3n correcta");
		lblNewLabel.setBounds(24, 21, 247, 14);
		frmProyectoBasesDe.getContentPane().add(lblNewLabel);
		
		JButton btnTiposDeProducto = new JButton("Tipos de Producto");
		btnTiposDeProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelproducto = new PanelProducto();
				panelproducto.setVisible(true);
			}
		});
		btnTiposDeProducto.setBounds(244, 54, 125, 23);
		frmProyectoBasesDe.getContentPane().add(btnTiposDeProducto);
		
		JButton btnNewButton_1 = new JButton("Funcionarios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelfuncionario = new PanelFuncionario();
				panelfuncionario.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(24, 88, 125, 23);
		frmProyectoBasesDe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelcliente = new PanelCliente();
				panelcliente.setVisible(true);
			}
		});
		btnNewButton.setBounds(24, 54, 124, 23);
		frmProyectoBasesDe.getContentPane().add(btnNewButton);
		
		JButton btnCrearSolicitud = new JButton("Crear Solicitud");
		btnCrearSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				PanelCrearSolicitud panelCrearSolicitud = new PanelCrearSolicitud();
				panelCrearSolicitud.setVisible(true);
			}
		});
		btnCrearSolicitud.setBounds(244, 88, 125, 23);
		frmProyectoBasesDe.getContentPane().add(btnCrearSolicitud);
		
		JButton btnNewButton_2 = new JButton("Atender Solicitud");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				PanelAtencion atencion=new PanelAtencion();
				atencion.setVisible(true);
				*/
				atencion = new PanelAtencionPrincipal();
				atencion.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(24, 122, 125, 23);
		frmProyectoBasesDe.getContentPane().add(btnNewButton_2);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelConsultas consultas=new PanelConsultas(conexion);
				consultas.setVisible(true);
			}
		});
		btnConsultas.setBounds(244, 121, 125, 25);
		frmProyectoBasesDe.getContentPane().add(btnConsultas);
	}
	
	
	
}
