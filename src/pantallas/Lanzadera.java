/**
 * @author daniel
 */
package pantallas; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lanzadera extends JFrame {

	// Atributo
	// Creamos los frames de las pantallas
	private JPanel contentPane;
	private static Lanzadera main = new Lanzadera();
	private PPrincipal principal = new PPrincipal();
	private PUnirseAEquipo unirseEquipo = new PUnirseAEquipo();
	// Main
	public static void main(String[] args) {
		// Hacemos visible el main
		main.setVisible(true);	
	}

	// Constructor
	public Lanzadera() {
		// Configuración de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Botones
		JButton btnPPrincipal = new JButton("Página Principal");
		btnPPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				principal.setVisible(true);
			}
		});
		btnPPrincipal.setBounds(404, 31, 140, 23);
		contentPane.add(btnPPrincipal);
		
		JButton btnInicioSesion = new JButton("Inicio de Sesi\u00F3n");
		btnInicioSesion.setBounds(404, 65, 140, 23);
		contentPane.add(btnInicioSesion);
		
		JButton btnPPrincipal_1_1 = new JButton("Registro");
		btnPPrincipal_1_1.setBounds(404, 99, 140, 23);
		contentPane.add(btnPPrincipal_1_1);
		
		JButton btnMiCuenta = new JButton("Mi Cuenta");
		btnMiCuenta.setBounds(404, 172, 140, 23);
		contentPane.add(btnMiCuenta);
		
		JButton btnUnirseLiga = new JButton("Unirse a una Liga");
		btnUnirseLiga.setBounds(404, 212, 140, 23);
		contentPane.add(btnUnirseLiga);
		
		JButton btnUnirseEquipo = new JButton("Unirse a Equipo");
		btnUnirseEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				unirseEquipo.setVisible(true);
			}
		});
		btnUnirseEquipo.setBounds(404, 250, 140, 23);
		contentPane.add(btnUnirseEquipo);
		
		JButton btnCrearLiga = new JButton("Crear Liga");
		btnCrearLiga.setBounds(404, 284, 140, 23);
		contentPane.add(btnCrearLiga);
		
		JButton btnCrearEquipo = new JButton("Crear Equipo");
		btnCrearEquipo.setBounds(404, 322, 140, 23);
		contentPane.add(btnCrearEquipo);
		
		JButton btnVerLigas = new JButton("Ver Ligas");
		btnVerLigas.setBounds(404, 363, 140, 23);
		contentPane.add(btnVerLigas);
		
		JButton btnLigaEspecifica = new JButton("Liga Espec\u00EDfica");
		btnLigaEspecifica.setBounds(404, 404, 140, 23);
		contentPane.add(btnLigaEspecifica);
		
		JButton btnEquipoEspecifico = new JButton("Equipo Espec\u00EDfico");
		btnEquipoEspecifico.setBounds(404, 444, 140, 23);
		contentPane.add(btnEquipoEspecifico);
		
		JButton btnApuestas = new JButton("Apuestas");
		btnApuestas.setBounds(404, 478, 140, 23);
		contentPane.add(btnApuestas);
		
		JButton btnPRecuperarCuenta = new JButton("Recuperar Contrase\u00F1a");
		btnPRecuperarCuenta.setBounds(404, 133, 140, 23);
		contentPane.add(btnPRecuperarCuenta);
	}
}
