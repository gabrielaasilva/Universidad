package Checkers;


/**
 * Ficha creada por nosotros (God)
 * Si una ficha God captura una del equipo contrario tendrá el pode de
 * eliminar otra ficha del otro equipo.
 */
public class God extends Ficha
{
    private int x,y,width;
    private String color;
    private boolean jugador;
    public God(Tablero t, int x, int y ,String color,int width,boolean jugador)
    {        
        super(t,x,y,color,width,jugador);
        this.x= x;
        this.y = y;
        this.color=color;
        this.width = width;
        this.jugador= jugador;
    }
    
    @Override
    public boolean getJugador(){
        super.getJugador();
        return jugador;
    }
    
    @Override
    public boolean isGod(){
        return true;
    }
}
