

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BusTest.
 *
 * @author  Miguel Lozana
 * @version 5-0ct-25
 */
public class BusTest
{
        /**
         * Test de los constructoes
         * 1- Valores default
         * 2 - Conductor como parametro
         * 3 - asietnos como parametro
         * 4 - Conductor y asientos de parametro
         */
        /**
         *  Prueba que asigna los valores default
         */
        @Test
        public void defaultValueConstructor(){
            Bus b1 = new Bus();
            assertEquals(Bus.DEFAULT_DRIVER_PRESENT, b1.getDriverPresent());
            assertEquals(Bus.MAX_SEATS, b1.getAvailableSeats());
        }
        /**
         *  Prueba que asigna correctametne el conductor
         */
        @Test
        public void driverConstructor(){
            Bus b1 = new Bus(true);
            assertEquals(true, b1.getDriverPresent());
            assertEquals(Bus.MAX_SEATS, b1.getAvailableSeats());
        }
        /**
         * Prueba que asigna correctamente los asientos
         */
        @Test
        public void seatConstructor(){
            Bus b1 = new Bus(33);
            assertEquals(Bus.DEFAULT_DRIVER_PRESENT,b1.getDriverPresent());
            assertEquals(33,b1.getAvailableSeats());
        }
        /**
         * Prueba quea asigna correctamente asientos y conductor
         */
        @Test
        public void driverAndSeatConstructor(){
            Bus b1 = new Bus(true,33);
            assertEquals(true,b1.getDriverPresent());
            assertEquals(33,b1.getAvailableSeats());
        }
        
        /**
         * 5 - Test de sitDriver()
         * Comprueba que una vez que se aplica el driverPresent es true
         */
        @Test
        public void sitDriverTest(){
            Bus b1 = new Bus();
            assertEquals(false, b1.getDriverPresent()); //Comprobamos que es False antes del cambio
            b1.sitDriver();
            assertEquals(true, b1.getDriverPresent()); //Comprobamos que es True despues del cambio
        }
        
        /**
         * Test de getOn()
         * 6 - driverPresent es false -> devuelve false
         * 7 - no suficeintes asientos vacios -> devuelve false
         * 8 - driverPresent es true y asientos suficientes -> Devuelve true y el numero de asientos que quedaran disponibles
         */
        /**
         * Comprueba que si el conductor es false, devuelve false
         */
        @Test
        public void getOnDriverPresentIsFalse(){
            Bus b1 = new Bus(false);
            assertEquals(false, b1.getOn(10));
        }
        /**
         * Comprueba que si no hay suficientes asientos disponibles, devuelve false
         */
        @Test
        public void getOnNotEnoughSeats(){
            Bus b1 = new Bus(true);
            assertEquals(false, b1.getOn(65));
        }
        /**
         * Comprueba que si el conductor es true y hay asientos disponilbles, devuelve true y obtiene los nuevos asientos disponibles
         */
        @Test
        public void getOnDiverIsTrueAndEnoughSeats(){
            Bus b1 = new Bus(true);
            assertEquals(true,b1.getOn(10));
            assertEquals(Bus.MAX_SEATS-10,b1.getAvailableSeats());
        }
        
        /**
         * Test de toString()
         * 9 - driverPresent es false 
         * 10 - driverPresent es true
         */
        /**
         * Comprueba qeu la cadena es bien representada si el conductor es false
         */
        @Test
        public void toStringFalseDriver(){
            Bus b1 = new Bus(false);
            assertEquals("OUT OF SERVICE-60",b1.toString());
        }
        /**
         * Comprueba qeu la cadena es bien representada si el conductor es true
         */
        @Test
        public void toStringTrueDriver(){
            Bus b1 = new Bus(true);
            assertEquals("ON DUTY-60",b1.toString());
        }
}