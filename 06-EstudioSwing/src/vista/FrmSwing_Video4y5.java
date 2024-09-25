package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class FrmSwing_Video4y5 extends JFrame implements ActionListener{

	private JPanel panel;
	private JPanel panelColores;
	
	private JButton btnRojo;
	private JButton btnAmarillo;
	private JButton btnVerde;
	private JButton btnAzul;
	
	private JToggleButton tglbtnHabilitar;
	private JButton btnCentral;
	private JButton btnIzq;
	private JButton btnDer;
	
	private Icon gatoFeliz;
	private Icon gatoTriste;

	
	/**
	 * Create the frame.
	 */
	public FrmSwing_Video4y5() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		definirVentana();
		definirEventos();
		
		setVisible(true);
	}


	private void definirEventos() {
		btnRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColores.setBackground(new Color(255, 0, 0));
			}
		});
		
		btnAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColores.setBackground(new Color(255, 255, 0));
			}
		});
		
		btnVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColores.setBackground(new Color(0, 255, 64));
			}
		});
		
		btnAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelColores.setBackground(new Color(0, 0, 255));
			}
		});
		
		tglbtnHabilitar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tglbtnHabilitar.isSelected()) {
					tglbtnHabilitar.setText("Deshabilitado");
					boolean sw = false;
					habilitar(sw);
				}else {
					tglbtnHabilitar.setText("Habilitado");
					boolean sw = true;
					habilitar(sw);
				}
			}
		});
		
		btnIzq.addActionListener(this);
		btnDer.addActionListener(this);
	}


	private void definirVentana() {
		gatoFeliz = new ImageIcon("imagenes/feliz.png");
		gatoTriste = new ImageIcon("imagenes/triste.png");
		
		panelColores = new JPanel();
		panelColores.setBackground(new Color(0, 255, 64));
		panelColores.setBounds(190, 108, 389, 239);
		panel.add(panelColores);
		
		btnRojo = new JButton("Rojo");
		btnRojo.setBackground(new Color(255, 0, 0));
		btnRojo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRojo.setBounds(10, 47, 130, 42);
		panel.add(btnRojo);
		
		btnAmarillo = new JButton("Amarillo");
		btnAmarillo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAmarillo.setBackground(new Color(255, 255, 0));
		btnAmarillo.setBounds(630, 47, 130, 42);
		panel.add(btnAmarillo);
		
		btnVerde = new JButton("Verde");
		btnVerde.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnVerde.setBackground(new Color(0, 255, 64));
		btnVerde.setBounds(10, 363, 130, 42);
		panel.add(btnVerde);
		
		btnAzul = new JButton("Azul");
		btnAzul.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAzul.setBackground(new Color(0, 0, 255));
		btnAzul.setBounds(630, 363, 130, 42);
		panel.add(btnAzul);
		
		tglbtnHabilitar = new JToggleButton("Habilitado");
		tglbtnHabilitar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tglbtnHabilitar.setBounds(283, 47, 207, 42);
		panel.add(tglbtnHabilitar);
		
		btnCentral = new JButton("");
		btnCentral.setIcon(gatoFeliz);
		btnCentral.setBounds(311, 357, 148, 112);
		panel.add(btnCentral);
		
		btnIzq = new JButton("Habilitar");
		btnIzq.setForeground(new Color(255, 255, 255));
		btnIzq.setBackground(new Color(0, 64, 0));
		btnIzq.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnIzq.setBounds(150, 382, 157, 42);
		btnIzq.setActionCommand("enable");
		panel.add(btnIzq);
		
		btnDer = new JButton("Deshabilitar");
		btnDer.setForeground(Color.WHITE);
		btnDer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDer.setBackground(new Color(64, 0, 0));
		btnDer.setBounds(463, 382, 157, 42);
		btnDer.setActionCommand("disable");
		panel.add(btnDer);
	}
	
	private void habilitar(boolean sw) {
		btnRojo.setEnabled(sw);
		btnAmarillo.setEnabled(sw);
		btnVerde.setEnabled(sw);
		btnAzul.setEnabled(sw);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("enable")) {
			btnCentral.setIcon(gatoFeliz);
			btnCentral.setEnabled(true);
			btnIzq.setEnabled(false);
			btnDer.setEnabled(true);
		}else if(e.getActionCommand().equals("disable")){
			btnCentral.setIcon(gatoTriste);
			btnCentral.setEnabled(false);
			btnIzq.setEnabled(true);
			btnDer.setEnabled(true);
		}
	}
}
