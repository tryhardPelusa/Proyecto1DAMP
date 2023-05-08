package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

/**
 * 
 * @author josem
 *
 */
public class _08_CrearEquipos extends JFrame {

	//Creamos las variables siguiendo las convenciones al nombrarlas
	private JPanel contentPane;
	private JMenuBar menuNavegacion;
	private JMenu mnMenuLigas;
	private JMenu mnMenuApuestas;
	private JMenu mnMenuEquipos;
	private JMenuItem mntmVerLigas;
	private JMenuItem mntmMisApuestas;
	private JMenuItem mntmUnirseEquipo;
	private JMenuItem mntmCrearEquipo;
	private JMenuItem mntmCrearLiga;
	private JMenuItem mntmUnirseLiga;
	private JMenuItem mntmApostar;
	private JButton btnMiCuenta;
	private JButton btnSignOut;
	private JLabel lblNuevoEquipo;
	private JLabel lblDeporte;
	private JLabel lblEstadio;
	private JLabel lblNombreEquipo;
	private JTextField txtEquipo;
	private JTextField txtEstadio;
	private JTextField txtDeporte;
	private JButton btnCrear;

	public _08_CrearEquipos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);

		//Crea el menu de navegacion
		menuNavegacion = new JMenuBar();
		setJMenuBar(menuNavegacion);

		//Agrega pestanha del menu Ligas
		mnMenuLigas = new JMenu("Ligas");
		menuNavegacion.add(mnMenuLigas);

		//Agrega opcion del deplegable de "Ligas"
		mntmVerLigas = new JMenuItem("Ver ligas");
		mnMenuLigas.add(mntmVerLigas);

		//Agrega opcion del deplegable de "Ligas"
		mntmCrearLiga = new JMenuItem("Crear liga");
		mnMenuLigas.add(mntmCrearLiga);

		//Agrega opcion del deplegable de "Ligas"
		mntmUnirseLiga = new JMenuItem("Unirse a liga");
		mnMenuLigas.add(mntmUnirseLiga);

		//Agrega opcion del menu, pestanha "Apuestas"
		mnMenuApuestas = new JMenu("Apuestas");
		menuNavegacion.add(mnMenuApuestas);

		//Agrega items a la opcion del menu "Apuestas"
		mntmMisApuestas = new JMenuItem("Mis apuestas");
		mnMenuApuestas.add(mntmMisApuestas);
		
		mntmApostar = new JMenuItem("Apostar");
		mnMenuApuestas.add(mntmApostar);

		//Crea pestanha equipos
		mnMenuEquipos = new JMenu("Equipos");
		menuNavegacion.add(mnMenuEquipos);

		//Crea el desplegable de "Equipos"
		mntmUnirseEquipo = new JMenuItem("Unirse a equipo");
		mnMenuEquipos.add(mntmUnirseEquipo);

		mntmCrearEquipo = new JMenuItem("Crear equipo");
		mnMenuEquipos.add(mntmCrearEquipo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//Creamos el boton
		btnMiCuenta = new JButton("Mi cuenta");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiCuenta.setBounds(873, 19, 109, 23);
		contentPane.add(btnMiCuenta);

		//Crea el boton "Sign out"
		btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignOut.setBounds(873, 53, 109, 23);
		contentPane.add(btnSignOut);
		
		//Crea el texto que muestra la pantalla
		lblNuevoEquipo = new JLabel("Nuevo Equipo");
		lblNuevoEquipo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNuevoEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoEquipo.setBounds(307, 19, 437, 87);
		contentPane.add(lblNuevoEquipo);
		
		//Crea el texto que indica lo que se necesita introducir en el campo vacio
		lblNombreEquipo = new JLabel("Nombre Equipo");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreEquipo.setBounds(225, 147, 109, 45);
		contentPane.add(lblNombreEquipo);
		
		//Crea el texto que indica lo que se necesita introducir en el campo vacio
		lblEstadio = new JLabel("Estadio");
		lblEstadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadio.setBounds(225, 196, 85, 45);
		contentPane.add(lblEstadio);
		
		//Crea el texto que indica lo que se necesita introducir en el campo vacio
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDeporte.setBounds(225, 246, 94, 45);
		contentPane.add(lblDeporte);
		
		//Boton para terminar de crear el equipo
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(478, 331, 109, 23);
		contentPane.add(btnCrear);
		
		//Crea el cajon vacio para introducir el nombre del equipo
		txtEquipo = new JTextField();
		txtEquipo.setBounds(365, 159, 325, 23);
		contentPane.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		//Crea el cajon vacio para introducir el nombre del estadio o lugar donde se va a realizar el partido
		txtEstadio = new JTextField();
		txtEstadio.setColumns(10);
		txtEstadio.setBounds(365, 208, 325, 23);
		contentPane.add(txtEstadio);
		
		//Crea el cajon vacio para introducir el deporte del equipo
		txtDeporte = new JTextField();
		txtDeporte.setColumns(10);
		txtDeporte.setBounds(365, 258, 325, 23);
		contentPane.add(txtDeporte);
	}
}