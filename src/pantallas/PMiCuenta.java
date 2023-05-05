/**
 * @author Guillermo Callizaya
 */

package pantallas;

//Importación de clases de Java
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

//Clase principal PMiCuenta que extiende de JFrame
public class PMiCuenta extends JFrame {
	// Declaración de componentes de la interfaz
	private JPanel contentPane;
	private JComboBox<Object> comboBoxLigas;
	private JComboBox<Object> comboBoxApuestas;
	private JComboBox<Object> comboBoxEquipos;
	private JButton btnMiCuenta;
	private JButton btnSignOut;
	private JLabel lblUsuario;
	private JTextField textField;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido1;
	private JTextField txtApellido_1;
	private JLabel lblApellido2;
	private JTextField txtApellido_2;
	private JLabel lblCorreo;
	private JTextField txtCorreoElectronico;
	private JLabel lblPwd;
	private JTextField textPwd;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblFecha;
	private JButton btnCambiar;
	private JPanel panel;
	private JDateChooser dateCalendario;

	// Constructor de la clase PMiCuenta
	public PMiCuenta() {
		// Configuración básica de la ventana
		setTitle("Pagina Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Crea y agrega un JLabel para mostrar el título "Mi cuenta"
		JLabel lblMiCuenta = new JLabel("Mi cuenta");
		lblMiCuenta.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblMiCuenta.setBounds(440, 66, 158, 36);
		contentPane.add(lblMiCuenta);
		// Crea un nuevo panel para mostrar la barra de navegación
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.CYAN);
		panel.setBounds(66, 17, 885, 35);
		contentPane.add(panel);
		// Crea y agrega un JComboBox para mostrar las diferentes opciones de "Ligas"
		comboBoxLigas = new JComboBox<Object>();
		comboBoxLigas.setModel(
				new DefaultComboBoxModel(new String[] { "Ligas", "Crear Liga", "Unirse a Liga", "Ver Ligas" }));
		comboBoxLigas.setBounds(10, 0, 96, 35);
		panel.add(comboBoxLigas);
		// Crea y agrega un JComboBox para mostrar las diferentes opciones de "Apuestas"
		comboBoxApuestas = new JComboBox<Object>();
		comboBoxApuestas.setModel(new DefaultComboBoxModel(new String[] { "Apuestas", "Mis Apuestas", "Apostar" }));
		comboBoxApuestas.setBounds(107, 0, 110, 35);
		panel.add(comboBoxApuestas);
		// Crea y agrega un JComboBox para mostrar las diferentes opciones de "Equipos"
		comboBoxEquipos = new JComboBox<Object>();
		comboBoxEquipos
				.setModel(new DefaultComboBoxModel(new String[] { "Equipos", "Unirse a equipo", "Crear Equipo" }));
		comboBoxEquipos.setBounds(215, 0, 103, 35);
		panel.add(comboBoxEquipos);
		// Crea y agrega un JButton para mostrar la opción "Mi Cuenta"
		btnMiCuenta = new JButton("Mi Cuenta");
		btnMiCuenta.setBounds(678, 0, 96, 35);
		panel.add(btnMiCuenta);
		// Crea y agrega un JButton para mostrar la opción "Sign Out"
		btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(779, 0, 96, 35);
		panel.add(btnSignOut);
		// Crea y agrega un JLabel para mostrar el texto "Usuario:"
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsuario.setBounds(143, 138, 86, 25);
		contentPane.add(lblUsuario);
		// Establece el texto inicial del campo de texto a "Usuario"
		textField = new JTextField();
		textField.setText("Usuario");
		textField.setColumns(10);
		textField.setBounds(232, 135, 180, 36);
		contentPane.add(textField);
		// Crea y agrega un JLabel para mostrar el texto "Nombre"
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNombre.setBounds(143, 202, 86, 25);
		contentPane.add(lblNombre);
		// Establece el texto inicial del campo de texto a "Nombre"
		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.setColumns(10);
		txtNombre.setBounds(232, 199, 180, 36);
		contentPane.add(txtNombre);
		// Crea y agrega un JLabel para mostrar el texto "Apellido"
		lblApellido1 = new JLabel("1\u00BA Apellido:");
		lblApellido1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblApellido1.setBounds(111, 264, 118, 25);
		contentPane.add(lblApellido1);
		// Establece el texto inicial del campo de texto a "Apellido"
		txtApellido_1 = new JTextField();
		txtApellido_1.setText("Apellido");
		txtApellido_1.setColumns(10);
		txtApellido_1.setBounds(232, 261, 180, 36);
		contentPane.add(txtApellido_1);
		// Crea y agrega un JLabel para mostrar el texto "Apellido2"
		lblApellido2 = new JLabel("2\u00BA Apellido");
		lblApellido2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblApellido2.setBounds(111, 328, 118, 25);
		contentPane.add(lblApellido2);
		// Establece el texto inicial del campo de texto a "Apellido2"
		txtApellido_2 = new JTextField();
		txtApellido_2.setText("Apellido");
		txtApellido_2.setColumns(10);
		txtApellido_2.setBounds(232, 325, 180, 36);
		contentPane.add(txtApellido_2);
		// Crea y agrega un JLabel para mostrar el texto "Correo"
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCorreo.setBounds(143, 395, 86, 25);
		contentPane.add(lblCorreo);
		// Establece el texto inicial del campo de texto a "Correo"
		txtCorreoElectronico = new JTextField();
		txtCorreoElectronico.setText("Correo electr\u00F3nico ");
		txtCorreoElectronico.setColumns(10);
		txtCorreoElectronico.setBounds(232, 392, 180, 36);
		contentPane.add(txtCorreoElectronico);
		// Crea y agrega un JLabel para mostrar el texto "Password"
		lblPwd = new JLabel("Password:");
		lblPwd.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPwd.setBounds(575, 141, 96, 25);
		contentPane.add(lblPwd);
		// Establece el texto inicial del campo de texto a "Password"
		textPwd = new JTextField();
		textPwd.setText("Password");
		textPwd.setColumns(10);
		textPwd.setBounds(674, 138, 180, 36);
		contentPane.add(textPwd);
		// Crea y agrega un JLabel para mostrar el texto "Telefono"
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTelefono.setBounds(575, 202, 96, 25);
		contentPane.add(lblTelefono);
		// Establece el texto inicial del campo de texto a "Telefono"
		txtTelefono = new JTextField();
		txtTelefono.setText("Telefono");
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(674, 199, 180, 36);
		contentPane.add(txtTelefono);
		// Crea y agrega un JLabel para mostrar el texto "FechadeNacimiento"
		lblFecha = new JLabel("Fecha Nacimiento:");
		lblFecha.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblFecha.setBounds(495, 267, 176, 25);
		contentPane.add(lblFecha);
		// Establece un button para cambiar los datos del usuario
		btnCambiar = new JButton("Cambiar datos");
		btnCambiar.setBackground(Color.BLUE);
		btnCambiar.setBounds(666, 397, 188, 29);
		contentPane.add(btnCambiar);
		// Creamo un JCalendar donde podremos seleccionar la fecha de nacimiento del
		// usuario
		dateCalendario = new JDateChooser();
		dateCalendario.setBounds(676, 267, 158, 26);
		contentPane.add(dateCalendario);
	}
}
