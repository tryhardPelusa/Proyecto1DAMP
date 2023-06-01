package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class _17_ConfiguracionFichero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblUsuario;
	private JButton btnModificar;

	public _17_ConfiguracionFichero() {
		setTitle("Configuracion De Ficheros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(177, 62, 182, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(177, 104, 182, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(177, 142, 182, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

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
		btnModificar.setBounds(173, 192, 117, 29);
		contentPane.add(btnModificar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(349, 237, 95, 29);
		contentPane.add(btnSalir);
	}
}
