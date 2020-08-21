package Presentación;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Aplicación.Ball;
import Aplicación.Personaje;

public class Imagen extends JPanel {
	private Ball ball = new Ball(235, 20);
	private String categoriaPersonaje;
	private String categoriaJuego;
	private String categoriaPelota;
	private File file;
	private JLabel hero1, hero2, terror1, terror2, food1, food2;
	private Personaje peronajeHeroe1, peronajeTerror1, peronajeFood1, peronajeHeroe2, peronajeTerror2, peronajeFood2;
	private Personaje personaje;
	private int width;
	public static int puntaje1 = 0, puntaje2 = 0;
	private int anchoL = 60, largoL = 55;

	public Imagen(String categoriaPersonaje, String categoriaJuego, String categoriaPelota) {
		this.categoriaPersonaje = categoriaPersonaje;
		this.categoriaJuego = categoriaJuego;
		this.categoriaPelota = categoriaPelota;

		setBounds(235, 20, 300, 400);
		setLayout(null);
		file = new File("");
		width = this.getWidth();
		prepareElementos();
		createInputMap();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		cancha(g);
		malla(g);
		pelota(g);
		diseño(g);
		actualizar();
	}

	private void prepareElementos() {
		escogerPersonaje1();
		escogerPersonaje2();
	}

