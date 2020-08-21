package Checkers;

/**
 * Ficha lazy
 * en un movimiento, solo salta una vez.
 */
public class Lazy extends Ficha
{

    private int x,y,width;
    private String color;
    private int conta=0;
    /**
     * Constructor for objects of class lazy
     */
    public Lazy(Tablero t, int x, int y ,String color,int width,boolean jugador)
    {
        super(t,x,y,color,width,jugador);
        x = 0;
    }
    
    @Override
    public void actionOnJump(Tablero t, boolean top, boolean right){
        if(conta==0){
            super.actionOnJump(t,top,right);
            conta++;
        }       
    }
}