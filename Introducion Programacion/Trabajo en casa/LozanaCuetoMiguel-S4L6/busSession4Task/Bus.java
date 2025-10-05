
/**
 * Modela un autobús en base a un conductor (si hay o no) y el número de asientos disponilbes. 
 * 
 * @author Miguel Lozana 
 * @version 6-oct-25
 */
public class Bus
{   
    public final static int MAX_SEATS = 60;
    public final static int MIN_SEATS = 10;
    public final static boolean DEFAULT_DRIVER_PRESENT = false;

    
    
    private boolean driverPresent;
    private int availableSeats;
    /**
     * Constructor con los valores default
     */
    public Bus(){
    this(DEFAULT_DRIVER_PRESENT,MAX_SEATS);
    }
    /**
     * Constructor dado si tiene conductor
     * @param driverPresent el valor del conductor al construir el objeto
     */
    public Bus(boolean driverPresent){
    this(driverPresent,MAX_SEATS);
    }
    /**
     * Constructor dado solo los asientos disponibles
     * @param availableSeats el valor los asientos disponibles al construir el objeto
     */
    public Bus(int availableSeats){
    this(DEFAULT_DRIVER_PRESENT,availableSeats);
    }
    /**
     * Constructor dado si tiene conductor y el nuemro de asientos disponibles
     * @param driverPresent el valor del conductor al construir el objeto
     * @param availableSeats el valor los asientos disponibles al construir el objeto 
     */
    public Bus(boolean driverPresent, int availableSeats){
     setDriverPresent(driverPresent);
     setAvailableSeats(availableSeats);
    }
    
    
    /**
     * Cambia el valor del conductor por el dado como parametro
     * @param driverPresent Nuevo valor para el conductor
     */
    private void setDriverPresent(boolean driverPresent){
        this.driverPresent=driverPresent;
    }
    /**
     * Cambia el valor de los asientos disponibles siempre que este dentro del margen establecido 
     * @param availableSeats Nuevo valor para los asientos disponibles
     */
    private void setAvailableSeats(int availableSeats){
        if(availableSeats>=MIN_SEATS && availableSeats<=60){
            this.availableSeats=availableSeats;
        }
    }
    
    /**
     * Obtiene el valor de driverPresent
     * @return boolean El valor de driverPresent
     */
    public boolean getDriverPresent(){
        return this.driverPresent;   
    }
    /**
     * Obtiene el valor de availableSeats
     * @return int El valor de availableSeats
     */
    public int getAvailableSeats(){
        return this.availableSeats;   
    }
    
    
    
    /**
     * Cambia el conductor a true
     */
    public void sitDriver(){
        setDriverPresent(true);
    }
    
    /**
     * Si el conductor es true y hay suficeintes asientios disponibles, se devuelve true y los asientos disponbles se reducen en el valor introducido como parametro 
     * @param newPassangers el valor que se intentara reducir los asientos disponibles
     */
    public boolean getOn(int newPassangers){
        if  (this.driverPresent == true && availableSeats >= newPassangers){
            setAvailableSeats(availableSeats-newPassangers);
            return true;
        } else {
            return false;
        }
    }
    /**
     * Genera una string dependiendo de si hay conductor o no y el nuermo de sitios, P.ej: "ON DUTY-23" / "OUT OF SERVICE-3"
     * @return string con el formato anterior
     */
    public String toString(){
        String firstString = "ON DUTY";
        if (driverPresent == false){
            firstString = "OUT OF SERVICE";
        }
        
        return firstString + "-" + getAvailableSeats();
    }
}