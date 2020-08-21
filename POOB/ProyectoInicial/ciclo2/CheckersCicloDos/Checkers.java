import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.HashMap;
/**
 * Write a description of class Checkers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Checkers
{
    // instance variables - replace the example below with your own
    private Tablero config;
    private Tablero game;
    private ArrayList<Ficha> fichas;
    private ArrayList<Ficha> fichasJuego;
    private ArrayList<ArrayList<Integer>> posiciones;
    private HashMap<String,String> dic;
    private Ficha ficha;
    private int width;
    private boolean itsOk =true; 
    private static boolean ul = false,ur=false,dl=false,dr=false;
    private String tipo;
    private String colores;
    private int x1= 0 ,y1=0 ;
    /**
     * Constructor for objects of class Checkers
     */
    public Checkers(int width)
    {
        // initialise instance variables
        config = new Tablero(width);
        game = new Tablero(width);
        game.move(width*20+100);
        config.makeVisible();
        game.makeVisible();
        fichas = new ArrayList<>();
        fichasJuego = new ArrayList<>();
        dic = new HashMap<String,String>();
        this.width = width;
    }

    /**Selecciona la ficha requerida por el usuario
     * @param int row 
     * @param int column
     */

    public void select (int row, int column){
        tipo = "juego";
        if(itsOk == false){
            column =column*20;
            int column2 = width*20+(100+column);        
            row = (row*20);
            if (fichasJuego.size()>0){
                for(int i=0; i<fichasJuego.size();i++){     
                    if((fichasJuego.get(i).getX()==column2) && (fichasJuego.get(i).getY()==row)){
                        colores = fichasJuego.get(i).getColor();
                        fichasJuego.get(i).cambiarColor("blue");                
                    } 
                }
            }else{
                JOptionPane.showMessageDialog(null,"No hay nada para seleccionar","ERROR!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
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
            for(int i=0;i<fichasJuego.size();i++){

                if(fichasJuego.get(i).getColor()=="blue"){                    
                    fichasJuego.get(i).move(top,right);
                    if(colores.equals("yellow")){
                        fichasJuego.get(i).cambiarColor("yellow");
                    }else{           
                        fichasJuego.get(i).cambiarColor("red");
                    }    
                }
            }
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
            for(int i=0;i<fichasJuego.size();i++){
                if(fichasJuego.get(i).getColor()=="blue"){
                    jumpDos(top, right);
                    if(colores.equals("yellow")){
                        fichasJuego.get(i).cambiarColor("yellow");
                    }else{           
                        fichasJuego.get(i).cambiarColor("red");}    
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Esta en configuracion por lo que no puede mover fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @parama String notation
     */
    public void move(String notation){
        tipo = "juego";
        boolean bandera;
        if(itsOk==false){
            for(int i=0;i<fichasJuego.size();i++){
                if(fichasJuego.get(i).getColor()=="blue"){
                    if(notation == "derecha"){
                        fichasJuego.get(i).move(false,true);
                    }else if (notation == "izquierda"){
                        fichasJuego.get(i).move(false,false);
                    }
                    if(colores.equals("yellow")){
                        fichasJuego.get(i).cambiarColor("yellow");
                    }else{           
                        fichasJuego.get(i).cambiarColor("red");
                    }    
                }
            }
        }else{
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
    public void add(boolean yellow,boolean king,int row, int column){
        tipo = "configuracion";
        int[][]men ={{row,column}};
        if(itsOk==true){
            if (king == true){
                addFichaKingConfi(yellow,column,row);
                addFichaKingJuego(yellow,column,row);
                makeVisible();
            }else{
                add(yellow,men);    
            }
        }else{
            JOptionPane.showMessageDialog(null,"Esta en juego por lo que no puede agregar fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Añade fichas de un jugador
     * @param boolean yellow
     * @param int[][] men
     */
    public void add(boolean yellow,int [][] men){
        tipo = "configuracion";
        if(itsOk==true){ 
            addFichaConfi(yellow,men);
            addFichaJuego(yellow,men);
            makeVisible();
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
            row = row *20;
            column = column*20;        
            removeFichas(row, column);
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
            removeBaseConfi(pieces);
            removeBaseJuego(pieces);
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
     * @return int[][][] consult
     */
    public int[][][] consult(){
        return null;

    }

    /**
     *  Hace visible las fichas 
     */
    public void makeVisible(){
        for(int i=0;i<fichas.size();i++){
            fichas.get(i).makeVisible();
            fichasJuego.get(i).makeVisible();
        }

    }

    /**
     * Hace invisible las fichas
     */
    public void makeInvisible(){
        for(int i=0;i<fichas.size();i++){
            fichas.get(i).makeInvisible();
            fichasJuego.get(i).makeInvisible();
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

    /**
     * @param String checkerboard
     */
    public void read(String checkerboard ){
        int total =checkerboard.length();
        int width2 = (int) Math.sqrt(total);
        for (int i = 0 ; i<total ; i++){            
            System.out.println(checkerboard.charAt(i));
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
        posiciones = new ArrayList<ArrayList<Integer>>();
        String[][]lineas = new String[width][width];
        String cadena ="";        
        baseWrite(lineas,cadena);
        for(String[]l:lineas){
            for(String p:l){
                cadena+=p;
            }
        }
        return cadena;
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

    public String move(){
        return "";
    }

    /*
    public void move(){

    }
     */
    /*
     * Ajusta la posicion de la ficha  dependiendo de su  color que y la convierte en rey de un distinto color en el tablero de configuracion
     * @param yellow
     * @param row
     * @param column
     */
    private void addFichaKingConfi(boolean yellow , int row, int column){
        Ficha rey;
        row = row *20;
        column = column*20;
        if (getColor(row/20,column/20) == "black" && yellow == true){
            Ficha ficha = new Ficha(row,column,"orange",width,true);
            fichas.add(ficha);    
        } else if(getColor(row/20,column/20) == "black" && yellow == false){
            Ficha ficha = new Ficha(row,column,"pink",width,true);
            fichas.add(ficha); 
        }else{
            JOptionPane.showMessageDialog(null,"Esta agregando a una casilla invalida intente de nuevo","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Ajusta la posicion de la ficha  dependiendo de su  color que y la convierte en rey de un distinto color en el tablero de juego
     * @param yellow
     * @param row
     * @param column
     */
    private void addFichaKingJuego(boolean yellow  , int row , int column){
        Ficha rey;
        row = row*20;
        column = column * 20;
        if (getColor(row/20,column/20) == "black" && yellow == true){
            Ficha ficha = new Ficha(width*20+(100+row),column,"orange",width,true); 
            fichasJuego.add(ficha);
        } else if (getColor(row/20,column/20) == "black"&& yellow == false){
            Ficha ficha = new Ficha(width*20+(100+row),column,"pink",width,true); 
            fichasJuego.add(ficha);
        }
    }

    /*
     * añade fichas al tablero de configuracion
     * @param yellow
     * @param men
     */
    private void addFichaConfi(boolean yellow,int [][] men){
        int x = 0,y = 0;        
        boolean bandera ; 
        for (int[] i:men ){
            bandera = true;
            for(int j:i){
                if (bandera){
                    y = j*20;
                    bandera = false;
                }else{
                    x = j*20;
                }
            }
            addFichaConfiColor(x,y,yellow);
        }
    }

    /*
     * Dependiendo del booleano del color se le asignara este
     * @param x
     * @param y
     * @param yellow
     */
    private void addFichaConfiColor(int x,int y,boolean yellow){
        if (getColor(x/20,y/20) == "black" && yellow == true){
            Ficha ficha = new Ficha(x,y,"yellow",width,false);
            fichas.add(ficha);    
        } else if(getColor(x/20,y/20) == "black" && yellow == false){
            Ficha ficha = new Ficha(x,y,"red",width,false);
            fichas.add(ficha); 
        }else{
            JOptionPane.showMessageDialog(null,"Esta agregando a una casilla invalida intente de nuevo","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * añade fichas al tablero de juego
     * @param yellow
     * @param men
     */
    private void addFichaJuego(boolean yellow ,int [][] men){
        int x = 0,y = 0;        
        boolean bandera ; 
        for (int[]i:men ){
            bandera = true;
            for(int j:i){
                if (bandera){
                    y = j*20;
                    bandera = false;
                }else{
                    x = j*20;                    
                }
            }
            if (getColor(x/20,y/20) == "black" && yellow == true){
                Ficha ficha = new Ficha(width*20+(100+x),y,"yellow",width,false); 
                fichasJuego.add(ficha);
            } else if (getColor(x/20,y/20) == "black"&& yellow == false){
                Ficha ficha = new Ficha(width*20+(100+x),y,"red",width,false); 
                fichasJuego.add(ficha);
            }
        }
    }

    /*
     * Remueve fichas de confi
     * @pieces
     */
    private void removeBaseConfi(int[][] pieces){
        int x = 0,y = 0; 
        boolean bandera ; 
        for (int[]i:pieces){
            bandera = true;
            for(int j:i){
                if (bandera){
                    y = j*20;
                    bandera = false;
                }else{
                    x = j*20;
                }               
            }
            for(int k=0;k<fichas.size();k++){                       
                if((fichas.get(k).getX()==x) && (fichas.get(k).getY()==y)){
                    fichas.get(k).makeInvisible();               
                    fichas.remove(k);
                }
            }
        }
    }

    private void removeBaseJuego(int[][] pieces){
        int x = 0,y = 0;; 
        boolean bandera ; 
        for (int[]i:pieces){
            bandera = true;
            for(int j:i){
                if (bandera){
                    y = j*20;
                    bandera = false;
                }else{
                    x = j*20;
                }               
            }
            for(int k=0;k<fichasJuego.size();k++){ 
                if((fichasJuego.get(k).getX()==width*20+(100+x)) && (fichasJuego.get(k).getY()==y)){
                    fichasJuego.get(k).makeInvisible();               
                    fichasJuego.remove(k);
                }
            }
        }
    }

    private String getColor(int x,int y){
        return game.getColor(x,y);
    }

    private boolean game(boolean juego){
        juego=itsOk;
        if (juego== false){
            return (true);
        } else{       
            return (false);
        }

    }

    private boolean board(boolean tablero){
        tablero = itsOk;
        if (tablero == true){
            return true;
        }else{
            return false;
        }
    }

    private void around(){
        int x = 0 , y = 0;
        for(int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i).getColor()=="blue"){ 
                x = fichasJuego.get(i).getX();
                y = fichasJuego.get(i).getY();
            }
            if(fichasJuego.get(i).getX() == x+20 && fichasJuego.get(i).getY() ==y-20 ){
                ur = true; 
                x1 = x+20;y1= y-20;   
                System.out.println(dl);
            }else if (fichasJuego.get(i).getX() == x-20 && fichasJuego.get(i).getY() ==y-20 ){
                ul = true;
                x1 = x-20;y1= y-20;                   
            }else if (fichasJuego.get(i).getX() == x+20 && fichasJuego.get(i).getY() ==y+20 ){
                dr = true;
                x1 = x+20;y1= y+20;
                System.out.println(x1+" "+y1);
            }else if (fichasJuego.get(i).getX() == x-20 && fichasJuego.get(i).getY() ==y+20 ){
                dl = true;
                x1 = x-20;y1= y+20;
            }          
        } 

    }   

    private void removeFichaJump(int row , int column){
        for(int i=0; i<fichasJuego.size();i++){   
            System.out.println(row+ " "+ column);
            System.out.println(fichasJuego.get(i).getX()+" "+fichasJuego.get(i).getY());
            if((fichasJuego.get(i).getX()==row) && (fichasJuego.get(i).getY()==column)){
                fichasJuego.get(i).makeInvisible();
                fichasJuego.remove(i);
            }
        }
    }

    private void removeFichas (int row , int column){
        for(int i=0; i<fichas.size();i++){   
            if((fichas.get(i).getX()==column) && (fichas.get(i).getY()==row)){
                fichas.get(i).makeInvisible();                    
                fichas.remove(i);
                fichasJuego.get(i).makeInvisible();
                fichasJuego.remove(i);
            }
        }
    }

    public void posicionFichas(){
        posiciones = new ArrayList<ArrayList<Integer>>();  
        System.out.println(fichasJuego.size()); 
        for(Ficha i:fichasJuego){
            ArrayList<Integer> posTabFicha = new ArrayList<Integer>();            
            for (int j = 0; j<posiciones.size();j++){
                posTabFicha.add(i.getX());
                posTabFicha.add(i.getY());
            }
            posiciones.add(posTabFicha);            
        }  
    }

    private void jumpDos(boolean top, boolean right){
        around();
        System.out.println(dr);
        for (int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i).getColor()=="blue"){
                if(top == true && right == false){
                    if(ul==true){
                        System.out.println(x1+" "+y1);
                        removeFichaJump(x1,y1);
                    }              
                    fichasJuego.get(i).jump(top,right);
                }
                else if(top==true && right == true){
                    if(ur==true){
                        System.out.println(x1+""+y1);
                        removeFichaJump(x1,y1);
                    }
                    fichasJuego.get(i).jump(top,right);
                }
                else if(top==false && right == false ){
                    if(dl==true){
                        System.out.println(x1+""+y1);
                        removeFichaJump(x1,y1);
                    }
                    fichasJuego.get(i).jump(top,right);
                }
                else if(top==false && right == true){
                    if(dr == true){
                        removeFichaJump(x1,y1);
                    }
                    fichasJuego.get(i).jump(top,right);
                }  
            }
        }
    }
    private void baseWrite(String[][]lineas,String cadena){
        for(int i = 0 ; i<width;i++){
            for(int j = 0;j<width; j++){
                if((i%2==0 && j%2!=0)||(i%2!=0 && j%2==0)){
                    lineas[i][j] = ".";
                }else{
                    lineas[i][j]= "-";}
            }            
        }
        for(Ficha k : fichas ){
            if(lineas[k.getY()/20][k.getX()/20]=="."){
                if(k.getColor() == "red"){
                    lineas[k.getY()/20][k.getX()/20]="b";
                }else if (k.getColor() == "pink"){
                    lineas[k.getY()/20][k.getX()/20]="B";
                }else if  (k.getColor() == "yellow"){
                    lineas[k.getY()/20][k.getX()/20]="w";
                }else if (k.getColor() == "orange"){
                    lineas[k.getY()/20][k.getX()/20]="W";}
            }
        }
    }
}
