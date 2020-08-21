package Test; 

import aplicacion.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class adicionarTest{

    @Test
    public void deberiaAdiciona(){
        //Arrange
		Sinap sinap =new  Sinap();
        Area area = new Area("Tuparro", "Tuparro National Park", "Vichada", "548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
         
        //Act
        sinap.adicioneDetalles(area);

        //Assert
        assertEquals(sinap.numeroAreas(),1);
    }
}