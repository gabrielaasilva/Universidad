package Checkers;

/**
 * Ficha Libertarian.
 * No captura las piezas que salta.
 */
public class Libertarian extends Ficha
{
    private int x,y,width;
    private String color;
    public Libertarian(Tablero t, int x, int y ,String color,int width,boolean jugador)
    {
        super(t,x,y,color,width,jugador);
        this.x= x;
        this.y = y;
        this.color=color;
        this.width = width;
    }
    /**
     * Confirma si este tipo de ficha puede capturar
     */
    @Override
    public boolean puedeCapturar(){
        return false;
    }
}
