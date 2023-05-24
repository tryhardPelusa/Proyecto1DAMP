package controlador;

import javax.swing.JFrame;

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

	public void registro() {
		miModelo.setVista(misVistas[2]);
		miModelo.registro();
	}

	public boolean login() {
		miModelo.setVista(misVistas[1]);
		String usr = ((_01_InicioSesion2) misVistas[1]).getUser();
		String pwd = ((_01_InicioSesion2) misVistas[1]).getPwd();
		if(miModelo.login(usr, pwd)) {
			cambiarVentana(1, 0);
			return true;
		} else {
			return false;
		}
	}

}
