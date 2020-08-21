package Presentación;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Configuracion extends JFrame {

	private final int ANCHO = 400, ALTO = 500;
	private JPanel panel;
	private JPanel panel2;
	private JLabel personaje;
	private JLabel modoDeJuego;
	private JLabel pelota;
	private JComboBox cPersonaje;
	private JComboBox cModoDeJuego;
	private JComboBox cPelota;
	private JButton boton;
	private String categoriaPersonaje;
	private String categoriaJuego;
	private String categoriaPelota;
	

	public Configuracion() {
		prepareElementos();
		prepareAcciones();
	}

	private void prepareElementos() {
		setTitle("POOng");
		this.setSize(ANCHO, ALTO);
		this.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		panel.setBackground(Color.BLACK);
		preparePanel();
		prepareBoton();
	}
	
	private void prepareAcciones() {
		prepareAccionesBotones();	
	}

	private void preparePanel() {
		JLabel titulo = new JLabel("SETTINGS");
		titulo.setFont(new Font("Century Gothic",1,11));
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 40));
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(100, 0, 700, 100);
		panel.add(titulo);
		prepareSegundoPanel();
	}

	private void prepareSegundoPanel() {
		panel2 = new JPanel(new BorderLayout(100, 100));
		panel.add(panel2);
		panel2.setBackground(Color.BLACK);
		panel2.setLayout(null);
		panel2.setBounds(37, 110, 310, 220);
		prepareEtiquetas();
		prepareComboBox();
	}

	private void prepareEtiquetas() {
		prepareEtiquetaPersonaje();
		prepareEtiquetaJuego();
		prepareEtiquetaPelota();
	}
	
	private void prepareComboBox() {
		preparePersonaje();
		prepareModoDeJuego();
		preparePelota();
	}
	
	private void prepareEtiquetaPersonaje() {
		personaje = new JLabel("Characters");
		personaje.setFont(new Font("Century Gothic",1,11));
		Font auxFont = personaje.getFont();
		personaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		personaje.setForeground(Color.WHITE);
		personaje.setBounds(10, 60, 700, 100);
		panel2.add(personaje);		
	}
	
	private void prepareEtiquetaJuego(){
		modoDeJuego = new JLabel("Game mode");
		modoDeJuego.setFont(new Font("Century Gothic",1,11));
		Font auxFont = modoDeJuego.getFont();
		modoDeJuego.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		modoDeJuego.setForeground(Color.WHITE);
		modoDeJuego.setBounds(10, 0, 700, 100);
		panel2.add(modoDeJuego);		
	}
	
	private void prepareEtiquetaPelota(){
		pelota = new JLabel("Ball");
		pelota.setFont(new Font("Century Gothic",1,11));
		Font auxFont = pelota.getFont();
		pelota.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		pelota.setForeground(Color.WHITE);
		pelota.setBounds(10, 120, 700, 100);
		panel2.add(pelota);
		
	}
	
	private void preparePersonaje() {
        cPersonaje = new JComboBox();
        panel2.add(cPersonaje);
        cPersonaje.setDefaultLocale(null);
        cPersonaje.addItem(null);
        cPersonaje.addItem("Terror");
        cPersonaje.addItem("Heroes");
        cPersonaje.addItem("Food");
        cPersonaje.setBounds(150, 100, 130, 20);
        
	}

	private void prepareModoDeJuego() {
        cModoDeJuego = new JComboBox();
        cModoDeJuego.addItem(null);
        cModoDeJuego.addItem("Player vs Player");
        cModoDeJuego.addItem("Player vs Machine");
        cModoDeJuego.addItem("Machine vs Machine");
        panel2.add(cModoDeJuego);
        cModoDeJuego.setBounds(150, 40,  130, 20);
        
	}
	
	private void preparePelota() {
        cPelota = new JComboBox();
        cPelota.addItem(null);
        cPelota.addItem("Slow");
        cPelota.addItem("Fast");
        cPelota.addItem("Increase");
        panel2.add(cPelota);
        cPelota.setBounds(150, 160,  130, 20);
        
	}
	
    private void prepareBoton() {
    	boton = new JButton("Start");
		Font auxFont = boton.getFont();
		boton.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		boton.setBounds(130, 350, 100, 50);
		panel.add(boton);
		
    }
    
    private void prepareAccionesBotones() {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				categoriaPersonaje = (String) cPersonaje.getSelectedItem();
				categoriaJuego = (String) cModoDeJuego.getSelectedItem();
				categoriaPelota = (String) cPelota.getSelectedItem();
				Game game = new Game(categoriaPersonaje, categoriaJuego,categoriaPelota);
				game.setVisible(true);
			}
		});
	}
	
}
