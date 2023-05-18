/*
 * @Author Javier Turienzo
 */
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Modelo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

import javax.swing.DropMode;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;

public class _02_Registro extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblLogo;
	private JPanel background;
	private JLabel lblRegistro;
	private JTextField textField;
	private JPasswordField passwordField;
	private JSeparator separator;
	private JButton btnRegistrarse;
	private JTextField textField_1;
	private JLabel lblApellido2;
	private JLabel lblApellido1;
	private JLabel lblNombre;
	private JLabel lblContrasenia;
	private JLabel lblUsuario;
	private JLabel lblCorreo;
	private JTextField textField_2;
	private JTextArea monedas;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JDateChooser dateNacimiento;
	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
	private JLabel lblBtnCerrar;
	private JLabel lblBtnMinimizar;

	// Constructor
	public _02_Registro() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1008, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		background = new JPanel();
		background.setBorder(null);
		background.setBackground(new Color(0, 128, 192));
		background.setBounds(0, 0, 1008, 537);
		contentPane.add(background);
		background.setLayout(null);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/logo.png")));
		lblLogo.setBounds(10, 11, 150, 64);
		background.add(lblLogo);

		lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Britannic Bold", Font.BOLD, 40));
		lblRegistro.setBounds(306, 30, 332, 64);
		background.add(lblRegistro);

		lblUsuario = new JLabel("USUARIO* :");
		lblUsuario.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblUsuario.setBounds(10, 207, 141, 29);
		background.add(lblUsuario);

		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 128, 192));
		textField.setBounds(110, 214, 217, 20);
		background.add(textField);
		textField.setColumns(10);

		lblContrasenia = new JLabel("CONTRASE\u00D1A* :");
		lblContrasenia.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblContrasenia.setBounds(10, 247, 183, 29);
		background.add(lblContrasenia);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(0, 128, 192));
		passwordField.setBounds(151, 254, 176, 20);
		background.add(passwordField);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnRegistrarse.setBackground(new Color(255, 128, 0));
		btnRegistrarse.setBounds(852, 487, 132, 39);
		background.add(btnRegistrarse);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(255, 128, 0));
		separator.setForeground(new Color(255, 128, 0));
		separator.setBounds(381, 105, 2, 292);
		background.add(separator);

		lblNombre = new JLabel("NOMBRE* :");
		lblNombre.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblNombre.setBounds(398, 212, 183, 29);
		background.add(lblNombre);

		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(0, 128, 192));
		textField_1.setBounds(498, 219, 217, 20);
		background.add(textField_1);

		lblApellido1 = new JLabel("Apellido1* :");
		lblApellido1.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblApellido1.setBounds(398, 252, 183, 29);
		background.add(lblApellido1);

		lblApellido2 = new JLabel("Apellido2  :");
		lblApellido2.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblApellido2.setBounds(398, 292, 183, 29);
		background.add(lblApellido2);

		JLabel lblFecha = new JLabel("Fecha de Nacimiento* :");
		lblFecha.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblFecha.setBounds(10, 287, 232, 29);
		background.add(lblFecha);

		dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(219, 296, 108, 20);
		background.add(dateNacimiento);

		lblCorreo = new JLabel("CORREO* :");
		lblCorreo.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblCorreo.setBounds(10, 331, 141, 29);
		background.add(lblCorreo);

		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(0, 128, 192));
		textField_2.setBounds(110, 338, 217, 20);
		background.add(textField_2);

		monedas = new JTextArea();
		monedas.setText(
				"se a\u00F1adiran 300 monedas una \r\nvez se halla registrado, una cierta \r\ncantidad de monedas se renovaran \r\ndiariamente");
		monedas.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		monedas.setBounds(259, 408, 238, 78);
		background.add(monedas);

		txtApellido1 = new JTextField();
		txtApellido1.setForeground(Color.WHITE);
		txtApellido1.setColumns(10);
		txtApellido1.setBackground(new Color(0, 128, 192));
		txtApellido1.setBounds(508, 259, 208, 20);
		background.add(txtApellido1);

		txtApellido2 = new JTextField();
		txtApellido2.setForeground(Color.WHITE);
		txtApellido2.setColumns(10);
		txtApellido2.setBackground(new Color(0, 128, 192));
		txtApellido2.setBounds(507, 299, 208, 20);
		background.add(txtApellido2);

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

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(725, 0, 283, 537);
		background.add(lblFondo);
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(725, 0, 283, 537);
		background.add(lblFondo);
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
