

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
     * Test de los constructores
     * 1 - Constructor SIN parametros (null, DEFAULT_ID, DEFAULT_FUEL)
     * 2 - Constructor de pilot como parametro (Fernando, DEFAULT_ID, DEFAULT_FUEL)
     * 3 - Constructor de identifier como parametro (null, E , DEFAULT_FUEL)
     * 4 - Constructor de fuel como parametro (null, DEFAULT_ID, 55)
     */
    /**
     * 1 - Test del constructor sin parametros que deberia dar los valores por defecto, SIN piloto, id: A y combustible 0
     */
    @Test
    public void constructorWithoutParams(){
        Plane plane1= new Plane() ;   
        assertEquals(Plane.DEFAULT_ID, plane1.getIdentifier());
        assertEquals(Plane.DEFAULT_FUEL, plane1.getFuel());
        assertEquals(null,plane1.getPilot());
    }
    /**
     * 2 - Test del constructor sin parametros que deberia dar, piloto: Fernando , id: A y combustible 0
     */
    @Test
    public void constructorWithPilotParam(){
        Person person1 = new Person();
        Plane plane1= new Plane(person1) ;   
        assertEquals(Plane.DEFAULT_ID, plane1.getIdentifier());
        assertEquals(Plane.DEFAULT_FUEL, plane1.getFuel());
        assertEquals("FERNANDO-Alonso-44-Masculino",plane1.getPilot().toString());
    }
     /**
     * 3 - Test del constructor sin parametros que deberia dar, SIN piloto, id: E y combustible 0
     */
    @Test
    public void constructorWithIdParam(){
        Plane plane1= new Plane('E') ;   
        assertEquals('E', plane1.getIdentifier());
        assertEquals(Plane.DEFAULT_FUEL, plane1.getFuel());
        assertEquals(null,plane1.getPilot());
    }
    /**
     * 4 - Test del constructor sin parametros que deberia dar, SIN piloto, id: A y combustible 50
     */
    @Test
    public void constructorWithFuelParam(){
        Plane plane1= new Plane(50) ;   
        assertEquals(Plane.DEFAULT_ID, plane1.getIdentifier());
        assertEquals(50, plane1.getFuel());
        assertEquals(null,plane1.getPilot());
    }
    /**
     * Test del metodo toString()
     * 5 - Valores por defecto (null,A,0), debería devolver "A-0-NO-PILOT"
     * 6 - Valores añadiendo a el Piloto default de la clase person debería devolver "A-0-Fernando"
     * 7 - Valores variando el combustible y el id (null,F,33) debería devolver "F-33-Fernando"
     */
    /**
     * 5 - Test para valores por defecto (null,A,0), debería devolver "A-0-NO-PILOT"
     */
    @Test
    public void defaultValue(){
        Plane plane1= new Plane() ; 
        assertEquals(plane1.toString(),"A-0-NO-PILOT");
    }
    /**
     * 6 - Test para valores añadiendo a un Piloto (Jose,A,0) debería devolver "A-0-Jose"
     */
    @Test
    public void withPilotValue(){
        Person piloto1 = new Person();
        Plane plane1= new Plane(piloto1) ; 
        assertEquals(plane1.toString(),"A-0-Fernando");
    }
    /**
     * 7 - Test para valores añadiendo a un Piloto (Jose,A,0) debería devolver "A-0-Jose"
     */
    @Test
    public void otherFuelOrId(){
        Person piloto1 = new Person();
        Plane plane1= new Plane(piloto1,'F',33) ; 
        assertEquals(plane1.toString(),"F-33-Fernando");
    }
    
    /**
     * Test del metodo fly()
     * 8 - Sin combustible, fuel = 0. Deberia debolver false y no cambiar el valor de fuel
     * 9 - Con combustible, ej. fuel = 5. Deberia debolver true y cambiar el valor de fuel a 4
     */
    /**
     * 8 - Test sin combustible
     */
    @Test
    public void withoutFuel(){
        Plane plane1 = new Plane();
        assertEquals(plane1.fly(),false);
        assertEquals(plane1.getFuel(),0);
    }
    /**
     * 9 - Test con fuel=5, devuevlve ture y el fuel baja a 4
     */
    @Test
    public void withFuel(){
        Plane plane1 = new Plane(5);
        assertEquals(plane1.fly(),true);
        assertEquals(plane1.getFuel(),4);
    }

}