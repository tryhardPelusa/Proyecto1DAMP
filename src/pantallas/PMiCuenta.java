/**
 * @author Guillermo Callizaya
 */

package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

//Clase principal PMiCuenta que extiende de JFrame
public class PMiCuenta extends JFrame {
	// Declaración de componentes de la interfaz
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido1;
	private JTextField txtApellido_1;
	private JLabel lblApellido2;
	private JTextField txtApellido_2;
	private JLabel lblCorreo;
	private JTextField txtCorreoElectronico;
	private JLabel lblPwd;
	private JTextField txtPwd;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblFecha;
	private JButton btnCambiar;
	private JDateChooser dateCalendario;
	private JMenuBar menuNavegacion;
	private JMenu mnLigas;
	private JMenu mnApuestas;
	private JMenu mnEquipos;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JButton btnMiCuenta;
	private JButton btnSignOut;

	// Constructor de la clase PMiCuenta
	public PMiCuenta() {
		// Configuración básica de la ventana
		setTitle("Pagina Registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Creacion de un JmenuBar donde tendremos todos los items
		menuNavegacion = new JMenuBar();
		setJMenuBar(menuNavegacion);

		mnLigas = new JMenu("Ligas");
		menuNavegacion.add(mnLigas);

		mntmNewMenuItem = new JMenuItem("Ver ligas");
		mnLigas.add(mntmNewMenuItem);

		mntmNewMenuItem_5 = new JMenuItem("Crear liga");
		mnLigas.add(mntmNewMenuItem_5);

		mntmNewMenuItem_6 = new JMenuItem("Unirse a liga");
		mnLigas.add(mntmNewMenuItem_6);

		mnApuestas = new JMenu("Apuestas");
		menuNavegacion.add(mnApuestas);

		mntmNewMenuItem_1 = new JMenuItem("Mis apuestas");
		mnApuestas.add(mntmNewMenuItem_1);

		mntmNewMenuItem_7 = new JMenuItem("Apostar");
		mnApuestas.add(mntmNewMenuItem_7);

		mnEquipos = new JMenu("Equipos");
		menuNavegacion.add(mnEquipos);

		mntmNewMenuItem_3 = new JMenuItem("Unirse a equipo");
		mnEquipos.add(mntmNewMenuItem_3);

		mntmNewMenuItem_4 = new JMenuItem("Crear equipo");
		mnEquipos.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Creamos un Button de mi cuenta para acceder al usuario
		btnMiCuenta = new JButton("Mi cuenta");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiCuenta.setBounds(873, 19, 109, 23);
		contentPane.add(btnMiCuenta);
		// Creamos un buttom donde hara la funcion de salir cerrar sesion
		btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignOut.setBounds(873, 53, 109, 23);
		contentPane.add(btnSignOut);

		// Crea y agrega un JLabel para mostrar el título "Mi cuenta"
		JLabel lblMiCuenta = new JLabel("Mi cuenta");
		lblMiCuenta.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblMiCuenta.setBounds(440, 66, 158, 36);
		contentPane.add(lblMiCuenta);
		// Crea y agrega un JLabel para mostrar el texto "Usuario:"
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsuario.setBounds(143, 138, 86, 25);
		contentPane.add(lblUsuario);
		// Establece el texto inicial del campo de texto a "Usuario"
		txtUsuario = new JTextField();
		txtUsuario.setText("Usuario");
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(232, 135, 180, 36);
		contentPane.add(txtUsuario);
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
		txtPwd = new JTextField();
		txtPwd.setText("Password");
		txtPwd.setColumns(10);
		txtPwd.setBounds(674, 138, 180, 36);
		contentPane.add(txtPwd);
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
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
