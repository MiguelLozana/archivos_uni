
/**
 * Models a Person including (at least) his/her name, surname age and gender.
 * 
 * @author Miguel Lozana
 * @version 20250910
 */
public class Person 
{
    private String name; 
    private String surname;
    private int age;
    private boolean gender; //Genero masculino=true; false=femenino
    /**
     * Constructor for objects of class Person
     */
    public Person()
    {
        
        
    }
    
    /**
     * Replaces the value on the name field by another one provided as a parameter.
     * 
     * @param newName constraining the new value fpr the name field
     */
    public void setName (String newName)
    {
       name=newName; //replaces the value os name by one one
    }
    
    /**
     Replaces the value on the surname field by another one provided as a parameter.
     * 
     * @param newSurame constraining the new value fpr the surname field
     */
    public void setSurname (String newSurname)
    {
       surname=newSurname;
    }
    
    /**
     * Replaces the value on the age field by another one provided as a parameter.
     * 
     * @param newAge replaces the old value of age field
     */
    public void setAge (int newAge)
    {
       age=newAge;
    }
    
    /**
     * Replaces the value on the gender field by another one provided as a parameter.
     * 
     * @param newGender becomes the new valor for the gender field
     */
    public void setGender (boolean newGender)
    {
       gender=newGender;
    }
    
    
    
    
    
    
    /**
     * Returns the current value of the name field
     * @return String with the current value of the name field
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the current value of the surname field
     * @return String with the current value of the surname field
     */
    public String getSurname()
    {
        return surname;
    }
    
    /**
     * Returns the current value of the age field
     * @return int with the current value of the age field
     */
    public int getAge()
    {
        return age;
    }
    
    /**
     * Returns the current value of the gender field
     * @return boleean with the current value of the gender field
     */
    public boolean getGender()
    {
        return gender;
    }
    
}
