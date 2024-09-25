package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import controller.LibroController;
import excepciones.CamposVaciosException;
import excepciones.IsbnException;
import modelo.Libro;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class frmLibros2 extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextField textIdLibros, textTitulo, textAutor, textEditorial,textFechaPrestamo;
	JCheckBox chckbxPrestado;
	private JButton btnPrimero, btnAtras, btnAdelante, btnUltimo;
	private JButton btnNuevo, btnEditar, btnGuardar, btnDeshacer, btnBorrar;
	private JPanel panelMantenimiento;
	private JPanel panelGrid;
	private JScrollPane scrollPane;
	private JTable tblLibros;	
	DefaultTableModel dtm;
	private JTextField textIsbn;
	private JFrame frame;
	JComboBox comboCampo;
	private JTextField textFiltrar;
	JButton btnFiltrar;
	JLabel lblConsulta;	

	private int puntero;
	private boolean nuevoRegistro=false;
	private ResultSet rs;
	
	private String opcionElegida;
	private String accion;
	private JLabel lblError;
	
	private LibroController libroController;
	private List<Libro> libros;
	private int index;
	
	
	public frmLibros2() throws SQLException, CamposVaciosException, IsbnException {
		libroController = new LibroController();
		setTitle("F O R M U L A R I O   D E   M A N T E N I M I E N T O");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 476);
		puntero=0;
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		definirVentana();	
		mostrarLibroActivo();
		definirEventos();
		frame=this;
		this.setVisible(true);
		index = 0;
	}

	private void definirEventos() {
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = 0;
				mostrarLibroActivo();
			}
		});
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index += 1;
				mostrarLibroActivo();
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index -= 1;
				mostrarLibroActivo();
			}
		});
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = libros.size() - 1;
				mostrarLibroActivo();
			}
		});
		
		 btnFiltrar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		String[] titulos = {"idLibros", "titulo", "autor",  "editorial",  "isbn",  "fechaPrestamo",  "prestado"};
			 		dtm.setColumnCount(0);
			 		dtm.setRowCount(0);
			 		dtm.setColumnIdentifiers(titulos);
			 		try {
			 			String sql = "SELECT * FROM libros WHERE " + comboCampo.getSelectedItem() + " = '" + textFiltrar.getText() +"'";
						libros = libroController.getLibros(sql);
						for(Libro lib: libros) {
							String[] libro = {lib.getIdLibro() + "", lib.getTitulo(), lib.getAutor(), lib.getEditorial(), lib.getIsbn(), lib.getFechaPrestamo().toString(), lib.isPrestado() + ""};
							dtm.addRow(libro);
						}
					} catch (SQLException | CamposVaciosException | IsbnException e1) {
						
					}
			 		
			 	}
		});
			
	}

	//E V E N T O S
	private void mostrarLibroActivo() {		
		libros = new ArrayList<Libro>();
			try {
				libros = libroController.getLibros("SELECT * FROM libros");
				if(libros.size() == 0) {
					textIdLibros.setText("");
					textTitulo.setText("");
					textAutor.setText("");
					textEditorial.setText("");
					textIsbn.setText("");
					textFechaPrestamo.setText("");
					chckbxPrestado.setSelected(false);
				}else {
					if(index < 0) {
						index = 0;
					}
					if(index > libros.size() - 1) {
						index = libros.size() - 1;
					}
					textIdLibros.setText("" + libros.get(index).getIdLibro());
					textTitulo.setText(libros.get(index).getTitulo());
					textAutor.setText(libros.get(index).getAutor());
					textEditorial.setText(libros.get(index).getEditorial());
					textIsbn.setText(libros.get(index).getIsbn());
					
					if(libros.get(index).isPrestado()) {
						chckbxPrestado.setSelected(true);
					}else {
						chckbxPrestado.setSelected(false);
					}
				}
				try {
					textFechaPrestamo.setText(libros.get(index).getFechaPrestamo().toString());
				} catch (Exception e2) {
					textFechaPrestamo.setText("");
				}
				
			} catch (SQLException| NumberFormatException | DateTimeParseException| IsbnException | CamposVaciosException e) {
	
			}
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btnElegido = (JButton) e.getSource();
		opcionElegida = btnElegido.getActionCommand();
		if(opcionElegida.equals("N") || opcionElegida.equals("E") || opcionElegida.equals("B")) {
			lblError.setText("");
			habilitarPanelMantenimiento(false);
			habilitarNavegador(false);
			if(opcionElegida.equals("N")) {
				habilitarPanelAgregarLibros(true);
				vaciarPanelLibros(true);
				accion = "N";
			}else if(opcionElegida.equals("E")) {
				habilitarPanelModificarLibros(true);
				accion = "E";
			}else {
				accion = "B";
			}
		}else if(opcionElegida.equals("G") || opcionElegida.equals("D")){
			habilitarPanelMantenimiento(true);
			habilitarNavegador(true);
			if(opcionElegida.equals("G")) {
				if(accion.equals("N")) {
					String titulo = textTitulo.getText();
					String autor = textAutor.getText();
					String editorial = textEditorial.getText();
					String isbn = textIsbn.getText();
					try {
						if(!libroController.agregarLibro(titulo, autor, editorial, isbn)) {
							lblError.setText("El libro ya existe");
						}
					} catch (CamposVaciosException | IsbnException | SQLException e1) {
						lblError.setText(e1.getMessage());
					}
				}else if(accion.equals("E")) {
					String isbn = textIsbn.getText();
					boolean prestado = chckbxPrestado.isSelected();
					try {
						libroController.modificarLibro(isbn, prestado);
					} catch (SQLException e1) {
						lblError.setText(e1.getMessage());
					}
				}else if(accion.equals("B")){
					String campo = "isbn";
					String valor = textIsbn.getText();
					try {
						if(!libroController.borrarLibro(campo, valor)) {
							lblError.setText("El libro no existe o ya ha sido borrado");
						}
					} catch (CamposVaciosException | IsbnException | SQLException e1) {
						lblError.setText(e1.getMessage());
					}
				}
				habilitarPanelAgregarLibros(false);
				habilitarPanelModificarLibros(false);
				mostrarLibroActivo();
			}else {
				habilitarPanelAgregarLibros(false);
				habilitarPanelModificarLibros(false);
				mostrarLibroActivo();
			}
		}
	}

	// D E F I N I R   V E N T A N A
