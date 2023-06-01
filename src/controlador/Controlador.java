package controlador;

import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Modelo;
import vista.Vista;
import vista._01_InicioSesion2;
import vista._04_MiCuenta;
import vista._07_CrearLigas2;

public class Controlador {

	private Modelo miModelo;
	private Vista[] misVistas;

	public void setVista(Vista[] misVistas) {
		this.misVistas = misVistas;
	}

	public void setModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}

	public void cambiarVentana(int desde, int hasta) {
		((JFrame) misVistas[desde]).setVisible(false);
		((JFrame) misVistas[hasta]).setVisible(true);
	}

	public void nuevaVentana(int nueva) {
		((JFrame) misVistas[nueva]).setVisible(true);
	}

	public void cerrarVentana(int ventanaActual) {
		((JFrame) misVistas[ventanaActual]).setVisible(false);

	}

	public boolean registro() {
		miModelo.setVista(misVistas[2]);
		return miModelo.registro();

	}

	public boolean login() {
		miModelo.setVista(misVistas[1]);
		String usr = ((_01_InicioSesion2) misVistas[1]).getUser();
		String pwd = ((_01_InicioSesion2) misVistas[1]).getPwd();
		if (miModelo.login(usr, pwd)) {
			cambiarVentana(1, 0);
			return true;
		} else {
			miModelo.setNumIntentos();
			if (miModelo.comprobarIntentos()) {
				System.exit(0);
			}
			return false;
		}
	}

	public void cargarMiCuenta() {
		miModelo.setVista(misVistas[4]);
		((_04_MiCuenta) misVistas[4]).actualizarDatos(miModelo.getMiCuenta());
	}

	public void actualizarCuenta(String[] datos) {
		miModelo.setVista(misVistas[4]);
		if (miModelo.actualizarCuenta(datos) > 0) {
			((_04_MiCuenta) misVistas[4]).mostrarUpdateCorrecto();
		}
	}

	public void crearliga(String[] datos) {
		miModelo.setVista(misVistas[7]);
		String codigo = miModelo.crearLiga(datos);
		if (!codigo.isEmpty())
			((_07_CrearLigas2) misVistas[7]).mostrarCorrecto(codigo);

	}

	public DefaultTableModel getLigasPublicas() {
		miModelo.setVista(misVistas[0]);
		return miModelo.getLigasPublicas();
	}

	public TableModel getLigasPrivadas() {
		miModelo.setVista(misVistas[0]);
		return miModelo.getLigasPrivadas();
	}

	public ComboBoxModel<String> getEquiposUsuario() {
		miModelo.setVista(misVistas[6]);
		return miModelo.getEquiposUsuario();
	}

	public void InsertEquipo() {
		miModelo.setVista(misVistas[8]);
		miModelo.InsertEquipo();

	}

	public DefaultTableModel getLigasDeEquipo(String equipoActual) {
		miModelo.setVista(misVistas[10]);
		return miModelo.getLigasDeEquipo();
	}

	public TableModel getUsuariosPorEquipo(String equipoActual) {
		miModelo.setVista(misVistas[10]);
		return miModelo.getUsuarioDeLiga(equipoActual);
	}

	public String getSede(String equipoActual) {
		miModelo.setVista(misVistas[10]);
		return miModelo.getSede(equipoActual);
	}

	public String getdeporte(String equipoActual) {
		miModelo.setVista(misVistas[10]);
		return miModelo.getdeporte(equipoActual);
	}

	public String getEquipo(String equipoActual) {
		miModelo.setVista(misVistas[10]);
		return miModelo.getEquipo(equipoActual);
	}

	public String getCodigo(String equipoActual) {
		miModelo.setVista(misVistas[10]);
		return miModelo.getCodigo(equipoActual);
	}

	public boolean verificarCodEquipo(String codigoIngresado) {
		miModelo.setVista(misVistas[6]);
		return miModelo.verificarCodEquipo(codigoIngresado);
	}

	public DefaultTableModel obtenerEquiposDePartidos(String[] apuesta) {
		miModelo.setVista(misVistas[11]);
		return miModelo.obtenerEquiposDePartidos(apuesta);
	}

	public DefaultTableModel obtenerPartidosLigaEspecifica(int idLiga) {
		miModelo.setVista(misVistas[9]);
		return miModelo.obtenerPartidosLigaEspecifica(idLiga);
	}

	public Object getEquipoDeTabla(String string) {
		miModelo.setVista(misVistas[9]);
		return miModelo.obtenerEquipoDeTable(string);
	}

	public DefaultTableModel getApuesta() {
		miModelo.setVista(misVistas[11]);
		return miModelo.getApuestaActual();
	}

	public DefaultTableModel obtenerApuestas() {
		miModelo.setVista(misVistas[12]);
		return miModelo.obtenerApuestas();
	}

	public void unirseLiga(String CodLiga, String nombreEquipo) {
		miModelo.setVista(misVistas[5]);
		miModelo.unirseLiga(CodLiga, nombreEquipo);
	}

	public DefaultTableModel getClasificacion(int idLiga, int idAdmin) {
		miModelo.setVista(misVistas[9]);
		return miModelo.getClasificacion(idLiga, idAdmin);
	}

	public int[] obtenerIdsLigaAdmin(String liga) {
		miModelo.setVista(misVistas[0]);
		return miModelo.obtenerIdsLigaAdmin(liga);
	}

	public void pasarIdsALigaEspecifica(int idLiga, int idAdmin) {
		miModelo.setVista(misVistas[9]);
		miModelo.pasarIdsALigaEspecifica(idLiga, idAdmin);
	}

	public void generarPartidos(int idLiga) {
		miModelo.setVista(misVistas[9]);
		miModelo.generarPartidos(idLiga);
	}


}
