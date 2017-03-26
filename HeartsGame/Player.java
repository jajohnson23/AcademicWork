import java.util.Arrays;
import java.util.Random;

public class Player {
	/**
	 * declares a constant for the number of cards in a hand
	 */
	 public static final int CARDS_IN_HAND = 13;
	/**
	 * declares an instance field for the player's name
	 */
	 private String name = "";
	/**
	 * declares an instance field for the overall points
	 */
	 private int overAllPoints;
	/**
	 * declares an instance field for the points for the hand
	 */
	 private int handPoints;
	/**
	 * declares an instance of an array of the cards in the player's hand
	 */
	 private Card [] hand;
	/**
	 * declares an instance field for next card in the deck array
	 */
	 private int next;
	/**
	 * declares an instance field for the seed integer
	 */
	 private int seed;
	/**
	 * This method returns the card that a computer player will use in the
	 * current round which is determined based on the starting card, whether or
	 * not it is the first round of a hand, and if hearts have been started in
	 * the hand.
	 * 
	 * @param startingCard
	 *            The card that started the round
	 * @param isFirstRound
	 *            Whether or not this is the first round of a hand
	 * @param heartsStarted
	 *            Whether or not hearts are in play at this point of the hand
	 * @return The card that will be played
	 */
	public Card getMove(Card startingCard, boolean isFirstRound,
			boolean heartsStarted) {
		// System.out.println("---\n" + startingCard + "\nFR: " + isFirstRound +
		// "\nHS: " + heartsStarted);
		Random rand = null;
		if (seed != -1) {
			rand = new Random(seed);
		} else {
			rand = new Random();
		}

		if (isFirstRound && startingCard == null
				&& hand[0].getSuit() == Card.CLUBS && hand[0].getValue() == 2) {
			// if this is the opening hand and you have the 2 of Clubs, you must
			// play it
			hand[0].setPlayed(true);
			return hand[0];
		} else if (startingCard != null) {
			// we must follow the suit of the initial card, if one was played at
			// this point
			int currentSuit = startingCard.getSuit();

			for (int i = 0; i < CARDS_IN_HAND; i++) {
				if (!hand[i].hasBeenPlayed()
						&& hand[i].getSuit() == currentSuit) {
					hand[i].setPlayed(true);
					return hand[i];
				}
			}
			// if we didn't have any cards in that suit, we will just choose one
			// at random
		}

		// if we have the queen of spades, we want to play it right away.
		if (startingCard != null && !isFirstRound) {
			for (int i = 0; i < CARDS_IN_HAND; i++) {
				if (hand[i].getSuit() == Card.SPADES
					&& hand[i].getValue() == Card.QUEEN_VALUE && !hand[i].hasBeenPlayed()) {
					hand[i].setPlayed(true);
					return hand[i];
				}
			}

			for (int i = CARDS_IN_HAND - 1; i >= 0; i--) {
				if (hand[i].getSuit() == Card.HEARTS
						&& !hand[i].hasBeenPlayed()) {
					hand[i].setPlayed(true);
					return hand[i];
				}
			}
		}

		// just play a random card from the hand
		boolean invalid = true;
		int index = 0;
		while (invalid) {
			index = rand.nextInt(CARDS_IN_HAND);
			invalid = hand[index].hasBeenPlayed();
			if (!invalid) {
				if (isFirstRound
						&& ((hand[index].getSuit() == Card.HEARTS) || (hand[index]
								.getSuit() == Card.SPADES && hand[index]
								.getValue() == Card.QUEEN_VALUE))) {
					invalid = true;
				} else if (!onlyHasHearts()
						&& hand[index].getSuit() == Card.HEARTS
						&& !heartsStarted) {
					invalid = true;
				}
			}
		}

		hand[index].setPlayed(true);
		return hand[index];
	}