private void definirVentana() {
	// TODO Ap�ndice de m�todo generado autom�ticamente
	JPanel panelLibros = new JPanel();
	panelLibros.setLayout(null);
	panelLibros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Libros", TitledBorder.LEADING,
			TitledBorder.TOP, null, Color.BLUE));
	panelLibros.setBounds(28, 118, 298, 227);
	panel.add(panelLibros);

	textIdLibros = new JTextField();
	textIdLibros.setEditable(false);
	textIdLibros.setColumns(10);
	textIdLibros.setBounds(82, 29, 40, 20);
	panelLibros.add(textIdLibros);

	JLabel label_IdLibros = new JLabel("IdLibros");
	label_IdLibros.setFont(new Font("Tahoma", Font.BOLD, 11));
	label_IdLibros.setBounds(26, 32, 46, 14);
	panelLibros.add(label_IdLibros);

	JLabel label_Titulo = new JLabel("Titulo");
	label_Titulo.setFont(new Font("Tahoma", Font.BOLD, 11));
	label_Titulo.setBounds(26, 60, 46, 14);
	panelLibros.add(label_Titulo);

	textTitulo = new JTextField();
	textTitulo.setEditable(false);
	textTitulo.setColumns(10);
	textTitulo.setBounds(82, 57, 186, 20);
	panelLibros.add(textTitulo);

	JLabel label_Autor = new JLabel("Autor");
	label_Autor.setFont(new Font("Tahoma", Font.BOLD, 11));
	label_Autor.setBounds(26, 91, 46, 14);
	panelLibros.add(label_Autor);

	textAutor = new JTextField();
	textAutor.setEditable(false);
	textAutor.setColumns(10);
	textAutor.setBounds(82, 88, 186, 20);
	panelLibros.add(textAutor);

	JLabel label_Editorial = new JLabel("Editorial");
	label_Editorial.setFont(new Font("Tahoma", Font.BOLD, 11));
	label_Editorial.setBounds(26, 121, 46, 14);
	panelLibros.add(label_Editorial);

	textEditorial = new JTextField();
	textEditorial.setEditable(false);
	textEditorial.setColumns(10);
	textEditorial.setBounds(82, 119, 186, 20);
	panelLibros.add(textEditorial);
	
	JLabel lblFecha = new JLabel("Fecha :");
	lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblFecha.setBounds(26, 173, 46, 14);
	panelLibros.add(lblFecha);
	
	textFechaPrestamo = new JTextField();
	textFechaPrestamo.setBounds(82, 170, 105, 20);
	textFechaPrestamo.setEditable(false);
	panelLibros.add(textFechaPrestamo);
	textFechaPrestamo.setColumns(10);
	
	chckbxPrestado = new JCheckBox("Prestado");
	chckbxPrestado.setFont(new Font("Tahoma", Font.BOLD, 11));
	chckbxPrestado.setBounds(25, 197, 97, 23);
	chckbxPrestado.setEnabled(false);
	panelLibros.add(chckbxPrestado);
	
	JLabel lblIsbn = new JLabel("Isbn");
	lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblIsbn.setBounds(26, 146, 46, 14);
	panelLibros.add(lblIsbn);
	
	textIsbn = new JTextField();
	textIsbn.setEditable(false);
	textIsbn.setBounds(82, 143, 186, 20);
	panelLibros.add(textIsbn);
	textIsbn.setColumns(10);
	
	JLabel lblAaammdd = new JLabel("aaaa-MM-dd");
	lblAaammdd.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblAaammdd.setBounds(190, 173, 78, 14);
	panelLibros.add(lblAaammdd);
	

	JPanel panelNavegador = new JPanel();
	panelNavegador.setLayout(null);
	panelNavegador.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Navegador", TitledBorder.LEADING,
			TitledBorder.TOP, null, Color.BLUE));
	panelNavegador.setBounds(28, 356, 218, 74);
	panel.add(panelNavegador);

	// NAVEGADOR
	ImageIcon imaNav = new ImageIcon("imagenes/navPri.jpg");
	btnPrimero = new JButton("", imaNav);
	btnPrimero.setBounds(15, 15, 40, 40);
	panelNavegador.add(btnPrimero);
	imaNav = new ImageIcon("imagenes/navIzq.jpg");
	btnAtras = new JButton("", imaNav);

	btnAtras.setBounds(65, 15, 40, 40);
	panelNavegador.add(btnAtras);
	imaNav = new ImageIcon("imagenes/navDer.jpg");
	btnAdelante = new JButton("", imaNav);
	
	btnAdelante.setBounds(115, 15, 40, 40);
	panelNavegador.add(btnAdelante);
	imaNav = new ImageIcon("imagenes/navUlt.jpg");
	btnUltimo = new JButton("", imaNav);

	btnUltimo.setBounds(165, 15, 40, 40);
	panelNavegador.add(btnUltimo);
	
	panelMantenimiento = new JPanel();
	panelMantenimiento.setLayout(null);
	panelMantenimiento.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Mantenimiento Libros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
	panelMantenimiento.setBounds(28, 21, 266, 74);
	panel.add(panelMantenimiento);
	
	imaNav = new ImageIcon("imagenes/botonAgregar.jpg");
	imaNav = new ImageIcon(imaNav.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
	btnNuevo = new JButton("", imaNav);
	btnNuevo.setToolTipText("Insertar Nuevo Libro");
	btnNuevo.setBounds(15, 15, 40, 40);
	panelMantenimiento.add(btnNuevo);
	btnNuevo.addActionListener(this);
	btnNuevo.setActionCommand("N");
	
	imaNav = new ImageIcon("imagenes/botonEditar.jpg");
	imaNav = new ImageIcon(imaNav.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
	btnEditar = new JButton("", imaNav);
	btnEditar.setToolTipText("Editar");
	btnEditar.setBounds(65, 15, 40, 40);
	panelMantenimiento.add(btnEditar);
	btnEditar.addActionListener(this);
	btnEditar.setActionCommand("E");
	
	imaNav = new ImageIcon("imagenes/botonGuardar.jpg");
	imaNav = new ImageIcon(imaNav.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
	btnGuardar = new JButton("", imaNav);
	btnGuardar.setEnabled(false);
	btnGuardar.setToolTipText("Guardar");
	btnGuardar.setBounds(166, 15, 40, 40);
	panelMantenimiento.add(btnGuardar);
	btnGuardar.addActionListener(this);
	btnGuardar.setActionCommand("G");
	
	imaNav = new ImageIcon("imagenes/botonDeshacer.jpg");
	imaNav = new ImageIcon(imaNav.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
	btnDeshacer = new JButton("", imaNav);
	btnDeshacer.setEnabled(false);
	btnDeshacer.setToolTipText("Deshacer");
	btnDeshacer.setBounds(216, 15, 40, 40);
	panelMantenimiento.add(btnDeshacer);
	btnDeshacer.addActionListener(this);
	btnDeshacer.setActionCommand("D");
	
	imaNav = new ImageIcon("imagenes/borrar.jpg");
	imaNav = new ImageIcon(imaNav.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_DEFAULT));
	btnBorrar = new JButton("", imaNav);
	btnBorrar.setToolTipText("Borrar Registro");
	btnBorrar.setBounds(116, 15, 40, 40);
	panelMantenimiento.add(btnBorrar);
	btnBorrar.addActionListener(this);
	btnBorrar.setActionCommand("B");
	
	panelGrid = new JPanel();
	panelGrid.setBounds(363, 98, 766, 305);
	panel.add(panelGrid);
	panelGrid.setLayout(new BorderLayout(0, 0));
	
	scrollPane = new JScrollPane();
	panelGrid.add(scrollPane, BorderLayout.CENTER);
	dtm=new DefaultTableModel();
	tblLibros = new JTable(dtm);

	
	scrollPane.setViewportView(tblLibros);
	
	comboCampo = new JComboBox();
	comboCampo.setModel(new DefaultComboBoxModel(new String[] {"titulo", "autor", "editorial"}));
	comboCampo.setBounds(396, 52, 68, 20);
	panel.add(comboCampo);
	
	textFiltrar = new JTextField();
	textFiltrar.setBounds(472, 52, 177, 20);
	panel.add(textFiltrar);
	textFiltrar.setColumns(10);
	
	 btnFiltrar = new JButton("FILTRAR");
	btnFiltrar.setBounds(659, 51, 89, 23);
	panel.add(btnFiltrar);
	
	 lblConsulta = new JLabel("Consulta");
	lblConsulta.setBounds(392, 21, 257, 14);
	panel.add(lblConsulta);
	
	lblError = new JLabel("");
	lblError.setForeground(new Color(255, 0, 0));
	lblError.setBounds(28, 98, 298, 20);
	panel.add(lblError);

}



//HABILITAR DESABILITAR PANELES
private void habilitarPanelAgregarLibros(boolean sw){
		
		textAutor.setEditable(sw);
		textTitulo.setEditable(sw);
		textEditorial.setEditable(sw);
		textIsbn.setEditable(sw);
	}

private void habilitarPanelModificarLibros(boolean sw){
	
	chckbxPrestado.setEnabled(sw);
}

private void vaciarPanelLibros(boolean sw){
	
	textIdLibros.setText("");
	textAutor.setText("");
	textTitulo.setText("");
	textEditorial.setText("");
	textFechaPrestamo.setText("");
	textIsbn.setText("");
	chckbxPrestado.setSelected(false);;
}
	
	private void habilitarPanelMantenimiento(boolean sw){
		
		btnNuevo.setEnabled(sw);
		btnEditar.setEnabled(sw);
		btnBorrar.setEnabled(sw);
	    btnGuardar.setEnabled(!sw);
	    btnDeshacer.setEnabled(!sw);
				
		
	}
	private void deshabilitarPanelMantenimiento(){
		boolean sw=false;
		btnNuevo.setEnabled(sw);
		btnEditar.setEnabled(sw);
		btnBorrar.setEnabled(sw);
	    btnGuardar.setEnabled(sw);
	    btnDeshacer.setEnabled(sw);
				
		
	}
	
	
	private void habilitarNavegador(boolean sw){
		
		btnPrimero.setEnabled(sw);
		btnAtras.setEnabled(sw);
		btnAdelante.setEnabled(sw);
		btnUltimo.setEnabled(sw);
		
		
	}
}