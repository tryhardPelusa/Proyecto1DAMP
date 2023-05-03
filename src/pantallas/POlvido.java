package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class POlvido extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {

					POlvido frame = new POlvido();
					frame.setVisible(true);

	}

	public POlvido() {
		setTitle("Pagina Olvido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
