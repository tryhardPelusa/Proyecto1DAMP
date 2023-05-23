package controlador;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Vista;
import vista._02_Registro;

public class Controlador {

	private Modelo miModelo;
	private Vista[] misVistas;
	private _02_Registro registro;

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
		
	}
}
