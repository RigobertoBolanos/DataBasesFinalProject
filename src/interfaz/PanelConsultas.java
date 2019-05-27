package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PanelConsultas extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelConsultas frame = new PanelConsultas();
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
	public PanelConsultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsulta = new JLabel("Consulta:");
		lblConsulta.setBounds(77, 13, 66, 31);
		contentPane.add(lblConsulta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Solicitud por funcionario", "Solicitud por estado", "Solicitud por tipo", "Productos por cliente"}));
		comboBox.setBounds(155, 17, 211, 22);
		contentPane.add(comboBox);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(155, 64, 97, 25);
		contentPane.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 243, 300, -47);
		contentPane.add(scrollPane);
		
		
		JTextArea textArea = new JTextArea();
		
		scrollPane=new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 110, 408, 233);
		//contentPane.add(textArea);
		contentPane.add(scrollPane);
	}
}
