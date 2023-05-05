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
	private JLabel lblNewLabel;
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

		lblNewLabel = new JLabel("Iniciar Sesion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(368, 47, 271, 93);
		contentPane.add(lblNewLabel);

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
		btnCrearCuenta.setBounds(386, 401, 104, 23);
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
