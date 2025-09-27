

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TwoCharTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */

public class TwoCharTest
{
    
    @Test
    public void pruebaUno(){
        TwoChar cadena = new TwoChar();
        assertEquals("ja",cadena.twoChar("java", 0));
    }
    @Test
    public void pruebaDos(){
        TwoChar cadena = new TwoChar();
        assertEquals("va",cadena.twoChar("java", 2));
    } 
}