/*
 * @Author Javier Turienzo
 */
package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

public class CrearLiga extends JFrame {

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

	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblNuevaLiga;
	private JLabel lblDeporte;
	private JTextField txtDeporte;
	private JLabel lblFecha;
	private JLabel lblPrivacidad;
	private JRadioButton rdbtnPrivada;
	private JRadioButton rdbtnPublica;
	private ButtonGroup privacidad;
	private JLabel lblSede;
	private JTextField txtSede;
	private JCheckBox chckbxPremio;
	private JScrollPane scrollPanePremio;
	private JSeparator separator;
	private JLabel lblReglamento;
	private JLabel lblVictoria;
	private JSpinner spinnerVictoria;
	private JLabel lblEmpate;
	private JSpinner spinnerEmpate;
	private JLabel lblDerrota;
	private JSpinner spinnerDerrota;
	private JButton btnCrear;
	private JButton btnVolver;
	private JDateChooser dateFecha;

	// Constructor
	public CrearLiga() {
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

		lblPrivacidad = new JLabel("Privacidad");
		lblPrivacidad.setToolTipText("");
		lblPrivacidad.setBounds(92, 271, 105, 14);
		contentPane.add(lblPrivacidad);

		// ButtonGroup para hacer exclusiva la selección de privacidad
		privacidad = new ButtonGroup();

		rdbtnPublica = new JRadioButton("Pública");
		rdbtnPublica.setBounds(204, 267, 80, 23);
		contentPane.add(rdbtnPublica);

		// Añadir el boton pública al ButtonGroup
		privacidad.add(rdbtnPublica);

		rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setSelected(true);
		rdbtnPrivada.setBounds(286, 267, 109, 23);
		contentPane.add(rdbtnPrivada);

		// Añadir el boton privada al ButtonGroup
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

		lblReglamento = new JLabel("Reglamento");
		lblReglamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReglamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblReglamento.setBounds(747, 114, 105, 26);
		contentPane.add(lblReglamento);

		lblVictoria = new JLabel("Puntos por victoria");
		lblVictoria.setToolTipText("");
		lblVictoria.setBounds(572, 177, 138, 14);
		contentPane.add(lblVictoria);

		spinnerVictoria = new JSpinner();
		spinnerVictoria.setModel(new SpinnerNumberModel(Integer.valueOf(3), null, null, Integer.valueOf(1)));
		spinnerVictoria.setBounds(711, 174, 48, 20);
		contentPane.add(spinnerVictoria);

		lblEmpate = new JLabel("Puntos por empate");
		lblEmpate.setToolTipText("");
		lblEmpate.setBounds(572, 236, 138, 14);
		contentPane.add(lblEmpate);

		spinnerEmpate = new JSpinner();
		spinnerEmpate.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
		spinnerEmpate.setBounds(711, 233, 48, 20);
		contentPane.add(spinnerEmpate);

		lblDerrota = new JLabel("Puntos por derrota");
		lblDerrota.setToolTipText("");
		lblDerrota.setBounds(572, 294, 138, 14);
		contentPane.add(lblDerrota);

		spinnerDerrota = new JSpinner();
		spinnerDerrota.setBounds(711, 291, 48, 20);
		contentPane.add(spinnerDerrota);

		btnCrear = new JButton("CREAR");
		btnCrear.setForeground(new Color(0, 0, 0));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCrear.setBounds(687, 433, 149, 59);
		contentPane.add(btnCrear);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(62, 71, 89, 23);
		contentPane.add(btnVolver);

		dateFecha = new JDateChooser();
		dateFecha.setBounds(207, 227, 109, 20);
		contentPane.add(dateFecha);
	}
}
