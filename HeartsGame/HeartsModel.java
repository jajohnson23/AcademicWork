import java.util.Arrays;

/**
 * Provides the "model"/logic for playing the game of Hearts
 * @author Dan Longo
 * @author YOUR NAME HERE
 */
public class HeartsModel {

	//Class Constants Declare and initialize the following public static class constants:
	/**
	 * declares the number of players in the game, set to 4.
	 */
	public static final int NUM_PLAYERS = 4; 
	/**
	 * declares the number of cards that are played in a single trick, set to 4.
	 */
	public static final int CARDS_IN_TRICK =4; 
	/**
	 * declares the number of players in the game, set to 4.declares the score that 
	 * when a player reaches it, the game will end. This is set to 100.
	 */
	public static final int MAX_SCORE = 100; 
	/**
	 * declares the index within the array of Player objects (see Instance Fields below) 
	 * that the human player resides, set to 0.
	 */
	 public static final int HUMAN_PLAYER = 0;   
	/**
	 * declares the number of points a player receives for winning a Heart card, which is 1 point.
	 */
	 public static final int HEART_VALUE = 1;   
	/**
	 * declares the number of points a player receives for winning the Queen of Spades, which is 13 points.
	 */
	 public static final int QUEEN_SPADES_VALUE  = 13;   
	/**
	 * declares the number of points a player must earn in a single hand in order to have shot the moon. 
	 * It is equal to the number of Heart cards in the deck times the value of a single heart card, 
	 * plus the value of the Queen of Spades.
	 */
	 public static final int MOON_SCORE = 13 * HEART_VALUE + QUEEN_SPADES_VALUE;
	 //Instance Fields   Declare the following instance fields using the names provided below:
	/**
	 * declares instance for the deck of cards that will be used to play the game.
	 */
	private Deck deck;
	/**
	 * declares instance for the array of Player objects that represents the four players in the game.
	 */
	 private Player[] players; 
	/**
	 * declares instance for an array of Card objects that represents the four cards that 
	 * have been played in the current trick.
	 */
	 private Card [] cardsPlayedInTrick;
	/**
	 * declares instance for the integer that keeps track of the index within the players 
	 * array of the player whose turn it currently is in the game.
	 */
	private int turn; 
	/**
	 * declares instance for an integer keeps track of the index within the players array of 
	 * the player who started the trick.
	 */
	private int whoStartedTrick;
	/**
	 * declares instance for an String represents the current status of the game, which is either 
	 * a message indicating whose turn it is or who won the current trick and how many points they received.
	 */
	private String status;
	/**
	 * declares instance for an boolean variable tells if it is the first turn of the current trick.
	 */
	private boolean isFirstTurn; 
	/**
	 * declares instance for an integer knows how many tricks have been played in the current hand.
	 */
	private int tricksPlayed;
	/**
	 * declares instance for an boolean variable knows if hearts have been played in the current hand.
	 */
	private boolean heartsStarted;
	/**
	 * declares instance for an String holds the current error message to be displayed in the GUI.
	 */
	private String errorMessage;

	/**
	 * declares instance for an is the constructor, where the deck and players are created, and the
	 * instance variables pertinent to the gameplay are initialized
	 * @param playerName human player's name
     * @param seed seed for Random Number Generator, 
	 *             if -1, the Random Number Generator is
	 *             created without providing a seed.
	 */
	public HeartsModel(String playerName, int seed) {
		deck = new Deck(seed);
		players = new Player[NUM_PLAYERS];

		players[HUMAN_PLAYER] = new Player(playerName, seed);

		status = "Initializing";
		cardsPlayedInTrick = new Card[NUM_PLAYERS];

		for (int i = HUMAN_PLAYER + 1; i < NUM_PLAYERS; i++) {
			players[i] = new Player("Computer " + i, seed);
		}

		isFirstTurn = true;
		turn = 0;
		whoStartedTrick = 0;
		tricksPlayed = 0;
		heartsStarted = false;
		errorMessage = "";
	}

