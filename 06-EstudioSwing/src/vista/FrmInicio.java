package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmInicio extends JFrame {

	private JPanel panel;
	private JTextField textNombre;
	private JLabel lblNombre;
	private JButton btnAceptar;
	private JLabel lblSaludo;

	/**
	 * Create the frame.
	 */
	public FrmInicio() {
		setTitle("Hola mundo desde Swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1039, 425);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		definirVentana();
		definirEvento();
		
		
		this.setVisible(true);
	}

	private void definirEvento() {
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				String saludo = "Hola " + nombre + ", bienvenido";
				lblSaludo.setText(saludo);
			}
		});
		
	}

	private void definirVentana() {
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNombre.setBounds(25, 184, 114, 37);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textNombre.setBounds(134, 190, 201, 24);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAceptar.setBounds(345, 190, 114, 24);
		panel.add(btnAceptar);
		
		lblSaludo = new JLabel("");
		lblSaludo.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblSaludo.setBounds(25, 241, 971, 37);
		panel.add(lblSaludo);
		
	}
}
