package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import vista.Vista;
import vista._01_InicioSesion2;
import vista._02_Registro;
import vista._06_UnirseEquipo2;
import vista._08_CrearEquipos;

public class Modelo {

	private Vista miVista;
	private String usuario;
	private String IdEquipo;
	private int numIntentos = 0;
	private int idLigaActual;
	private int idAdminActual;
	private boolean unionLigaCorrecta;

	// Atributos para la conexion mysql
	private String usr;
	private String pwd;
	private String url;
	private Connection conexion;
	private DefaultTableModel apuestaActual;
	private File fConfig = new File("Configuracion.ini");
	private Properties fp = new Properties();
	private int idPartidoActual;

	/**
	 * Establece la vista para el modelo.
	 * 
	 * @param miVista la vista a establecer
	 */
	public void setVista(Vista miVista) {
		this.miVista = miVista;
	}

	/**
	 * Modifica el fichero de configuración con los datos proporcionados.
	 * 
	 * @param datos un array de Strings que contiene los nuevos datos de
	 *              configuración
	 */
	public void modificarConfig(String[] datos) {
		try {
			FileOutputStream fos = new FileOutputStream(fConfig);
			fp.setProperty("usr", datos[0]);
			fp.setProperty("pwd", datos[1]);
			fp.setProperty("url", datos[2]);
			fp.store(fos, "");
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga la configuración guardada en el fichero.
	 * 
	 * @return un array de Strings que contiene los datos del fichero de
	 *         configuración
	 */
	public String[] cargarConfig() {
		String[] datos = new String[3];
		FileInputStream fis;
		try {
			fis = new FileInputStream(fConfig);
			fp.load(fis);
			datos[0] = fp.getProperty("usr");
			datos[1] = fp.getProperty("pwd");
			datos[2] = fp.getProperty("url");
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return datos;
	}

	/**
	 * Realiza la conexión a MySQL utilizando la configuración guardada.
	 */
	public void ConexionMySQL() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(fConfig);
			fp.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.usr = fp.getProperty("usr");
		this.pwd = fp.getProperty("pwd");
		this.url = fp.getProperty("url")
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usr, pwd);
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

	/**
	 * Recoge los datos del registro de la vista y se los pasa al método registrarse
	 * para hacer el registro
	 * 
	 * @return verdadero si el registro fue exitoso, falso de lo contrario
	 */
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

	/**
	 * Realiza el registro del usuario utilizando los datos proporcionados, además
	 * comprueba si el usuario ya existía, en dicho caso no realiza el registro
	 * 
	 * @param nombre    el nombre del usuario
	 * @param apellido1 el primer apellido del usuario
	 * @param apellido2 el segundo apellido del usuario
	 * @param correo    el correo del usuario
	 * @param fecha     la fecha de nacimiento del usuario
	 * @param Pwd       la contraseña del usuario
	 * @param User      el nombre de usuario del usuario
	 * @return verdadero si el registro fue exitoso, falso de lo contrario
	 */
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

	/**
	 * Comprueba que los campos obligatorios del registro están rellenos
	 * 
	 * @param nombre
	 * @param correo
	 * @param user
	 * @param password
	 * @param apellido1
	 * @return verdadero si estan rellenos, falso de lo contrario
	 */
	public boolean comprobarTodosRellenos(boolean nombre, boolean correo, boolean user, int password,
			boolean apellido1) {
		boolean todoRelleno = true;
		if (nombre || correo || user || apellido1 || password == 0) {
			todoRelleno = false;
		}

		return todoRelleno;
	}

	/**
	 * Comprueba que los campos obligatorios de creación de liga están rellenos
	 * 
	 * @param nombre
	 * @param deporte
	 * @param fecha
	 * @return verdadero si están rellenos, falso de lo contrario
	 */
	public boolean comprobarTodosRellenos(boolean nombre, boolean deporte, Date fecha) {
		boolean todoRelleno = true;
		if (nombre || deporte || fecha == null) {
			todoRelleno = false;
		}

		return todoRelleno;
	}

	/**
	 * Realiza el inicio de sesión del usuario con las credenciales proporcionadas.
	 * 
	 * @param usr el nombre de usuario
	 * @param pwd la contraseña
	 * @return verdadero si el inicio de sesión es exitoso, falso de lo contrario
	 */
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
					numIntentos = 0;
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

	/**
	 * Obtiene el nombre de usuario actualmente activo.
	 * 
	 * @return el nombre de usuario actual
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece el nombre de usuario actualmente activo.
	 * 
	 * @param usuario el nombre de usuario a establecer
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene las ligas públicas
	 * 
	 * @return un DefaultTableModel que contiene las ligas públicas
	 */
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

	/**
	 * Obtiene las ligas privadas a las que pertenece el usuario actual.
	 * 
	 * @return un DefaultTableModel que contiene las ligas privadas del usuario
	 */
	public DefaultTableModel getLigasPrivadas() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT Ligas.Nombre AS NombreLiga\r\n" + "FROM Ligas\r\n"
				+ "JOIN Equipo_Pert_Liga ON Ligas.ID = Equipo_Pert_Liga.IDLiga\r\n"
				+ "JOIN Equipos ON Equipo_Pert_Liga.IDEquipo = Equipos.IDEquipo\r\n"
				+ "JOIN Usuario_PertEquipo ON Equipos.IDEquipo = Usuario_PertEquipo.IDEquipo\r\n"
				+ "JOIN Usuario ON Usuario_PertEquipo.IDUsuario = Usuario.ID\r\n" + "WHERE Usuario.ID = ?";

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

	/**
	 * Obtiene la información de la cuenta del usuario actual.
	 * 
	 * @return un array de strings que contiene los datos de la cuenta del usuario
	 *         en el siguiente orden: [usuario, nombre, apellido1, apellido2,
	 *         contraseña, correo, edad]
	 */
	public String[] getMiCuenta() {
		String consulta = "SELECT usuario,nombre,apellido1,apellido2,contraseña,correo,edad FROM usuario WHERE id = ?";
		String[] datos = new String[7];

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, usuario);
			ResultSet rs = stmt.executeQuery();

			// Obtener los datos del usuario y guardarlos en el array datos
			rs.next();
			for (int i = 0; i < datos.length; i++) {
				datos[i] = rs.getString(i + 1);
			}

			// Liberar recursos
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Actualiza la información de la cuenta del usuario con los nuevos datos
	 * proporcionados.
	 * 
	 * @param datos un array de strings que contiene los nuevos datos de la cuenta
	 * @return el número de filas actualizadas en la base de datos
	 */
	public int actualizarCuenta(String[] datos) {
		String consulta = "UPDATE usuario SET nombre = ?, apellido1 = ?, apellido2 = ?, contraseña = ?, correo = ?, edad = ? WHERE id = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, datos[0]);
			stmt.setString(2, datos[1]);
			stmt.setString(3, datos[2]);
			stmt.setString(4, datos[3]);
			stmt.setString(5, datos[4]);
			stmt.setString(6, datos[5]);
			stmt.setString(7, usuario);
			int res = stmt.executeUpdate();

			// Liberar recursos
			stmt.close();

			// Devolver el número de cambios
			return res;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Obtiene los equipos a los que pertenece el usuario actual.
	 * 
	 * @return un ComboBoxModel que contiene los nombres de los equipos del usuario
	 */
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

	/**
	 * Genera un código único para un equipo con formato 12ABC
	 * 
	 * @return el código generado
	 */
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
		codigo += numero1 + "" + numero2 + "" + letra1 + "" + letra2 + "" + letra3;
		return codigo;
	}

	/**
	 * Genera un código único para una liga con formato ABC12.
	 * 
	 * @return el código generado
	 */
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
		codigo += letra1 + "" + letra2 + "" + letra3 + "" + numero1 + "" + numero2;
		return codigo;
	}

	/**
	 * Verifica si el código de equipo proporcionado existe en la base de datos. Si
	 * existe, agrega al usuario actual al equipo correspondiente.
	 * 
	 * @param codEquipo el código de equipo
	 * @return true si el código de equipo existe y se agrega al usuario, false de
	 *         lo contrario
	 */
	public boolean verificarCodEquipo(String codEquipo) {
		ConexionMySQL();
		String consulta = "SELECT idequipo, CodEquipo FROM Equipos WHERE CodEquipo = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, codEquipo);
			ResultSet rs = stmt.executeQuery();

			boolean existeEquipo = rs.next();
			if (existeEquipo) {
				String idEquipo = rs.getString("idequipo");

				rs.close();
				stmt.close();
				((_06_UnirseEquipo2) miVista).error(false);

				consulta = "INSERT INTO usuario_pertequipo (idusuario, idequipo) VALUES (?, ?)";
				PreparedStatement stmt2 = conexion.prepareStatement(consulta);
				stmt2.setString(1, usuario);
				stmt2.setString(2, idEquipo);
				stmt2.executeUpdate();
				stmt2.close();
			}
			rs.close();
			stmt.close();
			return existeEquipo;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Obtiene las apuestas realizadas por un usuario.
	 * 
	 * @param idUsuario el ID del usuario
	 * @return un DefaultTableModel que contiene las apuestas del usuario
	 */
	public DefaultTableModel getMisApuestas(int idUsuario) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT * FROM Apuestas WHERE IDUsuario = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setInt(1, idUsuario);
			ResultSet rs = stmt.executeQuery();
			model.addColumn("Fecha");
			model.addColumn("Cantidad");
			model.addColumn("Pronóstico");

			// Obtener los datos de las filas
			while (rs.next()) {
				String[] rowData = new String[2];
				rowData[0] = String.valueOf(rs.getInt("Cantidad"));
				rowData[1] = rs.getString("Pronostico");
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

	/**
	 * Obtiene el nombre, sede y deporte de un equipo a través de la vista. Genera
	 * un código de equipo único y lo asigna al equipo. Luego llama al método
	 * InsertarEquipo para insertar el equipo en la base de datos.
	 */
	public void InsertEquipo() {
		String codigo;
		String nombreEquip = ((_08_CrearEquipos) miVista).getNombreEquipo();
		String sede = ((_08_CrearEquipos) miVista).getSede();
		String deporte = ((_08_CrearEquipos) miVista).getDeporte();
		do {
			codigo = getCodigoEquipo();
		} while (comprobarCodigoEquipo(codigo));
		InsertarEquipo(nombreEquip, deporte, sede, codigo);
	}

	/**
	 * Comprueba si un código de equipo ya existe en la base de datos.
	 * 
	 * @param codigo el código de equipo a comprobar
	 * @return true si el código de equipo existe, false en caso contrario
	 */
	public boolean comprobarCodigoEquipo(String codigo) {
		String consulta = "SELECT nombre FROM Equipos WHERE CodEquipo=?";
		PreparedStatement proI;
		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, codigo);
			ResultSet rs = proI.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	/**
	 * Inserta un equipo en la base de datos.
	 * 
	 * @param NombreEquipo el nombre del equipo
	 * @param Deporte      el deporte del equipo
	 * @param Sede         la sede del equipo
	 * @param CodEquipo    el código del equipo
	 */
	public void InsertarEquipo(String NombreEquipo, String Deporte, String Sede, String CodEquipo) {
		ConexionMySQL();
		String insert = "INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES (?,?,?,?)";
		String consulta = "select IDEquipo from equipos where CodEquipo = ?";
		String Insert2 = "INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (?,?)";
		PreparedStatement proI;
		PreparedStatement pro2;
		PreparedStatement pro3;
		try {
			proI = conexion.prepareStatement(insert);
			proI.setString(1, NombreEquipo);
			proI.setString(2, Deporte);
			proI.setString(3, Sede);
			proI.setString(4, CodEquipo);
			proI.executeUpdate();
			proI.close();

			pro2 = conexion.prepareStatement(consulta);
			pro2.setString(1, CodEquipo);
			ResultSet rs = pro2.executeQuery();
			rs.next();
			String IdEquipo = rs.getString(1);

			pro3 = conexion.prepareStatement(Insert2);
			pro3.setString(1, usuario);
			pro3.setString(2, IdEquipo);
			pro3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene las ligas a las que pertenece un equipo.
	 * 
	 * @return un DefaultTableModel con las ligas del equipo
	 */
	public DefaultTableModel getLigasDeEquipo() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "select IDLiga from equipo_pert_liga WHERE IDEquipo = ?";
		String consultaNombreEquip = "select Nombre from ligas where ID = ?";
		PreparedStatement proI;
		PreparedStatement pro2;

		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);
			ResultSet rs = proI.executeQuery();

			ArrayList<String> idLigaList = new ArrayList<>();
			System.out.println(rs.getRow());
			while (rs.next()) {
				idLigaList.add(rs.getString(1));
			}
			String[] idLiga = idLigaList.toArray(new String[0]);

			model.addColumn("Ligas");
			for (int i = 0; i < idLiga.length; i++) {
				pro2 = conexion.prepareStatement(consultaNombreEquip);
				pro2.setString(1, idLiga[i]);
				ResultSet re = pro2.executeQuery();
				re.next();
				String[] fila = new String[1];
				fila[0] = re.getString(1);
				model.addRow(fila);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	/**
	 * Obtiene los usuarios que pertenecen a un equipo.
	 * 
	 * @param equipoActual el equipo actual
	 * @return un DefaultTableModel con los usuarios del equipo
	 */
	public DefaultTableModel getUsuarioDeLiga(String equipoActual) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "select IDUsuario from usuario_pertequipo where IDEquipo = ?;";
		String consultaNombreEquip = "select Nombre from usuario where ID = ?;";
		PreparedStatement proI;
		PreparedStatement pro2;

		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);
			ResultSet rs = proI.executeQuery();

			ArrayList<String> idUsuarios = new ArrayList<>();
			while (rs.next()) {
				idUsuarios.add(rs.getString(1));
			}
			String[] idLiga = idUsuarios.toArray(new String[0]);

			model.addColumn("Jugadores");
			for (int i = 0; i < idLiga.length; i++) {
				pro2 = conexion.prepareStatement(consultaNombreEquip);
				pro2.setString(1, idLiga[i]);
				ResultSet re = pro2.executeQuery();
				re.next();
				String[] fila = new String[1];
				fila[0] = re.getString(1);
				model.addRow(fila);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}

	/**
	 * Obtiene la sede de un equipo.
	 * 
	 * @param equipoActual el equipo actual
	 * @return la sede del equipo
	 */
	public String getSede(String equipoActual) {
		String consulta = "select Estadio from equipos where IDEquipo = ?;";
		PreparedStatement proI;
		String estadio = "";
		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);
			ResultSet rs = proI.executeQuery();
			rs.next();
			estadio = rs.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estadio;
	}

	/**
	 * Obtiene el deporte de un equipo.
	 * 
	 * @param equipoActual el equipo actual
	 * @return el deporte del equipo
	 */
	public String getDeporte(String equipoActual) {
		String consulta = "select Deporte from equipos where IDEquipo = ?;";
		PreparedStatement proI;
		String deporte = "";
		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);
			ResultSet rs = proI.executeQuery();
			rs.next();
			deporte = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deporte;
	}

	/**
	 * Obtiene el nombre de un equipo.
	 * 
	 * @param equipoActual el equipo actual
	 * @return el nombre del equipo
	 */
	public String getEquipo(String equipoActual) {
		String consulta = "select Nombre from equipos where IDEquipo = ?;";
		PreparedStatement proI;
		String equipo = "";
		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);
			ResultSet rs = proI.executeQuery();
			rs.next();
			equipo = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipo;
	}

	/**
	 * Obtiene el código de un equipo.
	 * 
	 * @param equipoActual el equipo actual
	 * @return el código del equipo
	 */
	public String getCodigo(String equipoActual) {
		String consulta = "select CodEquipo from equipos where IDEquipo = ?;";
		PreparedStatement proI;
		String codigo = "";
		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);
			ResultSet rs = proI.executeQuery();
			rs.next();
			codigo = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigo;
	}