	/**
	 * This method handles sorting the cards of each player's hand
	 */
	public void sortHands() {
		for (int i = 0; i < NUM_PLAYERS; i++) {
			players[i].sortHand();
			System.out.println(Arrays.toString(players[i].getCardNames()));
		}
	}

	/**
	 * This method determines if the moon has been hit, and if so, updates the
	 * scores of each player appropriately
	 */
	public void checkForMoon() {
		boolean hitMoon = false;
		int hitter = -1;

		for (int i = 0; i < NUM_PLAYERS; i++) {
			if (players[i].getHandPoints() == MOON_SCORE) // player has hit the
															// moon
			{
				hitMoon = true;
				hitter = i;
				players[i].addToHandPoints(-1 * MOON_SCORE);
				break;
			}
		}

		if (hitMoon)
			for (int i = 0; i < NUM_PLAYERS; i++) {
				if (i != hitter) {
					players[i].addToHandPoints(MOON_SCORE);
				}

			}
	}

	/**
	 * This method evaluates the four cards that have been played in a trick and
	 * determines who had the highest card based on the first card played and
	 * returns the index of which player it was
	 * 
	 * @return The index of which player took the cards from the last trick
	 */
	public int evaluateTrickCards() {
		int points = 0;

		Card highest = cardsPlayedInTrick[whoStartedTrick];

		if (highest.isHeart()) {
			points = HEART_VALUE;
		} else if (highest.isQueenOfSpades()) {
			points = QUEEN_SPADES_VALUE;
		}

		int winner = whoStartedTrick;

		for (int i = 1; i < NUM_PLAYERS; i++) {
			int checkNext = (whoStartedTrick + i) % NUM_PLAYERS;

			if (cardsPlayedInTrick[checkNext].getSuit() == Card.HEARTS) {
				points += HEART_VALUE;
			} else if (cardsPlayedInTrick[checkNext].getSuit() == Card.SPADES
					&& cardsPlayedInTrick[checkNext].getValue() == 12) {
				points += QUEEN_SPADES_VALUE;
			}

			if (cardsPlayedInTrick[checkNext].isHigherThan(highest)) {
				highest = cardsPlayedInTrick[checkNext];
				winner = checkNext;
			}
		}

		whoStartedTrick = turn = winner; // setup for the next trick

		// System.out.println("The person taking the cards this trick is " +
		// players[winner].getName());
		status = players[winner].getName() + " takes the cards and receives "
				+ points + " points.";
		players[winner].addToHandPoints(points);

		isFirstTurn = false;
		removePlayedCards();
		tricksPlayed++;
		return winner;

	}

	/**
	 * This method determines if a human user's desired move is acceptable or if
	 * it breaks a rule.
	 * 
	 * @param index
	 *            The index in the player's hand that represents the Card they
	 *            wish to play
	 * @return Whether or not the card desired is an acceptable move
	 */
	public boolean isAcceptableMove(int index) {
		Card temp = players[HUMAN_PLAYER].getCard(index);

		// we must determine if the player's card matches the suit of the
		// starting card
		if (whoStartedTrick == HUMAN_PLAYER) {
			if (isFirstTurn
					&& (temp.getSuit() != Card.CLUBS || temp.getValue() != 2)) {
				errorMessage = "You must play the 2 of Clubs to start the trick.";
                                
				return false;
			} else if (!players[HUMAN_PLAYER].onlyHasHearts()
					&& temp.getSuit() == Card.HEARTS && !heartsStarted) {
				errorMessage = "You cannot start a trick with a Heart until one has been played during a trick.";
                               
				return false;
			} else
				return true;
		} else // player did not start trick
		{
			if (isFirstTurn) {
				if (temp.getSuit() == Card.HEARTS) {
					errorMessage = "You cannot play a Heart in the first trick.";
                                        
					return false;
				} else if (temp.getSuit() != Card.CLUBS
						&& players[HUMAN_PLAYER]
								.hasActiveCardOfSuit(Card.CLUBS)) {
					errorMessage = "You must play a card of the same suit that started the trick.";
					return false;
				} else if (temp.getSuit() == Card.SPADES
						&& temp.getValue() == 12) {
					errorMessage = "You cannot play the Queen of Spades in the first trick.";
					return false;
				} else
					return true;
			} else // it isn't the first trick
			{
				char startingSuit = cardsPlayedInTrick[whoStartedTrick]
						.getSuit();

				if (temp.getSuit() != startingSuit
						&& players[HUMAN_PLAYER]
								.hasActiveCardOfSuit(startingSuit)) {
					errorMessage = "You must play a card of the same suit that started the trick.";
					return false;
				} else
					return true;
			}

		}
	}

