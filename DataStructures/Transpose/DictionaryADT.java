package Transpose;

/**
 * A class for the dictionary object
 * @author Joellyn Johnson, jajohn22
 */

import java.util.*;
import java.io.*;

public class DictionaryADT {
    /** integer representing the key for the dictionary object*/
    private int key;
    /**string of the value */
    private String value;
/**
* Constructs a dictionary entry from a string of the format <key><whitespace><value>. 
* This constructor throws an IllegalArgumentException if the string argument is not valid 
*       
* 
* 
* @param bookInfo a String containing <<key><whitespace><value>. 
*/
public DictionaryADT(String info) {
    
    try {
        Scanner in = new Scanner(info);
        int num = in.nextInt();
        String s = in.nextLine().trim();
        in.close();

        this.key = num;
        this.value= s;

    } catch (InputMismatchException e) {
            throw new IllegalArgumentException(info);
    }

}  
    /*
     * accessor for the key of a dictionaryADT object
     * @return the key integer for this object
     */
    public int getKey()
    {
        return this.key;
    }
       /*
     * accessor for the key of a dictionaryADT object
     * @return the key integer for this object
     */
    public String getValue()
    {
        return this.value;
    }
}
