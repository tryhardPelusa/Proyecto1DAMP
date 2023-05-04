package pantallas;

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

public class Pantalla_Registro extends JFrame {

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
	private JButton btnSignOut;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblApellido1;
	private JTextField txtApel1;
	private JLabel lblApellido2;
	private JTextField txtapel2;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JPasswordField passwordField;
	private JLabel lblPwd;
	private JLabel lblRegistro;
	private JLabel lblFecha;
	private JLabel lblAnyo;
	private JLabel lblMes;
	private JLabel lblDia;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JButton btnRegistrarse;
	private JTextArea txtrSeAadiran;

	public static void main(String[] args) {

		Pantalla_Registro frame = new Pantalla_Registro();
		frame.setVisible(true);

	}

	public Pantalla_Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);

		menuNavegacion = new JMenuBar();
		setJMenuBar(menuNavegacion);

		mnNewMenu = new JMenu("Ligas");
		menuNavegacion.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Ver ligas");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_5 = new JMenuItem("Crear liga");
		mnNewMenu.add(mntmNewMenuItem_5);

		mntmNewMenuItem_6 = new JMenuItem("Unirse a liga");
		mnNewMenu.add(mntmNewMenuItem_6);

		mnNewMenu_1 = new JMenu("Apuestas");
		menuNavegacion.add(mnNewMenu_1);

		mntmNewMenuItem_1 = new JMenuItem("Mis apuestas");
		mnNewMenu_1.add(mntmNewMenuItem_1);

		mntmNewMenuItem_7 = new JMenuItem("Apostar");
		mnNewMenu_1.add(mntmNewMenuItem_7);

		mnNewMenu_2 = new JMenu("Equipos");
		menuNavegacion.add(mnNewMenu_2);

		mntmNewMenuItem_3 = new JMenuItem("Unirse a equipo");
		mnNewMenu_2.add(mntmNewMenuItem_3);

		mntmNewMenuItem_4 = new JMenuItem("Crear equipo");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		btnMiCuenta = new JButton("Mi cuenta");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiCuenta.setBounds(873, 19, 109, 23);
		contentPane.add(btnMiCuenta);

		btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignOut.setBounds(873, 53, 109, 23);
		contentPane.add(btnSignOut);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		lblUser = new JLabel("Usuario*");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUser.setBounds(207, 186, 60, 21);
		contentPane.add(lblUser);

		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUser.setBounds(270, 186, 96, 19);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		lblApellido1 = new JLabel("Apellido 1*");
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido1.setBounds(202, 291, 65, 21);
		contentPane.add(lblApellido1);

		txtApel1 = new JTextField();
		txtApel1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApel1.setColumns(10);
		txtApel1.setBounds(270, 246, 96, 19);
		contentPane.add(txtApel1);

		lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido2.setBounds(207, 342, 60, 21);
		contentPane.add(lblApellido2);

		txtapel2 = new JTextField();
		txtapel2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtapel2.setColumns(10);
		txtapel2.setBounds(270, 293, 96, 19);
		contentPane.add(txtapel2);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(270, 342, 96, 19);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(270, 390, 96, 19);
		contentPane.add(textField_1);

		lblNombre = new JLabel("Nombre*");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(207, 244, 72, 21);
		contentPane.add(lblNombre);

		lblTelefono = new JLabel("Telefono ");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono.setBounds(207, 392, 60, 21);
		contentPane.add(lblTelefono);

		passwordField = new JPasswordField();
		passwordField.setBounds(270, 434, 96, 19);
		contentPane.add(passwordField);

		lblPwd = new JLabel("Contraseña *");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPwd.setBounds(181, 432, 98, 21);
		contentPane.add(lblPwd);

		lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblRegistro.setBounds(360, 39, 229, 111);
		contentPane.add(lblRegistro);

		lblFecha = new JLabel("Fecha de Nacimiento*");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecha.setBounds(487, 246, 132, 21);
		contentPane.add(lblFecha);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner.setBounds(629, 248, 43, 20);
		contentPane.add(spinner);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setBounds(689, 248, 40, 20);
		contentPane.add(spinner_1);

		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, null, 2023, 1));
		spinner_2.setBounds(739, 248, 53, 20);
		contentPane.add(spinner_2);

		lblDia = new JLabel("Dia");
		lblDia.setBounds(642, 226, 45, 13);
		contentPane.add(lblDia);

		lblMes = new JLabel("Mes");
		lblMes.setBounds(700, 225, 45, 13);
		contentPane.add(lblMes);

		lblAnyo = new JLabel("Año");
		lblAnyo.setBounds(749, 225, 45, 13);
		contentPane.add(lblAnyo);

		lblNewLabel = new JLabel("/");
		lblNewLabel.setBounds(679, 251, 45, 13);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setBounds(734, 251, 45, 13);
		contentPane.add(lblNewLabel_1);

		lblCorreo = new JLabel("Correo*");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCorreo.setBounds(559, 342, 60, 21);
		contentPane.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(642, 342, 180, 19);
		contentPane.add(txtCorreo);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(858, 484, 96, 33);
		contentPane.add(btnRegistrarse);

		txtrSeAadiran = new JTextArea();
		txtrSeAadiran.setEditable(false);
		txtrSeAadiran.setText(
				"se añadiran 300 monedas una \r\nvez se halla registrado, una cierta \r\ncantidad de monedas se renovaran \r\ndiariamente");
		txtrSeAadiran.setBounds(429, 405, 293, 76);
		contentPane.add(txtrSeAadiran);

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
