package checkers;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckersTestC2
{
    @Test
    public void segunPSdeberiaEscribir()
    {
        // Arrange
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men,"normal");
        
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
        damas.add(false,men,"normal");
        damas.save("hola");
        assertEquals("-b-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.--.-.-.-..-.-.-.-",damas.recover("hola"));
    }

    @Test 
    public void segundPSdeberiaFallar()
    {
        fail();
    }

}
