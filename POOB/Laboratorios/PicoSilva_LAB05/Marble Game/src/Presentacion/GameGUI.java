package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Aplicacion.MarbelGame;

public class GameGUI extends JFrame {
	private ArrayList<Integer> lados;
	private MarbelGame mb;
	private String canicas;
	private String barreras;
	private String tamaño;
	Color color;
	private int t, c, b;
	private GamePanel tablero;
	private JMenu menu;
	private JMenuBar barra;
	private JMenuItem item0 = new JMenuItem("Nuevo");
	private JMenuItem item1 = new JMenuItem("Abrir");
	private JMenuItem item2 = new JMenuItem("Guardar");
	private JMenuItem item3 = new JMenuItem("Guardar Como");
	private JMenuItem item4 = new JMenuItem("Salir");
	private JMenuItem item5 = new JMenuItem("DarkMode");
	private JMenuItem item6 = new JMenuItem("Reiniciar");
	private JButton norte;
	private JButton sur;
	private JButton este;
	private JButton oeste;

	public GameGUI(String tamaño, String canicas, String barreras) {
		lados = new ArrayList<Integer>();
		this.canicas = canicas;
		this.barreras = barreras;
		this.tamaño = tamaño;
		t = Integer.parseInt(tamaño);
		c = Integer.parseInt(canicas);
		b = Integer.parseInt(barreras);
		this.setBackground(Color.WHITE);
		prepareElementos();
		prepareAcciones();

	}

	private void prepareElementos() {
		setTitle("Marble Game");
		confiPanel();
		screen();
		movimientos();
		canicasBien();
		canicasMal();
		prepareElementosMenu();	
		prepareBotones();
	}

	private void prepareAcciones() {
		prepareAccionesMenu();
		prepareAccionesBotones();
	}

	private void prepareBotones() {
		sur = new JButton("S");
		este = new JButton("E");
		norte = new JButton("N");
		oeste = new JButton("O");
		tablero.add(norte);
		tablero.add(sur);
		tablero.add(este);
		tablero.add(oeste);
		sur.setBounds(500, 100, 50, 35);
		este.setBounds(550, 60, 50, 35);
		norte.setBounds(500, 20, 50, 35);
		oeste.setBounds(450, 60, 50, 35);
		
	}

	private void prepareAccionesBotones(){
		norte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mb.alNorte();
				refresque();
			}
		});
		
		sur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mb.alSur();
				refresque();
			}
		});
		
		oeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mb.alOeste();
				refresque();
			}
		});

		este.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mb.alEste();
				refresque();
			}
		});
	}
	private void refresque() {
		repaint();
	}

	private void confiPanel() {
		mb = new MarbelGame(t, c, b);
		tablero = new GamePanel(t, c, b, mb);

		tablero.setLayout(null);
		getContentPane().add(tablero);
	}

	private void movimientos() {
		JLabel movimientos = new JLabel("Número de movimientos");
		Font auxFont = movimientos.getFont();
		movimientos.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 10));
		movimientos.setBounds(500, 150, 300, 10);
		movimientos.setForeground(Color.MAGENTA);
		tablero.add(movimientos);
		JTextField cajaDeTexto = new JTextField("", 15);
		cajaDeTexto.setBounds(630, 145, 30, 20);
		tablero.add(cajaDeTexto);
	}

	private void canicasBien() {
		JLabel canicasBien = new JLabel("Cánicas bien ubicadas");
		Font auxFont1 = canicasBien.getFont();
		canicasBien.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 10));
		canicasBien.setBounds(500, 180, 300, 10);
		tablero.add(canicasBien);
		canicasBien.setForeground(Color.MAGENTA);
		JTextField cajaDeTexto = new JTextField("", 15);
		cajaDeTexto.setBounds(630, 175, 30, 20);
		tablero.add(cajaDeTexto);

	}

	private void canicasMal() {
		JLabel canicasMal = new JLabel("Cánicas mal ubicadas");
		Font auxFont2 = canicasMal.getFont();
		canicasMal.setFont(new Font(auxFont2.getFontName(), auxFont2.getStyle(), 10));
		canicasMal.setBounds(500, 210, 300, 10);
		canicasMal.setForeground(Color.MAGENTA);
		tablero.add(canicasMal, BorderLayout.EAST);
		JTextField cajaDeTexto = new JTextField("", 15);
		cajaDeTexto.setBounds(630, 205, 30, 20);
		tablero.add(cajaDeTexto, BorderLayout.EAST);

	}

	private void screen() {
		getScreenSize();
		this.setSize(lados.get(1) / 2, lados.get(0) / 2);
		this.setLocationRelativeTo(null);
	}

	private ArrayList<Integer> getScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		lados.add(height);
		int width = (int) screenSize.getWidth();
		lados.add(width);
		return lados;
	}

	private void prepareElementosMenu() {
		barra = new JMenuBar();
		menu = new JMenu("Menu");
		barra.add(menu);
		setJMenuBar(barra);
		menu.add(item0);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		menu.add(item5);
		menu.add(item6);
	}

	private void prepareAccionesMenu() {

		// Nuevo
		item0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fl = new JFileChooser();
				int seleccion = fl.showOpenDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					// refresh();
				}
			}
		});

		// Abrir
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int seleccion = fc.showOpenDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File fichero = fc.getSelectedFile();
					JOptionPane.showMessageDialog(fc,
							"La funcionalidad abrir está en construcción" + "   nombre de archivo" + fichero.getName());
				}

			}
		});

		// Guardar
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int seleccion = fc.showSaveDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File fichero = fc.getSelectedFile();
					JOptionPane.showMessageDialog(fc, "La funcionalidad guardar está en construcción"
							+ "  nombre de archivo" + fichero.getName());
				}

			}
		});

		// Guardar Como
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int seleccion = fc.showSaveDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File fichero = fc.getSelectedFile();
					JOptionPane.showMessageDialog(fc, "La funcionalidad guardar como está en construcción"
							+ "  nombre de archivo" + fichero.getName());
				}

			}
		});

		// Salir
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exit = JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar?", null,
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (exit == JOptionPane.YES_OPTION) {
					setVisible(false);
					System.exit(0);
				}
			}
		});

		// DarkMode
		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser Selectorcolor = new JColorChooser();
				color = Selectorcolor.showDialog(null, "Seleccione un color", Color.BLACK);
				tablero.setBackground(color);

			}
		});
		
		//Reiniciar
		
		item6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mb.recover();
				repaint();
			}
		});

	}

}
