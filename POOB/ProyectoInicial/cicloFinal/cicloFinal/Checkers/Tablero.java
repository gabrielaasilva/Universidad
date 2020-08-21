package Checkers;
import Shapes.*;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Tablero
{
    // instance variables - replace the example below with your own
    private boolean itsOk =true; 
    private String tipo;
    public  ArrayList<Ficha> fichas;
    public  ArrayList<Ficha> fichasJuego;
    private Ficha ficha;
    private int x,xPosition=0,yPosition= 0,contador,width;
    private ArrayList<ArrayList<Rectangle>> tablero;
    private HashMap<Integer,int[]> enumera;
    private String colores;
    private static boolean ul = false,ur=false,dl=false,dr=false;
    private int x1= 0 ,y1=0 ;
    private ArrayList<ArrayList<Integer>> posiciones;

    public Tablero(int width, boolean juego)
    {
        tablero = new ArrayList<>();
        String color = null;
        contador = 1;
        this.width = width;
        enumera = new HashMap<Integer, int[]>();
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
        fichas = new ArrayList<>();
        fichasJuego = new ArrayList<>();
    }

    /**
     * Retorna el HashMap requerido
     * @return HashMap
     */
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
     * Mueve el tablero de configuracion.
     * @param int x
     */
    public void moveTablero(int x){
        for(int i=0;i<tablero.size();i++){
            for(int j = 0;j<tablero.size();j++){
                tablero.get(i).get(j).moveHorizontal(x);                
            }
        }    
    }

    /**
     * Obtiene el color del cuadrado pedido.
     * @param int x
     * @param int y
     * @return String
     */
    public String getColor(int x, int y){
        return tablero.get(x).get(y).getColor();
    }

    /**
     * Calcula el color del cuadrado pedido.
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
                enumera.put(contador,vacio);
                contador++;
            }
        }
        else{
            if(tablero.get(i-1).get(j).getColor().equals("gray")){
                color = "black";            
                enumera.put(contador,vacio);
                contador++;
            }
            else{
                color = "gray";}                            
        }
        return color;
    }

    /**
     * Retorna el HashMap requerido
     * @return HashMap
     */
    public HashMap hash(){
        return enumera;
    }

    /**
     * Añade fichas de un jugador
     * @param boolean yellow
     * @param int[][] men
     */
    public void add(boolean jugadorUno,int [][] men,String type){
        addFichaConfi(jugadorUno,men,type);
        addFichaJuego(jugadorUno,men,type);
        makeVisibleF();

    }

    /**
     *  Hace visible las fichas 
     */
    public void makeVisibleF(){
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
                Ficha ficha = new Ficha(this,width*20+(100+x),y,"yellow",width,true);
                fichasJuego.add(ficha);    
            } else if(getColor(x/20,y/20) == "black" && jugadorUno == false && type == "normal"){
                Ficha ficha = new Ficha(this,width*20+(100+x),y,"red",width,false);
                fichasJuego.add(ficha); 

            }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "proletarian"){
                Ficha proletarian = new Proletarian(this,width*20+(100+x),y,"green",width,true);
                fichasJuego.add(proletarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "proletarian"){
                Ficha proletarian = new Proletarian(this,width*20+(100+x),y,"magenta",width,false);
                fichasJuego.add(proletarian);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "lazy"){
                Ficha proletarian = new Lazy(this,width*20+(100+x),y,"cyan",width,true);
                fichasJuego.add(proletarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "lazy"){
                Ficha proletarian = new Lazy(this,width*20+(100+x),y,"rosaBonito",width,false);
                fichasJuego.add(proletarian);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "powerful"){
                Ficha powerful = new Powerful(this,width*20+(100+x),y,"darkPink",width,true);
                fichasJuego.add(powerful);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "powerful"){
                Ficha powerful = new Powerful(this,width*20+(100+x),y,"white",width,false);
                fichasJuego.add(powerful);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "hurried"){
                Ficha hurried = new Hurried(this,width*20+(100+x),y,"darkRed",width,true);
                fichasJuego.add(hurried);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "hurried"){
                Ficha hurried = new Hurried(this,width*20+(100+x),y,"darkCyan",width,false);
                fichasJuego.add(hurried);}
            else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "libertarian"){
                Ficha  libertarian  = new Libertarian (this,width*20+(100+x),y,"darkGreen",width,true);
                fichasJuego.add(libertarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "libertarian"){
                Ficha  libertarian  = new Libertarian (this,width*20+(100+x),y,"darkOrange",width,false);
                fichasJuego.add(libertarian);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "god"){
                Ficha  god  = new God (this,width*20+(100+x),y,"lightGray",width,true);
                fichasJuego.add(god);
            }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "god"){
                Ficha  god  = new God (this,width*20+(100+x),y,"darkYellow",width,false);
                fichasJuego.add(god);
            }
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
            Ficha ficha = new Ficha(this,x,y,"yellow",width,true);
            fichas.add(ficha);    
        } else if(getColor(x/20,y/20) == "black" && jugadorUno == false && type == "normal"){
            Ficha ficha = new Ficha(this,x,y,"red",width,false);
            fichas.add(ficha); 
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "proletarian"){
            Ficha proletarian = new Proletarian(this,x,y,"green",width,true);
            fichas.add(proletarian);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "proletarian"){
            Ficha proletarian = new Proletarian(this,x,y,"magenta",width,false);
            fichas.add(proletarian);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "lazy"){
            Ficha lazy = new Lazy(this,x,y,"cyan",width,true);
            fichas.add(lazy);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "lazy"){
            Ficha lazy = new Lazy(this,x,y,"rosaBonito",width,false);
            fichas.add(lazy);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "powerful"){
            Ficha powerful = new Powerful(this,x,y,"darkPink",width,true);
            fichas.add(powerful);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "powerful"){
            Ficha powerful = new Powerful(this,x,y,"white",width,false);
            fichas.add(powerful);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "hurried"){
            Ficha hurried = new Hurried(this,x,y,"darkRed",width,true);
            fichas.add(hurried);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "hurried"){
            Ficha hurried = new Hurried(this,x,y,"darkCyan",width,false);
            fichas.add(hurried);}
        else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "libertarian"){
            Ficha libertarian = new Libertarian (this,x,y,"darkGreen",width,true);
            fichas.add(libertarian);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "libertarian"){
            Ficha  libertarian = new Libertarian (this,x,y,"darkOrange",width,false);
            fichas.add(libertarian);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == true && type == "god"){
            Ficha  god  = new God (this,x,y,"lightGray",width,true);
            fichas.add(god);
        }else if (getColor(x/20,y/20) == "black" && jugadorUno == false && type == "god"){
            Ficha  god  = new God (this,x,y,"darkYellow",width,false);
            fichas.add(god);
        }   
        else{
            JOptionPane.showMessageDialog(null,"Esta agregando a una casilla invalida intente de nuevo","ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**Selecciona la ficha requerida por el usuario
     * @param int row 
     * @param int column
     */
    public void select (int row, int column){

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
    }

    /**Permite mover diagonalmente la ficha seleccionada
     * @param boolean top
     * @param boolean right
     */
    public void shift(boolean top, boolean right){
        for(int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i).getColor()=="blue"){
                fichasJuego.get(i).move(top,right);
                if(fichasJuego.size()!=0){
                    if(colores.equals("yellow")){
                        fichasJuego.get(i).cambiarColor("yellow");
                    }else{           
                        fichasJuego.get(i).cambiarColor(colores);
                    }
                }
            }
        }              
    }

    /**
     * Salta fichas si hay otra alrededor
     * @param boolean top
     * @param boolean right
     */
    public void jump(boolean top, boolean right){
        for(int i=0;i<fichasJuego.size();i++){ 
            if(fichasJuego.get(i).isSelected()&&fichasJuego.get(i).hayFichaIntermedia(this,fichasJuego.get(i).getX(),fichasJuego.get(i).getY())&&fichasJuego.get(i).hayFichaFinal(this,fichasJuego.get(i).getX(),fichasJuego.get(i).getY())){ 
                fichasJuego.get(i).actionOnJump(this,top,right);
                removeGod();
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

    /*
     * Método para remover fichas en el método jump.
     * @param int row
     * @param int column
     */
    public void removeFichaJump(int row , int column){
        for(int i=0; i<fichasJuego.size();i++){

            if (fichasJuego.get(i).isCapturable() == false){

            }
            else if((fichasJuego.get(i).getX()==row) && (fichasJuego.get(i).getY()==column) ){  
                fichasJuego.get(i).makeInvisible();
                fichasJuego.remove(i);
            }            

        }
    }

    /**
     * Mueve la ficha donde el usuario lo requiera.
     * @param String notation
     */
    public void move(String notation){
        if (notation.contains("-")){
            String[] separa = notation.split("-");
            moveNormal(separa);
        }
        else{
            String[] separa = notation.split("x");
            moveRaro(separa);              
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

    /**
     * Añade un rey a cierto jugador
     * @param boolean yellow
     * @param boolean king
     * @param int row
     * @param int column
     */
    public void add(boolean jugadorUno,boolean king,int row, int column){
        int[][]men ={{row,column}};
        if (king == true){
            addFichaKingConfi(jugadorUno,column,row);
            addFichaKingJuego(jugadorUno,column,row);
            makeVisibleF();
        }else{
            add(jugadorUno,men,"normal");    
        }
    }

    /**
     * Remueve una ficha en especifico
     * @param int row
     * @param int column
     */
    public void remove(int row, int column){
        row = row *20;
        column = column*20;  
        removeFichas(row, column);
    }

    /*
     * Método base del método remove.
     * @param int row
     * @param int column
     */
    public void removeFichas (int row , int column){
        for(int i=0; i<fichas.size();i++){ 
            if(fichas.get(i).getX()==column && fichas.get(i).getY()==row){
                fichas.get(i).makeInvisible();                    
                fichas.remove(i);
                fichasJuego.get(i).makeInvisible();
                fichasJuego.remove(i);
            }
        }
    }

    /**
     * Remueve fichas
     * @param int[][] pieces
     */
    public void remove(int [][] pieces){
        removeBaseConfi(pieces);
        removeBaseJuego(pieces);
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
                    int entero1 = (numero1[0]-260)/20; int entero2 = ((numero1[1]/20));
                    select(entero2,entero1); 
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
            Ficha ficha = new Ficha(this,row,column,"orange",width,true);
            fichas.add(ficha);    
        } else if(getColor(row/20,column/20) == "black" && jugadorUno == false){
            Ficha ficha = new Ficha(this,row,column,"pink",width,false);
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
            Ficha ficha = new Ficha(this,width*20+(100+row),column,"orange",width,true); 
            fichasJuego.add(ficha);
        } else if (getColor(row/20,column/20) == "black"&& jugadorUno == false){
            Ficha ficha = new Ficha(this,width*20+(100+row),column,"pink",width,true); 
            fichasJuego.add(ficha);
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
                if(/**(!(fichas.get(k) instanceof Powerful)) && **/(fichas.get(k).getX()==x) && (fichas.get(k).getY()==y)){
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
                if(/**(!(fichas.get(k) instanceof Powerful)) && **/(fichasJuego.get(k).getX()==width*20+(100+x)) && (fichasJuego.get(k).getY()==y)){
                    fichasJuego.get(k).makeInvisible();               
                    fichasJuego.remove(k);
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

    public boolean hayUnaFicha(int x, int y){
        boolean val = false; 
        for (int i=0; i < fichasJuego.size(); i++){
            if (fichasJuego.get(i).getX() == x && fichasJuego.get(i).getY() == y){
                val = true;            
            }        
        }
        return val;
    }

    private void removeGod(){
        for (int i=0;i<fichasJuego.size();i++){
            if(fichasJuego.get(i).isGod()){
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

    public ArrayList<Ficha> getFichasJuego(){
        return fichasJuego;
    }
}