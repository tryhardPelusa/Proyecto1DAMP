package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;

/**
 * 
 * @author josem
 *
 */
public class _08_CrearEquipos extends JFrame implements Vista {

	// Creamos las variables siguiendo las convenciones al nombrarlas
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
	private JLabel lblNuevoEquipo;
	private JButton btnCrear;
	private JTextField txtNombre;
	private JTextField txtSede;
	private JTextField txtDeporte;
	private JLabel lblNombre;
	private JLabel lblSede;
	private JLabel lblDeporte;

	public _08_CrearEquipos() {
		setTitle("Crear Equipos");
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
				miControlador.cambiarVentana(8, 4);
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
				miControlador.cambiarVentana(8, 0);
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
				miControlador.cambiarVentana(8, 7);
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
				miControlador.cambiarVentana(8, 5);
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

		btnCrearEquipo = new JButton("  CREAR EQUIPO");
		btnCrearEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearEquipo.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnCrearEquipo.setFocusPainted(false);
		btnCrearEquipo.setContentAreaFilled(false);
		btnCrearEquipo.setBorderPainted(false);
		btnCrearEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCrearEquipo.setEnabled(false);
		btnCrearEquipo.setBackground(new Color(220, 220, 220));
		btnCrearEquipo.setForeground(new Color(128, 128, 128));
		btnCrearEquipo.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 128)));
		btnCrearEquipo.setBounds(10, 277, 260, 49);
		background.add(btnCrearEquipo);
		background.setComponentZOrder(btnCrearEquipo, 0);

		btnUnirseAEquipo = new JButton("UNIRSE A EQUIPO");
		btnUnirseAEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(8, 6);
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
				miControlador.cambiarVentana(8, 12);
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
				miControlador.cambiarVentana(8, 1);
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

		lblNuevoEquipo = new JLabel("Nuevo equipo");
		lblNuevoEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblNuevoEquipo.setFont(new Font("Britannic Bold", Font.BOLD, 40));
		lblNuevoEquipo.setBounds(481, 87, 277, 64);
		background.add(lblNuevoEquipo);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.InsertEquipo();
				miControlador.cambiarVentana(8, 10);
			}
		});
		btnCrear.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnCrear.setBackground(new Color(255, 128, 0));
		btnCrear.setBounds(481, 411, 111, 23);
		background.add(btnCrear);

		txtNombre = new JTextField();
		txtNombre.setBounds(481, 190, 402, 40);
		background.add(txtNombre);
		txtNombre.setColumns(10);

		txtSede = new JTextField();
		txtSede.setColumns(10);
		txtSede.setBounds(481, 262, 402, 40);
		background.add(txtSede);

		txtDeporte = new JTextField();
		txtDeporte.setColumns(10);
		txtDeporte.setBounds(481, 330, 402, 40);
		background.add(txtDeporte);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblNombre.setBounds(404, 192, 67, 40);
		background.add(lblNombre);

		lblSede = new JLabel("SEDE");
		lblSede.setHorizontalAlignment(SwingConstants.LEFT);
		lblSede.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblSede.setBounds(401, 264, 59, 40);
		background.add(lblSede);

		lblDeporte = new JLabel("DEPORTE");
		lblDeporte.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeporte.setFont(new Font("Britannic Bold", Font.PLAIN, 12));
		lblDeporte.setBounds(401, 332, 67, 40);
		background.add(lblDeporte);

		setLocationRelativeTo(null);
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;

	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public String getNombreEquipo() {
		return txtNombre.getText();
	}

	public String getSede() {
		return txtSede.getText();
	}

	public String getDeporte() {
		return txtDeporte.getText();
	}
}