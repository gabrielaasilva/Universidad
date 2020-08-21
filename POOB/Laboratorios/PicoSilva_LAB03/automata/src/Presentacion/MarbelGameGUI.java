package src.Presentacion;

import Aplicacion.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.File;

public class MarbelGameGUI extends JFrame {
	private ArrayList<Integer> lados = new ArrayList<Integer>();
	private JMenuBar barra;
	private JPanel panel;
	private JMenu menu;
	private JMenuItem item0 = new JMenuItem("Nuevo");
	private JMenuItem item1 = new JMenuItem("Abrir");
	private JMenuItem item2 = new JMenuItem("Guardar");
	private JMenuItem item3 = new JMenuItem("Guardar Como");
	private JMenuItem item4 = new JMenuItem("Salir");
	private MarbelGame game = null; 
	private JLabel titulo;
	
	

	private MarbelGameGUI() {
		super("Marbel Game");
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
		this.getContentPane().revalidate();
	}

	public static void main(final String args[]) {
		final MarbelGameGUI gui = new MarbelGameGUI();
		gui.setVisible(true);
	}

	private void prepareAcciones() {
		prepareAccionesMenu();
		prepareBotones();
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
	}

	private void prepareElementos() {
		setTitle("Marble Game");
		getScreenSize();
		this.setSize(lados.get(1) / 2, lados.get(0) / 2);
		this.setLocationRelativeTo(null);
		panel = new JPanel();
		this.getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		prepareElementosTablero();
		

	}


	private void prepareElementosTablero() {		
		prepareTitulo();
	}
	
	private void prepareTitulo() {
		titulo = new JLabel("Marbel Game");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 100));
		titulo.setBounds(60, 50, 700,200);
		panel.add(titulo);

	}

	private void prepareBotones() {
		JButton jugar = new JButton("PLAY");
		panel.setLayout(null);
		jugar.setBounds(334, 250, 100, 40);
		panel.add(jugar);
		jugar.setBackground(Color.WHITE);
		jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ConfigurationGUI configuracion = new ConfigurationGUI();
				configuracion.setVisible(true);				
			}			
		});
		
	}

	private void refresh() {
		JPanel temp = (JPanel) this.getContentPane();
		SwingUtilities.updateComponentTreeUI(temp);
		temp.validate();
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
	}

	private void prepareAccionesMenu() {

		// Nuevo
		item0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fl = new JFileChooser();
				int seleccion = fl.showOpenDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					refresh();
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

	}
	
	public void elimiarComponente() {
		panel.remove(titulo);
	}

}

