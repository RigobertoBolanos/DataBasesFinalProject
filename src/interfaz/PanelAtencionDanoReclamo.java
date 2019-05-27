package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PanelAtencionDanoReclamo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoSolicitud;
	private JTextField txtCedulaFuncionario;
	
	private JComboBox cbxTipo;
	private JComboBox cbxRespuesta;
	
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
					PanelAtencionDanoReclamo frame = new PanelAtencionDanoReclamo();
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
	public PanelAtencionDanoReclamo() {
		setTitle("Atencion da\u00F1os y reclamos");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Codigo solicitud");
		label.setBounds(56, 49, 112, 14);
		contentPane.add(label);
		
		txtCodigoSolicitud = new JTextField();
		txtCodigoSolicitud.setColumns(10);
		txtCodigoSolicitud.setBounds(188, 46, 173, 20);
		contentPane.add(txtCodigoSolicitud);
		
		txtCedulaFuncionario = new JTextField();
		txtCedulaFuncionario.setColumns(10);
		txtCedulaFuncionario.setBounds(188, 82, 173, 20);
		contentPane.add(txtCedulaFuncionario);
		
		JLabel label_1 = new JLabel("Cedula funcionario");
		label_1.setBounds(56, 85, 112, 14);
		contentPane.add(label_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(56, 119, 112, 14);
		contentPane.add(lblTipo);
		
		cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"da\u00F1o", "reclamo"}));
		cbxTipo.setBounds(188, 116, 173, 20);
		contentPane.add(cbxTipo);
		
		JLabel lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setBounds(56, 154, 112, 14);
		contentPane.add(lblRespuesta);
		
		cbxRespuesta = new JComboBox();
		cbxRespuesta.setModel(new DefaultComboBoxModel(new String[] {"atendido", "anulado"}));
		cbxRespuesta.setBounds(188, 151, 173, 20);
		contentPane.add(cbxRespuesta);
		
		JLabel label_2 = new JLabel("Comentarios");
		label_2.setBounds(56, 194, 112, 14);
		contentPane.add(label_2);
		
		taComentarios = new JTextArea();
		taComentarios.setRows(2);
		taComentarios.setColumns(3);
		taComentarios.setBounds(188, 189, 173, 91);
		contentPane.add(taComentarios);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(170, 299, 89, 23);
		contentPane.add(btnAceptar);
	}
}
