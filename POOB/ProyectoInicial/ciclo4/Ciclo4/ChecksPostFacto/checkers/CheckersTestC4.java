package checkers;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckersTestC4
{
    @Test
    public void probandoQueProletarianFuncione()
    {
        // Arrange
        Checkers damas = new Checkers(8);
        int[][] proletarian = {{6,1}};
        damas.add(true,proletarian,"proletarian");

        // Act
        damas.swap();
        damas.select(6,1);
        damas.shift(false,true);

        // Assert
        assertEquals(damas.getFichasJuego().size(),0);
    }

    @Test
    public void probandoQueLazyFuncione(){
        // Arrange
        Checkers damas = new Checkers(8);
        int[][] lazy = {{0,1}};
        int[][] normales = {{1,2},{3,4}};
        damas.add(true,lazy,"lazy");
        damas.add(false,normales,"normal");

        // Act
        damas.swap();
        damas.move("1x10x19");

        // Assert
        assertEquals(damas.getFichasJuego().size(),2);
    }

    @Test
    public void probandoQueLibertarianFuncione(){
        // Arrange
        Checkers damas = new Checkers(8);
        int[][] libertarian = {{0,1}};
        int[][] normales = {{1,2},{3,4}};
        damas.add(true,libertarian,"libertarian");
        damas.add(false,normales,"normal");

        // Act
        damas.swap();
        damas.select(0,1);

        damas.jump(false,true);
        damas.select(2,3);
        damas.jump(false,true);

        // Assert
        assertEquals(damas.getFichasJuego().size(),3);
    }

    @Test
    public void probandoQuePowerfulFuncione(){
        // Arrange
        Checkers damas = new Checkers(8);
        int[][] powerful = {{1,2}};
        int[][] normales = {{0,1}};
        damas.add(true,powerful,"powerful");
        damas.add(false,normales,"normal");

        // Act
        damas.swap();
        damas.select(0,1);
        damas.jump(false,true);
        
        // Assert
        assertEquals(damas.getFichasJuego().size(),2);
    
    }
   
    @Test
    public void probandoQueHurriedFuncioneShift(){
        // Arrange
        Checkers damas = new Checkers(8);
        int[][] hurried = {{0,1}};
        damas.add(true,hurried,"hurried");


        // Act
        damas.swap();
        damas.select(0,1);
        damas.shift(false,true);
        Integer[] posicion = {damas.getFichasJuego().get(0).getX(),damas.getFichasJuego().get(0).getY()};
        Integer[] comprueba = {320,40};
        // Assert
        assertEquals(posicion,comprueba);    
    
    }
    
    @Test 
    public void probandoQueHurriedFuncionaJump(){
        // Arrange
        Checkers damas = new Checkers(8);
        int[][] hurried = {{0,1}};
        int[][] normales = {{1,2},{3,4}};
        damas.add(true,hurried,"hurried");
        damas.add(false,normales,"normal");

        // Act
        damas.swap();
        damas.select(0,1);
        damas.jump(false,true);
        Integer[] posicion = {damas.getFichasJuego().get(0).getX(),damas.getFichasJuego().get(0).getY()};
        Integer[] comprueba = {360,80};
        // Assert
        assertEquals(posicion,comprueba);  
    
    }
    
    @Test
    public void probandoqueGodFuncione(){
    
        // Arrange
        Checkers damas = new Checkers(8);
        int[][] god = {{0,1}};
        int[][] normales = {{1,2},{3,4}};
        damas.add(true,god,"god");
        damas.add(false,normales,"normal");

        // Act
        damas.swap();
        damas.select(0,1);
        damas.jump(false,true);

        // Assert
        assertEquals(damas.getFichasJuego().size(),1);  
    
    }
}
