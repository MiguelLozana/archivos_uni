

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
 * 
 * 6 - Valores noramles
 * 7 - Valores con nombres vacios -> ""
 * 8 - Valores con minusculas y mayusculas
 * 9 - Valores con acentos
 */

public class PersonTest
{
    
    @Test
    /**
     * Comprueba que en el getAge(), si la edad esta entre los limites se modifica.
     */
    public void setBetweenLimitAgeTest(){
        Person p1 = new Person(8);
        assertEquals(8,p1.getAge());
        
        //assertEquals(VALOR_ESPERADO, VALOR OBTENIDO)
    }
    @Test
    /**
     * Comprueba que en el getAge(), si la edad esta por debajo del límite inferior se lanza una excepción. Para ello intenta asignarle un valor "incorrecto" al objeto, si lo cosigue el test falla.
     */
    public void setUnderLimitAgeTest(){
        try {
            Person p1 = new Person(-5);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }
    @Test
    /**
     * Comprueba que en el getAge(), si la edad esta por encima del límite superior se lanza una excepción. Para ello intenta asignarle un valor "incorrecto" al objeto, si lo cosigue el test falla.
     */
    public void setAboveLimitAgeTest(){
        try {
            Person p1 = new Person(333);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }
     @Test
    /**
     * Comprueba que en el getAge(), si la edad está justo en el límite inferior se lanza una excepción. Para ello intenta asignarle un valor "incorrecto" al objeto, si lo cosigue el test falla.
     */
    public void setOnLowerLimitAgeTest(){
        try {
            Person p1 = new Person(0);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }
     @Test
    /**
     * Comprueba que en el getAge(), si la edad está justo en el límite superior se lanza una excepción. Para ello intenta asignarle un valor "incorrecto" al objeto, si lo cosigue el test falla
     */
    public void setUpperLimitAgeTest(){
        try {
            Person p1 = new Person(120);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }  
    }
    
    
    @Test
    
    public void normalValue(){
        Person p1 = new Person("Pedro","Picapiedra",25,true);
        assertEquals("25-PEDRO-5-PICAPIEDRA-10", p1.getHashCode());
    }
    @Test
    public void withoutValue(){
        Person p1 = new Person("","",25,true);
        assertEquals("25--0--0", p1.getHashCode());
    }
    @Test
    public void uppeAndLowercaseValue(){
        Person p1 = new Person("PeDrO","PicAPiedrA",25,true);
        assertEquals("25-PEDRO-5-PICAPIEDRA-10", p1.getHashCode());
    }
    @Test
    public void acentValue(){
        Person p1 = new Person("María","Muñoz",25,true);
        assertEquals("25-MARÍA-5-MUÑOZ-5", p1.getHashCode());
    }
}
    

