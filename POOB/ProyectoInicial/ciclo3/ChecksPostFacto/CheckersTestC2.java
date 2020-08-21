
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckersTestC2
{

    @Test
    public void segunPSdeberiaAñadirFicha()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men);
        assertEquals(damas.ok(),true);
    }

    @Test
    public void segunPSdeberiaRemoverFicha()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men);
        damas.remove(0,1);
        assertEquals(damas.ok(),true);
    }

    @Test
    public void segunPSdeberiaSeleccionar()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men);
        damas.swap();
        damas.select(0,1);
        assertEquals(damas.ok(),true);       
    }
    
    @Test
    public void  segunPSdeberiaMoverse()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men);
        damas.swap();
        damas.shift(false,true);
        assertEquals(damas.ok(),true);
    }
    
    @Test
    public void segunPSdeberiaEscribir()
    {
        // Arrange
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men);
        
        // Act
        String representacion = damas.write();
        
        // Assert
        assertEquals("-b-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-",representacion);
    }
    
    @Test
    public void segunPSdeberiaRecordar()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men);
        damas.save("hola");
        assertEquals("-b-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-",damas.recover("hola"));
    }

    @Test 
    public void segundPSdeberiaFallar()
    {
        // TODO Dise
        fail();
    }

}
