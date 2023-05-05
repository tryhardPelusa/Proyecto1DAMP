package pantallas;

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

public class CrearEquipo extends JFrame {

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

	public CrearEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);

		menuNavegacion = new JMenuBar();
		setJMenuBar(menuNavegacion);

		mnMenuLigas = new JMenu("Ligas");
		menuNavegacion.add(mnMenuLigas);

		mntmVerLigas = new JMenuItem("Ver ligas");
		mnMenuLigas.add(mntmVerLigas);

		mntmCrearLiga = new JMenuItem("Crear liga");
		mnMenuLigas.add(mntmCrearLiga);

		mntmUnirseLiga = new JMenuItem("Unirse a liga");
		mnMenuLigas.add(mntmUnirseLiga);

		mnMenuApuestas = new JMenu("Apuestas");
		menuNavegacion.add(mnMenuApuestas);

		mntmMisApuestas = new JMenuItem("Mis apuestas");
		mnMenuApuestas.add(mntmMisApuestas);

		mntmApostar = new JMenuItem("Apostar");
		mnMenuApuestas.add(mntmApostar);

		mnMenuEquipos = new JMenu("Equipos");
		menuNavegacion.add(mnMenuEquipos);

		mntmUnirseEquipo = new JMenuItem("Unirse a equipo");
		mnMenuEquipos.add(mntmUnirseEquipo);

		mntmCrearEquipo = new JMenuItem("Crear equipo");
		mnMenuEquipos.add(mntmCrearEquipo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		
		lblNuevoEquipo = new JLabel("Nuevo Equipo");
		lblNuevoEquipo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNuevoEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoEquipo.setBounds(307, 19, 437, 87);
		contentPane.add(lblNuevoEquipo);
		
		lblNombreEquipo = new JLabel("Nombre Equipo");
		lblNombreEquipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombreEquipo.setBounds(225, 147, 109, 45);
		contentPane.add(lblNombreEquipo);
		
		lblEstadio = new JLabel("Estadio");
		lblEstadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadio.setBounds(225, 196, 85, 45);
		contentPane.add(lblEstadio);
		
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDeporte.setBounds(225, 246, 94, 45);
		contentPane.add(lblDeporte);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(478, 331, 109, 23);
		contentPane.add(btnCrear);
		
		txtEquipo = new JTextField();
		txtEquipo.setBounds(365, 159, 325, 23);
		contentPane.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		txtEstadio = new JTextField();
		txtEstadio.setColumns(10);
		txtEstadio.setBounds(365, 208, 325, 23);
		contentPane.add(txtEstadio);
		
		txtDeporte = new JTextField();
		txtDeporte.setColumns(10);
		txtDeporte.setBounds(365, 258, 325, 23);
		contentPane.add(txtDeporte);
	}
}