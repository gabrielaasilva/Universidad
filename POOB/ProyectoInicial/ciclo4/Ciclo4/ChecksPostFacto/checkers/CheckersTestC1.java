package checkers;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckersTestC1
{

    @Test
    public void segunPSdeberiaAñadirFicha()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men,"normal");
        assertEquals(damas.ok(),true);
    }

    @Test
    public void segunPSdeberiaRemoverFicha()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men,"normal");
        damas.remove(0,1);
        assertEquals(damas.ok(),true);
    }

    @Test
    public void segunPSdeberiaSeleccionar()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men,"normal");
        damas.swap();
        damas.select(0,1);
        assertEquals(damas.ok(),true);       
    }
    
    @Test
    public void  segunPSdeberiaMoverse()
    {
        Checkers damas = new Checkers(8);
        int [][] men = {{0,1}};
        damas.add(false,men,"normal");
        damas.swap();
        damas.shift(false,true);
        assertEquals(damas.ok(),true);
    }
    
        @Test 
    public void segundPSdeberiaFallar()
    {
        fail();
    }
}