	/**
	 * This method returns the filename of the image that represents the card
	 * that a computer player wants to use next
	 * 
	 * @return The filename of the image that represents the card a computer
	 *         player wants to use next
	 */
	public String getComputerMoveCardName() {
		cardsPlayedInTrick[turn] = players[turn]
				.getMove(cardsPlayedInTrick[whoStartedTrick], isFirstTurn,
						heartsStarted);
		if (cardsPlayedInTrick[turn].getSuit() == Card.HEARTS) {
			heartsStarted = true;
		}
		String filename = cardsPlayedInTrick[turn].toString();
		turn = (turn + 1) % NUM_PLAYERS;
		status = players[turn].getName() + "'s Turn";
		return filename;
	}

	/**
	 * This method accepts the index in the player's hand that contains the card
	 * they want to use in the current trick. This method returns the filename
	 * of that card's image.
	 * 
	 * @return The filename of the image of the card the player is using.
	 */
	public String getPlayerMoveFilename(int index) {
		cardsPlayedInTrick[turn] = players[turn].getCard(index);
		cardsPlayedInTrick[turn].setPlayed(true);
		if (cardsPlayedInTrick[turn].getSuit() == Card.HEARTS) {
			heartsStarted = true;
		}
		turn = (turn + 1) % NUM_PLAYERS;
		status = players[turn].getName() + "'s Turn";
		return cardsPlayedInTrick[HUMAN_PLAYER].toString();
	}

	/**
	 * This method sets up the instance variables for the next hand to be
	 * played, and then has the deck shuffled, cards dealt, and hands sorted.
	 */
	public void nextHand() {
		for (int i = 0; i < NUM_PLAYERS; i++) {
			players[i].resetHandPoints();
			players[i].dumpCards();
		}

		turn = 0;
		whoStartedTrick = 0;
		heartsStarted = false;
		isFirstTurn = true;
		tricksPlayed = 0;
		deck.shuffle();
		dealCards();
		sortHands();
		status = players[turn].getName() + "'s Turn";
	}

	/**
	 * This method handles dealing cards to the players for the next hand to be
	 * played. During the dealing process, the player who randomly receives the
	 * 2 of Clubs is set up to take the first turn.
	 */
	public void dealCards() {
		for (int i = 0; i < Player.CARDS_IN_HAND; i++) {
			for (int j = 0; j < NUM_PLAYERS; j++) {
				Card next = deck.nextCard();
				if (next.getSuit() == Card.CLUBS && next.getValue() == 2) {
					// System.out.println("Player with 2C is " +
					// players[j].getName());
					turn = whoStartedTrick = j;
					// REDUNDANT CODE
					// status = players[j].getName() + "'s turn";
				}

				players[j].addCard(next);
			}
		}
	}

