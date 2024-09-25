package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BibliotecaController;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMostrarLibros extends JFrame {

	//EMBELLECEDORES
		private ImageIcon fondoPanel;
		private JLabel lblfotoDerecha;
		private JTextArea lineaHorizontal;
		private JTextArea lineaVertical;
		
		private ImageIcon primero;
		private ImageIcon anterior;
		private ImageIcon siguiente;
		private ImageIcon ultimo;
		
	private JPanel panel;
	private JLabel lblTituloPanel;
	
	private JLabel lblId;
	private JTextField textId;
	private JLabel lblTitulo;
	private JLabel lblEditorial;
	private JLabel lblIsbn;
	private JLabel lblFecha;
	private JTextField textTitulo;
	private JTextField textEditorial;
	private JTextField textIsbn;
	private JTextField textFecha;
	private JCheckBox chckbxPrestado;
	
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JLabel lblPrestado;
	
	private List<Libro> listaLibros;
	private BibliotecaController biblio;
	private int index;
	private JLabel lblAutor;
	private JTextField textAutor;
	

	public FrmMostrarLibros() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1000, 600);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);
		
		definirVentana();
		definirEventos();
		
		setVisible(true);
	}

	private void definirEventos() {
		listaLibros = new ArrayList<Libro>();
		index = 0;
		
		try {
			biblio = new BibliotecaController();
			listaLibros = biblio.getBiblioteca();
			textId.setText(listaLibros.get(index).getId());
			textTitulo.setText(listaLibros.get(index).getTitulo());
			textAutor.setText(listaLibros.get(index).getAutor());
			textEditorial.setText(listaLibros.get(index).getEditorial());
			textIsbn.setText(listaLibros.get(index).getIsbn());
			try {
				textFecha.setText(listaLibros.get(index).getFechaDevolucion().toString());
			} catch (Exception e2) {
				textFecha.setText("");
			}
			if(listaLibros.get(index).isPrestado()) {
				chckbxPrestado.setSelected(true);
			}else {
				chckbxPrestado.setSelected(false);
			}
		} catch (NumberFormatException | DateTimeParseException | IOException | IsbnException | CamposVaciosException e) {
			
		}
		
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = 0;
				textId.setText(listaLibros.get(index).getId());
				textTitulo.setText(listaLibros.get(index).getTitulo());
				textAutor.setText(listaLibros.get(index).getAutor());
				textEditorial.setText(listaLibros.get(index).getEditorial());
				textIsbn.setText(listaLibros.get(index).getIsbn());
				try {
					textFecha.setText(listaLibros.get(index).getFechaDevolucion().toString());
				} catch (Exception e2) {
					textFecha.setText("");
				}
				if(listaLibros.get(index).isPrestado()) {
					chckbxPrestado.setSelected(true);
				}else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index -= 1;
				if(index < 0) {
					index = 0;
				}
				textId.setText(listaLibros.get(index).getId());
				textTitulo.setText(listaLibros.get(index).getTitulo());
				textAutor.setText(listaLibros.get(index).getAutor());
				textEditorial.setText(listaLibros.get(index).getEditorial());
				textIsbn.setText(listaLibros.get(index).getIsbn());
				try {
					textFecha.setText(listaLibros.get(index).getFechaDevolucion().toString());
				} catch (Exception e2) {
					textFecha.setText("");
				}
				if(listaLibros.get(index).isPrestado()) {
					chckbxPrestado.setSelected(true);
				}else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index += 1;
				if(index >= listaLibros.size()) {
					index = listaLibros.size() - 1;
				}
				textId.setText(listaLibros.get(index).getId());
				textTitulo.setText(listaLibros.get(index).getTitulo());
				textAutor.setText(listaLibros.get(index).getAutor());
				textEditorial.setText(listaLibros.get(index).getEditorial());
				textIsbn.setText(listaLibros.get(index).getIsbn());
				try {
					textFecha.setText(listaLibros.get(index).getFechaDevolucion().toString());
				} catch (Exception e2) {
					textFecha.setText("");
				}
				if(listaLibros.get(index).isPrestado()) {
					chckbxPrestado.setSelected(true);
				}else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = listaLibros.size() - 1;
				textId.setText(listaLibros.get(index).getId());
				textTitulo.setText(listaLibros.get(index).getTitulo());
				textAutor.setText(listaLibros.get(index).getAutor());
				textEditorial.setText(listaLibros.get(index).getEditorial());
				textIsbn.setText(listaLibros.get(index).getIsbn());
				try {
					textFecha.setText(listaLibros.get(index).getFechaDevolucion().toString());
				} catch (Exception e2) {
					textFecha.setText("");
				}
				if(listaLibros.get(index).isPrestado()) {
					chckbxPrestado.setSelected(true);
				}else {
					chckbxPrestado.setSelected(false);
				}
			}
		});
		
	}

	private void definirVentana() {
		// TODO Auto-generated method stub
		fondoPanel = new ImageIcon("imagenes/fotoDerecha.jpg");
		primero = new ImageIcon("imagenes/primero.png");
		anterior = new ImageIcon("imagenes/atras.png");
		siguiente = new ImageIcon("imagenes/adelante.png");
		ultimo = new ImageIcon("imagenes/ultimo.png");
		
		lineaVertical = new JTextArea();
		lineaVertical.setEditable(false);
		lineaVertical.setBackground(new Color(59, 16, 125));
		lineaVertical.setBounds(798, 63, 2, 500);
		panel.add(lineaVertical);
		
		lineaHorizontal = new JTextArea();
		lineaHorizontal.setEditable(false);
		lineaHorizontal.setBackground(new Color(59, 16, 125));
		lineaHorizontal.setBounds(0, 63, 800, 2);
		panel.add(lineaHorizontal);
		
		lblfotoDerecha = new JLabel("");
		lblfotoDerecha.setBackground(new Color(128, 128, 255));
		lblfotoDerecha.setBounds(786, 0, 200, 563);
		lblfotoDerecha.setIcon(fondoPanel);
		panel.add(lblfotoDerecha);
		
		lblTituloPanel = new JLabel("Biblioteca");
		lblTituloPanel.setForeground(new Color(59, 16, 125));
		lblTituloPanel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTituloPanel.setBounds(22, 17, 192, 36);
		panel.add(lblTituloPanel);
		
		lblId = new JLabel("ID:");
		lblId.setForeground(new Color(59, 16, 125));
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(22, 109, 90, 20);
		panel.add(lblId);
		
		textId = new JTextField();
		textId.setForeground(new Color(59, 16, 125));
		textId.setBackground(new Color(231, 219, 255));
		textId.setEditable(false);
		textId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textId.setBounds(118, 109, 96, 20);
		panel.add(textId);
		textId.setColumns(10);
		
		lblTitulo = new JLabel("Titulo:");
		lblTitulo.setForeground(new Color(59, 16, 125));
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTitulo.setBounds(22, 139, 90, 20);
		panel.add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setForeground(new Color(59, 16, 125));
		textTitulo.setBackground(new Color(231, 219, 255));
		textTitulo.setEditable(false);
		textTitulo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textTitulo.setColumns(10);
		textTitulo.setBounds(118, 139, 294, 20);
		panel.add(textTitulo);
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setForeground(new Color(59, 16, 125));
		lblAutor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAutor.setBounds(22, 169, 90, 20);
		panel.add(lblAutor);
		
		textAutor = new JTextField();
		textAutor.setForeground(new Color(59, 16, 125));
		textAutor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textAutor.setEditable(false);
		textAutor.setColumns(10);
		textAutor.setBackground(new Color(231, 219, 255));
		textAutor.setBounds(118, 169, 294, 20);
		panel.add(textAutor);
		
		lblEditorial = new JLabel("Editorial:");
		lblEditorial.setForeground(new Color(59, 16, 125));
		lblEditorial.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEditorial.setBounds(22, 199, 90, 20);
		panel.add(lblEditorial);
		
		textEditorial = new JTextField();
		textEditorial.setForeground(new Color(59, 16, 125));
		textEditorial.setBackground(new Color(231, 219, 255));
		textEditorial.setEditable(false);
		textEditorial.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textEditorial.setColumns(10);
		textEditorial.setBounds(118, 199, 294, 20);
		panel.add(textEditorial);
		
		lblIsbn = new JLabel("ISBN:");
		lblIsbn.setForeground(new Color(59, 16, 125));
		lblIsbn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblIsbn.setBounds(22, 229, 90, 20);
		panel.add(lblIsbn);
		
		textIsbn = new JTextField();
		textIsbn.setForeground(new Color(59, 16, 125));
		textIsbn.setBackground(new Color(231, 219, 255));
		textIsbn.setEditable(false);
		textIsbn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textIsbn.setColumns(10);
		textIsbn.setBounds(118, 229, 257, 20);
		panel.add(textIsbn);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(new Color(59, 16, 125));
		lblFecha.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFecha.setBounds(22, 259, 90, 20);
		panel.add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setForeground(new Color(59, 16, 125));
		textFecha.setBackground(new Color(231, 219, 255));
		textFecha.setEditable(false);
		textFecha.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textFecha.setColumns(10);
		textFecha.setBounds(118, 259, 119, 20);
		panel.add(textFecha);
		
		lblPrestado = new JLabel("Prestado");
		lblPrestado.setForeground(new Color(59, 16, 125));
		lblPrestado.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPrestado.setBounds(47, 290, 90, 20);
		panel.add(lblPrestado);
		
		chckbxPrestado = new JCheckBox("");
		chckbxPrestado.setEnabled(false);
		chckbxPrestado.setBackground(new Color(255, 255, 255));
		chckbxPrestado.setForeground(new Color(59, 16, 125));
		chckbxPrestado.setFont(new Font("Times New Roman", Font.BOLD, 20));
		chckbxPrestado.setBounds(22, 289, 21, 21);
		panel.add(chckbxPrestado);
		
		btnPrimero = new JButton("");
		btnPrimero.setBackground(new Color(255, 255, 255));
		btnPrimero.setBounds(25, 332, 60, 60);
		btnPrimero.setIcon(primero);
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("");
		btnAnterior.setBackground(Color.WHITE);
		btnAnterior.setBounds(121, 332, 60, 60);
		btnAnterior.setIcon(anterior);
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.setBackground(Color.WHITE);
		btnSiguiente.setBounds(223, 332, 60, 60);
		btnSiguiente.setIcon(siguiente);
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton("");
		btnUltimo.setBackground(Color.WHITE);
		btnUltimo.setBounds(318, 332, 60, 60);
		btnUltimo.setIcon(ultimo);
		panel.add(btnUltimo);
		
		
	}
}
