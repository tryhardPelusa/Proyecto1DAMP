/*
 * @Author Jose Maya
 */
package vista;

import java.awt.Color;
import java.awt.Component;
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
import com.jgoodies.forms.factories.DefaultComponentFactory;



public class _16_RegistroCorrecto extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JLabel lblFondo;
	private JPanel background;
	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
	private JButton btnIrLigas;
	private JLabel lblBienvenido;
	private JLabel lblMensajeBienvenida;


	// Constructor
	public _16_RegistroCorrecto() {
		setTitle("Error Registro");
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);;
		setSize(536, 200);
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
		lblBarraMoverVentana.setBounds(0, 0, 536, 23);
		background.add(lblBarraMoverVentana);
		
		int width = 85;  // Anchura del JLabel
		int height = 70; // Altura del JLabel


		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Plantilla.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(0, 0, 79, 200);
		background.add(lblFondo);
		
		lblBienvenido = new JLabel("Bienvenid@");
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Britannic Bold", Font.BOLD, 28));
		lblBienvenido.setBounds(208, 22, 165, 51);
		background.add(lblBienvenido);
		
		lblMensajeBienvenida = new JLabel("Enhorabuena!, ya puedes disfrutar de League Master");
		lblMensajeBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeBienvenida.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
		lblMensajeBienvenida.setBounds(135, 66, 336, 40);
		background.add(lblMensajeBienvenida);
		
		btnIrLigas = new JButton("Ir a Mis Ligas");
		btnIrLigas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarVentana(16);
				miControlador.cambiarVentana(2, 0);
			}
		});
		btnIrLigas.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
		btnIrLigas.setBackground(new Color(255, 128, 0));
		btnIrLigas.setBounds(221, 128, 138, 39);
		background.add(btnIrLigas);

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
}