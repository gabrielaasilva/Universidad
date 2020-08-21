package checkers;


/**
 * Ficha Powerful 
 * No se deja capturar  
 */
public class Powerful extends Ficha
{
    private int x,y,width;
    private String color;

    /**
     * Constructor for objects of class Powerful
     */
    public Powerful(int x, int y , String color,int width, boolean jugador){
        super(x,y,color,width,jugador);
        
    }
}
