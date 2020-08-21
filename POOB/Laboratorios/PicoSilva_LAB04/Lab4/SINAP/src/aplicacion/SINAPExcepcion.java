package aplicacion; 

public class SINAPExcepcion extends Exception{
	
	public static final String NO_NOMBRE_INTERNACIONAL= "El nombre internacional es vacio";
	public static final String AREA_REPETIDA = "El area ya esta registrada";
	public static final String ESPACIOS_VACIOS = "No hay datos para registrar";
	public static final String SE_GENERO_ERROR = "Se encontró un error";
	
	public SINAPExcepcion(String message){
		super(message);
	}
	
	
}