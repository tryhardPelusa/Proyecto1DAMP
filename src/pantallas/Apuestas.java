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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

public class Apuestas extends JFrame {

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
	private JScrollPane scrollPaneLiga;
	private JTable tblLiga;
	private DefaultTableModel modelo;
	private JLabel lblLiga;
	private JLabel lblJornada;
	private JSeparator separatorLeft;
	private JSeparator separatorRight;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblEquipo;
	private JLabel lblEquipo_1;
	private JCheckBox chckbxEquipo;
	private JCheckBox chckbxEquipo_1;
	private JSpinner spinner;
	private JSeparator separator_Hor;
	private JLabel lblEquipo_2;
	private JLabel lblEquipo_3;
	private JCheckBox chckbxEquipo_2;
	private JCheckBox chckbxEquipo_3;
	private JSpinner spinner_1;
	private JSeparator separator_Hor_1;
	private JLabel lblEquipo_4;
	private JLabel lblEquipo_5;
	private JCheckBox chckbxEquipo_4;
	private JCheckBox chckbxEquipo_5;
	private JSpinner spinner_2;
	private JSeparator separator_Hor_2;
	private JLabel lblEquipo_6;
	private JLabel lblEquipo_7;
	private JCheckBox chckbxEquipo_6;
	private JCheckBox chckbxEquipo_7;
	private JSpinner spinner_3;
	private JSeparator separator_Hor_3;
	private JScrollPane scrollPane_Total;
	private JPanel panel_Total;
	private JLabel lblApuesta;
	private JLabel lblRealMadridtokens;
	private JSeparator separator_Hor_4;
	private JLabel lblAlmeriagetafe;
	private JLabel lblalmeriaTokens;
	private JSeparator separator_Hor_5;
	private JSeparator separator_Hor_6;
	private JLabel lblTotal;
	private JButton btnConfirmar;

