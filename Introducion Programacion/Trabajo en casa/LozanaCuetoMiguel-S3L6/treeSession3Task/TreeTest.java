

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * --  Test sobre el metodo setNumberOfFlowers <br>
 * 1 - Cantidad de flores menor del limite inferior       -> Excepcion <br>
 * 2 - Cantidad de flores mayor del limite superior       -> Excepcion<br>
 * 3 - Cantidad de flores igual al limite inferior (0)    -> Cambia el valor<br>
 * 4 - Cantidad de flores igual al limite superior (12)   -> Cambia el valor<br>
 * 5 - Cantidad de flores dentro de los limites           -> Cambia el valor<br>
 *
 * --  Test sobre el metodo water <br>
 * 1 - Flores menor que MAX_NUMBER_OF_FLOWERS -> +1 Flor <br>
 * 2 - Flores igual a MAX_NUMBER_OF_FLOWERS y Frutas menor que MAX_NUMBER_OF_FLOWERS -> -1 Flor, +1 Fruta<br>
 * 3 - Flores igual a MAX_NUMBER_OF_FLOWERS igual a Frutas          ->   Sin cambios<br>
 * 4 - Flores igual a MAX_NUMBER_OF_FLOWERS y Frutas mayor que MAX_NUMBER_OF_FLOWERS   ->Sin Cambios<br>
 * 
 * @author  Miguel Lozana
 * @version 27/09/2025
 */
public class TreeTest
{
    /**
     * Comprueba que el metodo setNumberOfFlowers lanza excepcion si el valor esta debajo del limite inferior
     */
    @Test
    public void numberOfFlowersUnderMinim(){
        try {
            Tree t1= new Tree();
            t1.setNumberOfFlowers(-10);
            fail("Se esperaba excepción");
        }catch (RuntimeException excepcion){
            assertEquals("El número no puede ser negativo", excepcion.getMessage());
        }
    }
    /**
     * Comprueba que el metodo setNumberOfFlowers lanza excepcion si el valor esta encima del limite superior
     */
    @Test
    public void numberOfFlowersAboveMaximum(){
        try {
            Tree t1= new Tree();
            t1.setNumberOfFlowers(20);
            fail("Se esperaba excepción");
        }catch (RuntimeException excepcion){
            assertEquals("El número ha de ser menor o igual que el limite superior", excepcion.getMessage());
        }
    }
    /**
     *  Comprueba que el metodo setNumberOfFlowers permite asignar el valor minimo de flores
     */
    @Test
    public void numberOfFlowersAtMinim(){
        Tree t1= new Tree();
        t1.setNumberOfFlowers(0);
        assertEquals(0,t1.getNumberOfFlowers());
        
    }
    /**
     *  Comprueba que el metodo setNumberOfFlowers permite asignar el valor máximo de flores
     */
    @Test
    public void numberOfFlowersAtMaximum(){
        Tree t1= new Tree();
        t1.setNumberOfFlowers(12);
        assertEquals(12,t1.getNumberOfFlowers());        
    }
    /**
     *  Comprueba que el metodo setNumberOfFlowers permite asignar el valor dentro de los valroes maximo y minimo  de flores
     */
    @Test
    public void numberOfFlowersBetweenLimits(){
        Tree t1= new Tree();
        t1.setNumberOfFlowers(5);
        assertEquals(5,t1.getNumberOfFlowers()); 
    }
    
    @Test
    /**
     * Compueba que el metodo water() aumenta flores si no llega al limite superior
     */
    public void lessFloweresThanLimit(){
        Tree t1= new Tree(7,7);
        t1.water();
        assertEquals(8,t1.getNumberOfFlowers());
    }
    @Test
    /**
     * Compueba que el metodo water() aumenta 1 fruta disminuye 1 flor. Si flor es igual al maximo y las frutas menos que el maximo de flores
     */
    public void flowersEqualsMaximunNumberOfFlowersAndMoreThanFruits(){
        Tree t1= new Tree(12,7);
        t1.water();
        assertEquals(11,t1.getNumberOfFlowers());
        assertEquals(8,t1.getNumberOfFruits());
    }
     @Test
    /**
     * Compueba que el metodo water() aumenta 1 fruta disminuye 1 flor. Si flor es igual al maximo y las frutas menos que el maximo de flores
     */
    public void flowersEqualsMaximunNumberOfFlowersEqualsFruits(){
        Tree t1= new Tree(12,12);
        t1.water();
        assertEquals(12,t1.getNumberOfFlowers());
        assertEquals(12,t1.getNumberOfFruits());
    }
     @Test
    /**
     * Compueba que el metodo water() aumenta 1 fruta disminuye 1 flor. Si flor es igual al maximo y las frutas menos que el maximo de flores
     */
    public void flowersEqualsMaximunNumberOfFlowersLessThanFruits(){
        Tree t1= new Tree(12,26);
        t1.water();
        assertEquals(12,t1.getNumberOfFlowers());
        assertEquals(26,t1.getNumberOfFruits());
    }
     
}