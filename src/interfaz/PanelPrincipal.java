package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPrincipal {

	private JFrame frmProyectoBasesDe;

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
		frmProyectoBasesDe = new JFrame();
		frmProyectoBasesDe.setTitle("Proyecto Bases de Datos");
		frmProyectoBasesDe.setBounds(100, 100, 412, 179);
		frmProyectoBasesDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProyectoBasesDe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione la opci\u00F3n correcta");
		lblNewLabel.setBounds(24, 21, 247, 14);
		frmProyectoBasesDe.getContentPane().add(lblNewLabel);
		
		JButton btnTiposDeProducto = new JButton("Tipos de Producto");
		btnTiposDeProducto.setBounds(244, 54, 125, 23);
		frmProyectoBasesDe.getContentPane().add(btnTiposDeProducto);
		
		JButton btnNewButton_1 = new JButton("Funcionarios");
		btnNewButton_1.setBounds(24, 88, 125, 23);
		frmProyectoBasesDe.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Clientes");
		btnNewButton.setBounds(24, 54, 124, 23);
		frmProyectoBasesDe.getContentPane().add(btnNewButton);
		
		JButton btnCrearSolicitud = new JButton("Crear Solicitud");
		btnCrearSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCrearSolicitud.setBounds(244, 88, 125, 23);
		frmProyectoBasesDe.getContentPane().add(btnCrearSolicitud);
	}
}
