/*
 * @Author Javier Turienzo
 */
package pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	// Atributos
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
	private JLabel lbl_Iniciar_Sesion;
	private JTextField txtUsr;
	private JLabel lblUsr;
	private JPasswordField passwordField;
	private JLabel lblRestaurarPwd;

	// Constructor
	public Login() {
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

		lbl_Iniciar_Sesion = new JLabel("Iniciar Sesion");
		lbl_Iniciar_Sesion.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Iniciar_Sesion.setFont(new Font("Tahoma", Font.BOLD, 35));
		lbl_Iniciar_Sesion.setBounds(368, 47, 271, 93);
		contentPane.add(lbl_Iniciar_Sesion);

		txtUsr = new JTextField();
		txtUsr.setBounds(465, 204, 164, 20);
		contentPane.add(txtUsr);
		txtUsr.setColumns(10);

		lblUsr = new JLabel("Usuario");
		lblUsr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsr.setBounds(368, 204, 98, 20);
		contentPane.add(lblUsr);

		JLabel lblPwd = new JLabel("Contrase\u00F1a");
		lblPwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPwd.setBounds(368, 245, 98, 20);
		contentPane.add(lblPwd);

		passwordField = new JPasswordField();
		passwordField.setBounds(465, 247, 164, 20);
		contentPane.add(passwordField);

		lblRestaurarPwd = new JLabel("\u00BFHas olvidado la contrase\u00F1a?");
		lblRestaurarPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblRestaurarPwd.setForeground(new Color(0, 118, 236));
		lblRestaurarPwd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRestaurarPwd.setBounds(368, 276, 164, 14);
		contentPane.add(lblRestaurarPwd);

		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAcceder.setBounds(459, 313, 89, 23);
		contentPane.add(btnAcceder);

		JLabel lblNewLabel_1 = new JLabel("\u00BFNo tienes cuenta a\u00FAn?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(416, 367, 176, 23);
		contentPane.add(lblNewLabel_1);

		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrearCuenta.setBounds(368, 401, 122, 23);
		contentPane.add(btnCrearCuenta);

		JButton btnInvitado = new JButton("Invitado");
		btnInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInvitado.setBounds(509, 401, 98, 23);
		contentPane.add(btnInvitado);
	}
}
