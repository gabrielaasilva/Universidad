package aplicacion;
import java.awt.Color;
/** Los barreras son cuadradas, negras y como barreras están muertas: ni deciden ni cambian.**/
public class Barrera implements Elemento
{
    private Color color;
    /**
     * Constructor for objects of class Barrera
     */
    public Barrera(AutomataCelular ac, int fila , int columna)
    {
        ac.setElemento(fila,columna,(Elemento)this);        
        color = Color.black;
    }
    
    public final int getForma(){
        return CUADRADA;
    }  
    
    public final Color getColor(){
        return color;
    } 
    
}