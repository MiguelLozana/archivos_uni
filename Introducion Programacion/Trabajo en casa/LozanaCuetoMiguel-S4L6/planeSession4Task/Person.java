
/**
 * Modela una persona incluyendo al menos su nombre, apellido, edad y género.
 * @author Miguel Lozana
 * @version 20250910
 */
public class Person {
    //Constantes
    public final static int MIN_AGE=0;
    public final static int MAX_AGE=120;
    public final static int ADULTHOOD_AGE = 18;
    public final static int RETIREMENT_AGE = 65;
    public final static boolean GENDER_FEMALE = false;
    public final static boolean GENDER_MALE = true;
    public final static int DEFAULT_INIT_INDEX=0;
    public final static int MIN_NAME_LENGTH =2;
    public final static int MIN_SURNAME_LENGTH =4;
    
    // Constantes → Valores predeterminados para los atributos

    public final static String DEFAULT_NAME = "Fernando" ;
    public final static String DEFAULT_SURNAME = "Alonso" ;
    public final static int DEFAULT_AGE = 44 ;
    public final static boolean DEFAULT_GENDER= GENDER_MALE;
    
    //Atributos
    private String name; 
    private String surname;
    private int age;
    private boolean gender; //Genero masculino=true; false=femenino
    
    //Contructores (Completo de parametros 4/por defecto/ Solo para la edad / Nombre edad y genero / Nombre y apellido
    /**
     * Constructor completo con todos los parametros
     * @param name, nombre de la persona
     * @param surname, apellido de la persona
     * @param age, edad de la persona
     * @param gender, genero de la persona
     */
    public Person(String name, String surname, int age, boolean gender) {   
     setName(name);
     setSurname(surname);
     setAge(age);
     setGender(gender);
    } 
    /**
     * Constructor con los valores default para los objetos de la clase Person.
     */
    public Person() {   
     this(DEFAULT_NAME, DEFAULT_SURNAME, DEFAULT_AGE, DEFAULT_GENDER);
    }
    /**
     * Constructor para la edad de la clase Person.
     * @param age la edad con la que se va a construir el objeto
     */
    public Person(int age) {   
     this(DEFAULT_NAME, DEFAULT_SURNAME, age ,DEFAULT_GENDER);     
    }
    /**
     * Constructor para el nombre, edad y genero de la clase Person.
     * @param name nombre con la que se va a construir el objeto
     * @param age edad con la que se va a construir el objeto
     * @param gender género con la que se va a construir el objeto
     */
    public Person(String name, int age, boolean gender){
        this(name,DEFAULT_SURNAME, age ,gender);
    }
    /**
     * Constructor para el nombre y apellido de la clase Person.
     * @param name nombre con la que se va a construir el objeto
     * @param surname apellido con la que se va a construir el objeto
     */
    public Person(String name, String surname){
        this(name,surname, DEFAULT_AGE,DEFAULT_GENDER);
    }
    
    
    //Setters de los atributos
    /**
     * Cambia el valor del atributo nombre por uno dado como parámetro, siempre que no sea null.
     * @param name Sustituye el antiguo valor del atributo nombre.
     */
    private void setName (String name) {
        checkParam(name != null,"Nombre Ilegal");
        this.name=name; 
    }
    /**
     *
     * Reemplaza el valor de atributo surname por otro dado como parámetro. 
     * @param surname Sustituye el antiguo valor del atributo surname
     */
    private void setSurname (String surname){
       checkParam(surname != null,"Apellido Ilegal");
       this.surname=surname;
    }    
    /**
     * Cambia el valor del atributo edad por uno nuevo dado como parametro siempre que este en el rango establecido     
     * @param newAge nuevo valor para la edad de la persona
     */
    private void setAge (int age){
        checkParam(age > MIN_AGE && age < MAX_AGE,"Edad Ilegal");
        this.age=age;
    }
    /**
     * Cambia el valor del atributo gender por otro proporcionado como parámetro.
     * @param gender nuevo valor para el genero de la persona
     */
    private void setGender (boolean gender){
       this.gender=gender;
    }
    
    
    //Getters de los atibutos 
    /**
     * Devuelve el valor actual del atributo name.
     * @return String con el nombre almacenado en el atributo name.
     */
    public String getName(){
        return name;
    }
    /**
     *Devuelve el valor actual del atributo surname.
     * @return String con el apellido almacenado en el atributo surname.
     */
    public String getSurname(){
        return surname;
    }    
    /**
     * Devuelve el valor actual del atributo age. 
     * @return int con el valor de la edad almacenado en el atributo age.
     */
    public int getAge() {
        return age;
    }
    /**
     * Devuelve el valor actual del atributo gender.
     * @return boolean con el valor del género almacenado en el atributo gender.
     */
    public boolean getGender(){
        return gender;
    }
    
    
    //Metodos principales
    
