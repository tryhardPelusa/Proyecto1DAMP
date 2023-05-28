package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import vista.Vista;
import vista._01_InicioSesion2;
import vista._02_Registro;

public class Modelo {

	private Vista miVista;
	private String usuario;

	// Atributos para la conexion mysql
	private String db = "ProyectoIntegrador";
	private String login = "root";
	private String pwd = "";
	private String url = "jdbc:mysql://localhost/" + db
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection conexion;

	public void setVista(Vista miVista) {
		this.miVista = miVista;
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

	public boolean registro() {

		String nombre = ((_02_Registro) miVista).getNombre();
		String apellido1 = ((_02_Registro) miVista).getApellido1();
		String apellido2 = ((_02_Registro) miVista).getApellido2();
		String correo = ((_02_Registro) miVista).getCorreo();
		String fecha = ((_02_Registro) miVista).getfecha();
		String Pwd = ((_02_Registro) miVista).getPwd();
		String User = ((_02_Registro) miVista).getUser();
		ConexionMySQL();
		return registrarse(nombre, apellido1, apellido2, correo, fecha, Pwd, User);

	}

	public boolean registrarse(String nombre, String apellido1, String apellido2, String correo, String fecha,
			String Pwd, String User) {
		boolean resultado;
		try {
			String comprobarSiExiste = "SELECT correo, usuario FROM usuario WHERE correo=? OR usuario=?";
			PreparedStatement proII = conexion.prepareStatement(comprobarSiExiste);
			proII.setString(1, correo);
			proII.setString(2, User);
			ResultSet UsuarioExiste = proII.executeQuery();
			if (!UsuarioExiste.next()) {
				try {
					String insert = "INSERT INTO Usuario (nombre,Apellido1,Apellido2,monedas,Edad,Correo,contraseña,Usuario) VALUES (?,?,?,?,?,?,?,?)";
					PreparedStatement proI = conexion.prepareStatement(insert);
					proI.setString(1, nombre);
					proI.setString(2, apellido1);
					proI.setString(3, apellido2);
					proI.setString(4, "50");
					proI.setString(5, fecha);
					proI.setString(6, correo);
					proI.setString(7, Pwd);
					proI.setString(8, User);
					proI.executeUpdate();
					proI.close();
					resultado = true;
					setUsuario(User);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
					resultado = false;
				}
			} else {
				resultado = false;
			}
			proII.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
			resultado = false;
		}

		return resultado;
	}

	// Comprobamos que se puede pulsar el boton registrarse
	public boolean comprobarTodosRellenos(boolean nombre, boolean correo, boolean user, int password,
			boolean apellido1) {
		boolean todoRelleno = true;
		if (nombre || correo || user || apellido1 || password == 0) {
			todoRelleno = false;
		}

		return todoRelleno;
	}

	public boolean login(String usr, String pwd) {
		ConexionMySQL();
		String id;
		try {

			String insert = "Select id, usuario, contraseña from usuario";
			PreparedStatement proI = conexion.prepareStatement(insert);
			ResultSet rset = proI.executeQuery();
			while (rset.next()) {
				if (rset.getString(2).equals(usr) && rset.getString(3).equals(pwd)) {
					id = rset.getString(1);
					setUsuario(id);
					rset.close();
					proI.close();
					System.out.println(usuario);
					return true;
				}
			}
			rset.close();
			proI.close();
			((_01_InicioSesion2) miVista).actualizar(false);
			return false;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public DefaultTableModel getLigasPublicas() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT nombre FROM ligas WHERE idadmin=1";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();

			model.addColumn("Ligas Públicas");

			// Obtener los datos de las filas
			while (rs.next()) {
				String[] rowData = new String[1];
				rowData[0] = rs.getString(1);
				model.addRow(rowData);
			}

			// Cerrar la conexión y liberar recursos
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public DefaultTableModel getLigasPrivadas() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT Ligas.Nombre AS NombreLiga\r\n"
				+ "FROM Ligas\r\n"
				+ "JOIN Equipo_Pert_Liga ON Ligas.ID = Equipo_Pert_Liga.IDLiga\r\n"
				+ "JOIN Equipos ON Equipo_Pert_Liga.IDEquipo = Equipos.IDEquipo\r\n"
				+ "JOIN Usuario_PertEquipo ON Equipos.IDEquipo = Usuario_PertEquipo.IDEquipo\r\n"
				+ "JOIN Usuario ON Usuario_PertEquipo.IDUsuario = Usuario.ID\r\n"
				+ "WHERE Usuario.ID = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();

			model.addColumn("Ligas Privadas");

			// Obtener los datos de las filas
			while (rs.next()) {
				String[] rowData = new String[1];
				rowData[0] = rs.getString(1);
				model.addRow(rowData);
			}

			// Cerrar la conexión y liberar recursos
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	public ComboBoxModel<String> getEquiposUsuario() {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		ConexionMySQL();
		String consulta = "SELECT Equipos.Nombre\r\n" + "FROM Usuario\r\n"
				+ "INNER JOIN Usuario_PertEquipo ON Usuario.ID = Usuario_PertEquipo.IDUsuario\r\n"
				+ "INNER JOIN Equipos ON Usuario_PertEquipo.IDEquipo = Equipos.IDEquipo\r\n"
				+ "WHERE Usuario.ID = ?\r\n" + "";

		try {

			PreparedStatement stmt = conexion.prepareStatement(consulta);

			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();
			
			System.out.println(usuario);
			while (rs.next()) {
				String rowData = rs.getString("Nombre");
				model.addElement(rowData);
				System.out.println(rowData);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public String getCodigoEquipo() {
		String codigo = "";
		Random random = new Random();
	    
	    // Generar los números aleatorios
	    int numero1 = random.nextInt(10); // Número entre 0 y 9
	    int numero2 = random.nextInt(10); // Número entre 0 y 9
	    
	    // Generar las letras aleatorias
	    char letra1 = (char) (random.nextInt(26) + 'A'); // Letra mayúscula entre A y Z
	    char letra2 = (char) (random.nextInt(26) + 'A'); // Letra mayúscula entre A y Z
	    char letra3 = (char) (random.nextInt(26) + 'A'); // Letra mayúscula entre A y Z
	    
	    // Construir el código combinando los números y las letras
	    codigo += numero1 + numero2 + letra1 + letra2 + letra3;
		return codigo;
	}
	
	public String getCodigoLiga() {
		String codigo = "";
		Random random = new Random();
	    
	    // Generar los números aleatorios
	    int numero1 = random.nextInt(10); // Número entre 0 y 9
	    int numero2 = random.nextInt(10); // Número entre 0 y 9
	    
	    // Generar las letras aleatorias
	    char letra1 = (char) (random.nextInt(26) + 'A'); // Letra mayúscula entre A y Z
	    char letra2 = (char) (random.nextInt(26) + 'A'); // Letra mayúscula entre A y Z
	    char letra3 = (char) (random.nextInt(26) + 'A'); // Letra mayúscula entre A y Z
	    
	    // Construir el código combinando los números y las letras
	    codigo += letra1 + letra2 + letra3 + numero1 + numero2;
		return codigo;
	}

}
