package aplicacion;

public class AutomataExcepcion extends Exception {
	public static final String NO_OPCION_OPEN= "Opci�n abrir en construccion";
	public static final String NO_OPCION_SALVAR= "Opci�n salvar en construccion";
	public static final String NO_OPCION_IMPORTAR= "Opci�n importar en construccion";
	public static final String NO_OPCION_EXPORTAR= "Opci�n exportar en construccion";
	public static final String NO_OPCION_SALIR= "Opci�n salir en construccion";
	public static final String NO_SE_RECONOCE_CELULA= "Se ha importado una celula no reconocida";
	public static final String NO_SE_RECONONOCE_LAPOSICION= "Se ha importado una celula fuera de rango del txt";
	public static final String NO_SE_RECONONOCE_LAPOSICION_TABLERO= "Se ha importado una celula fuera de rango del tablero";
	public AutomataExcepcion (String message) {
		super(message);
	}
}
