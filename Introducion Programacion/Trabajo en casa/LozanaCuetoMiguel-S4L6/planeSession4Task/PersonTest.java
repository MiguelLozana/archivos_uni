
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Escenarios de prueba del setAge()
 * 1 - Edad entre los límites - se modifica
 * 2 - Edad por debajo del limite inferior - excepcion
 * 3 - Edad por encima del limite superior - excepcion
 * 4 - Edad en limite inferior - excepcion
 * 5 - Edad en limite superior - excepcion
 *
 * @author  Miguel Lozana 
 * @version (26/09/2025)
 *
 */

public class PersonTest
{
    /**
     * 1 - Comprueba que en el setAge(), si la edad esta entre los limites se modifica.
     */
    @Test
    public void setAgeBetweenLimitAgeTest(){
        Person p1 = new Person(8);
        assertEquals(8,p1.getAge());

        //assertEquals(VALOR_ESPERADO, VALOR OBTENIDO)
    }

    /**
     * 2 - Comprueba que en el setAge(), si la edad esta por debajo del límite inferior se lanza una excepción. 
     * Para ello intenta asignarle un valor "incorrecto" al objeto, si lo consigue el test falla.
     */
    @Test
    public void setAgeUnderLimitAgeTest(){
        try {
            Person p1 = new Person(-5);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }

    /**
     * 3 - Comprueba que en el setAge(), si la edad esta por encima del límite superior se lanza una excepción. 
     * Para ello intenta asignarle un valor "incorrecto" al objeto, si lo consigue el test falla.
     */
    @Test
    public void setAgeAboveLimitAgeTest(){
        try {
            Person p1 = new Person(333);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }

    /**
     * 4 - Comprueba que en el setAge(), si la edad está justo en el límite inferior se lanza una excepción. 
     * Para ello intenta asignarle un valor "incorrecto" al objeto, si lo consigue el test falla.
     */
    @Test
    public void setAgeOnLowerLimitAgeTest(){
        try {
            Person p1 = new Person(Person.MIN_AGE);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }
    }

    /**
     * 5 - Comprueba que en el setAge(), si la edad está justo en el límite superior se lanza una excepción. Para ello intenta asignarle un valor "incorrecto" al objeto, si lo cosigue el test falla
     */
    @Test
    public void setAgeUpperLimitAgeTest(){
        try {
            Person p1 = new Person(Person.MAX_AGE);
            fail("Se esperaba excepción");
        }   
        catch (RuntimeException excepcion) {
            assertEquals("Edad Ilegal", excepcion.getMessage());
        }  
    }
    /**--Test getCriticalAge  --
     * 6 - Edad menor de 18 -> 18 - Edad
     * 7 - Edad igual a 18 -> 65-18 =47
     * 8 - Edad mayor de 18 menor de 65 -> 65 - edad
     * 9 - Edad igual a 65 ->0
     * 10 - Edad mayor de 65 -> edad - 65
     */

    /**
     * 6 - Comprueba que si la edad es menor de 18, se cumple: 18-Edad
     */
    @Test
    public void getCriticalAgeUnderAdulthood() {
        Person p1 = new Person(10);
        assertEquals(8, p1.getCriticalAge()); 
    }

    /**
     * 7 - Comprueba que si la edad es igual a 18, se cumple: 65-18 = 47
     */
    @Test
    public void getCriticalAgeAtAdulthood() {
        Person p1 = new Person(18);
        assertEquals(47, p1.getCriticalAge());
    }

    /**
     * 8 - Comprueba que si la edad es mayor que 18 pero menor de 65, se cumple: 65-edad 
     */
    @Test
    public void getCriticalAgeAdultRange() {
        Person p1 = new Person(40);
        assertEquals(25, p1.getCriticalAge()); 
    }

    /**
     * 9 - Comprueba que si la edad es igual a 65, se cumple: 65-65 = 0
     */
    @Test
    public void getCriticalAgeAtRetirement() {
        Person p1 = new Person(65);
        assertEquals(0, p1.getCriticalAge());
    }

    @Test
    /**
     * 10 - Comprueba que si la edad es mayor que 65, se cumple: Edad - 65 
     */
    public void getCriticalAgeOverRetirement() {
        Person p1= new Person(80);
        assertEquals(15, p1.getCriticalAge()); 
    }

    /**Test de ageClasifier() mediante el getHashCode() ya que ageClasifier() es privado
     * 11 - Edad menor de 18 - CHILD
     * 12 - Edad igual a 18 - ADULT
     * 13 - Edad entre 18 y 65  - ADULT
     * 14 - Edad igual a 65 - RETIRED
     * 15 - Edad mayor de 65 - RETIRED
     */
    /**
     * 11 - Comprueba que getHashCode() contiene "CHILD" proveniente de ageClasifier() si la edad es menor de 18
     */
    @Test
    public void ageClasiferYoungerThan18(){
        Person p1 = new Person(Person.ADULTHOOD_AGE-1);
        assertEquals("17-FE-ALON-CHILD", p1.getHashCode()); 
    }

    /**
     * 12 -Comprueba que getHashCode() contiene "ADULT" proveniente de ageClasifier() si la edad es 18
     */
    @Test
    public void ageClasiferIs18(){
        Person p1 = new Person(Person.ADULTHOOD_AGE);
        assertEquals("18-FE-ALON-ADULT", p1.getHashCode()); 
    }

    /**
     * 13 - Compureba getHashCode() contiene "ADULT" proveniente de ageClasifier() si la edad está entre 18 y 65
     */
    @Test
    public void ageClasiferBetween18And65(){
        Person p1 = new Person(Person.ADULTHOOD_AGE+1);
        assertEquals("19-FE-ALON-ADULT", p1.getHashCode()); 
    }

    /**
     * 14 - Compureba que getHashCode() contiene "RETIRED" proveniente de ageClasifier() si la edad es 65
     */
    @Test
    public void ageClasiferIs65(){
        Person p1 = new Person(Person.RETIREMENT_AGE);
        assertEquals("65-FE-ALON-RETIRED", p1.getHashCode()); 
    }

    /**
     * 15 - Compureba que getHashCode() contiene "RETIRED" proveniente de ageClasifier() si la edad es mayor de 65
     */
    @Test
    public void ageClasiferOlderThan65(){
        Person p1 = new Person(Person.RETIREMENT_AGE+1);
        assertEquals("66-FE-ALON-RETIRED", p1.getHashCode()); 
    }

    /**
     * Test de shorterString()
     * 16 - Casos favorables
     * 17 - Indices invertidos (indice final < indice inicial) excepcion
     * 18 - Cadena demasiado pequeña - excepcion
     * 
     */
    /**
     * 16 - Test de shorter string en casos favorables
     */
    @Test
    public void shortStringFavourableString(){
        Person p1 = new Person();
        assertEquals("na", p1.shortenString("Fernando", 3, 5)); 
    }

    /**
     * 17 - Test de shorter string con indices desordenados
     */
    @Test
    public void shortStringUnshortedIndex(){
        try{   
            Person p1 = new Person();
        } catch (RuntimeException re){
            assertEquals("El indice inicial (segundo parametro) ha de ser menor al indice final(tercer parametro)", re.getMessage());
        }
    }

    /**
     * 18 - Test de shorter string con cadena demasiado corta
     */
    @Test
    public void shortStringTooShortString(){
        try{   
            Person p1 = new Person();
        } catch (RuntimeException re){
            assertEquals("La longitud de la cadena es demasiado corta", re.getMessage());
        }
    }
    /**-- Test getHashCode --
     * 19 - Valores con mayusculas y minusculas
     * 20 - Valores con acentos
     * 21 - Simbolos como string
     */

    /**
     * 19 - Comprueba que el metodo getHashCode representa bien la cadena con mayusculas y minusculas
     */
    @Test
    public void getHashCodeCapitalAndLowerCase(){
        Person p1 = new Person("PedRo","PIcApIEdRA",25,true);
        assertEquals("25-PE-PICA-ADULT", p1.getHashCode());
    }

    /**
     * 20 - Comprueba que representa bien la cadena con acentos
     */
    @Test
    public void getHashCodeAcents(){
        Person p1 = new Person("Pëdrò","Pîçápiedra",5,true);
        assertEquals("5-PË-PÎÇÁ-CHILD", p1.getHashCode());
    }

    /**
     * 21 - Comprueba que el metodo getHashCode representa bien la cadena con simbolos como string
     */
    @Test
    public void getHashCodeSimbols(){
        Person p1 = new Person("[*¨{","^´_-",95,true);
        assertEquals("95-[*-^´_--RETIRED", p1.getHashCode());
    }

}