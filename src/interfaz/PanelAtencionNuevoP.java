package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class PanelAtencionNuevoP extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoSolicitud;
	private JTextField txtCedulaFuncionario;
	private JTextField txtCodigoNuevoP;
	private JTextArea taComentarios;
	
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAtencionNuevoP frame = new PanelAtencionNuevoP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public PanelAtencionNuevoP() {
		setTitle("Atenci\u00F3n nuevo producto");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoSolicitud = new JLabel("Codigo solicitud");
		lblCodigoSolicitud.setBounds(50, 45, 112, 14);
		contentPane.add(lblCodigoSolicitud);
		
		txtCodigoSolicitud = new JTextField();
		txtCodigoSolicitud.setBounds(182, 42, 173, 20);
		contentPane.add(txtCodigoSolicitud);
		txtCodigoSolicitud.setColumns(10);
		
		txtCedulaFuncionario = new JTextField();
		txtCedulaFuncionario.setColumns(10);
		txtCedulaFuncionario.setBounds(182, 78, 173, 20);
		contentPane.add(txtCedulaFuncionario);
		
		JLabel lblCedulaFuncionario = new JLabel("Cedula funcionario");
		lblCedulaFuncionario.setBounds(50, 81, 112, 14);
		contentPane.add(lblCedulaFuncionario);
		
		txtCodigoNuevoP = new JTextField();
		txtCodigoNuevoP.setColumns(10);
		txtCodigoNuevoP.setBounds(182, 119, 173, 20);
		contentPane.add(txtCodigoNuevoP);
		
		JLabel lblCodigoNuevoProducto = new JLabel("Codigo nuevo producto");
		lblCodigoNuevoProducto.setBounds(50, 122, 112, 14);
		contentPane.add(lblCodigoNuevoProducto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(167, 261, 89, 23);
		contentPane.add(btnAceptar);
		
		taComentarios = new JTextArea();
		taComentarios.setRows(2);
		taComentarios.setColumns(3);
		taComentarios.setBounds(182, 157, 173, 84);
		contentPane.add(taComentarios);
		
		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setBounds(50, 155, 112, 14);
		contentPane.add(lblComentarios);
	}
}
