package aplicacion;

public class Conway extends Celula
{
    private int fila, columna, contador,contadorNull;
    private AutomataCelular ac;

    public Conway(AutomataCelular ac,int fila, int columna)
    {
        super(ac,fila,columna);
        this.ac = ac;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public void decida(){
        super.decida();
        alrededor();
    }
    /*
     * Hace un chequeo para saber si una celula tiene celulas pr�ximas.
     */
    
    private void alrededor(){
        for (int f = 0 ; f<ac.getLongitud() ; f++){
            for(int c = 0; c<ac.getLongitud(); c++){
                if(ac.getElemento(f,c) !=null){
                    contador = 0;
                    if (c == 0 && f == 0){
                        if(ac.getElemento(f,c+1) != null) contador++;
                        if(ac.getElemento(f+1,c+1) != null)contador++;
                        if(ac.getElemento(f+1,c) != null)contador++;
                    }
                    else if(c == 0 && f == ac.getLongitud()-1){
                        if(ac.getElemento(f,c+1) != null) contador++;
                        if(ac.getElemento(f-1,c) != null)contador++;
                        if(ac.getElemento(f-1,c+1) != null)contador++;
                    }  
                    else if(c == ac.getLongitud()-1 && f == ac.getLongitud()-1){
                        if(ac.getElemento(f,c-1) != null)contador++;
                        if(ac.getElemento(f-1,c) != null)contador++;
                        if(ac.getElemento(f-1,c-1) != null)contador++;
                    }
                    else if(c == ac.getLongitud()-1 && f == 0){
                        if(ac.getElemento(f,c-1) != null)contador++;
                        if(ac.getElemento(f+1,c) != null)contador++;
                        if(ac.getElemento(f+1,c-1) != null)contador++; 
                    }
                    else if (f == 0 && c != 0){
                        if(ac.getElemento(f,c+1) != null) contador++;
                        if(ac.getElemento(f+1,c+1) != null)contador++;
                        if(ac.getElemento(f+1,c) != null)contador++;
                        if(ac.getElemento(f+1,c-1) != null)contador++; 
                        if(ac.getElemento(f,c-1) != null)contador++;
                    }
                    else if (c == 0 && f != 0){
                        if(ac.getElemento(f,c+1) != null) contador++;
                        if(ac.getElemento(f+1,c) != null)contador++;
                        if(ac.getElemento(f-1,c) != null)contador++;
                        if(ac.getElemento(f+1,c+1) != null)contador++;
                        if(ac.getElemento(f-1,c+1) != null)contador++;
                    }
                    else if (c != 0 && f == ac.getLongitud()-1){
                        if(ac.getElemento(f,c+1) != null) contador++;
                        if(ac.getElemento(f,c-1) != null)contador++;
                        if(ac.getElemento(f-1,c) != null)contador++;
                        if(ac.getElemento(f-1,c+1) != null)contador++;
                        if(ac.getElemento(f-1,c-1) != null)contador++;
                    }
                    else if(c == ac.getLongitud()-1 && f != 0){
                        if(ac.getElemento(f,c-1) != null)contador++;
                        if(ac.getElemento(f+1,c) != null)contador++;
                        if(ac.getElemento(f-1,c) != null)contador++;
                        if(ac.getElemento(f+1,c-1) != null)contador++; 
                        if(ac.getElemento(f-1,c-1) != null)contador++; 
                    }
                    else{                 
                        if(ac.getElemento(f,c+1) != null) contador++;
                        if(ac.getElemento(f,c-1) != null)contador++;
                        if(ac.getElemento(f+1,c) != null)contador++;
                        if(ac.getElemento(f-1,c) != null)contador++;
                        if(ac.getElemento(f+1,c+1) != null)contador++;
                        if(ac.getElemento(f+1,c-1) != null)contador++; 
                        if(ac.getElemento(f-1,c+1) != null)contador++;
                        if(ac.getElemento(f-1,c-1) != null)contador++;
                    }
                    if(contador == 3 && super.estadoActual =='m'){
                        super.estadoSiguiente = 'v';
                    }else if((contador ==1 ||contador>3) && super.estadoActual == 'v'){
                        super.estadoSiguiente = 'm';
                    }else if((contador ==1 ||contador>3) && super.estadoActual == 'm'){
                        super.estadoSiguiente = 'm';
                    }else if ((contador==2 || contador==3) && super.estadoActual == 'v'){
                        super.estadoSiguiente = 'v';
                    } 

                } 
                else if (ac.getElemento(c,f) == null){
                    contadorNull = 0 ;
                    if (c == 0 && f == 0){
                        if(ac.getElemento(f,c+1) != null) contadorNull++;
                        if(ac.getElemento(f+1,c+1) != null)contadorNull++;
                        if(ac.getElemento(f+1,c) != null)contadorNull++;
                    }
                    else if(c == 0 && f == ac.getLongitud()-1){
                        if(ac.getElemento(f,c+1) != null) contadorNull++;
                        if(ac.getElemento(f-1,c) != null)contadorNull++;
                        if(ac.getElemento(f-1,c+1) != null)contadorNull++;
                    }  
                    else if(c == ac.getLongitud()-1 && f == ac.getLongitud()-1){
                        if(ac.getElemento(f,c-1) != null)contadorNull++;
                        if(ac.getElemento(f-1,c) != null)contadorNull++;
                        if(ac.getElemento(f-1,c-1) != null)contadorNull++;
                    }
                    else if(c == ac.getLongitud()-1 && f == 0){
                        if(ac.getElemento(f,c-1) != null)contadorNull++;
                        if(ac.getElemento(f+1,c) != null)contadorNull++;
                        if(ac.getElemento(f+1,c-1) != null)contadorNull++; 
                    }
                    else if (f == 0 && c != 0){
                        if(ac.getElemento(f,c+1) != null) contadorNull++;
                        if(ac.getElemento(f+1,c+1) != null)contadorNull++;
                        if(ac.getElemento(f+1,c) != null)contadorNull++;
                        if(ac.getElemento(f+1,c-1) != null)contadorNull++; 
                        if(ac.getElemento(f,c-1) != null)contadorNull++;
                    }
                    else if (c == 0 && f != 0){
                        if(ac.getElemento(f,c+1) != null) contadorNull++;
                        if(ac.getElemento(f+1,c) != null)contadorNull++;
                        if(ac.getElemento(f-1,c) != null)contadorNull++;
                        if(ac.getElemento(f+1,c+1) != null)contadorNull++;
                        if(ac.getElemento(f-1,c+1) != null)contadorNull++;
                    }
                    else if (c != 0 && f == ac.getLongitud()-1){
                        if(ac.getElemento(f,c+1) != null) contadorNull++;
                        if(ac.getElemento(f,c-1) != null)contadorNull++;
                        if(ac.getElemento(f-1,c) != null)contadorNull++;
                        if(ac.getElemento(f-1,c+1) != null)contadorNull++;
                        if(ac.getElemento(f-1,c-1) != null)contadorNull++;
                    }
                    else if(c == ac.getLongitud()-1 && f != 0){
                        if(ac.getElemento(f,c-1) != null)contadorNull++;
                        if(ac.getElemento(f+1,c) != null)contadorNull++;
                        if(ac.getElemento(f-1,c) != null)contadorNull++;
                        if(ac.getElemento(f+1,c-1) != null)contadorNull++; 
                        if(ac.getElemento(f-1,c-1) != null)contadorNull++; 
                    }
                    else{      
                        if(ac.getElemento(f,c+1) != null) contadorNull++;
                        if(ac.getElemento(f,c-1) != null)contadorNull++;
                        if(ac.getElemento(f+1,c) != null)contadorNull++;
                        if(ac.getElemento(f-1,c) != null)contadorNull++;
                        if(ac.getElemento(f+1,c+1) != null)contadorNull++;
                        if(ac.getElemento(f+1,c-1) != null)contadorNull++; 
                        if(ac.getElemento(f-1,c+1) != null)contadorNull++;
                        if(ac.getElemento(f-1,c-1) != null)contadorNull++;
                        
                    }
                    if (contadorNull == 3){
                        Conway cell =  new Conway(ac,f,c);
                    }
                }
            }
        }        
    }
}

