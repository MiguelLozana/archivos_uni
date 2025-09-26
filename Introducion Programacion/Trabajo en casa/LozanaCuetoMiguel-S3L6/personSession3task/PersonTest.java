

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Escenarios de prueba 
 * 1 - Edad entre los límites - se modifica
 * 2 - Edad por debajo del limite inferior - excepcion
 * 3 - Edad por encima del limite superior - excepcion
 * 4 - Edad en limite inferior - excepcion
 * 5 - Edad en limite superior - excepcion
 * 
 * 6 - Valores normales - Cumple perfectamente
 * 7 - Valores con nombres vacios -> "" - Cuenta los nombres como vacio y su longitud es 0
 * 8 - Valores con minusculas y mayusculas - Lo pone todo en mayusculas
 * 9 - Valores con acentos - Respeta todos los acentos 
 *
 * @author  Miguel Lozana 
 * @version (26/09/2025)
 *
 */

public class PersonTest
{
    
    
    /**
     * Comprueba que en el getAge(), si la edad esta entre los limites se modifica.
     */
    @Test
    public void setBetweenLimitAgeTest(){
        Person p1 = new Person(8);
        assertEquals(8,p1.getAge());
        
        //assertEquals(VALOR_ESPERADO, VALOR OBTENIDO)
    }
    
    /**
     * Comprueba que en el getAge(), si la edad esta por debajo del límite inferior se lanza una excepción. 
     * Para ello intenta asignarle un valor "incorrecto" al objeto, si lo consigue el test falla.
     */
    @Test
    public void setUnderLimitAgeTest(){
        try {
            Person p1 = new Person(-5);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }
    /**
     * Comprueba que en el getAge(), si la edad esta por encima del límite superior se lanza una excepción. 
     * Para ello intenta asignarle un valor "incorrecto" al objeto, si lo consigue el test falla.
     */
    @Test
    public void setAboveLimitAgeTest(){
        try {
            Person p1 = new Person(333);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }
    /**
     * Comprueba que en el getAge(), si la edad está justo en el límite inferior se lanza una excepción. 
     * Para ello intenta asignarle un valor "incorrecto" al objeto, si lo consigue el test falla.
     */
    @Test
    public void setOnLowerLimitAgeTest(){
        try {
            Person p1 = new Person(0);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }
    /**
     * Comprueba que en el getAge(), si la edad está justo en el límite superior se lanza una excepción. Para ello intenta asignarle un valor "incorrecto" al objeto, si lo cosigue el test falla
     */
    @Test
    public void setUpperLimitAgeTest(){
        try {
            Person p1 = new Person(120);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }  
    }
    
    

    /**
     * Comprueba que representa bien la cadena en un caso favorable
     */
    @Test
    public void normalValue(){
        Person p1 = new Person("Pedro","Picapiedra",25,true);
        assertEquals("25-PEDRO-5-PICAPIEDRA-10", p1.getHashCode());
    }
    /**
     * Comprueba que representa bien la cadena en un caso en el que el nombre y apellido esta vacio
     */
    @Test
    public void withoutValue(){
        Person p1 = new Person("","",25,true);
        assertEquals("25--0--0", p1.getHashCode());
    }
    /**
     * Comprueba que representa bien la cadena en un caso en el que se mezclan mayusculas y mincusculas
     */
    @Test
    public void uppeAndLowercaseValue(){
        Person p1 = new Person("PeDrO","PicAPiedrA",25,true);
        assertEquals("25-PEDRO-5-PICAPIEDRA-10", p1.getHashCode());
    }
    /**
     * Comprueba que representa bien la cadena en el caso de acentos y la letra ñ 
     */
    @Test
    public void acentValue(){
        Person p1 = new Person("Mâríà","Müñoz",25,true);
        assertEquals("25-MÂRÍÀ-5-MÜÑOZ-5", p1.getHashCode());
    }
}
    

