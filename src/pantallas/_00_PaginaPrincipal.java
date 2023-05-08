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

public class _00_PaginaPrincipal extends JFrame {
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
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JTable tableLigasPublicas;
	private JTable tableLigasPrivadas;
	private JScrollPane scrollPaneLigasPublicas;
	private JScrollPane scrollPaneLigasPrivadas;
	private JLabel lblBuscarLigas;
	private JLabel lblAnuncio;

	public _00_PaginaPrincipal() {
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
		lblAnuncio.setIcon(new ImageIcon(_00_PaginaPrincipal.class.getResource("/img/publicidad2.png")));
		lblAnuncio.setBounds(792, 195, 187, 287);
		contentPane.add(lblAnuncio);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
