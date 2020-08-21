import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class CheckersContest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CheckersContest
{
    // instance variables - replace the example below with your own
    private int x;
    private Checkers damas;

    /**
     * Constructor for objects of class CheckersContest
     */
    public CheckersContest()
    {
        damas = new Checkers(8);

        x = 0;  
    }

    public String[] solve(char player, String[] moves){
        String[] cadena = new String[2];

        if (player == 'B'){
            confiBlack(moves);
        }
        else{
            confiWhite(moves);
        }
        cadena[0]=damas.write();
        cadena[1]= damas.write();
        return cadena;
    }

    public void simulate(char player, String[] moves,boolean slow){
        damas.swap();
        for (int i=0; i< moves.length; i++){  
            damas.move(moves[i]);

        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }

    private void confiBlack(String[] moves){
        int pares = 0;
        for(String i:moves){
            if(pares%2 ==0){
                if(i.contains("x")){
                    String[] separa = i.split("x");
                    for(int j = 0 ; j<separa.length;j++){
                        int entero1 = Integer.parseInt(separa[j]);

                        if(damas.getPosicionOcupada(entero1)=='\u0000'){
                            damas.add(false,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'b');
                        }
                        else if(damas.getPosicionOcupada(entero1)=='x' ||damas.getPosicionOcupada(entero1)=='b' || damas.getPosicionOcupada(entero1)=='w'){
                            System.out.println("no puede agregar");
                        }
                    }
                    pares+=1;
                }
                else{
                    String[] separa = i.split("-");
                    int posicion1 = Integer.parseInt(separa[0]);
                    int posicion2 = Integer.parseInt(separa[1]);
                    if(damas.getPosicionOcupada(posicion1)=='\u0000'){
                        damas.add(false,false,(damas.getPosicionEnumera(posicion1)[1])/20,(((damas.getPosicionEnumera(posicion1)[0])-280)/20)+1);
                        damas.modificaOcupada(posicion1, 'b');
                        damas.modificaOcupada(posicion2, 'x');                            
                    }
                    pares+=1;
                }
            }
            else{
                if(i.contains("x")){
                    String[] separa = i.split("x");
                    for(int j = 0 ; j<separa.length;j++){
                        int entero1 = Integer.parseInt(separa[j]);

                        if(damas.getPosicionOcupada(entero1)=='\u0000'){
                            damas.add(true,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'w');
                        }
                        else if(damas.getPosicionOcupada(entero1)=='x' ||damas.getPosicionOcupada(entero1)=='b' || damas.getPosicionOcupada(entero1)=='w'){
                            System.out.println("no puede agregar");
                        }
                    }
                    pares+=1;
                }
                else{
                    String[] separa = i.split("-");
                    int posicion1 = Integer.parseInt(separa[0]);
                    int posicion2 = Integer.parseInt(separa[1]);
                    if(damas.getPosicionOcupada(posicion1)=='\u0000'){
                        damas.add(true,false,(damas.getPosicionEnumera(posicion1)[1])/20,(((damas.getPosicionEnumera(posicion1)[0])-280)/20)+1);
                        damas.modificaOcupada(posicion1, 'w');
                        damas.modificaOcupada(posicion2, 'x');

                    }
                    pares+=1;
                }
            }
        }
    }

    private void confiWhite(String[] moves){
        int pares = 0;
        for(String i:moves){
            if(pares%2 ==0){
                if(i.contains("x")){
                    String[] separa = i.split("x");
                    for(int j = 0 ; j<separa.length;j++){
                        int entero1 = Integer.parseInt(separa[j]);

                        if(damas.getPosicionOcupada(entero1)=='\u0000'){
                            damas.add(true,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'w');
                        }
                        else if(damas.getPosicionOcupada(entero1)=='x' ||damas.getPosicionOcupada(entero1)=='b' || damas.getPosicionOcupada(entero1)=='w'){
                            System.out.println("no puede agregar");
                        }
                    }
                    pares+=1;
                }
                else{
                    String[] separa = i.split("-");
                    int posicion1 = Integer.parseInt(separa[0]);
                    int posicion2 = Integer.parseInt(separa[1]);
                    if(damas.getPosicionOcupada(posicion1)=='\u0000'){
                        damas.add(true,false,(damas.getPosicionEnumera(posicion1)[1])/20,(((damas.getPosicionEnumera(posicion1)[0])-280)/20)+1);
                        damas.modificaOcupada(posicion1, 'w');
                        damas.modificaOcupada(posicion2, 'x');                            
                    }
                    pares+=1;
                }
            }
            else{
                if(i.contains("x")){
                    String[] separa = i.split("x");
                    for(int j = 0 ; j<separa.length;j++){
                        int entero1 = Integer.parseInt(separa[j]);

                        if(damas.getPosicionOcupada(entero1)=='\u0000'){
                            damas.add(false,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'b');
                        }
                        else if(damas.getPosicionOcupada(entero1)=='x' ||damas.getPosicionOcupada(entero1)=='b' || damas.getPosicionOcupada(entero1)=='w'){
                            System.out.println("no puede agregar");
                        }
                    }
                    pares+=1;
                }
                else{
                    String[] separa = i.split("-");
                    int posicion1 = Integer.parseInt(separa[0]);
                    int posicion2 = Integer.parseInt(separa[1]);
                    if(damas.getPosicionOcupada(posicion1)=='\u0000'){
                        damas.add(false,false,(damas.getPosicionEnumera(posicion1)[1])/20,(((damas.getPosicionEnumera(posicion1)[0])-280)/20)+1);
                        damas.modificaOcupada(posicion1, 'b');
                        damas.modificaOcupada(posicion2, 'x');

                    }
                    pares+=1;
                }
            }
        }
    }
}
