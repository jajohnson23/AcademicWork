/**
 * CSC 116 Intro to Programming
 * Instructor Mike Winters
 * TA Matt Witte
 *
 * Project 6 - Card Class for a game of Hearts
 * for building objects that represent a card in a standard playing deck
 * @author Dan Longo
 * @author Jo Johnson
 */
 

public class Card implements Comparable {
	// class constants
	/**
	 * declares a char value that represents the suit "Clubs" set equal to 'c'
	 */
	public static final char CLUBS = 'c';
	/**
	 * declares a char value that represents the suit "Diamonds" set equal to 'd'
	 */
	public static final char DIAMONDS = 'd';
	/**
	 * declares a char value that represents the suit "Spades" set equal to 's'
	 */
	public static final char SPADES = 's';
	/**
	 * declares a char value that represents the suit "Hearts" set equal to 'h'
	 */
	public static final char HEARTS = 'h';
	/**
	 * declares a char value that represents the lowest numeric value for a card, set equal to 2
	 */
	public static final int LOWEST_VALUE = 2;
	/**
	 * declares a char value that represents the highest numeric value for a card, set equal to 14
	 */
	public static final int HIGHEST_VALUE = 14;
	/**
	 * declares a char value that represents the numeric value for a queen, set equal to 12
	 */
	public static final int QUEEN_VALUE = 12;
	// instance fields
	/** value of the card */
	private int value;
	/** suit of the card */
	private char suit;
	/** represents if the card been played */
	private boolean played;	
	/**
	 * used only for testing, prints results out when calling functions/methods of Card
	 */
		public static void main (String [] args) {
			Card a = new Card (5, 'h');
			Card b = new Card (14, 'h');
			Card c = new Card (12, 's');
			Card d = new Card (2, 'h');
			Card e = new Card (12, 'h');
			System.out.println (a.toString());
			System.out.println ("Is the " + a.toString() + " higher than the " + b.toString() + "? " + a.isHigherThan(b));
			System.out.println ("Is the " + b.toString() + " higher than the " + d.toString() + "? " + b.isHigherThan(d));
			System.out.println ("Is the " + b.toString() + " higher than the " + c.toString() + "? " + b.isHigherThan(c));
			System.out.println ("testing get suit and value on 2 of hearts value = " + d.getValue() + " suit = " + d.getSuit());
			System.out.println ("Has the " + a.toString() + " been played? " + a.hasBeenPlayed());
			System.out.println ("I set it to played");
			a.setPlayed(true);
			System.out.println ("Has the " + a.toString() + " been played? " + a.hasBeenPlayed());
			System.out.println ("Is the Queen of spades equal to  " + c.toString() + " ? " + c.isQueenOfSpades());
			System.out.println ("Is the Queen of spades equal to  " + b.toString() + " ? " + b.isQueenOfSpades());
			System.out.println ("Is the Queen of spades equal to  " + e.toString() + " ? " + e.isQueenOfSpades());
			System.out.println ("Is the " + a.toString() + " a heart? " + a.isHeart());
			System.out.println ("Is the " + c.toString() + " a heart? " + c.isHeart());
		}

	/**
	 * This is the constructor of the class.   
	 * It accepts a value and a suit to assign to the instance fields.
	 * Throw an IllegalArgumentException if the value and/or suit are not valid.
	 * The field that knows if the card has been played at this point should be set to false.
	 */
	public Card(int value, char suit)  {
		this.value = value;
		this.suit = suit;
		this.played = false;

	}

	/**
	 * This is the getter method for the instance field that  
	 * knows whether or not this card has been played yet.
	 * It returns the instance field.
	 * @return a boolean, true if it has been played, otherwise false
	 */
	public boolean hasBeenPlayed()  {
		return played;

	}
	/**
	 * This is the setter method for the instance field that knows 
	 * whether or not this card has been played yet.
	 * It sets the value of the instance field to the value that 
	 * was passed to the parameter.
	 */
	public void setPlayed(boolean played) { 
		this.played = played;
	}

	/**
	 * This is the getter method for the instance field that knows
	 * the suit of the card. It returns the instance field.
	 * @return a char representing the suit
	 */
	public char getSuit() {
		return suit;
	
	}

	/**
	 * This is the getter method for the instance field that knows
	 * the value of the card. It returns the instance field.
	 * @return an integer representation of the value
	 */
	public int getValue() {
		return value;
	}	

	/**
	 * This method returns true if the card is of the suit "Hearts"
	 * Otherwise, the method returns false.
	 * @return a boolean indicating if it a heart
	 */
	public boolean isHeart()  {
		if (this.suit == 'h') {
			return true;
		}
		return false;
	}

	/**
	 * This method returns true if this card is the Queen of Spades.
	 * Otherwise, the method returns false
	 * @return a boolean indicating if it is the queen of spades
	 */
	public boolean isQueenOfSpades() {
		if (this.suit == 's' && this.value == 12) {
			return true;
		}
		return false;
	}

	/**
	 * This method will be used at the end of each trick to determine
	 * if a Card is "higher" than another card. A card is higher than
	 * another card if it is of the same suit as the other card
	 * and has a higher numeric value. For example, a Jack of Diamonds 
	 * is higher than a 2 of Diamonds, but it is NOT higher than a 2 of Clubs.
	 * If this card is higher than the Card given as a parameter,
	 * this method returns true. If it is not, return false.
	 * @return a boolean indicating if the card is higher than the card passed
	 */
	public boolean isHigherThan(Card other) {
		if (this.suit == other.getSuit())  {
			if (this.value > other.getValue()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}


	/**
	 * This method returns the the first letter of the suit (lowercase)
	 * followed by the numeric value of the card.
	 * it put together a String based on the suit and value
	 * For example:   2 of Clubs - "c2", Jack of Hearts - "h11", Ace of Spades - "s14"
	 * at return a string representing the cards suit and value
	 */
	public String toString()    {
	
		return suit + Integer.toString(value);
	}
		
		
	/**
	 * This method is used for sorting the cards in a player's hand in a game of Hearts.
	 * @param o The Card object that this Card is being compared to.
	 * @return -1 if this Card should be before the other Card,
	 *          1 if this Card should be after the other Card.
	 */
	public int compareTo(Object o) {
	   if(o instanceof Card) {
		  Card other = (Card)o;

		  if (getSuit() == other.getSuit()) {
			 if (getValue() < other.getValue()) {
				return -1;
			 } else {
				return 1;
			 }
		  } else {
			 switch(getSuit()) {
				case HEARTS:
				   return 1;
				case SPADES:
				   if (other.getSuit() == HEARTS) {
					  return -1;
				   } else {
					  return 1;
				   }
				case DIAMONDS:
				   if (other.getSuit() == HEARTS || other.getSuit() == SPADES) {
					  return -1;
				   } else {
					  return 1;
				   }
				case CLUBS:
				   return -1;
			 }
		  }
	   }
	   return 1;
	}
}