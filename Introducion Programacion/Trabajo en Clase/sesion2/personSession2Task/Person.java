
/**
 * Models a Person including (at least) his/her name, surname age and gender.
 * 
 * @author Miguel Lozana
 * @version 20250910
 */
public class Person {
    public final static int MIN_AGE=0;
    public final static int MAX_AGE=120;
    
    private String name; 
    private String surname;
    private int age;
    private boolean gender; //Genero masculino=true; false=femenino
    
    /**
     * Constructor for objects of class Person
     */
    public Person() {   
     //name="Fernando";
     //surname="Alonso";
     //age=44;
     //gender=true;
     setName("Fernando");
     setSurname("Alonso");
     setAge(44);
     setGender(true);
    }
    
    /**
     * Replaces the value on the name field by another one provided as a parameter.
     * 
     * @param newName constraining the new value fpr the name field
     */
    public void setName (String newName) {
        checkParam(newName !=null,"Nombre Ilegal");
        name=newName; //replaces the value os name by one one
    }
    
    /**
     Replaces the value on the surname field by another one provided as a parameter.
     * 
     * @param newSurame constraining the new value fpr the surname field
     */
    public void setSurname (String newSurname){
       checkParam(newSurname !=null,"Apellido Ilegal");
       surname=newSurname;
    }
    
    /**
     * Cambia el valor de la edad por uno nuevo 
     * 
     * @param newAge nuevo nombre para la edad de la persona
     */
    public void setAge (int newAge){
        //if(newAge>=0){
        //    age=newAge;
        //    
        //}else{
        //    throw new RuntimeException("Edad ilegal");
        //}
        checkParam(newAge>=MIN_AGE && newAge<MAX_AGE,"Edad Ilegal");
        age=newAge;
    }
    
    /**
     * Replaces the value on the gender field by another one provided as a parameter.
     * 
     * @param newGender becomes the new valor for the gender field
     */
    public void setGender (boolean newGender){
       gender=newGender;
    }
    
    
    
    
    
    
    /**
     * Returns the current value of the name field
     * @return String with the current value of the name field
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the current value of the surname field
     * @return String with the current value of the surname field
     */
    public String getSurname(){
        return surname;
    }
    
    /**
     * Returns the current value of the age field
     * @return int with the current value of the age field
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Returns the current value of the gender field
     * @return boleean with the current value of the gender field
     */
    public boolean getGender(){
        return gender;
    }
    
    /**
     * comprueba si un parametro tiene sentido dentro del campo correspondiente
     * @param condition, la condicion que el parametro tiene que cumplir
     * @param message, el mensaje mostrado en el caso de que no se cumpla la condicion
     */
    private void checkParam(boolean condition, String message){
        if(!condition){
            throw new RuntimeException(message);
        }
    }
    
    public void print() {
        System.out.println("Mi edad es "+ getAge() + " pero el año que viene tendré "+(getAge()+1)+" años");
        System.out.println(toString());
    }
    
    /**
     * Calcula una representacion de la informaciond el objeto con el siguente forrmato: nombre-apellido-edad-maculino (o femenino)
     * @return Un valor calculado segun lo esxpuesto anteriormente 
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
}
