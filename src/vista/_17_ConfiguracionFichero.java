package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _17_ConfiguracionFichero extends JFrame implements Vista {

	private JPanel contentPane;
	private JTextField txtUsr;
	private JTextField txtPwd;
	private JTextField txtUrl;
	private JLabel lblUsuario;
	private JButton btnModificar;
	private Controlador miControlador;
	private Modelo miModelo;
	private String[] datos = new String[3];

	public _17_ConfiguracionFichero() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				datos = miModelo.cargarConfig();
				txtUsr.setText(datos[0]);
				txtPwd.setText(datos[1]);
				txtUrl.setText(datos[2]);
			}
		});
		setTitle("Configuracion De Ficheros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsr = new JTextField();
		txtUsr.setBounds(177, 62, 182, 26);
		contentPane.add(txtUsr);
		txtUsr.setColumns(10);

		txtPwd = new JTextField();
		txtPwd.setBounds(177, 104, 182, 26);
		contentPane.add(txtPwd);
		txtPwd.setColumns(10);

		txtUrl = new JTextField();
		txtUrl.setBounds(177, 142, 182, 26);
		contentPane.add(txtUrl);
		txtUrl.setColumns(10);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(77, 70, 61, 16);
		contentPane.add(lblUsuario);

		JLabel lblPwd = new JLabel("Contrase\u00F1a:");
		lblPwd.setBounds(77, 112, 88, 16);
		contentPane.add(lblPwd);

		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(77, 150, 61, 16);
		contentPane.add(lblUrl);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miModelo.modificarConfig(datos);
			}
		});
		btnModificar.setBounds(173, 192, 117, 29);
		contentPane.add(btnModificar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cerrarVentana(17);
			}
		});
		btnSalir.setBounds(349, 237, 95, 29);
		contentPane.add(btnSalir);
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
