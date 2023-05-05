/**
 * @author Daniel
 */
package pantallas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class PPrincipal extends JFrame {
	// Atributos
	private JPanel contentPane;
	private JMenuBar menuNavegacion;
	private JMenu mnLigas;
	private JMenu mnApuestas;
	private JMenu mnEquipos;
	private JMenuItem mntmVerLigas;
	private JMenuItem mntmMisApuestas;
	private JMenuItem mntmUnirseEquipo;
	private JMenuItem mntmCrearEquipo;
	private JMenuItem mntmCrearLigas;
	private JMenuItem mntmUnirseALiga;
	private JMenuItem mntmApostar;
	private JButton btnMiCuenta;
	private JButton btnSignOut;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JTable tableLigasPublicas;
	private JTable tableLigasPrivadas;
	private JScrollPane scrollPaneLigasPublicas;
	private JScrollPane scrollPaneLigasPrivadas;
	private JLabel lblBuscarLigas;
	private JLabel lblAnuncio;

	// Constructor
	public PPrincipal() {
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

		mntmCrearLigas = new JMenuItem("Crear liga");
		mnLigas.add(mntmCrearLigas);

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

		mntmUnirseEquipo = new JMenuItem("Unirse a equipo");
		mnEquipos.add(mntmUnirseEquipo);

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

		txtBuscar = new JTextField();
		txtBuscar.setBounds(792, 112, 96, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		lblBuscarLigas = new JLabel("Buscar Ligas:");
		lblBuscarLigas.setBounds(792, 90, 96, 14);
		contentPane.add(lblBuscarLigas);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(890, 111, 89, 23);
		contentPane.add(btnBuscar);

		scrollPaneLigasPublicas = new JScrollPane();
		scrollPaneLigasPublicas.setBounds(48, 30, 315, 452);
		contentPane.add(scrollPaneLigasPublicas);

		tableLigasPublicas = new JTable();
		tableLigasPublicas.setModel(new DefaultTableModel(
				new Object[][] { { "Premiere League" }, { "Liga 123" }, { "Liga Santander" }, { "NBA" }, { "WNBA" },
						{ "Liga ABC" }, { "World Paddel Tour" }, { "Otra" }, { "Otra" }, { "Otra" }, },
				new String[] { "Ligas Públicas" }));
		tableLigasPublicas.setRowHeight(40);
		tableLigasPublicas.getTableHeader().setBackground(Color.CYAN);
		scrollPaneLigasPublicas.setViewportView(tableLigasPublicas);

		scrollPaneLigasPrivadas = new JScrollPane();
		scrollPaneLigasPrivadas.setBounds(412, 30, 315, 452);
		contentPane.add(scrollPaneLigasPrivadas);

		tableLigasPrivadas = new JTable();
		tableLigasPrivadas
				.setModel(
						new DefaultTableModel(
								new Object[][] { { "Pocholos Cup" }, { "Torneo Ochio" }, { "Programame Futbol" },
										{ "The coders League" }, { "U-TAD League" }, },
								new String[] { "Ligas Privadas" }));
		tableLigasPrivadas.setRowHeight(40);
		tableLigasPrivadas.getTableHeader().setBackground(Color.CYAN);
		scrollPaneLigasPrivadas.setViewportView(tableLigasPrivadas);

		lblAnuncio = new JLabel("");
		lblAnuncio.setIcon(new ImageIcon(PPrincipal.class.getResource("/img/publicidad2.png")));
		lblAnuncio.setBounds(792, 195, 187, 287);
		contentPane.add(lblAnuncio);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
