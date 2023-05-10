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

import controlador.Controlador;
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

public class _01_InicioSesion2 extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblLogo;
	private JPanel background;
	private JLabel lblIniciarSesion;

	// Constructor
	public _01_InicioSesion2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		background = new JPanel();
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
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblUsuario.setBounds(100, 237, 86, 29);
		background.add(lblUsuario);
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
