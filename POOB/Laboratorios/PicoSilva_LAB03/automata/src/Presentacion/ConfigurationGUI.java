package src.Presentacion;

import Aplicacion.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import java.util.*;
import java.io.File;

public class ConfigurationGUI extends JFrame {
	private ArrayList<Integer> lados = new ArrayList<Integer>();
	private JPanel panel;
	private JPanel panel2;	
	private JTextField cajaDeTextoC;
	private JTextField cajaDeTextoB;
	private JTextField cajaDeTextoT;
	public ConfigurationGUI() {
		prepareElementos();	
		prepareAcciones();
	}
	
	private void prepareAcciones() {
		prepareBoton();
		
	}
	
	private void prepareElementos() {
		setTitle("Marble Game");
		panel = new JPanel();
		this.getContentPane().add(panel);
		panel.setLayout(null);
		screen();
		confiPaneles();
		prepareTitulo();	
		prepareAjustes();
		
	}
	
	private void screen() {
		getScreenSize();
		this.setSize(lados.get(1)/4,lados.get(0)/2);
		this.setLocationRelativeTo(null);		
	}
	
	private void confiPaneles() {
		panel2 = new JPanel(new BorderLayout(100,100));
		panel.add(panel2);
		panel2.setLayout(null);
		panel2.setBounds(10,100 , 350, 200);		
		TitledBorder border = new TitledBorder(new EtchedBorder(EtchedBorder.RAISED),"Ajustes",TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION); 
		panel2.setBorder(border);		
	}
	private void prepareTitulo() {
		JLabel titulo = new JLabel("configuración");
		Font auxFont = titulo.getFont();
		titulo.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 40));
		titulo.setBounds(50, 10, 300, 100);
		panel.add(titulo);
	}
	private void prepareAjustes() {
		tamaño();
		canicas();
		barreras();	
	}
	
	private void prepareBoton() {
		JButton ready = new JButton("Ready");
		ready.setBounds(150, 320, 70, 40);
		panel.add(ready);
		
		ready.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				GameGUI game = new GameGUI(cajaDeTextoT.getText(),cajaDeTextoC.getText(),cajaDeTextoB.getText());
				game.setVisible(true);
			}
		});
		
	}
	
	private void tamaño() {
		JLabel tamaño = new JLabel("Tamaño nxn");
		Font auxFont = tamaño.getFont();
		tamaño.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 10));
		tamaño.setBounds(10, 20, 100, 10);
		panel2.add(tamaño);		
		cajaDeTextoT = new JTextField("",15);
		cajaDeTextoT.setBounds(120, 20,210, 20);
		panel2.add(cajaDeTextoT);		
	}
	
	private void canicas() {
		JLabel canicas = new JLabel ("Número cánicas");
		Font auxFont1 = canicas.getFont();
		canicas.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 10));
		canicas.setBounds(10, 50, 100, 10);
		panel2.add(canicas);
		cajaDeTextoC = new JTextField("",15);
		cajaDeTextoC.setBounds(120, 50,210, 20);
		panel2.add(cajaDeTextoC);
		
	}
	
	private void barreras() {
		JLabel barreras = new JLabel("Número barreras");
		Font auxFont2 = barreras.getFont();
		barreras.setFont(new Font(auxFont2.getFontName(), auxFont2.getStyle(), 10));
		barreras.setBounds(10, 80, 100, 10);
		panel2.add(barreras);
		cajaDeTextoB = new JTextField("",15);
		cajaDeTextoB.setBounds(120, 80,210, 20);
		panel2.add(cajaDeTextoB);
		
		
		
	}
	
	private ArrayList<Integer> getScreenSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		lados.add(height);
		int width = (int) screenSize.getWidth();
		lados.add(width);		
		return lados;
	}
	
	
	
	
	
}
