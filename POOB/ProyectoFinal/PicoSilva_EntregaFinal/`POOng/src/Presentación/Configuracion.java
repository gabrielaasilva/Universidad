package Presentación;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Diseño de ventana de configuración
 */
public class Configuracion extends JFrame {

	private final int ANCHO = 400, ALTO = 500;
	private JPanel panel;
	private JPanel panel2;
	private JLabel personaje;
	private JLabel modoDeJuego;
	private JLabel pelota;
	private JLabel puntajeAcordado;
	private JComboBox cPersonaje;
	private JComboBox cModoDeJuego;
	private JComboBox cPelota;
	private JComboBox cPuntajeAcordado;
	private JButton boton;
	private String categoriaPersonaje;
	private String categoriaJuego;
	private String categoriaPelota,categoriaPuntaje;

	public Configuracion() {
		prepareElementos();
		prepareAcciones();
	}

	/**
	 * Elementos de la ventana
	 */
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

	/**
	 * Acciones de la ventana
	 */
	private void prepareAcciones() {
		prepareAccionesBotones();
	}

	/**
	 * Diseño panel 1
	 */
	private void preparePanel() {
		JLabel titulo = new JLabel("SETTINGS");
		titulo.setFont(new Font("Century Gothic", 1, 11));
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 40));
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(100, 0, 700, 100);
		panel.add(titulo);
		prepareSegundoPanel();
	}

	/**
	 * Diseño panel 2
	 */
	private void prepareSegundoPanel() {
		panel2 = new JPanel(new BorderLayout(100, 100));
		panel.add(panel2);
		panel2.setBackground(Color.BLACK);
		panel2.setLayout(null);
		panel2.setBounds(37, 110, 310, 220);
		prepareEtiquetas();
		prepareComboBox();
	}

	/**
	 * Diseño de etiquetas
	 */
	private void prepareEtiquetas() {
		prepareEtiquetaPersonaje();
		prepareEtiquetaJuego();
		prepareEtiquetaPelota();
		prepareEtiquetaPuntajeAcordado();
	}

	/**
	 * Diseño de comboBox
	 */

	private void prepareComboBox() {
		preparePersonaje();
		prepareModoDeJuego();
		preparePelota();
		preparePuntaje();
	}

	/**
	 * Diseño etiqueta personaje
	 */
	private void prepareEtiquetaPersonaje() {
		personaje = new JLabel("Characters");
		personaje.setFont(new Font("Century Gothic", 1, 11));
		Font auxFont = personaje.getFont();
		personaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		personaje.setForeground(Color.WHITE);
		personaje.setBounds(10, 40, 700, 100);
		panel2.add(personaje);
	}

	/**
	 * Diseño etiqueta modo de juego
	 */
	private void prepareEtiquetaJuego() {
		modoDeJuego = new JLabel("Game mode");
		modoDeJuego.setFont(new Font("Century Gothic", 1, 11));
		Font auxFont = modoDeJuego.getFont();
		modoDeJuego.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		modoDeJuego.setForeground(Color.WHITE);
		modoDeJuego.setBounds(10, 0, 700, 100);
		panel2.add(modoDeJuego);
	}

	/**
	 * Diseño etiqueta tipo de pelota
	 */
	private void prepareEtiquetaPelota() {
		pelota = new JLabel("Ball");
		pelota.setFont(new Font("Century Gothic", 1, 11));
		Font auxFont = pelota.getFont();
		pelota.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		pelota.setForeground(Color.WHITE);
		pelota.setBounds(10, 80, 700, 100);
		panel2.add(pelota);

	}

	private void prepareEtiquetaPuntajeAcordado() {
		puntajeAcordado = new JLabel("Agreed score");
		puntajeAcordado.setFont(new Font("Century Gothic", 1, 11));
		Font auxFont = pelota.getFont();
		puntajeAcordado.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 20));
		puntajeAcordado.setForeground(Color.WHITE);
		puntajeAcordado.setBounds(10, 120, 700, 100);
		panel2.add(puntajeAcordado);

	}

	/**
	 * Items personaje
	 */
	private void preparePersonaje() {
		cPersonaje = new JComboBox();
		panel2.add(cPersonaje);
		cPersonaje.setDefaultLocale(null);
		cPersonaje.addItem(null);
		cPersonaje.addItem("Terror");
		cPersonaje.addItem("Heroes");
		cPersonaje.addItem("Food");
		cPersonaje.setBounds(160, 80, 130, 20);

	}

	/**
	 * Items modo de juego
	 */
	private void prepareModoDeJuego() {
		cModoDeJuego = new JComboBox();
		cModoDeJuego.addItem(null);
		cModoDeJuego.addItem("Player vs Player");
		cModoDeJuego.addItem("Player vs Machine");
		cModoDeJuego.addItem("Machine vs Machine");
		panel2.add(cModoDeJuego);
		cModoDeJuego.setBounds(160, 40, 130, 20);

	}

	/**
	 * Items pelota
	 */
	private void preparePelota() {
		cPelota = new JComboBox();
		cPelota.addItem(null);
		cPelota.addItem("Slow");
		cPelota.addItem("Fast");
		cPelota.addItem("Increase");
		panel2.add(cPelota);
		cPelota.setBounds(160, 120, 130, 20);

	}

	private void preparePuntaje() {
		cPuntajeAcordado = new JComboBox();
		cPuntajeAcordado.addItem(null);
		cPuntajeAcordado.addItem("40");
		cPuntajeAcordado.addItem("20");
		cPuntajeAcordado.addItem("10");
		panel2.add(cPuntajeAcordado);
		cPuntajeAcordado.setBounds(160, 160, 130, 20);

	}

	/**
	 * Diseño boton
	 */
	private void prepareBoton() {
		boton = new JButton("Start");
		Font auxFont = boton.getFont();
		boton.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		boton.setBounds(130, 350, 100, 50);
		panel.add(boton);

	}

	/**
	 * Acción de botón
	 */
	private void prepareAccionesBotones() {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				categoriaPersonaje = (String) cPersonaje.getSelectedItem();
				categoriaJuego = (String) cModoDeJuego.getSelectedItem();
				categoriaPelota = (String) cPelota.getSelectedItem();
				categoriaPuntaje = (String) cPuntajeAcordado.getSelectedItem();
				Game game = new Game(categoriaPersonaje, categoriaJuego, categoriaPelota,categoriaPuntaje);
				game.setVisible(true);
			}
		});
	}

}
