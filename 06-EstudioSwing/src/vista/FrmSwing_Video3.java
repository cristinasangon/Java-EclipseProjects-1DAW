package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSwing_Video3 extends JFrame implements ActionListener{

	private JPanel panel;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblEvento;

	/**
	 * Create the frame.
	 */
	public FrmSwing_Video3() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 340);
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
				lblEvento.setText("HAS ELEGIDO LA OPCION: ACEPTAR");
			}
		});
		
		btnCancelar.addActionListener(this);
	}

	private void definirVentana() {
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 128, 0));
		btnAceptar.setBounds(50, 60, 205, 45);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnCancelar.setBackground(new Color(185, 0, 0));
		btnCancelar.setBounds(370, 60, 205, 45);
		panel.add(btnCancelar);
		
		lblEvento = new JLabel("");
		lblEvento.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEvento.setBounds(50, 150, 525, 45);
		panel.add(lblEvento);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lblEvento.setText("HAS ELEGIDO LA OPCION: CANCELAR");
	}

}
