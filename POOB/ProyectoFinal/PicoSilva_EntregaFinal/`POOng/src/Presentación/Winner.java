package Presentación;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Ventana que indica el ganador del juego.
 */

public class Winner extends JFrame{
	private JPanel panel;
	private final int ANCHO = 400, ALTO = 250;
	/**
	 * Constructor
	 * @param ganador
	 */
	public Winner(boolean ganador) {
		prepareElementos(ganador);
	}
	/**
	 * Prepara elementos de la ventana propuesta
	 * @param ganador
	 */
	private void prepareElementos(boolean ganador) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		getContentPane().add(panel);
		if(ganador) {
			setTitle("Winner Player 1");
			JLabel label = new JLabel("WINNER PLAYER");
			panel.setLayout(null);
			label.setFont(new Font("Ink Free", 1, 11));
			label.setForeground(Color.GREEN);
			Font auxFont = label.getFont();
			label.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 45));
			label.setBounds(10, 0, 700, 200);
			JLabel label2 = new JLabel("1"); 	
			panel.setLayout(null);
			label2.setFont(new Font("Ink Free", 1, 11));
			label2.setForeground(Color.GREEN);
			label2.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
			label2.setBounds(180, 50, 700, 200);
			panel.add(label);
			panel.add(label2);
		}else {
			setTitle("Winner Player 2");
			JLabel label = new JLabel("WINNER PLAYER");
			panel.setLayout(null);
			label.setFont(new Font("Ink Free", 1, 11));
			label.setForeground(Color.GREEN);
			Font auxFont = label.getFont();
			label.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 45));
			label.setBounds(10, 0, 700, 200);
			JLabel label2 = new JLabel("2"); 	
			panel.setLayout(null);
			label2.setFont(new Font("Ink Free", 1, 11));
			label2.setForeground(Color.GREEN);
			label2.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
			label2.setBounds(180, 50, 700, 200);
			panel.add(label);
			panel.add(label2);
		}
		this.setSize(ANCHO, ALTO);
		this.setLocationRelativeTo(null);
	}
}
