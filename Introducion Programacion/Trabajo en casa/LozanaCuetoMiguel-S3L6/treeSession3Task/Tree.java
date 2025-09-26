
/**
 * Esta clase modela un árbol teniendo en cuenta su tipo, numero máximo de flores, 
 * número de flores o número de frutas.
 * 
 * @author (Miguel Lozana Cueto) 
 * @version (21/09/2025)
 */
public class Tree
{
    private static final int MAX_NUMBER_OF_FLOWERS = 12;
    private static final String DEFAULT_TYPE_OF_TREE = "Roble";
    private static final int DEFAULT_NUMBER_OF_FLOWERS = 3;
    private static final int DEFAULT_NUMBER_OF_FRUITS = 33;
    
    private String typeOfTree;
    private int numberOfFlowers ;
    private int numberOfFruits ;
    
    /**
     * Le da los valores iniciales llamando a los setters
     */
    public Tree() {
    setType(DEFAULT_TYPE_OF_TREE);
    setNumberOfFlowers(DEFAULT_NUMBER_OF_FLOWERS);
    setNumberOfFuits(DEFAULT_NUMBER_OF_FRUITS);
    }
    
    /**
     * Obtiene el valor del atributo typeOfTree
     * @return Devuelve el valor del atributo typeOfTree
     */
    public String getType(){
        return typeOfTree;
    }
    /**
     * Obtiene el valor de la constante MAX_NUMBER_OF_FLOWERS
     * @return Devuelve el valor de la constante MAX_NUMBER_OF_FLOWERS
     */
    
    public int getMaxFlowers(){
        return MAX_NUMBER_OF_FLOWERS;
    }
    /**
     * Obtiene el valor del atributo numberOfFlowers
     * @return Devuelve el valor del atributo numberOfFlowers 
     */
    public int getNumberOfFlowers(){
        return numberOfFlowers;
    }
    /**
     * Obtiene el valor del atributo numberOfFruits
     * @return Devuelve el valor del atributo numberOfFruits
     */
    public int getNumberOfFruits(){
        return numberOfFruits;
    }
    
    
    /**
     * Asigna el valor introducido como parametro (newType) a typeOfTree
     * @param newType sustituye al valor de typeOfTree
     */
    public void setType(String newType){
        typeOfTree = newType;
    }
   
    /**
     * Tras llamar al metodo numeroPosiivo() para que compruebe que el número es correcto, asigna el 
     * valor introducido como parametro (newNumberFlowers) a numberOfFlowers
     * @param newNumberFlowers sustituye al valor de numberOfFflowers 
     */
    public void setNumberOfFlowers(int newNumberFlowers){
        numeroPositivo(newNumberFlowers);
        if (newNumberFlowers<MAX_NUMBER_OF_FLOWERS){
            numberOfFlowers = newNumberFlowers;
        }
    }
    /**
     * Tras llamar al metodo numeroPositivo() para que compruebe que el número es correcto, asigna el 
     * valor introducido como parametro (newNumberFuits) a numberOfFruits
     * @param newNumberOfFruits sustituye al valor de numberOfFuits
     */
    public void setNumberOfFuits(int newNumberFuits){
        numeroPositivo(newNumberFuits);
        numberOfFruits = newNumberFuits;
    }
    
    /**
     * Comprueba si el número es positivo o negativo, en caso de ser negativo lanza un
     * RuntimeException, en caso contrario sigue ejecutando el codigo.
     *@param numero es el valor a comprobar si negativo o positivo
     */
    public void numeroPositivo(int numero){
        if (numero<0){
            throw new RuntimeException("El número no puede ser negativo");
        }
    }
    
    /**
     * Concatena los atributos del objeto con el formato: Manzano-25-7-3
     * @return String la cadena con los atributos del objeto
     */
    public String toString(){
        return getType() + "-" + getMaxFlowers() + "-" + getNumberOfFlowers() + "-" + getNumberOfFruits();
    }
    
    /**
     * Muestra la cadena devuelta por toString junto con un texto contextual
     */
    public void print() {
        System.out.println("Valores de la propiedades del árbol: " + toString());
    }
    
     
}