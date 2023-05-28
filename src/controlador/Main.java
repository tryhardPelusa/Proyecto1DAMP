package controlador;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Plantilla;
import vista.Vista;
import vista._00_PaginaPrincipal2;
import vista._01_InicioSesion2;
import vista._02_Registro;
import vista._03_RecuperarCuenta;
import vista._04_MiCuenta;
import vista._05_UnirseLiga;
import vista._06_UnirseEquipo2;
import vista._07_CrearLigas2;
import vista._08_CrearEquipos;
import vista._09_LigaEspecifica2;
import vista._10_EquipoEspecifico;
import vista._11_Apuestas2;
import vista._12_MisApuestas2;
import vista._13_Lanzadera;
import vista._15_ErrorRegistro;
import vista._16_RegistroCorrecto;

public class Main {

	public static void main(String[] args) {

		Modelo miModelo = new Modelo();
		Controlador miControlador = new Controlador();

		Vista[] misVistas = new Vista[17];
		misVistas[0] = new _00_PaginaPrincipal2(miModelo);
		misVistas[1] = new _01_InicioSesion2();
		misVistas[2] = new _02_Registro();
		misVistas[3] = new _03_RecuperarCuenta();
		misVistas[4] = new _04_MiCuenta();
		misVistas[5] = new _05_UnirseLiga();
		misVistas[6] = new _06_UnirseEquipo2();
		misVistas[7] = new _07_CrearLigas2();
		misVistas[8] = new _08_CrearEquipos();
		misVistas[9] = new _09_LigaEspecifica2();
		misVistas[10] = new _10_EquipoEspecifico();
		misVistas[11] = new _11_Apuestas2();
		misVistas[12] = new _12_MisApuestas2();
		misVistas[13] = new _13_Lanzadera();
		misVistas[14] = new Plantilla();
		misVistas[15] = new _15_ErrorRegistro();
		misVistas[16] = new _16_RegistroCorrecto();

		miControlador.setVista(misVistas);
		miControlador.setModelo(miModelo);
		for (Vista vista : misVistas) {
			vista.setModelo(miModelo);
			vista.setControlador(miControlador);
		}

		((JFrame) misVistas[1]).setVisible(true);
	}

}
