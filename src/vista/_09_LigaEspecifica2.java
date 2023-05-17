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
	private JButton btnApostar;
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
	private JButton btnModificar;

    public _09_LigaEspecifica2() {
    	
		setTitle("Liga Especifica");
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1010, 539);
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
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblBtnCerrar.setBackground(null);
		    	lblBtnCerrar.setOpaque(false);
		    }
		});
		lblBtnCerrar.setIcon(new ImageIcon(Plantilla.class.getResource("/img/close.png")));
		lblBtnCerrar.setBounds(970, 0, 40, 40);
		background.add(lblBtnCerrar);

		JLabel lblBtnMinimizar = new JLabel("");
		lblBtnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblBtnMinimizar.setIcon(new ImageIcon(Plantilla.class.getResource("/img/minimize.png")));
		lblBtnMinimizar.setBounds(928, 0, 34, 40);
		background.add(lblBtnMinimizar);

		btnMiCuenta = new JButton("MI CUENTA");
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
		btnMiCuenta.setBounds(10, 13, 262, 49);
		btnMiCuenta.setBorderPainted(false); 
        btnMiCuenta.setContentAreaFilled(false); 
		btnMiCuenta.setOpaque(false);
		btnMiCuenta.setFocusPainted(false);
		btnMiCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnMiCuenta);
		background.setComponentZOrder(btnMiCuenta, 0);
		
		btnVerLigas = new JButton("VER LIGAS");
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
		btnVerLigas.setBounds(10, 62, 262, 49);
		btnVerLigas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnVerLigas);
		background.setComponentZOrder(btnVerLigas, 0);
		
		btnCrearLiga = new JButton("CREAR LIGA");
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
		btnCrearLiga.setBounds(10, 122, 260, 49);
		btnCrearLiga.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnCrearLiga);
		background.setComponentZOrder(btnCrearLiga, 0);
		
		btnUnirseALiga = new JButton("UNIRSE A LIGA");
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
		btnUnirseALiga.setBounds(10, 182, 260, 49);
		btnUnirseALiga.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnUnirseALiga);
		background.setComponentZOrder(btnUnirseALiga, 0);
		
		btnCrearEquipo = new JButton("CREAR EQUIPO");
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
		btnCrearEquipo.setBounds(10, 242, 260, 49);
		btnCrearEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnCrearEquipo);
		background.setComponentZOrder(btnCrearEquipo, 0);
		
		btnUnirseAEquipo = new JButton("UNIRSE A EQUIPO");
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
		btnUnirseAEquipo.setBounds(10, 302, 262, 49);
		btnUnirseAEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnUnirseAEquipo);
		background.setComponentZOrder(btnUnirseAEquipo, 0);
		
		btnMisApuestas = new JButton("MIS APUESTAS");
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
		btnMisApuestas.setBounds(10, 362, 262, 49);
		btnMisApuestas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnMisApuestas);
		background.setComponentZOrder(btnMisApuestas, 0);
		
		btnApostar = new JButton("APOSTAR");
		btnApostar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnApostar.setBackground(Color.yellow);
		    	btnApostar.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnApostar.setBackground(null);
		    	btnApostar.setOpaque(false);
		    }
		});
		btnApostar.setHorizontalAlignment(SwingConstants.LEFT);
		btnApostar.setOpaque(false);
		btnApostar.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnApostar.setFocusPainted(false);
		btnApostar.setContentAreaFilled(false);
		btnApostar.setBorderPainted(false);
		btnApostar.setBounds(10, 422, 260, 49);
		btnApostar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnApostar);
		background.setComponentZOrder(btnApostar, 0);
		
		btnSignOut = new JButton("Sign Out");
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
		btnSignOut.setBounds(10, 470, 262, 49);
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
	
	//Crea el panel de "Clasificacion"
	JPanel panelClasificacion = new JPanel();
	tabbedPane.addTab("Clasificacion", null, panelClasificacion, null);
	panelClasificacion.setLayout(null);
	
	//Se crea el scrollpanel para poder meter la clasificacion y su tabla dentro
	scrollPaneClasificacion = new JScrollPane();
	scrollPaneClasificacion.setBounds(0, 0, 424, 178);
	panelClasificacion.add(scrollPaneClasificacion);
	
	// Tabla con los resultados de la liga
	tableClasificacion = new JTable();
	tableClasificacion.setEnabled(false);
	tableClasificacion.setFont(new Font("Britannic Bold", Font.PLAIN, 11));
	tableClasificacion.setModel(new DefaultTableModel(
			new Object[][] { { "Real Madrid", 12, 5, 4, 1, 14, 5 }, { "Barcelona", 10, 5, 3, 1, 12, 6 },
					{ "Cordoba", 8, 5, 2, 3, 10, 9 }, { null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
					{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
			new String[] { "Equipo", "Puntos", "PJ", "PG", "PP", "GF", "GC" }));
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
	  
    //Se crea el scrollpanel para poder meter el calendario y su tabla dentro
	scrollPaneCalendario = new JScrollPane();
	scrollPaneCalendario.setBounds(0, 0, 424, 178);
	panelCalendario.add(scrollPaneCalendario);
	  
	  // Crea la tabla del calendario
		tableCalendario = new JTable();
		tableCalendario.setModel(new DefaultTableModel(
				new Object[][] { { "2023-05-10", "Real Madrid", "Valencia", "Pista U-Tad" },
						{ "2023-05-11", "Barcelona", "Cadiz", "Camp Nou" },
						{ "2023-05-12", "Valencia", "Sevilla", "Old Trafford" }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "Fecha", "Equipo Local", "Equipo Visitante", "Sede" }));
		tableCalendario.setFont(new Font("Britannic Bold", Font.PLAIN, 11));
		scrollPaneCalendario.setViewportView(tableCalendario);
	
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
	 		miControlador.cambiarVentana(9, 11);
	 	}
	 });
	 btnApostar2.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
	 btnApostar2.setBackground(new Color(255, 128, 0));
	 btnApostar2.setBounds(584, 419, 111, 23);
	 background.add(btnApostar2);
	
	 btnModificar = new JButton("Modificar");
	 btnModificar.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
	 btnModificar.setBackground(new Color(255, 128, 0));
	 btnModificar.setBounds(733, 419, 111, 23);
	 background.add(btnModificar);
		
    }

    @Override
    public void setModelo(Modelo miModelo) {
        this.miModelo = miModelo;

    }

    @Override
    public void setControlador(Controlador miControlador) {
        this.miControlador = miControlador;
    }
}
