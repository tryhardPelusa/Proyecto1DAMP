/*
 * @Author Javier Turienzo
 */
package pantallas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Color;

public class MisApuestas extends JFrame {

	// Atributos
	private JPanel contentPane;
	private JMenuBar menuNavegacion;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JButton btnMiCuenta;
	private JButton btnSignOut;
	private JLabel lblMisApuetas;
	private JScrollPane scrollPane_Left;
	private JScrollPane scrollPane_Right;
	private JPanel panel_Left;
	private JPanel panel_Right;
	private JLabel lbl_EnCurso;
	private JLabel lbl_Finalizadas;
	private JLabel lblPartido;
	private JLabel lbl_Apuesta;
	private JSeparator separator_Hor;
	private JLabel lbl_Fecha;
	private JLabel lbl_Partido_1;
	private JSeparator separator_Hor_1;
	private JLabel lbl_Apuesta_1;
	private JLabel lbl_Fecha_1;
	private JLabel lbl_Finalizadas_Partido;
	private JLabel lbl_Finalizadas_Apuesta;
	private JLabel lbl_Finalizadas_Fecha;
	private JSeparator separator_Hor_2;
	private JLabel lbl_Finalizadas_Fecha_2;
	private JLabel lbl_Finalizadas_Apuesta_2;
	private JLabel lbl_Finalizadas_Partido_2;
	private JSeparator separator_Hor_3;
	private JLabel lbl_Finalizadas_Partido_1;
	private JSeparator separator_Hor_4;
	private JLabel lbl_Finalizadas_Apuesta_1;
	private JLabel lbl_Finalizadas_Fecha_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	// Constructor
	public MisApuestas() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);

		menuNavegacion = new JMenuBar();
		setJMenuBar(menuNavegacion);

		mnNewMenu = new JMenu("Ligas");
		menuNavegacion.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Ver ligas");
		mnNewMenu.add(mntmNewMenuItem);

		mntmNewMenuItem_5 = new JMenuItem("Crear liga");
		mnNewMenu.add(mntmNewMenuItem_5);

		mntmNewMenuItem_6 = new JMenuItem("Unirse a liga");
		mnNewMenu.add(mntmNewMenuItem_6);

		mnNewMenu_1 = new JMenu("Apuestas");
		menuNavegacion.add(mnNewMenu_1);

		mntmNewMenuItem_1 = new JMenuItem("Mis apuestas");
		mnNewMenu_1.add(mntmNewMenuItem_1);

		mntmNewMenuItem_7 = new JMenuItem("Apostar");
		mnNewMenu_1.add(mntmNewMenuItem_7);

		mnNewMenu_2 = new JMenu("Equipos");
		menuNavegacion.add(mnNewMenu_2);

		mntmNewMenuItem_3 = new JMenuItem("Unirse a equipo");
		mnNewMenu_2.add(mntmNewMenuItem_3);

		mntmNewMenuItem_4 = new JMenuItem("Crear equipo");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnMiCuenta = new JButton("Mi cuenta");
		btnMiCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMiCuenta.setBounds(873, 19, 109, 23);
		contentPane.add(btnMiCuenta);

		btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignOut.setBounds(873, 53, 109, 23);
		contentPane.add(btnSignOut);

		lblMisApuetas = new JLabel("Mis Apuestas");
		lblMisApuetas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMisApuetas.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMisApuetas.setBounds(372, 19, 264, 62);
		contentPane.add(lblMisApuetas);

		scrollPane_Left = new JScrollPane();
		scrollPane_Left.setBounds(23, 98, 473, 349);
		contentPane.add(scrollPane_Left);

		panel_Left = new JPanel();
		scrollPane_Left.setViewportView(panel_Left);
		panel_Left.setLayout(null);

		lblPartido = new JLabel("Real Madrid - Barcelona");
		lblPartido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPartido.setBounds(25, 11, 167, 27);
		panel_Left.add(lblPartido);

		lbl_Apuesta = new JLabel("(Real Madrid) 120 tokens");
		lbl_Apuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Apuesta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Apuesta.setBounds(202, 11, 162, 27);
		panel_Left.add(lbl_Apuesta);

		separator_Hor = new JSeparator();
		separator_Hor.setBounds(55, 49, 364, 7);
		panel_Left.add(separator_Hor);

		lbl_Fecha = new JLabel("27/05");
		lbl_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Fecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Fecha.setBounds(376, 11, 85, 27);
		panel_Left.add(lbl_Fecha);

		lbl_Partido_1 = new JLabel("Almeria - Getafe");
		lbl_Partido_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Partido_1.setBounds(25, 72, 167, 27);
		panel_Left.add(lbl_Partido_1);

		separator_Hor_1 = new JSeparator();
		separator_Hor_1.setBounds(55, 110, 364, 7);
		panel_Left.add(separator_Hor_1);

		lbl_Apuesta_1 = new JLabel("(Almeria) 50 tokens");
		lbl_Apuesta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Apuesta_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Apuesta_1.setBounds(202, 72, 162, 27);
		panel_Left.add(lbl_Apuesta_1);

		lbl_Fecha_1 = new JLabel("14/06");
		lbl_Fecha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Fecha_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Fecha_1.setBounds(376, 72, 85, 27);
		panel_Left.add(lbl_Fecha_1);

		scrollPane_Right = new JScrollPane();
		scrollPane_Right.setBounds(522, 98, 460, 349);
		contentPane.add(scrollPane_Right);

		panel_Right = new JPanel();
		scrollPane_Right.setViewportView(panel_Right);
		panel_Right.setLayout(null);

		lbl_Finalizadas_Partido = new JLabel("Real Madrid - Betis\r\n");
		lbl_Finalizadas_Partido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Finalizadas_Partido.setBounds(12, 11, 167, 27);
		panel_Right.add(lbl_Finalizadas_Partido);

		lbl_Finalizadas_Apuesta = new JLabel("(Real Madrid) 100 tokens");
		lbl_Finalizadas_Apuesta.setBackground(new Color(128, 255, 0));
		lbl_Finalizadas_Apuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Finalizadas_Apuesta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Finalizadas_Apuesta.setBounds(189, 11, 162, 27);
		panel_Right.add(lbl_Finalizadas_Apuesta);

		lbl_Finalizadas_Fecha = new JLabel("10/03");
		lbl_Finalizadas_Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Finalizadas_Fecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Finalizadas_Fecha.setBounds(363, 11, 43, 27);
		panel_Right.add(lbl_Finalizadas_Fecha);

		separator_Hor_2 = new JSeparator();
		separator_Hor_2.setBounds(42, 49, 364, 7);
		panel_Right.add(separator_Hor_2);

		lbl_Finalizadas_Fecha_2 = new JLabel("23/01");
		lbl_Finalizadas_Fecha_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Finalizadas_Fecha_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Finalizadas_Fecha_2.setBounds(363, 72, 43, 27);
		panel_Right.add(lbl_Finalizadas_Fecha_2);

		lbl_Finalizadas_Apuesta_2 = new JLabel("(Betis) 30 tokens");
		lbl_Finalizadas_Apuesta_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Finalizadas_Apuesta_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Finalizadas_Apuesta_2.setBounds(189, 72, 162, 27);
		panel_Right.add(lbl_Finalizadas_Apuesta_2);

		lbl_Finalizadas_Partido_2 = new JLabel("Barcelona - Betis");
		lbl_Finalizadas_Partido_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Finalizadas_Partido_2.setBounds(12, 72, 167, 27);
		panel_Right.add(lbl_Finalizadas_Partido_2);

		separator_Hor_3 = new JSeparator();
		separator_Hor_3.setBounds(42, 110, 364, 7);
		panel_Right.add(separator_Hor_3);

		lbl_Finalizadas_Partido_1 = new JLabel("Real Sociedad - Sevilla");
		lbl_Finalizadas_Partido_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Finalizadas_Partido_1.setBounds(12, 136, 203, 27);
		panel_Right.add(lbl_Finalizadas_Partido_1);

		separator_Hor_4 = new JSeparator();
		separator_Hor_4.setBounds(42, 174, 364, 7);
		panel_Right.add(separator_Hor_4);

		lbl_Finalizadas_Apuesta_1 = new JLabel("(Sevilla) 200 tokens");
		lbl_Finalizadas_Apuesta_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Finalizadas_Apuesta_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Finalizadas_Apuesta_1.setBounds(189, 136, 162, 27);
		panel_Right.add(lbl_Finalizadas_Apuesta_1);

		lbl_Finalizadas_Fecha_1 = new JLabel("19/04");
		lbl_Finalizadas_Fecha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Finalizadas_Fecha_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_Finalizadas_Fecha_1.setBounds(363, 136, 43, 27);
		panel_Right.add(lbl_Finalizadas_Fecha_1);

		lblNewLabel = new JLabel("Gana");
		lblNewLabel.setForeground(new Color(0, 230, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(416, 15, 42, 20);
		panel_Right.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Gana");
		lblNewLabel_1.setForeground(new Color(0, 230, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(416, 76, 42, 20);
		panel_Right.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Pierde");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(416, 140, 42, 20);
		panel_Right.add(lblNewLabel_2);

		lbl_EnCurso = new JLabel("En Curso");
		lbl_EnCurso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_EnCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_EnCurso.setBounds(203, 64, 83, 23);
		contentPane.add(lbl_EnCurso);

		lbl_Finalizadas = new JLabel("Finalizadas");
		lbl_Finalizadas.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Finalizadas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Finalizadas.setBounds(707, 64, 83, 23);
		contentPane.add(lbl_Finalizadas);

	}
}
