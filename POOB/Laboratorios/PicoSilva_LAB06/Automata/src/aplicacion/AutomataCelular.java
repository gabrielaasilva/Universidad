package aplicacion;

import java.util.*;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AutomataCelular {
	static private int LONGITUD = 20;
	private Elemento[][] automata;
	private AutomataCelular ac;
	private String[][] escribe;
	private String toString;

	public AutomataCelular() {
		automata = new Elemento[LONGITUD][LONGITUD];
		escribe = new String[LONGITUD][LONGITUD];
		for (int f = 0; f < LONGITUD; f++) {
			for (int c = 0; c < LONGITUD; c++) {
				automata[f][c] = null;
			}
		}
		algunosElementos();
	}

	/**
	 * Retorna la longitud
	 * 
	 * @return LONGITUD
	 */
	public int getLongitud() {
		return LONGITUD;
	}

	/**
	 * Retorna un elemento en la posicion dada.
	 * 
	 * @param int f, int c
	 * @return automata[f][c]
	 **/

	public Elemento getElemento(int f, int c) {
		return automata[f][c];
	}

	/**
	 * Cambia un elemento en la posicion dada.
	 * 
	 * @param int f, int c, Elemento nueva
	 */
	public void setElemento(int f, int c, Elemento nueva) {
		automata[f][c] = nueva;
	}

	/**
	 * Permite agregar elementos al automata
	 */
	public void algunosElementos() {

		/**
		 * Elemento indiana = new Celula(this,1,1); Elemento OO7 = new Celula(this,2,2);
		 * Elemento marx = new Izquierdosa(this,3,10); Elemento hegel = new
		 * Izquierdosa(this,3,0); Elemento noreste = new Barrera(this,0,18); Elemento
		 * suroeste = new Barrera(this,19,0); Elemento Ana = new NewCelula(this,4,9);
		 * Elemento blue = new Celula(this,4,10); Elemento blue2 = new
		 * Celula(this,4,11); Elemento bacteria = new Bacteria(this,0,0);
		 **/
		/**
		 * Elemento john = new Conway(this, 5, 1); Elemento horton = new Conway(this, 5,
		 * 2); Elemento pp = new Conway(this, 0, 1); Elemento ppp = new Conway(this, 1,
		 * 1); Elemento pppp = new Conway(this, 1, 0); Elemento ppppp = new Conway(this,
		 * 0, 0); Elemento pppppp = new Conway(this, 4, 1); Elemento barrera = new
		 * Barrera(this, 0, 6);
		 **/
	}

	/** Permite realizar el TIC-TAC de celulas **/

	public void ticTac() {
		for (int f = 0; f < LONGITUD; f++) {
			for (int c = 0; c < LONGITUD; c++) {
				if (automata[c][f] != null) {
					automata[c][f].cambie();
					automata[c][f].decida();
				}
			}
		}
	}

	public void abrir(File file) throws AutomataExcepcion {
		FileInputStream leer;
		try {
			leer = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(leer);
			ac = (AutomataCelular) in.readObject();
			in.close();
		} catch (java.io.WriteAbortedException e) {
			e.printStackTrace();
		} catch (java.io.NotSerializableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException f) {
			f.printStackTrace();
		}
		cambioAutomata(ac);
	}

	private void cambioAutomata(AutomataCelular ac) {
		for (int i = 0; i < getLongitud(); i++) {
			for (int j = 0; j < getLongitud(); j++) {
				automata[i][j] = ac.getElemento(i, j);
			}
		}
	}

	public void salvar(File file) throws AutomataExcepcion {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(this);
			out.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	public void exporte(File file) throws AutomataExcepcion {

		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			for (int i = 0; i < getLongitud(); i++) {
				for (int j = 0; j < getLongitud(); j++) {
					if (automata[i][j] != null && automata[i][j] instanceof Conway) {
						try {
							bw.write("Conway" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Izquierdosa) {
						try {
							bw.write("Izquierdosa" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Bacteria) {
						try {
							bw.write("Bacteria" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Barrera) {
						try {
							bw.write("Barrera" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof NewCelula) {
						try {
							bw.write("NewCelula" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Celula) {
						try {
							bw.write("Celula" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void importe(File file) throws AutomataExcepcion {
		String cadena;
		String[] cadena2;
		FileReader in;

		try {
			in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			while ((cadena = br.readLine()) != null) {
				cadena2 = cadena.split(" ");
				if (cadena2[0].equals("Conway")) {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					Elemento newElemento = new Conway(this, num1, num2);
				} else if (cadena2[0] == "Izquierdosa") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					Elemento newElemento = new Izquierdosa(this, num1, num2);
				} else if (cadena2[0] == "Bacteria") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					Elemento newElemento = new Bacteria(this, num1, num2);
				} else if (cadena2[0] == "Barrera") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					Elemento newElemento = new Barrera(this, num1, num2);
				} else if (cadena2[0] == "NewCelula") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					Elemento newElemento = new NewCelula(this, num1, num2);
				} else if (cadena2[0] == "Celula") {
					int num1 = Integer.parseInt(cadena2[1]);
					int num2 = Integer.parseInt(cadena2[2]);
					Elemento newElemento = new Celula(this, num1, num2);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void exporte02(File file) throws AutomataExcepcion {

		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
			for (int i = 0; i < getLongitud(); i++) {
				for (int j = 0; j < getLongitud(); j++) {
					if (automata[i][j] != null && automata[i][j] instanceof Conway) {
						try {
							bw.write("Conway" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Izquierdosa) {
						try {
							bw.write("Izquierdosa" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Bacteria) {
						try {
							bw.write("Bacteria" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Barrera) {
						try {
							bw.write("Barrera" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof NewCelula) {
						try {
							bw.write("NewCelula" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (automata[i][j] != null && automata[i][j] instanceof Celula) {
						try {
							bw.write("Celula" + " " + i + " " + j);
							bw.newLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * public void importe02(File file) throws AutomataExcepcion { String cadena;
	 * String[] cadena2; FileReader in;
	 * 
	 * try { in = new FileReader(file); BufferedReader br = new BufferedReader(in);
	 * while ((cadena = br.readLine()) != null) { cadena2 = cadena.split(" "); if
	 * (cadena2[0] == "Conway") { int num1 = Integer.parseInt(cadena2[1]); int num2
	 * = Integer.parseInt(cadena2[2]); Elemento newElemento = new Conway(this, num1,
	 * num2); } else if (cadena2[0] == "Izquierdosa") { int num1 =
	 * Integer.parseInt(cadena2[1]); int num2 = Integer.parseInt(cadena2[2]);
	 * Elemento newElemento = new Izquierdosa(this, num1, num2); } else if
	 * (cadena2[0] == "Bacteria") { int num1 = Integer.parseInt(cadena2[1]); int
	 * num2 = Integer.parseInt(cadena2[2]); Elemento newElemento = new
	 * Bacteria(this, num1, num2); } else if (cadena2[0] == "Barrera") { int num1 =
	 * Integer.parseInt(cadena2[1]); int num2 = Integer.parseInt(cadena2[2]);
	 * Elemento newElemento = new Barrera(this, num1, num2); } else if (cadena2[0]
	 * == "NewCelula") { int num1 = Integer.parseInt(cadena2[1]); int num2 =
	 * Integer.parseInt(cadena2[2]); Elemento newElemento = new NewCelula(this,
	 * num1, num2); } else if (cadena2[0] == "Celula") { int num1 =
	 * Integer.parseInt(cadena2[1]); int num2 = Integer.parseInt(cadena2[2]);
	 * Elemento newElemento = new Celula(this, num1, num2); } else if (cadena2[0] !=
	 * "Conway" && cadena2[0] != "Izquierdosa" && cadena2[0] != "Bacteria" &&
	 * cadena2[0] != "Barrera" && cadena2[0] != "NewCelula" && cadena2[0] !=
	 * "Celula") { throw new
	 * AutomataExcepcion(AutomataExcepcion.NO_SE_RECONOCE_CELULA); } else if
	 * (Integer.parseInt(cadena2[1]) >= getLongitud()) { throw new
	 * AutomataExcepcion(AutomataExcepcion.NO_SE_RECONONOCE_LAPOSICION_TABLERO); } }
	 * } catch (IOException e) { e.printStackTrace(); } catch
	 * (IndexOutOfBoundsException e) { throw new
	 * AutomataExcepcion(AutomataExcepcion.NO_SE_RECONONOCE_LAPOSICION); } }
	 **/

	public void importe03(File file) throws ClassNotFoundException {
		String cadena, className;
		String[] cadena2;
		FileReader in;
		try {
			in = new FileReader(file);
			BufferedReader br = new BufferedReader(in);
			while ((cadena = br.readLine()) != null) {
				cadena2 = cadena.split(" ");
				int fila = Integer.parseInt(cadena2[1]);
				int columna = Integer.parseInt(cadena2[2]);
				className = cadena2[0];
				Class<?> clazz = Class.forName("aplicacion."+className);
				Constructor<?> ctor = null;
				try {
					ctor = clazz.getConstructor(AutomataCelular.class,int.class,int.class);
				} catch (NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				try {
					Object object = ctor.newInstance(new Object[] { this, fila, columna });
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException	| InvocationTargetException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