    /**
     * Debuelve una cadena con informacion en el siguente formato. Ej: 44-FE-ALVA-ADULT 
     * @return string con el formato Ej: 44-FE-ALVA-ADULT 
     */
    public String getHashCode(){
        String stringName = shortenString(this.name, DEFAULT_INIT_INDEX, MIN_NAME_LENGTH);
        String stringSurname = shortenString(this.surname, DEFAULT_INIT_INDEX, MIN_SURNAME_LENGTH);
        return(this.age+"-"+
               stringName.toUpperCase()+"-"+
               stringSurname.toUpperCase()+"-"+
               this.ageClasifier());
    }
    /**
     * Devuelve un valor numerico en funcion de la edad actual.
     * - Si es menor de 18 años: devuelve los años que faltan para ser mayor de edad.
     * - Si tiene entre 18 y 64 años: devuelve los años que faltan para jubilarse (65 años).
     * - Si tiene 65 o más: devuelve los años que han pasado desde la jubilación.
     *@return int el numero de años segun la edad actual.
     */
    public int getCriticalAge(){
        if (age <ADULTHOOD_AGE){
            return (ADULTHOOD_AGE-age);
        } else {
            if (age<RETIREMENT_AGE){
                return (RETIREMENT_AGE-age);
            } else{
                return (age-RETIREMENT_AGE);
            }
        }
    }
    /**
     * Primero muestra una String con el siguiente formato: Mi edad es X pero el año que viene tendré x+1 años
     * Luego muestra la representacion de la información devuelta por el metodo toString.
     */
    public void print() {
        System.out.println("Mi edad es "+ getAge() + " pero el año que viene tendré "+(getAge()+1)+" años");
        System.out.println(toString());
    }

    /**
     * Crea una representación de la información del objeto con el siguiente formato: NOMBRE-apellido-edad-masculino (o femenino)
     * @return Devuelve la String con el formato anterior 
     */
    public String toString(){
        String sGender;
        if (getGender()==true){
            sGender="Masculino";
        } else{
            sGender="Femenino";
        }
        return getName().toUpperCase()+"-"+getSurname()+"-"+getAge()+"-"+sGender;

    }
    
    
    
    //Metodos auxiliares
    /**
     * Si la cadena es suficentemente larga y el indice final es mayor que el inical, devuelve una subcadena en funcion a los parametros
     * @param cadena Cadena a obtener la subcadena
     * @param initIndex Valor inicial para obtener la subcadena
     * @param finalIndex Valor final para obtener la subcadena
     * @return String Subcadena en fuicnion a los parametros
     */
    public String shortenString(String cadena, int initIndex, int finalIndex){
        checkParam(initIndex<finalIndex, "El indice inicial (segundo parametro) ha de ser menor al indice final(tercer parametro)");
        int length = finalIndex-initIndex;
        checkParam(cadena.length()>=length, "La longitud de la cadena es demasiado corta");
        return cadena.substring(initIndex, finalIndex);     
    }
    /**
     * Clasifica en funcion al gupo de edad. 
     * - Si es menor de 18 años devuelve "CHILD"
     * - Si tiene entre 18 y 64 años devuelve "ADULT"
     * - Si tiene 65 años o más devuelve "RETIRED"
     */
    private String ageClasifier(){
        if (age <ADULTHOOD_AGE){
            return "CHILD";
        } else {
            if (age<RETIREMENT_AGE){
                return "ADULT";
            } else{
                return "RETIRED";
            }
        }
    }
    /**
     * Comprueba si un parámetro tiene sentido dentro del campo correspondiente, en caso contrario corta la ejecucion y muestra un mensaje
     * @param condition, la condición que el parametro tiene que cumplir
     * @param message, el mensaje mostrado en el caso de que no se cumpla la condición.
     */
    private void checkParam(boolean condition, String message){
        if(!condition){
            throw new RuntimeException(message);
        }
    }
}
