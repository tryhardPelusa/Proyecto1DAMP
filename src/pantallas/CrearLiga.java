package pantallas;


import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

public class CrearLiga extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox comboBoxLigas;
	private JComboBox comboBoxApuestas;
	private JComboBox comboBoxEquipos;
	private JButton btnMiCuenta;
	private JButton btnSignOut;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblNuevaLiga;
	private JLabel lblDeporte;
	private JTextField txtDeporte;
	private JLabel lblFecha;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAnyo;
	private JSpinner spinnerDia;
	private JSpinner spinnerMes;
	private JSpinner spinnerAnyo;
	private JLabel lblPrivacidad;
	private JRadioButton rdbtnPrivada;
	private JRadioButton rdbtnPublica;
	private ButtonGroup privacidad;
	private JLabel lblSede;
	private JTextField txtSede;
	private JCheckBox chckbxPremio;
	private JScrollPane scrollPanePremio;
	private JSeparator separator;

	public static void main(String[] args) {

		CrearLiga frame = new CrearLiga();
		frame.setVisible(true);

	}

	public CrearLiga() {
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

		comboBoxLigas = new JComboBox();
		comboBoxLigas.setModel(
				new DefaultComboBoxModel(new String[] { "Ligas", "Crear Liga", "Unirse a Liga", "Ver Ligas" }));
		comboBoxLigas.setBounds(10, 0, 96, 35);
		panel.add(comboBoxLigas);

		comboBoxApuestas = new JComboBox();
		comboBoxApuestas.setModel(new DefaultComboBoxModel(new String[] { "Apuestas", "Mis Apuestas", "Apostar" }));
		comboBoxApuestas.setBounds(116, 0, 96, 35);
		panel.add(comboBoxApuestas);

		comboBoxEquipos = new JComboBox();
		comboBoxEquipos
				.setModel(new DefaultComboBoxModel(new String[] { "Equipos", "Unirse a equipo", "Crear Equipo" }));
		comboBoxEquipos.setBounds(222, 0, 96, 35);
		panel.add(comboBoxEquipos);

		btnMiCuenta = new JButton("Mi Cuenta");
		btnMiCuenta.setBounds(678, 0, 96, 35);
		panel.add(btnMiCuenta);

		btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(779, 0, 96, 35);
		panel.add(btnSignOut);
		
		lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(92, 122, 105, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(207, 119, 272, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNuevaLiga = new JLabel("Nueva Liga");
		lblNuevaLiga.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevaLiga.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNuevaLiga.setBounds(444, 57, 168, 38);
		contentPane.add(lblNuevaLiga);
		
		lblDeporte = new JLabel("Deporte*");
		lblDeporte.setToolTipText("");
		lblDeporte.setBounds(92, 177, 105, 14);
		contentPane.add(lblDeporte);
		
		txtDeporte = new JTextField();
		txtDeporte.setToolTipText("");
		txtDeporte.setColumns(10);
		txtDeporte.setBounds(207, 174, 272, 20);
		contentPane.add(txtDeporte);
		
		lblFecha = new JLabel("Fecha de inicio*");
		lblFecha.setToolTipText("");
		lblFecha.setBounds(92, 233, 105, 14);
		contentPane.add(lblFecha);
		
		spinnerDia = new JSpinner();
		spinnerDia.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDia.setBounds(207, 230, 48, 20);
		contentPane.add(spinnerDia);
		
		spinnerMes = new JSpinner();
		spinnerMes.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinnerMes.setBounds(265, 230, 48, 20);
		contentPane.add(spinnerMes);
		
		spinnerAnyo = new JSpinner();
		spinnerAnyo.setModel(new SpinnerNumberModel(Integer.valueOf(2023), Integer.valueOf(2023), null, Integer.valueOf(1)));
		spinnerAnyo.setBounds(323, 230, 63, 20);
		contentPane.add(spinnerAnyo);
		
		lblDia = new JLabel("Dia");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setToolTipText("");
		lblDia.setBounds(207, 215, 48, 14);
		contentPane.add(lblDia);
		
		lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setToolTipText("");
		lblMes.setBounds(265, 215, 48, 14);
		contentPane.add(lblMes);
		
		lblAnyo = new JLabel("Año");
		lblAnyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnyo.setToolTipText("");
		lblAnyo.setBounds(326, 215, 48, 14);
		contentPane.add(lblAnyo);
		
		lblPrivacidad = new JLabel("Privacidad");
		lblPrivacidad.setToolTipText("");
		lblPrivacidad.setBounds(92, 271, 105, 14);
		contentPane.add(lblPrivacidad);
		
		privacidad = new ButtonGroup();
		
		rdbtnPublica = new JRadioButton("Pública");
		rdbtnPublica.setBounds(204, 267, 80, 23);
		contentPane.add(rdbtnPublica);
		privacidad.add(rdbtnPublica);
		
		rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setSelected(true);
		rdbtnPrivada.setBounds(286, 267, 109, 23);
		contentPane.add(rdbtnPrivada);
		privacidad.add(rdbtnPrivada);
		
		lblSede = new JLabel("Sede");
		lblSede.setToolTipText("");
		lblSede.setBounds(92, 324, 105, 14);
		contentPane.add(lblSede);
		
		txtSede = new JTextField();
		txtSede.setToolTipText("");
		txtSede.setColumns(10);
		txtSede.setBounds(207, 321, 272, 20);
		contentPane.add(txtSede);
		
		JLabel lblPremio = new JLabel("Premio");
		lblPremio.setToolTipText("");
		lblPremio.setBounds(92, 375, 48, 14);
		contentPane.add(lblPremio);
		
		chckbxPremio = new JCheckBox("");
		chckbxPremio.setBounds(146, 371, 28, 23);
		contentPane.add(chckbxPremio);
		
		scrollPanePremio = new JScrollPane();
		scrollPanePremio.setBounds(207, 375, 272, 117);
		contentPane.add(scrollPanePremio);
		
		JTextArea txtPremio = new JTextArea();
		scrollPanePremio.setViewportView(txtPremio);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(527, 122, 10, 370);
		contentPane.add(separator);
		
		JLabel lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReglamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblReglamento.setBounds(747, 114, 105, 26);
		contentPane.add(lblReglamento);
	}
}
