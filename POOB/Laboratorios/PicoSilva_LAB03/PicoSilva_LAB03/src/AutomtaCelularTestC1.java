package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AutomtaCelularTestC1.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AutomtaCelularTestC1
{
    /**
     * Default constructor for test class AutomtaCelularTestC1
     */
    public AutomtaCelularTestC1()
    {
    }

    @Test
    public void deberiaHacerTicTac(){
        //Arrange
        AutomataCelular ac = new AutomataCelular();
        Celula indiana = new Celula(ac,1,1);
        
        //Act
        ac.ticTac();
        
        //Assert
        assertEquals(indiana.edad(),(int)1);
    }
}
