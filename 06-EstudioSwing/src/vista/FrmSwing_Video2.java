package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSwing_Video2 extends JFrame {

	private JPanel panel;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JButton btnAceptar;
	private JLabel lblSaludo;

	/**
	 * Create the frame.
	 */
	public FrmSwing_Video2() {
		setTitle("Hola mundo desde swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		definirVentana();
		definirEventos();
		this.setVisible(true);
	}

	private void definirEventos() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textNombre.getText();
				lblSaludo.setText("Hola " + nombre);
			}
		});
	}

	private void definirVentana() {
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNombre.setBounds(27, 42, 70, 25);
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textNombre.setToolTipText("");
		textNombre.setBounds(107, 42, 190, 27);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBounds(312, 42, 103, 27);
		panel.add(btnAceptar);
		
		lblSaludo = new JLabel("");
		lblSaludo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSaludo.setBounds(27, 122, 388, 36);
		panel.add(lblSaludo);
		
	}
}
