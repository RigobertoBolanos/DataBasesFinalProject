package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtFechaNaci;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelFuncionario frame = new PanelFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelFuncionario() {
		setTitle("Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Seleccione la operacion");
		label.setBounds(22, 11, 139, 14);
		contentPane.add(label);
		
		JRadioButton rdbCreacion = new JRadioButton("Creaci\u00F3n");
		rdbCreacion.setBounds(22, 47, 99, 23);
		contentPane.add(rdbCreacion);
		
		JRadioButton rdbModificacion = new JRadioButton("Modificaci\u00F3n");
		rdbModificacion.setBounds(157, 47, 114, 23);
		contentPane.add(rdbModificacion);
		
		JRadioButton rdbEliminacion = new JRadioButton("Eliminaci\u00F3n");
		rdbEliminacion.setBounds(298, 47, 109, 23);
		contentPane.add(rdbEliminacion);
		
		JLabel label_1 = new JLabel("Cedula");
		label_1.setBounds(55, 108, 46, 14);
		contentPane.add(label_1);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(191, 105, 167, 20);
		contentPane.add(txtCedula);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(55, 138, 46, 14);
		contentPane.add(label_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(191, 135, 167, 20);
		contentPane.add(txtNombre);
		
		JLabel label_3 = new JLabel("Fecha de nacimiento");
		label_3.setBounds(55, 168, 114, 14);
		contentPane.add(label_3);
		
		txtFechaNaci = new JTextField();
		txtFechaNaci.setColumns(10);
		txtFechaNaci.setBounds(191, 165, 167, 20);
		contentPane.add(txtFechaNaci);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setBounds(55, 200, 46, 14);
		contentPane.add(label_4);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(191, 197, 167, 20);
		contentPane.add(txtDireccion);
		
		JLabel label_5 = new JLabel("Telefono");
		label_5.setBounds(55, 234, 46, 14);
		contentPane.add(label_5);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(191, 231, 167, 20);
		contentPane.add(txtTelefono);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(188, 279, 89, 23);
		contentPane.add(btnAceptar);
	}

}
