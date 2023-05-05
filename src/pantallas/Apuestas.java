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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.Box;

public class Apuestas extends JFrame {

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
	private JScrollPane scrollPaneLiga;
	private JTable tblLiga;
	private DefaultTableModel modelo;
	private JLabel lblLiga;
	private JLabel lblJornada;
	private JSeparator separatorLeft;

	public static void main(String[] args) {

		Apuestas frame = new Apuestas();
		frame.setVisible(true);

	}

	public Apuestas() {

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

		lblLiga = new JLabel("Liga Santander");
		lblLiga.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiga.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLiga.setBounds(80, 54, 114, 19);
		contentPane.add(lblLiga);

		scrollPaneLiga = new JScrollPane();
		scrollPaneLiga.setBounds(40, 84, 195, 420);
		contentPane.add(scrollPaneLiga);

		tblLiga = new JTable();
		modelo = new DefaultTableModel(new Object[][] { { "Barcelona", 82 },
				{ "Atlético Madrid", 69 }, { "Real Madrid", 68 }, { "Real Sociedad", 61 }, { "Villareal", 54 },
				{ "Betis", 49 }, { "Athletic", 47 }, { "Girona", 45 }, { "Osasuna", 44 }, { "Rayo Vallecano", 43 },
				{ "Sevilla", 42 }, { "Mallorca", 42 }, { "Celta de Vigo", 39 }, { "Almería", 36 }, { "Cádiz", 35 },
				{ "Valladolid", 35 }, { "Valencia", 34 }, { "Getafe", 34 }, { "Espanyol", 31 }, { "Elche", 16 }, },
				new String[] { "Equipo", "Pts" });

		tblLiga.setModel(modelo);
		tblLiga.getColumnModel().getColumn(0).setPreferredWidth(100);
		tblLiga.getColumnModel().getColumn(1).setPreferredWidth(50);

		scrollPaneLiga.setViewportView(tblLiga);
		
		lblJornada = new JLabel("Jornada 7");
		lblJornada.setHorizontalAlignment(SwingConstants.CENTER);
		lblJornada.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblJornada.setBounds(441, 54, 126, 34);
		contentPane.add(lblJornada);
		
		separatorLeft = new JSeparator();
		separatorLeft.setOrientation(SwingConstants.VERTICAL);
		separatorLeft.setBounds(269, 86, 8, 418);
		contentPane.add(separatorLeft);
		
		

	}
}
