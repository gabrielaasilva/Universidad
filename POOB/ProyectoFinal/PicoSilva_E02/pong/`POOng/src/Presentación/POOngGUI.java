package Presentación;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class POOngGUI extends JFrame {
	private final int ANCHO = 800, ALTO = 500;
	private JPanel panel;
	private Configuracion panel2;
	private JButton play;
	private JLabel titulo;

	public POOngGUI() {
		super("POOng");
		prepareElementos();
		prepareAcciones();
		this.getContentPane().revalidate();
	}

	private void prepareElementos() {

		preparePestaña();		
		prepareBotones();
	}

	private void preparePestaña() {

		setTitle("POOng");
		this.setSize(ANCHO, ALTO);
		this.setLocationRelativeTo(null);
		panel = new JPanel();		
		this.getContentPane().add(panel);
		panel.setBackground(Color.BLACK);
		preparePanelUno();
	}
	
	private void preparePanelUno() {		
		panel.setLayout(null);
		titulo = new JLabel("POOng");
		titulo.setFont(new Font("Ink Free",1,11));
		titulo.setForeground(Color.GREEN);
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 150));
		titulo.setBounds(150, 70, 700, 200);
		panel.add(titulo);
	}


	private void prepareAcciones() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(final WindowEvent ev) {
				int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar?");
				if (resp == 0) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);

				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		prepareAccionesBotones();
	}

	private void prepareBotones() {
		play = new JButton("PLAY");
		Font auxFont = play.getFont();
		play.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 50));
		play.setBounds(270, 300, 200, 75);
		play.setBackground(Color.BLACK);
		play.setForeground(Color.WHITE);
		panel.add(play);
	}

	private void prepareAccionesBotones() {
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Configuracion configuracion = new Configuracion();
				configuracion.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		POOngGUI pong = new POOngGUI();
		pong.setVisible(true);
	}

}
