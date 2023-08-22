package classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class SpotTest {
	@Test
	public void testConstructorOne() {
		Position p = new Position(0,0);
		Piece pc = new Piece(Color.BLUE, false);
		Spot s = new Spot(pc, p, Color.BLUE);
		assertEquals(p, s.getPosition());
		assertEquals(Color.BLUE, s.getColor());
		assertEquals(pc, s.getPiece());
	}
	
	@Test
	public void testConstructorTwo() {
		Position p = new Position(0,0);
		Piece pc = new Piece(Color.BLUE, false);
		Spot s = new Spot(pc, p);
		assertEquals(p, s.getPosition());
		assertEquals(pc, s.getPiece());
	}
	
	@Test
	public void testConstructorThree() {
		Position p = new Position(0,0);
		Spot s = new Spot(p);
		assertEquals(p, s.getPosition());
	}

	@Test
	public void testColor() {
		Spot s = new Spot(new Piece(Color.BLUE, false), new Position(0,0), Color.BLUE);
		assertEquals(Color.BLUE, s.getColor());
	}
	
	@Test
	public void testPosition() {
		Position p = new Position(0,0);
		Spot s1 = new Spot(new Piece(Color.BLUE, false), p, Color.BLUE);
		Spot s2 = new Spot(new Piece(Color.BLUE, false), p);
		Spot s3 = new Spot(p);
		assertEquals(p, s1.getPosition());
		assertEquals(p, s2.getPosition());
		assertEquals(p, s3.getPosition());
	}
	
	@Test
	public void testPiece() {
		Piece pc = new Piece(Color.BLUE, false);
		Spot s1 = new Spot(pc, new Position(0,0), Color.BLUE);
		Spot s2 = new Spot(pc, new Position(0,0));
		assertEquals(pc, s1.getPiece());
		assertEquals(pc, s2.getPiece());
	}
	
	@Test
	public void testOccupySpotInvalid() {
		Piece oldPiece = new Piece(Color.BLUE, false);
		Piece newPiece = new Piece(Color.BLUE, false);
		Spot spot = new Spot (oldPiece, new Position(0,0), Color.BLUE);
	
		//assertEquals(newPiece.getColor(), spot.getColor());
		IllegalMovementException e = assertThrows(IllegalMovementException.class, () -> {
            spot.occupySpot(newPiece);
        });
        assertEquals("ERROR: The spot is already occupied by a piece of the same color", e.getMessage());

        // Ensure the spot remains unchanged
        assertEquals(oldPiece, spot.getPiece());
        assertEquals(oldPiece.getColor(), spot.getColor());
	}
	
	@Test
	public void testOccupySpotValid() {
		Position p = new Position(0,0);
		Piece oldPiece = new Piece(Color.BLUE, false);
		Piece newPiece = new Piece(Color.RED, false);
		Spot spot = new Spot (oldPiece, p, oldPiece.getColor());
		
		assertNotEquals(newPiece.getColor(), spot.getColor());
        spot.occupySpot(newPiece);
        assertEquals(newPiece, spot.getPiece());
	}
	
	@Test
	public void testOccupySpotNull() {
		Position p = new Position(0,0);
		Piece newPiece = new Piece(Color.RED, false);
		Spot spot = new Spot (p);
        spot.occupySpot(newPiece);
		assertNotEquals(newPiece.getColor(), spot.getColor());
        assertEquals(newPiece, spot.getPiece());
	}
	
	@Test
	public void testReleaseSpotNull() {
		Spot s = new Spot(new Position(0,0));
		s.releaseSpot();
		assertNull(s.getPiece());
	}
	
	@Test
	public void testReleaseSpotNotNull() {
		Piece p = new Piece(Color.BLUE, false);
		Spot s = new Spot(p, new Position(0,0));
		assertNotNull(p);
		s.releaseSpot();
		assertEquals(null, s.getPiece());
		
		Piece p2 = null;
		Spot s2 = new Spot(p, new Position(0,0));
		s2.releaseSpot();
		assertNull(p2);
	}
}