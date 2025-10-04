

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
 * 
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
    
    /**-- Test getHashCode --
     * 6 - Valores normales - Cumple perfectamente
     * 7 - Valores con nombre null -> runtimeException en name
     * 7 - Valores con apellido null -> runtimeException en apellido
     * 8 - Valores con nombre y apellido null -> runtimeException en name
     * 8 - Valores con logitud 1 -> 
     *
     */
    
    /**
     * Comprueba que representa bien la cadena en un caso favorable
     */
    @Test
    public void normalValue(){
        Person p1 = new Person("Pedro","Picapiedra",25,true);
        assertEquals("25-PE-PICA-ADULT", p1.getHashCode());
    }
    /**
     * Comprueba que representa bien la cadena en un caso donde name es null
     */
    @Test
    public void nameIsNullValue(){
        
        try {
            Person p1 = new Person(null,"picapiedra",25,true);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Nombre Ilegal", excepcion.getMessage());
        } 
    }
    /**
     * Comprueba que representa bien la cadena en un caso donde surname es null
     */
    @Test
    public void surnameIsNullValue(){
        
        try {
            Person p1 = new Person("picapiedra",null,25,true);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Apellido Ilegal", excepcion.getMessage());
        } 
    }
    /**
     * Comprueba que representa bien la cadena en un caso donde name y surname es null
     */
    @Test
    public void nameAndSurnameIsNullValue(){
        
        try {
            Person p1 = new Person(null,null,25,true);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Nombre Ilegal", excepcion.getMessage());
        } 
    }
    /**
     * Comprueba que representa bien la cadena en un caso donde name y surname es null
     */
    @Test
    public void lengthIsLowerThanExpected(){
        try{
            Person p1 = new Person("A","AB",25,true);
        }catch (runtimeException re) {
            assertEquals(p1.getHashCode(), re.getException());
        
        }
    }
    
    /**--Test getCriticalAge  --
     * 10 - Edad menor de 18 -> 18 - Edad
     * 11 - Edad igual a 18 -> 65-18 =47
     * 12 - Edad mayor de 18 menor de 65 -> 65 - edad
     * 13 - Edad igual a 65 ->0
     * 14 - Edad mayor de 65 -> edad - 65
     */
    
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