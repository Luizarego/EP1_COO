package classes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class CardTest {
	@Test
	public void testConstructor() {
		Card card = new Card("tiger", Color.valueOf("BLUE"), null);
		assertEquals("tiger", card.getName());
		assertEquals(Color.valueOf("BLUE"), card.getColor());
		assertArrayEquals(null, card.getPositions());
	}

	@Test
	public void testColor() {
		Card blueCard = new Card("tiger", Color.valueOf("BLUE"), null);
	    assertEquals(Color.valueOf("BLUE"), blueCard.getColor());
	
	    Card redCard = new Card("tiger", Color.valueOf("RED"), null);
	    assertEquals(Color.valueOf("RED"), redCard.getColor());
	}
	
	@Test
	public void testName() {
		Card card = new Card("tiger", Color.BLUE, null);
	    assertEquals("tiger", card.getName());
	}
	
	@Test
	public void testPosition() {
		Card card = new Card("tiger", Color.BLUE, null);
	    assertArrayEquals(null, card.getPositions());
	}
	
	@Test
	public void testCreateCards(){
		Card[] cards = Card.createCards();
		assertNotNull(cards);
	    assertEquals(5, cards.length);
	    int i = 0;
	    while(i<4) {
	    	assertNotEquals(cards[i], cards[i+1]);
	    	i++;
	    }
	}
	
	@Test 
	public void testGetCardPosition() {
		Position[] tigerPositions = {new Position(-2, 0), new Position(1, 0)};
		Position[] rabbitPositions = {new Position(1, -1), new Position(-1, 1), new Position(0, 2)};
		Position[] crabPositions = {new Position(0, -2), new Position(0, 2), new Position(-1, 0)};
		Position[] goosePositions = {new Position(-1, -1), new Position(0, -1), new Position(0, 1), new Position(1, 1)};
		Position[] dragonPositions = {new Position(-1, -2), new Position(1, -1), new Position(1, 1), new Position(-1, 2)};
		Position[] frogPositions = {new Position(0, -2), new Position(-1, -1), new Position(1, 1)};
		Position[] elephantPositions = {new Position(-1, -1), new Position(0, -1), new Position(0, 1), new Position(-1, 1)};
		Position[] roosterPositions = {new Position(1, -1), new Position(0, -1), new Position(0, 1), new Position(-1, 1)};
    	Card tigerCard = new Card("tiger", Color.valueOf("BLUE"), tigerPositions);
    	Card rabbitCard = new Card("rabbit", Color.valueOf("BLUE"), rabbitPositions);
    	Card crabCard  = new Card("crab", Color.valueOf("BLUE"), crabPositions);
    	Card gooseCard = new Card("goose", Color.valueOf("BLUE"), goosePositions);
    	Card dragonCard = new Card("dragon", Color.valueOf("RED"), dragonPositions);
    	Card frogCard = new Card("frog", Color.valueOf("RED"), frogPositions);
    	Card elephantCard = new Card("elephant", Color.valueOf("RED"), elephantPositions);
    	Card roosterCard = new Card("rooster", Color.valueOf("RED"), roosterPositions);
    	for(int i = 0; i<2; i++) {
    		assertEquals(tigerPositions[i].getRow(), Card.getCardPosition(tigerCard)[i].getRow());
    		assertEquals(tigerPositions[i].getCol(), Card.getCardPosition(tigerCard)[i].getCol());
    	}
    	for(int i = 0; i<3; i++) {
    		assertEquals(rabbitPositions[i].getRow(), Card.getCardPosition(rabbitCard)[i].getRow());
        	assertEquals(crabPositions[i].getRow(), Card.getCardPosition(crabCard)[i].getRow());
        	assertEquals(frogPositions[i].getRow(), Card.getCardPosition(frogCard)[i].getRow());
        	
        	assertEquals(rabbitPositions[i].getCol(), Card.getCardPosition(rabbitCard)[i].getCol());
        	assertEquals(crabPositions[i].getCol(), Card.getCardPosition(crabCard)[i].getCol());
        	assertEquals(frogPositions[i].getCol(), Card.getCardPosition(frogCard)[i].getCol());
    	}
    	
    	for(int i = 0; i<4; i++) {
	    	assertEquals(goosePositions[i].getRow(), Card.getCardPosition(gooseCard)[i].getRow());
	    	assertEquals(dragonPositions[i].getRow(), Card.getCardPosition(dragonCard)[i].getRow());
	    	assertEquals(elephantPositions[i].getRow(), Card.getCardPosition(elephantCard)[i].getRow());
	    	assertEquals(roosterPositions[i].getRow(), Card.getCardPosition(roosterCard)[i].getRow());
	    	
	    	assertEquals(goosePositions[i].getCol(), Card.getCardPosition(gooseCard)[i].getCol());
	    	assertEquals(dragonPositions[i].getCol(), Card.getCardPosition(dragonCard)[i].getCol());
	    	assertEquals(elephantPositions[i].getCol(), Card.getCardPosition(elephantCard)[i].getCol());
	    	assertEquals(roosterPositions[i].getCol(), Card.getCardPosition(roosterCard)[i].getCol());
    	}
    	
    	assertNull(Card.getCardPosition(new Card(null, Color.NONE, null)));
	}
}