
/**
 * Write a description of class Plane here.
 * 
 * @author Miguel Lozana CUeto 
 * @version 02/10/2025
 */
public class Plane
{
    //Declaramos las contantes, en este caso valores por defecto
    public static final int MIN_FUEL = 0;
    public static final char DEFAULT_ID = 'A';
    public static final int DEFAULT_FUEL= 0;
    
    //Declaramos los atributos
    private Person pilot;
    private char identifier;
    private int fuel;
    
    /**
     * Constructor por defecto de la clase plane
     * @param pilot Piloto asignado al avion
     *  @param identifier identificador del avión con un caracter 
     *  @param fuel cantidad de combustible del avión
     */
    public Plane(Person pilot, char identifier, int fuel)
    {
        setPilot(pilot);  
        setIdentifier(identifier);
        setFuel(fuel);
    }
    
    /**
     * Constructor de la clase plane pero con piloto = null
     */
    public Plane(){
        this(null,DEFAULT_ID,DEFAULT_FUEL);
    }
    /**
     * Constructor de la clase plane pero con piloto como parametro
     * @param pilot piloto asignado al avion
     */
    public Plane(Person pilot){
        this(pilot,DEFAULT_ID, DEFAULT_FUEL);
    }
    /**
     * Constructor de la clase plane pero con fuel como parametro
     * @param fuel combustible asignado al avion
     */
    public Plane(int fuel){
        this(null,DEFAULT_ID, fuel);
    }
    
   
    //SETTERS    
    /**
     * Establece el valor de pilot
     * @param pilot el nuevo valor para el atributo pilot
     */
    private void setPilot(Person pilot){
        this.pilot=pilot;
    }
    /**
     * Establece el valor de identifier
     * @param identifier el nuevo valor para el atributo identifier
     */
    private void setIdentifier(char identifier){
        this.identifier=identifier;
    }
    /**
     * Establece el valor de fuel
     * @param fuel el nuevo valor para el atributo fuel
     */
    private void setFuel(int fuel){
        checkParam(fuel>=MIN_FUEL , "Combustible no puede ser menor que 0");
        this.fuel = fuel;
    }
    
    //GETTERS
    /**
     * Devuelve el atributo pilot 
     * @return el atributo pilot
     */
    public Person getPilot(){
        return this.pilot;
    }
    /**
     * Devuelve el atributo identifier 
     * @return el atributo identifier
     */
    public char getIdentifier(){
        return this.identifier;
    }
    /**
     * Devuelve el atributo fuel 
     * @return el atributo fuel
     */
    public int getFuel(){
        return this.fuel;
    }
    
    /**
     * Comprueba si un parámetro tiene sentido dentro del campo correspondiente, en caso contrario corta la ejecucion y muestra un mensaje
     * @param condition la condición que el parametro tiene que cumplir
     * @param message el mensaje mostrado en el caso de que no se cumpla la condición.
     */
    private void checkParam(boolean condition, String message){
        if(!condition){
            throw new RuntimeException(message);
        }
    }
    
    /**
     * Crea una representación de la información del objeto con el siguiente formato: identificador-gasolina-piloto
     * @return Devuelve la String con el formato anterior 
     */
    public String toString(){
        String stringPilot ="NO-PILOT";
        if (this.pilot !=null){
            stringPilot = this.pilot.getName();
        }
        
        

        return this.identifier + "-" + this.fuel + "-" + stringPilot;

    }
    /**
     * Comprueba si el avion puede volar, si tiene combustible devuelve true (vuela) y consume 1, sino devuelve false (no puede volar)
     *@return boolean True si tiene combustible, false si no tiene
     */
    public boolean fly(){
        if (fuel>0){
           fuel = fuel - 1;
            return true;
        } else {
            return false;
        } 
    }
}
