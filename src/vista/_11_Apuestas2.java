/*
 * @Author Javier Turienzo
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class _11_Apuestas2 extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
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
	private JScrollPane scrollPaneApuestas;
	private JScrollPane scrollPaneListado;
	private JPanel panelListado;
	private JLabel lblApuesta;
	private JLabel lblRealMadridtokens;
	private JSeparator separator_Hor_4;
	private JLabel lblAlmeriagetafe;
	private JLabel lblalmeriaTokens;
	private JSeparator separator_Hor_5;
	private JSeparator separator_Hor_6;
	private JLabel lblTotal;
	private JLabel lblJornada;
	private JTable tblApuestas;
	private JSpinner spinnerCantidad;
	private JButton btnConfirmar;
	private JButton btnSiguiente;
	private JButton btnAnterior;

	// Constructor
	public _11_Apuestas2() {
		setTitle("Plantilla");
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLocationByPlatform(rootPaneCheckingEnabled);
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

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(0, 0, 283, 539);
		background.add(lblFondo);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/logo.png")));
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
		lblBtnCerrar.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/close.png")));
		lblBtnCerrar.setBounds(970, 0, 40, 40);
		background.add(lblBtnCerrar);

		JLabel lblBtnMinimizar = new JLabel("");
		lblBtnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblBtnMinimizar.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/minimize.png")));
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

		scrollPaneApuestas = new JScrollPane();
		scrollPaneApuestas.setBackground(new Color(0, 128, 192));
		scrollPaneApuestas.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		scrollPaneApuestas.setBounds(305, 109, 464, 410);
		scrollPaneApuestas.getViewport().setBackground(new Color(0, 128, 192));
		background.add(scrollPaneApuestas);

		tblApuestas = new JTable();
		tblApuestas.setShowGrid(false);
		tblApuestas.setRowSelectionAllowed(false);
		tblApuestas.setOpaque(false);
		tblApuestas.setShowVerticalLines(false);
		tblApuestas.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		tblApuestas.setModel(new DefaultTableModel(
				new Object[][] { { "Real Madrid", true, 0, null, "Barcelona" }, { "Almeria", true, 0, null, "Getafe" },
						{ "Betis", null, 0, null, "Valencia" }, { "Valladolid", null, 0, null, "Valencia" }, },
				new String[] { "Local", "", "Cantidad", "", "Visitante" }) {
			boolean[] columnEditables = new boolean[] { false, true, false, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblApuestas.getColumnModel().getColumn(1).setCellRenderer(tblApuestas.getDefaultRenderer(Boolean.class));
		tblApuestas.getColumnModel().getColumn(1).setCellEditor(tblApuestas.getDefaultEditor(Boolean.class));

		tblApuestas.getColumnModel().getColumn(3).setCellRenderer(tblApuestas.getDefaultRenderer(Boolean.class));
		tblApuestas.getColumnModel().getColumn(3).setCellEditor(tblApuestas.getDefaultEditor(Boolean.class));

		tblApuestas.getColumnModel().getColumn(0).setPreferredWidth(174);
		tblApuestas.getColumnModel().getColumn(1).setPreferredWidth(26);
		tblApuestas.getColumnModel().getColumn(2).setPreferredWidth(92);
		tblApuestas.getColumnModel().getColumn(3).setPreferredWidth(31);
		tblApuestas.getColumnModel().getColumn(4).setPreferredWidth(174);

		scrollPaneApuestas.setViewportView(tblApuestas);

		scrollPaneListado = new JScrollPane();
		scrollPaneListado.setBounds(787, 109, 213, 410);
		background.add(scrollPaneListado);

		panelListado = new JPanel();
		panelListado.setBackground(new Color(0, 128, 192));
		scrollPaneListado.setViewportView(panelListado);
		panelListado.setLayout(null);

		lblApuesta = new JLabel("Real Madrid - Barcelona");
		lblApuesta.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblApuesta.setBounds(10, 0, 191, 27);
		panelListado.add(lblApuesta);

		lblRealMadridtokens = new JLabel("(Real Madrid) 120 tokens");
		lblRealMadridtokens.setVerticalAlignment(SwingConstants.TOP);
		lblRealMadridtokens.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRealMadridtokens.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		lblRealMadridtokens.setBounds(10, 29, 191, 27);
		panelListado.add(lblRealMadridtokens);

		separator_Hor_4 = new JSeparator();
		separator_Hor_4.setBounds(20, 54, 183, 8);
		panelListado.add(separator_Hor_4);

		lblAlmeriagetafe = new JLabel("Almeria - Getafe");
		lblAlmeriagetafe.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblAlmeriagetafe.setBounds(10, 67, 191, 27);
		panelListado.add(lblAlmeriagetafe);

		lblalmeriaTokens = new JLabel("(Almeria) 50 tokens");
		lblalmeriaTokens.setVerticalAlignment(SwingConstants.TOP);
		lblalmeriaTokens.setHorizontalAlignment(SwingConstants.RIGHT);
		lblalmeriaTokens.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		lblalmeriaTokens.setBounds(10, 96, 191, 27);
		panelListado.add(lblalmeriaTokens);

		separator_Hor_5 = new JSeparator();
		separator_Hor_5.setBounds(20, 121, 183, 8);
		panelListado.add(separator_Hor_5);

		separator_Hor_6 = new JSeparator();
		separator_Hor_6.setForeground(Color.BLACK);
		separator_Hor_6.setBounds(10, 304, 201, 8);
		panelListado.add(separator_Hor_6);

		lblTotal = new JLabel("TOTAL: 170 tokens");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		lblTotal.setBounds(10, 323, 193, 23);
		panelListado.add(lblTotal);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
		btnConfirmar.setBackground(new Color(255, 128, 0));
		btnConfirmar.setBounds(48, 357, 117, 39);
		panelListado.add(btnConfirmar);

		lblJornada = new JLabel("Jornada 7");
		lblJornada.setHorizontalAlignment(SwingConstants.CENTER);
		lblJornada.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblJornada.setBounds(469, 77, 126, 34);
		background.add(lblJornada);
		
		btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
		btnSiguiente.setBackground(new Color(255, 128, 0));
		btnSiguiente.setBounds(651, 79, 101, 23);
		background.add(btnSiguiente);
		
		btnAnterior = new JButton("ANTERIOR");
		btnAnterior.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
		btnAnterior.setBackground(new Color(255, 128, 0));
		btnAnterior.setBounds(320, 79, 101, 23);
		background.add(btnAnterior);

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