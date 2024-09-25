package vista;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FrmListas_Video1 extends JFrame {

	private JPanel contentPane;
	private JPanel panelLista;
	private JScrollPane scrollPaneLista;
	private JList listPoblacion;
	private ImageIcon imagen;
	private DefaultListModel modelo;

	public FrmListas_Video1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		definirLista();
		definirEventos();
		
		setVisible(true);
	}
	
	private void definirLista() {
		panelLista = new JPanel();
		panelLista.setBounds(27, 24, 213, 237);
		contentPane.add(panelLista);
		panelLista.setLayout(new BorderLayout(0, 0));
		
		scrollPaneLista = new JScrollPane();
		panelLista.add(scrollPaneLista, BorderLayout.CENTER);
		
		modelo = new DefaultListModel();
		listPoblacion = new JList();
		scrollPaneLista.setViewportView(listPoblacion);
	}
	
	private void definirEventos() {
		
	}
}
