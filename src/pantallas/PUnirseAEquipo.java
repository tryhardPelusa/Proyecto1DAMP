/**
 * @author Daniel
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
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PUnirseAEquipo extends JFrame {

	// Atributos
	private JPanel contentPane;
	private JMenuBar menuNavegacion;
	private JMenu mnLigas;
	private JMenu mnApuestas;
	private JMenu mnEquipos;
	private JMenuItem mntmVerLigas;
	private JMenuItem mntmMisApuestas;
	private JMenuItem mntmUnirseaEquipo;
	private JMenuItem mntmCrearEquipo;
	private JMenuItem mntmCrearLiga;
	private JMenuItem mntmUnirseALiga;
	private JMenuItem mntmApostar;
	private JButton btnMiCuenta;
	private JButton btnSignOut;
	private JTextField textFieldCodigoEquipo;

	// Constructor
	public PUnirseAEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		menuNavegacion = new JMenuBar();
		setJMenuBar(menuNavegacion);
		mnLigas = new JMenu("Ligas");
		menuNavegacion.add(mnLigas);

		mntmVerLigas = new JMenuItem("Ver ligas");
		mnLigas.add(mntmVerLigas);

		mntmCrearLiga = new JMenuItem("Crear liga");
		mnLigas.add(mntmCrearLiga);

		mntmUnirseALiga = new JMenuItem("Unirse a liga");
		mnLigas.add(mntmUnirseALiga);

		mnApuestas = new JMenu("Apuestas");
		menuNavegacion.add(mnApuestas);

		mntmMisApuestas = new JMenuItem("Mis apuestas");
		mnApuestas.add(mntmMisApuestas);

		mntmApostar = new JMenuItem("Apostar");
		mnApuestas.add(mntmApostar);

		mnEquipos = new JMenu("Equipos");
		menuNavegacion.add(mnEquipos);

		mntmUnirseaEquipo = new JMenuItem("Unirse a equipo");
		mnEquipos.add(mntmUnirseaEquipo);

		mntmCrearEquipo = new JMenuItem("Crear equipo");
		mnEquipos.add(mntmCrearEquipo);

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
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoEquipo = new JLabel("Introduce el ID del equipo:");
		lblCodigoEquipo.setBounds(101, 148, 202, 14);
		contentPane.add(lblCodigoEquipo);
		
		textFieldCodigoEquipo = new JTextField();
		textFieldCodigoEquipo.setBounds(101, 173, 127, 20);
		contentPane.add(textFieldCodigoEquipo);
		textFieldCodigoEquipo.setColumns(10);
		
		JButton btnUnirse = new JButton("Unirme");
		btnUnirse.setBackground(new Color(0, 128, 255));
		btnUnirse.setBounds(125, 204, 89, 23);
		contentPane.add(btnUnirse);
		
		JLabel lblImagen1 = new JLabel("");
		lblImagen1.setIcon(new ImageIcon(PUnirseAEquipo.class.getResource("/img/el-equipo-de-f\u00FAtbol-del-deporte-con-el-entrenador-agrupe-la-foto-76609484.jpg")));
		lblImagen1.setBounds(416, 79, 269, 185);
		contentPane.add(lblImagen1);
		
		JLabel lblImagen2 = new JLabel("");
		lblImagen2.setIcon(new ImageIcon(PUnirseAEquipo.class.getResource("/img/istockphoto-1161534890-612x612.jpg")));
		lblImagen2.setBounds(693, 265, 269, 185);
		contentPane.add(lblImagen2);
		
		JLabel lblNewLabel = new JLabel("Aqu\u00ED Aparecer\u00E1 si se ha podido unir correctamente al equipo ");
		lblNewLabel.setBounds(36, 315, 375, 125);
		contentPane.add(lblNewLabel);
	}
}
