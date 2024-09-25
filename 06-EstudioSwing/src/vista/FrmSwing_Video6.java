package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;

public class FrmSwing_Video6 extends JFrame {

	private JPanel panel;
	private JTextField textImporte;
	private JTextField textIva;
	private JTextField textTotal;
	private JButton btnCalcular;
	private JLabel lblInformacion;
	private JLabel lblPropiedades;
	private double importe;
	private JLabel lblDniFormateo;
	JFormattedTextField formattedDni;
	

	public FrmSwing_Video6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 260);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		definirVentana();
		definirEventos();
		
		setVisible(true);
	}


	private void definirEventos() {
		textImporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInformacion.setText(e.getActionCommand());
				try {
					importe = Double.parseDouble(e.getActionCommand());
					textImporte.setBackground(new Color(255, 255, 255));
					textIva.requestFocus();
				} catch (Exception e2) {
					lblInformacion.setText("Introduce un valor correcto");
					textImporte.setText("");
				}
			}
		});
		
		textIva.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				lblPropiedades.setText("Caracter: " + e.getKeyChar() + " | Codigo: " + e.getKeyCode());
			}
			
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != 46)) {
					e.consume();
				}
				
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblInformacion.setText("");
				double importe, iva, total;
				try {
					importe = Double.parseDouble(textImporte.getText());
					textImporte.setBackground(new Color(255, 255, 255));
					iva = Double.parseDouble(textIva.getText());
					total = importe + ((importe * iva)/100);
					textTotal.setText(Double.toString(total));
				} catch (Exception e2) {
					for(int x = 0; x < textImporte.getText().length(); x++) {
						char c = textImporte.getText().charAt(x);
						if(!Character.isDigit(c)) {
							textImporte.setBackground(new Color(255, 0, 0));
						}
					}
			
					lblInformacion.setText("Introduzca un valor correcto");
				}
			}
		});
	}


	private void definirVentana() {
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblImporte.setBounds(25, 52, 106, 24);
		panel.add(lblImporte);
		
		JLabel lblIva = new JLabel("Iva:");
		lblIva.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblIva.setBounds(25, 86, 106, 24);
		panel.add(lblIva);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTotal.setBounds(25, 120, 106, 24);
		panel.add(lblTotal);
		
		textImporte = new JTextField();
		textImporte.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textImporte.setHorizontalAlignment(SwingConstants.RIGHT);
		textImporte.setBounds(131, 52, 106, 27);
		panel.add(textImporte);
		textImporte.setColumns(10);
		
		textIva = new JTextField();
		textIva.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textIva.setHorizontalAlignment(SwingConstants.RIGHT);
		textIva.setColumns(10);
		textIva.setBounds(131, 86, 106, 27);
		panel.add(textIva);
		
		textTotal = new JTextField();
		textTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		textTotal.setEditable(false);
		textTotal.setColumns(10);
		textTotal.setBounds(131, 120, 106, 27);
		panel.add(textTotal);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCalcular.setBounds(70, 167, 111, 27);
		panel.add(btnCalcular);
		
		lblInformacion = new JLabel("***************");
		lblInformacion.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblInformacion.setBounds(249, 52, 314, 24);
		panel.add(lblInformacion);
		
		lblPropiedades = new JLabel("Evento de teclado");
		lblPropiedades.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPropiedades.setBounds(247, 86, 314, 24);
		panel.add(lblPropiedades);
		
		lblDniFormateo = new JLabel("DNI:");
		lblDniFormateo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDniFormateo.setBounds(331, 185, 54, 28);
		panel.add(lblDniFormateo);
		
		MaskFormatter maskDni;
		try {
			maskDni = new MaskFormatter("##.###.###-?");
			formattedDni = new JFormattedTextField(maskDni);
			formattedDni.setFont(new Font("Times New Roman", Font.BOLD, 20));
			formattedDni.setBounds(383, 185, 142, 28);
			panel.add(formattedDni);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
