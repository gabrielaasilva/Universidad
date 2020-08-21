package Presentación;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Ventana de juego
 *
 */
public class Game extends JFrame {
	private final int ANCHO = 800, ALTO = 500;
	private Base base;
	private Imagen imagen;
	private String categoriaPersonaje;
	private String categoriaJuego;
	private String categoriaPelota, categoriaPuntaje;
	private JMenuItem item0 = new JMenuItem("Inicie");
	private JMenuItem item1 = new JMenuItem("Abrir");
	private JMenuItem item2 = new JMenuItem("Salvar");
	private JMenu menu;
	private JMenuBar barra;

	/*
	 * Constructor ventana de juego
	 */
	public Game(String categoriaPersonaje, String categoriaJuego, String categoriaPelota, String categoriaPuntaje) {
		this.categoriaPersonaje = categoriaPersonaje;
		this.categoriaJuego = categoriaJuego;
		this.categoriaPelota = categoriaPelota;
		this.categoriaPuntaje = categoriaPuntaje;
		prepareElementos();
		prepareAcciones();
	}
	
	private void prepareAcciones() {
		prepareAccionesMenu();
	}

	/*
	 * Elementos ventana de juego
	 */
	private void prepareElementos() {
		setTitle("POOng");
		this.setSize(ANCHO, ALTO);
		this.setLocationRelativeTo(null);
		base = new Base(categoriaPersonaje, categoriaJuego, categoriaPelota);
		base.setLayout(null);
		this.add(base);
		imagen = new Imagen(categoriaPersonaje, categoriaJuego, categoriaPelota, categoriaPuntaje);
		base.add(imagen);
		prepareElementosMenu();
	}
	/**
	 * Preparacion de elementos del menú
	 */

	private void prepareElementosMenu() {
		barra = new JMenuBar();
		menu = new JMenu("Menu");
		barra.add(menu);
		setJMenuBar(barra);
		menu.add(item1);
		menu.add(item2);
	}
	
	public Base getBase() {
		return base;
	}
	/**
	 * Preparación de las acciones del menú
	 */
	private void prepareAccionesMenu() {
		// Opcion abrir
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcionAbrir();

			}
		});

		// Opcion Salvar
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				opcionSalvar();
			}
		});

	}
	/**
	 * Abrir un juego nuevo 
	 */
	
	private void opcionAbrir(){
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
        fc.setFileFilter(filter);
        int seleccion = fc.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = new File(fc.getSelectedFile() + "");
            imagen.getPong().abrir(fichero);
        }
        imagen.refresque();
    }
	/**
	 * Salvar juego actual
	 */
    private void opcionSalvar(){
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
        fc.setFileFilter(filter);
        int seleccion = fc.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = new File(fc.getSelectedFile() +"");
            imagen.getPong().salvar(fichero);
            
        }
    }
}
