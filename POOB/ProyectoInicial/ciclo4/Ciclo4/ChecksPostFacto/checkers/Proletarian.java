package checkers;

/**
 * Ficha proletarian
 * muere al tener que convertirse en rey
 */

public class Proletarian extends Ficha
{
    private int x,y,width;
    private String color;
    public Proletarian(int x, int y , String color,int width,boolean jugador)
    {        
        super(x,y,color,width,jugador);
        this.x= x;
        this.y = y;
        this.color=color;
        this.width = width;
    }
    
    public void deadKing(){
        if(getJugador() && x==width-1){
            makeInvisible();
        }
    }
}
    
