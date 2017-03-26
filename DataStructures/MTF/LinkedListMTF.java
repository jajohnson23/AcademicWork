package mtf;

////**

import java.io.PrintStream;


// * This class provides implementation of a linked list that will 
// * have methods to add items to a list, check isEmpty, remove items, 
// * and move items to the front of the list
// * @author Joellyn Johnson (jajohn22)
// * Summer 2015
// *
// */
public class LinkedListMTF {

    /** points to the front of the list*/
    Node head;
    /** can traverse through the list elements*/
    Node iter;
    /**a filed to hold the size of a list*/
    private int size = 0;
    /**counters for analysis*/
    private int numCalls = 0;
    private int numCompares = 0;
    private static int [] counters = new int[10];
    
    /**
     * This is a nested class to create the nodes for the list
     * @author Jo Johnson
     *
     */
    private class Node {
            public DictionaryADT data;
            public Node link;
            public Node (DictionaryADT data, Node link) {
                    this.data = data;
                    this.link = link;
            }
    }

    /**
     * Constructs an empty list.
     */
    public LinkedListMTF() {
            head = null;
            iter = head;
            size = 0;
    }

    /**
     * Adds an element (second parameter) at the given position. 
     * Throws a NullPointerException if the item is null. 
     * Throws an IndexOutOfBoundsException if the position is 
     *   negative or greater than the list size.
     *   
     * @param pos the position at which the element is to be added
     * @param item the element is to be added
     */
    public void addItem(int pos, DictionaryADT item) {
        if (item == null)
                throw new NullPointerException();
        if (pos < 0 || pos > size())
                throw new IndexOutOfBoundsException();
        if (pos == 0) {
                //add to front of list
                head = new Node(item, head);
        } else {
            //inserting into an existing list
            Node current = head;
            //stop BEFORE index to add at
            for (int i = 0; i < pos - 1; i++) {
                    current = current.link;
            }
            current.link = new Node(item, current.link);
        }
        this.resetIterator();
        size++;	
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

     /**
     *  Returns the element at the given position. 
     *  Throws an IndexOutOfBoundsException if the position is negative or 
     *    greater than or equal to size.
     * @param key - the key of the dictionary object being searched for
     * @return the data at that position
     */	
    public DictionaryADT lookUpMTF(int key) {
        numCalls++;
        DictionaryADT found = null;
        int i; //loop counter and/or position found
        Node current = head;
        //iterates through looking for a key match
        for (i = 0; i < size; i++) {
            numCompares++;
            if (current.data.getKey() == key)
            {
                moveToFront (i, current.data );
                found = current.data;
                
                return found;
            }
            current = current.link;
        }
        return found;	
    }

  
   /**
     * Adds an element to the rear of the list. 
     * Throws a NullPointerException if the item is null.
     * 
     * @param item the object to be added to the rear of the list
     */
    public void addToRearAllowDups(DictionaryADT item) {
        if (item == null)
            throw new NullPointerException();
        
        if (head == null){
            head = new Node(item, head);
        } else {
            Node current = head;
            while (current.link != null) {
                current = current.link;
            }
            current.link = new Node (item, current.link);
        }
        this.resetIterator();
        size++;
    }
    
     /**
     * Adds an element to the rear of the list. 
     * Throws a NullPointerException if the item is null.
     * 
     * @param item the object to be added to the rear of the list
     */
    public void addToRear(DictionaryADT item) {
        if (item == null)
            throw new NullPointerException();
        
        if (head == null){
            head = new Node(item, head);
        } else {
            Node current = head;
            while (current.link != null) {
                if (current.data.getKey() == item.getKey() 
                        || current.link.data.getKey() == item.getKey())
                return;
                current = current.link;
            }
            current.link = new Node (item, current.link);
        }
        this.resetIterator();
        size++;
    }
     /**
      * Removes and returns the element in the given position. 
      * Throws an IndexOutOfBoundsException if the position is 
      *   negative or greater than or equal to size.
      * 
      * @param pos the integer representing the position in the list
      * @return T the object removed from list
      */
    public DictionaryADT remove(int pos) {
        if (pos < 0 || pos >= size())
            throw new IndexOutOfBoundsException();
        DictionaryADT temp;
        if (head == null) {
            return null;
        }
        if (pos == 0) {
            temp = head.data;
            head = head.link;
        } else {
            Node current = head;
            int i = 0;
            while (current.link != null && i < pos - 1) {
                    current = current.link;
                    i++;
            }
            if (current.link == null) {
                    throw new IndexOutOfBoundsException();
            }
            temp = current.link.data;
            current.link = current.link.link;
        }
        this.resetIterator();
        size--;
        return temp;

    }

    /**
     * Moves the element at the given position ahead one position in the list. 
     * Does nothing if the element is already at the front of the list. 
     *    Throws an IndexOutOfBoundsException if the position is negative 
     *    or greater than or equal to size.
     *    
     * @param pos the integer representing the position in the list 
     */
    public void moveAheadOne(int pos) {
        if (pos < 0 || pos >= size())
                throw new IndexOutOfBoundsException();
        if (pos == 0)
                return;
        DictionaryADT temp = this.remove(pos);
        this.addItem(pos - 1, temp);
    }

    /**
     * Moves the element at the given position to the front of the list. 
     * Does nothing if the element is already at the front of the list. 
     *    Throws an IndexOutOfBoundsException if the position is negative 
     *    or greater than or equal to size.
     *    
     * @param pos the integer representing the position in the list 
     * @param item the dictionary item
     */
    public void moveToFront(int pos, DictionaryADT item) {
        if (pos < 0 || pos >= size())
            throw new IndexOutOfBoundsException();
        if (pos == 0)
            return;
        //TODO add lines to remove and addTo front
        remove(pos);
        addItem (0, item);
//		for (int k = pos; k > 0; k--){
//			moveAheadOne (k);
//		}
    }
 
    
    /**
     * Returns the number of elements in the list.
     * 
     * @return size the number of elements in the list
     */
    public int size() {
            return size;

    }

    /**
     * True whenever iterator is pointing to a list element.
     * 
     * @return true if the iterator is pointing to an item, otherwise false
     */
    public boolean hasNext() {
            if ( iter == null )
                return false;
            return true;
    }
    /**
     * Returns the element iterator is pointing to and moves iterator to point 
     * to the next element in the list. Throws a NoSuchElementException 
     * if iterator is null or not pointing to a list element. 
     * 
     * @return n the  object in the list
     */
    public DictionaryADT next() {
            if (!hasNext())
                    throw new NullPointerException();
            DictionaryADT temp = iter.data;
            iter = iter.link;
            return temp;
    }
    /**
     * resets the iterator back to the head
     */
    public void resetIterator() {
            this.iter = head;
    }
    public void printToFile(PrintStream output)
    {
        Node current = head;
        for (int k = 0; k < size; k++) {
            String s = "";
            s += current.data.getKey();
            s += "  ";
            s += current.data.getValue();
            output.println(s);
            current = current.link;
        }                 
    }

}

