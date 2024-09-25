package vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Curriculum extends JFrame {

	private JPanel panel;
	private JTextArea textArea;
	private JLabel lblTitulo;
	private JLabel lblSakura;
	private JTextArea textAreaDatos;
	
	private ImageIcon sakura;
	private ImageIcon sakuraVolteada;
	private JLabel lblSakuraVolteada;

	public Curriculum(String frase) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(275, 10, 1000, 708);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(200, 227, 255));

		setContentPane(panel);
		panel.setLayout(null);
		
		lblTitulo = new JLabel("Currículum Vitae");
		lblTitulo.setForeground(new Color(0, 107, 215));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 32, 986, 30);
		panel.add(lblTitulo);
		
		sakura = new ImageIcon("img/sakura.png");
		sakuraVolteada = new ImageIcon("img/sakuraVolteada.png");
		
		
		lblSakura = new JLabel("");
		lblSakura.setBounds(686, 0, 300, 300);
		lblSakura.setIcon(sakura);
		panel.add(lblSakura);
	
		lblSakuraVolteada = new JLabel("");
		lblSakuraVolteada.setBounds(0, 367, 300, 300);
		lblSakuraVolteada.setIcon(sakuraVolteada);
		panel.add(lblSakuraVolteada);
		
		textAreaDatos = new JTextArea();
		textAreaDatos.setForeground(new Color(0, 107, 215));
		textAreaDatos.setFont(new Font("Tahoma", Font.BOLD, 15));
		textAreaDatos.setEditable(false);
		textAreaDatos.setText(frase);
		textAreaDatos.setBounds(285, 72, 410, 533);
		textAreaDatos.setBackground(new Color(157, 206, 255));
		panel.add(textAreaDatos);
		
		setVisible(true);
	}
}
