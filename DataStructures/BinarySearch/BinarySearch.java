/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinarySearch;
import java.util.*;
import java.io.*;

/**
 *
 * @author Jo
 */
public class BinarySearch {

    private static DictionaryADT[] keyValues = new DictionaryADT [2000];
    /**array for the list of all keys in the file, allowing duplicates
     * used for searching in lookUp */
    private static  int[] keys = new int [100000];
    /**a filed to hold the size of a list*/
    private static int size = 0;
    /**a filed to hold the size of a list*/
    private static int sizeKeys = 0;
    /** counters for num calls and num of compares
     and an array to keep track of the frequency of finds
     of each key*/
    private static int numCalls = 0;
    private static int numCompares = 0;
//    private static int [] counters = new int[10]; used to verify frequency of finds
    /**
     * main method creates scanners and printstream for file i/o
     * and calls the functions to process the input file 
     * and perform the lookUps
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner console = new Scanner (System.in); //create scanner
        Scanner inputFile = getInputScanner(console);
        PrintStream outputFile = getOutputScanner(console);  
        processFile (inputFile);
        lookUpKeys(keys, keyValues);
        printToFile(keyValues, outputFile);
    }
    
    /**
      * this method is called by userInterface to obtain valid user input for the input file name
      * input is a Scanner variable, initialized as empty until the user inputs a file name
      * the try catch block will cause the user to be re-prompted if they input an invalid file name
      * exception handled, not thrown
      *
      * @param console the Scanner passed from userInterface
      * @return input the valid input obtained (a valid, existing file)
     */
    public static Scanner getInputScanner(Scanner console){
	Scanner input = null;
	while (input == null) {
            System.out.print("Enter input file: ");
            String filename = console.nextLine();
//            String filename = "Geometric-large.txt"; //used for testing to hard code filenemas
            try {
                input = new Scanner(new File(filename));
            }
            catch (FileNotFoundException e) {
		System.out.println ("File not found.");	
            }
        }
	return input;  
    }
    
    /**
      * this method is called by main to obtain valid user input for the input file name
      * input is a Scanner variable, initialized as empty until the user inputs a file name
      * the try catch block will cause the user to be re-prompted if they input an invalid file name
      * exception handled, not thrown
      *
      * @param console the Scanner passed from main
      * @return input the valid input obtained (a valid, existing file)
     */
    public static PrintStream getOutputScanner(Scanner console){
        Scanner input = null;
        PrintStream outFile = null;
        while (input == null) {
            System.out.print("Enter output file: ");
            String filename = console.nextLine();
//            String filename = "Geometric-largeOut.txt";  //used in testing to hard code filenames
            try {
                outFile = new PrintStream(new File(filename));   
                break;
            }
            catch (FileNotFoundException e) {
                System.out.println ("File not found. Exiting program.");	
                break;
            }
        }
	return outFile;   
    }
   /**
    * processFile reads the input file line by line calling
    * the dictionaryADT constructor to create new objects from the 
    * string of input and making calls to add the items to the
    * unique key list and all keys list
    * 
    *
    * @param input a Scanner 
    */
    public static void processFile(Scanner input )
    {
        String nextLine = "";
        while(input.hasNextLine()){
            nextLine = input.nextLine();
            DictionaryADT newItem = new DictionaryADT (nextLine);
            addOrdered (keyValues, newItem);
            addToRearAllowDups(keys, newItem);
        }   
    } 
    /**
    * lookUpKeys iterates through the array of keys and
    * looks up each one by calling search, a binary search function
    * 
    * @param input a Scanner 
    */   
    public static void lookUpKeys(int[] listAllKeys, DictionaryADT[] listUniqueKeys)
    {
        DictionaryADT temp;
        try {
            for (int k = 0; k < sizeKeys; k++)
            {
                numCalls++;
                search (listAllKeys[k], listUniqueKeys);
//                if (numCalls % 1000 == 0)
//                    System.out.println(numCompares);
            }
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException();
        }
    } 
     /**
    * lookUpKeys iterates through the array of keys and
    * looks up each one by calling search, a binary search function
    * 
    * @param input a Scanner 
    */      
    private static DictionaryADT search(int i, DictionaryADT[] listUniqueKeys) {
        int lo = 0;
        int hi = size - 1;
        
        while (lo <= hi) {
//            numCompares++;
            // Key is in listUniqueKeys[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (i < listUniqueKeys[mid].getKey()) {
                hi = mid - 1;
                numCompares++;

            } else if (i > listUniqueKeys[mid].getKey()) {
                lo = mid + 1;
                numCompares+=2;

            } else {
                numCompares+=2;
                return listUniqueKeys[mid]; 
            }
        }
        return null;

    }
    /**
     * addOrdered adds the object in order 
     * if it does not already exist on the list
     * 
     * @param keyValues the array of key values without duplicates
     * @param newItem the object to be added
     */
    public static void addOrdered (DictionaryADT[] keyValues, DictionaryADT newItem)
    {

        if (keyValues[0] == null)
        {
            keyValues[0] = newItem;
            size++;
            return;
        }
        
        int k = 0;
        while (keyValues[k]!= null)
        {
            if (keyValues[k].getKey() == newItem.getKey()) {
                return;
            } else if (newItem.getKey() > keyValues[k].getKey()) {
                if (keyValues[k + 1] == null) {
                keyValues[k + 1] = newItem;
                size++;
                return;
                }
                k++;
                continue;
            } else {
                size++;
                insertInto(k,newItem, keyValues);
                break;            
            } 
        }
    }
    /**
     * insertInto uses recursion add the item to the spot and 
     * shift everything else up one
     * 
     * @param pos the spot to add it to on the list
     * @param keyValues the array of key values without duplicates
     * @param newItem the object to be added
     */
    private static void insertInto(int pos, DictionaryADT newItem, DictionaryADT[] keyValues )
    {
        DictionaryADT temp;
        if ( newItem == null)
            return;
        if ( pos >= keyValues.length)
            return;
        
        temp = keyValues[pos];
        keyValues[pos] = newItem;
        
        insertInto(pos + 1, temp, keyValues);
    }
    /**
     * addToRearAllowDupes adds an item to the list in the order it is received
     * and allows duplicate additions, it also increments the size of the keys list
     * each time one is added
     * @param keys the list of all of the keys in the file
     * @param newItem the item to be added
     */
    private static void addToRearAllowDups(int[] keys, DictionaryADT newItem) {
        keys[sizeKeys] = newItem.getKey();
        sizeKeys++;

    }
    /**
     * printToFule takes in a list of dictionaryADT and prints them
     * in the format <key><4spaces><value>
     * @param keyValues the list of unique keys with their values
     * @param outputFile the Printsteam passed to use for writing to file
     */

    private static void printToFile(DictionaryADT[] keyValues, PrintStream outputFile) {
        for (int k = 0; k < size; k++)
        {
            String s = "";
            s += keyValues[k].getKey();
            s += "    ";
            s += keyValues[k].getValue();
            outputFile.println(s);
        }
    }
        /**	
    * Returns true if the list contains no elements.
    * @return boolean false if there are elements, otherwise true
    **/

    public boolean isEmpty() {
        if (size > 0)
            return false;
        return true;
    }
}
