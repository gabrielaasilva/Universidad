package checkers;

import shapes.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.HashMap;
import java.util.Iterator;

public class Checkers 
{
    private Tablero config;
    private Tablero game;
    private ArrayList<Ficha> fichas;
    private ArrayList<Ficha> fichasJuego;
    private ArrayList<ArrayList<Integer>> posiciones;
    private HashMap<String,String> dic;
    private static  HashMap<Integer,int[]> enumera;
    private static  HashMap<Integer,Character> ocupada;
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
        config = new Tablero(width,true);
        game = new Tablero(width,false);
        game.move(width*20+100);
        enumera = game.getHashMap();
        config.makeVisible();
        game.makeVisible();
        fichas = new ArrayList<>();
        fichasJuego = new ArrayList<>();
        dic = new HashMap<String,String>();
        ocupada = new HashMap<Integer,Character>();
        this.width = width;
        llenarOcupado();
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
                    if(fichasJuego.get(i) instanceof Hurried){
                        fichasJuego.get(i).move(top,right);
                        fichasJuego.get(i).move(top,right);
                    }else{
                        fichasJuego.get(i).move(top,right);
                        compruebaProletarian();
                    }
                    if(fichasJuego.size()!=0){
                        if(colores.equals("yellow")){
                            fichasJuego.get(i).cambiarColor("yellow");
                        }else{           
                            fichasJuego.get(i).cambiarColor(colores);
                        }
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
                    if(fichasJuego.get(i) instanceof Libertarian){
                        jumpDos(top, right,true); 
                    }                    
                    else if(fichasJuego.get(i) instanceof Hurried){
                        jumpDos(top, right,false); 
                        jumpDos(top, right,false); 
                    }
                    else{   

                        System.out.println("Las longitud de fichas :"+fichasJuego.size());
                        jumpDos(top, right,false);   
                        System.out.println("Las longitud de fichas :"+fichasJuego.size());
                        removeGod();

                    }
                }
                if(colores.equals("yellow")){
                    fichasJuego.get(0).cambiarColor("yellow");
                    break;
                }else{           
                    fichasJuego.get(0).cambiarColor(colores);
                    break;
                }    
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Esta en configuracion por lo que no puede mover fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }   

    /**
     * @parama String notation
     */
    public void move(String notation){
        tipo = "juego";
        if(itsOk==false){ 
            if (notation.contains("-")){
                String[] separa = notation.split("-");
                moveNormal(separa);
                compruebaProletarian();
            }
            else{
                String[] separa = notation.split("x");
                compruebaLazy(separa);
                compruebaProletarian();               
            }
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
            if (king == true){
                addFichaKingConfi(jugadorUno,column,row);
                addFichaKingJuego(jugadorUno,column,row);
                makeVisible();
            }else{
                add(jugadorUno,men,"normal");    
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
    public void add(boolean jugadorUno,int [][] men,String type){
        tipo = "configuracion";
        if(itsOk==true){ 
            addFichaConfi(jugadorUno,men,type);
            addFichaJuego(jugadorUno,men,type);
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
     * Ajusta la posicion de la ficha  dependiendo de su  color que y la convierte en rey de un distinto color en el tablero de configuracion
     * @param yellow
     * @param row
     * @param column
     */
    private void addFichaKingConfi(boolean jugadorUno , int row, int column){
        Ficha rey;
        row = row *20;
        column = column*20;
        if (getColor(row/20,column/20) == "black" && jugadorUno == true){
            Ficha ficha = new Ficha(row,column,"orange",width,true);
            fichas.add(ficha);    
        } else if(getColor(row/20,column/20) == "black" && jugadorUno == false){
            Ficha ficha = new Ficha(row,column,"pink",width,false);
            fichas.add(ficha); 
        }else{
            JOptionPane.showMessageDialog(null,"Esta agregando a una casilla invalida intente de nuevo","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * Ajusta la posicion de la ficha  dependiendo de su  color que y la convierte en rey de un distinto color en el tablero de juego
     * @param boolean jugadorUno
     * @param int row
     * @param int column
     */
    private void addFichaKingJuego(boolean jugadorUno  , int row , int column){
        Ficha rey;
        row = row*20;
        column = column * 20;
        if (getColor(row/20,column/20) == "black" && jugadorUno == true){
            Ficha ficha = new Ficha(width*20+(100+row),column,"orange",width,true); 
            fichasJuego.add(ficha);
        } else if (getColor(row/20,column/20) == "black"&& jugadorUno == false){
            Ficha ficha = new Ficha(width*20+(100+row),column,"pink",width,true); 
            fichasJuego.add(ficha);
        }
    }

    /*
     * añade fichas al tablero de configuracion
     * @param boolean jugadorUno
     * @param int[][] men
     * @param String type
     */
    private void addFichaConfi(boolean jugadorUno,int [][] men,String type){
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
            addFichaConfiColor(x,y,jugadorUno,type);
        }
    }

    /*
     * Dependiendo del booleano del color se le asignara este
     * @param x
     * @param y
     * @param yellow
     */
    private void addFichaConfiColor(int x,int y,boolean jugadorUno,String type){
        if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "normal"){
            Ficha ficha = new Ficha(x,y,"yellow",width,true);
            fichas.add(ficha);    
        } else if(getColor(x/20,y/20) == "black" && jugadorUno == false && type == "normal"){
            Ficha ficha = new Ficha(x,y,"red",width,false);
            fichas.add(ficha); 
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "proletarian"){
            Proletarian proletarian = new Proletarian(x,y,"green",width,true);
            fichas.add(proletarian);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "proletarian"){
            Proletarian proletarian = new Proletarian(x,y,"magenta",width,false);
            fichas.add(proletarian);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "lazy"){
            Lazy lazy = new Lazy(x,y,"cyan",width,true);
            fichas.add(lazy);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "lazy"){
            Lazy lazy = new Lazy(x,y,"pink",width,false);
            fichas.add(lazy);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "powerful"){
            Powerful powerful = new Powerful(x,y,"darkPink",width,true);
            fichas.add(powerful);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "powerful"){
            Powerful powerful = new Powerful(x,y,"white",width,false);
            fichas.add(powerful);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "hurried"){
            Hurried hurried = new Hurried(x,y,"darkRed",width,true);
            fichas.add(hurried);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "hurried"){
            Hurried hurried = new Hurried(x,y,"darkCyan",width,false);
            fichas.add(hurried);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "libertarian"){
            Libertarian libertarian = new Libertarian (x,y,"darkGreen",width,true);
            fichas.add(libertarian);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "libertarian"){
            Libertarian  libertarian = new Libertarian (x,y,"darkOrange",width,false);
            fichas.add(libertarian);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "god"){
            God  god  = new God (x,y,"lightGray",width,true);
            fichas.add(god);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "god"){
            God  god  = new God (x,y,"darkYellow",width,false);
            fichas.add(god);
        }   
        else{
            JOptionPane.showMessageDialog(null,"Esta agregando a una casilla invalida intente de nuevo","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     * añade fichas al tablero de juego
     * @param boolean jugadorUno
     * @param int [][] men
     * @param String type
     */
    private void addFichaJuego(boolean jugadorUno ,int [][] men, String type){
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
            if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "normal"){
                Ficha ficha = new Ficha(width*20+(100+x),y,"yellow",width,true);
                fichasJuego.add(ficha);    
            } else if(getColor(x/20,y/20) == "black" && jugadorUno == false && type == "normal"){
                Ficha ficha = new Ficha(width*20+(100+x),y,"red",width,false);
                fichasJuego.add(ficha); 
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "proletarian"){
                Proletarian proletarian = new Proletarian(width*20+(100+x),y,"green",width,true);
                fichasJuego.add(proletarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "proletarian"){
                Proletarian proletarian = new Proletarian(width*20+(100+x),y,"magenta",width,false);
                fichasJuego.add(proletarian);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "lazy"){
                Lazy proletarian = new Lazy(width*20+(100+x),y,"cyan",width,true);
                fichasJuego.add(proletarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "lazy"){
                Lazy proletarian = new Lazy(width*20+(100+x),y,"pink",width,false);
                fichasJuego.add(proletarian);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "powerful"){
                Powerful powerful = new Powerful(width*20+(100+x),y,"darkPink",width,true);
                fichasJuego.add(powerful);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "powerful"){
                Powerful powerful = new Powerful(width*20+(100+x),y,"white",width,false);
                fichasJuego.add(powerful);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "hurried"){
                Hurried hurried = new Hurried(width*20+(100+x),y,"darkRed",width,true);
                fichasJuego.add(hurried);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "hurried"){
                Hurried hurried = new Hurried(width*20+(100+x),y,"darkCyan",width,false);
                fichasJuego.add(hurried);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "libertarian"){
                Libertarian  libertarian  = new Libertarian (width*20+(100+x),y,"darkGreen",width,true);
                fichasJuego.add(libertarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "libertarian"){
                Libertarian  libertarian  = new Libertarian (width*20+(100+x),y,"darkOrange",width,false);
                fichasJuego.add(libertarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "god"){
                God  god  = new God (width*20+(100+x),y,"lightGray",width,true);
                fichasJuego.add(god);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "god"){
                God  god  = new God (width*20+(100+x),y,"darkYellow",width,false);
                fichasJuego.add(god);
            }
        }
    }

    /*
     * Remueve fichas de confi
     * @param pieces
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
                if((!(fichas.get(k) instanceof Powerful)) && (fichas.get(k).getX()==x) && (fichas.get(k).getY()==y)){
                    fichas.get(k).makeInvisible();               
                    fichas.remove(k);
                }
            }
        }
    }

    /*
     * Método base para remover fichas del tablero de juego
     * @param pieces
     */
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
                if((!(fichas.get(k) instanceof Powerful)) && (fichasJuego.get(k).getX()==width*20+(100+x)) && (fichasJuego.get(k).getY()==y)){
                    fichasJuego.get(k).makeInvisible();               
                    fichasJuego.remove(k);
                }
            }
        }
    }

    /*
     * Método base para conocer el color de los cuadrados habilitados para añadir fichas.
     * @param int x
     * @param int y
     */
    private String getColor(int x,int y){
        return game.getColor(x,y);
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

    /*
     * Método para saber si hay fichas alrededor de otra.
     */
    private void around(){
        int x = 0 , y = 0,iazul=0;
        for(int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i).getColor()=="blue"){ 
                x = fichasJuego.get(i).getX();
                y = fichasJuego.get(i).getY();
                iazul=i;
                Ficha temp=fichasJuego.get(i);
                fichasJuego.remove(i);
                fichasJuego.add(0, temp);
            }
        }
        for(int i=0;i<fichasJuego.size();i++){

            if(fichasJuego.get(i).getX() == x+20 && fichasJuego.get(i).getY() ==y-20 ){
                ur  = true; 
                x1 = x+20;y1= y-20;   
            }else if (fichasJuego.get(i).getX() == x-20 && fichasJuego.get(i).getY() ==y-20 ){
                ul = true;
                x1 = x-20;y1= y-20;                   
            }else if (fichasJuego.get(i).getX() == x+20 && fichasJuego.get(i).getY() ==y+20 ){
                dr = true;
                x1 = x+20;y1= y+20;
            }else if (fichasJuego.get(i).getX() == x-20 && fichasJuego.get(i).getY() ==y+20 ){
                dl= true;
                x1 = x-20;y1= y+20;
            }
        } 

    }   

    /*
     * Método para remover fichas en el método jump.
     * @param int row
     * @param int column
     */
    private void removeFichaJump(int row , int column){
        for(int i=0; i<fichasJuego.size();i++){   
            if((!(fichas.get(i) instanceof Powerful))&&(fichasJuego.get(i).getX()==row) && (fichasJuego.get(i).getY()==column)){
                fichasJuego.get(i).makeInvisible();
                fichasJuego.remove(i);
            }
        }
    }

    /*
     * Método base del método remove.
     * @param int row
     * @param int column
     */
    private void removeFichas (int row , int column){
        for(int i=0; i<fichas.size();i++){ 
            if((!(fichas.get(i)  instanceof Powerful)) && (fichas.get(i).getX()==column) && (fichas.get(i).getY()==row)){
                fichas.get(i).makeInvisible();                    
                fichas.remove(i);
                fichasJuego.get(i).makeInvisible();
                fichasJuego.remove(i);
            }
        }
    }

    public void posicionFichas(){
        posiciones = new ArrayList<ArrayList<Integer>>();  
        for(Ficha i:fichasJuego){
            ArrayList<Integer> posTabFicha = new ArrayList<Integer>();            
            for (int j = 0; j<posiciones.size();j++){
                posTabFicha.add(i.getX());
                posTabFicha.add(i.getY());
            }
            posiciones.add(posTabFicha);            
        }  
    }

    /*
     * Método base del método jump.
     * @param boolean top
     * @param boolean right
     * @param boolean liber
     */
    private void jumpDos(boolean top, boolean right,boolean liber){
        around();
        for (int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i).getColor()=="blue"){
                if(top == true && right == false){
                    if(ul==true){
                        if(liber==false){
                            removeFichaJump(x1,y1);                        
                            ul=false;
                        }              
                        fichasJuego.get(i).jump(top,right);
                    }
                }else if(top==true && right == true){
                    if(ur==true){
                        if(liber==false){
                            removeFichaJump(x1,y1);                                               
                            ur=false;
                        }
                        fichasJuego.get(i).jump(top,right);
                    }
                }else if(top==false && right == false ){
                    if(dl==true){
                        if(liber==false){
                            removeFichaJump(x1,y1);                         
                            dl=false;
                        }
                        fichasJuego.get(i).jump(top,right);
                    }
                }else if(top==false && right == true){
                    if(dr == true){
                        if(liber==false){
                            removeFichaJump(x1,y1);                        
                            dr=false;
                        }
                        fichasJuego.get(i).jump(top,right);
                    }
                }    
            }
        }
    }

    /*
     * Método base del método write.
     * @param String [][] lineas
     * @param String cadena
     */
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

    /*
     * Método base del método move.
     * @param string[] separa
     */
    private void moveNormal(String[] separa){
        int[] numero1 = new int[2];
        numero1 = enumera.get(Integer.parseInt(separa[0]));
        int[] numero2 = new int[2];
        numero2 = enumera.get(Integer.parseInt(separa[1]));
        for(int i=0; i<fichasJuego.size();i++){
            if(fichasJuego.get(i).getX()==numero1[0] && fichasJuego.get(i).getY() == numero1[1]){             
                fichasJuego.get(i).diagonal(numero2[0]-numero1[0],numero2[1]-numero1[1]);                               
            }
        } 
    }

    /*
     * Método base del método move.
     * @param string[] separa
     */
    private void moveRaro(String[] separa){
        ArrayList<String> p = new ArrayList<String>();
        for(String j:separa){
            p.add(j);
        }
        for(int i =0 ; i<p.size()-1;i++){
            int[] numero1 = new int[2];
            numero1 = enumera.get(Integer.parseInt(separa[i]));
            int[] numero2 = new int[2];
            numero2 = enumera.get(Integer.parseInt(separa[i+1]));
            for(int k=0;k<fichasJuego.size();k++){
                if(fichasJuego.get(k).getX()==numero1[0] && fichasJuego.get(k).getY() == numero1[1]){
                    int entero1 = (numero1[0]-280)/20; int entero2 = ((numero1[1]/20)+1);
                    select(entero1,entero2); 
                    if (numero2[0]-numero1[0]>0 && numero2[1]-numero1[1]>0){
                        jump(false,true);
                    }else if(numero2[0]-numero1[0]<0 && numero2[1]-numero1[1]>0){
                        jump(false,false);
                    }else if (numero2[0]-numero1[0]<0 && numero2[1]-numero1[1]<0){
                        jump(true,false);
                    }else if(numero2[0]-numero1[0]>0 && numero2[1]-numero1[1]<0){
                        jump(true,true);
                    }                  
                }
            } 
        }
    }

    /*
     * Método comprobacion ficha.
     */
    private void compruebaProletarian(){
        for(int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i) instanceof Proletarian) {
                if(fichasJuego.get(i).getJugador() == true && (fichasJuego.get(i).getY())/20==width-1){
                    fichasJuego.get(i).makeInvisible();
                    fichasJuego.remove(i);
                } else if(fichasJuego.get(i).getJugador()==false && (fichasJuego.get(i).getY())/20==0){
                    fichasJuego.get(i).makeInvisible();
                    fichasJuego.remove(i);
                }
            }
        }
    }

    /*
     * Método comprobacion ficha.
     */
    private void removeGod(){
        for (int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i) instanceof God){
                if(fichasJuego.get(i).getJugador() == true){
                    for (int j=0;j<fichasJuego.size();j++){
                        if(fichasJuego.get(j).getJugador() == false){
                            fichasJuego.get(j).makeInvisible();
                            fichasJuego.remove(j);
                            break;
                        }
                    }
                }else{
                    for (int k=0;k<fichasJuego.size();k++){
                        if(fichasJuego.get(k).getJugador() == true){
                            fichasJuego.get(k).makeInvisible();
                            break;
                        }
                    }                        
                }
            }
            break;
        }
    }

    /*
     * Método comprobacion ficha.
     * @param string[] separa
     */
    private void compruebaLazy(String[] separa){
        String[] separa2 = new String[2];
        for(int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i) instanceof Lazy) {
                separa2[0]=separa[0];
                separa2[1]=separa[1];     
                moveRaro(separa2);    
                break;
            }else{
                moveRaro(separa);            
            }
        }
    }

    public Integer recorrerHashMap(){
        int maximo = 0;
        for(Integer key : enumera.keySet()){
            if(key>maximo){
                maximo=key;
            }
        }
        return maximo;
    }

    public void llenarOcupado(){

        for (int i = 1; i<=recorrerHashMap();i++){
            ocupada.put(i,'\u0000');
        }

    }

    private void agregarWrite(){
        String hola = write();
    }

    public int[] getPosicionEnumera(int key){
        return enumera.get(key);
    } 

    public char getPosicionOcupada(int key){
        return ocupada.get(key);
    } 

    public void modificaOcupada(int key , char value){
        ocupada.replace(key,value);
    } 

    public HashMap ocupada(){
        return ocupada;
    }

    public ArrayList<Ficha> getFichasJuego(){
        return fichasJuego;
    }
}

