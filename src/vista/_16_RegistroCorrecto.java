/*
 * @Author Jose Maya
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
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
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;



public class _16_RegistroCorrecto extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JLabel lblFondo;
	private JPanel background;
	private JButton btnApostar;
	private JButton btnSignOut;
	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
	private JButton btnRegistrarse;


	// Constructor
	public _16_RegistroCorrecto() {
		setTitle("Error Registro");
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);;
		setSize(1010, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		background = new JPanel();
		background.setBorder(null);
		background.setBackground(new Color(0, 128, 192));
		background.setBounds(0, 0, 536, 200);
		contentPane.add(background);
		background.setLayout(null);

		btnApostar = new JButton("BIENVENID@");
		btnApostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnApostar.setForeground(new Color(0, 0, 0));
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
		btnApostar.setBounds(201, 11, 186, 49);
		btnApostar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnApostar);
		background.setComponentZOrder(btnApostar, 0);

		btnSignOut = new JButton("Enhorabuena!, ya puedes disfrutar de League Master");
		btnSignOut.setForeground(new Color(0, 0, 0));
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
		btnSignOut.setBounds(89, 58, 415, 49);
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
		
		int width = 85;  // Anchura del JLabel
		int height = 70; // Altura del JLabel

		ImageIcon icon = new ImageIcon(_16_RegistroCorrecto.class.getResource("/img/error.png"));
		Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		icon = new ImageIcon(scaledImage);


		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Plantilla.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(0, 0, 79, 200);
		background.add(lblFondo);
		
		btnRegistrarse = new JButton("Ir a Mis Ligas");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarVentana(16);
				miControlador.cambiarVentana(2, 0);
			}
		});
		btnRegistrarse.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnRegistrarse.setBackground(new Color(255, 128, 0));
		btnRegistrarse.setBounds(221, 128, 138, 39);
		background.add(btnRegistrarse);

		

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