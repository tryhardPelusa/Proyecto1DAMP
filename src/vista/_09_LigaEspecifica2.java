package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;

/**
 * 
 * @author josem
 *
 */

public class _09_LigaEspecifica2 extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblLogo;
	private JPanel background;
	private JButton btnMiCuenta;
	private JButton btnVerLigas;
	private JButton btnCrearLiga;
	private JButton btnUnirseALiga;
	private JButton btnCrearEquipo;
	private JButton btnUnirseAEquipo;
	private JButton btnMisApuestas;
	private JButton btnSignOut;
	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
	private JScrollPane scrollPaneClasificacion;
	private JTable tableClasificacion;
	private JPanel panelCalendario;
	private JScrollPane scrollPaneCalendario;
	private JTable tableCalendario;
	private JLabel lblNombreLiga;
	private JButton btnVerEquipo;
	private JButton btnApostar2;
	String[] datosApuesta;
	int idAdmin;
	int idLiga;

	public _09_LigaEspecifica2() {

		datosApuesta = new String[2];
		setTitle("Liga Especifica");
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		;
		setSize(1010, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		background = new JPanel();
		background.setBorder(null);
		background.setBackground(new Color(0, 128, 192));
		background.setBounds(0, 0, 1010, 539);
		contentPane.add(background);
		background.setLayout(null);

		btnVerEquipo = new JButton("Ver Equipo");
		btnVerEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 10);
			}
		});
		btnVerEquipo.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnVerEquipo.setBackground(new Color(255, 128, 0));
		btnVerEquipo.setBounds(416, 419, 111, 23);
		background.add(btnVerEquipo);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Plantilla.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(0, 0, 283, 539);
		background.add(lblFondo);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Plantilla.class.getResource("/img/logo.png")));
		lblLogo.setBounds(290, 11, 150, 64);
		background.add(lblLogo);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(160, 160, 160));
		separator.setBackground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(282, 0, 13, 537);
		background.add(separator);

		JLabel lblBtnCerrar = new JLabel("");
		lblBtnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnCerrar.setBackground(Color.RED);
				lblBtnCerrar.setOpaque(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBtnCerrar.setBackground(null);
				lblBtnCerrar.setOpaque(false);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBtnCerrar.setIcon(new ImageIcon(_00_PaginaPrincipal2.class.getResource("/img/close.png")));
		lblBtnCerrar.setBounds(970, 0, 40, 40);
		background.add(lblBtnCerrar);

		JLabel lblBtnMinimizar = new JLabel("");
		lblBtnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnMinimizar.setBackground(Color.BLUE);
				lblBtnMinimizar.setOpaque(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblBtnMinimizar.setBackground(null);
				lblBtnMinimizar.setOpaque(false);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBtnMinimizar.setIcon(new ImageIcon(_00_PaginaPrincipal2.class.getResource("/img/minimize.png")));
		lblBtnMinimizar.setBounds(928, 0, 40, 40);
		background.add(lblBtnMinimizar);

		btnMiCuenta = new JButton("MI CUENTA");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 4);
			}
		});
		btnMiCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiCuenta.setBackground(Color.yellow);
				btnMiCuenta.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMiCuenta.setBackground(null);
				btnMiCuenta.setOpaque(false);
			}
		});

		btnMiCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		btnMiCuenta.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnMiCuenta.setBounds(10, 43, 260, 49);
		btnMiCuenta.setBorderPainted(false);
		btnMiCuenta.setContentAreaFilled(false);
		btnMiCuenta.setOpaque(false);
		btnMiCuenta.setFocusPainted(false);
		btnMiCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnMiCuenta);
		background.setComponentZOrder(btnMiCuenta, 0);

		btnVerLigas = new JButton("VER LIGAS");
		btnVerLigas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 0);
			}
		});
		btnVerLigas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVerLigas.setBackground(Color.yellow);
				btnVerLigas.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnVerLigas.setBackground(null);
				btnVerLigas.setOpaque(false);
			}
		});
		btnVerLigas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerLigas.setOpaque(false);
		btnVerLigas.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnVerLigas.setFocusPainted(false);
		btnVerLigas.setContentAreaFilled(false);
		btnVerLigas.setBorderPainted(false);
		btnVerLigas.setBounds(10, 94, 260, 49);
		btnVerLigas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnVerLigas);
		background.setComponentZOrder(btnVerLigas, 0);

		btnCrearLiga = new JButton("CREAR LIGA");
		btnCrearLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 7);
			}
		});
		btnCrearLiga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearLiga.setBackground(Color.yellow);
				btnCrearLiga.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearLiga.setBackground(null);
				btnCrearLiga.setOpaque(false);
			}
		});
		btnCrearLiga.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearLiga.setOpaque(false);
		btnCrearLiga.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnCrearLiga.setFocusPainted(false);
		btnCrearLiga.setContentAreaFilled(false);
		btnCrearLiga.setBorderPainted(false);
		btnCrearLiga.setBounds(10, 154, 260, 49);
		btnCrearLiga.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnCrearLiga);
		background.setComponentZOrder(btnCrearLiga, 0);

		btnUnirseALiga = new JButton("UNIRSE A LIGA");
		btnUnirseALiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 5);
			}
		});
		btnUnirseALiga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUnirseALiga.setBackground(Color.yellow);
				btnUnirseALiga.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnUnirseALiga.setBackground(null);
				btnUnirseALiga.setOpaque(false);
			}
		});
		btnUnirseALiga.setHorizontalAlignment(SwingConstants.LEFT);
		btnUnirseALiga.setOpaque(false);
		btnUnirseALiga.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnUnirseALiga.setFocusPainted(false);
		btnUnirseALiga.setContentAreaFilled(false);
		btnUnirseALiga.setBorderPainted(false);
		btnUnirseALiga.setBounds(10, 217, 260, 49);
		btnUnirseALiga.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnUnirseALiga);
		background.setComponentZOrder(btnUnirseALiga, 0);

		btnCrearEquipo = new JButton("CREAR EQUIPO");
		btnCrearEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 8);
			}
		});
		btnCrearEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCrearEquipo.setBackground(Color.yellow);
				btnCrearEquipo.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCrearEquipo.setBackground(null);
				btnCrearEquipo.setOpaque(false);
			}
		});
		btnCrearEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearEquipo.setOpaque(false);
		btnCrearEquipo.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnCrearEquipo.setFocusPainted(false);
		btnCrearEquipo.setContentAreaFilled(false);
		btnCrearEquipo.setBorderPainted(false);
		btnCrearEquipo.setBounds(10, 277, 260, 49);
		btnCrearEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnCrearEquipo);
		background.setComponentZOrder(btnCrearEquipo, 0);

		btnUnirseAEquipo = new JButton("UNIRSE A EQUIPO");
		btnUnirseAEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 6);
			}
		});
		btnUnirseAEquipo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUnirseAEquipo.setBackground(Color.yellow);
				btnUnirseAEquipo.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnUnirseAEquipo.setBackground(null);
				btnUnirseAEquipo.setOpaque(false);
			}
		});
		btnUnirseAEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnUnirseAEquipo.setOpaque(false);
		btnUnirseAEquipo.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnUnirseAEquipo.setFocusPainted(false);
		btnUnirseAEquipo.setContentAreaFilled(false);
		btnUnirseAEquipo.setBorderPainted(false);
		btnUnirseAEquipo.setBounds(10, 337, 260, 49);
		btnUnirseAEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnUnirseAEquipo);
		background.setComponentZOrder(btnUnirseAEquipo, 0);

		btnMisApuestas = new JButton("MIS APUESTAS");
		btnMisApuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 12);
			}
		});
		btnMisApuestas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMisApuestas.setBackground(Color.yellow);
				btnMisApuestas.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMisApuestas.setBackground(null);
				btnMisApuestas.setOpaque(false);
			}
		});
		btnMisApuestas.setHorizontalAlignment(SwingConstants.LEFT);
		btnMisApuestas.setOpaque(false);
		btnMisApuestas.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnMisApuestas.setFocusPainted(false);
		btnMisApuestas.setContentAreaFilled(false);
		btnMisApuestas.setBorderPainted(false);
		btnMisApuestas.setBounds(10, 397, 260, 49);
		btnMisApuestas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnMisApuestas);
		background.setComponentZOrder(btnMisApuestas, 0);

		btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(9, 1);
			}
		});
		btnSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSignOut.setBackground(Color.yellow);
				btnSignOut.setOpaque(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSignOut.setBackground(null);
				btnSignOut.setOpaque(false);
			}
		});
		btnSignOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnSignOut.setOpaque(false);
		btnSignOut.setFont(new Font("Britannic Bold", Font.BOLD, 15));
		btnSignOut.setFocusPainted(false);
		btnSignOut.setContentAreaFilled(false);
		btnSignOut.setBorderPainted(false);
		btnSignOut.setBounds(10, 457, 260, 40);
		btnSignOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnSignOut);
		background.setComponentZOrder(btnSignOut, 0);

		lblBarraMoverVentana = new JLabel("");
		lblBarraMoverVentana.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xPantalla = e.getXOnScreen();
				int yPantalla = e.getYOnScreen();
				setLocation(xPantalla - xMouse, yPantalla - yMouse);
			}
		});

		lblBarraMoverVentana.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		lblBarraMoverVentana.setBounds(0, 0, 918, 23);
		background.add(lblBarraMoverVentana);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(416, 165, 429, 206);
		background.add(tabbedPane);

		// Crea el panel de "Clasificacion"
		JPanel panelClasificacion = new JPanel();
		tabbedPane.addTab("Clasificacion", null, panelClasificacion, null);
		panelClasificacion.setLayout(null);

		// Se crea el scrollpanel para poder meter la clasificacion y su tabla dentro
		scrollPaneClasificacion = new JScrollPane();
		scrollPaneClasificacion.setBounds(0, 0, 424, 178);
		panelClasificacion.add(scrollPaneClasificacion);

		// Tabla con los resultados de la liga
		tableClasificacion = new JTable();
		tableClasificacion.setFont(new Font("Britannic Bold", Font.PLAIN, 11));
		scrollPaneClasificacion.setViewportView(tableClasificacion);

		// Personaliza el estilo de las celdas de encabezado de la tabla
		JTableHeader headerClasificacion = tableClasificacion.getTableHeader();
		headerClasificacion.setFont(new Font("Britannic Bold", Font.PLAIN, 11));
		headerClasificacion.setBackground(new Color(0, 128, 192));
		headerClasificacion.setForeground(Color.WHITE);

		// Personaliza el estilo de las celdas de datos de la tabla
		DefaultTableCellRenderer cellRendererClasificacion = new DefaultTableCellRenderer();
		cellRendererClasificacion.setBackground(new Color(230, 230, 250));
		cellRendererClasificacion.setForeground(Color.BLACK);
		for (int i = 0; i < tableClasificacion.getColumnCount(); i++) {
			tableClasificacion.getColumnModel().getColumn(i).setCellRenderer(cellRendererClasificacion);
		}

		// Crea el panel de "Calendario"
		panelCalendario = new JPanel();
		tabbedPane.addTab("Calendario", null, panelCalendario, null);
		panelCalendario.setLayout(null);

		// Se crea el scrollpanel para poder meter el calendario y su tabla dentro
		scrollPaneCalendario = new JScrollPane();
		scrollPaneCalendario.setBounds(0, 0, 424, 178);
		panelCalendario.add(scrollPaneCalendario);

		// Crea la tabla del calendario
		tableCalendario = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tableCalendario.setFont(new Font("Britannic Bold", Font.PLAIN, 11));
		scrollPaneCalendario.setViewportView(tableCalendario);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableCalendario.setModel(miControlador.obtenerPartidosLigaEspecifica());
			}
		});
		tableCalendario.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = tableCalendario.getSelectedRow(); // Obtiene el indice de la fila seleccionada

				Object valorCelda1 = tableCalendario.getValueAt(filaSeleccionada, 0); // Obtiene el valor de la primera
																						// columna de la fila
																						// seleccionada
				Object valorCelda2 = tableCalendario.getValueAt(filaSeleccionada, 1); // Obtiene el valor de la segunda
																						// columna de la fila
																						// seleccionada
				Object valorCelda3 = tableCalendario.getValueAt(filaSeleccionada, 2); // Obtiene el valor de la tercera
																						// columna de la fila
																						// seleccionada

				if (valorCelda1 != null && valorCelda2 != null && valorCelda3 != null) {
					datosApuesta[0] = (String) valorCelda2;
					datosApuesta[1] = (String) valorCelda3;
				}
			}
		});

		// Personaliza el estilo de las celdas de encabezado de la tabla
		JTableHeader headerCalendario = tableCalendario.getTableHeader();
		headerCalendario.setFont(new Font("Britannic Bold", Font.PLAIN, 11));
		headerCalendario.setBackground(new Color(0, 128, 192));
		headerCalendario.setForeground(Color.WHITE);

		// Personaliza el estilo de las celdas de datos de la tabla
		DefaultTableCellRenderer cellRendererCalendario = new DefaultTableCellRenderer();
		cellRendererCalendario.setBackground(new Color(230, 230, 250));
		cellRendererCalendario.setForeground(Color.BLACK);
		for (int i = 0; i < tableCalendario.getColumnCount(); i++) {
			tableCalendario.getColumnModel().getColumn(i).setCellRenderer(cellRendererCalendario);
		}

		lblNombreLiga = new JLabel("Liga DAM U-Tad");
		lblNombreLiga.setFont(new Font("Britannic Bold", Font.BOLD, 40));
		lblNombreLiga.setBounds(416, 86, 332, 64);
		background.add(lblNombreLiga);

		btnApostar2 = new JButton("Apostar");
		btnApostar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.obtenerEquiposDePartidos(datosApuesta);
				miControlador.cambiarVentana(9, 11);	 		
			}
		});
		btnApostar2.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnApostar2.setBackground(new Color(255, 128, 0));
		btnApostar2.setBounds(734, 419, 111, 23);
		background.add(btnApostar2);
		

		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				idLiga = miModelo.getIdLigaActual();
				idAdmin = miModelo.getIdAdminActual();
				tableClasificacion.setModel(miControlador.getClasificacion(idLiga, idAdmin));
//				if (!miModelo.getUsuario().equals(String.valueOf(idAdmin))) {
////					tableClasificacion.setEnabled(false);
//					tableClasificacion.setDefaultEditor(Object.class, null);
//				}
			}
		});
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;

	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
	
	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}
}