	/**
	 * Obtiene los equipos de los partidos que coinciden con los datos de apuesta
	 * proporcionados.
	 * 
	 * @param datosApuesta los datos de apuesta (EquipLocal y EquipVisitante)
	 * @return un DefaultTableModel con los equipos de los partidos
	 */
	public DefaultTableModel obtenerEquiposDePartidos(String[] datosApuesta) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT EquipLocal, EquipVisitante FROM Partidos WHERE EquipLocal=? AND EquipVisitante=?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, datosApuesta[0]);
			stmt.setString(2, datosApuesta[1]);
			ResultSet rs = stmt.executeQuery();

			model.addColumn("Equipo Local");
			model.addColumn("Gana");
			model.addColumn("Cantidad");
			model.addColumn("Gana");
			model.addColumn("Equipo Visitante");

			// Obtener los datos de las filas
			while (rs.next()) {
				Object[] rowData = new Object[5];
				rowData[0] = rs.getString(1); // Equipo Local
				rowData[1] = null;
				rowData[2] = 0;
				rowData[3] = null;
				rowData[4] = rs.getString(2); // Equipo Visitante
				model.addRow(rowData);
			}

			// Cerrar la conexión y liberar recursos
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		apuestaActual = model;
		return model;
	}

	/**
	 * Obtiene la tabla de la apuesta actual.
	 * 
	 * @return la tabla de la apuesta actual
	 */
	public DefaultTableModel getApuestaActual() {
		return apuestaActual;
	}

	/**
	 * Obtiene los partidos de una liga específica.
	 * 
	 * @param idLiga el ID de la liga
	 * @return un DefaultTableModel con los partidos de la liga
	 */
	public DefaultTableModel obtenerPartidosLigaEspecifica(int idLiga) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT Fecha, EquipLocal, EquipVisitante, Lugar FROM Partidos WHERE IDLiga = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setInt(1, idLiga);
			ResultSet rs = stmt.executeQuery();

			model.addColumn("Fecha");
			model.addColumn("Equipo Local");
			model.addColumn("Equipo Visitante");
			model.addColumn("Sede");

			// Obtener los datos de las filas
			while (rs.next()) {
				Object[] rowData = new Object[4];
				rowData[0] = rs.getDate(1); // Fecha
				rowData[1] = rs.getString(2); // Equipo Local
				rowData[2] = rs.getString(3); // Equipo Visitante
				rowData[3] = rs.getString(4); // Sede
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

	/**
	 * Crea una nueva liga con los datos proporcionados.
	 * 
	 * @param datos los datos de la liga
	 * @return el código de la liga creada
	 */
	public String crearLiga(String[] datos) {
		String consulta = "INSERT INTO ligas (premio,nombre,sede,fechaInicio,privacidad,deporte,idAdmin,CodLiga) VALUES (?,?,?,?,?,?,?,?)";
		String codigo = getCodigoLiga();
		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setInt(1, Integer.parseInt(datos[5]));
			stmt.setString(2, datos[0]);
			stmt.setString(3, datos[4]);

			// Convertir el String de fecha a LocalDate
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(datos[2], formatter);

			// Convertir LocalDate a java.sql.Date
			java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

			stmt.setDate(4, sqlDate);
			stmt.setString(5, datos[3]);
			stmt.setString(6, datos[1]);
			stmt.setString(7, usuario);
			stmt.setString(8, codigo);
			int res = stmt.executeUpdate();

			// Liberar recursos
			stmt.close();
			if (res > 0)
				return codigo;
			else
				return "";

		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * Obtiene las apuestas del usuario actual.
	 * 
	 * @return un DefaultTableModel con las apuestas del usuario
	 */
	public DefaultTableModel obtenerApuestas() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT Fecha, Partido, Cantidad, Pronostico FROM Apuestas WHERE IDUsuario = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setInt(1, Integer.parseInt(getUsuario()));

			ResultSet rs = stmt.executeQuery();

			model.addColumn("Fecha");
			model.addColumn("Partido");
			model.addColumn("Cantidad");
			model.addColumn("Pronostico");

			// Obtener los datos de las filas
			while (rs.next()) {
				Object[] rowData = new Object[4];
				rowData[0] = rs.getDate("Fecha"); // Fecha
				rowData[1] = rs.getString("Partido"); // Partido
				rowData[2] = rs.getInt("Cantidad"); // Cantidad
				rowData[3] = rs.getString("Pronostico");// Pronostico
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

	/**
	 * Obtiene el ID del equipo.
	 * 
	 * @param string el nombre del equipo
	 * @return el ID de equipo
	 */
	public Object obtenerEquipoDeTable(String string) {
		String consulta = "select IDEquipo from equipos where Nombre = ?";
		PreparedStatement proI;
		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, string);
			ResultSet rs = proI.executeQuery();
			rs.next();
			IdEquipo = rs.getString(1);
			proI.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return IdEquipo;
	}

	/**
	 * Obtiene el ID de una liga a partir de su código.
	 * 
	 * @param codLiga el código de la liga
	 * @return el ID de la liga
	 */
	public String obtenerIdLiga(String codLiga) {
		String consulta = "select ID from ligas where CodLiga = ?";
		PreparedStatement proI;
		String idLiga = "";
		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, codLiga);
			ResultSet rs = proI.executeQuery();
			if (rs.next()) {
				idLiga = rs.getString(1);
			}

			proI.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idLiga;
	}

	/**
	 * Añade un equipo a una liga.
	 * 
	 * @param CodLiga      el código de la liga
	 * @param nombreEquipo el nombre del equipo
	 */
	public void unirseLiga(String CodLiga, String nombreEquipo) {
		// Obtener el ID de la liga
		String idLiga = obtenerIdLiga(CodLiga);
		if (!idLiga.equals("")) {
			// Convertir el ID de la liga a entero
			int idLigaInt = Integer.parseInt(idLiga);
			// Comprobar si la liga ya ha empezado
			boolean ligaEmpezada = comprobarDatosEnPartidos(idLigaInt);
			if (!ligaEmpezada) {
				// Obtener el ID del equipo
				String idEquipo = (String) obtenerEquipoDeTable(nombreEquipo);
				// Insertar una nueva fila en la tabla equipo_pert_liga
				String union = "INSERT INTO equipo_pert_liga (IDEquipo, IDLiga) VALUES (?,?)";
				// Insertar una nueva fila en la tabla clasificacion
				String clasificacion = "INSERT INTO clasificacion (IDEquipo, IDLiga, Puntos, PartidosJugados, "
						+ "PartidosGanados, PartidosPerdidos, GolesAFavor, GolesEnContra, NombreEquipo) "
						+ "VALUES (?, ?, 0, 0, 0, 0, 0, 0, 'Equipo')";
				PreparedStatement proI;
				PreparedStatement proII;

				try {
					proI = conexion.prepareStatement(union);
					proI.setString(1, idEquipo);
					proI.setString(2, idLiga);
					proI.executeUpdate();
					proI.close();
					proII = conexion.prepareStatement(clasificacion);
					proII.setString(1, idEquipo);
					proII.setString(2, idLiga);
					proII.executeUpdate();
					proII.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
				unionLigaCorrecta = true;
			} else {
				unionLigaCorrecta = false;
			}
		} else {
			unionLigaCorrecta = false;
		}
	}

	/**
	 * Verifica si la unión de la liga se ha realizado correctamente.
	 * 
	 * @return true si la unión de la liga es correcta, false en caso contrario
	 */
	public boolean isUnionLigaCorrecta() {
		return unionLigaCorrecta;
	}

	/**
	 * Comprueba si los campos de login estan rellenos
	 * 
	 * @param empty  indica si el usuario está vacío
	 * @param length longitud de la contraseña
	 * @return true si los campos del login estan rellenos, false en caso contrario
	 */
	public boolean comprobarLoginRelleno(boolean empty, int length) {
		if (empty || length == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Incrementa el contador de intentos de login.
	 */
	public void setNumIntentos() {
		numIntentos++;
	}

	/**
	 * Comprueba si se ha alcanzado el número máximo de intentos de login.
	 * 
	 * @return true si se ha alcanzado el número máximo de intentos, false en caso
	 *         contrario
	 */
	public boolean comprobarIntentos() {
		if (numIntentos == 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Obtiene los datos de clasificación de una liga y un administrador
	 * específicos.
	 * 
	 * @param idLiga  el ID de la liga
	 * @param idAdmin el ID del administrador
	 * @return un objeto DefaultTableModel que contiene los datos de clasificación
	 *         de la liga
	 */
	public DefaultTableModel getClasificacion(int idLiga, int idAdmin) {
		String[] nombreColumnas = { "IDEquipo", "Nombre", "Puntos", "PartidosJugados", "PartidosGanados",
				"PartidosPerdidos", "GolesAFavor", "GolesEnContra" };
		DefaultTableModel model = new DefaultTableModel(nombreColumnas, 0);

		try {
			// Consulta SQL para obtener los datos de clasificación de la liga y el
			// administrador especificados
			String query = "SELECT Clasificacion.IDEquipo, Equipos.Nombre, Clasificacion.Puntos, "
					+ "Clasificacion.PartidosJugados, Clasificacion.PartidosGanados, Clasificacion.PartidosPerdidos, "
					+ "Clasificacion.GolesAFavor, Clasificacion.GolesEnContra FROM Clasificacion "
					+ "JOIN Equipos ON Clasificacion.IDEquipo = Equipos.IDEquipo WHERE Clasificacion.IDLiga = ?";

			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idLiga);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				// Obtener los datos de cada fila
				int equipoID = resultSet.getInt("IDEquipo");
				String nombreEquipo = resultSet.getString("Nombre");
				int puntos = resultSet.getInt("Puntos");
				int partidosJugados = resultSet.getInt("PartidosJugados");
				int partidosGanados = resultSet.getInt("PartidosGanados");
				int partidosPerdidos = resultSet.getInt("PartidosPerdidos");
				int golesAFavor = resultSet.getInt("GolesAFavor");
				int golesEnContra = resultSet.getInt("GolesEnContra");

				Object[] rowData = { equipoID, nombreEquipo, puntos, partidosJugados, partidosGanados, partidosPerdidos,
						golesAFavor, golesEnContra };
				model.addRow(rowData);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Agregar el listener de cambio de celda al JTable
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int column = e.getColumn();
					TableModel model = (TableModel) e.getSource();
					Object data = model.getValueAt(row, column);
					String columnName = model.getColumnName(column);

					// Actualizar la base de datos con el nuevo valor
					if (!columnName.equals("Nombre") && !columnName.equals("IDEquipo")) {
						String equipoID = (String) model.getValueAt(row, 0);

						try {
							String updateQuery = "UPDATE Clasificacion SET " + columnName + " = ? WHERE IDEquipo = ?";
							PreparedStatement updateStatement = conexion.prepareStatement(updateQuery);
							updateStatement.setObject(1, data);
							updateStatement.setString(2, equipoID);
							updateStatement.executeUpdate();
							updateStatement.close();
						} catch (SQLException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

		return model;
	}

	/**
	 * Obtiene los IDs de una liga y su administrador basado en el nombre de la
	 * liga.
	 * 
	 * @param liga el nombre de la liga
	 * @return un array de enteros que contiene los IDs de la liga y su
	 *         administrador
	 */
	public int[] obtenerIdsLigaAdmin(String liga) {
		String consulta = "SELECT id, idadmin FROM ligas WHERE nombre = ?";
		int ids[] = new int[2];
		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, liga);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int idLiga = rs.getInt("id");
				int idAdmin = rs.getInt("idadmin");
				ids[0] = idLiga;
				ids[1] = idAdmin;
			}

			// Cerrar la conexión y liberar recursos
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;
	}

	/**
	 * Establece los IDs de la liga y el administrador actual.
	 * 
	 * @param idLiga  el ID de la liga actual
	 * @param idAdmin el ID del administrador actual
	 */
	public void pasarIdsALigaEspecifica(int idLiga, int idAdmin) {
		idLigaActual = idLiga;
		idAdminActual = idAdmin;
	}

	/**
	 * Obtiene el ID de la liga actual.
	 * 
	 * @return el ID de la liga actual
	 */
	public int getIdLigaActual() {
		return idLigaActual;
	}

	/**
	 * Obtiene el ID del administrador de la liga actual.
	 * 
	 * @return el ID del administrador de la liga actual
	 */
	public int getIdAdminActual() {
		return idAdminActual;
	}

	/**
	 * Genera los partidos para una liga especificada.
	 * 
	 * @param idLiga el ID de la liga
	 */
	public void generarPartidos(int idLiga) {
		List<Integer> equipos = obtenerEquiposDeLiga(idLiga);

		int numEquipos = equipos.size();
		for (int i = 0; i < numEquipos - 1; i++) {
			int equipoLocal = equipos.get(i);
			for (int j = i + 1; j < numEquipos; j++) {
				int equipoVisitante = equipos.get(j);
				insertarPartido(equipoLocal, equipoVisitante, idLiga);
			}
		}
	}

	/**
	 * Obtiene la lista de equipos de una liga especificada.
	 * 
	 * @param idLiga el ID de la liga
	 * @return una lista de enteros que contiene los IDs de los equipos de la liga
	 */
	private List<Integer> obtenerEquiposDeLiga(int idLiga) {
		List<Integer> equipos = new ArrayList<>();

		try {
			String query = "SELECT IDEquipo FROM Equipo_Pert_Liga WHERE IDLiga = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idLiga);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int equipo = resultSet.getInt("IDEquipo");
				equipos.add(equipo);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return equipos;
	}

	/**
	 * Inserta un partido en la base de datos.
	 * 
	 * @param equipoLocal     el ID del equipo local
	 * @param equipoVisitante el ID del equipo visitante
	 * @param idLiga          el ID de la liga
	 */
	private void insertarPartido(int equipoLocal, int equipoVisitante, int idLiga) {
		try {
			String query = "INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setString(1, obtenerNombreEquipo(equipoLocal));
			statement.setString(2, obtenerNombreEquipo(equipoVisitante));
			statement.setString(3, "Lugar del partido");
			statement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			statement.setInt(5, idLiga);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene el nombre de un equipo basado en su ID.
	 * 
	 * @param idEquipo el ID del equipo
	 * @return el nombre del equipo
	 */
	private String obtenerNombreEquipo(int idEquipo) {
		String nombreEquipo = "";

		try {
			String query = "SELECT Nombre FROM Equipos WHERE IDEquipo = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idEquipo);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nombreEquipo = resultSet.getString("Nombre");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombreEquipo;
	}

	/**
	 * Busca ligas públicas en la base de datos que coincidan con el nombre
	 * especificado.
	 * 
	 * @param nombreLiga el nombre de la liga a buscar
	 * @return un DefaultTableModel que contiene las ligas públicas encontradas
	 */
	public DefaultTableModel BuscarLigas(String nombreLiga) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT nombre FROM ligas WHERE idadmin=1 and LOWER(ligas.nombre) like LOWER(?)";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			nombreLiga = "%" + nombreLiga + "%";
			stmt.setString(1, nombreLiga);
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

	/**
	 * Busca ligas privadas en la base de datos que coincidan con el nombre
	 * especificado.
	 * 
	 * @param nombreLiga el nombre de la liga a buscar
	 * @return un TableModel que contiene las ligas privadas encontradas
	 */
	public TableModel BuscarLigasPrivadas(String nombreLiga) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT Ligas.Nombre AS NombreLiga\r\n" + "FROM Ligas\r\n"
				+ "JOIN Equipo_Pert_Liga ON Ligas.ID = Equipo_Pert_Liga.IDLiga\r\n"
				+ "JOIN Equipos ON Equipo_Pert_Liga.IDEquipo = Equipos.IDEquipo\r\n"
				+ "JOIN Usuario_PertEquipo ON Equipos.IDEquipo = Usuario_PertEquipo.IDEquipo\r\n"
				+ "JOIN Usuario ON Usuario_PertEquipo.IDUsuario = Usuario.ID\r\n"
				+ "WHERE LOWER(ligas.Nombre) like LOWER(?)";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			nombreLiga = "%" + nombreLiga + "%";
			stmt.setString(1, nombreLiga);
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

	/**
	 * Busca las apuestas realizadas para un equipo específico en la base de datos.
	 * 
	 * @param nombreEquipoApostado el nombre del equipo apostado
	 * @return un TableModel que contiene las apuestas encontradas
	 */
	public TableModel buscarApuesta(String nombreEquipoApostado) {

		// Crear modelo de tabla por defecto
		DefaultTableModel model = new DefaultTableModel();

		// Conectar a la base de datos
		ConexionMySQL();

		// Consulta SQL para buscar las apuestas
		String consulta = "SELECT * FROM apuestas WHERE LOWER(ganador) like LOWER(?)";

		try {
			// Preparar la declaración SQL
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			nombreEquipoApostado = "%" + nombreEquipoApostado + "%";
			stmt.setString(1, nombreEquipoApostado);

			// Ejecutar la consulta y obtener el resultado
			ResultSet rs = stmt.executeQuery();

			// Agregar columnas al modelo de tabla

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

	/**
	 * Comprueba si el usuario actual es un invitado.
	 * 
	 * @return true si el usuario es un invitado, false en caso contrario
	 */
	public boolean comprobarInvitado() {
		if (usuario.equals("invitado")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Comprueba si existen datos en la tabla de partidos para una liga específica.
	 * 
	 * @param idLiga el ID de la liga
	 * @return true si existen datos en la tabla de partidos para la liga, false en
	 *         caso contrario
	 */
	public boolean comprobarDatosEnPartidos(int idLiga) {
		try {
			String query = "SELECT COUNT(*) AS count FROM Partidos WHERE IDLiga = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idLiga);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt("count");
				return count > 0;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Obtiene el nombre de una liga dado su ID.
	 * 
	 * @param idLiga el ID de la liga
	 * @return el nombre de la liga
	 */
	public String getNombreLiga(int idLiga) {
		String nombreLiga = "";

		try {
			String query = "SELECT Nombre FROM ligas WHERE ID = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idLiga);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				nombreLiga = resultSet.getString("Nombre");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombreLiga;
	}

	/**
	 * Actualiza la fecha del partido con el id de IdPartidoActual
	 * 
	 * @param nuevaFecha String con la nueva fecha del partido
	 */
	public void updateFechaPartido(String nuevaFecha) {
		String consulta = "UPDATE partidos SET fecha = ? WHERE id = ?";

		// Convertir el String de fecha a LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(nuevaFecha, formatter);

		// Convertir LocalDate a java.sql.Date
		java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setDate(1, sqlDate);
			stmt.setInt(2, idPartidoActual);
			stmt.executeUpdate();

			// Liberar recursos
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Establece el id de un partido concreto sacándolo de la DB
	 * 
	 * @param datos un array de strings que contiene equipo local, equipo visitante
	 *              y sede del partido para buscarlo en la DB
	 */
	public void setIdPartido(String[] datos) {
		String consulta = "SELECT id FROM partidos WHERE EquipoLocal = ? and EquipoVisitante = ? and lugar = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, datos[0]);
			stmt.setString(2, datos[1]);
			stmt.setString(3, datos[2]);
			idPartidoActual = stmt.executeUpdate();

			// Liberar recursos
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
