package controlador;

import javax.swing.ComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Modelo;
import vista.Vista;
import vista._01_InicioSesion2;

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
			return false;
		}
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
		return miModelo.getLigasDeEquipo(equipoActual);
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

}
