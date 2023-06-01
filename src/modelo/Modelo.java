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

	public void setVista(Vista miVista) {
		this.miVista = miVista;
	}

	public void modificarConfig(String[] datos) {
		try {
			// Abrir un flujo de salida de archivo para el archivo
			// de configuración
			FileOutputStream fos = new FileOutputStream(fConfig);
			fp.setProperty("usr", datos[0]); // Establecer la propiedad "usr" en el valor del primer elemento del
												// arreglo de datos
			fp.setProperty("pwd", datos[1]); // Establecer la propiedad "pwd" en el valor del segundo elemento del
												// arreglo de datos
			fp.setProperty("url", datos[2]); // Establecer la propiedad "url" en el valor del tercer elemento del
												// arreglo de datos
			fp.store(fos, ""); // Almacenar las propiedades en el archivo de configuración
			fos.close(); // Cerrar el flujo de salida de archivo
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // Imprimir la traza de la excepción si se produce un error al encontrar el
									// archivo
		} catch (IOException e) {
			e.printStackTrace(); // Imprimir la traza de la excepción si se produce un error de entrada/salida
		}
	}

	public String[] cargarConfig() {
		String[] datos = new String[3]; // Arreglo para almacenar los datos de configuración
		FileInputStream fis; // Objeto FileInputStream para leer el archivo de configuración
		try {
			fis = new FileInputStream(fConfig); // Abrir un flujo de entrada de archivo para el archivo de configuración
			fp.load(fis); // Cargar las propiedades del archivo en el objeto Properties fp
			datos[0] = fp.getProperty("usr");

			datos[1] = fp.getProperty("pwd");
			datos[2] = fp.getProperty("url");
			// Cerrar el flujo de entrada de archivo
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Devolver el arreglo de datos de configuración
		return datos;
	}

	public void ConexionMySQL() {

		FileInputStream fis;
		try {
			// Abre un flujo de entrada desde el archivo de configuración
			fis = new FileInputStream(fConfig);
			// Carga las propiedades desde el flujo de entrada al objeto de propiedades "fp"
			fp.load(fis);
		} catch (FileNotFoundException e) {
			// Captura una excepción si el archivo no se encuentra
			e.printStackTrace();
		} catch (IOException e) {
			// Captura una excepción si ocurre un error de entrada/salida
			e.printStackTrace();
		}

		// Obtiene los valores de las propiedades "usr", "pwd" y "url" del objeto de
		// propiedades "fp" y los asigna a las variables correspondientes
		this.usr = fp.getProperty("usr");
		this.pwd = fp.getProperty("pwd");
		this.url = fp.getProperty("url")
				+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

		try {
			// Carga la clase del controlador de JDBC de MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establece la conexión con la base de datos utilizando la URL, el nombre de
			// usuario y la contraseña
			conexion = DriverManager.getConnection(url, usr, pwd);
			System.out.println("-> Conexión con MySQL establecida");
		} catch (ClassNotFoundException e) {
			// Captura una excepción si no se encuentra el controlador JDBC
			System.out.println("Driver JDBC No encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			// Captura una excepción si ocurre un error de SQL al conectarse a la base de
			// datos
			System.out.println("Error al conectarse a la BD");
			e.printStackTrace();
		} catch (Exception e) {
			// Captura cualquier otra excepción no especificada anteriormente
			System.out.println("Error general de Conexion");
			e.printStackTrace();
		}
	}

	public boolean registro() {

		// Obtener los valores ingresados en la vista
		String nombre = ((_02_Registro) miVista).getNombre();
		String apellido1 = ((_02_Registro) miVista).getApellido1();
		String apellido2 = ((_02_Registro) miVista).getApellido2();
		String correo = ((_02_Registro) miVista).getCorreo();
		String fecha = ((_02_Registro) miVista).getfecha();
		String Pwd = ((_02_Registro) miVista).getPwd();
		String User = ((_02_Registro) miVista).getUser();

		// Realizar la conexión a MySQL
		ConexionMySQL();

		// Llamar al método registrarse() con los datos ingresados y retornar el
		// resultado
		return registrarse(nombre, apellido1, apellido2, correo, fecha, Pwd, User);
	}

	// Metodo para registrarse introduciendo todos los datos que necesitamos para
	// crear un usuario
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
				// Si no se encuentra ningún registro con el mismo correo o usuario, procedemos
				// a registrar al nuevo usuario
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
					// En caso de que ocurra un error al ejecutar la inserción, se imprime el
					// mensaje de error específico
					System.err.println(e.getMessage());
					resultado = false;
				}
			} else {
				// Si ya existe un usuario con el mismo correo o usuario, se establece el
				// resultado como falso
				resultado = false;
			}
			proII.close();
		} catch (SQLException e1) {
			// En caso de que ocurra un error al ejecutar la consulta, se imprime el rastro
			// de la excepción
			e1.printStackTrace();
			resultado = false;
		}

		return resultado;
	}

	// Comprobamos que se puede pulsar el botón "Registrarse"
	public boolean comprobarTodosRellenos(boolean nombre, boolean correo, boolean user, int password,
			boolean apellido1) {
		boolean todoRelleno = true;
		// Si alguno de los campos obligatorios está vacío (nombre, correo, usuario,
		// apellido1) o la contraseña es 0, establecemos todoRelleno como falso
		if (nombre || correo || user || apellido1 || password == 0) {
			todoRelleno = false;
		}

		return todoRelleno;
	}

	// Comprobamos que se puedan proporcionar todos los datos requeridos
	public boolean comprobarTodosRellenos(boolean nombre, boolean deporte, Date fecha) {
		boolean todoRelleno = true;
		if (nombre || deporte || fecha == null) {
			// Si alguno de los campos obligatorios (nombre, deporte) está vacío o la fecha
			// es nula, establecemos todoRelleno como falso
			todoRelleno = false;
		}

		return todoRelleno;
	}

	// Método que realiza el proceso de inicio de sesión.
	public boolean login(String usr, String pwd) {
		ConexionMySQL();
		String id;
		try {
			String insert = "SELECT id, usuario, contraseña FROM usuario";
			PreparedStatement proI = conexion.prepareStatement(insert);
			ResultSet rset = proI.executeQuery();
			while (rset.next()) {
				if (rset.getString(2).equals(usr) && rset.getString(3).equals(pwd)) {
					// Si se encuentra una coincidencia en el nombre de usuario y contraseña, se
					// establece el id del usuario actual
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
			// Si no se encuentra una coincidencia, se actualiza la vista para mostrar un
			// mensaje de inicio de sesión fallido
			((_01_InicioSesion2) miVista).actualizar(false);
			return false;
		} catch (SQLException e) {
			// En caso de que ocurra un error al ejecutar la consulta, se imprime el mensaje
			// de error específico
			System.err.println(e.getMessage());
			return false;
		}
	}

	// Método getUsuario
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	// Método que devuelve un objeto DefaultTableModel que contiene los nombres de
	// las ligas públicas obtenidas de la base de datos
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
			// En caso de error, se imprime la traza de la excepción
			e.printStackTrace();
		}

		return model;
	}

	// Método devuelve un objeto DefaultTableModel que contiene los nombres de las
	// ligas privadas a las que pertenece el usuario actual.
	public DefaultTableModel getLigasPrivadas() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		// se realiza una consulta compleja que involucra varias tablas para obtener los
		// nombres de las ligas privadas asociadas al usuario actual.
		String consulta = "SELECT Ligas.Nombre AS NombreLiga " + "FROM Ligas "
				+ "JOIN Equipo_Pert_Liga ON Ligas.ID = Equipo_Pert_Liga.IDLiga "
				+ "JOIN Equipos ON Equipo_Pert_Liga.IDEquipo = Equipos.IDEquipo "
				+ "JOIN Usuario_PertEquipo ON Equipos.IDEquipo = Usuario_PertEquipo.IDEquipo "
				+ "JOIN Usuario ON Usuario_PertEquipo.IDUsuario = Usuario.ID " + "WHERE Usuario.ID = ?";

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
			// En caso de error, se imprime la traza de la excepción
			e.printStackTrace();
		}

		return model;
	}

	// método devuelve un array de tipo String que contiene los datos de la cuenta
	// del usuario actual.
	public String[] getMiCuenta() {
		String consulta = "SELECT usuario, nombre, apellido1, apellido2, contraseña, correo, edad FROM usuario WHERE id = ?";
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
			// En caso de error, se imprime la traza de la excepción
			e.printStackTrace();
		}

		return datos;
	}

	// Este método permite actualizar los datos de la cuenta del usuario
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
			// En caso de error, se imprime la traza de la excepción
			e.printStackTrace();
			return 0;
		}
	}

	// Este método devuelve un ComboBoxModel que contiene los nombres de los equipos
	// asociados al usuario actual.
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

			// Agregar los equipos del usuario al modelo del ComboBox
			while (rs.next()) {
				String rowData = rs.getString("Nombre");
				model.addElement(rowData);
			}
			rs.close();

		} catch (SQLException e) {
			// En caso de error, se imprime la traza de la excepción
			e.printStackTrace();
		}

		return model;
	}

	// Este método genera un código aleatorio para un equipo.
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

	// Este método genera un código aleatorio para una liga.
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

	// Este método verifica si un código de equipo dado existe en la base de datos
	public boolean verificarCodEquipo(String codEquipo) {
		ConexionMySQL();
		// Consulta SQL para buscar en la tabla Equipos aquellos registros que coincidan
		// con el código de equipo proporcionado
		String consulta = "SELECT idequipo, CodEquipo FROM Equipos WHERE CodEquipo = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, codEquipo);
			ResultSet rs = stmt.executeQuery();

			boolean existeEquipo = rs.next();
			if (existeEquipo) {
				// Si el equipo existe en la base de datos
				String idEquipo = rs.getString("idequipo");

				rs.close();
				stmt.close();
				((_06_UnirseEquipo2) miVista).error(false);

				// Insertar la relación entre el usuario y el equipo en la tabla
				// usuario_pertequipo
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

	// Este método obtiene las apuestas realizadas por un usuario específico
	// identificado por idUsuario.
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

	// Este método se encarga de insertar un nuevo equipo en la base de datos.
	public void InsertEquipo() {
		String codigo;
		String nombreEquip = ((_08_CrearEquipos) miVista).getNombreEquipo();
		String sede = ((_08_CrearEquipos) miVista).getSede();
		String deporte = ((_08_CrearEquipos) miVista).getDeporte();

		// Generar un código de equipo único
		do {
			codigo = getCodigoEquipo();
		} while (comprobarCodigoEquipo(codigo));

		// Insertar el equipo en la base de datos
		InsertarEquipo(nombreEquip, deporte, sede, codigo);
	}

	// Este método se encarga de comprobar si un código de equipo ya está en uso en
	// la base de datos.
	public boolean comprobarCodigoEquipo(String codigo) {
		String consulta = "SELECT nombre FROM Equipos WHERE CodEquipo=?";
		PreparedStatement proI;

		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, codigo);
			ResultSet rs = proI.executeQuery();

			// Verificar si existe un equipo con el código proporcionado
			if (rs.next()) {
				// Si hay resultados, significa que el código de equipo ya está en uso
				return true;
			} else {
				// Si no hay resultados, el código de equipo no está en uso
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Si ocurre una excepción, se asume que el código de equipo está en uso
			return true;
		}
	}

	// Este método se encarga de insertar un nuevo equipo en la base de datos y
	// establecer la relación entre el usuario actual y el equipo
	public void InsertarEquipo(String NombreEquipo, String Deporte, String Sede, String CodEquipo) {
		ConexionMySQL();

		// Sentencia SQL para insertar un nuevo equipo en la tabla Equipos
		String insert = "INSERT INTO Equipos (Nombre, Deporte, Estadio, CodEquipo) VALUES (?,?,?,?)";

		// Consulta SQL para obtener el ID del equipo recién insertado
		String consulta = "SELECT IDEquipo FROM equipos WHERE CodEquipo = ?";

		// Sentencia SQL para insertar una relación entre el usuario y el equipo en la
		// tabla usuario_pertequipo
		String Insert2 = "INSERT INTO usuario_pertequipo (IDUsuario, IDEquipo) VALUES (?,?)";

		PreparedStatement proI;
		PreparedStatement pro2;
		PreparedStatement pro3;

		try {
			// Insertar el nuevo equipo en la tabla Equipos
			proI = conexion.prepareStatement(insert);
			proI.setString(1, NombreEquipo);
			proI.setString(2, Deporte);
			proI.setString(3, Sede);
			proI.setString(4, CodEquipo);
			proI.executeUpdate();
			proI.close();

			// Obtener el ID del equipo recién insertado
			pro2 = conexion.prepareStatement(consulta);
			pro2.setString(1, CodEquipo);
			ResultSet rs = pro2.executeQuery();
			rs.next();
			String IdEquipo = rs.getString(1);

			// Insertar la relación entre el usuario y el equipo en la tabla
			// usuario_pertequipo
			pro3 = conexion.prepareStatement(Insert2);
			pro3.setString(1, usuario);
			pro3.setString(2, IdEquipo);
			pro3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Este método se encarga de obtener las ligas a las que pertenece un equipo y
	// devuelve un objeto DefaultTableModel con los nombres de las ligas
	public DefaultTableModel getLigasDeEquipo() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();

		// Consulta SQL para obtener las ID de las ligas a las que pertenece el equipo
		String consulta = "SELECT IDLiga FROM equipo_pert_liga WHERE IDEquipo = ?";

		// Consulta SQL para obtener el nombre de la liga dado su ID
		String consultaNombreEquip = "SELECT Nombre FROM ligas WHERE ID = ?";

		PreparedStatement proI;
		PreparedStatement pro2;

		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);
			ResultSet rs = proI.executeQuery();

			ArrayList<String> idLigaList = new ArrayList<>();

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

	// Este método se encarga de obtener los usuarios que pertenecen a un equipo y
	// devuelve un objeto DefaultTableModel con los nombres de los usuarios.
	public DefaultTableModel getUsuarioDeLiga(String equipoActual) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();

		// Consulta SQL para obtener los ID de los usuarios que pertenecen al equipo
		String consulta = "SELECT IDUsuario FROM usuario_pertequipo WHERE IDEquipo = ?";

		// Consulta SQL para obtener el nombre del usuario dado su ID
		String consultaNombreEquip = "SELECT Nombre FROM usuario WHERE ID = ?";

		PreparedStatement proI;
		PreparedStatement pro2;

		try {
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, equipoActual);
			ResultSet rs = proI.executeQuery();

			ArrayList<String> idUsuarios = new ArrayList<>();

			// Obtener los ID de los usuarios y guardarlos en la lista idUsuarios
			while (rs.next()) {
				idUsuarios.add(rs.getString(1));
			}

			String[] idLiga = idUsuarios.toArray(new String[0]);

			model.addColumn("Jugadores");

			// Obtener el nombre de cada usuario y agregarlo como una fila en el modelo de
			// tabla
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

	// Este método getSede recibe como parámetro el identificador de un equipo
	// (equipoActual) y devuelve la sede o estadio asociado a ese equipo
	public String getSede(String equipoActual) {
		String consulta = "SELECT Estadio FROM equipos WHERE IDEquipo = ?;"; // Consulta SQL para obtener el estadio del
																				// equipo actual
		PreparedStatement proI;
		String estadio = "";
		try {
			proI = conexion.prepareStatement(consulta); // Preparar la consulta SQL
			proI.setString(1, equipoActual); // Establecer el parámetro de la consulta con el valor del equipo actual
			ResultSet rs = proI.executeQuery(); // Ejecutar la consulta y obtener el resultado
			rs.next(); // Mover el cursor al primer resultado
			estadio = rs.getString(1); // Obtener el valor del estadio desde el resultado

		} catch (SQLException e) {
			// Imprimir traza de la excepción en caso de error
			e.printStackTrace();
		}
		return estadio; // Devolver el valor del estadio
	}

	public String getdeporte(String equipoActual) {
		// Consulta para obtener el deporte del equipo
		String consulta = "select Deporte from equipos where IDEquipo = ?;";
		PreparedStatement proI;
		String deporte = "";
		try {
			proI = conexion.prepareStatement(consulta); // Preparar la consulta SQL
			proI.setString(1, IdEquipo); // Asignar el valor del parámetro al placeholder de la consulta
			ResultSet rs = proI.executeQuery(); // Ejecutar la consulta y obtener el resultado
			rs.next(); // Mover el cursor al primer resultado
			deporte = rs.getString(1); // Obtener el valor de la columna "Deporte"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); // Manejar la excepción en caso de error
		}
		return deporte; // Devolver el deporte del equipo
	}

	// Este método recibe como parámetro el identificador de un equipo
	// (equipoActual) y devuelve el nombre del equipo correspondiente a ese
	// identificador
	public String getEquipo(String equipoActual) {
		String consulta = "select Nombre from equipos where IDEquipo = ?;";

		// Preparar la consulta SQL
		PreparedStatement proI;

		// Variable para almacenar el nombre del equipo
		String equipo = "";

		try {
			// Asignar el valor del parámetro al placeholder de la consulta
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);

			// Ejecutar la consulta y obtener el resultado
			ResultSet rs = proI.executeQuery();

			// Mover el cursor al primer resultado
			rs.next();

			// Obtener el valor de la columna "Nombre"
			equipo = rs.getString(1);
		} catch (SQLException e) {
			// Manejar la excepción en caso de error
			e.printStackTrace();
		}

		// Devolver el nombre del equipo
		return equipo;
	}

	// Este método recibe como parámetro el identificador de un equipo
	// (equipoActual) y devuelve el código del equipo correspondiente a ese
	// identificador.
	public String getCodigo(String equipoActual) {
		String consulta = "select CodEquipo from equipos where IDEquipo = ?;";

		// Preparar la consulta SQL
		PreparedStatement proI;

		// Variable para almacenar el código del equipo
		String codigo = "";

		try {
			// Asignar el valor del parámetro al placeholder de la consulta
			proI = conexion.prepareStatement(consulta);
			proI.setString(1, IdEquipo);

			// Ejecutar la consulta y obtener el resultado
			ResultSet rs = proI.executeQuery();

			// Mover el cursor al primer resultado
			rs.next();

			// Obtener el valor de la columna "CodEquipo"
			codigo = rs.getString(1);
		} catch (SQLException e) {
			// Manejar la excepción en caso de error
			e.printStackTrace();
		}

		// Devolver el código del equipo
		return codigo;
	}

	// Este método obtiene los equipos de los partidos de acuerdo a los datos de
	// apuesta proporcionados
	public DefaultTableModel obtenerEquiposDePartidos(String[] datosApuesta) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		// Realiza una consulta SQL para obtener los equipos locales y visitantes de los
		// partidos
		String consulta = "SELECT EquipLocal, EquipVisitante FROM Partidos WHERE EquipLocal=? AND EquipVisitante=?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, datosApuesta[0]);
			stmt.setString(2, datosApuesta[1]);
			ResultSet rs = stmt.executeQuery();
			// Agrega las columnas correspondientes al modelo
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

	public DefaultTableModel getApuestaActual() {
		return apuestaActual;
	}

	// Este método obtiene los partidos de una liga específica según el ID de la
	// liga proporcionado.
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

	// Este método se utiliza para crear una nueva liga en la base de datos
	public String crearLiga(String[] datos) {
		String consulta = "INSERT INTO ligas (premio,nombre,sede,fechaInicio,privacidad,deporte,idAdmin,CodLiga) VALUES (?,?,?,?,?,?,?,?)";
		String codigo = getCodigoLiga();
		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setInt(1, Integer.parseInt(datos[5])); // Premio
			stmt.setString(2, datos[0]); // Nombre
			stmt.setString(3, datos[4]); // Sede

			// Convertir el String de fecha a LocalDate
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.parse(datos[2], formatter);

			// Convertir LocalDate a java.sql.Date
			java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
			stmt.setDate(4, sqlDate); // Fecha de inicio

			stmt.setString(5, datos[3]); // Privacidad
			stmt.setString(6, datos[1]); // Deporte
			stmt.setString(7, usuario); // ID del administrador
			stmt.setString(8, codigo); // Código de la liga

			int res = stmt.executeUpdate(); // Ejecutar la inserción

			// Liberar recursos
			stmt.close();

			if (res > 0)
				return codigo; // Devolver el código de la liga si la inserción fue exitosa
			else
				return ""; // Devolver una cadena vacía si la inserción falló

		} catch (SQLException e) {
			e.printStackTrace();
			return ""; // Devolver una cadena vacía en caso de excepción
		}
	}

	// Este método se utiliza para obtener las apuestas realizadas por un usuario
	// específico
	public DefaultTableModel obtenerApuestas() {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT Fecha, Partido, Cantidad, Pronostico FROM Apuestas WHERE IDUsuario = ?";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setInt(1, Integer.parseInt(getUsuario()));

			ResultSet rs = stmt.executeQuery();
			// Se agregan las columnas al modelo de tabla
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

	// Este método se utiliza para obtener el ID del equipo correspondiente a un
	// nombre de equipo dado.
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return IdEquipo;
	}

	// método se utiliza para obtener el ID de una liga correspondiente a un código
	// de liga dado.
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

	// método que se utiliza para unirse a una liga específica con un equipo
	// determinado.
	public void unirseLiga(String CodLiga, String nombreEquipo) {
		String idLiga = obtenerIdLiga(CodLiga);
		if (!idLiga.equals("")) {

			int idLigaInt = Integer.parseInt(idLiga);
			boolean ligaEmpezada = comprobarDatosEnPartidos(idLigaInt);
			if (!ligaEmpezada) {
				String idEquipo = (String) obtenerEquipoDeTable(nombreEquipo);

				// Realizar la inserción en la tabla 'equipo_pert_liga'
				String union = "INSERT INTO equipo_pert_liga (IDEquipo, IDLiga) VALUES (?,?)";
				// Realizar la inserción en la tabla 'clasificacion'
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

	public boolean isUnionLigaCorrecta() {
		return unionLigaCorrecta;
	}

	// Este método se utiliza para comprobar si el inicio de sesión está completo
	public boolean comprobarLoginRelleno(boolean empty, int length) {
		if (empty || length == 0) {
			return false;
		} else {
			return true;
		}

	}

	// Este método incrementa el número de intentos
	public void setNumIntentos() {
		numIntentos++;
	}

	// Este método comprueba si el número de intentos es igual a 3
	public boolean comprobarIntentos() {

		if (numIntentos == 3) {
			return true;
		} else {
			return false;
		}
	}

	// Método que obtiene la clasificación de una liga específica.
	public DefaultTableModel getClasificacion(int idLiga, int idAdmin) {
		String[] nombreColumnas = { "IDEquipo", "Nombre", "Puntos", "PartidosJugados", "PartidosGanados",
				"PartidosPerdidos", "GolesAFavor", "GolesEnContra" };
		DefaultTableModel model = new DefaultTableModel(nombreColumnas, 0);

		try {
			// Consulta SQL para obtener la clasificación de la tabla Clasificacion
			// y unirlo con la tabla Equipos para obtener el nombre del equipo.
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

				// Crear un arreglo con los datos de la fila y agregarlo al modelo de tabla
				Object[] rowData = { equipoID, nombreEquipo, puntos, partidosJugados, partidosGanados, partidosPerdidos,
						golesAFavor, golesEnContra };
				model.addRow(rowData);
			}

			// Cerrar recursos
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Agregar el listener de cambio de celda al modelo de tabla
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int column = e.getColumn();
					TableModel model = (TableModel) e.getSource();
					Object data = model.getValueAt(row, column);
					String columnName = model.getColumnName(column);

					// Actualizar la base de datos con el nuevo valor si la columna no es "Nombre"
					// ni "IDEquipo"
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

	// método recupera los IDs de una liga y su administrador
	public int[] obtenerIdsLigaAdmin(String liga) {
		String consulta = "SELECT id, idadmin FROM ligas WHERE nombre = ?";
		int ids[] = new int[2];
		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			stmt.setString(1, liga);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// Obtener los IDs de la liga y el administrador
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

	// método que asigna los IDs de una liga y su administrador a las variables
	public void pasarIdsALigaEspecifica(int idLiga, int idAdmin) {
		idLigaActual = idLiga;
		idAdminActual = idAdmin;
	}

	public int getIdLigaActual() {
		return idLigaActual;
	}

	public int getIdAdminActual() {
		return idAdminActual;
	}

	// Método que se encarga de generar los partidos para una liga específica
	public void generarPartidos(int idLiga) {
		List<Integer> equipos = obtenerEquiposDeLiga(idLiga);

		int numEquipos = equipos.size();
		for (int i = 0; i < numEquipos - 1; i++) {
			// Seleccionar el equipo local para el partido actual
			int equipoLocal = equipos.get(i);
			for (int j = i + 1; j < numEquipos; j++) {
				// Seleccionar el equipo visitante para el partido actual
				int equipoVisitante = equipos.get(j);
				// Insertar el partido en la base de datos
				insertarPartido(equipoLocal, equipoVisitante, idLiga);
			}
		}
	}

	// método que se encarga de obtener los IDs de los equipos que pertenecen a una
	// liga específica
	private List<Integer> obtenerEquiposDeLiga(int idLiga) {
		List<Integer> equipos = new ArrayList<>();

		try {
			// Consulta para obtener los equipos que pertenecen a la liga
			String query = "SELECT IDEquipo FROM Equipo_Pert_Liga WHERE IDLiga = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idLiga);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// Obtener el ID del equipo y agregarlo a la lista de equipos
				int equipo = resultSet.getInt("IDEquipo");
				equipos.add(equipo);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return equipos;
	}

	// El método que se encarga de insertar un nuevo partido en la tabla de partidos
	private void insertarPartido(int equipoLocal, int equipoVisitante, int idLiga) {
		try {
			// Consulta para insertar un nuevo partido en la tabla Partidos
			String query = "INSERT INTO Partidos (EquipLocal, EquipVisitante, Lugar, Fecha, IDLiga) "
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = conexion.prepareStatement(query);
			// Asigna el nombre del equipo local al primer parámetro de la consulta.
			statement.setString(1, obtenerNombreEquipo(equipoLocal));
			// Asigna el nombre del equipo visitante al segundo parámetro de la consulta.
			statement.setString(2, obtenerNombreEquipo(equipoVisitante));
			// Asigna el lugar del partido al tercer parámetro de la consulta.
			statement.setString(3, "Lugar del partido");
			// Asigna la fecha actual al cuarto parámetro de la consulta.
			statement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			// Asigna el ID de la liga al quinto parámetro de la consulta.
			statement.setInt(5, idLiga);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método que se encarga de obtener el nombre de un equipo a partir de su ID.
	private String obtenerNombreEquipo(int idEquipo) {
		String nombreEquipo = "";

		try {
			// Consulta para obtener el nombre del equipo a partir de su ID
			String query = "SELECT Nombre FROM Equipos WHERE IDEquipo = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idEquipo);

			ResultSet resultSet = statement.executeQuery();
			// Si hay un resultado, obtiene el nombre del equipo de la columna "Nombre" y lo
			// asigna a la variable
			if (resultSet.next()) {
				nombreEquipo = resultSet.getString("Nombre");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombreEquipo;
	}

	// Méto que busca ligas públicas que coincidan con un nombre específico
	public DefaultTableModel BuscarLigas(String nombreLiga) {
		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT nombre FROM ligas WHERE idadmin=1 and LOWER(ligas.nombre) like LOWER(?)";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			// Prepara el parámetro de la consulta buscar
			// coincidencias parciales en cualquier posición del nombre de la liga.
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

	// Método que busca ligas privadas cuyo nombre coincida con el parámetro
	// especificado
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

	// busca ligas privadas cuyo nombre coincida con el parámetro especificado
	public TableModel buscarApuesta(String nombreEquipoApostado) {

		DefaultTableModel model = new DefaultTableModel();
		ConexionMySQL();
		String consulta = "SELECT * FROM apuestas WHERE LOWER(ganador) like LOWER(?)";

		try {
			PreparedStatement stmt = conexion.prepareStatement(consulta);
			nombreEquipoApostado = "%" + nombreEquipoApostado + "%";
			stmt.setString(1, nombreEquipoApostado);
			ResultSet rs = stmt.executeQuery();

			model.addColumn("");

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

	public boolean comprobarInvitado() {
		if (usuario.equals("invitado")) {
			return true;
		} else {
			return false;
		}
	}

	// Método que verifica si existen registros en la tabla "Partidos" para una liga
	// específica.
	public boolean comprobarDatosEnPartidos(int idLiga) {
		try {
			String query = "SELECT COUNT(*) AS count FROM Partidos WHERE IDLiga = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idLiga);

			ResultSet resultSet = statement.executeQuery();

			// Verificar si hay registros en el resultado de la consulta
			if (resultSet.next()) {
				int count = resultSet.getInt("count");
				// Devolver true si el conteo es mayor que cero, indicando que hay datos en la
				// tabla de partidos
				return count > 0;
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	// método que obtiene el nombre de una liga específica dado su ID.
	public String getNombreLiga(int idLiga) {
		String nombreLiga = "";

		try {
			String query = "SELECT Nombre FROM ligas WHERE ID = ?";
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setInt(1, idLiga);

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				// Verifica si hay registros en el resultado de la consulta
				nombreLiga = resultSet.getString("Nombre");
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nombreLiga;
	}

}