	/**
	 * NOT USED This method returns a text based representation of the players
	 * in the game for testing purposes only.
	 * 
	 * @return The text based representation of the players in the game
	 */
	public String toString() {
		String s = "Here we go\n";

		for (int i = 0; i < NUM_PLAYERS; i++) {
			s += players[i] + "\n";
		}

		return s;
	}
	/**
	 * This method is used to determine if the current hand is finished.
	 * The current hand is finished when the number of tricks played in the current hand
	 * is equal to the number of cards a player holds in their hand.
	 * 
	 * @return true if the hand if finished, and false if it is not.
	 */	
	public boolean isHandFinished() { 
		
		if ( tricksPlayed == Player.CARDS_IN_HAND ){
			return true;
		}
		
		return false;
	}
	/**
	 * This method removes the Card objects from the cardsPlayedInTrick array. 
	 * Set each element within the array to null so that the array is ready for 
	 * the start of the next trick.
	 */	
	public void removePlayedCards()  {  
		for ( int i = 0; i < cardsPlayedInTrick.length; i++) {
			cardsPlayedInTrick[i] = null;
		}
	}
	/**
	 * This is the getter method for the errorMessage instance field. 
	 * 
	 * @return a String representing the instance field.
	 */	
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * This is the getter method for the turn instance field.
	 * 
	 * @return an integer representing the instance field.
	 */	
	public int getTurn() {
		return turn;
	}  
	/**
	 * This is the getter method for the whoStartedTrick instance field.
	 * 
	 * @return an integer representing the instance field.
	 */	
	public int getWhoStartedTrick() {
		return whoStartedTrick;
	}
	/**
	 * This method returns an array of Strings that contain the names of the cards
	 * in the human player's hand.
	 * HINT - there is a method in the Player class that does this. 
	 * All you need to do here is call that method for the appropriate player, 
	 * and return the array of Strings that the method in the Player class returns.
	 * 
	 * @return the array of Strings that the method in the Player class returns
	 */	
	public String[] getHumanPlayerCardNames() {
		return players[HUMAN_PLAYER].getCardNames();
	}
	/**
	 * This is the getter method for the status instance field.
	 * 
	 * @return a String representing the instance field.
	 */	
	public String getStatus() {
		return status;
	}	
	/**
	 * This method returns the status of a given player in the game of Hearts.
	 * The parameter "player" is the index within the array of Player objects "players"
	 * for which the GUI wants to know the status.
	 * HINT: Call the toString() method for the appropriate Player and return the String.
	 * 
	 * @return a String representing the players status
	 */	
	public String getPlayerStatus(int player) {
		return players[player].toString();
	
	}
	/**
	 * This method determines whether or not the game is over due to a player having
	 * an overall score equal to or greater than the MAX_SCORE class constant.
	 * If any player has such a score, this method returns true. 
	 * If none of the players has a score that high, this method returns false.
	 * 
	 * @return true if a score is high enough for a win, and false if not.
	 */	
	public boolean isGameOver()  {
		int score = 0;
		for (int i = 0; i < NUM_PLAYERS; i++) {
			if (players[i].getOverallPoints() >= MAX_SCORE) {
				return true;
			}
		}
		return false;

	}	
	/**
	 * This method determines which player has the lowest score in the game and
	 * returns that player's name. If there is a tie, return the name of the
	 * player with the lowest score at the lowest index in the players array.
	 * 
	 * @return String representing the player with the lowest score
	 */	
	public String getWinnerName() {
		String winner = "";
		int lowScore = 0;
		int playerPoints = 0;
		
		for ( int i = 0; i < players.length; i++) {
			playerPoints = players[i].getOverallPoints();
			if ( playerPoints < lowScore || lowScore == 0 ){
				lowScore = playerPoints;
				winner = players[i].getName();
			}
		}
		
		return winner;
	}
	/**
	 * This method puts together a String that represents a list of each player's name,
	 * a colon, and their overall point count. The String is then returned. 
	 * This String will be used in the GUI to display the results of the previous hand.
	 * An example of such a String would be as follows:
	 * 	John: 57
	 * Computer 1: 34
	 * Computer 2: 42
	 * Computer 3: 89
	 * 
	 * @return playerScores a String representing each players name with score
	 */	
	public String getOverallPoints() {
		String playerScores = "";
		
		for ( int i = 0; i < players.length; i++) {
			playerScores += players[i].getName() + ": " + players[i].getOverallPoints() + "\n";
		}
		
		return playerScores;
	}


	
}

