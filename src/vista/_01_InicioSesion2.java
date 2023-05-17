/*
 * @Author Javier Turienzo
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

public class _01_InicioSesion2 extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblLogo;
	private JPanel background;
	private JLabel lblIniciarSesion;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblContraseniaOlvidada;
	private JLabel lblPregunta;
	private JSeparator separator;
	private JButton btnAcceder;
	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
	private JLabel lblBtnCerrar;
	private JLabel lblBtnMinimizar;

	// Constructor
	public _01_InicioSesion2() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1008, 536);
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

		lblIniciarSesion = new JLabel("INICIAR SESI\u00D3N");
		lblIniciarSesion.setFont(new Font("Britannic Bold", Font.BOLD, 40));
		lblIniciarSesion.setBounds(100, 132, 332, 64);
		background.add(lblIniciarSesion);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblUsuario.setBounds(100, 237, 141, 29);
		background.add(lblUsuario);

		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 128, 192));
		textField.setBounds(100, 278, 283, 20);
		background.add(textField);
		textField.setColumns(10);

		JLabel lblContrasenia = new JLabel("CONTRASE\u00D1A");
		lblContrasenia.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblContrasenia.setBounds(100, 328, 183, 29);
		background.add(lblContrasenia);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(0, 128, 192));
		passwordField.setBounds(100, 368, 283, 20);
		background.add(passwordField);

		lblContraseniaOlvidada = new JLabel("\u00BFHas olvidado tu contrase\u00F1a?");
		lblContraseniaOlvidada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				miControlador.cambiarVentana(1, 3);
			}
		});
		lblContraseniaOlvidada.setForeground(new Color(255, 128, 0));
		lblContraseniaOlvidada.setBounds(100, 393, 283, 14);
		background.add(lblContraseniaOlvidada);

		btnAcceder = new JButton("ACCEDER");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(1, 0);
			}
		});
		btnAcceder.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnAcceder.setBackground(new Color(255, 128, 0));
		btnAcceder.setBounds(100, 440, 101, 39);
		background.add(btnAcceder);

		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(255, 128, 0));
		separator.setForeground(new Color(255, 128, 0));
		separator.setBounds(518, 59, 2, 448);
		background.add(separator);

		lblPregunta = new JLabel("\u00BFA\u00FAn no tienes cuenta?");
		lblPregunta.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
		lblPregunta.setBounds(539, 151, 176, 29);
		background.add(lblPregunta);

		JButton btnRegistrate = new JButton("REGISTRATE");
		btnRegistrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(1, 2);
			}
		});
		btnRegistrate.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnRegistrate.setBackground(new Color(255, 128, 0));
		btnRegistrate.setBounds(539, 243, 119, 39);
		background.add(btnRegistrate);

		JButton btnInvitado = new JButton("INVITADO");
		btnInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(1, 0);
			}
		});
		btnInvitado.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnInvitado.setBackground(new Color(255, 128, 0));
		btnInvitado.setBounds(539, 349, 119, 39);
		background.add(btnInvitado);

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

		lblBtnCerrar = new JLabel("");
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
		lblBtnCerrar.setIcon(new ImageIcon(Plantilla.class.getResource("/img/close.png")));
		lblBtnCerrar.setBounds(970, 0, 40, 40);
		background.add(lblBtnCerrar);

		lblBtnMinimizar = new JLabel("");
		lblBtnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBtnMinimizar.setIcon(new ImageIcon(Plantilla.class.getResource("/img/minimize.png")));
		lblBtnMinimizar.setBounds(928, 0, 34, 40);
		background.add(lblBtnMinimizar);

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
