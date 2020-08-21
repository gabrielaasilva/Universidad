package Presentación;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game extends JFrame {
	private final int ANCHO = 800, ALTO = 500;
	private Base base;
	private Movement movement;
	private Imagen imagen;
	private String categoriaPersonaje;
	private String categoriaJuego;
	private String categoriaPelota;


	public Game(String categoriaPersonaje, String categoriaJuego, String categoriaPelota) {
		this.categoriaPersonaje = categoriaPersonaje;
		this.categoriaJuego = categoriaJuego;
		this.categoriaPelota = categoriaPelota;
		prepareElementos();
		prepareAcciones();
		
		
	}
	private void prepareElementos() {
		setTitle("POOng");
		this.setSize(ANCHO, ALTO);
		this.setLocationRelativeTo(null);
		base = new Base(categoriaPersonaje,categoriaJuego,categoriaPelota);
		base.setLayout(null);
		//base.setBackground(Color.WHITE);		
		this.add(base);
		imagen = new Imagen(categoriaPersonaje,categoriaJuego,categoriaPelota);
		base.add(imagen);
	}
	
	private void prepareAcciones() {
		movement = new Movement(imagen);
		movement.start();
		
	}
	
	

	

	
	

	
}
