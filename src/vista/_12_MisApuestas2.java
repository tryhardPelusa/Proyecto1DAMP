/*
 * @Author Javier Turienzo
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Modelo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class _12_MisApuestas2 extends JFrame implements Vista {

	// Atributos
	private Controlador miControlador;
	private Modelo miModelo;

	private JLabel lblBarraMoverVentana;
    private int xMouse, yMouse;
	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblLogo;
	private JPanel background;
	private JButton btnMiCuenta;
	private JButton btnVerLigas;
	private JButton btnCrearLiga;
	private JButton btnUnirseALiga;
	private JButton btnCrearEquipo;
	private JButton btnUnirseAEquipo;
	private JButton btnMisApuestas;
	private JButton btnApostar;
	private JButton btnSignOut;
	private JTabbedPane tabbedPane;
	private JPanel panelCurso;
	private JScrollPane scrollPaneCurso;
	private JTable tblCurso;
	private JPanel panelFinalizadas;
	private JScrollPane scrollPaneFinalizadas;
	private JTable tblFinalizadas;
	private JTextField txtbuscar;
	private JButton btnBuscar;

	// Constructor
	public _12_MisApuestas2() {
		setTitle("Plantilla");
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setLocationByPlatform(rootPaneCheckingEnabled);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1010, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		background = new JPanel();
		background.setBorder(null);
		background.setBackground(new Color(0, 128, 192));
		background.setBounds(0, 0, 1010, 539);
		contentPane.add(background);
		background.setLayout(null);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_12_MisApuestas2.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(0, 0, 283, 539);
		background.add(lblFondo);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(_12_MisApuestas2.class.getResource("/img/logo.png")));
		lblLogo.setBounds(290, 11, 150, 64);
		background.add(lblLogo);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(160, 160, 160));
		separator.setBackground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(282, 0, 13, 537);
		background.add(separator);

		JLabel lblBtnCerrar = new JLabel("");
		lblBtnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
		    public void mouseEntered(MouseEvent e) {
				lblBtnCerrar.setBackground(Color.RED);
				lblBtnCerrar.setOpaque(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblBtnCerrar.setBackground(null);
		    	lblBtnCerrar.setOpaque(false);
		    	setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		    }
		});
		lblBtnCerrar.setIcon(new ImageIcon(_00_PaginaPrincipal2.class.getResource("/img/close.png")));
		lblBtnCerrar.setBounds(970, 0, 40, 40);
		background.add(lblBtnCerrar);

		JLabel lblBtnMinimizar = new JLabel("");
		lblBtnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBtnMinimizar.setBackground(Color.BLUE);
				lblBtnMinimizar.setOpaque(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBtnMinimizar.setBackground(null);
		    	lblBtnMinimizar.setOpaque(false);
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		lblBtnMinimizar.setIcon(new ImageIcon(_00_PaginaPrincipal2.class.getResource("/img/minimize.png")));
		lblBtnMinimizar.setBounds(928, 0, 40, 40);
		background.add(lblBtnMinimizar);

		btnMiCuenta = new JButton("MI CUENTA");
		btnMiCuenta.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        btnMiCuenta.setBackground(Color.yellow);
		        btnMiCuenta.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        btnMiCuenta.setBackground(null);
		        btnMiCuenta.setOpaque(false);
		    }
		});
		
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 4);
			}
		});

		btnMiCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		btnMiCuenta.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnMiCuenta.setBounds(10, 13, 262, 49);
		btnMiCuenta.setBorderPainted(false); 
        btnMiCuenta.setContentAreaFilled(false); 
		btnMiCuenta.setOpaque(false);
		btnMiCuenta.setFocusPainted(false);
		btnMiCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnMiCuenta);
		background.setComponentZOrder(btnMiCuenta, 0);
		
		btnVerLigas = new JButton("VER LIGAS");
		btnVerLigas.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnVerLigas.setBackground(Color.yellow);
		    	btnVerLigas.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnVerLigas.setBackground(null);
		    	btnVerLigas.setOpaque(false);
		    }
		});
		
		btnVerLigas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 0);
			}
		});
		
		btnVerLigas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerLigas.setOpaque(false);
		btnVerLigas.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnVerLigas.setFocusPainted(false);
		btnVerLigas.setContentAreaFilled(false);
		btnVerLigas.setBorderPainted(false);
		btnVerLigas.setBounds(10, 62, 262, 49);
		btnVerLigas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnVerLigas);
		background.setComponentZOrder(btnVerLigas, 0);
		
		btnCrearLiga = new JButton("CREAR LIGA");
		btnCrearLiga.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnCrearLiga.setBackground(Color.yellow);
		    	btnCrearLiga.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnCrearLiga.setBackground(null);
		    	btnCrearLiga.setOpaque(false);
		    }
		});
		
		btnCrearLiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 7);
			}
		});
		
		btnCrearLiga.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearLiga.setOpaque(false);
		btnCrearLiga.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnCrearLiga.setFocusPainted(false);
		btnCrearLiga.setContentAreaFilled(false);
		btnCrearLiga.setBorderPainted(false);
		btnCrearLiga.setBounds(10, 122, 260, 49);
		btnCrearLiga.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnCrearLiga);
		background.setComponentZOrder(btnCrearLiga, 0);
		
		btnUnirseALiga = new JButton("UNIRSE A LIGA");
		btnUnirseALiga.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnUnirseALiga.setBackground(Color.yellow);
		    	btnUnirseALiga.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnUnirseALiga.setBackground(null);
		    	btnUnirseALiga.setOpaque(false);
		    }
		});
		
		btnUnirseALiga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 5);
			}
		});
		
		btnUnirseALiga.setHorizontalAlignment(SwingConstants.LEFT);
		btnUnirseALiga.setOpaque(false);
		btnUnirseALiga.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnUnirseALiga.setFocusPainted(false);
		btnUnirseALiga.setContentAreaFilled(false);
		btnUnirseALiga.setBorderPainted(false);
		btnUnirseALiga.setBounds(10, 182, 260, 49);
		btnUnirseALiga.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnUnirseALiga);
		background.setComponentZOrder(btnUnirseALiga, 0);
		
		btnCrearEquipo = new JButton("CREAR EQUIPO");
		btnCrearEquipo.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnCrearEquipo.setBackground(Color.yellow);
		    	btnCrearEquipo.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnCrearEquipo.setBackground(null);
		    	btnCrearEquipo.setOpaque(false);
		    }
		});
		
		btnCrearEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 8);
			}
		});
		
		btnCrearEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCrearEquipo.setOpaque(false);
		btnCrearEquipo.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnCrearEquipo.setFocusPainted(false);
		btnCrearEquipo.setContentAreaFilled(false);
		btnCrearEquipo.setBorderPainted(false);
		btnCrearEquipo.setBounds(10, 242, 260, 49);
		btnCrearEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnCrearEquipo);
		background.setComponentZOrder(btnCrearEquipo, 0);
		
		btnUnirseAEquipo = new JButton("UNIRSE A EQUIPO");
		btnUnirseAEquipo.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnUnirseAEquipo.setBackground(Color.yellow);
		    	btnUnirseAEquipo.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnUnirseAEquipo.setBackground(null);
		    	btnUnirseAEquipo.setOpaque(false);
		    }
		});
		
		btnUnirseAEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 6);
			}
		});
		
		btnUnirseAEquipo.setHorizontalAlignment(SwingConstants.LEFT);
		btnUnirseAEquipo.setOpaque(false);
		btnUnirseAEquipo.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnUnirseAEquipo.setFocusPainted(false);
		btnUnirseAEquipo.setContentAreaFilled(false);
		btnUnirseAEquipo.setBorderPainted(false);
		btnUnirseAEquipo.setBounds(10, 302, 262, 49);
		btnUnirseAEquipo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnUnirseAEquipo);
		background.setComponentZOrder(btnUnirseAEquipo, 0);
		
		btnMisApuestas = new JButton("  MIS APUESTAS");
		btnMisApuestas.setBounds(10, 362, 262, 49);
		btnMisApuestas.setHorizontalAlignment(SwingConstants.LEFT);
		btnMisApuestas.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnMisApuestas.setFocusPainted(false);
		btnMisApuestas.setContentAreaFilled(false);
		btnMisApuestas.setBorderPainted(false);
		btnMisApuestas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMisApuestas.setEnabled(false);
		btnMisApuestas.setBackground(new Color(220, 220, 220));
		btnMisApuestas.setForeground(new Color(128, 128, 128));
		btnMisApuestas.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 128)));
		background.add(btnMisApuestas);
		background.setComponentZOrder(btnMisApuestas, 0);
		
		btnApostar = new JButton("APOSTAR");
		btnApostar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnApostar.setBackground(Color.yellow);
		    	btnApostar.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnApostar.setBackground(null);
		    	btnApostar.setOpaque(false);
		    }
		});
		
		btnApostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 11);
			}
		});
		
		btnApostar.setHorizontalAlignment(SwingConstants.LEFT);
		btnApostar.setOpaque(false);
		btnApostar.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnApostar.setFocusPainted(false);
		btnApostar.setContentAreaFilled(false);
		btnApostar.setBorderPainted(false);
		btnApostar.setBounds(10, 422, 260, 49);
		btnApostar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnApostar);
		background.setComponentZOrder(btnApostar, 0);
		
		btnSignOut = new JButton("Sign Out");
		btnSignOut.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnSignOut.setBackground(Color.yellow);
		    	btnSignOut.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnSignOut.setBackground(null);
		    	btnSignOut.setOpaque(false);
		    }
		});
		
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarVentana(12, 1);
			}
		});
		
		btnSignOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnSignOut.setOpaque(false);
		btnSignOut.setFont(new Font("Britannic Bold", Font.BOLD, 15));
		btnSignOut.setFocusPainted(false);
		btnSignOut.setContentAreaFilled(false);
		btnSignOut.setBorderPainted(false);
		btnSignOut.setBounds(10, 470, 262, 49);
		btnSignOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		background.add(btnSignOut);
		background.setComponentZOrder(btnSignOut, 0);
		
		lblBarraMoverVentana = new JLabel("");
        lblBarraMoverVentana.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int xPantalla = e.getXOnScreen();
                int yPantalla = e.getYOnScreen();
                setLocation(xPantalla - xMouse, yPantalla - yMouse);
            }
        });

        lblBarraMoverVentana.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });
        lblBarraMoverVentana.setBounds(0, 0, 918, 23);
        background.add(lblBarraMoverVentana);
        
        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        tabbedPane.setBorder(null);
        tabbedPane.setBackground(new Color(0, 128, 200));
        tabbedPane.setBounds(329, 111, 620, 390);
        background.add(tabbedPane);
        
        panelCurso = new JPanel();
        panelCurso.setBorder(null);
        panelCurso.setBackground(new Color(0, 128, 200));
        tabbedPane.addTab("En curso", null, panelCurso, null);
        panelCurso.setLayout(null);
        
        scrollPaneCurso = new JScrollPane();
        scrollPaneCurso.setBounds(0, 0, 615, 362);
        scrollPaneCurso.getViewport().setBackground(new Color(0, 128, 192));
        panelCurso.add(scrollPaneCurso);
        
        tblCurso = new JTable();
        tblCurso.setBorder(null);
        tblCurso.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        tblCurso.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"Real Madrid - Barcelona", "Real Madrid", new Integer(120), "27/05"},
        		{"Almeria - Getafe", "Almeria", new Integer(50), "14/06"},
        	},
        	new String[] {
        		"Partido", "Apuesta", "Cantidad", "Fecha"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        tblCurso.getColumnModel().getColumn(0).setPreferredWidth(190);
        tblCurso.getColumnModel().getColumn(1).setPreferredWidth(190);
        tblCurso.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblCurso.getColumnModel().getColumn(3).setPreferredWidth(160);
        scrollPaneCurso.setViewportView(tblCurso);
        
        panelFinalizadas = new JPanel();
        panelFinalizadas.setBorder(null);
        tabbedPane.addTab("Finalizadas", null, panelFinalizadas, null);
        panelFinalizadas.setLayout(null);
        
        scrollPaneFinalizadas = new JScrollPane();
        scrollPaneFinalizadas.setBounds(0, 0, 615, 362);
        scrollPaneFinalizadas.getViewport().setBackground(new Color(0, 128, 192));
        panelFinalizadas.add(scrollPaneFinalizadas);
        
        tblFinalizadas = new JTable();
        tblFinalizadas.setBorder(null);
        tblFinalizadas.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"Real Madrid - Betis", "Real Madrid", 100, "10/03", "Acertada"},
        		{"Barcelona - Betis", "Betis", 30, "23/01", "Acertada"},
        		{"Real Sociedad - Sevilla", "Sevilla", 200, "19/04", "Fallida"},
        	},
        	new String[] {
        		"Partido", "Apuesta", "Cantidad", "Fecha", "Resultado"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false, false, false, false, false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        tblFinalizadas.getColumnModel().getColumn(0).setPreferredWidth(190);
        tblFinalizadas.getColumnModel().getColumn(1).setPreferredWidth(190);
        tblFinalizadas.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblFinalizadas.getColumnModel().getColumn(3).setPreferredWidth(160);
        tblFinalizadas.getColumnModel().getColumn(4).setPreferredWidth(160);
        tblFinalizadas.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        scrollPaneFinalizadas.setViewportView(tblFinalizadas);
        
        txtbuscar = new JTextField();
        txtbuscar.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        txtbuscar.setBounds(724, 80, 119, 20);
        background.add(txtbuscar);
        txtbuscar.setColumns(10);
        
        btnBuscar = new JButton("BUSCAR");
        btnBuscar.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
        btnBuscar.setBackground(new Color(255, 128, 0));
        btnBuscar.setBounds(853, 79, 101, 23);
        background.add(btnBuscar);
		

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
