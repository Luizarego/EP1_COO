package classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GameImplTest {

	@Test
	public void testConstructorOne(){
		GameImpl game = new GameImpl();
		Card[] cards = game.getCards();
		Card[] redPlayerCards = new Card[] {cards[0], cards[1]};
		Card[] bluePlayerCards = new Card[] {cards[2], cards[3]};
		
		assertEquals(redPlayerCards[0], game.getRedPlayer().getCards()[0]);
		assertEquals(redPlayerCards[1], game.getRedPlayer().getCards()[1]); 
		assertEquals(bluePlayerCards[0], game.getBluePlayer().getCards()[0]);
		assertEquals(bluePlayerCards[1], game.getBluePlayer().getCards()[1]); 
		assertEquals(cards[4], game.getTableCard());
		assertEquals(cards[4].getColor(), game.getFirstToPlay());
		assertEquals(1, game.getTurnControl());
	
		assertEquals("RedPlayer", game.getRedPlayer().getName());
		assertEquals(Color.valueOf("RED"), game.getRedPlayer().getPieceColor());
		assertEquals("BluePlayer", game.getBluePlayer().getName());
		assertEquals(Color.valueOf("BLUE"), game.getBluePlayer().getPieceColor());
		
		for(int i = 0; i<2; i++) {
			assertEquals(redPlayerCards[i], game.getRedPlayer().getCards()[i]);
			assertEquals(bluePlayerCards[i], game.getBluePlayer().getCards()[i]);
		}
		
	}
	
	@Test
	public void testConstructorTwo(){
		String redName = "RedPlayer";
		String blueName = "BluePlayer";
		GameImpl game = new GameImpl(redName, blueName);
		Card[] cards = game.getCards();
		Card[] redPlayerCards = new Card[] {cards[0], cards[1]};
		Card[] bluePlayerCards = new Card[] {cards[2], cards[3]};
		
		assertEquals(redPlayerCards[0], game.getRedPlayer().getCards()[0]);
		assertEquals(redPlayerCards[1], game.getRedPlayer().getCards()[1]); 
		assertEquals(bluePlayerCards[0], game.getBluePlayer().getCards()[0]);
		assertEquals(bluePlayerCards[1], game.getBluePlayer().getCards()[1]); 
		assertEquals(cards[4], game.getTableCard());
		assertEquals(cards[4].getColor(), game.getFirstToPlay());
		assertEquals(1, game.getTurnControl());
	
		assertEquals(redName, game.getRedPlayer().getName());
		assertEquals(Color.valueOf("RED"), game.getRedPlayer().getPieceColor());
		assertEquals(blueName, game.getBluePlayer().getName());
		assertEquals(Color.valueOf("BLUE"), game.getBluePlayer().getPieceColor());
		
		for(int i = 0; i<2; i++) {
			assertEquals(redPlayerCards[i], game.getRedPlayer().getCards()[i]);
			assertEquals(bluePlayerCards[i], game.getBluePlayer().getCards()[i]);
		}
	}
	
	@Test
	public void testConstructorThree(){
		String redName = "RedPlayer";
		String blueName = "BluePlayer";
		Card[] cards = Card.createCards();
		GameImpl game = new GameImpl(redName, blueName, cards);
		Card[] redPlayerCards = new Card[] {cards[0], cards[1]};
		Card[] bluePlayerCards = new Card[] {cards[2], cards[3]};
		
		assertEquals(redPlayerCards[0], game.getRedPlayer().getCards()[0]);
		assertEquals(redPlayerCards[1], game.getRedPlayer().getCards()[1]); 
		assertEquals(bluePlayerCards[0], game.getBluePlayer().getCards()[0]);
		assertEquals(bluePlayerCards[1], game.getBluePlayer().getCards()[1]); 
		assertEquals(cards[4], game.getTableCard());
		assertEquals(cards[4].getColor(), game.getFirstToPlay());
		assertEquals(1, game.getTurnControl());
	
		assertEquals(redName, game.getRedPlayer().getName());
		assertEquals(Color.valueOf("RED"), game.getRedPlayer().getPieceColor());
		assertEquals(blueName, game.getBluePlayer().getName());
		assertEquals(Color.valueOf("BLUE"), game.getBluePlayer().getPieceColor());
		
		for(int i = 0; i<2; i++) {
			assertEquals(redPlayerCards[i], game.getRedPlayer().getCards()[i]);
			assertEquals(bluePlayerCards[i], game.getBluePlayer().getCards()[i]);
		}
	}
	
	@Test
	public void testConstructorThreeInvalidCards(){
  	Card tigerCard = new Card("tiger", Color.valueOf("BLUE"), null);
  	Card rabbitCard = new Card("rabbit", Color.valueOf("BLUE"), null);
  	Card crabCard  = new Card("crab", Color.valueOf("BLUE"), null);
  	Card gooseCard = new Card("goose", Color.valueOf("BLUE"), null);
		String redName = "RedPlayer";
		String blueName = "BluePlayer";
		Card[] cards = new Card[] {tigerCard, rabbitCard, crabCard, gooseCard};
	
		assertThrows(IndexOutOfBoundsException.class, () -> {
			new GameImpl(redName, blueName, cards);
		});
	}

	@Test
	public void testGetFirstToPlay() {
		Card[] cards = Card.createCards();
		GameImpl game = new GameImpl("redP", "blueP", cards);
		assertEquals(cards[4].getColor(), game.getFirstToPlay());
	}
	
	@Test
	public void testGetSpotColor() {
		 Card[] cards = Card.createCards();
		 GameImpl game = new GameImpl("redP", "blueP", cards);
		 Position pos = new Position(0,2);
		 assertEquals(Color.valueOf("BLUE"), game.getSpotColor(pos));
	}
	
	@Test
	public void testGetPieceNull() {
		GameImpl game = new GameImpl("redP", "blueP", Card.createCards());
		Position pos = new Position(2,3);
		assertEquals(null, game.getPiece(pos));
		
		Position pos2 = new Position(0,4);
		assertEquals(Color.valueOf("BLUE"), game.getPiece(pos2).getColor());
		assertEquals(false, game.getPiece(pos2).isMaster());
	}
	
	@Test
	public void testGetTableCard() {
		Card[] cards = Card.createCards();
		GameImpl game = new GameImpl("redP", "blueP", cards);
		assertEquals(cards[4], game.getTableCard());
	}

	@Test
	public void testGetRedPlayer() {
		Card[] cards = Card.createCards();
		GameImpl game = new GameImpl("redP", "blueP", cards);
		Card[] redPlayerCards = new Card[2];
		redPlayerCards[0] = cards[0];
		redPlayerCards[1] = cards[1];
		Player rp = new Player("redP", Color.valueOf("RED"), redPlayerCards);
		assertEquals(rp.getName(), game.getRedPlayer().getName());
		assertEquals(rp.getPieceColor(), game.getRedPlayer().getPieceColor());
	}

	@Test
	public void testGetBluePlayer() {
		Card[] cards = Card.createCards();
		GameImpl game = new GameImpl("redP", "blueP", cards);
		Card[] bluePlayerCards = new Card[2];
		bluePlayerCards[0] = cards[2];
		bluePlayerCards[1] = cards[3];
		Player bp = new Player("blueP", Color.valueOf("BLUE"), bluePlayerCards);
		assertEquals(bp.getName(), game.getBluePlayer().getName());
		assertEquals(bp.getPieceColor(), game.getBluePlayer().getPieceColor());
	}

	@Test
	public void testValidMove() {
		Spot s1 = new Spot(new Piece(Color.valueOf("BLUE"), false), new Position(0,0), Color.valueOf("NONE"));
		Spot s2 = new Spot(new Piece(Color.valueOf("BLUE"), false), new Position(1,0), Color.valueOf("NONE"));
		Spot s3 = new Spot(new Piece(Color.valueOf("RED"),false), new Position(0,0), Color.valueOf("NONE"));
		
		assertFalse(GameImpl.validMove(s1, s2));
		assertTrue(GameImpl.validMove(s1, s3));
	}

  @Test
  public void testMakeMoveIncorrectTurnOrderException() {
      GameImpl game = new GameImpl();
      Position currentPos = new Position(0, 0);
      Position cardMove = new Position(1, 0);
      game.setFirstToPlay(Color.RED);
	    Card card = Card.createCards()[1];
      
     assertThrows(IncorrectTurnOrderException.class, () -> {
  	  game.makeMove(card, cardMove, currentPos); 
     });

  }
  
	@Test
	public void testMakeMoveInvalidCard() {
	    GameImpl game = new GameImpl();
	    Position currentPos = new Position(0, 0);
	    Position cardMove = new Position(1, 0);
	    game.setFirstToPlay(Color.BLUE);
	    Card card = Card.createCards()[1];
	
	    assertThrows(InvalidCardException.class, () -> {
	    	  game.makeMove(card, cardMove, currentPos); 
	      });
	}
  @Test
  public void testMakeMoveIllegalMovementExceptionIndexOutOfBounds() {
      GameImpl game = new GameImpl();
      Position currentPos = new Position(0, 0);
      Position cardMove = new Position(5, 5);
      game.setFirstToPlay(Color.BLUE);
	    Card card = Card.createCards()[1];

      assertThrows(IllegalMovementException.class, () ->
              game.makeMove(card, cardMove, currentPos));
  }

  @Test
  public void testMakeMoveIllegalMovementExceptionPositionOccupiedByAlly() {
      GameImpl game = new GameImpl();
      Position currentPos = new Position(4, 2);
      Position cardMove = new Position(-4, 1);
      game.setFirstToPlay(Color.RED);
	    Card card = Card.createCards()[1];
      Piece p = new Piece(Color.RED, false);

      game.getBoard()[0][3].occupySpot(p);

      assertThrows(IllegalMovementException.class, () ->
              game.makeMove(card, cardMove, currentPos));
  }

  @Test
  public void testMakeMoveInvalidPieceExceptionPieceOutOfBounds() {
      GameImpl game = new GameImpl();
      Position currentPos = new Position(2, 2);
      Position cardMove = new Position(1, 1);
      Card card = game.getRedPlayer().getCards()[0];

      assertThrows(InvalidPieceException.class, () ->
              game.makeMove(card, cardMove, currentPos));
  }
  
  @Test
  public void testMakeMoveValid() {
  	Card c1n = new Card("dragon", null, null);
      Card c2n = new Card("tiger", null, null);
      Card c3n = new Card("crab", null, null);
      Card c4n = new Card("goose", null, null);
      Card c5n = new Card("rooster", null, null);
  	Card a = new Card("dragon", Color.valueOf("RED"), Card.getCardPosition(c1n));
      Card b = new Card("tiger", Color.valueOf("BLUE"), Card.getCardPosition(c2n));
      Card c = new Card("crab", Color.valueOf("BLUE"), Card.getCardPosition(c3n));
      Card d = new Card("goose", Color.valueOf("BLUE"), Card.getCardPosition(c4n));
      Card e = new Card("rooster", Color.valueOf("RED"), Card.getCardPosition(c5n));

      Card[] cards = {a, b, c, d, e};

      GameImpl game = new GameImpl("RedPlayer", "BluePlayer", cards);
      Card[] redCards = game.getRedPlayer().getCards();
      Card[] blueCards = game.getBluePlayer().getCards();
  	
      game.makeMove(game.getRedPlayer().getCards()[1], Card.getCardPosition(game.getRedPlayer().getCards()[1])[0], new Position(4, 2));
      game.makeMove(blueCards[1], Card.getCardPosition(blueCards[1])[3], new Position(0, 2)); 
      game.makeMove(redCards[0], Card.getCardPosition(redCards[0])[0], new Position(4, 3));
      
      Card[] cards1 = {c, a, b, d, e};
      GameImpl game1 = new GameImpl("RedPlayer", "BluePlayer", cards1);
      game1.setFirstToPlay(Color.BLUE);
      game1.makeMove(game1.getBluePlayer().getCards()[0], Card.getCardPosition(game1.getBluePlayer().getCards()[0])[1], new Position(0, 2));  
  }
  
	@Test
	public void testCheckVictoryRedTemple() {
		GameImpl game = new GameImpl();
		Spot s  = game.getBoard()[0][2];
		Color r = Color.valueOf("RED");
		s.occupySpot(game.getRedMaster());
		assertTrue(game.checkVictory(r));
	}
	
	@Test
	public void testCheckVictoryBlueTemple() {
		GameImpl game = new GameImpl();
		Piece blueMaster = game.getBlueMaster();
		Position p = new Position(4,2);
		game.getBoard()[4][2].occupySpot(blueMaster);
		
		assertEquals(game.getPiece(p), blueMaster);
		assertTrue(game.checkVictory(Color.BLUE));
	}
	
	@Test
	public void testCheckNotVictoryOccupyTemple() {
		GameImpl game = new GameImpl();
		Spot s  = game.getBoard()[1][1];
		Piece p = new Piece(Color.BLUE, false);
		s.occupySpot(p);
		assertFalse(game.checkVictory(Color.BLUE));
		assertFalse(game.checkVictory(Color.RED));
	}
	
	@Test
	public void testCheckNotVictoryRedTemple() {
		GameImpl game = new GameImpl();
		Spot s  = game.getBoard()[0][2];
		Spot s1  = game.getBoard()[1][1];
		Piece p = new Piece(Color.RED, false);
		s1.occupySpot(game.getBlueMaster());
		s.occupySpot(p);
		assertFalse(game.checkVictory(Color.BLUE));
		assertFalse(game.checkVictory(Color.RED));
	}
	
	@Test
	public void testCheckNotVictoryBlueTemple() {
		GameImpl game = new GameImpl();
		Piece blueMaster = game.getBlueMaster();
		Position p = new Position(4,2);
		game.getBoard()[4][2].occupySpot(blueMaster);
		
		assertEquals(game.getPiece(p), blueMaster);
		assertTrue(game.checkVictory(Color.BLUE));
	}
	
	@Test
	public void testCheckVictoryCapture() {
		GameImpl game = new GameImpl();
		
		int i = 0;
		int j = 2;
		assertNotNull(game.getBoard()[i][j].getPiece());
		assertEquals(game.getBoard()[i][j].getPiece().getColor(), Color.valueOf("BLUE"));
		assertTrue(game.getBoard()[i][j].getPiece().isMaster());
		assertFalse(game.checkVictory(Color.RED));

		int m = 4;
		int n = 2;
		assertNotNull(game.getBoard()[m][n].getPiece());
		assertEquals(game.getBoard()[m][n].getPiece().getColor(), Color.valueOf("RED"));
		assertTrue(game.getBoard()[m][n].getPiece().isMaster());
		assertFalse(game.checkVictory(Color.BLUE));
	}
	
}