	/**
	 * This method sorts the player's hand so that it is in the correct order to
	 * start out
	 */
	public void sortHand() {
		Arrays.sort(hand);
	}
	/**
	 * This is the constructor of the Player class. The instance field that knows
	 * the name of the player must be set equal to the value passed to the parameter
	 * It creates an array of Card objects with as many elements as the number
	 * in the class constant CARDS_IN_HAND dictates it should have.
	 * The seed parameter should be stored in the instance field for the seed.
	 * All other instance fields should be set to 0.
	 * 
	 */
	 public Player(String name, int seed) {   
		this.name = name;
		overAllPoints = 0;
		handPoints = 0;
		hand = new Card[CARDS_IN_HAND];
		next = 0;
		seed = seed;
	}
	/**
	 * This method adds a new card that has been dealt to the player from the deck
	 * and places it in the player's "hand".
	 * It must place the card in the next open position in the array of Cards.
	 * The instance field that knows the position within the array in which
	 * the next Card should be placed will be used for this.
	 * After you place the card in the array, you should add one to the instance
	 * field so that the next card will be placed in the next open element in the array.
	 * 
	 */	
	public void addCard(Card card) {
		hand[next] = card;
		next++;
	}
	/**
	 * This is the getter method for the instance field that knows the current number
	 * of points the player has obtained in the current hand. 
	 * It simply returns the instance field.
	 * 
	 * @return an integer value of the points in hand
	 */
	public int getHandPoints() {
		return handPoints;
	}
	/**
	 * This method updates the current number of points a player has obtained in the current hand.
	 * The amount passed to the parameter must be added to the instance field that knows
	 * the current number of points the player has obtained in the current hand.
	 * Be sure to also add these points to the integer variable that knows
	 * the player's overall score in the game of Hearts.
	 * 
	 */
	public void addToHandPoints(int points) {
		handPoints += points;
		overAllPoints += points;
	}
	/**
	 * This method resets the instance field that knows how many points the player
	 * has obtained in the current hand to 0
	 * (thus setting the player up for the next hand)
	 * 
	 */
	public void resetHandPoints() {
		handPoints = 0;
	}
	/**
	 * This is the getter method for the instance field that knows the current
	 * number of points the player has obtained across all hands
	 * played in the Hearts game. It simply returns the instance field.
	 * 
	 * @return the integer value of the overall points
	 */
	public int getOverallPoints()  {
		return overAllPoints;
	}
	/**
	 * This is the getter method for the instance field that knows
	 * the player's name. It simply returns the instance field.
	 *
	 * @return the String of the players name 
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method creates a String that represents the player's current
	 * status in the game and returns it.
	 * The players status consists of the player's name, a colon, a space,
	 * and their current points for the given hand.
	 * For example, a player named "John" who has 7 points for the 
	 * current hand would have a status of "John: 7".
	 * 
	 * @return a String containing  player's name, a colon, a space,
	 * and their current points for the given hand. 
	 */
	public String toString() {
		return name + ": " + handPoints; 
	}	
	/**
	 * This method simulates returning a player's cards back to the deck. 
	 * All it does is reset the instance field that knows the next
	 * position in the player's hand to place the next card dealt to 0.
	 * 
	 */
	public void dumpCards() {
		next = 0;
	}
	/**
	 * This method simply returns the card from the player's
	 * hand at the index specified by the parameter.
	 *
	 * @param index and integer representing the index of a card
	 * @return a Card of that index
	 */
	public Card getCard(int index) {
		return hand[index];
	}
	/**
	 * This method determines if the player contains a card in their hand of 
	 * a given that has not been played yet. If the player has such a card
	 * suit in their hand, this method returns true. If not, this method returns false. 
	 * This method is used to determine if a card may legally be played.
	 *
	 * @param suit a character representing the suit
	 * @return a boolean, true if the players hand contains that suit, otherwise false
	 */
	public boolean hasActiveCardOfSuit(char suit) {
		for ( int i = 0; i < hand.length; i++ ) {
			if ( hand[i] !=null && !hand[i].hasBeenPlayed() && hand[i].getSuit() == suit ){
				return true;
			}
		}
		return false;
	}
	/**
	 * This method determines if the cards that have not been played yet in the
	 * player's hand are made up entirely of Heart cards. If they are entirely Hearts
	 * (or all cards have been played), this method returns true.
	 * If there is even one card in the player's hand that has not been played yet 
	 * that is of a suit other than Hearts, this method must return false.
	 * that This method is also used to determine if a card may legally be played.
	 *
	 * @return a boolean, true if the players has all hearts or no cards, otherwise false
	 */
	public boolean onlyHasHearts() {	
		for ( int i = 0; i < hand.length; i++ ) {
			if ( hand[i] !=null && !hand[i].hasBeenPlayed() ) {
				if ( hand[i].getSuit() != Card.HEARTS ){
					return false;		
				}
			}
		}
		return true;
	}
	/**
	 * This method creates an array of String objects that has as many elements
	 * as the class constant CARDS_IN_HANDS dictates.
	 * Each element in the array of Strings is set equal to the String value 
	 * of the corresponding Card in the array of Cards, for example "c4".
	 *  
	 * The array of Strings is returned at the end of the method.
	 * This is used by the Graphical User Interface to show the appropriate cards 
	 * in a player's hand to the user.
	 * 
	 */
	public String[] getCardNames(){
		String[] cardsString = new String[CARDS_IN_HAND];
		for ( int i = 0; i < hand.length; i++ ) {
			if (hand[i] != null) {
				cardsString[i] = hand[i].toString();
			}
		}
		
		return cardsString;
	}	


}

