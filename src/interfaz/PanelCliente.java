package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PanelCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtFechaNaci;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	
	private JRadioButton rdbCreacion;
	private JRadioButton rdbModificacion;
	private JRadioButton rdbEliminacion;
	
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelCliente frame = new PanelCliente();
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
	public PanelCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		ButtonGroup grupoRadio = new ButtonGroup();
		
		rdbCreacion = new JRadioButton("Creaci\u00F3n");
		rdbCreacion.setBounds(22, 47, 99, 23);
		rdbCreacion.addActionListener(this);
		rdbCreacion.setActionCommand("creacion");
		contentPane.add(rdbCreacion);
		
		rdbModificacion = new JRadioButton("Modificaci\u00F3n");
		rdbModificacion.setBounds(157, 47, 114, 23);
		rdbModificacion.addActionListener(this);
		rdbModificacion.setActionCommand("modificacion");
		contentPane.add(rdbModificacion);
		
		rdbEliminacion = new JRadioButton("Eliminaci\u00F3n");
		rdbEliminacion.setBounds(298, 47, 109, 23);
		rdbEliminacion.addActionListener(this);
		rdbEliminacion.setActionCommand("eliminacion");
		contentPane.add(rdbEliminacion);
		
		grupoRadio.add(rdbCreacion);
		grupoRadio.add(rdbModificacion);
		grupoRadio.add(rdbEliminacion);
		
		JLabel lblSeleccioneLaOperacion = new JLabel("Seleccione la operacion");
		lblSeleccioneLaOperacion.setBounds(22, 11, 139, 14);
		contentPane.add(lblSeleccioneLaOperacion);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(64, 115, 46, 14);
		contentPane.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(64, 145, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(64, 175, 114, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(64, 207, 46, 14);
		contentPane.add(lblDireccin);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(64, 241, 46, 14);
		contentPane.add(lblTelefono);
		
		txtCedula = new JTextField();
		txtCedula.setEnabled(false);
		txtCedula.setBounds(200, 112, 167, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setBounds(200, 142, 167, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtFechaNaci = new JTextField();
		txtFechaNaci.setEnabled(false);
		txtFechaNaci.setBounds(200, 172, 167, 20);
		contentPane.add(txtFechaNaci);
		txtFechaNaci.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(200, 204, 167, 20);
		contentPane.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(200, 238, 167, 20);
		contentPane.add(txtTelefono);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(197, 286, 89, 23);
		contentPane.add(btnAceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String ac = e.getActionCommand();
		if(ac.equals("creacion")) {
			txtCedula.setEnabled(true);
			txtNombre.setEnabled(true);
			txtFechaNaci.setEnabled(true);
			txtDireccion.setEnabled(true);
			txtTelefono.setEnabled(true);
		}
		if(ac.equals("modificacion")) {
			txtCedula.setEnabled(true);
			txtNombre.setEnabled(true);
			txtFechaNaci.setEnabled(true);
			txtDireccion.setEnabled(true);
			txtTelefono.setEnabled(true);
		}
		if(ac.equals("eliminacion")) {
			txtCedula.setEnabled(true);
			txtNombre.setEnabled(false);
			txtFechaNaci.setEnabled(false);
			txtDireccion.setEnabled(false);
			txtTelefono.setEnabled(false);
		}
		
		btnAceptar.setEnabled(true);
	}
	
	
}
