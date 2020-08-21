package checkers;


/**
 * Ficha lazy
 * en un movimiento, solo salta una vez.
 */
public class Lazy extends Ficha
{
    
    private int x,y,width;
    private String color;

    /**
     * Constructor for objects of class lazy
     */
    public Lazy(int x, int y , String color,int width, boolean jugador)
    {
        super(x,y,color,width,jugador);
        x = 0;
    }
}