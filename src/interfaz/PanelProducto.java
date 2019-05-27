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

public class PanelProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelProducto frame = new PanelProducto();
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
	public PanelProducto() {
		setTitle("Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Seleccione la operacion");
		label.setBounds(24, 11, 139, 14);
		contentPane.add(label);
		
		JRadioButton rdbCreacion = new JRadioButton("Creaci\u00F3n");
		rdbCreacion.setBounds(24, 47, 99, 23);
		contentPane.add(rdbCreacion);
		
		JRadioButton rdbModificacion = new JRadioButton("Modificaci\u00F3n");
		rdbModificacion.setBounds(159, 47, 114, 23);
		contentPane.add(rdbModificacion);
		
		JRadioButton rdbEliminacion = new JRadioButton("Eliminaci\u00F3n");
		rdbEliminacion.setBounds(300, 47, 109, 23);
		contentPane.add(rdbEliminacion);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(193, 105, 167, 20);
		contentPane.add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(193, 135, 167, 20);
		contentPane.add(txtNombre);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(193, 165, 167, 20);
		contentPane.add(txtValor);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(57, 168, 114, 14);
		contentPane.add(lblValor);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(57, 138, 46, 14);
		contentPane.add(label_2);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(57, 108, 46, 14);
		contentPane.add(lblCodigo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(172, 221, 89, 23);
		contentPane.add(btnAceptar);
	}

}
