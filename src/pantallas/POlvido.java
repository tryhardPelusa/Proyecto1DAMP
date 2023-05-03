package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POlvido extends JFrame {

	private JPanel contentPane;
	private JLabel lblTituloAcceder;
	private JLabel lblPorFavorIntroduzca;
	private JLabel lblUsuario;
	private JLabel lblCorreo;
	private JLabel lblO;
	private JTextField textUsuario;
	private JTextField textCorreo;
	private JButton btnRecuperar;
	private JLabel lblRevise;


	public static void main(String[] args) {

					POlvido frame = new POlvido();
					frame.setVisible(true);

	}

	public POlvido() {
		setTitle("Pagina Olvido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTituloAcceder = new JLabel("\u00BFNo puedes acceder?");
		lblTituloAcceder.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblTituloAcceder.setBounds(389, 58, 253, 70);
		contentPane.add(lblTituloAcceder);
		
		lblPorFavorIntroduzca = new JLabel("Por favor, introduzca su nombre de usuario");
		lblPorFavorIntroduzca.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPorFavorIntroduzca.setBounds(306, 124, 415, 70);
		contentPane.add(lblPorFavorIntroduzca);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblUsuario.setBounds(361, 206, 86, 25);
		contentPane.add(lblUsuario);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblCorreo.setBounds(366, 293, 86, 25);
		contentPane.add(lblCorreo);
		
		lblO = new JLabel("o");
		lblO.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblO.setBounds(441, 234, 21, 47);
		contentPane.add(lblO);
		
		textUsuario = new JTextField();
		textUsuario.setText("Usuario");
		textUsuario.setBounds(450, 203, 180, 36);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setText("Correo electronico");
		textCorreo.setColumns(10);
		textCorreo.setBounds(451, 290, 180, 36);
		contentPane.add(textCorreo);
		
		btnRecuperar = new JButton("Recuperar Cuenta");
		btnRecuperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblRevise.setText("Revise su correo");
			}
		});
		btnRecuperar.setBackground(Color.BLUE);
		btnRecuperar.setBounds(409, 380, 167, 29);
		contentPane.add(btnRecuperar);
		
		lblRevise = new JLabel("");
		lblRevise.setFont(new Font("Geneva", Font.PLAIN, 18));
		lblRevise.setBounds(399, 338, 215, 30);
		contentPane.add(lblRevise);
	}
}
