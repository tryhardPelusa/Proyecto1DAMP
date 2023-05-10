package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.JScrollPane;

/**
 * 
 * @author josem
 *
 */

public class _09_LigaEspecifica2 extends JFrame implements Vista {

    // Creamos las variables siguiendo las convenciones al nombrarlas
    private Controlador miControlador;
    private Modelo miModelo;

    private JPanel contentPane;
    private JLabel lblFondo;
    private JLabel lblLogo;
    private JPanel background;
    private JTabbedPane tabbedPane;
    private JTable tableClasificacion;
    private JTable tableCalendario;
    private JPanel panelClasificacion;
    private JPanel panelCalendario;
    private JScrollPane scrollPaneClasificacion;
    private JScrollPane scrollPaneCalendario;
    private JLabel lblNombreLiga;
    private JButton btnVerEquipo;
    private JButton btnApostar;
    private JButton btnModificar_2;

    public _09_LigaEspecifica2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1024, 576);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        background = new JPanel();
        background.setBackground(new Color(0, 128, 192));
        background.setBounds(0, 0, 1008, 537);
        contentPane.add(background);
        background.setLayout(null);

        lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/fondoLogin2  - copia.jpg")));
        lblFondo.setBounds(725, 0, 283, 537);
        background.add(lblFondo);

        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(_01_InicioSesion2.class.getResource("/img/logo.png")));
        lblLogo.setBounds(10, 11, 150, 64);
        background.add(lblLogo);

        // Crea el contenedor para poder poner las pestañas
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(136, 183, 429, 206);
        background.add(tabbedPane);

        // Crea el panel de "Clasificacion"
        panelClasificacion = new JPanel();
        tabbedPane.addTab("Clasificacion", null, panelClasificacion, null);
        panelClasificacion.setLayout(null);

        // Se crea el scrollpanel para poder meter la clasificacion y su tabla dentro
        scrollPaneClasificacion = new JScrollPane();
        scrollPaneClasificacion.setBounds(0, 0, 424, 178);
        panelClasificacion.add(scrollPaneClasificacion);

        // Tabla con los resultados de la liga
        tableClasificacion = new JTable();
        tableClasificacion.setFont(new Font("Calibri", Font.PLAIN, 11));
        tableClasificacion.setModel(new DefaultTableModel(
                new Object[][] { { "Real Madrid", 12, 5, 4, 1, 14, 5 }, { "Barcelona", 10, 5, 3, 1, 12, 6 },
                        { "Cordoba", 8, 5, 2, 3, 10, 9 }, { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
                new String[] { "Equipo", "Puntos", "PJ", "PG", "PP", "GF", "GC" }));
        scrollPaneClasificacion.setViewportView(tableClasificacion);

        // Personaliza el estilo de las celdas de encabezado de la tabla
        JTableHeader headerClasificacion = tableClasificacion.getTableHeader();
        headerClasificacion.setFont(new Font("Calibri", Font.PLAIN, 11));
        headerClasificacion.setBackground(new Color(0, 128, 192));
        headerClasificacion.setForeground(Color.WHITE);

        // Personaliza el estilo de las celdas de datos de la tabla
        DefaultTableCellRenderer cellRendererClasificacion = new DefaultTableCellRenderer();
        cellRendererClasificacion.setBackground(new Color(230, 230, 250));
        cellRendererClasificacion.setForeground(Color.BLACK);
        for (int i = 0; i < tableClasificacion.getColumnCount(); i++) {
            tableClasificacion.getColumnModel().getColumn(i).setCellRenderer(cellRendererClasificacion);
        }

        // Crea el panel de "Calendario"
        panelCalendario = new JPanel();
        tabbedPane.addTab("Calendario", null, panelCalendario, null);
        panelCalendario.setLayout(null);

        // Se crea el scrollpanel para poder meter el calendario y su tabla dentro
        scrollPaneCalendario = new JScrollPane();
        scrollPaneCalendario.setBounds(0, 0, 424, 178);
        panelCalendario.add(scrollPaneCalendario);

        // Crea la tabla del calendario
        tableCalendario = new JTable();
        tableCalendario.setModel(new DefaultTableModel(
                new Object[][] { { "2023-05-10", "Real Madrid", "Valencia", "Pista U-Tad" },
                        { "2023-05-11", "Barcelona", "Cadiz", "Camp Nou" },
                        { "2023-05-12", "Valencia", "Sevilla", "Old Trafford" }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null }, },
                new String[] { "Fecha", "Equipo Local", "Equipo Visitante", "Sede" }));
        scrollPaneCalendario.setViewportView(tableCalendario);

        // Personaliza el estilo de las celdas de encabezado de la tabla
        JTableHeader headerCalendario = tableCalendario.getTableHeader();
        headerCalendario.setFont(new Font("Calibri", Font.BOLD, 12));
        headerCalendario.setBackground(new Color(0, 128, 192));
        headerCalendario.setForeground(Color.WHITE);

        // Personaliza el estilo de las celdas de datos de la tabla
        DefaultTableCellRenderer cellRendererCalendario = new DefaultTableCellRenderer();
        cellRendererCalendario.setBackground(new Color(230, 230, 250));
        cellRendererCalendario.setForeground(Color.BLACK);
        for (int i = 0; i < tableCalendario.getColumnCount(); i++) {
            tableCalendario.getColumnModel().getColumn(i).setCellRenderer(cellRendererCalendario);
        }

        lblNombreLiga = new JLabel("Liga DAM U-Tad");
        lblNombreLiga.setFont(new Font("Britannic Bold", Font.BOLD, 40));
        lblNombreLiga.setBounds(136, 97, 332, 64);
        background.add(lblNombreLiga);

        btnVerEquipo = new JButton("Ver Equipo");
        btnVerEquipo.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
        btnVerEquipo.setBackground(new Color(255, 128, 0));
        btnVerEquipo.setBounds(135, 419, 111, 23);
        background.add(btnVerEquipo);

        btnApostar = new JButton("Apostar");
        btnApostar.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
        btnApostar.setBackground(new Color(255, 128, 0));
        btnApostar.setBounds(297, 419, 111, 23);
        background.add(btnApostar);

        btnModificar_2 = new JButton("Modificar");
        btnModificar_2.setFont(new Font("Britannic Bold", Font.PLAIN, 16));
        btnModificar_2.setBackground(new Color(255, 128, 0));
        btnModificar_2.setBounds(454, 419, 111, 23);
        background.add(btnModificar_2);
    }

    @Override
    public void setModelo(Modelo miModelo) {
        this.miModelo = miModelo;

    }

    @Override
    public void setControlador(Controlador miControlador) {
        this.miControlador = miControlador;
    }
}
