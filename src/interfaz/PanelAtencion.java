package interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAtencion extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private PanelPrincipal gui;

	/**
	 * Create the panel.
	 */
	public PanelAtencion(PanelPrincipal v) {
		setLayout(null);
		gui=v;
		
		JLabel lblCodigo = new JLabel("Codigo Funcionario:");
		lblCodigo.setBounds(47, 81, 115, 14);
		add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Codigo Solicitud:");
		lblNewLabel.setBounds(47, 106, 99, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 78, 115, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 106, 115, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Atender");
		btnNewButton.setBounds(120, 166, 89, 29);
		add(btnNewButton);

	}
}
