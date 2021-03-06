package aplicacion;


import java.awt.Color;

/**
 * Estas c�lulas son de color rojo y deciden morir si hay alg�n elemento vivo a su derecha (oeste).
 */
public class Izquierdosa extends Celula{
    private int fila,columna;
    private AutomataCelular ac;
    /**
     * Constructor for objects of class Izquierdosa
     */
    public Izquierdosa(AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);       
        this.ac = ac;
        this.fila = fila;
        this.columna = columna;
        color = Color.red;
    }
    
    @Override
    public void decida(){
        super.decida();        
        for(int i=columna-1;i>-1;i--){
            if(ac.getElemento(fila,i)!=null && ac.getElemento(fila,i).isVivo()){
                estadoSiguiente = 'm';
            }
        }
    }
}
