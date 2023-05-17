/*
 * @Guillermo Callizaya Fernandez
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _03_RecuperarCuenta extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblLogo;
	private JPanel background;
	private JButton btnPaginaPrincipal;
	private JButton btnIniciarSesion;
	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
	private JLabel lblPorFavorIntroduzca;
	private JLabel lblUsuario;
	private JLabel lblTituloAcceder;
	private JTextField txtUsuario;
	private JLabel lblCorreo;
	private JTextField txtCorreoElectronico;
	private JLabel lblO;
	private JButton btnRecuperarCuenta;
	private JLabel lblRevise;

	// Constructor
	public _03_RecuperarCuenta() {
		setTitle("Plantilla");
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

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(_03_RecuperarCuenta.class.getResource("/img/logo.png")));
		lblLogo.setBounds(600, 11, 150, 64);
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
		lblBtnCerrar.setIcon(new ImageIcon(_03_RecuperarCuenta.class.getResource("/img/close.png")));
		lblBtnCerrar.setBounds(970, 0, 40, 40);
		background.add(lblBtnCerrar);

		JLabel lblBtnMinimizar = new JLabel("");
		lblBtnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblBtnMinimizar.setIcon(new ImageIcon(_03_RecuperarCuenta.class.getResource("/img/minimize.png")));
		lblBtnMinimizar.setBounds(928, 0, 34, 40);
		background.add(lblBtnMinimizar);
		
		btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(3, 1);
			}
		});
		btnIniciarSesion.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnIniciarSesion.setBackground(Color.yellow);
		    	btnIniciarSesion.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnIniciarSesion.setBackground(null);
		    	btnIniciarSesion.setOpaque(false);
		    }
		});
		
				btnPaginaPrincipal = new JButton("PAGINA PRINCIPAL");
				btnPaginaPrincipal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						miControlador.cambiarVentana(3, 0);
					}
				});
				btnPaginaPrincipal.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				        btnPaginaPrincipal.setBackground(Color.yellow);
				        btnPaginaPrincipal.setOpaque(true);
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				        btnPaginaPrincipal.setBackground(null);
				        btnPaginaPrincipal.setOpaque(false);
				    }
				});
				
						btnPaginaPrincipal.setHorizontalAlignment(SwingConstants.LEFT);
						btnPaginaPrincipal.setFont(new Font("Britannic Bold", Font.BOLD, 25));
						btnPaginaPrincipal.setBounds(10, 215, 285, 49);
						btnPaginaPrincipal.setBorderPainted(false); 
						btnPaginaPrincipal.setContentAreaFilled(false); 
						btnPaginaPrincipal.setOpaque(false);
						btnPaginaPrincipal.setFocusPainted(false);
						btnPaginaPrincipal.setCursor(new Cursor(Cursor.HAND_CURSOR));
						background.add(btnPaginaPrincipal);
						background.setComponentZOrder(btnPaginaPrincipal, 0);
		btnIniciarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnIniciarSesion.setFocusPainted(false);
		btnIniciarSesion.setContentAreaFilled(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBounds(10, 265, 260, 49);
		btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnIniciarSesion);
		background.setComponentZOrder(btnIniciarSesion, 0);
		
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
		
				lblFondo = new JLabel("");
				lblFondo.setIcon(new ImageIcon(_03_RecuperarCuenta.class.getResource("/img/fondoLogin2  - copia.jpg")));
				lblFondo.setBounds(0, 0, 283, 539);
				background.add(lblFondo);
		lblBarraMoverVentana.setBounds(0, 0, 918, 23);
		background.add(lblBarraMoverVentana);
		
		lblTituloAcceder = new JLabel("\u00BFNo puedes acceder?");
		lblTituloAcceder.setFont(new Font("Britannic Bold", Font.PLAIN, 22));
		lblTituloAcceder.setBounds(601, 114, 232, 32);
		background.add(lblTituloAcceder);
		
		lblPorFavorIntroduzca = new JLabel("Por favor, introduzca:");
		lblPorFavorIntroduzca.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblPorFavorIntroduzca.setBounds(601, 163, 205, 25);
		background.add(lblPorFavorIntroduzca);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblUsuario.setBounds(518, 215, 86, 25);
		background.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(0, 128, 192));
		txtUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtUsuario.setText("          Introduzca el usuario");
		txtUsuario.setBounds(601, 207, 268, 40);
		background.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblCorreo.setBounds(525, 290, 76, 25);
		background.add(lblCorreo);
		
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setBackground(new Color(0, 128, 192));
		txtCorreoElectronico.setText("Introduzca el correo electronico");
		txtCorreoElectronico.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.setBounds(601, 280, 268, 40);
		background.add(txtCorreoElectronico);
		
		lblO = new JLabel("o");
		lblO.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblO.setBounds(604, 250, 18, 25);
		background.add(lblO);
		
		btnRecuperarCuenta = new JButton("Recuperar Cuenta");
		btnRecuperarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRevise.setText("Revise su correo electronico");
			}
		});
		btnRecuperarCuenta.setBackground(new Color(255, 128, 0));
		btnRecuperarCuenta.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnRecuperarCuenta.setBounds(601, 365, 268, 40);
		background.add(btnRecuperarCuenta);
		
		lblRevise = new JLabel("");
		lblRevise.setForeground(new Color(255, 128, 0));
		lblRevise.setBackground(Color.WHITE);
		lblRevise.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 16));
		lblRevise.setBounds(601, 328, 249, 25);
		background.add(lblRevise);
		

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
