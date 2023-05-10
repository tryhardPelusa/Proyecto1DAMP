/**
 * @author Daniel
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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

import controlador.Controlador;
import modelo.Modelo;
import java.awt.Font;

public class _00_PaginaPrincipal extends JFrame implements Vista {
	private Controlador miControlador;
	private Modelo miModelo;

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
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JTable tableLigasPublicas;
	private JTable tableLigasPrivadas;
	private JScrollPane scrollPaneLigasPublicas;
	private JScrollPane scrollPaneLigasPrivadas;
	private JLabel lblBuscarLigas;
	private JLabel lblAnuncio;
	private JLabel lblPaginaPrincipal;
	private JLabel lblMisLigas;

	public _00_PaginaPrincipal() {
		setTitle("Pagina Principal");
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
		
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(247, 69, 89, 23);
				contentPane_1.add(btnBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(133, 69, 114, 20);
		contentPane_1.add(txtBuscar);
		txtBuscar.setColumns(10);

		lblBuscarLigas = new JLabel("Buscar Ligas:");
		lblBuscarLigas.setBounds(48, 72, 96, 14);
		contentPane_1.add(lblBuscarLigas);
		
		lblPaginaPrincipal = new JLabel("Pagina Principal");
		lblPaginaPrincipal.setFont(new Font("Kannada MN", Font.PLAIN, 30));
		lblPaginaPrincipal.setBounds(345, 4, 248, 42);
		contentPane_1.add(lblPaginaPrincipal);
		
		lblMisLigas = new JLabel("Mis Ligas");
		lblMisLigas.setFont(new Font("Kannada MN", Font.PLAIN, 15));
		lblMisLigas.setBounds(476, 91, 76, 42);
		contentPane_1.add(lblMisLigas);

		scrollPaneLigasPublicas = new JScrollPane();
		scrollPaneLigasPublicas.setBounds(48, 121, 389, 386);
		contentPane_1.add(scrollPaneLigasPublicas);

		tableLigasPublicas = new JTable();
		tableLigasPublicas.setModel(new DefaultTableModel(
				new Object[][] { { "Premiere League" }, { "Liga 123" }, { "Liga Santander" }, { "NBA" }, { "WNBA" },
						{ "Liga ABC" }, { "World Paddel Tour" }, { "Otra" }, { "Otra" }, { "Otra" }, },
				new String[] { "Ligas Públicas" }));
		tableLigasPublicas.setRowHeight(40);
		tableLigasPublicas.getTableHeader().setBackground(Color.CYAN);
		scrollPaneLigasPublicas.setViewportView(tableLigasPublicas);

		scrollPaneLigasPrivadas = new JScrollPane();
		scrollPaneLigasPrivadas.setBounds(476, 121, 224, 150);
		contentPane_1.add(scrollPaneLigasPrivadas);

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
		lblAnuncio.setBounds(734, 334, 271, 173);
		contentPane_1.add(lblAnuncio);

		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		JLabel lblLigaPublicas = new JLabel("Ligas P\u00FAblicas");
		lblLigaPublicas.setFont(new Font("Kannada MN", Font.PLAIN, 15));
		lblLigaPublicas.setBounds(48, 93, 114, 42);
		contentPane_1.add(lblLigaPublicas);
	}

	@Override
	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;

	}

	@Override
	public void setControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}
}
