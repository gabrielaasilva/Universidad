package Aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarbelGame{
	private Pieces[][] pieces;
	private Pieces[][] copiaPieces;
	private EmptyMarbel[][] empty;
	private EmptyMarbel[][] copiaEmpty;
	private int size, canicas, barreras;
	private boolean x;
	private boolean y;
	private ArrayList<EmptyMarbel> emptyPieces;
	private Color[] colores = { Color.PINK, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE, Color.BLUE,
			Color.RED };
	private Color color;
	private HashMap<String, Object> recover;

	public MarbelGame(int size, int canicas, int barreras) {
		this.size = size;
		this.canicas = canicas;
		this.barreras = barreras;
		emptyPieces = new ArrayList<EmptyMarbel>();
		pieces = new Pieces[size][size];

		empty = new EmptyMarbel[size][size];

		drawEmpty();
		drawFill();
		drawBarrier();
	}

	private void drawFill() {
		int numero1, numero2;
		FillMarbel fill;
		numero1 = (int) (Math.random() * size);
		numero2 = (int) (Math.random() * size);
		for (int i = 0; i < canicas; i++) {
			if (this.getPieces(numero1, numero2) == null) {
				fill = new FillMarbel(this, numero1, numero2);
				setPieces(numero1, numero2, fill);
				fill.changeColor(colores[i]);
			} else {
				numero1 = (int) (Math.random() * size);
				numero2 = (int) (Math.random() * size);
				fill = new FillMarbel(this, numero1, numero2);
				setPieces(numero1, numero2, fill);
				fill.changeColor(colores[i]);
			}
		}
	}

	private void drawEmpty() {
		int numero1, numero2;
		EmptyMarbel fill;
		numero1 = (int) (Math.random() * size);
		numero2 = (int) (Math.random() * size);
		for (int i = 0; i < canicas; i++) {
			if ((this.getEmptyPieces(numero1, numero2) == null)
					&& (!(this.getPieces(numero1, numero2) instanceof Barrier))) {
				fill = new EmptyMarbel(this, numero1, numero2);
				setPiecesEmpty(numero1, numero2, fill);
				fill.changeColor(colores[i]);
			} else {
				numero1 = (int) (Math.random() * size);
				numero2 = (int) (Math.random() * size);
				fill = new EmptyMarbel(this, numero1, numero2);
				setPiecesEmpty(numero1, numero2, fill);
				fill.changeColor(colores[i]);
			}
		}
	}

	private void drawBarrier() {
		int numero1, numero2;
		numero1 = (int) (Math.random() * size);
		numero2 = (int) (Math.random() * size);
		for (int i = 0; i < barreras; i++) {
			if (this.getPieces(numero1, numero2) == null) {
				setPieces(numero1, numero2, new Barrier(this, numero1, numero2));
			} else {
				numero1 = (int) (Math.random() * size);
				numero2 = (int) (Math.random() * size);
				setPieces(numero1, numero2, new Barrier(this, numero1, numero2));
			}
		}

	}

	public boolean getRandomBooleanX() {
		x = Math.random() < 0.5;
		return x;

	}

	public boolean getRandomBooleanY() {
		y = Math.random() < 0.5;
		return y;

	}

	public void alNorte() {
		for (int i = size - 1; i >= 0; i--) {
			for (int j = size - 1; j >= 0; j--) {
				if (pieces[i][j] != null && pieces[i][j].canMove()) {
					int k = i;
					while (k < size - 1) {
						if (getEmptyPieces(k + 1, j) != null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k + 1, j);
							setPieces(k + 1, j, fill);
							fill.changeColor(color);
							k = size - 1;
						} else if (pieces[k + 1][j] instanceof Barrier) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k, j);
							setPieces(k, j, fill);
							fill.changeColor(color);
							k = size - 1;
						} else if (pieces[i][k + 1] instanceof FillMarbel) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k, j);
							setPieces(k, j, fill);
							fill.changeColor(color);
							k = size - 1;
						} else if (k + 2 == size && pieces[k + 1][j] == null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k + 1, j);
							setPieces(k + 1, j, fill);
							fill.changeColor(color);

						} else if (combinado(k + 1, j) && k + 2 > size) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k, j);
							setPieces(k, j, fill);
							fill.changeColor(color);
							k = size - 1;
						}
						k++;
					}

				}
			}
		}
	}

	public void alOeste() {
		for (int i = size - 1; i >= 0; i--) {
			for (int j = size - 1; j >= 0; j--) {
				if (pieces[i][j] != null && pieces[i][j].canMove()) {
					int k = j;
					while (k < size - 1) {

						if (getEmptyPieces(i, k + 1) != null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k + 1);
							setPieces(i, k + 1, fill);
							fill.changeColor(color);
							k = size - 1;
						} else if (pieces[i][k + 1] instanceof Barrier) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k);
							setPieces(i, k, fill);
							fill.changeColor(color);
							k = size - 1;
						} else if (pieces[i][k + 1] instanceof FillMarbel) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k);
							setPieces(i, k, fill);
							fill.changeColor(color);
							k = size - 1;
						} else if (k + 2 == size && pieces[i][k + 1] == null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k + 1);
							setPieces(i, k + 1, fill);
							fill.changeColor(color);
							k = size - 1;

						} else if (combinado(i, k + 1) && k + 2 > size) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k);
							setPieces(i, k, fill);
							fill.changeColor(color);
							k = size - 1;
						}
						k++;
					}

				}
			}
		}
	}

	public void alEste() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (pieces[i][j] != null && pieces[i][j].canMove()) {
					int k = j;
					while (k > 0) {
						if (getEmptyPieces(i, k - 1) != null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k - 1);
							setPieces(i, k - 1, fill);
							fill.changeColor(color);
							k = 0;
						} else if (pieces[i][k - 1] instanceof Barrier) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k);
							setPieces(i, k, fill);
							fill.changeColor(color);
							k = 0;
						} else if (pieces[i][k - 1] instanceof FillMarbel) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k);
							setPieces(i, k, fill);
							fill.changeColor(color);
							k = 0;
						} else if (k - 2 == -1 && pieces[i][k - 1] == null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k - 1);
							setPieces(i, k - 1, fill);
							fill.changeColor(color);
						} else if (combinado(i, k - 1) && k - 2 == -1) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, i, k);
							setPieces(i, k, fill);
							fill.changeColor(color);
							k = 0;
						}
						k--;
					}

				}
			}
		}
	}

	public void alSur() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (pieces[i][j] != null && pieces[i][j].canMove()) {
					int k = i;
					while (k > 0) {
						if (getEmptyPieces(k - 1, j) != null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k - 1, j);
							setPieces(k - 1, j, fill);
							fill.changeColor(color);
							k = 0;
						} else if (pieces[k - 1][j] instanceof Barrier) {
							System.out.println("hola2");
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k, j);
							setPieces(k, j, fill);
							fill.changeColor(color);
							k = 0;
						} else if (pieces[i][k - 1] instanceof FillMarbel) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k, j);
							setPieces(k, j, fill);
							fill.changeColor(color);
							k = 0;
						} else if (k - 2 == -1 && pieces[k - 1][j] == null) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k - 1, j);
							setPieces(k - 1, j, fill);
							fill.changeColor(color);
						} else if (combinado(k - 1, j) && k - 2 == -1) {
							color = pieces[i][j].getColor();
							pieces[i][j] = null;
							FillMarbel fill = new FillMarbel(this, k, j);
							setPieces(k, j, fill);
							fill.changeColor(color);
							k = 0;
						}
						k--;
					}

				}
			}
		}
	}

	public boolean combinado(int fila, int columna) {
		if (pieces[fila][columna] != null && empty[fila][columna] != null) {
			return true;
		}
		return false;
	}

	public Pieces getPieces(int fila, int columna) {
		return pieces[fila][columna];

	}

	public Pieces getPiecesCopia(int fila, int columna) {
		return copiaPieces[fila][columna];

	}

	public EmptyMarbel getEmptyPieces(int fila, int columna) {
		return empty[fila][columna];
	}

	public void setPieces(int fila, int columna, Pieces nuevo) {
		pieces[fila][columna] = nuevo;
	}

	public void setPiecesEmpty(int fila, int columna, EmptyMarbel nuevo) {
		empty[fila][columna] = nuevo;
	}

	public void recover() {
		
		delete();
		clones();

	}

	public void clones() {
		for (EmptyMarbel[] p : empty) {
            for (EmptyMarbel j : p) {
                if (j != null) {
                    System.out.println("recupero, entro al if");
                    setPiecesEmpty(j.getFila(), j.getColumna(), j);
                }
            }
        }
        for (Pieces[] p : pieces) {
            for (Pieces j : p) {
                if (j.getForma() == 0 & !(j.equals(null))) {
                    System.out.println("recupero, entro al if");
                    setPieces(j.getFila(), j.getColumna(), j);
                } else if (j.getForma() == 1 & !(j.equals(null))) {
                    System.out.println("recupero, entro al elseif");
                    setPieces(j.getFila(), j.getColumna(), j);
                }
            }
        }
	}
	
	

	public void delete() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				pieces[i][j] = null;
				empty[i][j] = null;
			}
		}
	}
}
