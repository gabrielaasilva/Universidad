
import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();

    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        personas= new ArrayList<Persona>();
        for (int i=0; i< nombres.length;i++){
            personas.add(new Persona(nombres[i]));
        }    
    }

    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
        int valor = 0;
        if(personas.size()==0){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }else{
           for (int i=0; i< personas.size();i++){
                try{
                    valor += personas.get(i).valorHora();
                } catch(EquipoExcepcion e){
                    throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);
                }
            }
           return valor;
        }
    }

    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor estimado de una persona a la que no se conoce su valor es la
     * media de los valores conocidos
     * Más del 75% del equipo debe tener valores conocidos 
     * @return el valor hora del equipo
     * @throws EquipoException si en el equipo hay una persona desconocida
     * o si no es posible calular el valor estimado
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int valorEstimado = 0;
        int cont = 0;
        for (int i=0; i< personas.size();i++){
            try{
                valorEstimado += personas.get(i).valorHora();
                cont+=1;
            }catch(EquipoExcepcion e){
                valorEstimado += (valorEstimado/cont);
                throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);
            }
        }
        if(personas.size()*0.75>=cont){
            throw new EquipoExcepcion(EquipoExcepcion.VALOR_DESCONOCIDO);            
        }
        return valorEstimado ;
    }      
}
