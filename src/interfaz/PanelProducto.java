package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class PanelProducto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtValor;

	private JRadioButton rdbCreacion;
	private JRadioButton rdbModificacion;
	private JRadioButton rdbEliminacion;
	
	private JButton btnAceptar;
	
	/**
	 * Launch the application.
	 */
	/*
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
*/
	/**
	 * Create the frame.
	 */
	public PanelProducto() {
		setTitle("Producto");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Seleccione la operacion");
		label.setBounds(24, 11, 139, 14);
		contentPane.add(label);
		
		ButtonGroup grupoRadio = new ButtonGroup();
		
		rdbCreacion = new JRadioButton("Creaci\u00F3n");
		rdbCreacion.setBounds(24, 47, 99, 23);
		rdbCreacion.addActionListener(this);
		rdbCreacion.setActionCommand("creacion");
		contentPane.add(rdbCreacion);
		
		rdbModificacion = new JRadioButton("Modificaci\u00F3n");
		rdbModificacion.setBounds(159, 47, 114, 23);
		rdbModificacion.addActionListener(this);
		rdbModificacion.setActionCommand("modificacion");
		contentPane.add(rdbModificacion);
		
		rdbEliminacion = new JRadioButton("Eliminaci\u00F3n");
		rdbEliminacion.setBounds(300, 47, 109, 23);
		rdbEliminacion.addActionListener(this);
		rdbEliminacion.setActionCommand("eliminacion");
		contentPane.add(rdbEliminacion);
		
		grupoRadio.add(rdbCreacion);
		grupoRadio.add(rdbModificacion);
		grupoRadio.add(rdbEliminacion);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(193, 105, 167, 20);
		contentPane.add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(193, 135, 167, 20);
		contentPane.add(txtNombre);
		
		txtValor = new JTextField();
		txtValor.setEnabled(false);
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
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(172, 221, 89, 23);
		contentPane.add(btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ac = e.getActionCommand();
		if(ac.equals("creacion")) {
			txtCodigo.setEnabled(true);
			txtNombre.setEnabled(true);
			txtValor.setEnabled(true);
		}
		if(ac.equals("modificacion")) {
			txtCodigo.setEnabled(true);
			txtNombre.setEnabled(true);
			txtValor.setEnabled(true);
		}
		if(ac.equals("eliminacion")) {
			txtCodigo.setEnabled(true);
			txtNombre.setEnabled(false);
			txtValor.setEnabled(false);
		}
		
		btnAceptar.setEnabled(true);
		
	}

}
