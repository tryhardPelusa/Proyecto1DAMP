/*@autor: Raúl Fernández*/
package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class _02_Registro extends JFrame implements Vista {
	private Controlador miControlador;
	private Modelo miModelo;

	private JPanel contentPane;
	private JMenuBar menuNavegacion;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JButton btnMiCuenta;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblApellido1;
	private JTextField txtnombre;
	private JLabel lblApellido2;
	private JTextField txtapellido1;
	private JTextField txtapellido;
	private JTextField txtTelefono;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JPasswordField passwordField;
	private JLabel lblPwd;
	private JLabel lblRegistro;
	private JLabel lblFecha;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnRegistrarse;
	private JTextArea txtrSeAadiran;
	private JDateChooser FechaNaci;
	private JLabel lblIconoUsuario;

	public _02_Registro() {
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		lblUser = new JLabel("Usuario*");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUser.setBounds(207, 186, 60, 21);
		contentPane.add(lblUser);
		// campo usuario en el que el usuario introduce su nombre de usuario
		txtUser = new JTextField();
		txtUser.setForeground(new Color(255, 255, 255));
		txtUser.setBackground(new Color(64, 0, 64));
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUser.setBounds(270, 186, 171, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		lblApellido1 = new JLabel("Apellido 1*");
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido1.setBounds(202, 329, 65, 21);
		contentPane.add(lblApellido1);
		// Campo apellido 1 en el que recoge el primer apellido de un usuario
		txtnombre = new JTextField();
		txtnombre.setBackground(new Color(64, 0, 64));
		txtnombre.setForeground(new Color(255, 255, 255));
		txtnombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtnombre.setColumns(10);
		txtnombre.setBounds(270, 299, 171, 19);
		contentPane.add(txtnombre);

		lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido2.setBounds(207, 361, 60, 21);
		contentPane.add(lblApellido2);
		// Campo apellido 2 en el que recoge el segundo apellido de un usuario
		txtapellido1 = new JTextField();
		txtapellido1.setBackground(new Color(64, 0, 64));
		txtapellido1.setForeground(new Color(255, 255, 255));
		txtapellido1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtapellido1.setColumns(10);
		txtapellido1.setBounds(270, 331, 171, 19);
		contentPane.add(txtapellido1);

		txtapellido = new JTextField();
		txtapellido.setBackground(new Color(64, 0, 64));
		txtapellido.setForeground(new Color(255, 255, 255));
		txtapellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtapellido.setColumns(10);
		txtapellido.setBounds(270, 361, 171, 19);
		contentPane.add(txtapellido);

		txtTelefono = new JTextField();
		txtTelefono.setBackground(new Color(64, 0, 64));
		txtTelefono.setForeground(new Color(255, 255, 255));
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(640, 277, 183, 19);
		contentPane.add(txtTelefono);

		lblNombre = new JLabel("Nombre*");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(207, 297, 72, 21);
		contentPane.add(lblNombre);

		lblTelefono = new JLabel("Telefono ");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(560, 277, 60, 21);
		contentPane.add(lblTelefono);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(64, 0, 64));
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBounds(270, 218, 171, 19);
		contentPane.add(passwordField);

		lblPwd = new JLabel("Contraseña *");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPwd.setBounds(177, 218, 98, 21);
		contentPane.add(lblPwd);

		lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Kannada MN", Font.BOLD, 43));
		lblRegistro.setBounds(316, 40, 180, 111);
		contentPane.add(lblRegistro);

		lblFecha = new JLabel("Fecha de Nacimiento*");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecha.setBounds(492, 311, 132, 21);
		contentPane.add(lblFecha);

		lblCorreo = new JLabel("Correo*");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCorreo.setBounds(560, 342, 60, 21);
		contentPane.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBackground(new Color(64, 0, 64));
		txtCorreo.setForeground(new Color(255, 255, 255));
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(640, 342, 183, 19);
		contentPane.add(txtCorreo);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBackground(new Color(255, 128, 64));
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setBounds(865, 493, 114, 33);
		contentPane.add(btnRegistrarse);
		// jtext en el que damos una pequeña informacion sobre las monedas
		txtrSeAadiran = new JTextArea();
		txtrSeAadiran.setBackground(new Color(128, 128, 0));
		txtrSeAadiran.setEditable(false);
		txtrSeAadiran.setText(
				"se añadiran 300 monedas una \r\nvez se halla registrado, una cierta \r\ncantidad de monedas se renovaran \r\ndiariamente");
		txtrSeAadiran.setBounds(534, 389, 293, 76);
		contentPane.add(txtrSeAadiran);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		FechaNaci = new JDateChooser();
		FechaNaci.setBackground(new Color(64, 0, 64));
		FechaNaci.setForeground(new Color(255, 255, 255));
		FechaNaci.setBounds(640, 311, 187, 19);
		contentPane.add(FechaNaci);
		
		lblIconoUsuario = new JLabel("\"\"");
		lblIconoUsuario.setIcon(new ImageIcon("/Users/guillermofdez/git/prog---ud15---tarea-rosa-melano/src/img/pngwing.png"));
		lblIconoUsuario.setBounds(525, 40, 85, 100);
		contentPane.add(lblIconoUsuario);
		
		JLabel lblImagenPerfil = new JLabel("Cargar im\u00E1gen de perfil");
		lblImagenPerfil.setForeground(SystemColor.inactiveCaptionText);
		lblImagenPerfil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblImagenPerfil.setBounds(496, 130, 148, 33);
		contentPane.add(lblImagenPerfil);
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
