
package Checkers;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class checkers 
{
    protected Tablero config;
    protected Tablero game;
    private ArrayList<ArrayList<Integer>> posiciones;
    private HashMap<String,String> dic;
    private static  HashMap<Integer,int[]> enumera;
    private static  HashMap<Integer,Character> ocupada;   
    private int width;
    private boolean itsOk =true; 
    private static boolean ul = false,ur=false,dl=false,dr=false;
    private String tipo;
    private String colores;
    private int x1= 0 ,y1=0 ;

    /**
     * Constructor for objects of class Checkers
     */
    public checkers(int width)
    {
        // initialise instance variables
        config = new Tablero(width,true);
        game = new Tablero(width,false);
        game.moveTablero(width*20+100);
        enumera = game.getHashMap();
        config.makeVisible();
        game.makeVisible();
        dic = new HashMap<String,String>();
        ocupada = new HashMap<Integer,Character>();
        this.width = width;
    }

    /**
     * Añade fichas de un jugador
     * @param boolean yellow
     * @param int[][] men
     */
    public void add(boolean jugadorUno,int [][] men,String type){
        tipo = "configuracion";
        if(itsOk==true){
            config.add(jugadorUno,men,type);
        }else{
            JOptionPane.showMessageDialog(null,"Esta en configuracion por lo que no puede seleccionar fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }         

    }

    /**Selecciona la ficha requerida por el usuario
     * @param int row 
     * @param int column
     */
    public void select (int row, int column){
        tipo = "juego";
        if(itsOk == false){
            config.select(row,column);
        } else{
            JOptionPane.showMessageDialog(null,"Esta en configuracion por lo que no puede seleccionar fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }  

    /**Permite mover diagonalmente la ficha seleccionada
     * @param boolean top
     * @param boolean right
     */
    public void shift(boolean top, boolean right){
        tipo = "juego";
        boolean bandera;
        if(itsOk==false){
            config.shift(top,right);                
        }else{
            JOptionPane.showMessageDialog(null,"Esta en configuracion por lo que no puede mover fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Salta fichas si hay otra alrededor
     * @param boolean top
     * @param boolean right
     */
    public void jump(boolean top, boolean right){
        tipo = "juego";
        if(itsOk==false){
            config.jump(top,right);
        }
        else{
            JOptionPane.showMessageDialog(null,"Esta en configuracion por lo que no puede mover fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }   

    /**
     * Mueve la ficha desde la casilla donde está hasta la que se le da.
     * @param String notation
     */
    public void move(String notation){
        tipo = "juego";
        if(itsOk==false){
            config.move(notation);
        }
        else{
            JOptionPane.showMessageDialog(null,"Esta en configuracion por lo que no puede mover fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Añade un rey a cierto jugador
     * @param boolean yellow
     * @param boolean king
     * @param int row
     * @param int column
     */
    public void add(boolean jugadorUno,boolean king,int row, int column){
        tipo = "configuracion";
        int[][]men ={{row,column}};
        if(itsOk==true){
            config.add(jugadorUno,king,row,column);
        }else{
            JOptionPane.showMessageDialog(null,"Esta en juego por lo que no puede agregar fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Remueve una ficha en especifico
     * @param int row
     * @param int column
     */
    public void remove(int row, int column){
        tipo = "configuracion";
        if(itsOk==true){
            config.remove(row,column);
        }else{
            JOptionPane.showMessageDialog(null,"Esta en juego por lo que no puede remover fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Remueve fichas
     * @param int[][] pieces
     */
    public void remove(int [][] pieces){
        tipo = "configuracion";
        if(itsOk==true){
            config.remove(pieces);
        }else{
            JOptionPane.showMessageDialog(null,"Esta en juego por lo que no puede remover fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Cambia de tablero de configuracion al tablero de juego 
     */
    public void swap(){
        if (itsOk== true){
            itsOk = false;
        }else{
            itsOk = true;
        }
    }

    /**
     * Termina el juego 
     */
    public void finish(){
        System.exit(0);
    }

    /**
     * confirma si el anterior metodo fue ejecutado
     * @return afirmacion o negacion del anterior metodo realizado 
     */
    public boolean ok(){
        boolean x = game(itsOk);
        boolean y = board(itsOk);
        if (tipo=="juego"){
            return(x);  
        }else{
            return(y);        
        }
    }

    /*
     * Método para saber conocer en que tipo de tablero está.
     * @param boolean juego
     */
    private boolean game(boolean juego){
        juego=itsOk;
        if (juego== false){
            return (true);
        } else{       
            return (false);
        }

    }

    /*
     * Método para saber conocer en que tipo de tablero está.
     * @param boolean juego
     */
    private boolean board(boolean tablero){
        tablero = itsOk;
        if (tablero == true){
            return true;
        }else{
            return false;
        }
    }

    /**
     *  Hace visible las fichas 
     */
    public void makeVisible(){
        config.makeVisibleF();
    }

    /**
     * Hace invisible las fichas
     */
    public void makeInvisible(){
        config.makeInvisible();
    }

    /**
     * lee el tablero actual que está en juego.
     * @param String checkerboard
     */
    public void read(String checkerboard ){
        int total =checkerboard.length();
        int width2 = (int) Math.sqrt(total);
        for (int i = 0 ; i<total ; i++){            
            if( checkerboard.charAt(i)== 'b'){
                add(false,false,i/8,i%8);
            }else if (checkerboard.charAt(i)== 'B'){
                add(false,true,i/8,i%8);
            }else if (checkerboard.charAt(i)== 'w'){
                add(true,false,i/8,i%8);
            }else if (checkerboard.charAt(i)== 'W'){
                add(true,true,i/8,i%8);
            }                                  
        }
    }

    /**
     * Escribe el tablero actual de configuracion en un String
     * @return tablero de configuracion en cadena 
     */
    public String write(){
        tipo = "configuracion";
        return config.write();
    }

    /**
     * Guarda el tablero segun el nombre ingresado
     * @param name
     */
    public void save (String name){
        String s = write();
        dic.put(name,s);        
    }

    /**
     * Recupera el tablero segun el nombre ingresado
     * @param name
     * @return La representacion de la informacion del tablero 
     */
    public String recover(String name){
        return dic.get(name);
    }

    /*
     * Retorna el HashMap requerido
     * @return HasMap
     */
    public HashMap ocupada(){
        return ocupada;
    }

    /*
     * Retorna el arreglo requerido
     * @param int key
     * @return int[]
     */
    public int[] getPosicionEnumera(int key){
        return enumera.get(key);
    } 

    /*
     * Modifica el HashMap requerido
     */
    public void modificaOcupada(int key , char value){
        ocupada.replace(key,value);
    } 

    /*
     * Retorna la posicion donde se encuentra una ficha.
     * @return char
     */
    public char getPosicionOcupada(int key){
        return ocupada.get(key);
    } 

}
