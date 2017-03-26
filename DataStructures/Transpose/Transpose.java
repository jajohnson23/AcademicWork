/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transpose;
import java.util.*;
import java.io.*;

/**
 *
 * @author Jo
 */
public class Transpose {
    /** The list of object with unique keys.*/
    private static LinkedListTranspose keyValues = new LinkedListTranspose();
    /** The list of object allowing duplicate keys*/
    private static LinkedListTranspose keys = new LinkedListTranspose();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner console = new Scanner (System.in); //create scanner
        Scanner inputFile = getInputScanner(console);
        PrintStream outputFile = getOutputScanner(console);  
        processFile (inputFile);
        lookUpKeys(keys, keyValues);
        keyValues.printToFile(outputFile);
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
//            String filename = console.nextLine();
            String filename = "Geometric-large.txt";
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
//            String filename = console.nextLine();
            String filename = "Geometric-largeOutTranspose.txt";
            try {
//                File checkFile = new File(filename);
//                if ( checkFile.exists() ) {
//                    char overWriteAction = getOverWriteInput(console);
//                    if ( overWriteAction == 'N' || overWriteAction == 'n') {
//                       continue; 
//                    }
//                }
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
     * process file reads each line of the file and through
     * a call to the DictionaryADT constructor it turns each line 
     * into a separate key and value object
     * it then calls the appropriate methods to add the objects to the lists.
     * @param input 
     */
    public static void processFile(Scanner input )
    {
//        int key;
//        String value;
        String nextLine = "";
        while(input.hasNextLine()){
            nextLine = input.nextLine();
            DictionaryADT newItem = new DictionaryADT (nextLine);
            keyValues.addToRear (newItem);
            keys.addToRearAllowDups(newItem);
        }   
        //input.close();
    } 
    /**
     * lookUpKeys i responsible for reading in all of the keys in the all keys list 
     * and looking them up on the unique keys list
     * @param listAllKeys a list of all the keys found in the file
     * @param listUniqueKeys a list containing just the unique keys
     */
    public static void lookUpKeys(LinkedListTranspose listAllKeys, LinkedListTranspose listUniqueKeys)
    {
        DictionaryADT temp;
        listAllKeys.resetIterator();
        try {
        while (listAllKeys.hasNext())
        {
            temp = listAllKeys.next();
            int num = temp.getKey(); 
            listUniqueKeys.lookUpTranspose (num);
        }
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException();
        }
    } 
}
