package Presentaci�n;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.Toolkit;

import Aplicaci�n.Ball;
import Aplicaci�n.Personaje;
import Aplicaci�n.Poderes;
import Aplicaci�n.Pong;

/**
 * Panel encargado del campo de juego
 * 
 * @author 57301
 *
 */
public class Imagen extends JPanel {
	private Pong pong;
	private String categoriaPersonaje, categoriaJuego, categoriaPelota, siEntra, categoriaPuntaje;
	private File file;
	private JLabel hero1, hero2, terror1, terror2, food1, food2;
	private Personaje personaje;
	private int anchoL = 60, largoL = 55, width;
	private Movement movement;
	private boolean ultimoEnGolpear, bandera, turtle, x = false, y = false;
	private JLabel score1, score2, fortaleza1, fortaleza2;

	/**
	 * Constructor
	 * 
	 * @param categoriaPersonaje
	 * @param categoriaJuego
	 * @param categoriaPelota
	 * @param categoriaPuntaje
	 */
	public Imagen(String categoriaPersonaje, String categoriaJuego, String categoriaPelota, String categoriaPuntaje) {
		this.categoriaPersonaje = categoriaPersonaje;
		this.categoriaJuego = categoriaJuego;
		this.categoriaPelota = categoriaPelota;
		this.categoriaPuntaje = categoriaPuntaje;
		pong = new Pong(categoriaPuntaje);

		setBounds(235, 20, 300, 400);
		setLayout(null);
		file = new File("");
		width = this.getWidth();
		inicializarPuntajes();
		inicializarFortaleza();
		prepareHilo();
		prepareElementos();
		createInputMap(siEntra);

		if (categoriaJuego == "Player vs Machine") {
			comVsPlayer();
		}else if(categoriaJuego == "Machine vs Machine") {
			comVsCom();
		}

	}

	/**
	 * M�todo encargado del dise�o de componentes dentro del panel
	 * 
	 * @param Graphics g
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		cancha(g);
		malla(g);
		pelota(g);
		dise�o(g);
		actualizar();
		poder(g);
		imagenPoder(g);
		objetivo(g);
		imagenObjetivo(g);
		bloque(g);
		// puntajeJugador1();
		// puntajeJugador2();
		// hiloPoderes();
	}

	/**
	 * Preparaci�n de elementos del panel
	 */
	private void prepareElementos() {
		escogerPersonaje1();
		escogerPersonaje2();
		comprobarTipoPelota();

	}

	/**
	 * m�todo encargado de lal inicializaci�n del puntaje de cada jugador
	 */
	public void inicializarPuntajes() {
		score1 = new JLabel(Integer.toString(pong.puntaje1()));
		score2 = new JLabel(Integer.toString(pong.puntaje2()));
		JLabel jugador1 = new JLabel("Jugador 1");
		JLabel jugador2 = new JLabel("Jugador 2");
		score1.setFont(new Font("Ink Free", 1, 11));
		score1.setForeground(Color.BLUE);
		Font auxFont = score1.getFont();
		score1.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		score2.setFont(new Font("Ink Free", 1, 11));
		score2.setForeground(Color.BLUE);
		score2.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		jugador1.setFont(new Font("Ink Free", 1, 11));
		jugador1.setForeground(Color.BLUE);
		jugador1.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		jugador2.setFont(new Font("Ink Free", 1, 11));
		jugador2.setForeground(Color.BLUE);
		jugador2.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		score1.setBounds(80, 140, 60, 30);
		jugador1.setBounds(60, 120, 80, 20);
		score2.setBounds(80, 260, 60, 30);
		jugador2.setBounds(60, 240, 80, 20);
		add(score1);
		add(score2);
		add(jugador1);
		add(jugador2);
	}

