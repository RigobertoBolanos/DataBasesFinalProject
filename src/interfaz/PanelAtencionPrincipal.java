package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAtencionPrincipal extends JFrame {

	private JPanel contentPane;

	private PanelAtencionNuevoP atencionnuevopro;
	private PanelAtencionRetiro atencionretiro;
	private PanelAtencionDanoReclamo atenciondanoreclamo;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAtencionPrincipal frame = new PanelAtencionPrincipal();
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
	public PanelAtencionPrincipal() {
		setTitle("Panel Atenci\u00F3n");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneElTipo = new JLabel("Seleccione el tipo de solicitud a atender");
		lblSeleccioneElTipo.setBounds(10, 25, 241, 14);
		contentPane.add(lblSeleccioneElTipo);
		
		JButton btnNuevoProducto = new JButton("Nuevo Producto");
		btnNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atencionnuevopro = new PanelAtencionNuevoP();
				atencionnuevopro.setVisible(true);
			}
		});
		btnNuevoProducto.setBounds(10, 88, 134, 48);
		contentPane.add(btnNuevoProducto);
		
		JButton btnRetiro = new JButton("Retiro");
		btnRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atencionretiro = new PanelAtencionRetiro();
				atencionretiro.setVisible(true);
			}
		});
		btnRetiro.setBounds(165, 88, 134, 48);
		contentPane.add(btnRetiro);
		
		JButton btnDaosYReclamos = new JButton("Da\u00F1os y Reclamos");
		btnDaosYReclamos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atenciondanoreclamo = new PanelAtencionDanoReclamo();
				atenciondanoreclamo.setVisible(true);
			}
		});
		btnDaosYReclamos.setBounds(316, 88, 134, 48);
		contentPane.add(btnDaosYReclamos);
	}
}
