/*@autor: Raúl Fernández*/
package pantallas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class Pantalla_EquipoEspecifico extends JFrame {

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
    private JLabel lblIntegrantes;
    private JTextArea txtparticipantes;
    private JPanel panel;
    private JTextArea txtdeportes;
    private JLabel lblSede;
    private JLabel lblLigas;
    private JTextArea txtrligas;

    public static void main(String[] args) {

        Pantalla_EquipoEspecifico frame = new Pantalla_EquipoEspecifico();
        frame.setVisible(true);

    }
public Pantalla_EquipoEspecifico() {
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
        
        JLabel lbltitulo = new JLabel("Equipo Especifico");
        lbltitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lbltitulo.setBounds(303, 53, 445, 97);
        contentPane.add(lbltitulo);
        
        panel = new JPanel();
        panel.setBounds(40, 201, 277, 303);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblIntegrantes = new JLabel("Integrantes del Equipo");
        lblIntegrantes.setBounds(83, 11, 109, 14);
        panel.add(lblIntegrantes);
        
        txtparticipantes = new JTextArea();
        txtparticipantes.setEditable(false);
        txtparticipantes.setText("-Paco\r\n- Juan\r\n- Rodolfo\r\n- Guillermo\r\n- kike\r\n- Ra\u00FAl\r\n- Daniel\r\n- Alejandro\r\n- Sergio\r\n- Miguel");
        txtparticipantes.setBounds(36, 36, 210, 256);
        panel.add(txtparticipantes);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(355, 201, 284, 303);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        txtdeportes = new JTextArea();
        txtdeportes.setText("-Baloncesto\r\n-futbol\r\n-golf");
        txtdeportes.setEditable(false);
        txtdeportes.setBounds(40, 34, 210, 98);
        panel_1.add(txtdeportes);
        
        JLabel lbldeportes = new JLabel("Deportes Participados");
        lbldeportes.setBounds(94, 9, 105, 14);
        panel_1.add(lbldeportes);
        
        lblSede = new JLabel("Sede");
        lblSede.setBounds(133, 172, 39, 14);
        panel_1.add(lblSede);
        
        JTextArea txtrCavenidaDeMargarita = new JTextArea();
        txtrCavenidaDeMargarita.setText("C/avenida de margarita n\u00BA5");
        txtrCavenidaDeMargarita.setEditable(false);
        txtrCavenidaDeMargarita.setBounds(40, 197, 210, 44);
        panel_1.add(txtrCavenidaDeMargarita);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(688, 201, 277, 303);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        lblLigas = new JLabel("Ligas en las que Participan");
        lblLigas.setBounds(75, 5, 126, 14);
        panel_2.add(lblLigas);
        
        txtrligas = new JTextArea();
        txtrligas.setLineWrap(true);
        txtrligas.setEditable(false);
        txtrligas.setText("-liga A\r\n-Liga B\r\n-Liga C\r\n-Liga D");
        txtrligas.setBounds(36, 36, 210, 256);
        panel_2.add(txtrligas);
    }
}