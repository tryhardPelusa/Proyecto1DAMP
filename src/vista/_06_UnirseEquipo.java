/**
 * @author Daniel
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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class _06_UnirseEquipo extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
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
	private JTextField textFieldCodigoEquipo;

	public _06_UnirseEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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

		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

		btnMiCuenta = new JButton("Mi cuenta");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiCuenta.setBounds(873, 19, 109, 23);
		contentPane_1.add(btnMiCuenta);

		btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignOut.setBounds(873, 53, 109, 23);
		contentPane_1.add(btnSignOut);
		
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JLabel lblCodigoEquipo = new JLabel("Introduce el ID del equipo:");
		lblCodigoEquipo.setBounds(101, 148, 202, 14);
		contentPane_1.add(lblCodigoEquipo);
		
		textFieldCodigoEquipo = new JTextField();
		textFieldCodigoEquipo.setBounds(101, 173, 127, 20);
		contentPane_1.add(textFieldCodigoEquipo);
		textFieldCodigoEquipo.setColumns(10);
		
		JButton btnUnirse = new JButton("Unirme");
		btnUnirse.setBackground(new Color(0, 128, 255));
		btnUnirse.setBounds(125, 204, 89, 23);
		contentPane_1.add(btnUnirse);
		
		JLabel lblImagen1 = new JLabel("");
		lblImagen1.setIcon(new ImageIcon(_06_UnirseEquipo.class.getResource("/img/el-equipo-de-f\u00FAtbol-del-deporte-con-el-entrenador-agrupe-la-foto-76609484.jpg")));
		lblImagen1.setBounds(416, 79, 269, 185);
		contentPane_1.add(lblImagen1);
		
		JLabel lblImagen2 = new JLabel("");
		lblImagen2.setIcon(new ImageIcon(_06_UnirseEquipo.class.getResource("/img/istockphoto-1161534890-612x612.jpg")));
		lblImagen2.setBounds(693, 265, 269, 185);
		contentPane_1.add(lblImagen2);
		
		JLabel lblNewLabel = new JLabel("Aqu\u00ED Aparecer\u00E1 si se ha podido unir correctamente al equipo ");
		lblNewLabel.setBounds(36, 315, 375, 125);
		contentPane_1.add(lblNewLabel);
	}
}
