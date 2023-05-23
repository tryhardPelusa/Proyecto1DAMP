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
		String nombre = registro.getNombre();  
		String apellido1 = registro.getApellido1();
		String apellido2 = registro.getApellido2();
		String correo = registro.getCorreo();
		String fecha = registro.getfecha();
		String Pwd = registro.getPwd();
		String User = registro.getUser();
		
	}
	
}
