package controlador;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Vista;
import vista._00_PaginaPrincipal;
import vista._01_InicioSesion2;
import vista._02_Registro;
import vista._03_RecuperarCuenta;
import vista._04_MiCuenta;
import vista._05_UnirseLiga;
import vista._06_UnirseEquipo;
import vista._07_CrearLigas;
import vista._08_CrearEquipos;
import vista._09_LigaEspecifica2;
import vista._10_EquipoEspecifico;
import vista._11_Apuestas;
import vista._12_MisApuestas;
import vista._13_Lanzadera;

public class Main {

	public static void main(String[] args) {

		Modelo miModelo = new Modelo();
		Controlador miControlador = new Controlador();

		Vista[] misVistas = new Vista[14];
		misVistas[0] = new _00_PaginaPrincipal();
		misVistas[1] = new _01_InicioSesion2();
		misVistas[2] = new _02_Registro();
		misVistas[3] = new _03_RecuperarCuenta();
		misVistas[4] = new _04_MiCuenta();
		misVistas[5] = new _05_UnirseLiga();
		misVistas[6] = new _06_UnirseEquipo();
		misVistas[7] = new _07_CrearLigas();
		misVistas[8] = new _08_CrearEquipos();
		misVistas[9] = new _09_LigaEspecifica2();
		misVistas[10] = new _10_EquipoEspecifico();
		misVistas[11] = new _11_Apuestas();
		misVistas[12] = new _12_MisApuestas();
		misVistas[13] = new _13_Lanzadera();
 
		miModelo.setControlador(miControlador);
		miControlador.setVista(misVistas);
		miControlador.setModelo(miModelo);
		for (Vista vista : misVistas) {
			vista.setModelo(miModelo);
			vista.setControlador(miControlador);
		}

		((JFrame) misVistas[13]).setVisible(true);
	}

}
