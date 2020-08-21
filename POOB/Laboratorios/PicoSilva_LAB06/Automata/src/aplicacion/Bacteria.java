package aplicacion;
import java.awt.Color;
/** El nuevo elemento que proponemos es una bacteria de forma cuadrada y amarilla, que tiene vida hasta su quinta generación.**/
public class Bacteria implements Elemento
{
    private final static char VIVA='v', MUERTA='m';
    protected char estadoActual,estadoSiguiente;
    private Color color;
    private int edad;
    /**
     * Constructor for objects of class Bacteria
     */
    public Bacteria(AutomataCelular ac , int fila , int columna)
    {
        ac.setElemento(fila,columna,(Elemento)this);
        color = Color.yellow;
        estadoActual=' ';
        estadoSiguiente=VIVA;
        edad = 0;
    }
    
    public final Color getColor(){
        return color;
    } 
    
    public final int getForma(){
        return CUADRADA;
    }
    
    public final int getEdad(){
        return edad;
    }
    
    public void decida(){
        if (edad>=5){
            estadoSiguiente=MUERTA;
        }
        else{
            estadoSiguiente = VIVA;
        }
    }
    
    public final void cambie(){
        edad++;
        estadoActual=estadoSiguiente;
    } 

    public final boolean isVivo(){
        return (estadoActual == VIVA) ;
    }

}

