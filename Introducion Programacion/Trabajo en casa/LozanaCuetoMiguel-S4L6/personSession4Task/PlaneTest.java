

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PlaneTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */

public class PlaneTest
{   
    /**
     * Test del constructor sin parametros que deberia dar los valores por defecto, SIN piloto, id: A y combustible 0
     */
    @Test
    public void constructorWithoutParams(){
        Plane plane1= new Plane() ;   
        assertEquals(Plane.DEFAULT_ID, plane1.getIdentifier());
        assertEquals(Plane.DEFAULT_FUEL, plane1.getFuel());
        assertEquals(null,plane1.getPilot());
    }
    /**
     * Test del metodo toString()
     * 1 - Valores por defecto (null,A,0), debería devolver "A-0-NO-PILOT"
     * 2 - Valores añadiendo a el Piloto default de la clase person debería devolver "A-0-Fernando"
     * 3 - Valores variando el combustible y el id (null,F,33) debería devolver "F-33-Fernando"
     */
    /**
     * Test para valores por defecto (null,A,0), debería devolver "A-0-NO-PILOT"
     */
    @Test
    public void defaultValue(){
        Plane plane1= new Plane() ; 
        assertEquals(plane1.toString(),"A-0-NO-PILOT");
    }
    /**
     * Test para valores añadiendo a un Piloto (Jose,A,0) debería devolver "A-0-Jose"
     */
    @Test
    public void withPilotValue(){
        Person piloto1 = new Person();
        Plane plane1= new Plane(piloto1) ; 
        assertEquals(plane1.toString(),"A-0-Fernando");
    }
    /**
     * Test para valores añadiendo a un Piloto (Jose,A,0) debería devolver "A-0-Jose"
     */
    @Test
    public void otherFuelOrId(){
        Person piloto1 = new Person();
        Plane plane1= new Plane(piloto1,'F',33) ; 
        assertEquals(plane1.toString(),"F-33-Fernando");
    }
}