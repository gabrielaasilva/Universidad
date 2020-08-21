
import java.util.ArrayList;
/**
 * Write a description of class Tablero here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Tablero
{
    // instance variables - replace the example below with your own
    private int x;
    private ArrayList<ArrayList<Rectangle>> tablero;
    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int width)
    {
        tablero = new ArrayList<>();
        String color = null;
        for(int i=0;i<width;i++){
            ArrayList<Rectangle> fila = new ArrayList<>();
            for (int j=0;j<width;j++){
                Rectangle cuadrado = new Rectangle(j*20,i*20,calColor(i,j),width) ;                
                fila.add(cuadrado);

            }
            tablero.add(fila);
        }

    }
    /**
     * Convierte el tablero en visible
     */
    public void makeVisible(){
        for(int i=0;i<tablero.size();i++){
            for(int j = 0;j<tablero.size();j++){
                tablero.get(i).get(j).makeVisible();
            }
        } 
    }
    
    /**
     * @param int x
     */
    public void move(int x){
        for(int i=0;i<tablero.size();i++){
            for(int j = 0;j<tablero.size();j++){
                tablero.get(i).get(j).moveHorizontal(x);                
            }
        }    
    }
    /**
     * @param int x
     * @param int y
     * @return String
     */
    public String getColor(int x, int y){
        return tablero.get(x).get(y).getColor();
    }

    /**
     * @param int i 
     * @param int j 
     * @return String color
     */
    public String calColor(int i , int j){
        String color;
        if(i==0){
            if (j%2==0)
                color = "gray";
            else
                color = "black";            
        }
        else{
            if(tablero.get(i-1).get(j).getColor().equals("gray"))
                color = "black";     
            else
                color = "gray";                            
        }
        return color;
    }

}
