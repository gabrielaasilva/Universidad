package Presentacion;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Aplicacion.*;

import java.util.Random;

public class GamePanel extends JPanel {
	private int n = 40;
	private int size;
	private MarbelGame mb;

	public GamePanel(int t, int c, int b, MarbelGame mb) {
		size = t;
		setBackground(Color.WHITE);
		this.mb = mb;

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i <= size; i++) {
			g.setColor(Color.CYAN);
			g.drawLine(80 + i * n, 25, 80 + i * n, 25 + size * n);
		}
		for (int i = 0; i <= size; i++) {
			g.setColor(Color.CYAN);
			g.drawLine(80, 25 + i * n, 80 + size * n, 25 + i * n);
		}
		for (int f = 0; f < size; f++) {
			for (int c = 0; c < size; c++) {
				if (mb.getPieces(f, c) != null) {
					g.setColor(mb.getPieces(f, c).getColor());
					if (mb.getPieces(f, c).getForma() == Pieces.BARRERA) {
						if (mb.getPieces(f, c).isFilled()) {
							g.fillRoundRect(n * c + 83, n * f + 28, 35, 35, 5, 5);
						}

					} else {
						if (mb.getPieces(f, c).isFilled()) {
							g.fillOval(n * c + 90, n * f + 34, 22, 22);
						}
					}
				}
				if (mb.getEmptyPieces(f, c) != null) {
					g.setColor(mb.getEmptyPieces(f,c).getColor());
					g.drawOval(n * c + 86, n * f + 31, 30, 30);
				}
			}
		}

	}

}
