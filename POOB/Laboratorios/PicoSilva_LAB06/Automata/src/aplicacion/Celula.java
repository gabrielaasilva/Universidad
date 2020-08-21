package aplicacion;

import java.awt.Color;

/**Informacion sobre una c�lula<br>
<b>(COLOR,automata,fila,columna,estadoActual,estadoSigiente)</b><br>
x.<br>
Todas las c�lulas son de color azul<br>
Los posibles estados de una c�lula son tres: viva, muerta o latente<br>
 */
public class Celula implements Elemento{

    private final static char VIVA='v', MUERTA='m';
    private AutomataCelular automata;
    private int fila,columna;
    protected char estadoActual,estadoSiguiente;
    protected Color color;
    private int edad;

    /**Crea una c�lula, viva o latente, en la posici�n (<b>fila,columna</b>) del aut�mta <b>ac</b>.Toda nueva c�lula va a estar viva en el estado siguiente.
    @param ac automata celular en el que se va a ubicar la nueva c�lula
    @param fila fila en el automata celular
    @param columna columna en el automata celula
     */
    public Celula(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        estadoActual=' ';
        estadoSiguiente=VIVA;
        edad=0;
        automata.setElemento(fila,columna,(Elemento)this);  
        color =Color.blue;
    }
    /**Retorna la fila del automata en que se encuentra 
    @return 
     */

    public final int getFila(){
        return fila;
    }

    /**Retorna la columna del automata en que se encuentra
    @return 
     */
    public final int getColumma(){
        return columna;
    }

    /**Retorna el color de  la c�lula
    @return 
     */
    public final Color getColor(){
        return color;
    }

    /**Retorna si est� viva
    @return v
     */
    public final boolean isVivo(){
        return (estadoActual == VIVA) ;
    }

    /**Retorna la edad de la c�lula
    @return 
     */
    public final int edad(){
        return (edad) ;
    }

    /**Decide cual va a ser su  siguiente estado 
     */
    public void decida(){
        if (edad>=2){
            estadoSiguiente=MUERTA;
        }
        else{
            estadoSiguiente = VIVA;
        }
    }

    /**Actualiza su estado actual considerando lo definido como siguiente estado
     */
    public final void cambie(){
        edad++;
        estadoActual=estadoSiguiente;
    }

}