	// Constructor
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
		modelo = new DefaultTableModel(new Object[][] { { "Barcelona", 82 }, { "Atlético Madrid", 69 },
				{ "Real Madrid", 68 }, { "Real Sociedad", 61 }, { "Villareal", 54 }, { "Betis", 49 },
				{ "Athletic", 47 }, { "Girona", 45 }, { "Osasuna", 44 }, { "Rayo Vallecano", 43 }, { "Sevilla", 42 },
				{ "Mallorca", 42 }, { "Celta de Vigo", 39 }, { "Almería", 36 }, { "Cádiz", 35 }, { "Valladolid", 35 },
				{ "Valencia", 34 }, { "Getafe", 34 }, { "Espanyol", 31 }, { "Elche", 16 }, },
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

		separatorRight = new JSeparator();
		separatorRight.setOrientation(SwingConstants.VERTICAL);
		separatorRight.setBounds(745, 84, 8, 418);
		contentPane.add(separatorRight);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(313, 53, 89, 23);
		contentPane.add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(614, 53, 89, 23);
		contentPane.add(btnSiguiente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 86, 442, 418);
		contentPane.add(scrollPane);

		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		lblEquipo = new JLabel("Real Madrid");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo.setBounds(24, 32, 109, 23);
		panel.add(lblEquipo);

		lblEquipo_1 = new JLabel("Barcelona");
		lblEquipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo_1.setBounds(325, 32, 91, 23);
		panel.add(lblEquipo_1);

		chckbxEquipo = new JCheckBox("");
		chckbxEquipo.setSelected(true);
		chckbxEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo.setBounds(122, 32, 28, 23);
		panel.add(chckbxEquipo);

		chckbxEquipo_1 = new JCheckBox("");
		chckbxEquipo_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo_1.setBounds(300, 32, 28, 23);
		panel.add(chckbxEquipo_1);

		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(120), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner.setBounds(191, 35, 65, 20);
		panel.add(spinner);

		separator_Hor = new JSeparator();
		separator_Hor.setBounds(71, 87, 288, 2);
		panel.add(separator_Hor);

		lblEquipo_2 = new JLabel("Almeria");
		lblEquipo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo_2.setBounds(24, 120, 109, 23);
		panel.add(lblEquipo_2);

		lblEquipo_3 = new JLabel("Getafe");
		lblEquipo_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo_3.setBounds(325, 120, 91, 23);
		panel.add(lblEquipo_3);

		chckbxEquipo_2 = new JCheckBox("");
		chckbxEquipo_2.setSelected(true);
		chckbxEquipo_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo_2.setBounds(122, 120, 28, 23);
		panel.add(chckbxEquipo_2);

		chckbxEquipo_3 = new JCheckBox("");
		chckbxEquipo_3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo_3.setBounds(300, 120, 28, 23);
		panel.add(chckbxEquipo_3);

		spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_1.setBounds(191, 123, 65, 20);
		panel.add(spinner_1);

		separator_Hor_1 = new JSeparator();
		separator_Hor_1.setBounds(71, 175, 288, 2);
		panel.add(separator_Hor_1);

		lblEquipo_4 = new JLabel("Betis");
		lblEquipo_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo_4.setBounds(24, 215, 109, 23);
		panel.add(lblEquipo_4);

		lblEquipo_5 = new JLabel("Valencia");
		lblEquipo_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo_5.setBounds(325, 215, 91, 23);
		panel.add(lblEquipo_5);

		chckbxEquipo_4 = new JCheckBox("");
		chckbxEquipo_4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo_4.setBounds(122, 215, 28, 23);
		panel.add(chckbxEquipo_4);

		chckbxEquipo_5 = new JCheckBox("");
		chckbxEquipo_5.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo_5.setBounds(300, 215, 28, 23);
		panel.add(chckbxEquipo_5);

		spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_2.setBounds(191, 218, 65, 20);
		panel.add(spinner_2);

		separator_Hor_2 = new JSeparator();
		separator_Hor_2.setBounds(71, 270, 288, 2);
		panel.add(separator_Hor_2);

		lblEquipo_6 = new JLabel("Valladolid");
		lblEquipo_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo_6.setBounds(24, 311, 109, 23);
		panel.add(lblEquipo_6);

		lblEquipo_7 = new JLabel("Mallorca");
		lblEquipo_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEquipo_7.setBounds(325, 311, 91, 23);
		panel.add(lblEquipo_7);

		chckbxEquipo_6 = new JCheckBox("");
		chckbxEquipo_6.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo_6.setBounds(122, 311, 28, 23);
		panel.add(chckbxEquipo_6);

		chckbxEquipo_7 = new JCheckBox("");
		chckbxEquipo_7.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxEquipo_7.setBounds(300, 311, 28, 23);
		panel.add(chckbxEquipo_7);

		spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_3.setBounds(191, 314, 65, 20);
		panel.add(spinner_3);

		separator_Hor_3 = new JSeparator();
		separator_Hor_3.setBounds(71, 366, 288, 2);
		panel.add(separator_Hor_3);

		scrollPane_Total = new JScrollPane();
		scrollPane_Total.setBounds(763, 86, 223, 418);
		contentPane.add(scrollPane_Total);

		panel_Total = new JPanel();
		scrollPane_Total.setViewportView(panel_Total);
		panel_Total.setLayout(null);

		lblApuesta = new JLabel("Real Madrid - Barcelona");
		lblApuesta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApuesta.setBounds(10, 11, 201, 27);
		panel_Total.add(lblApuesta);

		lblRealMadridtokens = new JLabel("(Real Madrid) 120 tokens");
		lblRealMadridtokens.setVerticalAlignment(SwingConstants.TOP);
		lblRealMadridtokens.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRealMadridtokens.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRealMadridtokens.setBounds(10, 40, 201, 27);
		panel_Total.add(lblRealMadridtokens);

		separator_Hor_4 = new JSeparator();
		separator_Hor_4.setBounds(20, 65, 183, 8);
		panel_Total.add(separator_Hor_4);

		lblAlmeriagetafe = new JLabel("Almeria - Getafe");
		lblAlmeriagetafe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlmeriagetafe.setBounds(10, 78, 201, 27);
		panel_Total.add(lblAlmeriagetafe);

		lblalmeriaTokens = new JLabel("(Almeria) 50 tokens");
		lblalmeriaTokens.setVerticalAlignment(SwingConstants.TOP);
		lblalmeriaTokens.setHorizontalAlignment(SwingConstants.RIGHT);
		lblalmeriaTokens.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblalmeriaTokens.setBounds(10, 107, 201, 27);
		panel_Total.add(lblalmeriaTokens);

		separator_Hor_5 = new JSeparator();
		separator_Hor_5.setBounds(20, 132, 183, 8);
		panel_Total.add(separator_Hor_5);

		separator_Hor_6 = new JSeparator();
		separator_Hor_6.setForeground(new Color(0, 0, 0));
		separator_Hor_6.setBounds(10, 315, 201, 8);
		panel_Total.add(separator_Hor_6);

		lblTotal = new JLabel("TOTAL: 170 tokens");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(10, 334, 193, 23);
		panel_Total.add(lblTotal);

		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBounds(63, 368, 102, 37);
		panel_Total.add(btnConfirmar);

	}
}
