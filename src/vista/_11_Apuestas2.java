/*
 * @Author Javier Turienzo
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

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
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;

public class _11_Apuestas2 extends JFrame implements Vista {

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
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblEquipo;
	private JLabel lblEquipo_1;
	private JCheckBox chckbxEquipo;
	private JCheckBox chckbxEquipo_1;
	private JSpinner spinner;
	private JSeparator separator_Hor;
	private JLabel lblEquipo_2;
	private JLabel lblEquipo_3;
	private JCheckBox chckbxEquipo_2;
	private JCheckBox chckbxEquipo_3;
	private JSpinner spinner_1;
	private JSeparator separator_Hor_1;
	private JLabel lblEquipo_4;
	private JLabel lblEquipo_5;
	private JCheckBox chckbxEquipo_4;
	private JCheckBox chckbxEquipo_5;
	private JSpinner spinner_2;
	private JSeparator separator_Hor_2;
	private JLabel lblEquipo_6;
	private JLabel lblEquipo_7;
	private JCheckBox chckbxEquipo_6;
	private JCheckBox chckbxEquipo_7;
	private JSpinner spinner_3;
	private JSeparator separator_Hor_3;
	private JScrollPane scrollPaneListado;
	private JPanel panelListado;
	private JLabel lblApuesta;
	private JLabel lblRealMadridtokens;
	private JSeparator separator_Hor_4;
	private JLabel lblAlmeriagetafe;
	private JLabel lblalmeriaTokens;
	private JSeparator separator_Hor_5;
	private JSeparator separator_Hor_6;
	private JLabel lblTotal;
	private JButton btnConfirmar;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JLabel lblJornada;

	// Constructor
	public _11_Apuestas2() {
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
		lblFondo.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/fondoLogin2  - copia.jpg")));
		lblFondo.setBounds(0, 0, 283, 539);
		background.add(lblFondo);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/logo.png")));
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
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	lblBtnCerrar.setBackground(null);
		    	lblBtnCerrar.setOpaque(false);
		    }
		});
		lblBtnCerrar.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/close.png")));
		lblBtnCerrar.setBounds(970, 0, 40, 40);
		background.add(lblBtnCerrar);

		JLabel lblBtnMinimizar = new JLabel("");
		lblBtnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblBtnMinimizar.setIcon(new ImageIcon(_11_Apuestas2.class.getResource("/img/minimize.png")));
		lblBtnMinimizar.setBounds(928, 0, 34, 40);
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
		
		btnMisApuestas = new JButton("MIS APUESTAS");
		btnMisApuestas.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnMisApuestas.setBackground(Color.yellow);
		    	btnMisApuestas.setOpaque(true);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnMisApuestas.setBackground(null);
		    	btnMisApuestas.setOpaque(false);
		    }
		});
		btnMisApuestas.setHorizontalAlignment(SwingConstants.LEFT);
		btnMisApuestas.setOpaque(false);
		btnMisApuestas.setFont(new Font("Britannic Bold", Font.BOLD, 25));
		btnMisApuestas.setFocusPainted(false);
		btnMisApuestas.setContentAreaFilled(false);
		btnMisApuestas.setBorderPainted(false);
		btnMisApuestas.setBounds(10, 362, 262, 49);
		btnMisApuestas.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(305, 109, 464, 410);
        background.add(scrollPane);
        
        panel = new JPanel();
        panel.setBackground(new Color(0, 128, 192));
        scrollPane.setViewportView(panel);
        panel.setLayout(null);
        
        lblEquipo = new JLabel("Real Madrid");
        lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo.setBounds(10, 36, 109, 23);
        panel.add(lblEquipo);
        
        lblEquipo_1 = new JLabel("Barcelona");
        lblEquipo_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo_1.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo_1.setBounds(361, 36, 91, 23);
        panel.add(lblEquipo_1);
        
        chckbxEquipo = new JCheckBox("");
        chckbxEquipo.setBackground(new Color(0, 128, 192));
        chckbxEquipo.setSelected(true);
        chckbxEquipo.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo.setBounds(132, 36, 28, 23);
        panel.add(chckbxEquipo);
        
        chckbxEquipo_1 = new JCheckBox("");
        chckbxEquipo_1.setBackground(new Color(0, 128, 192));
        chckbxEquipo_1.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo_1.setBounds(310, 36, 28, 23);
        panel.add(chckbxEquipo_1);
        
        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(Integer.valueOf(120), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinner.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        spinner.setBounds(201, 39, 65, 20);
        panel.add(spinner);
        
        separator_Hor = new JSeparator();
        separator_Hor.setBounds(81, 91, 288, 2);
        panel.add(separator_Hor);
        
        lblEquipo_2 = new JLabel("Almeria");
        lblEquipo_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo_2.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo_2.setBounds(10, 124, 109, 23);
        panel.add(lblEquipo_2);
        
        lblEquipo_3 = new JLabel("Getafe");
        lblEquipo_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo_3.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo_3.setBounds(361, 124, 91, 23);
        panel.add(lblEquipo_3);
        
        chckbxEquipo_2 = new JCheckBox("");
        chckbxEquipo_2.setBackground(new Color(0, 128, 192));
        chckbxEquipo_2.setSelected(true);
        chckbxEquipo_2.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo_2.setBounds(132, 124, 28, 23);
        panel.add(chckbxEquipo_2);
        
        chckbxEquipo_3 = new JCheckBox("");
        chckbxEquipo_3.setBackground(new Color(0, 128, 192));
        chckbxEquipo_3.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo_3.setBounds(310, 124, 28, 23);
        panel.add(chckbxEquipo_3);
        
        spinner_1 = new JSpinner();
        spinner_1.setModel(new SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinner_1.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        spinner_1.setBounds(201, 127, 65, 20);
        panel.add(spinner_1);
        
        separator_Hor_1 = new JSeparator();
        separator_Hor_1.setBounds(81, 179, 288, 2);
        panel.add(separator_Hor_1);
        
        lblEquipo_4 = new JLabel("Betis");
        lblEquipo_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo_4.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo_4.setBounds(10, 219, 109, 23);
        panel.add(lblEquipo_4);
        
        lblEquipo_5 = new JLabel("Valencia");
        lblEquipo_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo_5.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo_5.setBounds(361, 219, 91, 23);
        panel.add(lblEquipo_5);
        
        chckbxEquipo_4 = new JCheckBox("");
        chckbxEquipo_4.setBackground(new Color(0, 128, 192));
        chckbxEquipo_4.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo_4.setBounds(132, 219, 28, 23);
        panel.add(chckbxEquipo_4);
        
        chckbxEquipo_5 = new JCheckBox("");
        chckbxEquipo_5.setBackground(new Color(0, 128, 192));
        chckbxEquipo_5.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo_5.setBounds(310, 219, 28, 23);
        panel.add(chckbxEquipo_5);
        
        spinner_2 = new JSpinner();
        spinner_2.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinner_2.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        spinner_2.setBounds(201, 222, 65, 20);
        panel.add(spinner_2);
        
        separator_Hor_2 = new JSeparator();
        separator_Hor_2.setBounds(81, 274, 288, 2);
        panel.add(separator_Hor_2);
        
        lblEquipo_6 = new JLabel("Valladolid");
        lblEquipo_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo_6.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo_6.setBounds(10, 315, 109, 23);
        panel.add(lblEquipo_6);
        
        lblEquipo_7 = new JLabel("Mallorca");
        lblEquipo_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblEquipo_7.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblEquipo_7.setBounds(361, 315, 91, 23);
        panel.add(lblEquipo_7);
        
        chckbxEquipo_6 = new JCheckBox("");
        chckbxEquipo_6.setBackground(new Color(0, 128, 192));
        chckbxEquipo_6.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo_6.setBounds(132, 315, 28, 23);
        panel.add(chckbxEquipo_6);
        
        chckbxEquipo_7 = new JCheckBox("");
        chckbxEquipo_7.setBackground(new Color(0, 128, 192));
        chckbxEquipo_7.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxEquipo_7.setBounds(310, 315, 28, 23);
        panel.add(chckbxEquipo_7);
        
        spinner_3 = new JSpinner();
        spinner_3.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spinner_3.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        spinner_3.setBounds(201, 318, 65, 20);
        panel.add(spinner_3);
        
        separator_Hor_3 = new JSeparator();
        separator_Hor_3.setBounds(81, 370, 288, 2);
        panel.add(separator_Hor_3);
        
        scrollPaneListado = new JScrollPane();
        scrollPaneListado.setBounds(787, 109, 213, 410);
        background.add(scrollPaneListado);
        
        panelListado = new JPanel();
        panelListado.setBackground(new Color(0, 128, 192));
        scrollPaneListado.setViewportView(panelListado);
        panelListado.setLayout(null);
        
        lblApuesta = new JLabel("Real Madrid - Barcelona");
        lblApuesta.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
        lblApuesta.setBounds(10, 0, 191, 27);
        panelListado.add(lblApuesta);
        
        lblRealMadridtokens = new JLabel("(Real Madrid) 120 tokens");
        lblRealMadridtokens.setVerticalAlignment(SwingConstants.TOP);
        lblRealMadridtokens.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRealMadridtokens.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblRealMadridtokens.setBounds(10, 29, 191, 27);
        panelListado.add(lblRealMadridtokens);
        
        separator_Hor_4 = new JSeparator();
        separator_Hor_4.setBounds(20, 54, 183, 8);
        panelListado.add(separator_Hor_4);
        
        lblAlmeriagetafe = new JLabel("Almeria - Getafe");
        lblAlmeriagetafe.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
        lblAlmeriagetafe.setBounds(10, 67, 191, 27);
        panelListado.add(lblAlmeriagetafe);
        
        lblalmeriaTokens = new JLabel("(Almeria) 50 tokens");
        lblalmeriaTokens.setVerticalAlignment(SwingConstants.TOP);
        lblalmeriaTokens.setHorizontalAlignment(SwingConstants.RIGHT);
        lblalmeriaTokens.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        lblalmeriaTokens.setBounds(10, 96, 191, 27);
        panelListado.add(lblalmeriaTokens);
        
        separator_Hor_5 = new JSeparator();
        separator_Hor_5.setBounds(20, 121, 183, 8);
        panelListado.add(separator_Hor_5);
        
        separator_Hor_6 = new JSeparator();
        separator_Hor_6.setForeground(Color.BLACK);
        separator_Hor_6.setBounds(10, 304, 201, 8);
        panelListado.add(separator_Hor_6);
        
        lblTotal = new JLabel("TOTAL: 170 tokens");
        lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotal.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
        lblTotal.setBounds(10, 323, 193, 23);
        panelListado.add(lblTotal);
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Britannic Bold", Font.PLAIN, 15));
        btnConfirmar.setBounds(63, 357, 102, 37);
        panelListado.add(btnConfirmar);
        
        btnAnterior = new JButton("Anterior");
        btnAnterior.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        btnAnterior.setBounds(323, 84, 89, 23);
        background.add(btnAnterior);
        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Britannic Bold", Font.PLAIN, 13));
        btnSiguiente.setBounds(663, 84, 89, 23);
        background.add(btnSiguiente);
        
        lblJornada = new JLabel("Jornada 7");
        lblJornada.setHorizontalAlignment(SwingConstants.CENTER);
        lblJornada.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
        lblJornada.setBounds(469, 77, 126, 34);
        background.add(lblJornada);

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
