package Presentación;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Base extends JPanel {
	private File file;
	private Image image;
	private String categoriaPersonaje;
	private String categoriaJuego;
	private String categoriaPelota;

	
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


	private void fondo(Graphics g) {
		String path;
		if (categoriaPersonaje == "Terror") {		
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\bosque.jpeg";
			ImageIcon icon = new ImageIcon(path);
			image = icon.getImage();
			g.drawImage(image,0,0,800,500,this);
		} else if(categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\hero.jpeg";
			ImageIcon icon = new ImageIcon(path);
			image = icon.getImage();
			g.drawImage(image,0,0,800,500,this);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\papas.png";
			ImageIcon icon = new ImageIcon(path);
			image = icon.getImage();
			g.drawImage(image,0,0,800,500,this);			
		}
		//g.drawString("Puntaje "+Imagen.puntaje1, 20, 20);
	}
	
}
