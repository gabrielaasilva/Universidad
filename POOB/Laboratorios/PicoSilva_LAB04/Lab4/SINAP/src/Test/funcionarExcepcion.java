package Test; 

import aplicacion.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class funcionarExcepcion{

    @Test
    public void deberiaLanzarExcepcionSiNoTieneNombreInternacional(){
		Sinap sinap =new  Sinap();
        Area area = new Area("Tuparro","", "Vichada", "548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
		 
		try{
			int valor = sinap.numeroAreas();
		}catch(Exception e){
			assertEquals(SINAPExcepcion.NO_NOMBRE_INTERNACIONAL,e.getMessage());
			Registro.registre(e);
		}
    }
	
	@Test
	public void deberiaLanzarExcepcionSiElAreaEsRepetida(){
		Sinap sinap = new  Sinap();
		
		try{
			sinap.adicione("Tuparro","Tuparro National Park", "Vichada", "548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
			sinap.adicione("Tuparro","Tuparro National Park", "Vichada", "548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
		}catch(Exception e){
			assertEquals(SINAPExcepcion.AREA_REPETIDA,e.getMessage());
			Registro.registre(e);
			
		}
		
	}
	
	@Test
	public void deberiaLanzarExcepcionSiTodosSonVacios(){
		Sinap sinap = new Sinap();
		
		try{
			sinap.adicione("","","","","");
		}catch (Exception e){
			assertEquals(SINAPExcepcion.ESPACIOS_VACIOS,e.getMessage());
			Registro.registre(e);
		}
	}
	
	@Test
	public void deberiaBuscar() throws SINAPExcepcion{
		Sinap sinap = new Sinap();		
		try{
			Area area = new Area("Tuparro","Tuparro National Park", "Vichada", "548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeños caños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocas cristalinas en forma de cerros redondeados.");
			sinap.adicioneDetalles(area);
			assertTrue(sinap.busque("T").contains(area));
		}catch(Exception e){
			throw e;
		}
		
		
		
	}
	
}