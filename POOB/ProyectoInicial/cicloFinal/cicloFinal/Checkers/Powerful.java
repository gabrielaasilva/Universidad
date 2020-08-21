package Checkers;

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
    public Powerful(Tablero t, int x, int y ,String color,int width,boolean jugador){
        super(t,x,y,color,width,jugador);
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean isCapturable(){
        return false;
    }
}