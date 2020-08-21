package aplicacion;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AutomataCelularTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AutomataCelularTest
{
    /**
     * Default constructor for test class AutomataCelularTest
     */
    public AutomataCelularTest()
    {
    }
    
    public void deberiaHacerTicTac(){
        //Arrange
        AutomataCelular ac = new AutomataCelular();
        Celula indiana = new Celula(ac,1,1);
        
        //Act
        ac.ticTac();
        
        //Assert
        assertEquals(indiana.edad(),(int)1);
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
