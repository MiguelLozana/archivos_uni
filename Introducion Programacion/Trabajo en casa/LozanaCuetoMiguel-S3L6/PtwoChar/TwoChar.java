
/**
 * Write a description of class TwoChar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoChar
{
    /**
     * Constructor vacio
     */
    public TwoChar()
    {
    }
    /**
     * A partir de una cadena y un indice devuelve una cadena de lonitud 2
     * @param str, string de donde hay que sacar la subcaneda
     * @param index, int de donde empezar a sacar la subcadena
     * @return String la cadena de dos caracteres 
     */
    public String twoChar(String str, int index) {
        if (index < 0 || index > str.length() - 2) {
            return str.substring(0, 2);
        } else {
            return str.substring(index, index + 2);
        }
     }
}