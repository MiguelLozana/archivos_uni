
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
        setTypeOfTree(DEFAULT_TYPE_OF_TREE);
        setNumberOfFlowers(DEFAULT_NUMBER_OF_FLOWERS);
        setNumberOfFruits(DEFAULT_NUMBER_OF_FRUITS);
    }
    /**
     * Constructor que le da los valores de flores y frutas mediante parametros
     * @param numberOfFlowers, es el numero de flores que se le asiganara al objeto
     * @param numberOfFruits, es el numero de furtas que se le asiganara al objeto
     */
    public Tree(int numberOfFlowers, int numberOfFruits){
        this();
        setNumberOfFlowers(numberOfFlowers);
        setNumberOfFruits(numberOfFruits);
    }
    
    /**
     * Obtiene el valor del atributo typeOfTree
     * @return Devuelve el valor del atributo typeOfTree
     */
    public String getTypeOfTree(){
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
     * Asigna el valor introducido como parametro (typeOfTree) a typeOfTree
     * @param typeOfTree sustituye al valor de typeOfTree
     */
    public void setTypeOfTree(String typeOfTree){
        this.typeOfTree = typeOfTree ;
    }
   
    /**
     * Tras llamar al metodo numeroPositivo() para que compruebe que el número es correcto, asigna el 
     * valor introducido como parametro (numberOfFlowers) a numberOfFlowers
     * @param numberOfFlowers sustituye al valor de numberOfFlowers 
     */
    public void setNumberOfFlowers(int numberOfFlowers){
        numeroPositivo(numberOfFlowers);
        if (numberOfFlowers<=MAX_NUMBER_OF_FLOWERS){
            this.numberOfFlowers = numberOfFlowers;
        } else {
            throw new RuntimeException("El número ha de ser menor o igual que el limite superior");
        }
    }
    /**
     * Tras llamar al metodo numeroPositivo() para que compruebe que el número es correcto, asigna el 
     * valor introducido como parametro (numberOfFruits) a numberOfFruits
     * @param numberOfFruits sustituye al valor de numberOfFruits
     */
    public void setNumberOfFruits(int numberOfFruits){
        numeroPositivo(numberOfFruits);
        this.numberOfFruits = numberOfFruits;
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
        return getTypeOfTree() + "-" + getMaxFlowers() + "-" + getNumberOfFlowers() + "-" + getNumberOfFruits();
    }
    
    /**
     * Muestra la cadena devuelta por toString junto con un texto contextual
     */
    public void print() {
        System.out.println("Valores de la propiedades del árbol: " + toString());
    }
    
    public void water(){
        if (getNumberOfFlowers() < MAX_NUMBER_OF_FLOWERS){
            setNumberOfFlowers(getNumberOfFlowers() + 1 );
        } else {
            if (getNumberOfFruits() < MAX_NUMBER_OF_FLOWERS){
            setNumberOfFlowers(getNumberOfFlowers() - 1 );    
            setNumberOfFruits(getNumberOfFruits() + 1 );
            }
        }
    }
    
    public int gatherFruit(){

        if (getNumberOfFruits() > 0){
            setNumberOfFruits(getNumberOfFruits()-1);  
        }
        return this.numberOfFruits;
    }
    
    public int harvest(){
        int frutas;
        if (getNumberOfFruits() > 0){
            frutas = getNumberOfFruits();
            setNumberOfFruits(0);  
        } else{
            frutas=0;
        }
        return frutas;
    }
}