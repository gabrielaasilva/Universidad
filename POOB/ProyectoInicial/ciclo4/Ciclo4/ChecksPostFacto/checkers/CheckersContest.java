
package checkers;
import java.util.HashMap;
import java.util.ArrayList;
public class CheckersContest
{
    private Checkers damas;
    public CheckersContest()
    {
        damas = new Checkers(8);
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
        damas.ocupada();
        return cadena;
    }

    public void simulate(char player, String[] moves,boolean slow){
        damas.swap();
        for (int i=0; i< moves.length; i++){  
            damas.move(moves[i]);
        }
    }

    private void confiBlack(String[] moves){
        int pares = 0;
        for(String i:moves){
            if(pares%2 ==0){
                if(i.contains("x")){
                    String[] separa = i.split("x");
                    for(int j = 0 ; j<separa.length;j++){
                        int entero1 = Integer.parseInt(separa[j]);
                        if (j==0){
                            damas.add(false,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'b');
                        }else{
                            damas.modificaOcupada(entero1, 'x');
                            diagonalNegra(separa);
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
                        if (j==0){
                            damas.add(true,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'w');
                        }else{
                            damas.modificaOcupada(entero1, 'x');
                            diagonalBlanca(separa);
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
                        if (j==0){
                            damas.add(true,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'w');
                        }else{
                            damas.modificaOcupada(entero1, 'x');
                            diagonalBlanca(separa);
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
                        if (j==0){
                            damas.add(false,false,((damas.getPosicionEnumera(entero1)[1])/20),(((damas.getPosicionEnumera(entero1)[0])-280)/20)+1);
                            damas.modificaOcupada(entero1, 'b');
                        }else{
                            damas.modificaOcupada(entero1, 'x');
                            diagonalNegra(separa);
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

    public void diagonalBlanca(String[] numeros){
        int posicionx = 0;
        int posiciony = 0;
        for (int i = 0 ; i<(numeros.length)-1;i++){
            if(Integer.parseInt(numeros[i+1])>Integer.parseInt(numeros[i])){
                int resultadox = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[0] -damas.getPosicionEnumera(Integer.parseInt(numeros[i]))[0];  
                int resultadoy =  damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[1] -damas.getPosicionEnumera(Integer.parseInt(numeros[i]))[1];
                if (resultadox > 0){
                    posicionx = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[0] - 20;
                    posiciony = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[1] - 20;
                    if(damas.getPosicionOcupada(numero(posicionx,posiciony)) != 'x'){
                        damas.add(false,false,posiciony/20,((posicionx-280)/20)+1);
                        damas.modificaOcupada(numero(posicionx,posiciony),'b');
                    }
                }else{
                    posicionx = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[0] + 20;
                    posiciony = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[1] - 20;
                    if(damas.getPosicionOcupada(numero(posicionx,posiciony)) != 'x'){
                        damas.add(false,false,posiciony/20,((posicionx-280)/20)+1);
                        damas.modificaOcupada(numero(posicionx,posiciony),'b');
                    }
                }
            }           
        }
    }

    public void diagonalNegra(String[] numeros){
        int posicionx = 0;
        int posiciony = 0;
        for (int i = 0 ; i<(numeros.length)-1;i++){
            if(Integer.parseInt(numeros[i+1])<Integer.parseInt(numeros[i])){
                int resultadox = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[0] -damas.getPosicionEnumera(Integer.parseInt(numeros[i]))[0];  
                int resultadoy =  damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[1] -damas.getPosicionEnumera(Integer.parseInt(numeros[i]))[1];
                if (resultadox > 0){                    
                    posicionx = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[0] - 20;
                    posiciony = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[1] + 20;                
                    if(damas.getPosicionOcupada(numero(posicionx,posiciony)) != 'x'){
                        damas.add(true,false,posiciony/20,((posicionx-280)/20)+1);
                        damas.modificaOcupada(numero(posicionx,posiciony),'w');
                    }
                }else{
                    posicionx = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[0] + 20;
                    posiciony = damas.getPosicionEnumera(Integer.parseInt(numeros[i+1]))[1] + 20;
                    if(damas.getPosicionOcupada(numero(posicionx,posiciony)) != 'x'){
                        damas.add(true,false,posiciony/20,((posicionx-280)/20)+1);
                        damas.modificaOcupada(numero(posicionx,posiciony),'w');
                    }
                }
            }
        }
    }

    public int numero(int x , int y){
        int[] posicion = new int[2];
        posicion[0] = x;
        posicion[1] = y;
        int numero = 0;
        for(int i = 1; i <= 32;i++){
            if(damas.getPosicionEnumera(i)[0] == posicion[0] && damas.getPosicionEnumera(i)[1] == posicion[1]){
                numero = i;
            }
        }
        return numero;
    }
}
