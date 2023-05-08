/**
 * @author Guillermo Callizaya
 */

package vista;

import controlador.Controlador;
import modelo.Modelo;

public interface Vista {
	public _00_PaginaPrincipal principal = new _00_PaginaPrincipal();
	public _01_InicioSesion login = new _01_InicioSesion();
	public _02_Registro registro = new _02_Registro();
	public _03_RecuperarCuenta olvido = new _03_RecuperarCuenta();
	public _04_MiCuenta miCuenta = new _04_MiCuenta();
	public _07_CrearLigas crearLiga = new _07_CrearLigas();
	public _09_LigaEspecifica ligaEspecifica = new _09_LigaEspecifica();
	public _05_UnirseLiga unirseLiga = new _05_UnirseLiga();
	public _06_UnirseEquipo unirseEquipo = new _06_UnirseEquipo();
	public _08_CrearEquipos crearEquipo = new _08_CrearEquipos();
	public _10_EquipoEspecifico equipoEspecifico = new _10_EquipoEspecifico();
	public _11_Apuestas apuestas = new _11_Apuestas();
	public _12_MisApuestas misApuestas = new _12_MisApuestas();

	public void setModelo(Modelo miModelo);

	public void setControlador(Controlador miControlador);

	Controlador miControlador = new Controlador();
	Modelo miModelo = new Modelo();
}
