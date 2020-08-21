import java.util.HashMap;
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
    private int x,xPosition=0,yPosition= 0,contador,width;
    private ArrayList<ArrayList<Rectangle>> tablero;
    public HashMap<Integer,int[]> enumera;HashMap<Integer,int[]> enumera2 ;
    //private HashMap<Integer,Rectangle>
    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(int width, boolean juego)
    {
        tablero = new ArrayList<>();
        String color = null;
        contador = 1;
        this.width = width;
        if (juego == false){
            enumera = new HashMap<Integer, int[]>();
        }
        else{
            enumera2 = new HashMap<Integer, int[]>();
        }
        for(int i=0;i<width;i++){
            ArrayList<Rectangle> fila = new ArrayList<>();
            yPosition=i*20;
            for (int j=0;j<width;j++){
                xPosition=j*20;
                Rectangle cuadrado = new Rectangle(j*20,i*20,calColor(i,j),width) ;                
                fila.add(cuadrado);
            }
            tablero.add(fila);
        }
    }
    
    public HashMap getHashMap(){
        return enumera;
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
        int[] vacio = new int[2];
        vacio[0] = width*20+(100+xPosition); vacio[1] = yPosition;
        if(i==0){
            if (j%2==0){
                color = "gray";}
            else{
                color = "black";
                if(enumera==null){
                    enumera2.put(contador,vacio);
                }else{
                    enumera.put(contador,vacio);
                    contador++;
                }                
            }
        }
        else{
            if(tablero.get(i-1).get(j).getColor().equals("gray")){
                color = "black"; 
                if(enumera==null){
                    enumera2.put(contador,vacio);
                }
                else{
                    enumera.put(contador,vacio);
                    contador++;
                }              
            }
            else{
                color = "gray";}                            
        }
        return color;
    }

    public HashMap hash(){
        return enumera;
    }
}
