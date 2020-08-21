package Checkers;


/**
 * Ficha Hurried.
 * repite dos veces el movimiento, si pueda 
 */
public class Hurried extends Ficha
{
    private int x,y,width;
    private String color; 

    public Hurried(Tablero t, int x, int y ,String color,int width,boolean jugador)
    {
        super(t,x,y,color,width,jugador);
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void move(boolean top, boolean right){
        super.move(top,right);
        super.move(top,right);
    }
    
    @Override
    public void actionOnJump(Tablero t, boolean top, boolean right){
        super.actionOnJump(t,top,right);
        super.actionOnJump(t,top,right);
    }
    
    

}