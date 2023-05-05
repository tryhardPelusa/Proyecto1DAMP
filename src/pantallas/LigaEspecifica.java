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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class LigaEspecifica extends JFrame {

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
	private JLabel lblNombreLiga;
	private JButton btnVerEquipo;
	private JButton btnApostar;
	private JButton btnModificar;
	private JTable tableClasificacion;
	private JTable tableCalendario;
	private JTabbedPane tabbedPane;
	private JPanel panelClasificacion;
	private JPanel panelCalendario;
	private JScrollPane scrollPaneClasificacion;
	private JScrollPane scrollPaneCalendario;

	public LigaEspecifica() {
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

		lblNombreLiga = new JLabel("Liga DAM U-Tad");
		lblNombreLiga.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreLiga.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNombreLiga.setBounds(238, 19, 372, 83);
		contentPane.add(lblNombreLiga);

		btnVerEquipo = new JButton("Ver equipo");
		btnVerEquipo.setBounds(717, 174, 109, 23);
		contentPane.add(btnVerEquipo);

		btnApostar = new JButton("Apostar");
		btnApostar.setBounds(717, 208, 109, 23);
		contentPane.add(btnApostar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(717, 242, 109, 23);
		contentPane.add(btnModificar);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(225, 126, 429, 206);
		contentPane.add(tabbedPane);

		panelClasificacion = new JPanel();
		tabbedPane.addTab("Clasificacion", null, panelClasificacion, null);
		panelClasificacion.setLayout(null);

		scrollPaneClasificacion = new JScrollPane();
		scrollPaneClasificacion.setBounds(0, 0, 424, 178);
		panelClasificacion.add(scrollPaneClasificacion);

		tableClasificacion = new JTable();
		tableClasificacion.setModel(new DefaultTableModel(
			new Object[][] {
				{"Real Madrid", 12, 5, 4, 1, 14, 5},
				{"Barcelona", 10, 5, 3, 1, 12, 6},
				{"Cordoba", 8, 5, 2, 3, 10, 9},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Equipo", "Puntos", "PJ", "PG", "PP", "GF", "GC"
			}
		));
		scrollPaneClasificacion.setViewportView(tableClasificacion);

		panelCalendario = new JPanel();
		tabbedPane.addTab("Calendario", null, panelCalendario, null);
		panelCalendario.setLayout(null);

		scrollPaneCalendario = new JScrollPane();
		scrollPaneCalendario.setBounds(0, 0, 424, 178);
		panelCalendario.add(scrollPaneCalendario);

		tableCalendario = new JTable();
		tableCalendario.setModel(new DefaultTableModel(
			new Object[][] {
				{"2023-05-10", "Real Madrid", "Valencia", "Pista U-Tad"},
				{"2023-05-11", "Barcelona", "Cadiz", "Camp Nou"},
				{"2023-05-12", "Valencia", "Sevilla", "Old Trafford"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Fecha", "Equipo Local", "Equipo Visitante", "Sede"
			}
		));
		scrollPaneCalendario.setViewportView(tableCalendario);
	}
}
