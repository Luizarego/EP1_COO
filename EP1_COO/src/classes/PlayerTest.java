package classes;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void testConstructorOne() {
		Card[] cards = Card.createCards();
	    Player p = new Player("Name", Color.BLUE, cards);
	    assertEquals(Color.valueOf("BLUE"), p.getPieceColor());
	    assertEquals("Name", p.getName());
	    assertArrayEquals(cards, p.getCards());
	}
	
	@Test
	public void testConstructorTwo() {
		Card card1 = new Card("tiger", Color.BLUE, null);
		Card card2 = new Card("goose", Color.BLUE, null);
		
	    Player p = new Player("Name", Color.BLUE, card1, card2);
	    assertEquals(Color.valueOf("BLUE"), p.getPieceColor());
	    assertEquals("Name", p.getName());
	}
	
	@Test
	public void testColor() {
		Card[] cards = Card.createCards();
	    Player redP = new Player("Name", Color.RED, cards);
	    assertEquals(Color.valueOf("RED"), redP.getPieceColor());
	
	    Player blueP = new Player("Name", Color.BLUE, cards);
	    assertEquals(Color.valueOf("BLUE"), blueP.getPieceColor());
	}
	
	@Test
	public void testName() {
		Card[] cards = Card.createCards();
	    Player redP = new Player("Name", Color.RED, cards);
	    assertEquals("Name", redP.getName());
	}
	
	@Test
	public void testCards() {
		Card[] cards = Card.createCards();
	    Player redP = new Player("Name", Color.RED, cards);
	    assertArrayEquals(cards, redP.getCards());
	}
	
	@Test
	public void testGetCard() {
		Card card1 = new Card("tiger", Color.BLUE, null);
		Card card2 = new Card("goose", Color.BLUE, null);
		Player blueP = new Player("Name", Color.BLUE, card1, card2);
		assertEquals(card1, blueP.getCard1());
		assertEquals(card2, blueP.getCard2());
	}
	
	@Test
	public void testSwapValid() {
		Card card1 = new Card("tiger", Color.BLUE, null);
		Card card2 = new Card("goose", Color.BLUE, null);
		Card[] cards = new Card[] {card1, card2};
		Card[] cards2 = new Card[] {card2, card1};
		
		Player p = new Player("Name", Color.BLUE, cards);
		p.swapCard(card1, card2);
		assertEquals(card2, p.getCards()[0]);
		
		Player p2 = new Player("Name", Color.BLUE, cards2);
		p2.swapCard(card1, card2);
		assertEquals(card2, p2.getCards()[1]);
	}
	
	@Test
	public void testSwapInvalid() {
		Card card1 = new Card("tiger", Color.BLUE, null);
		Card card2 = new Card("goose", Color.BLUE, null);
		Card card3 = new Card("rabbit", Color.BLUE, null);
		Card[] cards = new Card[] {card1, card2};
		
		Player p = new Player("Name", Color.BLUE, cards);
		assertThrows(InvalidCardException.class, () -> {
			p.swapCard(card3, card2);
		});
	}
}