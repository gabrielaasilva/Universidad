package Presentación;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Presentación panel base
 */
public class Base extends JPanel {
	private File file;
	private Image image;
	private String categoriaPersonaje;
	private String categoriaJuego;
	private String categoriaPelota;

	/**
	 * Constructor panel vabse
	 * @param categoriaPersonaje
	 * @param categoriaJuego
	 * @param categoriaPelota
	 */
	public Base(String categoriaPersonaje, String categoriaJuego, String categoriaPelota) {
		this.categoriaPersonaje = categoriaPersonaje;
		this.categoriaJuego = categoriaJuego;
		this.categoriaPelota = categoriaPelota;
		file = new File("");
		setLayout(null);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		fondo(g);

	}
	
	public void crearPuntaje(int p1) {
		JLabel puntaje1 = new JLabel(Integer.toString(p1));
		add(puntaje1);
		puntaje1.setBounds(0, 0, 50, 50);
		puntaje1.setBackground(Color.WHITE);
		
	}

	/**
	 * Diseño fondo panel base
	 * @param g
	 */
	private void fondo(Graphics g) {
		String path;
		if (categoriaPersonaje == "Terror") {		
			path = file.getAbsolutePath() + "\\Presentación\\Images\\bosque.jpeg";
			ImageIcon icon = new ImageIcon(path);
			image = icon.getImage();
			g.drawImage(image,0,0,800,500,this);
		} else if(categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\Presentación\\Images\\hero.jpeg";
			ImageIcon icon = new ImageIcon(path);
			image = icon.getImage();
			g.drawImage(image,0,0,800,500,this);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\Presentación\\Images\\papas.png";
			ImageIcon icon = new ImageIcon(path);
			image = icon.getImage();
			g.drawImage(image,0,0,800,500,this);			
		}
		//g.drawString("Puntaje "+Imagen.puntaje1, 20, 20);
	}
	
}
