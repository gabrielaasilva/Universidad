package Checkers;

/**
 * Ficha proletarian
 * muere al tener que convertirse en rey
 */

public class Proletarian extends Ficha
{
    private int x,y,width;
    private String color;
    private Tablero t;
    public Proletarian(Tablero t,int x, int y , String color,int width,boolean jugador)
    {        
        super(t,x,y,color,width,jugador);
        this.x= x;
        this.y = y;
        this.color=color;
        this.width = width;
        this.t = t;
    }
    
    @Override
    public void move(boolean top, boolean right){
        super.move(top,right);
        eliminaKing();
    }
    }


