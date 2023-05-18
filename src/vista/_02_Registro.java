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
	private JTextField txtUser;
	private JPasswordField txtPwd;
	private JSeparator separator;
	private JButton btnRegistrarse;
	private JTextField txtNombre;
	private JLabel lblApellido2;
	private JLabel lblApellido1;
	private JLabel lblNombre;
	private JLabel lblUsuario;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JTextArea monedas;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JDateChooser dateNacimiento;

	// Constructor
	public _02_Registro() {
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

		txtUser = new JTextField();
		txtUser.setForeground(new Color(255, 255, 255));
		txtUser.setBackground(new Color(0, 128, 192));
		txtUser.setBounds(110, 214, 217, 20);
		background.add(txtUser);
		txtUser.setColumns(10);

		txtPwd = new JPasswordField();
		txtPwd.setForeground(new Color(255, 255, 255));
		txtPwd.setBackground(new Color(0, 128, 192));
		txtPwd.setBounds(110, 254, 217, 20);
		background.add(txtPwd);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(2, 0);
			}
		});
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
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBackground(new Color(0, 128, 192));
		txtNombre.setBounds(498, 219, 217, 20);
		background.add(txtNombre);
		
		lblApellido1 = new JLabel("APELLIDO1*:");
		lblApellido1.setFont(new Font("Britannic Bold", Font.PLAIN, 17));
		lblApellido1.setBounds(398, 252, 183, 29);
		background.add(lblApellido1);
		
		lblApellido2 = new JLabel("APELLIDO2 :");
		lblApellido2.setFont(new Font("Britannic Bold", Font.PLAIN, 17));
		lblApellido2.setBounds(398, 292, 183, 29);
		background.add(lblApellido2);
		
		dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(110, 301, 217, 20);
		background.add(dateNacimiento);
		
		lblCorreo = new JLabel("CORREO* :");
		lblCorreo.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblCorreo.setBounds(10, 331, 141, 29);
		background.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(Color.WHITE);
		txtCorreo.setColumns(10);
		txtCorreo.setBackground(new Color(0, 128, 192));
		txtCorreo.setBounds(110, 338, 217, 20);
		background.add(txtCorreo);
		
		monedas = new JTextArea();
		monedas.setBackground(new Color(0, 128, 192));
		monedas.setText("se a\u00F1adiran 300 monedas una \r\nvez se halla registrado, una cierta \r\ncantidad de monedas se renovaran \r\ndiariamente");
		monedas.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		monedas.setBounds(259, 408, 238, 78);
		background.add(monedas);
		
		txtApellido1 = new JTextField();
		txtApellido1.setForeground(Color.WHITE);
		txtApellido1.setColumns(10);
		txtApellido1.setBackground(new Color(0, 128, 192));
		txtApellido1.setBounds(498, 259, 218, 20);
		background.add(txtApellido1);
		
		txtApellido2 = new JTextField();
		txtApellido2.setForeground(Color.WHITE);
		txtApellido2.setColumns(10);
		txtApellido2.setBackground(new Color(0, 128, 192));
		txtApellido2.setBounds(498, 299, 217, 20);
		background.add(txtApellido2);
		
				lblFondo = new JLabel("");
				lblFondo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/fondoLogin2  - copia.jpg")));
				lblFondo.setBounds(725, 0, 283, 537);
				background.add(lblFondo);
				
				JTextArea txtrFechaDeNacimiento = new JTextArea();
				txtrFechaDeNacimiento.setEditable(false);
				txtrFechaDeNacimiento.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
				txtrFechaDeNacimiento.setBackground(new Color(0, 128, 192));
				txtrFechaDeNacimiento.setText("FECHA DE\r\n NACIMIENTO * :");
				txtrFechaDeNacimiento.setBounds(10, 287, 98, 78);
				background.add(txtrFechaDeNacimiento);
				
				JTextArea txtrContraSea = new JTextArea();
				txtrContraSea.setEditable(false);
				txtrContraSea.setText("CONTRASE\u00D1A*:");
				txtrContraSea.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
				txtrContraSea.setBackground(new Color(0, 128, 192));
				txtrContraSea.setBounds(10, 253, 98, 78);
				background.add(txtrContraSea);
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
