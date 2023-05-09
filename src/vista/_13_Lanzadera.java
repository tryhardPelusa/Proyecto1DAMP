/**
 * @author daniel
 */
package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class _13_Lanzadera extends JFrame implements Vista {

	// Atributo
	private Modelo miModelo;
	private Controlador miControlador;

	// Creamos los frames de las pantallas
	private JPanel contentPane;
	private JButton btnPPrincipal;
	private JButton btnInicioSesion;
	private JButton btnRegistro;
	private JButton btnPRecuperarCuenta;
	private JButton btnMiCuenta;
	private JButton btnUnirseLiga;
	private JButton btnUnirseEquipo;
	private JButton btnCrearLiga;
	private JButton btnCrearEquipo;
	private JButton btnMisApuestas;
	private JButton btnLigaEspecifica;
	private JButton btnEquipoEspecifico;
	private JButton btnApuestas;

	// Constructor
	public _13_Lanzadera() {
		// Configuración de la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Botones
		btnPPrincipal = new JButton("Página Principal");
		btnPPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 0);
			}
		});
		btnPPrincipal.setBounds(404, 31, 140, 23);
		contentPane.add(btnPPrincipal);

		btnInicioSesion = new JButton("Inicio de Sesión");
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 1);
			}
		});
		btnInicioSesion.setBounds(404, 65, 140, 23);
		contentPane.add(btnInicioSesion);

		btnRegistro = new JButton("Registro");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 2);
			}
		});
		btnRegistro.setBounds(404, 99, 140, 23);
		contentPane.add(btnRegistro);

		btnMiCuenta = new JButton("Mi Cuenta");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 4);
			}
		});
		btnMiCuenta.setBounds(404, 172, 140, 23);
		contentPane.add(btnMiCuenta);

		btnUnirseLiga = new JButton("Unirse a una Liga");
		btnUnirseLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 5);
			}
		});
		btnUnirseLiga.setBounds(404, 212, 140, 23);
		contentPane.add(btnUnirseLiga);

		btnUnirseEquipo = new JButton("Unirse a Equipo");
		btnUnirseEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 6);
			}
		});
		btnUnirseEquipo.setBounds(404, 250, 140, 23);
		contentPane.add(btnUnirseEquipo);

		btnCrearLiga = new JButton("Crear Liga");
		btnCrearLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 7);
			}
		});
		btnCrearLiga.setBounds(404, 284, 140, 23);
		contentPane.add(btnCrearLiga);

		btnCrearEquipo = new JButton("Crear Equipo");
		btnCrearEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 8);
			}
		});
		btnCrearEquipo.setBounds(404, 322, 140, 23);
		contentPane.add(btnCrearEquipo);

		btnMisApuestas = new JButton("Mis Apuestas");
		btnMisApuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 12);
			}
		});
		btnMisApuestas.setBounds(404, 363, 140, 23);
		contentPane.add(btnMisApuestas);

		btnLigaEspecifica = new JButton("Liga Específica");
		btnLigaEspecifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 9);
			}
		});
		btnLigaEspecifica.setBounds(404, 404, 140, 23);
		contentPane.add(btnLigaEspecifica);

		btnEquipoEspecifico = new JButton("Equipo Específico");
		btnEquipoEspecifico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 10);
			}
		});
		btnEquipoEspecifico.setBounds(404, 444, 140, 23);
		contentPane.add(btnEquipoEspecifico);

		btnApuestas = new JButton("Apuestas");
		btnApuestas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 11);
			}
		});
		btnApuestas.setBounds(404, 478, 140, 23);
		contentPane.add(btnApuestas);

		btnPRecuperarCuenta = new JButton("Recuperar Contraña");
		btnPRecuperarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(13, 3);
			}
		});
		btnPRecuperarCuenta.setBounds(404, 133, 140, 23);
		contentPane.add(btnPRecuperarCuenta);
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
