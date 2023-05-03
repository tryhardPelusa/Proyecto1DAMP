package pantallas;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class PPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox<Object> comboBoxLigas;
	private JComboBox<Object> comboBoxApuestas;
	private JComboBox<Object> comboBoxEquipos;
	private JButton btnMiCuenta;
	private JButton btnSignOut;
	private JPanel panelLigasPublicas;
	private JPanel panelLigasPrivadas;
	private JTable tableLigasPublicas;
	private JTable tableLigasPrivadas;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JLabel lblLigasPublicas;
	private JLabel lblLigasPrivadas;
	private JTable table;

	public static void main(String[] args) {

		PPrincipal frame = new PPrincipal();
		frame.setVisible(true);

	}

	public PPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(62, 11, 885, 35);
		contentPane.add(panel);
		panel.setLayout(null);

		comboBoxLigas = new JComboBox<Object>();
		comboBoxLigas.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "Ligas", "Crear Liga", "Unirse a Liga", "Ver Ligas" }));
		comboBoxLigas.setBounds(10, 0, 96, 35);
		panel.add(comboBoxLigas);

		comboBoxApuestas = new JComboBox<Object>();
		comboBoxApuestas
				.setModel(new DefaultComboBoxModel<Object>(new String[] { "Apuestas", "Mis Apuestas", "Apostar" }));
		comboBoxApuestas.setBounds(116, 0, 96, 35);
		panel.add(comboBoxApuestas);

		comboBoxEquipos = new JComboBox<Object>();
		comboBoxEquipos.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "Equipos", "Unirse a equipo", "Crear Equipo" }));
		comboBoxEquipos.setBounds(222, 0, 96, 35);
		panel.add(comboBoxEquipos);

		btnMiCuenta = new JButton("Mi Cuenta");
		btnMiCuenta.setBounds(678, 0, 96, 35);
		panel.add(btnMiCuenta);

		btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(779, 0, 96, 35);
		panel.add(btnSignOut);

		panelLigasPublicas = new JPanel();
		panelLigasPublicas.setBounds(62, 122, 287, 355);
		contentPane.add(panelLigasPublicas);
		panelLigasPublicas.setLayout(null);

		tableLigasPublicas = new JTable();
		tableLigasPublicas.setModel(new DefaultTableModel(
			new Object[][] {
				{"Premiere Legue"},
				{"Liga Santander"},
				{"Liga 123"},
				{"NBA"},
				{"Liga ABC"},
				{"WNBA"},
				{"Otra"},
				{"Otra"},
				{"Otra"},
				{"Otra"},
			},
				new String[] { "Ligas Públicas" }
		));
		tableLigasPublicas.setBounds(0, 0, 287, 355);
		tableLigasPublicas.setRowHeight(40);
		panelLigasPublicas.add(tableLigasPublicas);

		panelLigasPrivadas = new JPanel();
		panelLigasPrivadas.setBounds(388, 122, 287, 355);
		panelLigasPrivadas.setLayout(null);
		contentPane.add(panelLigasPrivadas);

		tableLigasPrivadas = new JTable();
		tableLigasPrivadas.setModel(new DefaultTableModel(
			new Object[][] {
				{"Pocholos CUP"},
				{"U-TAD League"},
				{"Copa Programación"},
				{"Torneo Ochio"},
			},
			new String[] {
				"Ligas Privadas"
			}
		));
		tableLigasPrivadas.setRowHeight(40);
		tableLigasPrivadas.setBounds(0, 0, 287, 355);
		panelLigasPrivadas.add(tableLigasPrivadas);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(792, 112, 96, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblBuscarLigas = new JLabel("Buscar Ligas:");
		lblBuscarLigas.setBounds(792, 90, 96, 14);
		contentPane.add(lblBuscarLigas);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(890, 111, 89, 23);
		contentPane.add(btnBuscar);
		
		lblLigasPublicas = new JLabel("Ligas P\u00FAblicas");
		lblLigasPublicas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLigasPublicas.setBounds(62, 97, 287, 23);
		contentPane.add(lblLigasPublicas);
		
		lblLigasPrivadas = new JLabel("Tus Ligas");
		lblLigasPrivadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLigasPrivadas.setBounds(389, 98, 286, 23);
		contentPane.add(lblLigasPrivadas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(724, 170, 176, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(table);
	}
}
