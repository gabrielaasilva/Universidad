package checkers;


/**
 * Ficha Libertarian.
 * No captura las piezas que salta.
 */
public class Libertarian extends Ficha
{
    private int x,y,width;
    private String color;
    public Libertarian(int x, int y , String color,int width, boolean jugador)
    {
        super(x,y,color,width,jugador);
    }


}
