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
import javax.swing.SwingConstants;

public class Lanzadera extends JFrame {

	// Atributo
	// Creamos los frames de las pantallas
	private JPanel contentPane;
	private static Lanzadera main = new Lanzadera();
	private _01_InicioSesion login = new _01_InicioSesion();
	private _02_Registro registro = new _02_Registro();
	private _03_RecuperarCuenta olvido = new _03_RecuperarCuenta();
	private _04_MiCuenta miCuenta = new _04_MiCuenta();
	private _00_PaginaPrincipal principal = new _00_PaginaPrincipal();
	private _07_CrearLigas crearLiga = new _07_CrearLigas();
	private _09_LigaEspecifica ligaEspecifica = new _09_LigaEspecifica();
	private _05_UnirseLiga unirseLiga = new _05_UnirseLiga();
	private _06_UnirseEquipo unirseEquipo = new _06_UnirseEquipo();
	private _08_CrearEquipos crearEquipo = new _08_CrearEquipos();
	private _10_EquipoEspecifico equipoEspecifico = new _10_EquipoEspecifico();
	private _11_Apuestas apuestas = new _11_Apuestas();
	private _12_MisApuestas misApuestas = new _12_MisApuestas();

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

		JButton btnInicioSesion = new JButton("Inicio de Sesión");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				login.setVisible(true);
			}
		});
		btnInicioSesion.setBounds(404, 65, 140, 23);
		contentPane.add(btnInicioSesion);

		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				registro.setVisible(true);
			}
		});
		btnRegistro.setBounds(404, 99, 140, 23);
		contentPane.add(btnRegistro);

		JButton btnMiCuenta = new JButton("Mi Cuenta");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				miCuenta.setVisible(true);
			}
		});
		btnMiCuenta.setBounds(404, 172, 140, 23);
		contentPane.add(btnMiCuenta);

		JButton btnUnirseLiga = new JButton("Unirse a una Liga");
		btnUnirseLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				unirseLiga.setVisible(true);
			}
		});
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
		btnCrearLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				crearLiga.setVisible(true);
			}
		});
		btnCrearLiga.setBounds(404, 284, 140, 23);
		contentPane.add(btnCrearLiga);

		JButton btnCrearEquipo = new JButton("Crear Equipo");
		btnCrearEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				crearEquipo.setVisible(true);
			}
		});
		btnCrearEquipo.setBounds(404, 322, 140, 23);
		contentPane.add(btnCrearEquipo);

		JButton btnMisApuestas = new JButton("Mis Apuestas");
		btnMisApuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				misApuestas.setVisible(true);
			}
		});
		btnMisApuestas.setBounds(404, 363, 140, 23);
		contentPane.add(btnMisApuestas);

		JButton btnLigaEspecifica = new JButton("Liga Específica");
		btnLigaEspecifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				ligaEspecifica.setVisible(true);
			}
		});
		btnLigaEspecifica.setBounds(404, 404, 140, 23);
		contentPane.add(btnLigaEspecifica);

		JButton btnEquipoEspecifico = new JButton("Equipo Específico");
		btnEquipoEspecifico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				equipoEspecifico.setVisible(true);
			}
		});
		btnEquipoEspecifico.setBounds(404, 444, 140, 23);
		contentPane.add(btnEquipoEspecifico);

		JButton btnApuestas = new JButton("Apuestas");
		btnApuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				apuestas.setVisible(true);
			}
		});
		btnApuestas.setBounds(404, 478, 140, 23);
		contentPane.add(btnApuestas);

		JButton btnPRecuperarCuenta = new JButton("Recuperar Contraña");
		btnPRecuperarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				olvido.setVisible(true);
			}
		});
		btnPRecuperarCuenta.setBounds(404, 133, 140, 23);
		contentPane.add(btnPRecuperarCuenta);
	}
}
