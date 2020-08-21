package Checkers;
import Shapes.*;
import java.util.HashMap;
import java.util.ArrayList;

public class Ficha implements AccionFicha
{
    // instance variables - replace the example below with your own
    private int x;
    private int y,width;
    public static  boolean sele;
    public static boolean dr, dl, ur, ul;
    private Circle ficha;
    private String color;
    private boolean jugador;
    public static HashMap<Integer,int[]> enumera;
    private Tablero t;

    public Ficha(Tablero t, int x, int y ,String color,int width,boolean jugador){
        this.x = x;
        this.y = y;
        this.color = color;
        this.jugador = jugador;
        sele  = false;
        ficha = new Circle(x,y,color,width);
        this.t=t;
        this.width = width;
    }

    /**
     * Retorna si una ficha está seleccionada.
     * @return boolean
     */
    public boolean isSelected() {
        return this.color.equals("blue");
    }

    /**
     * Retorna la ficha que se está utilizando
     * @return Circle
     */
    public Circle getCircle(){
        return ficha;
    }

    /**
     * Conoce si hay ficha intermedia para saltar.
     * @param Tablero t
     * @param int x
     * @param int y
     * @return boolean val
     */
    public boolean hayFichaIntermedia(Tablero t, int x, int y){
        boolean val = false;
        if(t.hayUnaFicha(x+20,y+20)){
            val = true;        
        }
        else if(t.hayUnaFicha(x-20,y+20)){
            val = true;        
        }        
        else if(t.hayUnaFicha(x+20,y-20)){
            val = true;        
        } 
        else if(t.hayUnaFicha(x-20,y-20)){
            val = true;        
        }
        return val;
    }

    /**
     * Confirma si hay ficha en el espacio de llegada del salto.
     * @param Tablero t
     * @param int x
     * @param int y
     * @return boolean val
     */
    public boolean hayFichaFinal(Tablero t, int x, int y){
        boolean val = true;
        if(t.hayUnaFicha(x+40,y+40)){
            val = false;        
        }
        else if(t.hayUnaFicha(x-40,y+40)){
            val = false;        
        }        
        else if(t.hayUnaFicha(x+40,y-40)){
            val = false;        
        } 
        else if(t.hayUnaFicha(x-40,y-40)){
            val = false;        
        }
        return val;
    }

    /**
     * Cambia color de una ficha.
     * @param String color
     */
    public void cambiarColor(String color){
        ficha.changeColor(color);
        this.color = color;
    }

    /**
     * vuelve visible la ficha
     */
    public void makeVisible(){
        ficha.makeVisible();    
    }

    /**
     * vuelve insible la ficha
     */
    public void makeInvisible(){
        ficha.makeInvisible();    
    }

    /**
     * Retorna el valor x de la posicion de la ficha.
     * @return int x
     */
    public Integer getX(){
        return x;
    }

    /**
     * Retorna el valor y de la posicion de la ficha.
     * @return int y
     */
    public Integer getY(){
        return y;
    }

    /**
     * Retorna de que jugador es la ficha.
     * @return boolean king
     */
    public boolean getJugador(){
        return jugador;
    }

    /**
     * Permite mover la ficha a la direccion dada.
     * @param boolean top
     * @param boolean right
     */
    public void move(boolean top, boolean right){
        if (top==false && right == true){
            ficha.moveDiagonal(20,20);
            x+=20;
            y+=20;

        }else if(top==false && right == false){
            ficha.moveDiagonal(20,-20);
            x-=20;
            y+=20;
        }else if(top == true && right == true){
            ficha.moveDiagonal(-20,20);
            x+=20;
            y-=20;
        }else{
            ficha.moveDiagonal(-20,-20);
            x-=20;
            y-=20;
        }
    }

    /**
     * Permite mover la ficha diagonalmente a la direccion dada.
     * @param int x
     * @param int y
     */
    public void moveDiagonal(int x , int y){
        this.x +=x;
        this.y +=y;
        ficha.moveDiagonal(x,y);        
    }

    /**
     * Permite mover la ficha diagonalmente a la direccion dada.
     * @param int x
     * @param int y
     */
    public void diagonal(int x , int y){
        this.x +=x;
        this.y +=y;
        ficha.moveDiagonal(y,x);        
    }

    /**
     * Realiza lo que debe hacer la ficha durante un salto.
     * @boolean top
     * @boolean right
     */
    public void actionOnJump(Tablero t, boolean top, boolean right){
        if (top==false && right == true){
            ficha.moveDiagonal(40,40);
            x+=40;
            y+=40;

            if (this.puedeCapturar()){
                t.removeFichaJump(x-20,y-20);
            }            
        }else if(top==false && right == false){
            ficha.moveDiagonal(40,-40);
            x-=40;
            y+=40;
            if(this.puedeCapturar()){
                t.removeFichaJump(x+20,y-20);
            }
        }else if(top == true && right == true){
            ficha.moveDiagonal(-40,40);
            x+=40;
            y-=40;
            if(this.puedeCapturar()){
                t.removeFichaJump(x-20,y+20);
            }
        }else if(top == true && right == false){
            ficha.moveDiagonal(-40,-40);
            x-=40;
            y-=40;
            if(this.puedeCapturar()){
                t.removeFichaJump(x+20,y+20);
            }
        }
    }

    /**
     * Confirma si una ficha es rey.
     * @return boolean val
     */
    private boolean isKing(){
        boolean val = false;
        if(y == 0){
            val = true;
        } else if(y == (width-1)*20 ){
            val = true;
        }
        return val; 
    }

    /**
     * Elimina a una ficha rey.
     */
    public void eliminaKing (){
        if(isKing()){
            t.removeFichaJump(x,y);
        }        
    }

    /**
     * Obtiene el color de la ficha actual
     * @return String color
     */
    public String getColor(){
        return color;
    }
    /**
     * Conoce si una ficha puede capturar.
     * @return boolean 
     */
    public boolean puedeCapturar(){
        return true;
    }
    
    /**
     * Conoce si una ficha es capturable
     * @return boolean 
     */
    public boolean isCapturable(){
        return true;
    }
    
    /**
     * Conoce si una ficha es "God"
     * @return boolean 
     */
    public boolean isGod(){
        return false;
    }
}