	/**
	 * M�todo encargado en inicializar la fortaleza de cada jugador
	 */
	public void inicializarFortaleza() {
		fortaleza1 = new JLabel(Integer.toString(pong.getPersonaje1().getFortaleza()));
		fortaleza2 = new JLabel(Integer.toString(pong.getPersonaje2().getFortaleza()));
		JLabel jugador1 = new JLabel("Jugador 1");
		JLabel jugador2 = new JLabel("Jugador 2");
		fortaleza1.setFont(new Font("Ink Free", 1, 11));
		fortaleza1.setForeground(Color.BLUE);
		Font auxFont = fortaleza1.getFont();
		fortaleza1.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		fortaleza2.setFont(new Font("Ink Free", 1, 11));
		fortaleza2.setForeground(Color.BLUE);
		fortaleza2.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 30));
		jugador1.setFont(new Font("Ink Free", 1, 11));
		jugador1.setForeground(Color.BLUE);
		jugador1.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		jugador2.setFont(new Font("Ink Free", 1, 11));
		jugador2.setForeground(Color.BLUE);
		jugador2.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
		fortaleza1.setBounds(180, 140, 80, 30);
		jugador1.setBounds(175, 120, 80, 20);
		fortaleza2.setBounds(180, 260, 80, 30);
		jugador2.setBounds(175, 240, 80, 20);
		add(fortaleza1);
		add(fortaleza2);
		add(jugador1);
		add(jugador2);
	}

	/**
	 * M�todo encargado en ir actualizando la fortaleza de cada jugador
	 */
	public void setFortaleza() {
		fortaleza1.setText(Integer.toString(pong.getPersonaje1().getFortaleza()));
		fortaleza2.setText(Integer.toString(pong.getPersonaje2().getFortaleza()));
	}

	/**
	 * M�todo encargado en ir actualizando el puntaje de cada jugador
	 */
	public void setPuntajes() {
		score1.setText(Integer.toString(pong.puntaje1()));
		score2.setText(Integer.toString(pong.puntaje2()));
	}

	/**
	 * M�todo encargado en seleccionar la iamgen de la malla segun el tema del
	 * juego.
	 * 
	 * @param g
	 */
	private void malla(Graphics g) {
		String path;
		if (categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\malla3.png";
			ImageIcon icon = new ImageIcon(path);
			Image image = icon.getImage();
			g.drawImage(image, 0, 175, 300, 50, this);
		} else if (categoriaPersonaje == "Terror") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\mallaTerror.jpg";
			ImageIcon icon = new ImageIcon(path);
			Image image = icon.getImage();
			g.drawImage(image, 0, 175, 300, 50, this);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\mallaFood.png";
			ImageIcon icon = new ImageIcon(path);
			Image image = icon.getImage();
			g.drawImage(image, 0, 175, 300, 50, this);
		}
	}

	/**
	 * Color del panel
	 * 
	 * @param g
	 */
	private void dise�o(Graphics g) {
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

	/**
	 * Dibujo de la cancha
	 * 
	 * @param g
	 */
	private void cancha(Graphics g) {
		g.drawRect(0, 0, 299, 399);
		g.drawRect(30, 0, 239, 399);
		g.drawRect(30, 0, 239, 100);
		g.drawRect(30, 299, 239, 100);
		g.drawRect(30, 100, 120, 199);
	}

	/**
	 * Dise�o de la pelota
	 * 
	 * @param g
	 */
	private void pelota(Graphics g) {

		Graphics2D ball2 = (Graphics2D) g;
		ball2.setColor(pong.getBall().getColor());
		dibujarPelota(ball2);
		if (pong.getBall2() != null) {
			Graphics2D ball3 = (Graphics2D) g;
			ball3.setColor(pong.getBall().getColor());
			dibujarPelota(ball3);
		}

	}

	/**
	 * Dibujar pelota
	 * 
	 * @param g
	 */
	private void dibujarPelota(Graphics2D g) {
		if (pong.getBall().isVisible()) {
			g.fill(pong.getBall().getRectangle());
		}
		if (pong.getBall2() != null) {
			g.fill(pong.getBall2().getRectangle());

		}
	}

	/**
	 * M�todo encargado de actualizar el tablero de juego
	 */
	private void actualizar() {
		pong.getBall().move(getBounds(), pong.getColision().colisionP2(), pong.getColision().colisionP1(),
				pong.getColision().puntajeUno(), pong.getColision().puntajeDos());
		if (pong.getBall2() != null) {
			pong.getBall2().move(getBounds(), pong.getColision().colisionP2(), pong.getColision().colisionP1(),
					pong.getColision().puntajeUno(), pong.getColision().puntajeDos());
		}

		if (pong.getBloque() != null) {
			pong.getBloque().move(getBounds(), pong.getBall().getResultado());
			pong.accionBloque();
		}
		comprobarPoderHilo();
		pong.colisionBola();
		pong.colisionObjetivo();

		gameOver();
	}

	/**
	 * Selecci�n de imagen del personaje n�mero uno seg�n el tema
	 */
	private void escogerPersonaje1() {
		String path;
		if (categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\spidi.png";
			ImageIcon icon1 = new ImageIcon(path);
			Image image1 = icon1.getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
			icon1 = new ImageIcon(image1);
			hero1 = new JLabel(icon1);
			hero1.setBounds(pong.getPersonaje1().getX(), pong.getPersonaje1().getY(), pong.getPersonaje1().getAlto(),
					pong.getPersonaje1().getAncho());
			add(hero1);
		} else if (categoriaPersonaje == "Terror") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\chucky.png";
			ImageIcon icon2 = new ImageIcon(path);
			Image image2 = icon2.getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
			icon2 = new ImageIcon(image2);
			terror1 = new JLabel(icon2);
			terror1.setBounds(pong.getPersonaje1().getX(), pong.getPersonaje1().getY(), pong.getPersonaje1().getAlto(),
					pong.getPersonaje1().getAncho());
			add(terror1);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\burger.png";
			ImageIcon icon3 = new ImageIcon(path);
			Image image3 = icon3.getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
			icon3 = new ImageIcon(image3);
			food1 = new JLabel(icon3);
			food1.setBounds(pong.getPersonaje1().getX(), pong.getPersonaje1().getY(), pong.getPersonaje1().getAlto(),
					pong.getPersonaje1().getAncho());
			add(food1);
		}
	}

	/***
	 * Selecci�n imagen poder
	 * 
	 * @param g
	 */
	private void imagenPoder(Graphics g) {
		if (pong.getPoder() != null) {
			if (pong.getPoder().getNamePoder() == "Fastball") {
				String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\fastball.png";
				java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
				Image image = t.getImage(path);
				g.drawImage(image, pong.getPoder().getX(), pong.getPoder().getY(), 35, 35, this);
			} else if (pong.getPoder().getNamePoder() == "Freezer") {
				String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\copo.png";
				java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
				Image image = t.getImage(path);
				g.drawImage(image, pong.getPoder().getX(), pong.getPoder().getY(), 35, 35, this);
			} else if (pong.getPoder().getNamePoder() == "Flash") {
				String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\Rayo.png";
				java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
				Image image = t.getImage(path);
				g.drawImage(image, pong.getPoder().getX(), pong.getPoder().getY(), 35, 35, this);
			} else if (pong.getPoder().getNamePoder() == "Turtle") {
				String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\Turtle.png";
				java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
				Image image = t.getImage(path);
				g.drawImage(image, pong.getPoder().getX(), pong.getPoder().getY(), 35, 35, this);
			} else if (pong.getPoder().getNamePoder() == "Cold") {
				String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\penguin.png";
				java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
				Image image = t.getImage(path);
				g.drawImage(image, pong.getPoder().getX(), pong.getPoder().getY(), 35, 35, this);
			} else if (pong.getPoder().getNamePoder() == "Phantom") {
				String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\fantasma.png";
				java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
				Image image = t.getImage(path);
				g.drawImage(image, pong.getPoder().getX(), pong.getPoder().getY(), 35, 35, this);
			} else if (pong.getPoder().getNamePoder() == "Energy") {
				String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\Energy.png";
				java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
				Image image = t.getImage(path);
				g.drawImage(image, pong.getPoder().getX(), pong.getPoder().getY(), 35, 35, this);
			}
		}
	};

	/**
	 * Seleccion imagen objetivo
	 * 
	 * @param g
	 */
	private void imagenObjetivo(Graphics g) {
		if (pong.getObjetivo() != null) {
			String path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\blanco.png";
			java.awt.Toolkit t = java.awt.Toolkit.getDefaultToolkit();
			Image image = t.getImage(path);
			g.drawImage(image, pong.getObjetivo().getX(), pong.getObjetivo().getY(), 35, 35, this);
		}
	}

	/**
	 * Selecci�n de imagen del personaje n�mero dos seg�n el tema
	 */
	private void escogerPersonaje2() {
		String path;
		if (categoriaPersonaje == "Heroes") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\bat.png";
			ImageIcon icon4 = new ImageIcon(path);
			Image image4 = icon4.getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
			icon4 = new ImageIcon(image4);
			hero2 = new JLabel(icon4);
			hero2.setBounds(pong.getPersonaje2().getX(), pong.getPersonaje2().getY(), pong.getPersonaje2().getAncho(),
					pong.getPersonaje2().getAlto());
			add(hero2);
		} else if (categoriaPersonaje == "Terror") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\fredycute.png";
			ImageIcon icon5 = new ImageIcon(path);
			Image image5 = icon5.getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
			icon5 = new ImageIcon(image5);
			terror2 = new JLabel(icon5);
			terror2.setBounds(pong.getPersonaje2().getX(), pong.getPersonaje2().getY(), pong.getPersonaje2().getAncho(),
					pong.getPersonaje2().getAlto());
			add(terror2);
		} else if (categoriaPersonaje == "Food") {
			path = file.getAbsolutePath() + "\\Presentaci�n\\Images\\pizza.png";
			ImageIcon icon6 = new ImageIcon(path);
			Image image6 = icon6.getImage().getScaledInstance(40, 35, Image.SCALE_SMOOTH);
			icon6 = new ImageIcon(image6);
			food2 = new JLabel(icon6);
			food2.setBounds(pong.getPersonaje2().getX(), pong.getPersonaje2().getY(), pong.getPersonaje2().getAncho(),
					pong.getPersonaje2().getAlto());
			add(food2);
		}
	}

	/**
	 * M�todo encargado del movimiento de la m�quina contra jugador
	 */
	private void comVsPlayer() {
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {

				// pong.getPersonaje1().getX()!= pong.getBall().getX()
				if(pong.getPersonaje1().getX() != pong.getBall().getX()) {
					pong.getPersonaje1().setX(pong.getBall().getX());
					if (categoriaPersonaje == "Heroes") {
						hero1.setBounds(pong.getBall().getX(),pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					} else if (categoriaPersonaje == "Terror") {
						terror1.setBounds(pong.getBall().getX(), pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					} else if (categoriaPersonaje == "Food") {
						food1.setBounds(pong.getBall().getX(), pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					}
				}
			}
		};
		timer.schedule(tarea, 0, 1000);
	}
	/**
	*M�todo encargado del movimiento de las m�quinas en el juego de m�quina vs m�quina
	*/
	public void comVsCom() {
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {

				// pong.getPersonaje1().getX()!= pong.getBall().getX()
				if(pong.getPersonaje1().getX() != pong.getBall().getX()) {
					pong.getPersonaje1().setX(pong.getBall().getX());
					if (categoriaPersonaje == "Heroes") {
						hero1.setBounds(pong.getBall().getX(),pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					} else if (categoriaPersonaje == "Terror") {
						terror1.setBounds(pong.getBall().getX(), pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					} else if (categoriaPersonaje == "Food") {
						food1.setBounds(pong.getBall().getX(), pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					}
				}
			}
		};
		TimerTask tarea2 = new TimerTask() {
			@Override
			public void run() {
				if(pong.getPersonaje2().getX() != pong.getBall().getX()) {
					pong.getPersonaje2().setX(pong.getBall().getX());
					if (categoriaPersonaje == "Heroes") {
						hero2.setBounds(pong.getBall().getX(),pong.getPersonaje2().getY(),
								pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
					} else if (categoriaPersonaje == "Terror") {
						terror2.setBounds(pong.getBall().getX(), pong.getPersonaje2().getY(),
								pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
					} else if (categoriaPersonaje == "Food") {
						food2.setBounds(pong.getBall().getX(), pong.getPersonaje2().getY(),
								pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
					}
				}
			}
		};
		timer.schedule(tarea, 0, 1000);
		timer.schedule(tarea2, 0, 1500);
	}
	/**
	 * M�todo encargado para mover los personajes con teclas
	 * 
	 * @param hola
	 */
	private void createInputMap(String hola) {
		InputMap input = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		if (categoriaJuego == "Player vs Player") {
			input.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "izquierda1");
			input.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "derecha1");
			input.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "derecha2");
			input.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "izquierda2");
		} else if (categoriaJuego == "Player vs Machine") {
			input.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "derecha2");
			input.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "izquierda2");
		}

		input.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "esc");

		ActionMap ap = this.getActionMap();

		ap.put("esc", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (bandera == false) {
					movement.suspend();
					bandera = true;
				} else {
					bandera = false;
					movement.resume();
				}

			}
		});

		ap.put("izquierda1", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (categoriaPersonaje == "Heroes") {
					hero1.setBounds(pong.getPersonaje1().moverIzquierda(), pong.getPersonaje1().getY(),
							pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
				} else if (categoriaPersonaje == "Terror") {
					terror1.setBounds(pong.getPersonaje1().moverIzquierda(), pong.getPersonaje1().getY(),
							pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
				} else if (categoriaPersonaje == "Food") {
					food1.setBounds(pong.getPersonaje1().moverIzquierda(), pong.getPersonaje1().getY(),
							pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
				}
			}
		});

		ap.put("izquierda2", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (categoriaPersonaje == "Heroes") {
					hero2.setBounds(pong.getPersonaje2().moverIzquierda(), pong.getPersonaje2().getY(),
							pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
				} else if (categoriaPersonaje == "Terror") {
					terror2.setBounds(pong.getPersonaje2().moverIzquierda(), pong.getPersonaje2().getY(),
							pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
				} else if (categoriaPersonaje == "Food") {
					food2.setBounds(pong.getPersonaje2().moverIzquierda(), pong.getPersonaje2().getY(),
							pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
				}
			}
		});

		ap.put("derecha1", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (ultimoEnGolpear == false && hola == "si entra") {
					Timer timer = new Timer();
					Repetidor repetidor = new Repetidor(timer);
					timer.scheduleAtFixedRate(repetidor, 0, 10000);
					siEntra = "perreo SUPER SALVAJE";
					createInputMap(siEntra);
				} else {
					if (categoriaPersonaje == "Heroes") {
						hero1.setBounds(pong.getPersonaje1().moverDerecha(), pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					} else if (categoriaPersonaje == "Terror") {
						terror1.setBounds(pong.getPersonaje1().moverDerecha(), pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					} else if (categoriaPersonaje == "Food") {
						food1.setBounds(pong.getPersonaje1().moverDerecha(), pong.getPersonaje1().getY(),
								pong.getPersonaje1().getAlto(), pong.getPersonaje1().getAncho());
					}

				}

			}
		});

		ap.put("derecha2", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if (categoriaPersonaje == "Heroes") {
					hero2.setBounds(pong.getPersonaje2().moverDerecha(), pong.getPersonaje2().getY(),
							pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
				} else if (categoriaPersonaje == "Terror") {
					terror2.setBounds(pong.getPersonaje2().moverDerecha(), pong.getPersonaje2().getY(),
							pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
				} else if (categoriaPersonaje == "Food") {
					food2.setBounds(pong.getPersonaje2().moverDerecha(), pong.getPersonaje2().getY(),
							pong.getPersonaje2().getAlto(), pong.getPersonaje2().getAncho());
				}

			}

		});
	}

	/**
	 * Dise�o poder
	 * 
	 * @param g
	 */
	private void poder(Graphics g) {
		Graphics2D poder = (Graphics2D) g;
		poder.setColor(Color.ORANGE);
		dibujarPoderes(poder);
	}

	/**
	 * Dise�o objetivo
	 * 
	 * @param g
	 */
	private void objetivo(Graphics g) {
		Graphics2D poder = (Graphics2D) g;
		poder.setColor(Color.ORANGE);
		dibujarObjetivo(poder);
	}

	/**
	 * Dise�o bloque
	 * 
	 * @param g
	 */
	private void bloque(Graphics g) {
		Graphics2D bloque = (Graphics2D) g;
		bloque.setColor(Color.MAGENTA);
		dibujarBloque(bloque);

	}

	/**
	 * Dibuja el bloque en pantalla
	 * 
	 * @param g
	 */
	private void dibujarBloque(Graphics2D g) {
		if (pong.getBloque() != null) {
			g.fill(pong.getBloque().getFiguraBloque());
		}
	}

	/**
	 * Dibujar objetivo
	 * 
	 * @param g
	 */
	private void dibujarObjetivo(Graphics2D g) {
		if (pong.getObjetivo() != null) {
			g.draw(pong.getObjetivo().getFiguraObjetivo());
		}
	}

	/**
	 * Dibujar poder
	 * 
	 * @param g
	 */
	private void dibujarPoderes(Graphics2D g) {
		if (pong.getPoder() != null) {
			g.draw(pong.getPoder().getFiguraPoder());
		}
	}

	/**
	 * Commprobar tipo de poder
	 */
	private void comprobarPoderHilo() {
		if (pong.getColision().colisionPoder()) {
			String cadena = pong.comprobarPoderHilo();
			movement.setPoder(cadena);
		}
	}

	/**
	 * Tipo de pelota
	 */
	private void comprobarTipoPelota() {
		if (categoriaPelota == "Fast") {
			movement.setTipoPelota("Fast");
		} else if (categoriaPelota == "Slow") {
			movement.setTipoPelota("Slow");
		} else if (categoriaPelota == "Increase") {
			movement.setTipoPelota("Increase");
		}
	}

	/**
	 * Inicio del hilo
	 */
	private void prepareHilo() {
		movement = new Movement(this);
		movement.start();
	}

	/**
	 * Instancia Pong
	 * 
	 * @return Pong pong
	 */
	public Pong getPong() {
		return pong;
	}

	public void refresque() {
		repaint();
	}

	/**
	 * Confirmaci�n de ganador
	 * 
	 */
	private void gameOver() {
		if (pong.puntaje1() >= Integer.parseInt(categoriaPuntaje) || pong.getPersonaje2().getFortaleza() < 250) {
			setVisible(false);
			movement.suspend();
			Winner winner = new Winner(true);
			winner.setVisible(true);
		} else if (pong.puntaje2() >= Integer.parseInt(categoriaPuntaje) || pong.getPersonaje1().getFortaleza() < 250) {
			movement.suspend();
			setVisible(false);
			Winner winner = new Winner(false);
			winner.setVisible(true);

		}
	}

}
