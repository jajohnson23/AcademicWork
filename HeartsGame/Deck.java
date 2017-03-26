/**
 * CSC 116 Intro to Programming
 * Instructor Mike Winters
 * TA Matt Witte
 *
 * Project 6 - Deck for Hearts Game
 * A class containing array of Card objects 
 * performing some actions on those objects
 * @author Jo Johnson
 */
import java.util.*;
public class Deck {
	
	public Card [] deck;
	
	/**
	 * Private instance field to hold seed for shuffle the cards.
	 */
	private int seed = -1;
	/**
	 * Private instance field to hold the location of the next card.
	 */
	private int next = -1;
	
	/**
	 * declares a constant for the number of cards in a deck
	 */
	public static final int CARDS_IN_DECK = 52;
	/**
	 * declares a constant for the number of cards in a suit
	 */
	public static final int CARDS_IN_SUIT = 13;
	/**
	 * declares a constant for the number of suits in a deck
	 */
	public static final int NUMBER_OF_SUITS = 4;
	/**
	 * declares a constant for the number of times cards 
	 * should switch positions in a deck when shuffled
	 */
	public static final int SHUFFLE_SWAPS= 500;
	/**
	 * used only for testing, prints results out when calling functions/methods of Card
	 */
	public static void main (String [] args) {
		Deck myDeck;
		myDeck = new Deck(0);
		System.out.println (myDeck.toString());
		myDeck.shuffle();
		System.out.println (myDeck.toString());
		myDeck = new Deck(1);
		myDeck.shuffle();
		System.out.println (myDeck.toString());
		//System.out.println ("The location of the Ace of Spades: " + );
		myDeck = new Deck(4);
		myDeck.shuffle();
		System.out.println (myDeck.toString());
		myDeck = new Deck(4);
		myDeck.shuffle();
		System.out.println (myDeck.toString());
		
	}
	/**
	 * This is the constructor of the Deck class. 
	 * It initializes an array of Card objects to hold 52 cards 
	 * using the class constant "CARDS_IN_DECK".
	 * array initialized, it goes through the array one element at a time
	 * and actually creates a Card object. 
	 * All cards are created (values 2-14 for each of the four suits), with no duplicates
	 * The seed parameter is stored in the instance field for the seed.
	 * 
	 * @param seed a command line parameter, an integer that seeds the Random deck dealt
	 */
	public Deck(int seed) {   
		deck = new Card[CARDS_IN_DECK];
		int cardCount = 0;
		char suitNow;
		String suits = "cdhs";
		for (int i = 0; i < NUMBER_OF_SUITS; i++){
			suitNow = suits.charAt(i);
			for  (int j = 0; j < CARDS_IN_SUIT; j++)  {
				deck[cardCount] = new Card (j + 2, suitNow);
				cardCount++;
			}
		}
		this.seed = seed;
		
	}
	/**
	 * handles resetting the deck for a new hand to be played
	 * first is resets each card so that it has not been played yet
	 * it uses a loop that goes through each index in the array
	 * of Card objects, and call the appropriate method from the
	 * Card class to reset its status to not having been played yet
	 *
	 * it then handles shuffling the deck by using the Random class to generate
	 * two integers between 0-51  Then swaps the cards at those two positions.
	 * For example, if the random numbers are 20 and 11, and the 2 of Clubs
	 * is in element 20 of the array and the 3 of Hearts is in element 11 of the array
	 * after these two cards are swapped element 20 will hold the 3 of Hearts
	 * and element 11 will hold the 2 of Clubs.
	 * it will repeat this process of generating two numbers and swapping the cards
	 * in the corresponding locations for as many times as the class constant
	 * "SHUFFLE_SWAPS" indicates that you should.
	 * If the random seed is not -1, the Random object created will use the provided random seed.
	 * This will ensure that the deck will be shuffled the same way every
	 * time you run the program with the same random seed. For example,
	 * Random rand = new Random(seed);
	 * If the random seed is -1, then create a Random object with no seed,  
	 * which will create a different game every time you play. For example,
	 * Random rand = new Random();
	 * Finally, your instance field that knows which index in your array of 
	 * cards that should be used next must be reset to 0. 
	 * @param seed an integer to initiate a particular shuffle, will be random for seed = -1
	 */
	public void shuffle() {   
		for (int i = 0; i < CARDS_IN_DECK; i++) {
			deck[i].setPlayed(false);
		}
		
		Random rand;
		if (this.seed == -1) {
			rand = new Random();
		}else{
			rand = new Random(this.seed);
		}
		
		for (int i = 0; i < SHUFFLE_SWAPS; i++)	{
			int cardIndex2 = rand.nextInt(CARDS_IN_DECK);
			int cardIndex1 = rand.nextInt(CARDS_IN_DECK);
			int tempValue = deck[cardIndex1].getValue();
			char tempSuit = deck[cardIndex1].getSuit();
			deck[cardIndex1] = deck[cardIndex2];
			deck[cardIndex2] = new Card (tempValue, tempSuit);
		}
		this.next = 0;
    }
	/**
	 * This method returns the next card in the deck based on the instance
	 * field that knows the position within the array where the next card
	 * to be dealt is located. Before returning the card, it updates
	 * this number so that the next time the method is called,
	 * the next card in the deck will be returned (increase it by 1).
	 * 
	 * @return a Card - the next card in the deck
	 */
	public Card nextCard() {
		Card nextValue = deck[this.next];
		if (this.next < CARDS_IN_DECK) {
			this.next ++;
		}
		return nextValue;
	}	
	/**
	 * This method returns a String representation of the Deck which will come in handy
	 * for Unit Testing. HINT: call the toString() method of the Card
	 * class for each Card in the array of Card objects.
	 * 
	 * @return The array of cards as a string
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < CARDS_IN_DECK; i ++) {
			s += (deck[i].toString());
			if (i > 0 && (i + 1) % 4 == 0) {
				s += "\n";
			} else {
				s+= "\t";
			}
		}
		return s;
	}
}