package aplicacion;

import java.util.*;

public class AutomataCelular{
    static private int LONGITUD=20;
    private Elemento[][] automata;
    private int tiempo =0;
    private Celula indiana; Celula h007;
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
        indiana = new Celula(this,1,1);
        h007 = new Celula(this,2,2);
        }
        
    public void ticTac(){
        tiempo+=1;
        indiana.decida();
        indiana.cambie();
        h007.decida();
        h007.cambie();
        }

    }
