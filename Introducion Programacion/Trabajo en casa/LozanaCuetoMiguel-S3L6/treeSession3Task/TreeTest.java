

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
 * --  Test sobre el metodo gatherFruit() <br>
 * 1 - Fruit mayor que 1 -> Disminuye 1<br>
 * 2 - Fruit igual a 1 -> Disminuye 1, frutas finales 0<br>
 * 3 - Fruit igual a 0 -> No disminuye, futas finales 0<br>
 * 
 * -- Test sobre el metodo harvest() <br>
 * 1 - Frutas mayores a 0 - devuelve el numero de frutas
 * 2 - Frutas iguales a 0 - devuevle 0
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
     * Comprueba que el metodo water() aumenta flores si no llega al limite superior
     */
    public void lessFloweresThanLimit(){
        Tree t1= new Tree(7,7);
        t1.water();
        assertEquals(8,t1.getNumberOfFlowers());
    }
    @Test
    /**
     * Comprueba que el metodo water() aumenta 1 fruta disminuye 1 flor, si flor es igual al maximo y las frutas menos que el maximo de flores
     */
    public void flowersEqualsMaximunNumberOfFlowersAndMoreThanFruits(){
        Tree t1= new Tree(12,7);
        t1.water();
        assertEquals(11,t1.getNumberOfFlowers());
        assertEquals(8,t1.getNumberOfFruits());
    }
     @Test
    /**
     * Comprueba que el metodo water() no aumenta ni disminuye flores ni frutas. Si flor es igual al maximo y igual a fruta
     */
    public void flowersEqualsMaximunNumberOfFlowersEqualsFruits(){
        Tree t1= new Tree(12,12);
        t1.water();
        assertEquals(12,t1.getNumberOfFlowers());
        assertEquals(12,t1.getNumberOfFruits());
    }
     @Test
    /**
     *  Comprueba que el metodo water() no aumenta ni disminuye flores ni frutas. Si flor es igual al maximo y las frutas mas que el maximo de flores
     */
    public void flowersEqualsMaximunNumberOfFlowersLessThanFruits(){
        Tree t1= new Tree(12,26);
        t1.water();
        assertEquals(12,t1.getNumberOfFlowers());
        assertEquals(26,t1.getNumberOfFruits());
    }
     
    
     @Test
    /**
     * Comprueba que el metodo gatherFruit() disminuye 1 fruta. Si hay mas de una fruta
     */
    public void gatherFruitMoreThanOne(){
        Tree t1= new Tree(5,6);
        t1.gatherFruit();
        assertEquals(5,t1.getNumberOfFruits());
    }
    @Test
    /**
     *Comprueba que el metodo gatherFruit() disminuye 1 fruta. Si hay UNA fruta 
     */
    public void gatherFruitIsOne(){
        Tree t1= new Tree(5,1);
        t1.gatherFruit();
        assertEquals(0,t1.getNumberOfFruits());
    }
    @Test
    /**
     *Comprueba que el metodo gatherFruit() disminuye 1 fruta. Si hay CERO fruta 
     */
    public void gatherFruitIsCero(){
        Tree t1= new Tree(5,0);
        t1.gatherFruit();
        assertEquals(0,t1.getNumberOfFruits());
    }
    
    
     @Test
    /**
     *Compueba que el metodo harvest() pone a 0 las frutas y dice cuantas habia. 
     */
    public void harvestFruitMoreThanCero(){
        Tree t1= new Tree(5,5);
        assertEquals(5,t1.harvest());
    }
     @Test
    /**
     *Comprueba que el metodo harvest() pone a 0 las furtas y dice cuantas habia (0).
     */
    public void harvestFruitIsCero(){
        Tree t1= new Tree(5,0);
        assertEquals(0,t1.harvest());
    }
}