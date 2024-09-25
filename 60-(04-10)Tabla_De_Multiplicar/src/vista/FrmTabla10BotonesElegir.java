package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class FrmTabla10BotonesElegir extends JFrame implements ActionListener{

	private JPanel panel;
	private JButton btnEleccion;
	private JLabel lblTitulo;
	private JLabel lblSubTitulo;
	
	private ArrayList<JLabel> listaEnunciado;
	private JLabel lblEn1;
	private JLabel lblEn2;
	private JLabel lblEn3;
	private JLabel lblEn4;
	private JLabel lblEn5;
	private JLabel lblEn6;
	private JLabel lblEn7;
	private JLabel lblEn8;
	private JLabel lblEn9;
	private JLabel lblEn10;
	
	private JButton btnCorregir;
	private JButton btnSolucionar;
	private JButton btnBorrar;
	
	private ArrayList<JFormattedTextField> listaSoluciones;
	private JFormattedTextField formattedTextSol1;
	private JFormattedTextField formattedTextSol2;
	private JFormattedTextField formattedTextSol3;
	private JFormattedTextField formattedTextSol4;
	private JFormattedTextField formattedTextSol5;
	private JFormattedTextField formattedTextSol6;
	private JFormattedTextField formattedTextSol7;
	private JFormattedTextField formattedTextSol8;
	private JFormattedTextField formattedTextSol9;
	private JFormattedTextField formattedTextSol10;
	
	private JLabel lblLineaCentral;
	private  int[] aleatorios;
	private String opcionElegida;

	public FrmTabla10BotonesElegir() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 550);
		panel = new JPanel();
		panel.setBackground(new Color(52, 52, 52));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		definirVentana();
		definirEventos();
		
		setVisible(true);
	}

	private void definirVentana() {
		int cx = 475, cy = 75;
		for(int x = 1; x <= 10; x++) {
			String nom = "" + x;
			btnEleccion = new JButton(nom);
			btnEleccion.setBounds(cx, cy, 75, 75);
			btnEleccion.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnEleccion.setBackground(new Color(80, 80, 80));
			btnEleccion.setForeground(new Color(255, 255, 255));
			btnEleccion.setActionCommand(nom);
			btnEleccion.addActionListener(this);
			panel.add(btnEleccion);
			cx += 75;
			if(x == 5) {
				cx = 475;
				cy += 75;
			}
		}
		
		lblTitulo = new JLabel("TABLAS DE MULTIPLICAR");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitulo.setBounds(244, 10, 408, 40);
		panel.add(lblTitulo);
		
		lblSubTitulo = new JLabel("TABLA DEL __");
		lblSubTitulo.setForeground(new Color(255, 255, 255));
		lblSubTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSubTitulo.setBounds(35, 60, 302, 20);
		panel.add(lblSubTitulo);
		
		listaEnunciado = new ArrayList<JLabel>();
		
		lblEn1 = new JLabel("__");
		lblEn1.setForeground(new Color(255, 255, 255));
		lblEn1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn1.setBounds(35, 101, 75, 20);
		listaEnunciado.add(lblEn1);
		panel.add(lblEn1);
		
		lblEn2 = new JLabel("__");
		lblEn2.setForeground(new Color(255, 255, 255));
		lblEn2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn2.setBounds(35, 141, 75, 20);
		listaEnunciado.add(lblEn2);
		panel.add(lblEn2);
		
		lblEn3 = new JLabel("__");
		lblEn3.setForeground(Color.WHITE);
		lblEn3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn3.setBounds(35, 181, 75, 20);
		listaEnunciado.add(lblEn3);
		panel.add(lblEn3);

		lblEn4 = new JLabel("__");
		lblEn4.setForeground(Color.WHITE);
		lblEn4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn4.setBounds(35, 221, 75, 20);
		listaEnunciado.add(lblEn4);
		panel.add(lblEn4);
		
		lblEn5 = new JLabel("__");
		lblEn5.setForeground(Color.WHITE);
		lblEn5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn5.setBounds(35, 261, 75, 20);
		listaEnunciado.add(lblEn5);
		panel.add(lblEn5);
		
		lblEn6 = new JLabel("__");
		lblEn6.setForeground(Color.WHITE);
		lblEn6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn6.setBounds(35, 301, 75, 20);
		listaEnunciado.add(lblEn6);
		panel.add(lblEn6);
		
		lblEn7 = new JLabel("__");
		lblEn7.setForeground(Color.WHITE);
		lblEn7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn7.setBounds(35, 341, 75, 20);
		listaEnunciado.add(lblEn7);
		panel.add(lblEn7);
		
		lblEn8 = new JLabel("__");
		lblEn8.setForeground(Color.WHITE);
		lblEn8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn8.setBounds(35, 381, 75, 20);
		listaEnunciado.add(lblEn8);
		panel.add(lblEn8);
		
		lblEn9 = new JLabel("__");
		lblEn9.setForeground(Color.WHITE);
		lblEn9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn9.setBounds(35, 421, 75, 20);
		listaEnunciado.add(lblEn9);
		panel.add(lblEn9);
		
		lblEn10 = new JLabel("__");
		lblEn10.setForeground(Color.WHITE);
		lblEn10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEn10.setBounds(35, 461, 75, 20);
		listaEnunciado.add(lblEn10);
		panel.add(lblEn10);
	
		btnCorregir = new JButton("Corregir");
		btnCorregir.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCorregir.setBackground(new Color(0, 128, 0));
		btnCorregir.setBounds(475, 330, 150, 40);
		panel.add(btnCorregir);
		
		btnSolucionar = new JButton("Solucionar");
		btnSolucionar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSolucionar.setBackground(new Color(0, 128, 0));
		btnSolucionar.setBounds(475, 381, 150, 40);
		panel.add(btnSolucionar);
		
		lblLineaCentral = new JLabel("|");
		lblLineaCentral.setBackground(new Color(255, 255, 255));
		lblLineaCentral.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineaCentral.setFont(new Font("Times New Roman", Font.PLAIN, 300));
		lblLineaCentral.setForeground(new Color(255, 255, 255));
		lblLineaCentral.setBounds(233, 93, 75, 336);
		panel.add(lblLineaCentral);
		
		listaSoluciones = new ArrayList<JFormattedTextField>();
		
		formattedTextSol1 = new JFormattedTextField();
		formattedTextSol1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol1.setBounds(88, 101, 75, 20);
		panel.add(formattedTextSol1);
		listaSoluciones.add(formattedTextSol1);
		
		formattedTextSol2 = new JFormattedTextField();
		formattedTextSol2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol2.setBounds(88, 141, 75, 20);
		panel.add(formattedTextSol2);
		listaSoluciones.add(formattedTextSol2);
		
		formattedTextSol3 = new JFormattedTextField();
		formattedTextSol3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol3.setBounds(88, 181, 75, 20);
		panel.add(formattedTextSol3);
		listaSoluciones.add(formattedTextSol3);
		
		formattedTextSol4 = new JFormattedTextField();
		formattedTextSol4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol4.setBounds(88, 221, 75, 20);
		panel.add(formattedTextSol4);
		listaSoluciones.add(formattedTextSol4);
		
		formattedTextSol5 = new JFormattedTextField();
		formattedTextSol5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol5.setBounds(88, 261, 75, 20);
		panel.add(formattedTextSol5);
		listaSoluciones.add(formattedTextSol5);
		
		formattedTextSol6 = new JFormattedTextField();
		formattedTextSol6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol6.setBounds(88, 301, 75, 20);
		panel.add(formattedTextSol6);
		listaSoluciones.add(formattedTextSol6);
		
		formattedTextSol7 = new JFormattedTextField();
		formattedTextSol7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol7.setBounds(88, 341, 75, 20);
		panel.add(formattedTextSol7);
		listaSoluciones.add(formattedTextSol7);
		
		formattedTextSol8 = new JFormattedTextField();
		formattedTextSol8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol8.setBounds(88, 381, 75, 20);
		panel.add(formattedTextSol8);
		listaSoluciones.add(formattedTextSol8);
		
		formattedTextSol9 = new JFormattedTextField();
		formattedTextSol9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol9.setBounds(88, 421, 75, 20);
		panel.add(formattedTextSol9);
		listaSoluciones.add(formattedTextSol9);
		
		formattedTextSol10 = new JFormattedTextField();
		formattedTextSol10.setFont(new Font("Times New Roman", Font.BOLD, 15));
		formattedTextSol10.setBounds(88, 461, 75, 20);
		panel.add(formattedTextSol10);
		listaSoluciones.add(formattedTextSol10);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBorrar.setBackground(new Color(128, 0, 0));
		btnBorrar.setBounds(475, 431, 150, 40);
		panel.add(btnBorrar);
	}
	
	private void pintarTabla(String tablaElegida) {
		lblSubTitulo.setText("TABLA DEL " + tablaElegida);
		aleatorios = generarAleatoriosSinRepeticion(10, 1, 10);
		for(int x = 0; x < 10; x++) {
			listaEnunciado.get(x).setText(tablaElegida + "x" + aleatorios[x] + " = ");;
			listaSoluciones.get(x).setBackground(new Color(255, 255, 255));
			listaSoluciones.get(x).setText("");
			listaSoluciones.get(x).setEditable(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnElegido = (JButton) e.getSource();
		opcionElegida = btnElegido.getActionCommand();
		pintarTabla(opcionElegida);
	}
	
	public static int[] generarAleatoriosSinRepeticion(int cant, int menor, int mayor) {
		int[] aleatorios = new int[cant];
		for(int x = 0; x < cant; x++) {
			aleatorios[x] = mayor + 1;
		}
		
		int x = 0;
		while(x < cant) {
			int ale = (int) Math.floor(Math.random()* (mayor - menor + 1) + menor);
			boolean encontrado = false;
			for(int y = 0; y < cant; y++) {
				if(ale == aleatorios[y]) {
					encontrado = true;
				}
			}
			if(!encontrado) {
				aleatorios[x] = ale;
				x++;
			}
		}
		return aleatorios;
	}
	
	private void definirEventos() {
		btnCorregir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int x = 0; x < 10; x++) {
					boolean esCorrecto = true;
					try {
						int solucion = Integer.parseInt(listaSoluciones.get(x).getText());
						int correcto = aleatorios[x] * (Integer.parseInt(opcionElegida));
						if(correcto != solucion) {
							esCorrecto = false;
						}
					} catch (Exception e2) {
						esCorrecto = false;
					}
					
					if(esCorrecto) {
						listaSoluciones.get(x).setBackground(new Color(0, 180, 0));
					}else {
						listaSoluciones.get(x).setBackground(new Color(180, 0, 0));
					}
				}
			}
		});
		
		btnSolucionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int x = 0; x < 10; x++) {
					int resultado = aleatorios[x] * (Integer.parseInt(opcionElegida));
					listaSoluciones.get(x).setText("" + resultado);
					listaSoluciones.get(x).setEditable(false);
					listaSoluciones.get(x).setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int x = 0; x < 10; x++) {
					int resultado = aleatorios[x] * (Integer.parseInt(opcionElegida));
					listaSoluciones.get(x).setText("");
					listaSoluciones.get(x).setEditable(true);
					listaSoluciones.get(x).setBackground(new Color(255, 255, 255));
				}
			}
		});
	}
}
