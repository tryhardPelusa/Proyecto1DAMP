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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

import javax.swing.DropMode;
import javax.swing.JSeparator;

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

	// Constructor
	public _01_InicioSesion2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
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
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(725, 0, 283, 537);
		background.add(lblFondo);
		
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
		lblContraseniaOlvidada.setForeground(new Color(255, 128, 0));
		lblContraseniaOlvidada.setBounds(100, 393, 283, 14);
		background.add(lblContraseniaOlvidada);
		
		btnAcceder = new JButton("ACCEDER");
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
		btnRegistrate.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnRegistrate.setBackground(new Color(255, 128, 0));
		btnRegistrate.setBounds(539, 243, 119, 39);
		background.add(btnRegistrate);
		
		JButton btnInvitado = new JButton("INVITADO");
		btnInvitado.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnInvitado.setBackground(new Color(255, 128, 0));
		btnInvitado.setBounds(539, 349, 119, 39);
		background.add(btnInvitado);
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
