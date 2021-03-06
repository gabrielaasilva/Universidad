package aplicacion;

import java.awt.Color;
/**
 * Nuestro nuevo tipo de célula será de color verde, la función que realizará será que muera si tiene vecinos a su lado izquierdo. (Este) 
 */
public class NewCelula extends Celula
{
    private int fila, columna;
    private AutomataCelular ac;

    public NewCelula(AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        this.ac = ac;
        this.fila = fila;
        this.columna = columna;
        color = Color.green;
    }

    @Override
    public void decida(){
        super.decida();
        for(int i=0;i<columna;i++){
            if(ac.getElemento(fila,i)!=null && ac.getElemento(fila,i).isVivo()){
                estadoSiguiente = 'm';
            }
        }
    }

}
