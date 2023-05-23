package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

import modelo.Modelo;
import vista.Vista;
import vista._02_Registro;

public class Controlador {

	private Modelo miModelo;
	private Vista[] misVistas;
	private _02_Registro registro;
	private String db = "ProyectoIntegrador";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + db
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection conexion;

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
		ConexionMySQL();
		registrarse(nombre, apellido1, apellido2, correo, fecha, Pwd, User);
	}

	public void registrarse(String nombre, String apellido1, String apellido2, String correo, String fecha, String Pwd,
			String User) {

	}

	public void ConexionMySQL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println("-> Conexión con MySQL establecida");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver JDBC No encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectarse a la BD");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error general de Conexion");
			e.printStackTrace();
		}
	}

}
