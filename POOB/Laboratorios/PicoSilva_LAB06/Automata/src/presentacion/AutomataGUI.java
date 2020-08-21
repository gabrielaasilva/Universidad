package presentacion;

import aplicacion.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AutomataGUI extends JFrame {

	private JMenu menu;
	private JMenuBar barra;
	private JMenuItem item0 = new JMenuItem("Inicia");
	private JMenuItem item1 = new JMenuItem("Abrir");
	private JMenuItem item2 = new JMenuItem("Salvar");
	private JMenuItem item3 = new JMenuItem("Importar");
	private JMenuItem item4 = new JMenuItem("Exportar");
	private JMenuItem item5 = new JMenuItem("Salir");
	private JButton botonReloj;

	private JLabel lFila;
	private JLabel lColumna;
	private JTextField tFila;
	private JTextField tColumna;
	private JPanel panelControl;
	private JPanel panelNueva;
	private JPanel panelBNueva;
	private JButton botonViva;
	private JButton botonLatente;

	private FotoAutomata foto;
	private AutomataCelular automata = null;

	public AutomataGUI(AutomataCelular ac) {
		super("Automata celular");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		automata = ac;
		foto = new FotoAutomata(automata);
		setSize(new Dimension(802, 870));
		prepareElementos();
		prepareAcciones();
		foto.setVisible(false);
	}

	private void prepareElementos() {
		setResizable(false);

		botonReloj = new JButton("Tic-tac");

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(foto, BorderLayout.WEST);
		getContentPane().add(botonReloj, BorderLayout.EAST);
		prepareElementosMenu();
	}

	private void prepareAcciones() {
		try {
			prepareAccionesMenu();
		} catch (AutomataExcepcion e1) {
			e1.printStackTrace();
		}

		botonReloj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonRelojAccion();
			}
		});
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

	}

	private void prepareAccionesMenu() throws AutomataExcepcion {

		// Opcion Iniciar
		item0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcionIniciar();

			}
		});

		// Opcion Abrir
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					opcionAbrir();
				} catch (AutomataExcepcion e1) {
					e1.printStackTrace();
				}
			}
		});

		// Opcion Salvar
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					opcionSalvar();
				} catch (AutomataExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Opcion Importar
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					opcionImportar();
				} catch (AutomataExcepcion e1) {
					e1.printStackTrace();
				}
			}
		});

		// Opcion Exportar
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					opcionExportar();
				} catch (AutomataExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Opcion sALIR
		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					opcionSalir();
				} catch (AutomataExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void opcionIniciar() {
		foto.setVisible(true);
	}

	private void opcionAbrir() throws AutomataExcepcion {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("dat", "dat");
		fc.setFileFilter(filter);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = new File(fc.getSelectedFile() + "");
			automata.abrir(fichero);
		}
		foto.repaint();
	}

	private void opcionSalvar() throws AutomataExcepcion {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("dat", "dat");
		fc.setFileFilter(filter);
		int seleccion = fc.showSaveDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = new File(fc.getSelectedFile() + "");
			automata.salvar(fichero);
		}
	}

	private void opcionImportar() throws AutomataExcepcion {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
		fc.setFileFilter(filter);
		int seleccion = fc.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = new File(fc.getSelectedFile() + "");
			try {
				automata.importe03(fichero);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		foto.repaint();

	}

	private void opcionExportar() throws AutomataExcepcion {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","txt");
		fc.setFileFilter(filter);
		int seleccion = fc.showSaveDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = new File(fc.getSelectedFile() +"");
			
			automata.exporte(fichero);
		}
	}

	private void opcionSalir() throws AutomataExcepcion {
		this.setVisible(true);
		this.dispose();

	}

	private void botonRelojAccion() {
		automata.ticTac();
		foto.repaint();
	}

	public static void main(String[] args) {
		AutomataCelular ac = new AutomataCelular();
		AutomataGUI ca = new AutomataGUI(ac);
		ca.setVisible(true);
	}
}
