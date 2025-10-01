

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Escenarios de prueba del getAge()
 * 1 - Edad entre los límites - se modifica
 * 2 - Edad por debajo del limite inferior - excepcion
 * 3 - Edad por encima del limite superior - excepcion
 * 4 - Edad en limite inferior - excepcion
 * 5 - Edad en limite superior - excepcion
 *
 * -- Test getHashCode --
 * 6 - Valores normales - Cumple perfectamente
 * 7 - Valores con nombres vacios -> "" - Cuenta los nombres como vacio y su longitud es 0
 * 8 - Valores con minusculas y mayusculas - Lo pone todo en mayusculas
 * 9 - Valores con acentos - Respeta todos los acentos 
 *
 * --Test getCriticalAge  --
 * 10 - Edad menor de 18 -> 18 - Edad
 * 11 - Edad igual a 18 -> 65-18 =47
 * 12 - Edad mayor de 18 menor de 65 -> 65 - edad
 * 13 - Edad igual a 65 ->0
 * 14 - Edad mayor de 65 -> edad - 65
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
            Person p1 = new Person(Person.MIN_AGE);
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
            Person p1 = new Person(Person.MAX_AGE);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }  
    }
    
    
    //Test de getHashCode
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
    
    //TEST  de getCriticalAge
    
    /**
     * Comprueba que si la edad es menor de 18, se cumple: 18-Edad
     */
    @Test
    public void underAdulthood() {
        Person p1 = new Person(10);
        assertEquals(8, p1.getCriticalAge()); 
    }
    /**
     * Comprueba que si la edad es igual a 18, se cumple: 65-18 = 47
     */
    @Test
    public void atAdulthood() {
        Person p1 = new Person(18);
        assertEquals(47, p1.getCriticalAge());
    }
    /**
     * Comprueba que si la edad es mayor que 18 pero menor de 65, se cumple: 65-edad 
     */
    @Test
    public void adultRange() {
        Person p1 = new Person(40);
        assertEquals(25, p1.getCriticalAge()); 
    }
    /**
     * Comprueba que si la edad es igual a 65, se cumple: 65-65 = 0
     */
    @Test
    public void atRetirement() {
        Person p1 = new Person(65);
        assertEquals(0, p1.getCriticalAge());
    }
    @Test
    /**
     * Comprueba que si la edad es mayor que 65, se cumple: Edad - 65 
     */
    public void overRetirement() {
        Person p1= new Person(80);
        assertEquals(15, p1.getCriticalAge()); 
    }
}
    
//tarea semana que viene 
//chakparam name7surname
//constructor de solo nama / surname
//seter y geter de plane
//pruebas constructor sin parametros 
//probar toString
// implementar en plane un metodo fly() publico, sin parametros, debuelve bollean
// so fuel=0 false, si else, fuel -1 true
