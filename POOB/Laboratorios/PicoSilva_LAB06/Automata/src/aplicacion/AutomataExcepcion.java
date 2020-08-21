package aplicacion;

public class AutomataExcepcion extends Exception {
	public static final String NO_OPCION_OPEN= "Opción abrir en construccion";
	public static final String NO_OPCION_SALVAR= "Opción salvar en construccion";
	public static final String NO_OPCION_IMPORTAR= "Opción importar en construccion";
	public static final String NO_OPCION_EXPORTAR= "Opción exportar en construccion";
	public static final String NO_OPCION_SALIR= "Opción salir en construccion";
	public static final String NO_SE_RECONOCE_CELULA= "Se ha importado una celula no reconocida";
	public static final String NO_SE_RECONONOCE_LAPOSICION= "Se ha importado una celula fuera de rango del txt";
	public static final String NO_SE_RECONONOCE_LAPOSICION_TABLERO= "Se ha importado una celula fuera de rango del tablero";
	public AutomataExcepcion (String message) {
		super(message);
	}
}
