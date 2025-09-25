

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 *Escenarios de prueba 
 * 1 - Edad entre los límites - se modifica
 * 2 - Edad por debajo del limite inferior - excepcion
 * 3 - Edad por encima del limite superior - excepcion
 * 4 - Edad en limite inferior - excepcion
 * 5 - Edad en limite superior - excepcion
 */

public class PersonTest
{
    @Test
    public void setBetweenLimitNameTest(){
        Person p1 = new Person(8);
        assertEquals(8,p1.getAge());
        //assertEquals(VALOR_ESPERADO, VALOR OBTENIDO)
    }
    
    @Test
    public void setunderLimitNameTest(){
        
    }
     @Test
    public void setOnLimitNameTest(){
        
    }
     @Test
    public void setNameTest(){
        
    }
    
    
}
