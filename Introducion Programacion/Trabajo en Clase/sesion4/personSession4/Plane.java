
/**
 * Write a description of class Plane here.
 * 
 * @author Miguel Lozana CUeto 
 * @version (a version number or a date)
 */
public class Plane
{
    public static final int MIN_FUEL = 0;
    public static final char DEFAULT_ID = 'A';
    public static final int DEFAULT_FUEL= 0;
    
    
    private Person pilot;
    private char indentifier;
    private int fuel;

    public Plane(){
        this(null,'A',0);
    }
    public Plane(Person pilot){
        this(pilot,DEFAULT_ID, DEFAULT_FUEL);
    }
    /**
     * Constructor por defecto de la clase plane
     * @param Person pilot
     */
    public Plane(Person pilot, char indentifier, int fuel)
    {
        setPilot(pilot);  
        setIdentifier(indentifier);
        setFuel(fuel);
    }
    
    
    public void setPilot(Person pilot){
        this.pilot=pilot;
    }
    public void setIdentifier(char identifier){
        this.pilot=pilot;
    }
    public void setFuel(int fuel){
        checkParam(fuel>=MIN_FUEL , "Combustible no puede ser menor que 0");
    }
    
    private Person getPilot(){
        return this.pilot;
    }
    private char getIdentifier(){
        return this.indentifier;
    }
    private int getFuel(){
        return this.fuel;
    }
     
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
            stringPilot = this.pilot;
        }
        
        

        return this.indentifier + "-" + this.fuel + "-" + this.pilot;

    }
}
