package checkers;


/**
 * Ficha Hurried.
 * repite dos veces el movimiento, si pueda 
 */
public class Hurried extends Ficha
{
    private int x,y,width;
    private String color; 
    /**
     * Constructor for objects of class Hurried
     */
    public Hurried(int x, int y , String color,int width, boolean jugador)
    {
        super(x,y ,color,width,jugador);
        this.x = x;
        this.y = y;
    }
    
    

}