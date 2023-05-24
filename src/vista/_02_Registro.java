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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import controlador.Controlador;
import modelo.Modelo;

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
	private JLabel lblApellido1;
	private JLabel lblNombre;
	private JLabel lblUsuario;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JTextArea monedas;
	private JTextField txtApellido1;
	private JDateChooser dateNacimiento;
	private JLabel lblBarraMoverVentana;
	private int xMouse, yMouse;
	private JLabel lblBtnCerrar;
	private JLabel lblBtnMinimizar;
	private JLabel lblApellido2;
	private JTextField txtApellido2;

	// Constructor
	public _02_Registro() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);;
		setSize(1007, 536);
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
		txtUser.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}
		});
		txtUser.setForeground(new Color(255, 255, 255));
		txtUser.setBackground(new Color(0, 128, 192));
		txtUser.setBounds(110, 214, 217, 20);
		background.add(txtUser);
		txtUser.setColumns(10);

		txtPwd = new JPasswordField();
		txtPwd.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}
		});
		txtPwd.setForeground(new Color(255, 255, 255));
		txtPwd.setBackground(new Color(0, 128, 192));
		txtPwd.setBounds(110, 254, 217, 20);
		background.add(txtPwd);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setEnabled(false);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miControlador.registro()) {
					miControlador.nuevaVentana(16);
					txtUser.setText("");
					txtPwd.setText("");
					dateNacimiento.setDate(null);
					txtCorreo.setText("");
					txtNombre.setText("");
					txtApellido1.setText("");
					txtApellido2.setText("");
				} else {
					miControlador.nuevaVentana(15);
					txtUser.setText("");
					txtPwd.setText("");
					txtCorreo.setText("");
				}
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
		txtNombre.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}
		});
		txtNombre.setForeground(Color.WHITE);
		txtNombre.setColumns(10);
		txtNombre.setBackground(new Color(0, 128, 192));
		txtNombre.setBounds(498, 219, 217, 20);
		background.add(txtNombre);

		lblApellido1 = new JLabel("APELLIDO1*:");
		lblApellido1.setFont(new Font("Britannic Bold", Font.PLAIN, 17));
		lblApellido1.setBounds(398, 252, 183, 29);
		background.add(lblApellido1);

		dateNacimiento = new JDateChooser();
		dateNacimiento.setBounds(110, 301, 217, 20);
		background.add(dateNacimiento);

		lblCorreo = new JLabel("CORREO* :");
		lblCorreo.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblCorreo.setBounds(10, 331, 141, 29);
		background.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}
		});
		txtCorreo.setForeground(Color.WHITE);
		txtCorreo.setColumns(10);
		txtCorreo.setBackground(new Color(0, 128, 192));
		txtCorreo.setBounds(110, 338, 217, 20);
		background.add(txtCorreo);

		monedas = new JTextArea();
		monedas.setText(
				"Se a\u00F1adiran 50 monedas una vez se halla registrado");

		monedas.setBackground(new Color(0, 128, 192));
		monedas.setText(
				"se a\u00F1adiran 300 monedas una \r\nvez se halla registrado, una cierta \r\ncantidad de monedas se renovaran \r\ndiariamente");
		monedas.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		monedas.setBounds(259, 408, 238, 78);
		background.add(monedas);

		txtApellido1 = new JTextField();
		txtApellido1.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				btnRegistrarse.setEnabled(miModelo.comprobarTodosRellenos(txtNombre.getText().isEmpty(),
						txtCorreo.getText().isEmpty(), txtUser.getText().isEmpty(), txtPwd.getPassword().length,
						txtApellido1.getText().isEmpty()));

			}
		});
		txtApellido1.setForeground(Color.WHITE);
		txtApellido1.setColumns(10);
		txtApellido1.setBackground(new Color(0, 128, 192));
		txtApellido1.setBounds(498, 259, 218, 20);
		background.add(txtApellido1);

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

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(725, 0, 283, 537);
		background.add(lblFondo);

		JTextArea txtrFechaDeNacimiento = new JTextArea();
		txtrFechaDeNacimiento.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
		txtrFechaDeNacimiento.setBackground(new Color(0, 128, 192));
		txtrFechaDeNacimiento.setText("FECHA DE\r\n NACIMIENTO * :");
		txtrFechaDeNacimiento.setBounds(10, 287, 98, 78);
		background.add(txtrFechaDeNacimiento);

		JTextArea txtrContraSea = new JTextArea();
		txtrContraSea.setText("CONTRASE\u00D1A*:");
		txtrContraSea.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
		txtrContraSea.setBackground(new Color(0, 128, 192));
		txtrContraSea.setBounds(10, 253, 98, 78);
		background.add(txtrContraSea);

		txtApellido2 = new JTextField();
		txtApellido2.setForeground(Color.WHITE);
		txtApellido2.setColumns(10);
		txtApellido2.setBackground(new Color(0, 128, 192));
		txtApellido2.setBounds(498, 298, 217, 20);
		background.add(txtApellido2);

		lblApellido2 = new JLabel("APELLIDO2:");
		lblApellido2.setFont(new Font("Britannic Bold", Font.PLAIN, 17));
		lblApellido2.setBounds(398, 292, 183, 29);
		background.add(lblApellido2);

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

	public String getNombre() {
		return txtNombre.getText();
	}

	public String getApellido1() {
		return txtApellido1.getText();
	}

	public String getApellido2() {
		return txtApellido2.getText();
	}

	public String getCorreo() {
		return txtCorreo.getText();
	}

	public String getPwd() {
		return String.valueOf(txtPwd.getPassword());
	}

	public String getfecha() {
		return dateNacimiento.getDateFormatString();
	}

	public String getUser() {
		return txtUser.getText();
	}
}
