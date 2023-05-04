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
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Pantalla_UnirseLiga extends JFrame {

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
    private JTextField textField;
    private JButton btnUnion;
    private JLabel lblunirse;
    private JLabel lblUnirse;

    public static void main(String[] args) {

        Pantalla_UnirseLiga frame = new Pantalla_UnirseLiga();
        frame.setVisible(true);

    }
public Pantalla_UnirseLiga() {
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
        
        lblUnirse = new JLabel("Unirse a una Liga");
        lblUnirse.setFont(new Font("Tahoma", Font.BOLD, 46));
        lblUnirse.setBounds(271, 29, 416, 86);
        contentPane.add(lblUnirse);
        
        lblunirse = new JLabel("Introduzca un codigo de union:");
        lblunirse.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblunirse.setBounds(117, 255, 316, 39);
        contentPane.add(lblunirse);
        
        textField = new JTextField();
        textField.setBounds(401, 269, 219, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        btnUnion = new JButton("Unirse");
        btnUnion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnUnion.setBounds(655, 268, 85, 21);
        contentPane.add(btnUnion);
        
        JLabel lblNewLabel = new JLabel("No tienes equipo?, crea o unete a uno :D ");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(481, 475, 266, 32);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Unirse equip");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(746, 483, 97, 21);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Crear Equip");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_1.setBounds(873, 483, 109, 21);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Pantalla_UnirseLiga.class.getResource("/img/el-equipo-de-f\u00FAtbol-del-deporte-con-el-entrenador-agrupe-la-foto-76609484.jpg")));
        lblNewLabel_1.setBounds(42, 298, 369, 223);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Pantalla_UnirseLiga.class.getResource("/img/publicidad2.png")));
        lblNewLabel_2.setBounds(764, 167, 154, 256);
        contentPane.add(lblNewLabel_2);
    }
}