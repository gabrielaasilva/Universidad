package aplicacion;

import java.util.*;
import java.awt.Color;
public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;
    
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }

    public int  getLongitud(){
        return LONGITUD;
    }

    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }

    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    public void algunosElementos(){
        //Elemento indiana = new Celula(this,1,1);
        //Elemento OO7 = new Celula(this,2,2);
        //Elemento marx = new Izquierdosa(this,3,10);
        //Elemento hegel = new Izquierdosa(this,3,0);
        //Elemento noreste = new Barrera(this,0,18);
        //Elemento suroeste = new Barrera(this,19,0);
        //Elemento Ana = new NewCelula(this,4,9);
        //Elemento blue = new Celula(this,4,10);
        //Elemento blue2 = new Celula(this,4,11);
        //Elemento bacteria = new Bacteria(this,0,0);
        Elemento john = new Conway(this,5,1);
        Elemento horton = new Conway(this,5,2);
        Elemento pp = new Conway(this,0,1);
        Elemento ppp = new Conway(this,1,1);
        Elemento pppp= new Conway(this,1,0);
        Elemento ppppp= new Conway(this,0,0);
        Elemento barrera = new Barrera(this,19,0);
    }

    public void ticTac(){
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                if(automata[c][f] !=null){
                    automata[c][f].cambie();
                    automata[c][f].decida();                                        
                }
            }
        }
    }

}
