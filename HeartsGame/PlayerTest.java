public class PlayerTest {
	
	private Player testPlayer;
	private Card c1;
	private Card c2;
	
	private void setUp() {
		testPlayer = new Player("Human", 1);
		c1 = new Card(3, 'c');
		c2 = new Card (5, 'h');
	}
	
	public void testAddCard() {
		setUp();
		
		//Test that there are no cards in hand
		Card firstCard = testPlayer.getCard(0);
		System.out.printf("%-40s", "testAddCard - empty");
		System.out.printf("%-15s", "null");
		System.out.printf("%-20s\n", firstCard);
		
		//Add a card to the hand
		testPlayer.addCard(c1);
		firstCard = testPlayer.getCard(0);
		System.out.printf("%-40s", "testAddCard - one card");
		System.out.printf("%-15s", "c3");
		System.out.printf("%-20s\n", firstCard);
		
		//TODO write test case here
		testPlayer.addCard(c2);
		Card nextCard = testPlayer.getCard(1);
		System.out.printf("%-40s", "testAddCard - one card");
		System.out.printf("%-15s", "h5");
		System.out.printf("%-20s\n", nextCard);
	}
	
	public void testAddToHandPoints() {
		setUp();
		
		//Test that a new player starts at 0 hand points
		System.out.printf("%-40s", "testAddToHandPoints - new player");
		System.out.printf("%-15s", "0");
		System.out.printf("%-20s\n", testPlayer.getHandPoints());
		
		//TODO write test case here- tests if adding 8 points shows up when getting hand points
		testPlayer.addToHandPoints (8);
		System.out.printf("%-40s", "testAddToHandPoints - player w/ 8 pts");
		System.out.printf("%-15s", "8");
		System.out.printf("%-20s\n", testPlayer.getHandPoints());
	}

	
	public void testResetHandPoints() {
		setUp();
	
		//Check that points are reset even if there are no points
		testPlayer.resetHandPoints();
		System.out.printf("%-40s", "testResetHandPoints - new player");
		System.out.printf("%-15s", "0");
		System.out.printf("%-20s\n", testPlayer.getHandPoints());
		
		//TODO write test case here - does it reset if there are points in hand
		testPlayer.addToHandPoints (8);
		testPlayer.resetHandPoints();
		System.out.printf("%-40s", "testResetHandPoints - player w/ 8 pts");
		System.out.printf("%-15s", "0");
		System.out.printf("%-20s\n", testPlayer.getHandPoints());		
	}
	
	public void testToString() {
		setUp();
		
		//TODO write test case here- tests for test player string with no points
		System.out.printf("%-40s", "testToString - Human w/ no points");
		System.out.printf("%-15s", "Human 0");
		System.out.printf("%-20s\n", testPlayer.toString());
		
		testPlayer.addToHandPoints (8);
		System.out.printf("%-40s", "testToString - Human w/ 8 points");
		System.out.printf("%-15s", "Human 8");
		System.out.printf("%-20s\n", testPlayer.toString());
	}
	
	public void testGetCard() {
		setUp();
		
		//Test that a card in the hand is null when the player is first created
		System.out.printf("%-40s", "testGetCard - no cards in hand");
		System.out.printf("%-15s", "null");
		System.out.printf("%-20s\n", testPlayer.getCard(7));
		
		//TODO write test case here - put the test cards c1 and c2 in hand
		testPlayer.addCard(c1);
		System.out.printf("%-40s", "testGetCard - card 1 in hand");
		System.out.printf("%-15s", "c3");
		System.out.printf("%-20s\n", testPlayer.getCard(0));
		testPlayer.addCard(c2);
		System.out.printf("%-40s", "testGetCard - card 2 in hand");
		System.out.printf("%-15s", "h5");
		System.out.printf("%-20s\n", testPlayer.getCard(1));
		
	}
	
	public void testHasActiveCardOfSuit() {
		setUp();
		
		//With no cards, test that the card is active for the suit
		System.out.printf("%-40s", "testHasActiveCardOfSuit - clubs");
		System.out.printf("%-15s", "false");
		System.out.printf("%-20s\n", testPlayer.hasActiveCardOfSuit('c'));
		
		//Add a card and test that the card is active for the suit
		testPlayer.addCard(c1);
		System.out.printf("%-40s", "testHasActiveCardOfSuit - clubs");
		System.out.printf("%-15s", "true");
		System.out.printf("%-20s\n", testPlayer.hasActiveCardOfSuit('c'));
		
		//TODO write test case here - tests if has suit when it has a club, no spades
		System.out.printf("%-40s", "testHasActiveCardOfSuit - spades");
		System.out.printf("%-15s", "false");
		System.out.printf("%-20s\n", testPlayer.hasActiveCardOfSuit('s'));

		//Add a heart and test that the card is active for the suit
		testPlayer.addCard(c2);
		System.out.printf("%-40s", "testHasActiveCardOfSuit - hearts");
		System.out.printf("%-15s", "true");
		System.out.printf("%-20s\n", testPlayer.hasActiveCardOfSuit('h'));
		
	}
	
	public void testOnlyHasHearts() {
		setUp();
		
		//With no cards,  test if the player only has hearts
		System.out.printf("%-40s", "testOnlyHasHearts - has no cards");
		System.out.printf("%-15s", "true");
		System.out.printf("%-20s\n", testPlayer.onlyHasHearts());
		
		//Add a card and test if the player only has hearts
		testPlayer.addCard(c2);
		System.out.printf("%-40s", "testOnlyHasHearts - has only hearts");
		System.out.printf("%-15s", "true");
		System.out.printf("%-20s\n", testPlayer.onlyHasHearts());
		
		//Add a card and test if the player has a heart and a club
		testPlayer.addCard(c1);
		System.out.printf("%-40s", "testOnlyHasHearts - has clubs too");
		System.out.printf("%-15s", "false");
		System.out.printf("%-20s\n", testPlayer.onlyHasHearts());
		

		
	}
	
	public void testGetCardNames() {
		setUp();
		
		//TODO write test case here
		testPlayer.addCard(c1);
		testPlayer.addCard(c2);
		String [] testString = testPlayer.getCardNames();
		System.out.printf("%-40s", "testGetCardNames - card name list ");
		System.out.printf("%-15s", "c3, h5");
		System.out.printf("%-20s", testString[0] + ", " + testString[1]);
	}
	
	public static void main(String [] args) {
		PlayerTest test = new PlayerTest();
		System.out.printf("%-40s%-15s%-20s\n", "Test", "Expected", "Actual");
		
		test.testAddCard();
		test.testAddToHandPoints();
		test.testResetHandPoints();
		test.testToString();
		test.testGetCard();
		test.testHasActiveCardOfSuit();
		test.testOnlyHasHearts();
		test.testGetCardNames();
	}

}