	private void malla(Graphics g) {
		String path;
		if (categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\malla3.png";
			ImageIcon icon = new ImageIcon(path);
			Image image = icon.getImage();
			g.drawImage(image, 0, 175, 300, 50, this);
		} else if (categoriaPersonaje == "Terror") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\mallaTerror.jpg";
			ImageIcon icon = new ImageIcon(path);
			Image image = icon.getImage();
			g.drawImage(image, 0, 175, 300, 50, this);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\mallaFood.png";
			ImageIcon icon = new ImageIcon(path);
			Image image = icon.getImage();
			g.drawImage(image, 0, 175, 300, 50, this);

		}

	}

	private void diseño(Graphics g) {
		if (categoriaPersonaje == "Heroes") {
			this.setBackground(Color.YELLOW);
			g.setColor(Color.RED);
			cancha(g);
		} else if (categoriaPersonaje == "Terror") {
			this.setBackground(Color.BLACK);
			g.setColor(Color.RED);
			cancha(g);
		} else if (categoriaPersonaje == "Food") {
			this.setBackground(Color.RED);
			g.setColor(Color.WHITE);
			cancha(g);
		}
	}

	private void cancha(Graphics g) {
		g.drawRect(0, 0, 299, 399);
		g.drawRect(30, 0, 239, 399);
		g.drawRect(30, 0, 239, 100);
		g.drawRect(30, 299, 239, 100);
		g.drawRect(30, 100, 120, 199);
	}

	private void pelota(Graphics g) {
		Graphics2D ball2 = (Graphics2D) g;
		ball2.setColor(Color.ORANGE);
		dibujar(ball2);
	}

	private void dibujar(Graphics2D g) {
		g.fill(ball.getBall());
	}

	private void actualizar() {
		ball.move(getBounds(), colisionDos(), colision(), puntajeUno(), puntajeDos());
		colision();
	}

	private void escogerPersonaje1() {
		String path;
		if (categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\spidi.png";
			ImageIcon icon1 = new ImageIcon(path);
			Image image1 = icon1.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
			icon1 = new ImageIcon(image1);
			hero1 = new JLabel (icon1);
			hero1.setBounds(0, 0, 60, 55);
			add(hero1);
			
		} else if (categoriaPersonaje == "Terror") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\chucky.png";
			ImageIcon icon2 = new ImageIcon(path);
			Image image2 = icon2.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
			icon2 = new ImageIcon(image2);
			terror1 = new JLabel(icon2);
			terror1.setBounds(0, 0, anchoL, largoL);
			add(terror1);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\burger.png";
			ImageIcon icon3 = new ImageIcon(path);
			Image image3 = icon3.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
			icon3 = new ImageIcon(image3);
			food1 = new JLabel(icon3);
			food1.setBounds(0, 0, 60, 55);
			add(food1);
		}
	}

	private void escogerPersonaje2() {
		String path;
		if (categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\bat.png";
			ImageIcon icon4 = new ImageIcon(path);
			Image image4 = icon4.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
			icon4 = new ImageIcon(image4);
			hero2 = new JLabel(icon4);
			hero2.setBounds(240, 349, 60, 55);
			add(hero2);
		} else if (categoriaPersonaje == "Terror") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\fredycute.png";
			ImageIcon icon5 = new ImageIcon(path);
			Image image5 = icon5.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
			icon5 = new ImageIcon(image5);
			terror2 = new JLabel(icon5);
			terror2.setBounds(240, 349, anchoL, largoL);
			add(terror2);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\src\\Presentación\\Images\\pizza.png";
			ImageIcon icon6 = new ImageIcon(path);
			Image image6 = icon6.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
			icon6 = new ImageIcon(image6);
			food2 = new JLabel(icon6);
			food2.setBounds(240, 349, 60, 55);
			add(food2);
		}
	}

	private void createInputMap() {
		InputMap input = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "izquierda1");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "derecha1");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "derecha2");
		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "izquierda2");

		ActionMap ap = this.getActionMap();

		ap.put("izquierda1", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (categoriaPersonaje == "Heroes") {
					int x1 = hero1.getX();
					if (x1 > 0) {
						x1 -= 20;
						hero1.setBounds(x1, hero1.getY(), 60, 55);
					}
				} else if (categoriaPersonaje == "Terror") {
					int x1 = terror1.getX();
					if (x1 > 0) {
						x1 -= 20;
						terror1.setBounds(x1, terror1.getY(), 60, 55);
					}
				} else if (categoriaPersonaje == "Food") {
					int x1 = food1.getX();
					if (x1 > 0) {
						x1 -= 20;
						food1.setBounds(x1, food1.getY(), 60, 55);
					}
				}

			}
		});

		ap.put("izquierda2", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                if (categoriaPersonaje == "Heroes") {
                    int x1 = hero2.getX();
                    if (x1 > 0) {
                        x1 -= 20;
                        hero2.setBounds(x1, hero2.getY(), 60, 55);
                    }
                } else if (categoriaPersonaje == "Terror") {
                    int x1 = terror2.getX();
                    if (x1 > 0) {
                        x1 -= 20;
                        terror2.setBounds(x1, terror2.getY(), 60, 55);
                    }
                } else if (categoriaPersonaje == "Food") {
                    int x1 = food2.getX();
                    if (x1 > 0) {
                        x1 -= 20;
                        food2.setBounds(x1, food2.getY(), 60, 55);
                    }

                }
            }
        });

		ap.put("derecha1", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {
				if (categoriaPersonaje == "Heroes") {
					int x1 = hero1.getX();
					if (x1 < 240) {
						x1 += 20;
						hero1.setBounds(x1, hero1.getY(), 60, 55);
					}
				} else if (categoriaPersonaje == "Terror") {
					int x1 = terror1.getX();
					if (x1 < 240) {
						x1 += 20;
						terror1.setBounds(x1, terror1.getY(), 60, 55);
					}
				} else if (categoriaPersonaje == "Food") {
					int x1 = food1.getX();
					if (x1 < 240) {
						x1 += 20;
						food1.setBounds(x1, food1.getY(), 60, 55);
					}
				}

			}
		});

		ap.put("derecha2", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (categoriaPersonaje == "Heroes") {
					int x1 = hero2.getX();
					if (x1 < 240) {
						x1 += 20;
						hero2.setBounds(x1, hero2.getY(), 60, 55);
					}
				} else if (categoriaPersonaje == "Terror") {
					int x1 = terror2.getX();
					if (x1 < 240) {
						x1 += 20;
						terror2.setBounds(x1, terror2.getY(), 60, 55);
					}
				} else if (categoriaPersonaje == "Food") {
					int x1 = food2.getX();
					if (x1 < 240) {
						x1 += 20;
						food2.setBounds(x1, food2.getY(), 60, 55);
					}
				}

			}

		});

	}

	private boolean colisionDos() {
		boolean val = false;
		while (true) {
			if (categoriaPersonaje == "Terror") {
				if ((ball.getBall().getX() < terror2.getX() + terror2.getWidth()
						&& ball.getBall().getX() + ball.getAncho() > terror2.getX())
						&& terror2.getY() == ball.getBall().getY() + ball.getAlto()) {

					val = true;
				} else {
					val = false;
				}
			} else if (categoriaPersonaje == "Heroes") {
				if ((ball.getBall().getX() < hero2.getX() + hero2.getWidth()
						&& ball.getBall().getX() + ball.getAncho() > hero2.getX())
						&& hero2.getY() == ball.getBall().getY() + ball.getAlto()) {
					val = true;
				} else {
					val = false;
				}
			} else if (categoriaPersonaje == "Food") {
				if ((ball.getBall().getX() < food2.getX() + food2.getWidth()
						&& ball.getBall().getX() + ball.getAncho() > food2.getX())
						&& food2.getY() == ball.getBall().getY() + ball.getAlto()) {
					val = true;
				} else {
					val = false;
				}
			}

			return val;
		}

	}

	private boolean colision() {
		boolean val = false;
		while (true) {
			if (categoriaPersonaje == "Terror") {
				if ((ball.getBall().getX() < terror1.getX() + terror1.getWidth()
						&& ball.getBall().getX() + ball.getAncho() > terror1.getX())
						&& terror1.getY() + terror1.getHeight() == ball.getBall().getY()) {

					val = true;
				} else {
					val = false;
				}
			} else if (categoriaPersonaje == "Heroes") {
				if ((ball.getBall().getX() < hero1.getX() + hero1.getWidth()
						&& ball.getBall().getX() + ball.getAncho() > hero1.getX())
						&& hero1.getY() + hero1.getHeight() == ball.getBall().getY()) {

					val = true;
				} else {
					val = false;
				}

			} else if (categoriaPersonaje == "Food") {
				if ((ball.getBall().getX() < food1.getX() + food1.getWidth()
						&& ball.getBall().getX() + ball.getAncho() > food1.getX())
						&& food1.getY() + food1.getHeight() == ball.getBall().getY()) {

					val = true;
				} else {
					val = false;
				}
			}
			return val;

		}
	}

	private boolean puntajeUno() {
		boolean val;
		if (ball.getBall().getY() + ball.getAlto() == 390) {
			puntaje1++;
			System.out.println("PUNTAJE JUGADOR UNO : " + puntaje1);
			val = true;
		} else {
			val = false;
		}

		return val;
	}

	private boolean puntajeDos() {
		boolean val;
		if (ball.getBall().getY() == 0) {
			puntaje2++;
			System.out.println("PUNTAJE JUGADOR DOS : " + puntaje2);
			val = true;
		} else {
			val = false;
		}
		return val;
	}
}
